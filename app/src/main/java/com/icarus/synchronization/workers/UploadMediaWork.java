package com.icarus.synchronization.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;

import com.icarus.constants.Constants;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.UserSuggestionAttachmentsEntity;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.AssignedChecklistsApi;
import com.icarus.synchronization.api.SuggestionsApi;
import com.icarus.synchronization.api.WorkOrdersApi;
import com.icarus.synchronization.syncmodels.UploadResponse;
import com.icarus.synchronization.syncmodels.WordorderUploadResponse;
import com.icarus.util.FileUtils;

import java.io.File;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class UploadMediaWork extends CommonWorker {

    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
    PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();

    public UploadMediaWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {

        List<AssignedStepFileResourceEntity> stepResource = postSynchronizationDao.getResourceForUpload();

        for (int i = 0; i < stepResource.size(); i++) {
            uploadStepResource(stepResource.get(i));
        }

        List<WorkOrderAttachmentsEntity> workorderResource = postSynchronizationDao.getWorkorderAttachmentForUpload();

        for (int i = 0; i < workorderResource.size(); i++) {
            uploadWorkOrderAttachment(workorderResource.get(i));
        }

        List<UserSuggestionAttachmentsEntity> suggestionResource = postSynchronizationDao.getUserSuggestionAttachmentForUpload();

        for (int i = 0; i < suggestionResource.size(); i++) {
            uploadUserSuggestionAttachment(suggestionResource.get(i));
        }
        return Result.success();
    }

    private void uploadStepResource(final AssignedStepFileResourceEntity resourceEntity) {
        File directory = FileUtils.getResourcesAttachmentsDir();
        if (directory == null)
            return;

        final File fileDestinationFolder = new File(directory, resourceEntity.getFile_md5_checksum() + "." + resourceEntity.getFile_name().split("\\.")[1]);
        if (fileDestinationFolder.exists()) {
            RequestBody requestBody = RequestBody.create(MediaType.parse(resourceEntity.getContent_type()), fileDestinationFolder);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("content", resourceEntity.getFile_name(), requestBody);
            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedChecklistsApi.class)
                    .resourceUpload(Constants.HEADER_ACCEPT, fileToUpload, resourceEntity.getUuid())
                    .subscribe(new AbstractNetworkObservable<UploadResponse>() {
                        @Override
                        public void success(UploadResponse responseBody) {
                            if (responseBody != null && responseBody.getData() != null) {
                                postSynchronizationDao.updateAssigednStepMd5Checksum(responseBody.getData().getFileMd5Checksum(), responseBody.getData().getUuid());
                                postSynchronizationDao.updateAssignedChecklistPendingResourceCount(resourceEntity.getAssigned_checklist_uuid());
                            }
                        }

                        @Override
                        public void failure(Throwable error) {
                            Log.d(Parameters.TAG, error.getMessage());
                        }
                    });
        }
    }

    private void uploadWorkOrderAttachment(final WorkOrderAttachmentsEntity resourceEntity) {

        File directory = FileUtils.getWorkOrderAttachmentsDir();
        if (directory == null)
            return;

        final File fileDestinationFolder = new File(directory, resourceEntity.getFileMd5Checksum() + "." + resourceEntity.getFilename().split("\\.")[1]);

        if (fileDestinationFolder.exists()) {
            RequestBody requestBody = RequestBody.create(MediaType.parse(resourceEntity.getContentType()), fileDestinationFolder);

            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("content", resourceEntity.getFilename(), requestBody);

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(WorkOrdersApi.class)
                    .resourceUpload(Constants.HEADER_ACCEPT, fileToUpload, resourceEntity.getUuid())
                    .subscribe(new AbstractNetworkObservable<WordorderUploadResponse>() {
                        @Override
                        public void success(WordorderUploadResponse responseBody) {
                            if (responseBody != null && responseBody.getData() != null) {
                                postSynchronizationDao.updateWorkorderAttachmentMd5Checksum(responseBody.getData().getFileMd5Checksum(), responseBody.getData().getUuid());
                            }
                        }

                        @Override
                        public void failure(Throwable error) {
                            Log.d(Parameters.TAG, error.getMessage());
                        }
                    });
        }
    }


    private void uploadUserSuggestionAttachment(final UserSuggestionAttachmentsEntity resourceEntity) {

        File directory = FileUtils.getSuggestionAttachmentsDir();
        if (directory == null)
            return;

        final File fileDestinationFolder = new File(directory, resourceEntity.getFile_md5_checksum() + "." + resourceEntity.getFilename().split("\\.")[1]);

        if (fileDestinationFolder.exists()) {

            RequestBody requestBody = RequestBody.create(MediaType.parse(resourceEntity.getContent_type()), fileDestinationFolder);

            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("content", resourceEntity.getFilename(), requestBody);

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(SuggestionsApi.class)
                    .resourceUpload(Constants.HEADER_ACCEPT, fileToUpload, resourceEntity.getUuid())
                    .subscribe(new AbstractNetworkObservable<WordorderUploadResponse>() {
                        @Override
                        public void success(WordorderUploadResponse responseBody) {
                            if (responseBody != null && responseBody.getData() != null) {
                                postSynchronizationDao.updateUserSuggestionAttachmentMd5Checksum(responseBody.getData().getFileMd5Checksum(), responseBody.getData().getUuid());
                            }
                        }

                        @Override
                        public void failure(Throwable error) {
                            Log.d(Parameters.TAG, error.getMessage());

                        }
                    });
        }
    }
}
