package com.icarus.database;

public class ReportQueries {
    public static final String SUMMARY = "SELECT " +
            "   StartedBy.full_name AS started_by, " +
            "   AssignedChecklist.started_at, " +
            "   StatusLog.\"action\", " +
            "   coalesce(StatusLog.username, PerformedBy.full_name) AS last_performed_by, " +
            "   coalesce(StatusLog.created, AssignedChecklist.modified) AS last_performed_at, " +
            "   StatusLog.item_description AS reason, " +
            "   ClosedLog.username AS closed_by, " +
            "   ClosedLog.created AS closed_at, " +
            "   Department.name AS department, " +
            "   Location.name AS location, " +
            "   RoomEquipmentLog.step_action AS room, " +
            "   RoomEquipmentLog.item_description AS equipment " +
            "FROM " +
            "   assigned_checklists AS AssignedChecklist " +
            "LEFT JOIN users AS StartedBy ON( " +
            "   AssignedChecklist.started_by_user_id = StartedBy.id " +
            ") " +
            "LEFT JOIN users AS PerformedBy ON( " +
            "   AssignedChecklist.user_id = PerformedBy.id " +
            ") " +
            "LEFT JOIN logs AS RoomEquipmentLog ON (\n" +
            "   RoomEquipmentLog.assigned_checklist_uuid = AssignedChecklist.uuid " +
            "   AND RoomEquipmentLog.\"action\" = 16 " +
            "   AND RoomEquipmentLog.checklist_element_id IS NULL " +
            ") " +
            "LEFT JOIN logs AS StatusLog ON( " +
            "   StatusLog.assigned_checklist_uuid = AssignedChecklist.uuid " +
            "   AND StatusLog.\"action\" IN (3, 4) " +
            "   AND StatusLog.checklist_element_id IS NULL " +
            ") " +
            "LEFT JOIN logs AS ClosedLog ON( " +
            "   ClosedLog.assigned_checklist_uuid = AssignedChecklist.uuid " +
            "   AND ClosedLog.\"action\" = 24 " +
            "   AND ClosedLog.checklist_element_id IS NULL " +
            ") " +
            "LEFT JOIN locations AS Location ON( " +
            "   AssignedChecklist.location_id = Location.id " +
            ") " +
            "LEFT JOIN departments AS Department ON( " +
            "   AssignedChecklist.department_id = Department.id " +
            ") " +
            "WHERE\n" +
            "   AssignedChecklist.uuid = :assignedChecklistUuid " +
            "ORDER BY " +
            "   StatusLog.created DESC, " +
            "   ClosedLog.created DESC " +
            "LIMIT 1";

    public static final String ASSIGNED_MEMBERS = "SELECT " +
            " User.full_name " +
            "FROM " +
            " assigned_users AS AssignedUser " +
            "LEFT JOIN users AS User ON( " +
            " AssignedUser.user_id = User.id " +
            ") " +
            "WHERE " +
            "   AssignedUser.assigned_checklist_uuid = :assignedChecklistUuid " +
            "AND AssignedUser.is_deleted = 0 " +
            "ORDER BY " +
            "   User.full_name ASC";

    public static final String ASSIGNMENT_HISTORY = "SELECT " +
            " Log.created AS performed_at, " +
            " Log.\"action\", " +
            " Log.username AS assigned_by, " +
            " group_concat(assigned_to_name, ', ') AS assigned_to " +
            "FROM " +
            " logs AS Log " +
            "WHERE " +
            " assigned_checklist_uuid = :assignedChecklistUuid " +
            "AND checklist_element_id IS NULL " +
            "AND( " +
            "   \"action\" IN (0, 1, 15, 21) " +
            "   OR( " +
            "       \"action\" = 20 " +
            "       AND user_id <> assigned_to " +
            "   ) " +
            ") " +
            "GROUP BY " +
            "   created, " +
            "   \"action\", " +
            "   username " +
            "ORDER BY " +
            "   created DESC, " +
            "   \"action\" ASC";

    public static final String PAUSE_HISTORY = "SELECT " +
            "   Log.uuid, " +
            "   Log.username AS paused_by, " +
            "   Log.created AS paused_at, " +
            "   Log.item_description AS pause_reason, " +
            "   NLog.created AS resumed_at, " +
            "   NLog.username AS resumed_by " +
            "FROM " +
            " logs AS Log  " +
            "LEFT JOIN logs AS NLog ON( " +
            "   NLog.assigned_checklist_uuid = :assignedChecklistUuid " +
            "   AND NLog.\"action\" = :resumeAction " +
            "   AND NLog.created > Log.created " +
            ") " +
            "LEFT JOIN logs AS NNLog ON( " +
            "   NNLog.assigned_checklist_uuid = :assignedChecklistUuid " +
            "   AND NNLog.\"action\" = :resumeAction " +
            "   AND NNLog.created > Log.created " +
            "   AND NNLog.created < NLog.created " +
            ") " +
            "WHERE " +
            "   Log.assigned_checklist_uuid = :assignedChecklistUuid " +
            "AND Log.\"action\" = :pauseAction " +
            "AND NNLog.created IS NULL " +
            "ORDER BY " +
            "   Log.created ASC, " +
            "   NLog.created ASC";


    public static final String GET_NOTES_LIST = "SELECT " +
            "    AssignedChecklistComment.comment, " +
            "    AssignedChecklistComment.modified AS updatedAt, " +
            "    User.full_name AS userFullName " +
            "FROM " +
            "    assigned_checklist_comments AS AssignedChecklistComment " +
            "        LEFT JOIN " +
            "    users AS User ON (AssignedChecklistComment.user_id = User.id) " +
            "WHERE " +
            "    AssignedChecklistComment.assigned_checklist_uuid = :checklistUUID " +
            "ORDER BY AssignedChecklistComment.modified DESC";


    public static final String ACCEPTANCE_HISTORY = "SELECT " +
            "   Log.created, " +
            "   Log.\"action\", " +
            "   Log.username, " +
            "   Log.item_description " +
            "FROM   " +
            "   logs AS Log " +
            "WHERE " +
            "   Log.assigned_checklist_uuid = :assignedChecklistUuid " +
            "AND Log.checklist_element_id IS NULL " +
            "AND Log.\"action\" IN (:acceptanceActions) " +
            "ORDER BY " +
            "   Log.created DESC";

    public static final String GET_LOGS_SUMMARY = "SELECT \n" +
            "Log.uuid, \n" +
            "Log.item_uuid, \n" +
            "Log.action, \n" +
            "Log.username, \n" +
            "Log.item_description, \n" +
            "Log.created, \n" +
            "Log.checklist_element_id, \n" +
            "Log.step_action, \n" +
            "Log.assigned_checklist_uuid, \n" +
            "AssignedStepResource.uuid AS assignedStepResourceUUID, \n" +
            "AssignedStepResource.file_md5_checksum, \n" +
            "AssignedStepResource.display_file_name,\n" +
            "CustomField.type\n" +
            "FROM logs AS Log \n" +
            "LEFT JOIN step_attributes AS StepAttribute ON (\n" +
            "StepAttribute.id = Log.assigned_to\n" +
            ")\n" +
            "LEFT JOIN custom_fields AS CustomField ON (\n" +
            "       CustomField.id = StepAttribute.custom_field_id\n" +
            ")\n" +
            "LEFT JOIN assigned_step_resources AS AssignedStepResource ON \n" +
            "    (\n" +
            "        Log.assigned_checklist_uuid = AssignedStepResource.assigned_checklist_uuid \n" +
            "            AND \n" +
            "        Log.action = '7' \n" +
            "            AND \n" +
            "        (\n" +
            "            (Log.step_action = AssignedStepResource.uuid) \n" +
            "                OR \n" +
            "            (Log.step_action = AssignedStepResource.file_name)\n" +
            "        )\n" +
            "    ) \n" +
            "WHERE \n" +
            "Log.assigned_checklist_uuid = :checklistUUID \n" +
            "AND Log.checklist_element_id IS NOT NULL \n" +
            "AND Log.action != '19' \n" +
            "ORDER BY Log.checklist_element_id ASC, Log.created DESC,\n" +
            "CASE\n" +
            "    WHEN action = 0 THEN 0 \n" +
            "    WHEN action = 1 THEN 1\n" +
            "    WHEN action = 4 THEN 2\n" +
            "    WHEN action = 5 THEN 3\n" +
            "    WHEN action = 12 THEN 4\n" +
            "    WHEN action = 13 THEN 5\n" +
            "    WHEN action = 15 THEN 6\n" +
            "    WHEN action = 17 THEN 7\n" +
            "    WHEN action = 18 THEN 8\n" +
            "    WHEN action = 6 THEN 9\n" +
            "    WHEN action = 7 THEN 10\n" +
            "    WHEN action = 8 THEN 11\n" +
            "END ASC";
}
