package com.icarus.navigators;

import com.icarus.entities.LocationEntity;

import java.util.List;

/**
 * Created by Monika Rana on 12/27/2018.
 */

public interface ChangeLocationNavigator {

    void onSaveLocationError(String errorMsg);

    void onSaveLocationSuccess();

    void onGetLocationSuccess(List<LocationEntity> locationList);

    void internetNotConnected();
}
