package com.icarus.synchronization.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.LocationDepartmentsEntity;
import com.icarus.entities.LocationEntity;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.LocationsApi;
import com.icarus.synchronization.syncmodels.RetrieveLocations;

import java.util.ArrayList;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class LocationWorker extends CommonWorker {
    private final static String EMBED = "location_departments";
    private final Context mContext;

    public LocationWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        int pageCount = getInputData().getInt(Parameters.PAGE_COUNT, 1);

        for (int i = 0; i < pageCount; i++) {
            hitApi(i + 1);
        }

        return Result.success();
    }

    private void hitApi(Integer pageNo) {
        RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                .create(LocationsApi.class)
                .locationIndex(
                        Constants.HEADER_ACCEPT,
                        Parameters.PAGE_SIZE,
                        pageNo,
                        BaseApplication.getPreferenceManager().getLastActivityAfter(),
                        BaseApplication.getPreferenceManager().getLastActivityBefore(),
                        EMBED,
                        BaseApplication.getPreferenceManager().getRevisionNumber()
                )
                .subscribe(new AbstractNetworkObservable<RetrieveLocations>() {
                    @Override
                    public void success(RetrieveLocations retrievedLocations) {
                        if (retrievedLocations == null) {
                            return;
                        }

                        List<RetrieveLocations.Datum> locationList = retrievedLocations.getData();

                        if (locationList == null) {
                            return;
                        }

                        List<LocationEntity> locationEntities = new ArrayList<>();
                        List<LocationDepartmentsEntity> locationDepartmentsEntities = new ArrayList<>();

                        // Save the data in database
                        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                        GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

                        for (RetrieveLocations.Datum location : locationList) {
                            LocationEntity newLocationEntity = ModelMapper.mapLocationEntity(location);
                            locationEntities.add(newLocationEntity);

                            locationDepartmentsEntities.addAll(mapLocationDepartments(location.getLocationDepartments()));
                        }

                        getSynchronizationDao.insertLocationsWithAssociatedData(
                                locationEntities,
                                locationDepartmentsEntities
                        );

                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.d(Parameters.TAG, error.getMessage());
                        WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
                    }
                });
    }


    private List<LocationDepartmentsEntity> mapLocationDepartments(
            List<RetrieveLocations.LocationDepartment> locationDepartments
    ) {
        List<LocationDepartmentsEntity> locationDepartmentsEntities = new ArrayList<>();

        if (locationDepartments == null) {
            return locationDepartmentsEntities;
        }

        for (RetrieveLocations.LocationDepartment locationDepartment : locationDepartments) {
            LocationDepartmentsEntity locationDepartmentEntity = ModelMapper.mapLocationDepartmentEntity(locationDepartment);
            locationDepartmentsEntities.add(locationDepartmentEntity);
        }

        return locationDepartmentsEntities;
    }

}
