package com.icarus.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.LocationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.LocationEntity;

import androidx.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import c.anurag.database.IcarusDatabaseHelper;
import c.anurag.network.RetrofitApiServiceFactory;
import c.anurag.network.apiservice.LoginApiCall;
import c.anurag.network.beans.location.Locations;
import c.anurag.network.beans.location.LocationsResponse;
import c.anurag.network.beans.user.locationdepartments.UserLocationDepartments;
import c.anurag.network.beans.user.locationdepartments.UserLocationDepartmentsResponse;
import c.anurag.network.callback.AbstractViewCallback;

public class LocationRepository {

    private Context context;
    private LocationDao mLocationDao;

    public LocationRepository(Context context) {
        this.context = context;

        AppDatabase db = AppDatabase.getInstance(context);
        mLocationDao = db.locationDao();
    }

    public LocationEntity getLocation(Integer locationId) {
        return mLocationDao.get(locationId);
    }

    public MutableLiveData<LinkedHashMap<Integer, LocationEntity>> getLocationList() {
        final MutableLiveData<LinkedHashMap<Integer, LocationEntity>> liveDataLocation = new MutableLiveData<>();

        boolean isClientExist = IcarusDatabaseHelper.checkDatabaseExist(context, BaseApplication.getPreferenceManager().getClientUuid());
        if (!TextUtils.isEmpty(BaseApplication.getPreferenceManager().getLoginUserLocations())) {
            List<LocationEntity> item = new Gson().fromJson(BaseApplication.getPreferenceManager().getLoginUserLocations(), new TypeToken<List<LocationEntity>>() {
            }.getType());
            LinkedHashMap<Integer, LocationEntity> locationItems = new LinkedHashMap<>();
            for (LocationEntity locationEntity : item) {
                locationItems.put(locationEntity.getId(), locationEntity);
            }
            liveDataLocation.setValue(locationItems);
        } else if (isClientExist) {
            new LoadLocations(mLocationDao, new CallBack() {
                @Override
                public void onComplete(List<LocationEntity> list) {
                    LinkedHashMap<Integer, LocationEntity> locationItems = new LinkedHashMap<>();
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            if (!locationItems.containsKey(list.get(i).getId()))
                                locationItems.put(list.get(i).getId(), list.get(i));
                        }
                        liveDataLocation.setValue(locationItems);
                    }
                }
            }).execute();
        } else {
            if (BaseApplication.getPreferenceManager().getIsAdmin()) {
                final String base64EncodedCredentials = BaseApplication.getPreferenceManager().getUserCredintials();
                HashMap<String, String> mHeaders = new HashMap<>();
                mHeaders.put(Constants.HEADER_AUTHORIZATION, base64EncodedCredentials);
                LoginApiCall loginApiCall = new LoginApiCall(context, new RetrofitApiServiceFactory(), mHeaders);

                loginApiCall.getLocation(new AbstractViewCallback<LocationsResponse>(context) {
                    @Override
                    protected void onSuccess(LocationsResponse locationsResponse) {
                        if (locationsResponse != null) {
                            LinkedHashMap<Integer, LocationEntity> locationItems = new LinkedHashMap<>();
                            for (Locations locations : locationsResponse.getData()) {
                                LocationEntity item = new LocationEntity(locations.getId(), locations.getName(), locations.getTimezone(), null);
                                if (!locationItems.containsKey(item.getId()))
                                    locationItems.put(locations.getId(), item);
                            }
                            liveDataLocation.setValue(locationItems);
                        }

                    }

                });
            } else {
                final String base64EncodedCredentials = BaseApplication.getPreferenceManager().getUserCredintials();
                HashMap<String, String> mHeaders = new HashMap<>();
                mHeaders.put(Constants.HEADER_AUTHORIZATION, base64EncodedCredentials);
                LoginApiCall loginApiCall = new LoginApiCall(context, new RetrofitApiServiceFactory(), mHeaders);

                loginApiCall.getUserLocationDepartment(new AbstractViewCallback<UserLocationDepartmentsResponse>(context) {
                    @Override
                    protected void onSuccess(UserLocationDepartmentsResponse userLocationDepartmentsResponse) {
                        if (userLocationDepartmentsResponse != null && userLocationDepartmentsResponse.getData() != null && userLocationDepartmentsResponse.getData().size() > 0) {
                            LinkedHashMap<Integer, LocationEntity> locationItems = new LinkedHashMap<>();
                            for (UserLocationDepartments locations : userLocationDepartmentsResponse.getData()) {
                                if (BaseApplication.getPreferenceManager().getUserId() == locations.getUserId()) {
                                    LocationEntity item = new LocationEntity(locations.getLocation().getId(), locations.getLocation().getName(), locations.getLocation().getTimezone(), null);
                                    if (!locationItems.containsKey(locations.getLocation().getId()))
                                        locationItems.put(locations.getLocation().getId(), item);
                                }
                            }
                            liveDataLocation.setValue(locationItems);
                        } else
                            liveDataLocation.setValue(null);
                    }
                });
            }

        }
        return liveDataLocation;
    }

    public interface CallBack {
        public void onComplete(List<LocationEntity> listLiveData);
    }

    public class LoadLocations extends AsyncTask<Void, List<LocationEntity>, List<LocationEntity>> {
        LocationDao locationDao;
        CallBack callBack;

        LoadLocations(LocationDao locationDao, CallBack callBack) {
            this.locationDao = locationDao;
            this.callBack = callBack;
        }

        @Override
        protected List<LocationEntity> doInBackground(Void... voids) {
            if (BaseApplication.getPreferenceManager().getIsAdmin())
                return locationDao.getLocations();
            else
                return locationDao.getLocations(BaseApplication.getPreferenceManager().getUserId());
        }

        @Override
        protected void onPostExecute(List<LocationEntity> listLiveData) {
            super.onPostExecute(listLiveData);
            callBack.onComplete(listLiveData);
        }
    }

}
