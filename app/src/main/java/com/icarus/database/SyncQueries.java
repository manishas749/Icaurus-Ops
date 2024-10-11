package com.icarus.database;

public class SyncQueries {
    public final static String QUERY_GET_ASSIGNED_CHECKLISTS = "select * from assigned_checklists where sync_status = 0 AND execution_status = 0;";
    public final static String QUERY_GET_ASSIGNED_USERS = "select AssociatedTable.* from assigned_users AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1;";
    public final static String QUERY_GET_ASSIGNED_CHECKLICKLIST_COMMENTS = "select AssociatedTable.* from assigned_checklist_comments AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1;";
    public final static String QUERY_GET_ASSIGNED_DECISION = "select AssociatedTable.* from assigned_decisions AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1;";
    public final static String QUERY_GET_ASSIGNED_USER_FAVORITES = "select * from user_favorites where sync_status = 0";
    public final static String QUERY_GET_ASSIGNED_NCW = "select AssociatedTable.* from assigned_ncw  AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1 and AssociatedTable.item_type_id = :ncwtype ";
    public final static String QUERY_GET_ASSIGNED_ROOM_EQUIPMENTS = "select AssociatedTable.* from assigned_room_equipments  AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    public final static String QUERY_GET_ASSIGNED_SKIPDEFER_REASON = "select AssociatedTable.* from assigned_checklists  AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    public final static String QUERY_GET_ASSIGNED_STEP = "select AssociatedTable.* from assigned_steps  AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1 and AssociatedTable.status IN (0,1)";
    public final static String QUERY_GET_ASSIGNED_STEP_SKIP_DEFER = "select AssociatedTable.* from assigned_steps AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1 and AssociatedTable.status IN (2,3)";
    public final static String QUERY_GET_ASSIGNED_STEP_ATTRIBUTE = "select AssociatedTable.* from assigned_step_attributes AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    public final static String QUERY_GET_ASSIGNED_LOGO = "select AssociatedTable.* from assigned_logos AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    public final static String QUERY_GET_ASSIGNED_COMMENT = "select AssociatedTable.* from assigned_checklist_comments AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    public final static String QUERY_GET_ASSIGNED_PAUSETIME= "select AssociatedTable.* from assigned_checklist_pause_times AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    public final static String QUERY_GET_ASSIGNED_Logs = "select AssociatedTable.* from logs AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";
    public final static String QUERY_GET_ASSIGNED_STEP_RESOURCES = "select AssociatedTable.* from assigned_step_resources AS AssociatedTable LEFT JOIN assigned_checklists as AssignedChecklist ON AssignedChecklist.uuid = AssociatedTable.assigned_checklist_uuid where AssociatedTable.sync_status = 0 AND AssignedChecklist.sync_status = 1";

    public final static String QUERY_UPDATE_ASSIGNED_CHECKLISTS = "update assigned_checklists set sync_status = 1, execution_status = 1 where uuid = :uuid;";
    public final static String QUERY_UPDATE_ASSIGNED_USERS = "update assigned_users set sync_status = 1 where uuid = :uuid;";
    public final static String QUERY_UPDATE_ASSIGNED_USER_FAVORITES = "update user_favorites set sync_status = 1 where uuid = :uuid;";
    public final static String QUERY_UPDATE_ASSIGNED_USER_SUGGESTION = "update user_suggestions set sync_status = 1 where uuid = :uuid;";
    public final static String QUERY_UPDATE_ASSIGNED_USER_SUGGESTION_ATTACHMENT = "update user_suggestion_attachments set sync_status = 1 where uuid = :uuid;";
    public final static String QUERY_UPDATEASSIGNED_CHECKLICKLIST_COMMENTS = "update assigned_checklist_comments set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_DECISION = "update assigned_decisions set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_NCW = "update assigned_ncw set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_ROOM_EQUIPMENTS = "update assigned_room_equipments set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_SKIPDEFER_REASON = "update assigned_checklists set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_STEP = "update assigned_steps set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_LOGO = "update assigned_logos set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_STEP_ATTRIBUTE = "update assigned_step_attributes set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_PAUSETIME= "update assigned_checklist_pause_times set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_Logs = "update logs set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_STEP_RESOURCES = "update assigned_step_resources set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_ASSIGNED_CHECKLIST_COMMENT = "update assigned_checklist_comments set sync_status = 1 where uuid = :uuid";

    public static final String UPDATE_LAST_SYNC_TIME = "update locations set last_sync_time = :lastSyncTime where id = :locationId";
    public static final String GET_LAST_SYNC_TIME = "select last_sync_time from locations where id = :locationId";
    public static final String UPDATE_LAST_SYNC_STATUS = "update locations set last_sync_status = :lastSyncStatus where id = :locationId";

    public static final String GET_LATEST_CHECKLISTS = "SELECT DISTINCT\n" +
            "   Checklist.id \n" +
            " FROM checklists AS Checklist\n" +
            "   INNER JOIN checklist_statuses AS ChecklistStatus ON ( ChecklistStatus.id = Checklist.checklist_status_id )\n" +
            "   INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n" +
            "   LEFT JOIN checklists AS NextChecklist ON ( Checklist.id = NextChecklist.parent_id )\n" +
            "   LEFT JOIN checklist_statuses AS NextChecklistStatus ON ( NextChecklistStatus.id = NextChecklist.checklist_status_id )\n" +
            "   LEFT JOIN checklist_locations AS ChecklistLocation ON (ChecklistLocation.checklist_id = Checklist.id  AND ChecklistLocation.is_deleted = 0) \n" +
            " WHERE\n" +
            "   Checklist.is_deleted = 0 \n" +
            "   AND Checklist.is_template = 0 \n" +
            "   AND ChecklistStatus.is_closed = 1 \n" +
            "   AND ChecklistLocation.location_id = :locationId \n" +
            "   AND (NextChecklist.modified = (SELECT max(modified) FROM checklists WHERE parent_id = Checklist.id) OR NextChecklist.modified IS NULL) \n" +
            "   AND (NextChecklistStatus.is_closed = 0 OR NextChecklistStatus.is_closed IS NULL)  AND Checklist.sync_status = 2 " +
            " UNION SELECT AssignedChecklist.checklist_id  FROM assigned_checklists AS AssignedChecklist  " +
            "    LEFT JOIN checklists AS Checklist ON (Checklist.id = AssignedChecklist.checklist_id) " +
            "   WHERE AssignedChecklist.checklist_status IN ( 0, 4 )  AND AssignedChecklist.is_deleted = 0 \n" +
            "   AND AssignedChecklist.location_id = :locationId AND Checklist.sync_status = 2.";
    public static final String GET_LATEST_ASSIGNED_CHECKLISTS = "select uuid from assigned_checklists where assigned_checklists.checklist_status IN (:status) and modified > :modified and execution_status = -1";
    public static final String GET_LATEST_WORKORDERS = "select id from workorders where execution_status = -1";
    public static final String GET_LATEST_PPES = "select * from ppes";
    public static final String GET_LATEST_HAZARDS = "select * from hazards";

    public static final String GET_LATEST_CLIENT_LOGO = "select * from client_logos where is_downloaded = 0";
    public static final String GET_LATEST_RESOURCES =  "SELECT\n" +
            "   \tResource.id,\n" +
            "   \tResource.uuid,\n" +
            "   \tResource.file_md5_checksum,\n" +
            "   \tResource.file_name,\n" +
            //"   \tResource.file_size,\n" +
            "   \tResource.is_deleted,\n" +
            //"   \tResource.is_downloaded,\n" +
            "   \tResource.is_resource,\n" +
            //"   \tResource.modified,\n" +
            "   \tGROUP_CONCAT(DISTINCT Checklist.id) AS checklist_ids\n" +
            " FROM\n" +
            "   \tresources AS Resource\n" +
            " \tLEFT JOIN checklist_elements AS ChecklistElement ON ((ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR (ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) )\n" +
            " \tLEFT JOIN checklists AS Checklist ON ( Checklist.id = ChecklistElement.checklist_id )\n" +
            " \tLEFT JOIN user_favorites AS UserFavorite ON (UserFavorite.checklist_id = Checklist.id AND UserFavorite.user_id = :userId AND UserFavorite.is_deleted = 0 ) \n" +
            " \n" +
            " WHERE\n" +
            "   \tResource.is_deleted = 0\n" +
            "   \tAND Resource.is_downloaded = 0\n" +
            "   \tAND ChecklistElement.is_deleted = 0\n" +
            //"   \tAND Checklist.is_deleted = 0\n" +
            "   \tAND (\n" +
            "   \tResource.is_resource = 1 \n" +
            "   \tOR (\n" +
            "   \tResource.is_resource = 0 \n" +
            "   \tAND ifnull(UserFavorite.is_deleted, 1) = 0 \n" +
            "   \t) \n" +
            "   \t)\n" +
            "GROUP BY Resource.id";
    public static final String GET_LAST_SYNC_STATUS = "select last_sync_status from locations where id = :locationId";
    public static final String QUERY_GET_USER_SUGGESTION = "select * from user_suggestions where sync_status = 0";
    public static final String QUERY_GET_USER_SUGGESTION_ATTACHMENT = "select * from user_suggestion_attachments where sync_status = 0";

    public static final String UPDATE_RESOURCES =  "update resources set is_downloaded = 1 where uuid = :uuid";
    public static final String UPDATE_CLIENT_LOGO = "update client_logos set is_downloaded = 1 where uuid = :uuid";

    //--------- Queries for workorder synchronization------//

    public static final String QUERY_GET_WORKORDERS= "SELECT Workorder.* FROM workorders Workorder " +
            " LEFT JOIN workorder_attachments WorkorderAttachment ON (WorkorderAttachment.workorder_id = Workorder.id AND WorkorderAttachment.sync_status = 0) " +
            " LEFT JOIN workorder_notes WorkorderNote ON (WorkorderNote.workorder_id = Workorder.id AND WorkorderNote.sync_status = 0) " +
            " LEFT JOIN workorder_note_details WorkorderNoteDetail ON (WorkorderNoteDetail.workorder_note_id = WorkorderNote.id AND WorkorderNoteDetail.sync_status = 0) " +
            " WHERE Workorder.location_id = :locationId AND (Workorder.sync_status = 0 OR WorkorderAttachment.sync_status = 0 OR WorkorderNote.sync_status = 0 OR WorkorderNoteDetail.sync_status = 0)";
    public static final String QUERY_GET_WORKORDERS_ATTACHMENTS = "select * from workorder_attachments where workorder_id = :id  and sync_status = 0";
    public static final String QUERY_GET_WORKORDERS_NOTES = "select * from workorder_notes where workorder_id = :id and sync_status = 0";
    public static final String QUERY_GET_WORKORDERS_NOTES_DETAIL = "select * from workorder_note_details where workorder_note_id = :id  and sync_status = 0";

    public final static String QUERY_UPDATE_WORKORDER = "update workorders set sync_status = 1, id = :id where uuid = :uuid";
    public final static String QUERY_UPDATE_WORKORDER_SYNC_STATUS = "update workorders set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_WORKORDER_ATTACHMENT = "update workorder_attachments set sync_status = 1, workorder_id = :workorderId where uuid = :uuid";
    public final static String QUERY_UPDATE_WORKORDER_ATTACHMENT_SYNC_STATUS = "update workorder_attachments set sync_status = 1 where uuid = :uuid";
    public final static String QUERY_UPDATE_WORKORDER_NOTES = "update workorder_notes set sync_status = 1 , workorder_id = :workorderId,  id = :id where id = :oldId";
    public final static String QUERY_UPDATE_WORKORDER_NOTES_DETAIL = "update workorder_note_details set sync_status = 1, workorder_note_id = :workorderNoteId,  id = :id where id = :oldId";

    public final static String UPDATE_SYNC_CHECKLIST_STATUS = "update checklists set sync_status = :syncStatus where id = :checklistID";
    public final static String UPDATE_SYNC_ASSIGNED_CHECKLIST_STATUS = "update assigned_checklists set execution_status = 1 where uuid = :uuid";

    //public final static String UPDATE_SYNC_RESOURCE_CHECKLIST_STATUS = "UPDATE checklists SET pending_resources_count = pending_resources_count - 1 WHERE id IN (:checklistIds)";
    //public final static String UPDATE_SYNC_REFERENCE_CHECKLIST_STATUS = "UPDATE checklists SET pending_references_count = pending_references_count - 1 WHERE id IN (:checklistIds)";

    public final static String UPDATE_CHECKLIST_SYNC_PENDING_RESOURCE_AFTER_DOWNLOAD = "UPDATE checklists\n" +
            "SET pending_resources_count = pending_resources_count - (\n" +
            "\tSELECT COUNT(DISTINCT resources.file_md5_checksum)\n" +
            "\tFROM resources\n" +
            "\tLEFT JOIN checklist_elements ON (resources.id = checklist_elements.item_id AND checklist_elements.item_type_id = 10)\n" +
            "\tWHERE\n" +
            "\t\tchecklist_elements.is_deleted = 0\n" +
            "\t\tAND resources.is_deleted = 0\n" +
            "\t\tAND resources.is_resource = 1\n" +
            "\t\tAND resources.is_downloaded = 1\n" +
            "\t\tAND resources.file_md5_checksum = :checksum\n" +
            ")\n" +
            "WHERE\n" +
            "\tchecklists.id IN (\n" +
            "\t\tSELECT DISTINCT checklist_elements.checklist_id\n" +
            "\t\tFROM checklist_elements\n" +
            "\t\tLEFT JOIN resources ON (checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10)\n" +
            "\t\tWHERE\n" +
            "\t\t\tchecklist_elements.is_deleted = 0\n" +
            "\t\t\tAND resources.is_deleted = 0\n" +
            "\t\t\tAND resources.is_resource = 1\n" +
            "\t\t\tAND resources.is_downloaded = 1\n" +
            "\t\t\tAND resources.file_md5_checksum = :checksum\n" +
            "\t)\n" +
            "\tAND checklists.pending_resources_count > 0";

    public final static String UPDATE_CHECKLIST_SYNC_PENDING_REFERENCE_AFTER_DOWNLOAD = "UPDATE checklists\n" +
            "SET pending_references_count = pending_references_count - (\n" +
            "\tSELECT COUNT(DISTINCT resources.file_md5_checksum)\n" +
            "\tFROM resources resources\n" +
            "\tLEFT JOIN checklist_elements checklist_elements ON (resources.item_id = checklist_elements.item_id AND resources.item_type_id = checklist_elements.item_type_id)\n" +
            "\tWHERE\n" +
            "\t\tchecklist_elements.is_deleted = 0\n" +
            "\t\tAND resources.is_deleted = 0\n" +
            "\t\tAND resources.is_resource = 0\n" +
            "\t\tAND resources.is_downloaded = 1\n" +
            "\t\tAND resources.file_md5_checksum = :checksum\n" +
            ")\n" +
            "WHERE\n" +
            "\tchecklists.id IN (\n" +
            "\t\tSELECT DISTINCT checklist_elements.checklist_id\n" +
            "\t\tFROM checklist_elements\n" +
            "\t\tLEFT JOIN resources ON (checklist_elements.item_id = resources.item_id AND checklist_elements.item_type_id = resources.item_type_id)\n" +
            "\t\tWHERE\n" +
            "\t\t\tchecklist_elements.is_deleted = 0\n" +
            "\t\t\tAND resources.is_deleted = 0\n" +
            "\t\t\tAND resources.is_resource = 0\n" +
            "\t\t\tAND resources.is_downloaded = 1\n" +
            "\t\t\tAND resources.file_md5_checksum = :checksum\n" +
            "\t)\n" +
            "\tAND checklists.pending_references_count > 0";

    public final static String GET_NON_SYNCED_CHECKLISTS = "select id from checklists where sync_status = 2";

    public final static String QUERY_ASSIGNED_STEP_RESOURCE = "select * from assigned_step_resources  WHERE is_uploaded = 0 AND sync_status = 1";
    public final static String QUERY_WORKORDER_ATTACHMENT_RESOURCE = "select * from workorder_attachments  WHERE is_uploaded = 0 AND sync_status = 1";
    public final static String QUERY_USER_SUGGESTION_ATTACHMENT = "select * from user_suggestion_attachments  WHERE is_uploaded = 0 AND sync_status = 1";

    public final static String QUERY_WORKORDER_ATTACHMENT_UPDATE = "update workorder_attachments set is_uploaded = 1 AND file_md5_checksum = :fileMd5Checksum  WHERE uuid = :uuid";
    public final static String QUERY_ASSIGNED_STEP_UPDATE = "update assigned_step_resources set is_uploaded = 1 AND file_md5_checksum = :fileMd5Checksum WHERE uuid = :uuid";
    public final static String QUERY_SUGGESTION_ATTACHMENT_UPDATE = "update user_suggestion_attachments set is_uploaded = 1 AND file_md5_checksum = :fileMd5Checksum  WHERE uuid = :uuid";

    public final static String QUERY_DELETE_OLD_WORKORDER = "delete FROM workorders where id = :oldId";
    public final static String QUERY_DELETE_OLD_WORKORDER_NOTES = "delete FROM workorder_notes where id = :oldId";
    public final static String QUERY_DELETE_OLD_WORKORDER_NOTE_DETAIL = "delete FROM workorder_note_details where id = :oldId";
    public final static String QUERY_DELETE_OLD_WORKORDER_NOTE_ATTACHMENT = "delete FROM workorder_attachments where uuid = :oldId and sync_status = 0";
    /*public static final String UPDATE_SYNC_CHECKLIST_PENDING_COUNT = "UPDATE checklists SET pending_resources_count = (SELECT count(resources.id)\n" +
            " FROM checklist_elements LEFT JOIN resources ON (checklist_elements.item_id = resources.id)\n" +
            " WHERE\n" +
            " checklist_elements.checklist_id = :checklistId\n" +
            " AND checklist_elements.is_deleted = 0\n" +
            " AND checklist_elements.item_type_id = 10\n" +
            " AND resources.is_resource = 1\n" +
            " AND resources.is_deleted = 0\n" +
            " AND resources.is_downloaded = 0), pending_references_count = (SELECT count(resources.id)\n" +
            " FROM checklist_elements LEFT JOIN resources ON (checklist_elements.item_id = resources.item_id AND checklist_elements.item_type_id = resources.item_type_id )\n" +
            " WHERE\n" +
            " checklist_elements.checklist_id = :checklistId\n" +
            " AND checklist_elements.is_deleted = 0\n" +
            " AND resources.is_resource = 0\n" +
            " AND resources.is_deleted = 0\n" +
            " AND resources.is_downloaded = 0) WHERE id = :checklistId";*/

    public static final String UPDATE_SYNC_CHECKLIST_PENDING_REFERENCE_COUNT = "UPDATE checklists\n" +
            "SET pending_references_count = (\n" +
            "  SELECT count(DISTINCT resources.file_md5_checksum) \n" +
            "  FROM checklist_elements \n" +
            "  LEFT JOIN resources ON (checklist_elements.item_id = resources.item_id AND checklist_elements.item_type_id = resources.item_type_id)\n" +
            "  WHERE \n" +
            "  checklist_elements.checklist_id = :checklistId\n" +
            "  AND checklist_elements.is_deleted = 0 \n" +
            "  AND resources.is_resource = 0 \n" +
            "  AND resources.is_deleted = 0 \n" +
            "  AND resources.is_downloaded = 0\n" +
            ")\n" +
            "WHERE\n" +
            "\tchecklists.id = :checklistId";

    public static final String UPDATE_SYNC_CHECKLIST_PENDING_RESOURCE_COUNT = "UPDATE checklists\n" +
            "SET pending_resources_count = (\n" +
            "  SELECT count(DISTINCT resources.file_md5_checksum) \n" +
            "  FROM checklist_elements \n" +
            "  LEFT JOIN resources ON (checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10)\n" +
            "  WHERE \n" +
            "  checklist_elements.checklist_id = :checklistId\n" +
            "  AND checklist_elements.is_deleted = 0 \n" +
            "  AND resources.is_resource = 1\n" +
            "  AND resources.is_deleted = 0 \n" +
            "  AND resources.is_downloaded = 0\n" +
            ")\n" +
            "WHERE\n" +
            "\tchecklists.id = :checklistId";

    public final static String QUERY_CHECK_IF_CHECKLIST_PPE_EXIST = "select * FROM checklist_ppes where ppe_id = :ppeId and step_id = :stepId";
    public final static String QUERY_CHECK_IF_NCW_HAZARDS_EXIST = "select * FROM ncw_hazards where item_type_id = :itemTypeId and item_id = :itemId and hazard_id = :hazardId";

    public static final String UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT = "update assigned_checklists SET pending_elements_count = pending_elements_count - 1 where uuid = :uuid";
    public static final String UPDATE_ASSIGNED_CHECKLIST_PENDING_RESOURCE = "update assigned_checklists SET pending_resources_count = pending_resources_count - 1 where uuid = :uuid";
    public final static String UPDATE_SYNC_WORKORDER_EXECUTION_STATUS = "update workorders set execution_status = 1 where id = :id";

    public static final String UPDATE_RESOURCE_CHECKLIST_STATUS = "UPDATE checklists SET pending_resources_count = pending_resources_count - 1 WHERE id IN (SELECT DISTINCT ChecklistElement.checklist_id FROM resources AS Resource LEFT JOIN checklist_elements AS ChecklistElement ON ( ( ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR ( ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) ) WHERE Resource.file_md5_checksum = :resourceChecksum AND ChecklistElement.is_deleted = 0 )";

    public static final String UPDATE_REFERENCE_CHECKLIST_STATUS = "UPDATE checklists SET pending_references_count = pending_references_count - 1 WHERE id IN ( SELECT DISTINCT ChecklistElement.checklist_id FROM resources AS Resource LEFT JOIN checklist_elements AS ChecklistElement ON ( ( ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR ( ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) ) WHERE Resource.file_md5_checksum = :referencesChecksum AND ChecklistElement.is_deleted = 0 )";

    public static final String IF_LOCATION_EXISTS_QUERY = "SELECT * FROM locations WHERE id = :id";

    public static final String IF_PAUSE_TIMES_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_checklist_pause_times\n" +
            "WHERE \n" +
            "    uuid = :uuid \n" +
            "AND assigned_checklist_uuid = :assignedChecklistUuid";

    public static final String IF_COMMENT_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_checklist_comments\n" +
            "WHERE \n" +
            "    uuid = :uuid \n" +
            "AND assigned_checklist_uuid = :assignedChecklistUuid";

    public static final String IF_PLACEHOLDER_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_item_placeholders\n" +
            "WHERE \n" +
            "    item_placeholder_id = :id \n" +
            " AND assigned_checklist_uuid = :assignedChecklistUuid "+
            " AND checklist_element_id = :checkListElementID";

    public static final String IF_STEP_RESOURCES_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_step_resources\n" +
            "WHERE \n" +
            "    uuid = :uuid \n" +
            "AND assigned_checklist_uuid = :assignedChecklistUuid "+
            " AND checklist_element_id = :checkListElementID";

    public static final String IF_STEP_ATTRIBUTE_WITH_FILE_EXIST_QUERY = "SELECT " +
            "   * " +
            "FROM " +
            "   assigned_step_attributes " +
            " WHERE item_uuid = :uuid " +
            " AND assigned_checklist_uuid = :assignedChecklistUuid " +
            " AND checklist_element_id = :elementId " +
            " AND step_attribute_id = :stepAttributeId" +
            " AND value = :value";

    public static final String IF_STEP_ATTRIBUTE_EXIST_QUERY = "SELECT " +
            "   * " +
            "FROM " +
            "   assigned_step_attributes " +
            " WHERE item_uuid = :uuid " +
            " AND assigned_checklist_uuid = :assignedChecklistUuid " +
            " AND checklist_element_id = :elementId " +
            " AND step_attribute_id = :stepAttributeId";

    public static final String IF_STEP_ATTRIBUTE_CUSTOM_FILED_QUERY = "SELECT " +
            "   CustomField.type \n" +
            "FROM " +
            "   step_attributes StepAttribute\n" +
            " INNER JOIN custom_fields CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n" +
            " WHERE\n" +
            " StepAttribute.id = :stepAttributeId";

    public static final String IF_LOG_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    logs\n" +
            "WHERE \n" +
            "    assigned_checklist_uuid = :uuid \n" +
            "AND checklist_element_id = :checkListElementID";

    public static final String IF_ASSIGNED_CHECKLIST_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_checklists\n" +
            "WHERE \n" +
            "    uuid = :uuid";

    public static final String IF_ASSIGNED_LOGO_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_logos\n" +
            "WHERE \n" +
            "    assigned_checklist_uuid = :uuid";

    public static final String IF_ASSIGNED_ROOM_EQUIPMENT_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_room_equipments\n" +
            "WHERE \n" +
            "    assigned_checklist_uuid = :uuid";

    public static final String IF_ASSIGNED_USERS_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_users\n" +
            "WHERE \n" +
            "    assigned_checklist_uuid = :uuid " +
            " AND user_id = :userId";

    public static final String IF_ASSIGNED_DEPARTMENTS_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_departments\n" +
            "WHERE \n" +
            "    assigned_checklist_uuid = :uuid " +
            " AND department_id = :depId";

    public static final String IF_USER_FAVORITE_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    user_favorites\n" +
            "WHERE \n" +
            "    checklist_id = :id " +
            " AND user_id = :userId";

    public static final String IF_WORK_ORDER_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    workorders\n" +
            "WHERE \n" +
            "    id = :workOrderId";

    public static final String IF_WORK_ORDER_WITH_UUID_EXISTS = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    workorders\n" +
            "WHERE \n" +
            "    uuid = :workOrderUuid";

    public static final String IF_WORK_ORDER_NOTE_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    workorder_notes\n" +
            "WHERE \n" +
            "    uuid = :workOrderNoteUuid";

    public static final String IF_WORK_ORDER_NOTE_DETAIL_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    workorder_note_details\n" +
            "WHERE \n" +
            "    uuid = :workOrderNoteDetailUuid";

    public static final String IF_WORK_ORDER_ATTACHMENT_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    workorder_attachments\n" +
            "WHERE \n" +
            "    uuid = :workOrderAttachmentUuid";

    public static final String IF_NCW_UPDATED_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_ncw\n" +
            "WHERE \n" +
            "    assigned_checklist_uuid = :uuid \n" +
            "AND checklist_element_id = :checkListElementID";

    public static final String IF_DECISION_UPDATED_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    assigned_decisions\n" +
            "WHERE \n" +
            "    assigned_checklist_uuid = :uuid \n" +
            "AND checklist_element_id = :checkListElementID";

    public static final String GET_ASSIGNED_STEP_UUID = "SELECT " +
            "   * " +
            "FROM " +
            "   assigned_steps " +
            "WHERE " +
            "   checklist_element_id = :stepId " +
            " AND assigned_checklist_uuid = :assignedChecklistUuid";

    public static final String IF_LOCATION_ROOM_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    location_rooms\n" +
            "WHERE \n" +
            "    id = :locationId";

    public static final String IF_LOCATION_EQUIPMENT_EXIST_QUERY = "SELECT \n" +
            "    *\n" +
            "FROM \n" +
            "    location_equipments\n" +
            "WHERE \n" +
            "    id = :locationId";

    public static final String DELETE_QR_STORAGE = "delete FROM qr_storage where id =:qrStorageID";

    public static final String GET_ASSIGNED_CHECKLIST = "Select * " +
            "From assigned_checklists " +
            "where uuid = :checklistUuid";


}
