package com.icarus.database;

public class InsertUpdateQueries {
    public static final String UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT = "update assigned_checklists SET pending_elements_count = pending_elements_count + 1 where uuid = :uuid";
    public static final String UPDATE_ASSIGNED_CHECKLIST_PENDING_RESOURCE = "update assigned_checklists SET pending_resources_count = pending_resources_count + 1 where uuid = :uuid";

    public static final String UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT_COUNT = "update assigned_checklists SET pending_elements_count = pending_elements_count + :incrementBy where uuid = :uuid";

    public static final String UPDATE_ASSIGNED_CHECKLIST = "update assigned_checklists SET user_id = :userId , modified = :currentTime , checklist_status = :checklist_status , sync_status = :sync_status, execution_status = 0 where uuid = :uuid";
    public static final String UPDATE_ASSIGNED_CHECKLIST_PAUSE_TIME_ENTRY = "update assigned_checklist_pause_times SET resumed_by_user_id = :userId , is_paused = :is_paused , modified = :currentTime , sync_status = :sync_status where assigned_checklist_uuid = :uuid and is_paused = 1";
    public static final String UPDATE_ASSIGNED_CHECKLIST_START = "update assigned_checklists SET user_id = :userId , started_by_user_id = :userId, started_at = :currentTime , modified = :currentTime , sync_status = :sync_status, execution_status = 0 where uuid = :uuid";
    public static final String UPDATE_USER_FAV_REMOVE = "update user_favorites set is_deleted = 1,modified = :modified, sync_status = :sync_status where checklist_id = :checklistId and user_id = :userId";
    public static final String UPDATE_USER_FAV = "update user_favorites set is_deleted = 0, modified = :modified, sync_status = :sync_status where checklist_id = :checklistId and user_id = :userId";
    public static final String UPDATE_ASSIGN_NCW = "update assigned_ncw set is_deleted = 0 , sync_status = 0 , user_id = :userId , acknowledged = :acknowledged , modified = :currentTime where uuid = :uuid";

    public static final String CHECK_USER_FAV_EXIST = "select uuid FROM user_favorites where checklist_id = :checklistId AND user_id  = :userId ";

    public static final String UPDATE_ASSIGN_DECISIONS = "update assigned_decisions set is_deleted = 0 , sync_status = 0 , user_id = :userId , status = :status , modified = :currentTime where uuid = :uuid";
    public static final String GET_LOGO_ID_QUERY = "SELECT id FROM checklist_logos WHERE checklist_id = :checklistId";
    public static final String UPDATE_CHECKLIST_MODIFIED = "update assigned_checklists SET modified = :currentTime , sync_status = 0, execution_status = 0 where uuid = :checklistUuid";
    public static final String UPDATE_ASSIGNED_CHECKLIST_DEPARTMENT = "UPDATE assigned_checklists SET user_id = :userId, started_by_user_id= :userId, started_at= :currentTime, assignee_type = 1, modified=:currentTime, sync_status=0, execution_status = 0 WHERE  uuid = :uuid";
    public static final String UPDATE_DEPARTMENT_ASSIGNED = "UPDATE assigned_departments SET is_deleted =1, modified=:currentTime WHERE  uuid = :uuid";
    public static final String UPDATE_CHILDS_ON_PARENT = "update assigned_ncw set is_deleted = 1 , sync_status = 0 , modified = CURRENT_TIMESTAMP where assigned_ncw.checklist_element_id IN (select checklist_elements.id from checklist_elements where checklist_elements.parent_id = :parentid)";

    public static final String UPDATE_ASSIGNED_STEP_ATTRIBUTE = "update assigned_step_attributes set is_deleted = :isDeleted, sync_status = 0,  modified =:currentDate, value = :value where uuid = :uuid";
    public static final String REMOVE_FILE_FROM_ATTRIBUTE = "update assigned_step_attributes set is_deleted = 1, sync_status = 0  where value = :fileUuid";
    public static final String REMOVE_FILE_FROM_ATTRIBUTE_FILE = "update assigned_step_resources set is_deleted = 1, sync_status = 0  where uuid = :fileUuid";

    public static final String UPDATE_ASSIGNED_STEP_ATTRIBUTE_QR = "update assigned_step_attributes set is_deleted = 0, sync_status = 0, modified =:currentDate, value = :value, user_id =:userId where uuid = :uuid";

    public static final String UPDATE_ASSIGNED_CHECKLIST_AND_PENDING_COUNT = "update assigned_checklists " +
            "set sync_status = 0, " +
            "modified =:executedAt, " +
            "user_id =:userId, " +
            "pending_elements_count = pending_elements_count + :incrementBy " +
            " where uuid = :assignedChecklistUuid";

    public static final String IF_PAUSE_TIMES_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_checklist_pause_times\n" +
            "WHERE \n" +
            " assigned_checklist_uuid = :uuid" +
            " AND is_deleted = 0 ORDER BY modified DESC";
}
