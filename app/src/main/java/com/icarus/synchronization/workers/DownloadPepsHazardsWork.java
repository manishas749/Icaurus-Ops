package com.icarus.synchronization.workers;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.HazardsEntity;
import com.icarus.entities.PepesEntity;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.HazardsApi;
import com.icarus.synchronization.api.PpesApi;
import com.icarus.util.FileUtils;
import com.icarus.util.MD5;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.List;

import androidx.work.WorkerParameters;
import c.anurag.network.subscriber.AbstractNetworkObservable;
import okhttp3.ResponseBody;

public class DownloadPepsHazardsWork extends CommonWorker {


    public DownloadPepsHazardsWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        List<PepesEntity> ppes = getSynchronizationDao.getPpes();  //-- Get Detail of Peps to be downloaded
        List<HazardsEntity> hazards = getSynchronizationDao.getHazards();  //-- Get Detail of hazards to be downloaded


        for (int i = 0; i < ppes.size(); i++)
            downloadIcon(ppes.get(i), 0);

        for (int i = 0; i < hazards.size(); i++)
            downloadIcon(hazards.get(i), 0);


        return Result.success();
    }


    private void downloadIcon(final PepesEntity hazardObject, int count) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File directory = new File(BaseApplication.getCommonFunctions().getStoragePath(), Constants.RESOURCES_PPE);
            if (!directory.exists())
                directory.mkdirs();

            final File fileDestinationFolder = new File(directory, hazardObject.getIcon());

            if (!fileDestinationFolder.exists()) {


                RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(PpesApi.class).ppeDownload(Constants.HEADER_ACCEPT, hazardObject.getUuid()).subscribe(new AbstractNetworkObservable<ResponseBody>() {
                    @Override
                    public void success(ResponseBody responseBody) {
                        if (responseBody != null) {
                            try {
                                fileDestinationFolder.createNewFile();
                                fileUtils.saveToDisk(responseBody, fileDestinationFolder);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.d(Parameters.TAG, error.getMessage());
                    }
                });
            } else if (!MD5.checkMD5(hazardObject.getFileMd5Checksum(), fileDestinationFolder)) {
                count++;
                fileDestinationFolder.delete();
                if (count < 2) {
                    downloadIcon(hazardObject, count);
                }
            }
        } catch (Exception ex) {
        }
    }

    private void downloadIcon(final HazardsEntity hazardObject, int count) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File directory = new File(BaseApplication.getCommonFunctions().getStoragePath(), Constants.RESOURCES_HAZARDS);
            if (!directory.exists())
                directory.mkdirs();

            final File fileDestinationFolder = new File(directory, hazardObject.getIcon());

            if (!fileDestinationFolder.exists()) {


                RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(HazardsApi.class).hazardDownload(Constants.HEADER_ACCEPT, hazardObject.getUuid()).subscribe(new AbstractNetworkObservable<ResponseBody>() {
                    @Override
                    public void success(ResponseBody responseBody) {
                        if (responseBody != null) {
                            try {
                                fileDestinationFolder.createNewFile();
                                fileUtils.saveToDisk(responseBody, fileDestinationFolder);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.d(Parameters.TAG, error.getMessage());
                    }
                });
            } else if (!MD5.checkMD5(hazardObject.getFileMd5Checksum(), fileDestinationFolder)) {
                count++;
                fileDestinationFolder.delete();
                if (count < 2) {
                    downloadIcon(hazardObject, count);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}