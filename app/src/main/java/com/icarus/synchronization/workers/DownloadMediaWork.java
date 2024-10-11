package com.icarus.synchronization.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.ClientLogoEntity;
import com.icarus.models.ResourceDownloadItems;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.AccountLogosApi;
import com.icarus.synchronization.api.MasterChecklistsApi;
import com.icarus.util.FileUtils;
import com.icarus.util.MD5;

import java.io.File;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadMediaWork extends CommonWorker {

    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
    GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

    public DownloadMediaWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        Integer loggedInUserId = BaseApplication.getPreferenceManager().getUserId();

        // Fetch resources that are to be downloaded.
        List<ResourceDownloadItems> resources = getSynchronizationDao
                .getResourcesToDownload(loggedInUserId);

        for (ResourceDownloadItems resource : resources) {
            downloadIcon(resource, 0);
        }

        // Fetch client logos to be downloaded.
        List<ClientLogoEntity> clientLogos = getSynchronizationDao.getClientLogo();

        for (ClientLogoEntity clientLogo : clientLogos) {
            downloadIcon(clientLogo);
        }

        return Result.success();
    }


    private void downloadIcon(final ClientLogoEntity clientLogoEntity) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File logoDirectory = new File(BaseApplication.getCommonFunctions().getStoragePath(), Constants.CLIENT_LOGO);

            if (!logoDirectory.exists()) {
                logoDirectory.mkdirs();
            }

            final File file = new File(logoDirectory, clientLogoEntity.getFileMd5Checksum());

            if (file.exists()) {
                if (MD5.checkMD5(clientLogoEntity.getFileMd5Checksum(), file)) {
                    getSynchronizationDao.updateClientLogo(clientLogoEntity.getUuid());
                }
            } else {
                RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                        .create(AccountLogosApi.class)
                        .clientLogoDownload(Constants.HEADER_ACCEPT, clientLogoEntity.getUuid(), BaseApplication.getPreferenceManager().getRevisionNumber())
                        .subscribe(new AbstractNetworkObservable<ResponseBody>() {
                            @Override
                            public void success(ResponseBody responseBody) {
                                if (responseBody != null) {
                                    if (fileUtils.writeResponseBodyToDisk(responseBody, file)) {
                                        if (MD5.checkMD5(clientLogoEntity.getFileMd5Checksum(), file)) {
                                            getSynchronizationDao.updateClientLogo(clientLogoEntity.getUuid());
                                        } else {
                                            file.delete();
                                        }
                                    }
                                }
                            }

                            @Override
                            public void failure(Throwable error) {
                                Log.d(Parameters.TAG, error.getMessage());
                            }
                        });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void downloadIcon(final ResourceDownloadItems resourceEntity, final int count) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File resourceDirectory = FileUtils.getResourcesAttachmentsDir();
            if (resourceDirectory == null)
                return;

            final File file = new File(resourceDirectory, resourceEntity.getPath());
            if (file.exists()) {
                update(resourceEntity, file, count);
            } else {
                RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                        .create(MasterChecklistsApi.class)
                        .resourceDownload(Constants.HEADER_ACCEPT, resourceEntity.getUuid())
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> responseBody) {
                                if (responseBody.body() != null) {
                                    if (fileUtils.writeResponseBodyToDisk(responseBody.body(), file)) {
                                        update(resourceEntity, file, count);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                                Log.d(Parameters.TAG, t.getMessage());
                            }
                        });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void update(ResourceDownloadItems resourceEntity, File file, int count) {
        if (MD5.checkMD5(resourceEntity.getFileMd5Checksum(), file)) {
            getSynchronizationDao.updateResources(resourceEntity.getUuid());

            if (resourceEntity.getIsResource() == 1) {
                getSynchronizationDao.updateResourceSyncStatus(resourceEntity.getFileMd5Checksum());
            } else {
                getSynchronizationDao.updateReferenceSyncStatus(resourceEntity.getFileMd5Checksum());
            }

            //postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_COMPLETED, BaseApplication.getPreferenceManager().getUserLocationId());
        } else {
            file.delete();

            count++;

            if (count < 3) {
                downloadIcon(resourceEntity, count);
            }
        }
    }
}