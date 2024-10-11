package com.icarus.base;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.databinding.ObservableBoolean;
import androidx.annotation.NonNull;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class BaseViewModel <N> extends AndroidViewModel {


    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    private N mNavigator;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    @NonNull
    @Override
    public <T extends Application> T getApplication() {
        return super.getApplication();
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }

}

