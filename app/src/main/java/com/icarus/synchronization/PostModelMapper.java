package com.icarus.synchronization;

import com.icarus.constants.Constants;
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
import com.icarus.enums.ChecklistElementType;
import com.icarus.synchronization.postsyncmodel.AddANdUpdateAssignedChecklistCommentObject;
import com.icarus.synchronization.postsyncmodel.AddANdUpdateAssignedLogoObject;
import com.icarus.synchronization.postsyncmodel.AddANdUpdateAssignedStepObject;
import com.icarus.synchronization.postsyncmodel.AddAndUpdateAssignedCautionObject;
import com.icarus.synchronization.postsyncmodel.AddAndUpdateAssignedChecklistObject;
import com.icarus.synchronization.postsyncmodel.AddAndUpdateAssignedStepResourceObject;
import com.icarus.synchronization.postsyncmodel.AddAndUpdateAssignedWarningObject;
import com.icarus.synchronization.postsyncmodel.AddLogObject;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistCommentRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsrequest;
import com.icarus.synchronization.postsyncmodel.AssginedUserObject;
import com.icarus.synchronization.postsyncmodel.AssignedChecklistPauseTimeObject;
import com.icarus.synchronization.postsyncmodel.AssignedDecisionObject;
import com.icarus.synchronization.postsyncmodel.AssignedNoteObject;
import com.icarus.synchronization.postsyncmodel.AssignedRoomEquipmentObject;
import com.icarus.synchronization.postsyncmodel.AssignedStepAttributeObject;
import com.icarus.synchronization.postsyncmodel.UserFavourites;
import com.icarus.synchronization.postsyncmodel.UserSuggestion;
import com.icarus.synchronization.postsyncmodel.UserSuggestionAttachmentObject;
import com.icarus.synchronization.syncmodels.UserFavorite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import c.anurag.network.beans.AssigneeTypeEnum;

public class PostModelMapper {


    public static List<AddAndUpdateAssignedChecklistObject> mapAssignedChecklist(List<AssignCheckListEntity> getNonSyncedChecklists) {
        List<AddAndUpdateAssignedChecklistObject> list = new ArrayList<>();

        for (int i = 0; i < getNonSyncedChecklists.size(); i++) {
            AddAndUpdateAssignedChecklistObject addAndUpdateAssignedChecklistObject = new AddAndUpdateAssignedChecklistObject();
            AssignCheckListEntity checklist = getNonSyncedChecklists.get(i);
            addAndUpdateAssignedChecklistObject.setAssignedAt(checklist.getAssignedAt());
            addAndUpdateAssignedChecklistObject.setAssigneeType(checklist.getAssigneeType() == 1 ? AddAndUpdateAssignedChecklistObject.AssigneeTypeEnum.USER : AddAndUpdateAssignedChecklistObject.AssigneeTypeEnum.USER);
            addAndUpdateAssignedChecklistObject.setChecklistId(checklist.getChecklistId());
            addAndUpdateAssignedChecklistObject.setDepartmentId(checklist.getDepartmentId());
            addAndUpdateAssignedChecklistObject.setCreatedAt(checklist.getCreated());
            addAndUpdateAssignedChecklistObject.setDueAt(checklist.getDueDate());
            addAndUpdateAssignedChecklistObject.setIsDeleted(checklist.getIsDeleted() == 1 ? true : false);
            addAndUpdateAssignedChecklistObject.setLocationId(checklist.getLocationId());
            addAndUpdateAssignedChecklistObject.setStartedAt(checklist.getStartedAt());
            addAndUpdateAssignedChecklistObject.setStartedByUserId(checklist.getStartedByUserId());
            addAndUpdateAssignedChecklistObject.setStatus(checklist.getChecklistStatus() == 0 ? AddAndUpdateAssignedChecklistObject.StatusEnum.PENDING : checklist.getChecklistStatus() == 2 ? AddAndUpdateAssignedChecklistObject.StatusEnum.COMPLETED : checklist.getChecklistStatus() == 1 ?
                    AddAndUpdateAssignedChecklistObject.StatusEnum.CANCELLED : AddAndUpdateAssignedChecklistObject.StatusEnum.PAUSED);

            addAndUpdateAssignedChecklistObject.setUserId(checklist.getUserId());
            addAndUpdateAssignedChecklistObject.setUuid(checklist.getUuid());
            addAndUpdateAssignedChecklistObject.setUpdatedAt(checklist.getModified());

            list.add(addAndUpdateAssignedChecklistObject);

        }

        return list;
    }

    public static AssignCheckListEntity mapAssignedChecklistEntity(AddAndUpdateAssignedChecklistObject assignedCheckList) {
        AssignCheckListEntity assignCheckListEntity = new AssignCheckListEntity();
        assignCheckListEntity.setDepartmentId(assignedCheckList.getDepartmentId());
        assignCheckListEntity.setChecklistId(assignedCheckList.getChecklistId());
        assignCheckListEntity.setAssigneeType(assignedCheckList.getAssigneeType().equals(AssigneeTypeEnum.user.name()) ? AssigneeTypeEnum.user.getValue() : AssigneeTypeEnum.department.getValue());
        assignCheckListEntity.setIsDeleted(assignedCheckList.getIsDeleted() != null && assignedCheckList.getIsDeleted() ? 1 : 0);
        assignCheckListEntity.setModified(assignedCheckList.getUpdatedAt());
        if (assignedCheckList.getStatus().equals("pending"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PENDING);
        else if (assignedCheckList.getStatus().equals("completed"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECK_LIST_STATUS_COMPLETED);
        else if (assignedCheckList.getStatus().equals("cancelled"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_CANCELLED);
        else if (assignedCheckList.getStatus().equals("paused"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PAUSED);
        else if (assignedCheckList.getStatus().equals("rejected"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_REJECTED);
        else if (assignedCheckList.getStatus().equals("closed"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_CLOSED);
        else if (assignedCheckList.getStatus().equals("pending_approval"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PENDING_APPROVAL);
        else
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_RESUMED);

        assignCheckListEntity.setLocationId(assignedCheckList.getLocationId());
        assignCheckListEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignCheckListEntity.setStartedByUserId(assignedCheckList.getStartedByUserId());
        assignCheckListEntity.setUuid(assignedCheckList.getUuid());
        assignCheckListEntity.setDueDate(assignedCheckList.getDueAt());
        assignCheckListEntity.setUserId(assignedCheckList.getUserId());
        assignCheckListEntity.setAssignedAt(assignedCheckList.getAssignedAt());
        assignCheckListEntity.setCreated(assignedCheckList.getCreatedAt());
        assignCheckListEntity.setStartedAt(assignedCheckList.getStartedAt());
        return assignCheckListEntity;
    }

    public static List<AssignedDecisionObject> mapAssignedDecision(List<AssignedDecisionEntity> list) {
        List<AssignedDecisionObject> assignedDecisionObjects = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            AssignedDecisionObject assignedDecisionObject = new AssignedDecisionObject();
            AssignedDecisionEntity assignedDecisionEntity = list.get(i);
            assignedDecisionObject.setAssignedChecklistUuid(assignedDecisionEntity.getAssignedChecklistUuid());
            assignedDecisionObject.setChecklistElementId(assignedDecisionEntity.getChecklistElementId());
            assignedDecisionObject.setCreatedAt(assignedDecisionEntity.getCreated());
            assignedDecisionObject.setStatus(assignedDecisionEntity.getStatus() == 1 ? AssignedDecisionObject.StatusEnum.YES : assignedDecisionEntity.getStatus() == 0
                    ? AssignedDecisionObject.StatusEnum.NO : assignedDecisionEntity.getStatus() == 2 ?
                    AssignedDecisionObject.StatusEnum.SKIPPED : AssignedDecisionObject.StatusEnum.DEFERRED);
            assignedDecisionObject.setDecisionId(assignedDecisionEntity.getDecisionId());
            assignedDecisionObject.setUserId(assignedDecisionEntity.getUserId());
            assignedDecisionObject.setUuid(assignedDecisionEntity.getUuid());
            assignedDecisionObject.setUpdatedAt(assignedDecisionEntity.getModified());

            assignedDecisionObjects.add(assignedDecisionObject);


        }
        return assignedDecisionObjects;
    }

    public static List<AssignedChecklistPauseTimeObject> mapAssignedChecklistPauseTimes(List<AssignedCheckListPauseTimesEntity> list) {
        List<AssignedChecklistPauseTimeObject> assignedDecisionObjects = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            AssignedChecklistPauseTimeObject assignedChecklistPauseTimeObject = new AssignedChecklistPauseTimeObject();
            AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity = list.get(i);
            assignedChecklistPauseTimeObject.setUuid(assignedCheckListPauseTimesEntity.getUuid());
            assignedChecklistPauseTimeObject.setAssignedChecklistUuid(assignedCheckListPauseTimesEntity.getAssigned_checklist_uuid());
            assignedChecklistPauseTimeObject.setUserId(assignedCheckListPauseTimesEntity.getUser_id());
            assignedChecklistPauseTimeObject.setResumedByUserId(assignedCheckListPauseTimesEntity.getResumed_by_user_id());
            assignedChecklistPauseTimeObject.setReason(assignedCheckListPauseTimesEntity.getReason());
            assignedChecklistPauseTimeObject.setIsDeleted(assignedCheckListPauseTimesEntity.getIs_deleted() == 1);
            assignedChecklistPauseTimeObject.setIsPaused(assignedCheckListPauseTimesEntity.getIs_paused() == 1);
            assignedChecklistPauseTimeObject.setCreatedAt(assignedCheckListPauseTimesEntity.getCreated());
            assignedChecklistPauseTimeObject.setUpdatedAt(assignedCheckListPauseTimesEntity.getModified());

            assignedDecisionObjects.add(assignedChecklistPauseTimeObject);


        }
        return assignedDecisionObjects;
    }

    public static List<AssignedNoteObject> mapAssignedNotes(List<AssignedNCWEntity> nonSyncedAssignedNCW) {
        List<AssignedNoteObject> assignedNoteObjects = new ArrayList<>();
        for (int i = 0; i < nonSyncedAssignedNCW.size(); i++) {
            AssignedNCWEntity assignedNCWEntity = nonSyncedAssignedNCW.get(i);
            AssignedNoteObject assignedNCWObject = new AssignedNoteObject();
            assignedNCWObject.setAssignedChecklistUuid(assignedNCWEntity.getAssigned_checklist_uuid());
            assignedNCWObject.setChecklistElementId(assignedNCWEntity.getChecklistElementId());
            assignedNCWObject.setCreatedAt(assignedNCWEntity.getCreated());
            assignedNCWObject.setIsDeleted(assignedNCWEntity.getIs_deleted() == 1 ? true : false);
            assignedNCWObject.setNoteId(assignedNCWEntity.getItemId());
            assignedNCWObject.setStatus(assignedNCWEntity.getAcknowledged() == 0 ? AssignedNoteObject.StatusEnum.PENDING : assignedNCWEntity.getAcknowledged() == 1 ? AssignedNoteObject.StatusEnum.ACKNOWLEDGED : assignedNCWEntity.getAcknowledged() == 2 ? AssignedNoteObject.StatusEnum.SKIPPED : AssignedNoteObject.StatusEnum.DEFERRED);
            assignedNCWObject.setUpdatedAt(assignedNCWEntity.getModified());
            assignedNCWObject.setUuid(assignedNCWEntity.getUuid());
            assignedNCWObject.setUserId(assignedNCWEntity.getUserId());

            assignedNoteObjects.add(assignedNCWObject);
        }
        return assignedNoteObjects;
    }


    public static List<AddAndUpdateAssignedCautionObject> mapAssignedCausion(List<AssignedNCWEntity> nonSyncedAssignedNCW) {
        List<AddAndUpdateAssignedCautionObject> assignedNoteObjects = new ArrayList<>();
        for (int i = 0; i < nonSyncedAssignedNCW.size(); i++) {
            AssignedNCWEntity assignedNCWEntity = nonSyncedAssignedNCW.get(i);
            AddAndUpdateAssignedCautionObject assignedNCWObject = new AddAndUpdateAssignedCautionObject();
            assignedNCWObject.setAssignedChecklistUuid(assignedNCWEntity.getAssigned_checklist_uuid());
            assignedNCWObject.setChecklistElementId(assignedNCWEntity.getChecklistElementId());
            assignedNCWObject.setCreatedAt(assignedNCWEntity.getCreated());
            assignedNCWObject.setIsDeleted(assignedNCWEntity.getIs_deleted() == 1 ? true : false);
            assignedNCWObject.setCautionId(assignedNCWEntity.getItemId());
            assignedNCWObject.setStatus(assignedNCWEntity.getAcknowledged() == 0 ? AssignedNoteObject.StatusEnum.PENDING : assignedNCWEntity.getAcknowledged() == 1 ? AssignedNoteObject.StatusEnum.ACKNOWLEDGED : assignedNCWEntity.getAcknowledged() == 2 ? AssignedNoteObject.StatusEnum.SKIPPED : AssignedNoteObject.StatusEnum.DEFERRED);
            assignedNCWObject.setUpdatedAt(assignedNCWEntity.getModified());
            assignedNCWObject.setUuid(assignedNCWEntity.getUuid());
            assignedNCWObject.setUserId(assignedNCWEntity.getUserId());

            assignedNoteObjects.add(assignedNCWObject);
        }
        return assignedNoteObjects;
    }


    public static List<AddAndUpdateAssignedWarningObject> mapAssignedWarning(List<AssignedNCWEntity> nonSyncedAssignedNCW) {
        List<AddAndUpdateAssignedWarningObject> assignedNoteObjects = new ArrayList<>();
        for (int i = 0; i < nonSyncedAssignedNCW.size(); i++) {
            AssignedNCWEntity assignedNCWEntity = nonSyncedAssignedNCW.get(i);
            AddAndUpdateAssignedWarningObject assignedNCWObject = new AddAndUpdateAssignedWarningObject();
            assignedNCWObject.setAssignedChecklistUuid(assignedNCWEntity.getAssigned_checklist_uuid());
            assignedNCWObject.setChecklistElementId(assignedNCWEntity.getChecklistElementId());
            assignedNCWObject.setCreatedAt(assignedNCWEntity.getCreated());
            assignedNCWObject.setIsDeleted(assignedNCWEntity.getIs_deleted() == 1 ? true : false);
            assignedNCWObject.setWarningId(assignedNCWEntity.getItemId());
            assignedNCWObject.setStatus(assignedNCWEntity.getAcknowledged() == 0 ? AddAndUpdateAssignedWarningObject.StatusEnum.PENDING : assignedNCWEntity.getAcknowledged() == 1 ? AddAndUpdateAssignedWarningObject.StatusEnum.ACKNOWLEDGED : assignedNCWEntity.getAcknowledged() == 2 ? AddAndUpdateAssignedWarningObject.StatusEnum.SKIPPED : AddAndUpdateAssignedWarningObject.StatusEnum.DEFERRED);
            assignedNCWObject.setUpdatedAt(assignedNCWEntity.getModified());
            assignedNCWObject.setUuid(assignedNCWEntity.getUuid());
            assignedNCWObject.setUserId(assignedNCWEntity.getUserId());

            assignedNoteObjects.add(assignedNCWObject);
        }
        return assignedNoteObjects;
    }

    public static List<AssginedUserObject> mapAssignedUser(List<AssignedUserEntity> nonSyncedAssignedUsers) {
        List<AssginedUserObject> assginedUserObjects = new ArrayList<>();

        for (int i = 0; i < nonSyncedAssignedUsers.size(); i++) {
            AssginedUserObject assginedUserObject = new AssginedUserObject();
            AssignedUserEntity assignedUserEntity = nonSyncedAssignedUsers.get(i);
            assginedUserObject.setAssignedBy(assignedUserEntity.getAssignedBy());
            assginedUserObject.setAssignedChecklistUuid(assignedUserEntity.getAssignedCheklistUUID());
            assginedUserObject.setCreatedAt(assignedUserEntity.getCreated());
            assginedUserObject.setIsDeleted(assignedUserEntity.getIsDeleted() == 1 ? true : false);
            assginedUserObject.setUserId(assignedUserEntity.getUserId());
            assginedUserObject.setUuid(assignedUserEntity.getUuid());
            assginedUserObject.setUpdatedAt(assignedUserEntity.getModified());

            assginedUserObjects.add(assginedUserObject);
        }

        return assginedUserObjects;
    }

    public static AddUpdateAssignedChecklistCommentRequest mapAssignedChecklistComment(List<AssignedChecklistCommentsEntity> entities) {
        AddUpdateAssignedChecklistCommentRequest request = new AddUpdateAssignedChecklistCommentRequest();

        for (AssignedChecklistCommentsEntity entity : entities) {
            AddANdUpdateAssignedChecklistCommentObject dataItem = new AddANdUpdateAssignedChecklistCommentObject();

            dataItem.uuid(entity.getUuid())
                    .assignedChecklistUuid(entity.getAssigned_checklist_uuid())
                    .checklistId(entity.getChecklistId())
                    .checklistElementId(entity.getChecklistElementId())
                    .comment(entity.getComment())
                    .userId(entity.getUserId())
                    .createdAt(entity.getCreated())
                    .updatedAt(entity.getModified());

            request.addDataItem(dataItem);
        }

        return request;
    }

    public static List<AddANdUpdateAssignedStepObject> mapAssignedStep(List<AssignedStepEntity> nonSyncedAssignedStep) {
        List<AddANdUpdateAssignedStepObject> addANdUpdateAssignedStepObjectList = new ArrayList<>();

        for (int i = 0; i < nonSyncedAssignedStep.size(); i++) {
            AddANdUpdateAssignedStepObject addANdUpdateAssignedStepObject = new AddANdUpdateAssignedStepObject();
            AssignedStepEntity assignedStepEntity = nonSyncedAssignedStep.get(i);
            addANdUpdateAssignedStepObject.setAssignedChecklistUuid(assignedStepEntity.getAssignedChecklistUuid());
            addANdUpdateAssignedStepObject.setChecklistElementId(assignedStepEntity.getChecklistElementId());
            addANdUpdateAssignedStepObject.setCreatedAt(assignedStepEntity.getCreated());
            addANdUpdateAssignedStepObject.setStatus(assignedStepEntity.getStatus() == 1 ? "completed" : assignedStepEntity.getStatus() == 2 ? "skipped" : "deferred");
            addANdUpdateAssignedStepObject.setStepId(assignedStepEntity.getStepId());
            addANdUpdateAssignedStepObject.setIsDeleted(assignedStepEntity.getIsDeleted() == 1 ? true : false);
            addANdUpdateAssignedStepObject.setUserId(assignedStepEntity.getUserId());
            addANdUpdateAssignedStepObject.setUuid(assignedStepEntity.getUuid());
            addANdUpdateAssignedStepObject.setUpdatedAt(assignedStepEntity.getModified());

            addANdUpdateAssignedStepObjectList.add(addANdUpdateAssignedStepObject);
        }

        return addANdUpdateAssignedStepObjectList;
    }

    public static List<AddANdUpdateAssignedLogoObject> mapAssignedLogo(List<AssignedLogoEntity> nonSyncedAssignedLogo) {
        List<AddANdUpdateAssignedLogoObject> addANdUpdateAssignedStepObjectList = new ArrayList<>();

        for (int i = 0; i < nonSyncedAssignedLogo.size(); i++) {
            AddANdUpdateAssignedLogoObject addANdUpdateAssignedStepObject = new AddANdUpdateAssignedLogoObject();
            AssignedLogoEntity assignedLogoEntity = nonSyncedAssignedLogo.get(i);
            addANdUpdateAssignedStepObject.setAssignedChecklistUuid(assignedLogoEntity.getAssignedChecklistUuid());
            addANdUpdateAssignedStepObject.setChecklistLogoId(assignedLogoEntity.getChecklistLogoId());
            addANdUpdateAssignedStepObject.setCreatedAt(assignedLogoEntity.getCreated());
            addANdUpdateAssignedStepObject.setUuid(assignedLogoEntity.getUuid());
            addANdUpdateAssignedStepObject.setUpdatedAt(assignedLogoEntity.getModified());

            addANdUpdateAssignedStepObjectList.add(addANdUpdateAssignedStepObject);
        }

        return addANdUpdateAssignedStepObjectList;
    }

    public static List<AssignedStepAttributeObject> mapAssignedStepAttribute(List<AssignedStepAttributesEntity> nonSyncedAssignedStepAttribute) {
        List<AssignedStepAttributeObject> addAndUpdateAssignedStepResourceObjectList = new ArrayList<>();
        for (int i = 0; i < nonSyncedAssignedStepAttribute.size(); i++) {
            AssignedStepAttributeObject assignedStepAttributeObject = new AssignedStepAttributeObject();
            AssignedStepAttributesEntity assignedStepAttributesEntity = nonSyncedAssignedStepAttribute.get(i);

            assignedStepAttributeObject.setAssignedChecklistUuid(assignedStepAttributesEntity.getAssignedChecklistUuid());
            assignedStepAttributeObject.setChecklistElementId(assignedStepAttributesEntity.getChecklistElementId());
            assignedStepAttributeObject.setCreatedAt(assignedStepAttributesEntity.getCreated());
            assignedStepAttributeObject.setIsDeleted(assignedStepAttributesEntity.getIsDeleted() == 1 ? true : false);
            assignedStepAttributeObject.setItemUuid(assignedStepAttributesEntity.getItemUuid());
            assignedStepAttributeObject.setStepAttributeId(assignedStepAttributesEntity.getStepAttributeId());
            assignedStepAttributeObject.setChecklistElementId(assignedStepAttributesEntity.getChecklistElementId());
            assignedStepAttributeObject.setValue(assignedStepAttributesEntity.getValue());
            assignedStepAttributeObject.setUserId(assignedStepAttributesEntity.getUserId());
            assignedStepAttributeObject.setStepId(assignedStepAttributesEntity.getStepId());
            assignedStepAttributeObject.setUpdatedAt(assignedStepAttributesEntity.getModified());
            assignedStepAttributeObject.setUuid(assignedStepAttributesEntity.getUuid());
            addAndUpdateAssignedStepResourceObjectList.add(assignedStepAttributeObject);
        }
        return addAndUpdateAssignedStepResourceObjectList;
    }

    public static List<AddAndUpdateAssignedStepResourceObject> mapAssignedStepResources(List<AssignedStepFileResourceEntity> nonSyncedAssignedStepAttribute) {
        List<AddAndUpdateAssignedStepResourceObject> addAndUpdateAssignedStepResourceObjectList = new ArrayList<>();
        for (int i = 0; i < nonSyncedAssignedStepAttribute.size(); i++) {
            AddAndUpdateAssignedStepResourceObject assignedStepAttributeObject = new AddAndUpdateAssignedStepResourceObject();
            AssignedStepFileResourceEntity assignedStepAttributesEntity = nonSyncedAssignedStepAttribute.get(i);

            assignedStepAttributeObject.setAssignedChecklistUuid(assignedStepAttributesEntity.getAssigned_checklist_uuid());
            assignedStepAttributeObject.setChecklistElementId(assignedStepAttributesEntity.getChecklist_element_id());
            assignedStepAttributeObject.setCreatedAt(assignedStepAttributesEntity.getCreated());
            assignedStepAttributeObject.setIsDeleted(assignedStepAttributesEntity.getIs_deleted() == 1 ? true : false);
            assignedStepAttributeObject.setContentType(assignedStepAttributesEntity.getContent_type());
            assignedStepAttributeObject.setDisplayFilename(assignedStepAttributesEntity.getDisplay_file_name());
            assignedStepAttributeObject.setFilename(assignedStepAttributesEntity.getFile_name());
            assignedStepAttributeObject.setUserId(assignedStepAttributesEntity.getUser_id());
            assignedStepAttributeObject.setItemId(assignedStepAttributesEntity.getItem_id());
            assignedStepAttributeObject.setItemTypeId(assignedStepAttributesEntity.getItem_type_id());
            assignedStepAttributeObject.setMd5Checksum(assignedStepAttributesEntity.getFile_md5_checksum());
            assignedStepAttributeObject.setItemId(assignedStepAttributesEntity.getItem_id());
            assignedStepAttributeObject.setUpdatedAt(assignedStepAttributesEntity.getModified());
            assignedStepAttributeObject.setUuid(assignedStepAttributesEntity.getUuid());
            addAndUpdateAssignedStepResourceObjectList.add(assignedStepAttributeObject);
        }
        return addAndUpdateAssignedStepResourceObjectList;
    }

    public static List<UserFavorite> mapuserFavoritesAction(List<UserFavouritesEntity> userFavouritesEntities) {
        List<UserFavorite> userFavorites = new ArrayList<>();
        for (int i = 0; i < userFavouritesEntities.size(); i++) {
            UserFavorite userFavorite = new UserFavorite();
            UserFavouritesEntity userFavouritesEntity = userFavouritesEntities.get(i);

            userFavorite.setChecklistId(userFavouritesEntity.getChecklistId());
            userFavorite.setCreatedAt(userFavouritesEntity.getCreated());
            userFavorite.setUpdatedAt(userFavouritesEntity.getModified());
            userFavorite.setUserId(userFavouritesEntity.getUserId());
            userFavorite.setUuid(userFavouritesEntity.getUuid());
            userFavorite.setIsDeleted(userFavouritesEntity.getIsDeleted() == 1);

            userFavorites.add(userFavorite);
        }
        return userFavorites;
    }

    public static AddUpdateUserSuggestionsrequest mapUserSuggestionAction(List<UserSuggestionEntity> entities) {
        AddUpdateUserSuggestionsrequest request = new AddUpdateUserSuggestionsrequest();

        for (UserSuggestionEntity entity : entities) {
            UserSuggestion dataItem = new UserSuggestion();
            dataItem.uuid(entity.getUuid())
                    .assignedChecklistUuid(entity.getAssignedChecklistUuid())
                    .checklistId(entity.getChecklistId())
                    .checklistElementId(entity.getChecklistElementId())
                    .description(entity.getDescription())
                    .userId(entity.getUser_id())
                    .createdAt(entity.getCreated())
                    .updatedAt(entity.getModified());

            request.addDataItem(dataItem);
        }

        return request;
    }


    public static List<UserSuggestionAttachmentObject> mapuserSuggestionAttachment(List<UserSuggestionAttachmentsEntity> userSuggestionEntities) {
        List<UserSuggestionAttachmentObject> userSuggestions = new ArrayList<>();
        for (int i = 0; i < userSuggestionEntities.size(); i++) {
            UserSuggestionAttachmentObject userSuggestion = new UserSuggestionAttachmentObject();
            UserSuggestionAttachmentsEntity userSuggestionEntity = userSuggestionEntities.get(i);

            userSuggestion.setCreatedAt(userSuggestionEntity.getCreated());
            userSuggestion.setUpdatedAt(userSuggestionEntity.getModified());
            userSuggestion.setUserId(userSuggestionEntity.getUser_id());
            userSuggestion.setUuid(userSuggestionEntity.getUuid());
            userSuggestion.setContentType(userSuggestionEntity.getContent_type());
            userSuggestion.setDisplayFilename(userSuggestionEntity.getDisplay_filename());
            userSuggestion.setFilename(userSuggestionEntity.getFilename());
            userSuggestion.setFileSize(BigDecimal.valueOf(userSuggestionEntity.getFilesize()));
            userSuggestion.setMd5Checksum(userSuggestionEntity.getFile_md5_checksum());
            userSuggestion.setUserSuggestionUuid(userSuggestionEntity.getUser_suggestion_uuid());
            userSuggestion.setUuid(userSuggestionEntity.getUuid());


            userSuggestions.add(userSuggestion);
        }
        return userSuggestions;
    }

    public static List<AddLogObject> mapLogs(List<LogsEntity> list) {

        List<AddLogObject> logObjects = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            AddLogObject logObject = new AddLogObject();
            LogsEntity logsEntity = list.get(i);

            logObject.setAction(logsEntity.getAction());
            logObject.setAssignedChecklistUuid(logsEntity.getAssignedChecklistUuid());
            logObject.setAssignedTo(logsEntity.getAssignedTo());
            logObject.setAssignedToName(logsEntity.getAssignedToName());
            logObject.setChecklistElementId(logsEntity.getChecklistElementId());
            logObject.setChecklistId(logsEntity.getChecklistId());
            logObject.setUserId(logsEntity.getUserId());
            logObject.setStepAction(logsEntity.getStepAction());
            logObject.setCreatedAt(logsEntity.getCreated());
            logObject.setItemDescription(logsEntity.getItemDescription());
            logObject.setUuid(logsEntity.getUuid());
            logObject.setUsername(logsEntity.getUsername());
            logObject.setItemUuid(logsEntity.getItemUuid());
            logObject.setUpdatedAt(logsEntity.getModified());


            logObjects.add(logObject);
        }
        return logObjects;
    }

    public static List<AssignedRoomEquipmentObject> mapRoomEquipments(List<AssignRoomEquipmentsEntity> list) {
        List<AssignedRoomEquipmentObject> assignedRoomEquipmentObjects = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            AssignedRoomEquipmentObject assignedRoomEquipmentObject = new AssignedRoomEquipmentObject();
            AssignRoomEquipmentsEntity assignRoomEquipmentsEntity = list.get(i);

            assignedRoomEquipmentObject.setAssignedChecklistUuid(assignRoomEquipmentsEntity.getAssignedChecklistUuid());
            assignedRoomEquipmentObject.setUuid(assignRoomEquipmentsEntity.getUuid());
            assignedRoomEquipmentObject.setCreatedAt(assignRoomEquipmentsEntity.getCreated());
            assignedRoomEquipmentObject.setUpdatedAt(assignRoomEquipmentsEntity.getModified());
            assignedRoomEquipmentObject.setEquipmentId(assignRoomEquipmentsEntity.getEquipmentId());
            assignedRoomEquipmentObject.setRoomId(assignRoomEquipmentsEntity.getRoomId());
            assignedRoomEquipmentObject.setIsDeleted(assignRoomEquipmentsEntity.getIsDeleted() == 1 ? true : false);

            assignedRoomEquipmentObjects.add(assignedRoomEquipmentObject);

        }

        return assignedRoomEquipmentObjects;
    }

    public static AssignCheckListEntity mapInsertAssignedChecklistEntity(AddAndUpdateAssignedChecklistObject assignedCheckList,
                                                                         AssignCheckListEntity assignCheckListEntity) {
        if (assignCheckListEntity == null) assignCheckListEntity = new AssignCheckListEntity();
        assignCheckListEntity.setDepartmentId(assignedCheckList.getDepartmentId());
        assignCheckListEntity.setChecklistId(assignedCheckList.getChecklistId());
        assignCheckListEntity.setAssigneeType(assignedCheckList.getAssigneeType().equals(AssigneeTypeEnum.user.name()) ? AssigneeTypeEnum.user.getValue() : AssigneeTypeEnum.department.getValue());
        assignCheckListEntity.setIsDeleted(assignedCheckList.getIsDeleted() != null && assignedCheckList.getIsDeleted() ? 1 : 0);
        assignCheckListEntity.setModified(assignedCheckList.getUpdatedAt());
        if (assignedCheckList.getStatus().equals("pending"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PENDING);
        else if (assignedCheckList.getStatus().equals("completed"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECK_LIST_STATUS_COMPLETED);
        else if (assignedCheckList.getStatus().equals("cancelled"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_CANCELLED);
        else if (assignedCheckList.getStatus().equals("paused"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PAUSED);
        else if (assignedCheckList.getStatus().equals("rejected"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_REJECTED);
        else if (assignedCheckList.getStatus().equals("closed"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_CLOSED);
        else if (assignedCheckList.getStatus().equals("pending_approval"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PENDING_APPROVAL);
        else
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_RESUMED);

        assignCheckListEntity.setLocationId(assignedCheckList.getLocationId());
        assignCheckListEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignCheckListEntity.setStartedByUserId(assignedCheckList.getStartedByUserId());
        assignCheckListEntity.setUuid(assignedCheckList.getUuid());
        assignCheckListEntity.setDueDate(assignedCheckList.getDueAt());
        assignCheckListEntity.setUserId(assignedCheckList.getUserId());
        assignCheckListEntity.setAssignedAt(assignedCheckList.getAssignedAt());
        assignCheckListEntity.setCreated(assignedCheckList.getCreatedAt());
        assignCheckListEntity.setStartedAt(assignedCheckList.getStartedAt());
        assignCheckListEntity.setExecutionStatus(Constants.EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER);
        return assignCheckListEntity;
    }

    public static AssignedUserEntity mapInsertAssignedUsersEntity(AssginedUserObject assignedUser) {
        AssignedUserEntity assignedUserEntity = new AssignedUserEntity();
        assignedUserEntity.setAssignedBy(assignedUser.getAssignedBy() != null ? assignedUser.getAssignedBy() : assignedUser.getUserId());
        assignedUserEntity.setCreated(assignedUser.getCreatedAt());
        assignedUserEntity.setUserId(assignedUser.getUserId());
        assignedUserEntity.setIsDeleted(assignedUser.getIsDeleted() ? 1 : 0);
        assignedUserEntity.setAssignedCheklistUUID(assignedUser.getAssignedChecklistUuid());
        assignedUserEntity.setUuid(assignedUser.getUuid());
        assignedUserEntity.setModified(assignedUser.getUpdatedAt());
        assignedUserEntity.setUserId(assignedUser.getUserId());
        assignedUserEntity.setSyncStatus(Constants.SYNC_STATUS);
        return assignedUserEntity;
    }

    public static AssignedLogoEntity mapInsertAssignedLogoEntity(AddANdUpdateAssignedLogoObject assignedLogo) {
        AssignedLogoEntity assignedLogoEntity = new AssignedLogoEntity();
        assignedLogoEntity.setChecklistLogoId(assignedLogo.getChecklistLogoId());
        assignedLogoEntity.setUuid(assignedLogo.getUuid());
        assignedLogoEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignedLogoEntity.setAssignedChecklistUuid(assignedLogo.getAssignedChecklistUuid());
        assignedLogoEntity.setModified(assignedLogo.getUpdatedAt());
        assignedLogoEntity.setCreated(assignedLogo.getCreatedAt());
        return assignedLogoEntity;
    }

    public static AssignedNCWEntity mapInsertAssignedCautionEntity(AddAndUpdateAssignedCautionObject assignedCaution) {
        AssignedNCWEntity assignedNCWEntity = new AssignedNCWEntity();
        assignedNCWEntity.setSync_status(Constants.SYNC_STATUS);
        assignedNCWEntity.setCreated(assignedCaution.getCreatedAt() + "");
        assignedNCWEntity.setModified(assignedCaution.getUpdatedAt() + "");
        assignedNCWEntity.setUuid(assignedCaution.getUuid());
        assignedNCWEntity.setItemTypeId(ChecklistElementType.CAUTION.getValue());
        assignedNCWEntity.setAssigned_checklist_uuid(assignedCaution.getAssignedChecklistUuid());
        assignedNCWEntity.setItemId(assignedCaution.getCautionId());
        if (assignedCaution.getStatus().equals(Parameters.ACKNOWLEDGE))
            assignedNCWEntity.setAcknowledged(1);
        else
            assignedNCWEntity.setAcknowledged(0);
        assignedNCWEntity.setIs_deleted(assignedCaution.getIsDeleted() ? 1 : 0);
        assignedNCWEntity.setUserId(assignedCaution.getUserId());
        assignedNCWEntity.setChecklistElementId(assignedCaution.getChecklistElementId());

        return assignedNCWEntity;
    }

    public static AssignedNCWEntity mapInsertAssignedNotesEntity(AssignedNoteObject assignedNote) {
        AssignedNCWEntity assignedNCWEntity = new AssignedNCWEntity();
        assignedNCWEntity.setSync_status(Constants.SYNC_STATUS);
        assignedNCWEntity.setCreated(assignedNote.getCreatedAt() + "");
        assignedNCWEntity.setModified(assignedNote.getUpdatedAt() + "");
        assignedNCWEntity.setUuid(assignedNote.getUuid());
        assignedNCWEntity.setItemTypeId(ChecklistElementType.NOTE.getValue());
        assignedNCWEntity.setAssigned_checklist_uuid(assignedNote.getAssignedChecklistUuid());
        assignedNCWEntity.setItemId(assignedNote.getNoteId());
        if (assignedNote.getStatus().equals(Parameters.ACKNOWLEDGE))
            assignedNCWEntity.setAcknowledged(1);
        else
            assignedNCWEntity.setAcknowledged(0);

        assignedNCWEntity.setIs_deleted(assignedNote.getIsDeleted() ? 1 : 0);
        assignedNCWEntity.setUserId(assignedNote.getUserId());
        assignedNCWEntity.setChecklistElementId(assignedNote.getChecklistElementId());

        return assignedNCWEntity;
    }

    public static AssignedNCWEntity mapInsertAssignedWarningEntity(AddAndUpdateAssignedWarningObject assignedWarning) {
        AssignedNCWEntity assignedNCWEntity = new AssignedNCWEntity();
        assignedNCWEntity.setSync_status(Constants.SYNC_STATUS);
        assignedNCWEntity.setCreated(assignedWarning.getCreatedAt() + "");
        assignedNCWEntity.setModified(assignedWarning.getUpdatedAt() + "");
        assignedNCWEntity.setUuid(assignedWarning.getUuid());
        assignedNCWEntity.setItemTypeId(ChecklistElementType.WARNING.getValue());
        assignedNCWEntity.setAssigned_checklist_uuid(assignedWarning.getAssignedChecklistUuid());
        assignedNCWEntity.setItemId(assignedWarning.getWarningId());
        if (assignedWarning.getStatus().equals(Parameters.ACKNOWLEDGE))
            assignedNCWEntity.setAcknowledged(1);
        else
            assignedNCWEntity.setAcknowledged(0);
        assignedNCWEntity.setIs_deleted(assignedWarning.getIsDeleted() ? 1 : 0);
        assignedNCWEntity.setUserId(assignedWarning.getUserId());
        assignedNCWEntity.setChecklistElementId(assignedWarning.getChecklistElementId());
        return assignedNCWEntity;
    }

    public static AssignedCheckListPauseTimesEntity mapInsertAssignedPauseTimeEntity(AssignedChecklistPauseTimeObject assignedChecklistPauseTime) {
        AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity = new AssignedCheckListPauseTimesEntity();
        assignedCheckListPauseTimesEntity.setModified(assignedChecklistPauseTime.getUpdatedAt());
        assignedCheckListPauseTimesEntity.setReason(assignedChecklistPauseTime.getReason() != null ? assignedChecklistPauseTime.getReason() : "");
        assignedCheckListPauseTimesEntity.setResumed_by_user_id(assignedChecklistPauseTime.getResumedByUserId());
        assignedCheckListPauseTimesEntity.setIs_deleted(assignedChecklistPauseTime.getIsDeleted() ? 1 : 0);
        assignedCheckListPauseTimesEntity.setUser_id(assignedChecklistPauseTime.getUserId());
        assignedCheckListPauseTimesEntity.setUuid(assignedChecklistPauseTime.getUuid());
        assignedCheckListPauseTimesEntity.setSync_status(Constants.SYNC_STATUS);
        assignedCheckListPauseTimesEntity.setIs_paused(assignedChecklistPauseTime.getIsPaused() ? 1 : 0);
        assignedCheckListPauseTimesEntity.setCreated(assignedChecklistPauseTime.getCreatedAt());
        assignedCheckListPauseTimesEntity.setAssigned_checklist_uuid(assignedChecklistPauseTime.getAssignedChecklistUuid());
        assignedCheckListPauseTimesEntity.setUuid(assignedChecklistPauseTime.getUuid());
        return assignedCheckListPauseTimesEntity;
    }

    public static LogsEntity mapInsertLogs(AddLogObject log) {
        LogsEntity logsEntity = new LogsEntity();
        logsEntity.setAction(log.getAction());
        logsEntity.setAssignedChecklistUuid(log.getAssignedChecklistUuid());
        logsEntity.setAssignedTo(log.getAssignedTo());
        logsEntity.setAssignedToName(log.getAssignedToName());
        logsEntity.setChecklistId(log.getChecklistId());
        logsEntity.setCreated(log.getCreatedAt());
        logsEntity.setChecklistElementId(log.getChecklistElementId());
        logsEntity.setUuid(log.getUuid());
        logsEntity.setUserId(log.getUserId());
        logsEntity.setSyncStatus(Constants.SYNC_STATUS);
        logsEntity.setStepAction(log.getStepAction());
        logsEntity.setUsername(log.getUsername());
        logsEntity.setItemDescription(log.getItemDescription() != null ? log.getItemDescription() : "");
        logsEntity.setModified(log.getUpdatedAt());
        logsEntity.setItemUuid(log.getItemUuid());
        return logsEntity;
    }

    public static AssignRoomEquipmentsEntity mapInsertAssignedRoomEquipmentEntity(AssignedRoomEquipmentObject assignedRoomEquipment) {
        AssignRoomEquipmentsEntity assignRoomEquipmentsEntity = new AssignRoomEquipmentsEntity();
        assignRoomEquipmentsEntity.setModified(assignedRoomEquipment.getUpdatedAt());
        assignRoomEquipmentsEntity.setCreated(assignedRoomEquipment.getCreatedAt());
        assignRoomEquipmentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignRoomEquipmentsEntity.setIsDeleted(assignedRoomEquipment.getIsDeleted() ? 1 : 0);
        assignRoomEquipmentsEntity.setEquipmentId(assignedRoomEquipment.getEquipmentId());
        assignRoomEquipmentsEntity.setRoomId(assignedRoomEquipment.getRoomId());
        assignRoomEquipmentsEntity.setUuid(assignedRoomEquipment.getUuid());
        assignRoomEquipmentsEntity.setAssignedChecklistUuid(assignedRoomEquipment.getAssignedChecklistUuid());
        return assignRoomEquipmentsEntity;
    }

    public static AssignedStepAttributesEntity mapInsertAssignedStepAttributeEntity(AssignedStepAttributeObject assignedStepAttribute) {
        AssignedStepAttributesEntity assignedStepAttributesEntity = new AssignedStepAttributesEntity();
        assignedStepAttributesEntity.setItemUuid(assignedStepAttribute.getItemUuid());
        assignedStepAttributesEntity.setStepAttributeId(assignedStepAttribute.getStepAttributeId());
        assignedStepAttributesEntity.setIsDeleted(assignedStepAttribute.getIsDeleted() ? 1 : 0);
        assignedStepAttributesEntity.setValue(assignedStepAttribute.getValue());
        assignedStepAttributesEntity.setCreated(assignedStepAttribute.getCreatedAt());
        assignedStepAttributesEntity.setUserId(assignedStepAttribute.getUserId());
        assignedStepAttributesEntity.setUuid(assignedStepAttribute.getUuid());
        assignedStepAttributesEntity.setChecklistElementId(assignedStepAttribute.getChecklistElementId());
        assignedStepAttributesEntity.setStepId(assignedStepAttribute.getStepId());
        assignedStepAttributesEntity.setAssignedChecklistUuid(assignedStepAttribute.getAssignedChecklistUuid());
        assignedStepAttributesEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignedStepAttributesEntity.setModified(assignedStepAttribute.getUpdatedAt());
        return assignedStepAttributesEntity;
    }

    public static AssignedStepFileResourceEntity mapInsertAssignedStepResourcesEntity(AddAndUpdateAssignedStepResourceObject assignedStepResource) {
        AssignedStepFileResourceEntity assignedStepFleResourceEntity = new AssignedStepFileResourceEntity();
        assignedStepFleResourceEntity.setDisplay_file_name(assignedStepResource.getDisplayFilename());
        assignedStepFleResourceEntity.setIs_downloaded(Constants.NOT_DOWNLOADED);
        assignedStepFleResourceEntity.setIs_uploaded(Constants.UPLOADED);
        assignedStepFleResourceEntity.setFile_md5_checksum(assignedStepResource.getMd5Checksum());
        assignedStepFleResourceEntity.setContent_type(assignedStepResource.getContentType());
        assignedStepFleResourceEntity.setFile_name(assignedStepResource.getFilename());
        assignedStepFleResourceEntity.setItem_type_id(assignedStepResource.getItemTypeId());
        assignedStepFleResourceEntity.setChecklist_element_id(assignedStepResource.getChecklistElementId());
        assignedStepFleResourceEntity.setSync_status(Constants.SYNC_STATUS);
        assignedStepFleResourceEntity.setCreated(assignedStepResource.getCreatedAt());
        assignedStepFleResourceEntity.setUuid(assignedStepResource.getUuid());
        assignedStepFleResourceEntity.setModified(assignedStepResource.getUpdatedAt());
        assignedStepFleResourceEntity.setAssigned_checklist_uuid(assignedStepResource.getAssignedChecklistUuid());
        assignedStepFleResourceEntity.setItem_id(assignedStepResource.getItemId());
        assignedStepFleResourceEntity.setIs_deleted(assignedStepResource.getIsDeleted() ? 1 : 0);
        assignedStepFleResourceEntity.setUser_id(assignedStepResource.getUserId());
        return assignedStepFleResourceEntity;
    }

    public static AssignedStepEntity mapInsertAssignedStepEntity(AddANdUpdateAssignedStepObject assignedStep) {
        AssignedStepEntity assignedStepEntity = new AssignedStepEntity();
        assignedStepEntity.setModified(assignedStep.getUpdatedAt());
        assignedStepEntity.setCreated(assignedStep.getCreatedAt());
        assignedStepEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignedStepEntity.setIsDeleted(assignedStep.getIsDeleted() ? 1 : 0);
        assignedStepEntity.setUserId(assignedStep.getUserId());
        assignedStepEntity.setUuid(assignedStep.getUuid());
        if (assignedStep.getStatus().equals(Parameters.COMPLETED))
            assignedStepEntity.setStatus(1);
        else if (assignedStep.getStatus().equals(Parameters.SKIPPED))
            assignedStepEntity.setStatus(2);
        else if (assignedStep.getStatus().equals(Parameters.DEFERRED))
            assignedStepEntity.setStatus(3);
        else
            assignedStepEntity.setStatus(0);

        assignedStepEntity.setStepId(assignedStep.getStepId());
        assignedStepEntity.setChecklistElementId(assignedStep.getChecklistElementId());
        assignedStepEntity.setAssignedChecklistUuid(assignedStep.getAssignedChecklistUuid());
        return assignedStepEntity;
    }

    public static AssignedChecklistCommentsEntity mapAssignedChecklistCommentEntity(AddANdUpdateAssignedChecklistCommentObject object) {
        AssignedChecklistCommentsEntity entity = new AssignedChecklistCommentsEntity();

        entity.setUuid(object.getUuid());
        entity.setAssigned_checklist_uuid(object.getAssignedChecklistUuid());
        entity.setChecklistId(object.getChecklistId());
        entity.setChecklistElementId(object.getChecklistElementId());
        entity.setUserId(object.getUserId());
        entity.setIsDeleted(Constants.NOT_DELETED);
        entity.setComment(object.getComment());
        entity.setCreated(object.getCreatedAt());
        entity.setModified(object.getUpdatedAt());

        entity.setSyncStatus(Constants.SYNC_STATUS);
        return entity;
    }

    public static UserFavouritesEntity mapInsertUserFavourite(UserFavourites datum) {
        UserFavouritesEntity userFavouritesEntity = new UserFavouritesEntity();
        userFavouritesEntity.setModified(datum.getUpdatedAt());
        userFavouritesEntity.setCreated(datum.getCreatedAt());
        userFavouritesEntity.setUuid(datum.getUuid());
        userFavouritesEntity.setSyncStatus(Constants.SYNC_STATUS);
        userFavouritesEntity.setUserId(datum.getUserId());
        userFavouritesEntity.setChecklistId(datum.getChecklistId());
        userFavouritesEntity.setIsDeleted(datum.getIsDeleted() ? 1 : 0);
        return userFavouritesEntity;
    }

    public static AssignedDecisionEntity mapInsertAssignedDecisionEntity(AssignedDecisionObject assignedDecision) {
        AssignedDecisionEntity assignedDecisionEntity = new AssignedDecisionEntity();
        if (assignedDecision.getStatus().getValue().equals(Parameters.SKIPPED))
            assignedDecisionEntity.setStatus(2);
        else if (assignedDecision.getStatus().getValue().equals(Parameters.DEFERRED))
            assignedDecisionEntity.setStatus(3);
        else if (assignedDecision.getStatus().getValue().equalsIgnoreCase(Parameters.YES))
            assignedDecisionEntity.setStatus(1);
        else
            assignedDecisionEntity.setStatus(0);
        assignedDecisionEntity.setUserId(assignedDecision.getUserId());
        assignedDecisionEntity.setUuid(assignedDecision.getUuid());
        assignedDecisionEntity.setIsDeleted(assignedDecision.getIsDeleted() ? 1 : 0);
        assignedDecisionEntity.setModified(assignedDecision.getUpdatedAt());
        assignedDecisionEntity.setDecisionId(assignedDecision.getDecisionId());
        assignedDecisionEntity.setChecklistElementId(assignedDecision.getChecklistElementId());
        assignedDecisionEntity.setAssignedChecklistUuid(assignedDecision.getAssignedChecklistUuid());
        assignedDecisionEntity.setCreated(assignedDecision.getCreatedAt());
        assignedDecisionEntity.setSyncStatus(Constants.SYNC_STATUS);
        return assignedDecisionEntity;
    }
}
