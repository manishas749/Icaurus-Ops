package com.icarus.repositories;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.UserSuggestionDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.UserSuggestionAttachmentsEntity;
import com.icarus.entities.UserSuggestionEntity;
import com.icarus.models.AttachmentItems;
import com.icarus.util.AppUtility;

import android.app.Application;
import androidx.databinding.ObservableList;

public class UserSuggestionRepository {

    public Application application;

    public UserSuggestionRepository(Application application) {
        this.application = application;
    }

    /**
     * @param assignedCheckListUuid uuid of assigned checklist
     * @param checklistId           id of checklist
     * @param description           description
     * @param contentType           content type (image/video)
     * @param displayFileName       file name for displaying
     * @param fileName              name of the file beiong uploaded
     * @param md5CheckSum           md5 checksum for file
     * @param fileSize              size of file
     */

    private void addUserSuggestion(String assignedCheckListUuid, Integer checklistId, String description, String contentType, String displayFileName, String fileName, String md5CheckSum, Long fileSize) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        UserSuggestionDao userSuggestionDao = appDatabase.userSuggestionDao();

        String currentTime = AppUtility.Companion.getUtcTime();

        String userSuggestionUuid = AppUtility.Companion.getUuid();

        UserSuggestionEntity userSuggestionEntity = new UserSuggestionEntity();
        userSuggestionEntity.setAssignedChecklistUuid(assignedCheckListUuid);
        userSuggestionEntity.setChecklistId(checklistId);
        userSuggestionEntity.setCreated(currentTime);
        userSuggestionEntity.setDescription(description);
        userSuggestionEntity.setIsDeleted(Constants.NOT_DELETED);
        userSuggestionEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        userSuggestionEntity.setUser_id(BaseApplication.getPreferenceManager().getUserId());
        userSuggestionEntity.setUuid(userSuggestionUuid);
        userSuggestionEntity.setModified(currentTime);


            UserSuggestionAttachmentsEntity userSuggestionAttachmentsEntity = new UserSuggestionAttachmentsEntity();
        userSuggestionAttachmentsEntity.setCreated(currentTime);
        userSuggestionAttachmentsEntity.setModified(currentTime);
        userSuggestionAttachmentsEntity.setContent_type(contentType);
        userSuggestionAttachmentsEntity.setDisplay_filename(displayFileName);
        userSuggestionAttachmentsEntity.setFilename(fileName);
        userSuggestionAttachmentsEntity.setFile_md5_checksum(md5CheckSum);
        userSuggestionAttachmentsEntity.setIs_uploaded(Constants.NOT_UPLOADED);
        userSuggestionAttachmentsEntity.setUuid(AppUtility.Companion.getUuid());
        userSuggestionAttachmentsEntity.setSync_status(Constants.SYNC_STATUS_NOT);
        userSuggestionAttachmentsEntity.setUser_id(BaseApplication.getPreferenceManager().getUserId());
        userSuggestionAttachmentsEntity.setFilesize(Math.round(fileSize));
        userSuggestionAttachmentsEntity.setUser_suggestion_uuid(userSuggestionUuid);


        userSuggestionDao.addUserSuggestions(userSuggestionEntity, userSuggestionAttachmentsEntity);

    }


    public void addUserSuggestion(String checklistUUID, Integer checklistID, Integer checklistElementId, String reason, ObservableList<AttachmentItems> listAttachment) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        UserSuggestionDao userSuggestionDao = appDatabase.userSuggestionDao();

        String currentTime = AppUtility.Companion.getUtcTime();

        String userSuggestionUuid = AppUtility.Companion.getUuid();

        UserSuggestionEntity userSuggestionEntity = new UserSuggestionEntity();
        userSuggestionEntity.setAssignedChecklistUuid(checklistUUID);
        userSuggestionEntity.setChecklistId(checklistID);
        userSuggestionEntity.setCreated(currentTime);
        userSuggestionEntity.setDescription(reason);
        userSuggestionEntity.setIsDeleted(Constants.NOT_DELETED);
        userSuggestionEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        userSuggestionEntity.setUser_id(BaseApplication.getPreferenceManager().getUserId());
        userSuggestionEntity.setUuid(userSuggestionUuid);
        userSuggestionEntity.setModified(currentTime);
        userSuggestionEntity.setChecklistElementId(checklistElementId);
        userSuggestionDao.insertUserSuggestion(userSuggestionEntity);

        if (listAttachment != null && listAttachment.size() > 0)
            for (int i = 0; i < listAttachment.size(); i++) {
                UserSuggestionAttachmentsEntity userSuggestionAttachmentsEntity = new UserSuggestionAttachmentsEntity();
                userSuggestionAttachmentsEntity.setCreated(currentTime);
                userSuggestionAttachmentsEntity.setModified(currentTime);
                userSuggestionAttachmentsEntity.setContent_type(listAttachment.get(i).getMimeType());
                userSuggestionAttachmentsEntity.setDisplay_filename(listAttachment.get(i).getFileSource().getName());
                userSuggestionAttachmentsEntity.setFilename(listAttachment.get(i).getFileDestination().getName());
                userSuggestionAttachmentsEntity.setFile_md5_checksum(listAttachment.get(i).getFileMd5Checksum());
                userSuggestionAttachmentsEntity.setIs_uploaded(Constants.NOT_UPLOADED);
                userSuggestionAttachmentsEntity.setUuid(AppUtility.Companion.getUuid());
                userSuggestionAttachmentsEntity.setSync_status(Constants.SYNC_STATUS_NOT);
                userSuggestionAttachmentsEntity.setUser_id(BaseApplication.getPreferenceManager().getUserId());
                userSuggestionAttachmentsEntity.setFilesize(Math.round(listAttachment.get(i).getFileSize()));
                userSuggestionAttachmentsEntity.setUser_suggestion_uuid(userSuggestionUuid);
                userSuggestionDao.insertUserSuggestionAttachment(userSuggestionAttachmentsEntity);
            }

    }
}

