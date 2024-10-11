package com.icarus.viewmodels;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;
import android.text.TextUtils;

import com.icarus.base.BaseApplication;
import com.icarus.base.BaseViewModel;
import com.icarus.entities.LocationEntity;
import com.icarus.navigators.ChangeLocationNavigator;
import com.icarus.repositories.LocationRepository;

import java.util.LinkedHashMap;

import c.anurag.network.beans.user.locationdepartments.UserLocationDepartmentsResponse;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class ChangeLocationViewModel extends BaseViewModel<ChangeLocationNavigator> {
    private LiveData<LinkedHashMap<Integer, LocationEntity>> locationsLiveData;
    private LiveData<UserLocationDepartmentsResponse> userLocationDepartmentsResponseLiveData;
    private boolean isBackButtonToBeShown;

    public ChangeLocationViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchLocation() {
        setIsLoading(true);
        LocationRepository locationRepository = new LocationRepository(getApplication());
        locationsLiveData = locationRepository.getLocationList();
        /*if (Utilities.isOnline(getApplication())) {



            if (BaseApplication.getPreferenceManager().getIsAdmin()) {
                locationsResponseLiveData = locationRepository.getLocations();
            } else {
                userLocationDepartmentsResponseLiveData = locationRepository.getUserLocationDepartment();
            }
        } else {
            getNavigator().internetNotConnected();
        }*/


    }

    public LiveData<LinkedHashMap<Integer, LocationEntity>> observeLocationsResponse() {
        return locationsLiveData;
    }

    public boolean validateLocation(int userLocationId, LinkedHashMap<Integer, LocationEntity> locationItemsLinkedHashMap) {
        if (locationItemsLinkedHashMap != null)
            for (int key : locationItemsLinkedHashMap.keySet()) {
                LocationEntity locationItem = locationItemsLinkedHashMap.get(key);
                if (locationItem!=null && locationItem.getId() == userLocationId)
                    return true;
            }
        return false;
    }

    public boolean isBackButtonToBeShown() {
        return isBackButtonToBeShown;
    }

    public void setBackButtonToBeShown() {
        isBackButtonToBeShown = !TextUtils.isEmpty(BaseApplication.getPreferenceManager().getUserLocationName());
    }
}
