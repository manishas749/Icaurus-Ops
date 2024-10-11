package com.icarus.dao;

import com.icarus.database.SyncQueries;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.entities.UserSuggestionAttachmentsEntity;
import com.icarus.entities.UserSuggestionEntity;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PostSynchronizationDao {

    @Query(SyncQueries.QUERY_GET_ASSIGNED_CHECKLISTS)
    List<AssignCheckListEntity> getNonSyncedAssignedChecklist();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_USERS)
    List<AssignedUserEntity> getNonSyncedAssignedUsers();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_CHECKLICKLIST_COMMENTS)
    List<AssignedChecklistCommentsEntity> getNonSyncedAssignedChecklistComments();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_PAUSETIME)
    List<AssignedCheckListPauseTimesEntity> getNonSyncedAssignedChecklistPauseTime();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_DECISION)
    List<AssignedDecisionEntity> getNonSyncedAssignedDecision();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_USER_FAVORITES)
    List<UserFavouritesEntity> getNonSyncedUserFavorites();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_NCW)
    List<AssignedNCWEntity> getNonSyncedAssignedNCW(Integer ncwtype);

    @Query(SyncQueries.QUERY_GET_ASSIGNED_STEP)
    List<AssignedStepEntity> getNonSyncedAssignedStep();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_STEP_SKIP_DEFER)
    List<AssignedStepEntity> getNonSyncedAssignedStepSkipDefer();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_LOGO)
    List<AssignedLogoEntity> getNonSyncedAssignedLogo();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_COMMENT)
    List<AssignedChecklistCommentsEntity> getNonSyncedAssignedComment();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_STEP_ATTRIBUTE)
    List<AssignedStepAttributesEntity> getNonSyncedAssignedStepAttribute();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_Logs)
    List<LogsEntity> getNonSyncedAssignedLogs();

    /*@Query(SyncQueries.QUERY_GET_ASSIGNED_SKIPDEFER_REASON)
    List<AssignCheckListEntity> getNonSyncedAssignedSkipeDeferReasons();*/

    @Query(SyncQueries.QUERY_GET_ASSIGNED_STEP_RESOURCES)
    List<AssignedStepFileResourceEntity> getNonSyncedAssignedStepResources();

    @Query(SyncQueries.QUERY_GET_ASSIGNED_ROOM_EQUIPMENTS)
    List<AssignRoomEquipmentsEntity> getNonSyncedRoomAssets();

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_CHECKLISTS)
    void updateSyncStatusAssignedCheclist(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_CHECKLIST_COMMENT)
    void updateSyncStatusAssignedChecklistComment(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_DECISION)
    void updateSyncStatusAssignedDecision(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_Logs)
    void updateSyncStatusLogs(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_PAUSETIME)
    void updateSyncStatusPauseTime(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_ROOM_EQUIPMENTS)
    void updateSyncStatusRoomEquipments(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_LOGO)
    void updateSyncStatusLogo(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_STEP)
    void updateSyncStatusStep(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_STEP_ATTRIBUTE)
    void updateSyncStatusStepStepAttributes(String uuid);


    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_STEP_RESOURCES)
    void updateSyncStatusStepResources(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_NCW)
    void updateSyncStatusNCW(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_USERS)
    void updateSyncStatusUser(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_USER_FAVORITES)
    void updateSyncStatusUserFavorite(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_USER_SUGGESTION)
    void updateSyncStatusUserSuggestion(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_ASSIGNED_USER_SUGGESTION_ATTACHMENT)
    void updateSyncStatusUserSuggestionAttachment(String uuid);

    @Query(SyncQueries.UPDATE_LAST_SYNC_TIME)
    int updateSyncTime(String lastSyncTime, Integer locationId);

    @Query(SyncQueries.UPDATE_LAST_SYNC_STATUS)
    int updateSyncStatus(Integer lastSyncStatus, Integer locationId);


    @Query(SyncQueries.GET_LAST_SYNC_TIME)
    String getLastSyncTime(Integer locationId);

    @Query(SyncQueries.GET_LAST_SYNC_TIME)
    LiveData<String> getLiveLastSyncTime(Integer locationId);

    @Query(SyncQueries.GET_LAST_SYNC_STATUS)
    LiveData<Integer> getLiveLastSyncStatus(Integer locationId);

    @Query(SyncQueries.GET_LAST_SYNC_STATUS)
    int getLastSyncStatus(Integer locationId);

    @Query(SyncQueries.QUERY_GET_USER_SUGGESTION)
    List<UserSuggestionEntity> getNonSyncedUserSuggestion();

    @Query(SyncQueries.QUERY_GET_USER_SUGGESTION_ATTACHMENT)
    List<UserSuggestionAttachmentsEntity> getNonSyncedUserSuggestionAttachments();

    @Update
    void updateSyncStatus(UserSuggestionAttachmentsEntity userSuggestionAttachmentsEntity);

    //--- Dao operations for work order synchronization--------//

    @Query(SyncQueries.QUERY_GET_WORKORDERS)
    List<WorkOrderEntity> getNonSyncedWorkOrders(Integer locationId);

    @Query(SyncQueries.QUERY_GET_WORKORDERS_ATTACHMENTS)
    List<WorkOrderAttachmentsEntity> getNonSyncedWorkOrdersAttachments(Integer id);

    @Query(SyncQueries.QUERY_GET_WORKORDERS_NOTES)
    List<WorkOrderNotesEntity> getNonSyncedWorkOrdersNotes(Integer id);

    @Query(SyncQueries.QUERY_GET_WORKORDERS_NOTES_DETAIL)
    List<WorkOrderNoteDetailEntity> getNonSyncedWorkOrdersNotesDetail(Integer id);

    @Query(SyncQueries.QUERY_UPDATE_WORKORDER)
    void updateSyncStatusWorkorder(Integer id, String uuid);

    @Query(SyncQueries.QUERY_UPDATE_WORKORDER_SYNC_STATUS)
    void updateSyncStatusWorkorder(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_WORKORDER_NOTES)
    void updateSyncStatusWorkorderNotes(Integer workorderId, Integer id, Integer oldId);

    @Query(SyncQueries.QUERY_UPDATE_WORKORDER_ATTACHMENT)
    void updateSyncStatusWorkorderAttachments(Integer workorderId, String uuid);

    @Query(SyncQueries.QUERY_UPDATE_WORKORDER_ATTACHMENT_SYNC_STATUS)
    void updateSyncStatusWorkorderAttachments(String uuid);

    @Query(SyncQueries.QUERY_UPDATE_WORKORDER_NOTES_DETAIL)
    void updateSyncStatusWorkorderNotesDetail(Integer workorderNoteId, Integer id, Integer oldId);

    @Query(SyncQueries.QUERY_ASSIGNED_STEP_RESOURCE)
    List<AssignedStepFileResourceEntity> getResourceForUpload();

    @Query(SyncQueries.QUERY_WORKORDER_ATTACHMENT_RESOURCE)
    List<WorkOrderAttachmentsEntity> getWorkorderAttachmentForUpload();

    @Query(SyncQueries.QUERY_USER_SUGGESTION_ATTACHMENT)
    List<UserSuggestionAttachmentsEntity> getUserSuggestionAttachmentForUpload();

    @Query(SyncQueries.QUERY_WORKORDER_ATTACHMENT_UPDATE)
    void updateWorkorderAttachmentMd5Checksum(String fileMd5Checksum, String uuid);

    @Query(SyncQueries.QUERY_ASSIGNED_STEP_UPDATE)
    void updateAssigednStepMd5Checksum(String fileMd5Checksum, String uuid);

    @Query(SyncQueries.QUERY_SUGGESTION_ATTACHMENT_UPDATE)
    void updateUserSuggestionAttachmentMd5Checksum(String fileMd5Checksum, String uuid);

    @Query(SyncQueries.UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT)
    void updateAssignedChecklistPendingElementCount(String uuid);

    @Query(SyncQueries.UPDATE_ASSIGNED_CHECKLIST_PENDING_RESOURCE)
    void updateAssignedChecklistPendingResourceCount(String uuid);

}
