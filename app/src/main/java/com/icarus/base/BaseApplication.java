package com.icarus.base;

import com.facebook.stetho.Stetho;
import com.icarus.BuildConfig;
import com.icarus.util.ImageLoader;
import com.icarus.util.Storage;

import android.content.Context;

import c.anurag.common.preference.PreferenceManager;
import c.anurag.database.LoginDatabaseHelper;
import c.anurag.database.navigation.IntentHelperAbstract;
import c.anurag.database.util.CommonFunctions;
import c.anurag.network.RetrofitApiServiceFactory;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class BaseApplication extends c.anurag.database.application.BaseApplication {
    private static Context context;
    private static CommonFunctions commonFunctions;
    private static ImageLoader imageLoader;

    public static Context getContext() {
        return context;
    }
    public static CommonFunctions getCommonFunctions() {
        return commonFunctions;
    }

    public static ImageLoader getImageLoader() {
        return imageLoader;
    }

    @Override
    public IntentHelperAbstract getIntentHelper() {
        return null;
    }

    private static PreferenceManager preferenceManager;
    private static LoginDatabaseHelper loginDatabaseHelper;
    private static RetrofitApiServiceFactory apiServiceFactory;
    private static Storage storage;

    public static Storage getStorage() {
        return storage;
    }

    public static PreferenceManager getPreferenceManager() {
        return preferenceManager;
    }

    public static LoginDatabaseHelper getLoginDatabaseHelper() {
        return loginDatabaseHelper;
    }

    public static RetrofitApiServiceFactory getApiServiceFactory() {
        return apiServiceFactory;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
            Stetho.initializeWithDefaults(this);
        context = this;
        commonFunctions = new CommonFunctions(this);
        apiServiceFactory = new RetrofitApiServiceFactory();
        preferenceManager = new PreferenceManager(this);
        loginDatabaseHelper = LoginDatabaseHelper.getInstance(this);
        imageLoader = new ImageLoader(this);
        String baseUrl = BuildConfig.SERVERPATH;
        preferenceManager.setServerPath(baseUrl);
        preferenceManager.setResourcesDownloadPath(baseUrl + "/resources/%1$s/download.json");
        preferenceManager.setAssignedStepResourcesDownloadPath(baseUrl + "/assigned_step_resources/%1$s/download.json");
        preferenceManager.setChecklistLogoDownloadPath(baseUrl + "/checklist_logos/%1$s/download.json");
        preferenceManager.setClientLogoDownloadPath(baseUrl + "/client_logos/%1$s/download.json");
        preferenceManager.setPpesDownloadPath(baseUrl + "/ppes/%1$s/download.json");
        preferenceManager.setHazardsDownloadPath(baseUrl + "/hazards/%1$s/download.json");
        preferenceManager.setWorkordersDownloadPath(baseUrl + "/workorder_attachments/%1$s/download.json");

        preferenceManager.setWorkordersUploadPath(baseUrl + "/workorder_attachments/%1$s/upload.json");
        preferenceManager.setUserSuggestionsUploadPath(baseUrl + "/user_suggestion_attachments/%1$s/upload.json");
        preferenceManager.setAssignedStepUploadPath(baseUrl + "/assigned_step_resources/%1$s/upload.json");
        storage = new Storage(this);

    }

}
