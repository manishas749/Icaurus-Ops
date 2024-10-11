package com.icarus.database;


public class Queries {
    public static final String GET_CLIENT_SETTINGS = "SELECT name, value FROM client_settings";

    public static final String GET_ALL_CHECKLIST_ADMIN = "SELECT DISTINCT Checklist.id," +
            "  Checklist.uuid," +
            "  ChecklistTitle.title, \n" +
            "  Checklist.checklist_type_id, \n" +
            "  Checklist.pending_resources_count, \n" +
            "  Checklist.pending_references_count, \n" +
            "  Checklist.sync_status, \n" +
            "  Checklist.department_id, \n" +
            "  Departments.name as departmentName," +
            "  Checklist.is_sequential, \n" +
            "  Checklist.is_approval_required, \n" +
            "  ChecklistStatus.name AS checkliststatus_name, \n" +
            "  ChecklistStatus.is_expired AS checkliststatus_is_expired, \n" +
            "  Ifnull(\n" +
            "    ChecklistExecutionPermission.is_assignable, \n" +
            "    0\n" +
            "  ) AS is_assignable, \n" +
            "  Ifnull(\n" +
            "    ChecklistExecutionPermission.is_executable, \n" +
            "    0\n" +
            "  ) AS is_executable, \n" +
            "  Checklist.due_at, \n" +
            "  Checklist.modified, \n" +
            " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite," +
            "  Checklist.checklist_placeholder_count \n" +
            "FROM \n" +
            "  checklists AS Checklist \n" +
            "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n" +
            "    ChecklistTitle.checklist_id = Checklist.id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n" +
            "    ChecklistStatus.id = Checklist.checklist_status_id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_types AS ChecklistType ON(\n" +
            "    ChecklistType.id = Checklist.checklist_type_id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n" +
            "    ChecklistLocation.checklist_id = Checklist.id\n" +
            "  ) \n" +
            "  LEFT JOIN checklists AS NextChecklist ON(\n" +
            "    Checklist.id = NextChecklist.parent_id\n" +
            "  ) \n" +
            "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n" +
            "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n" +
            "  ) \n" +
            "  LEFT JOIN departments AS Departments ON(\n" +
            "    Departments.id = Checklist.department_id \n" +
            "  ) \n" +
            "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n" +
            "    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n" +
            "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n" +
            "  ) \n" +
            "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "  UserFavorite.checklist_id = Checklist.id \n" +
            "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = :udid" +
            ") " +
            "WHERE \n" +
            "  Checklist.is_deleted = 0 \n" +
            "  AND Checklist.is_template = 0 \n" +
            "  AND ChecklistStatus.is_closed = 1 \n" +
            "  AND ChecklistType.type IN (1, 2) \n" +
            "  AND ChecklistLocation.location_id = :locationid" +
            "  AND ChecklistLocation.is_deleted = 0 \n" +
            "  AND (\n" +
            "    NextChecklist.modified = (\n" +
            "      SELECT \n" +
            "        Max(modified) \n" +
            "      FROM \n" +
            "        checklists \n" +
            "      WHERE \n" +
            "        parent_id = Checklist.id\n" +
            "    ) \n" +
            "    OR NextChecklist.modified IS NULL\n" +
            "  ) \n" +
            "  AND (\n" +
            "    NextChecklistStatus.is_closed = 0 \n" +
            "    OR NextChecklistStatus.is_closed IS NULL\n" +
            "  )" +
            "AND (ChecklistTitle.title like :keyword)";

    public static final String GET_CHECK_LIST = "SELECT \n" +
            "  DISTINCT Checklist.id, \n" +
            "  Checklist.uuid, \n" +
            "  ChecklistTitle.title, \n" +
            "  Checklist.pending_resources_count, \n" +
            "  Checklist.pending_references_count, \n" +
            "  Checklist.sync_status, \n" +
            "  Checklist.checklist_type_id, \n" +
            "  Checklist.department_id, \n" +
            "  Departments.name as departmentName," +
            "  Checklist.is_sequential, \n" +
            "  Checklist.is_approval_required, \n" +
            "  ChecklistStatus.name as checkliststatus_name, \n" +
            "  ChecklistStatus.is_expired as checkliststatus_is_expired, \n" +
            "  ifnull(\n" +
            "    ChecklistExecutionPermission.is_assignable, \n" +
            "    0\n" +
            "  ) AS is_assignable, \n" +
            "  ifnull(\n" +
            "    ChecklistExecutionPermission.is_executable, \n" +
            "    0\n" +
            "  ) AS is_executable, \n" +
            "  Checklist.due_at, \n" +
            "  Checklist.modified, \n" +
            " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite," +
            "  Checklist.checklist_placeholder_count \n" +
            "FROM \n" +
            "  checklists AS Checklist \n" +
            "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n" +
            "    ChecklistTitle.checklist_id = Checklist.id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n" +
            "    ChecklistStatus.id = Checklist.checklist_status_id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_types AS ChecklistType ON(\n" +
            "    ChecklistType.id = Checklist.checklist_type_id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n" +
            "    ChecklistLocation.checklist_id = Checklist.id\n" +
            "  ) \n" +
            "  LEFT JOIN departments AS Departments ON(\n" +
            "    Departments.id = Checklist.department_id \n" +
            "  ) \n" +
            "  LEFT JOIN checklists AS NextChecklist ON(\n" +
            "    Checklist.id = NextChecklist.parent_id\n" +
            "  ) \n" +
            "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n" +
            "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n" +
            "  ) \n" +
            "  LEFT JOIN user_location_departments AS UserLocationDepartment ON(\n" +
            "    UserLocationDepartment.department_id = Checklist.department_id \n" +
            "    AND UserLocationDepartment.location_id = ChecklistLocation.location_id \n" +
            "    AND UserLocationDepartment.is_deleted = 0\n" +
            "  ) \n" +
            "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n" +
            "    ChecklistExecutionPermission.group_id = \n" + ":groupID" +
            "    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n" +
            "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n" +
            "  ) \n" +
            "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "  UserFavorite.checklist_id = Checklist.id \n" +
            "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = " + ":udid" +
            ") " +
            "WHERE \n" +
            "  Checklist.is_deleted = 0 \n" +
            "  AND Checklist.is_template = 0 \n" +
            "  AND ChecklistStatus.is_closed = 1 \n" +
            "  AND ChecklistType.type IN (1, 2) \n" +
            "  AND ChecklistLocation.location_id = \n" + ":locationid" +
            "  AND ChecklistLocation.is_deleted = 0 \n" +
            "  AND (\n" +
            "    NextChecklist.modified =(\n" +
            "      SELECT \n" +
            "        max(modified) \n" +
            "      FROM \n" +
            "        checklists \n" +
            "      WHERE \n" +
            "        parent_id = Checklist.id\n" +
            "    ) \n" +
            "    OR NextChecklist.modified IS NULL\n" +
            "  ) \n" +
            "  AND (\n" +
            "    NextChecklistStatus.is_closed = 0 \n" +
            "    OR NextChecklistStatus.is_closed IS NULL\n" +
            "  ) \n" +
            "  AND (\n" +
            "    Checklist.department_id = 0 \n" +
            "    OR UserLocationDepartment.user_id = \n" + ":udid" +
            "  )" +
            " AND (ChecklistTitle.title like :keyword) \n";


    public static final String GET_CHECK_LIST_SEARCH = "SELECT \n" +
            "  DISTINCT Checklist.id, \n" +
            "  Checklist.uuid, \n" +
            "  ChecklistTitle.title, \n" +
            "  Checklist.checklist_type_id, \n" +
            "  Checklist.department_id, \n" +
            "  Checklist.is_sequential, \n" +
            "  Checklist.is_approval_required, \n" +
            "  ChecklistStatus.name as checkliststatus_name, \n" +
            "  ChecklistStatus.is_expired as checkliststatus_is_expired, \n" +
            "  ifnull(\n" +
            "    ChecklistExecutionPermission.is_assignable, \n" +
            "    0\n" +
            "  ) AS is_assignable, \n" +
            "  ifnull(\n" +
            "    ChecklistExecutionPermission.is_executable, \n" +
            "    0\n" +
            "  ) AS is_executable, \n" +
            "  Checklist.due_at, \n" +
            "  Checklist.modified, \n" +
            " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite," +
            "  Checklist.checklist_placeholder_count \n" +
            "FROM \n" +
            "  checklists AS Checklist \n" +
            "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n" +
            "    ChecklistTitle.checklist_id = Checklist.id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n" +
            "    ChecklistStatus.id = Checklist.checklist_status_id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_types AS ChecklistType ON(\n" +
            "    ChecklistType.id = Checklist.checklist_type_id\n" +
            "  ) \n" +
            "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n" +
            "    ChecklistLocation.checklist_id = Checklist.id\n" +
            "  ) \n" +
            "  LEFT JOIN checklists AS NextChecklist ON(\n" +
            "    Checklist.id = NextChecklist.parent_id\n" +
            "  ) \n" +
            "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n" +
            "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n" +
            "  ) \n" +
            "  LEFT JOIN user_location_departments AS UserLocationDepartment ON(\n" +
            "    UserLocationDepartment.department_id = Checklist.department_id \n" +
            "    AND UserLocationDepartment.location_id = ChecklistLocation.location_id \n" +
            "    AND UserLocationDepartment.is_deleted = 0\n" +
            "  ) \n" +
            "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n" +
            "    ChecklistExecutionPermission.group_id = \n" + ":groupID" +
            "    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n" +
            "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n" +
            "  ) \n" +
            "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "  UserFavorite.checklist_id = Checklist.id \n" +
            "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = " + ":udid" +
            ") " +
            "WHERE \n" +
            "  Checklist.is_deleted = 0 \n" +
            "  AND Checklist.is_template = 0 \n" +
            "  AND ChecklistStatus.is_closed = 1 \n" +
            "  AND ChecklistType.type IN (1, 2) \n" +
            "  AND ChecklistLocation.location_id = \n" + ":locationid" +
            "  AND ChecklistLocation.is_deleted = 0 \n" +
            "  AND (\n" +
            "    NextChecklist.modified =(\n" +
            "      SELECT \n" +
            "        max(modified) \n" +
            "      FROM \n" +
            "        checklists \n" +
            "      WHERE \n" +
            "        parent_id = Checklist.id\n" +
            "    ) \n" +
            "    OR NextChecklist.modified IS NULL\n" +
            "  ) \n" +
            "  AND (\n" +
            "    NextChecklistStatus.is_closed = 0 \n" +
            "    OR NextChecklistStatus.is_closed IS NULL\n" +
            "  ) \n" +
            "  AND (\n" +
            "    Checklist.department_id = 0 \n" +
            "    OR UserLocationDepartment.user_id = \n" + ":udid" +
            "  ) " +
            " AND ChecklistTitle.title like :keyword ";


    public static final String CHECKLISTCLAUSE = " AND Checklist.checklist_type_id IN (:type)";
    public static final String CHECKLISTORDERBY = "ORDER BY\n" +
            "\t:orderby";

    public static final String CHECKLIST_ORDERBY_NAME = " ORDER BY lower(ChecklistTitle.title) ASC ";
    public static final String CHECKLIST_ORDERBY_DUE_DATE = " ORDER BY AssignedChecklist.due_date ASC ";
    public static final String CHECKLIST_ORDERBY_MODIFIED = " ORDER BY Checklist.modified  ASC ";
    public static final String CHECKLIST_ORDERBY_CHECKLIST_STATUS = " ORDER BY checklistStatus ASC ";
    public static final String CHECKLIST_ORDERBY_LAST_UPDATE = " ORDER BY assigned_checklists.modified ASC ";
    public static final String CHECKLIST_ORDERBY_LAST_UPDATED = " ORDER BY AssignedChecklist.modified ASC ";

    public static final String CHECKLIST_ORDERBY_FAV = " ORDER BY is_favorite DESC, Checklist.modified DESC ";

    public static final String CHECKLIST_ORDERBY_NAME_DESC = " ORDER BY lower(ChecklistTitle.title) DESC ";
    public static final String CHECKLIST_ORDERBY_DUE_DATE_DESC = " ORDER BY AssignedChecklist.due_date DESC ";
    public static final String CHECKLIST_ORDERBY_MODIFIED_DESC = " ORDER BY Checklist.modified DESC ";
    public static final String CHECKLIST_ORDERBY_CHECKLIST_STATUS_DESC = " ORDER BY checklistStatus DESC ";
    public static final String CHECKLIST_ORDERBY_LAST_UPDATE_DESC = " ORDER BY assigned_checklists.modified DESC ";
    public static final String CHECKLIST_ORDERBY_LAST_UPDATED_DESC = " ORDER BY AssignedChecklist.modified DESC ";

    public static final String GET_USER_DEPARTMENT_FILTER = "SELECT DISTINCT\n" +
            "  departments.id,\n" +
            "  departments.name,\n" +
            "  departments.short_name\n" +
            "FROM\n" +

            "  departments\n" +
            "INNER JOIN user_location_departments ON departments.id = user_location_departments.department_id\n" +
            "WHERE\n" +
            "  departments.is_deleted = 0 AND\n" +
            "  user_location_departments.is_deleted = 0 AND\n" +
            "  user_location_departments.user_id = :userId AND\n" +
            "  user_location_departments.location_id = :locationId";
    public static final String GET_LOCATION_DEPARTMENT_FILTER = "SELECT DISTINCT\n" +
            "  departments.id,\n" +
            "  departments.name,\n" +
            "  departments.short_name\n" +
            "FROM\n" +

            "  departments\n" +
            "INNER JOIN location_departments ON departments.id = location_departments.department_id\n" +
            "WHERE\n" +
            "  departments.is_deleted = 0 AND\n" +
            "  location_departments.is_deleted = 0 AND\n" +
            "  location_departments.location_id = :locationId";


    public static final String GET_USER_DEPARTMENT_ID_LIST = "SELECT DISTINCT\n" +
            "  departments.id\n" +
            "FROM\n" +
            "  departments\n" +
            "INNER JOIN user_location_departments ON departments.id = user_location_departments.department_id\n" +
            "WHERE\n" +
            "  departments.is_deleted = 0 AND\n" +
            "  user_location_departments.is_deleted = 0 AND\n" +
            "  user_location_departments.user_id = :userId AND\n" +
            "  user_location_departments.location_id = :locationId";

    public static final String GET_LOCATION_DEPARTMENT_ID_LIST = "SELECT DISTINCT\n" +
            "  departments.id\n" +
            "FROM\n" +
            "  departments\n" +
            "INNER JOIN location_departments ON departments.id = location_departments.department_id\n" +
            "WHERE\n" +
            "  departments.is_deleted = 0 AND\n" +
            "  location_departments.is_deleted = 0 AND\n" +
            "  location_departments.location_id = :locationId";

    public static final String CHECKLIST_USER = "SELECT\n" +
            "\tChecklist.id,\n" +
            "\tAssignedChecklist.uuid,\n" +
            "  Checklist.sync_status, \n" +
            "  AssignedChecklist.execution_status, \n" +
            "\tAssignedChecklist.checklist_status AS status,\n" +
            "  Checklist.pending_resources_count, \n" +
            "  Checklist.pending_references_count, \n" +
            " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite," +
            "\tChecklistType.type,\n" +
            "\tChecklist.is_sequential,\n" +
            "\tChecklistTitle.title,\n" +
            "\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,\n" +
            "\tRoom.name AS room,\n" +
            "\tEquipment.name AS equipment,\n" +
            "\tAssignedChecklist.started_by_user_id, \n" +
            "\tAssignedChecklist.due_date AS due_at,\n" +
            "\tAssignedChecklist.assigned_at,\n" +
            "\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,\n" +
            "\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,\n" +
            "\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,\n" +
            "\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,\n" +
            "\tAssignedChecklist.modified AS updated_at\n" +
            "FROM\n" +
            "\tassigned_checklists AS AssignedChecklist\n" +
            "\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )\n" +
            "\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )\n" +
            "\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n" +
            "\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )\n" +
            "\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )\n" +
            "\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )\n" +
            "\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )\n" +
            "\tLEFT JOIN assigned_departments AS AssignedDepartment ON (\n" +
            "\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND AssignedDepartment.is_deleted = 0 \n" +
            "\t)\n" +
            "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "  UserFavorite.checklist_id = Checklist.id \n" +
            "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = " + ":userId" +
            ") " +
            "\tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )\n";

    public static final String GET_MY_ASSIGNED_CHECKLIST_SEARCH = "SELECT DISTINCT\n" +
            "    assigned_checklists.uuid,\n" +
            "    assigned_checklists.checklist_id,\n" +
            "    checklist_titles.title,\n" +
            "    IFNULL( rooms.name || ' / ' || equipments.name, '' ) AS roomEquipment,\n" +
            "    CAST (( JULIANDAY( DATE( assigned_checklists.due_date )) - JULIANDAY( DATE( CURRENT_DATE )) ) AS Integer ) AS dueDays,\n" +
            "CASE\n" +
            "    WHEN assigned_checklists.checklist_status = 0 \n" +
            "    AND ( started_by_user_id = 0 OR started_by_user_id IS NULL ) THEN\n" +
            "    'New' \n" +
            "        WHEN assigned_checklists.checklist_status = 0 THEN\n" +
            "        'In Progress' \n" +
            "        WHEN assigned_checklists.checklist_status = 4 THEN\n" +
            "        'Paused' \n" +
            "        END AS checklistStatus,\n" +
            "         checklists.checklist_type_id as checklistType\n" +
            "FROM\n" +
            "    assigned_checklists\n" +
            "    INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id\n" +
            "    INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id\n" +
            "    INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid\n" +
            "    INNER JOIN users ON assigned_checklists.user_id = users.id\n" +
            "    LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid\n" +
            "    LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id\n" +
            "    LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id \n" +
            "WHERE\n" +
            "    assigned_users.user_id = :userId" +
            "  AND assigned_checklists.location_id = \n" + ":locationId" +
            "    AND assigned_users.is_deleted = 0 \n" +
            "    AND assigned_checklists.checklist_status IN ( 0, 4 ) \n" +
            "    AND assigned_checklists.is_Deleted = 0 \n" +
            "    AND assigned_checklists.assignee_type = \n" + ":assignType" +
            "  AND (checklist_titles.title like :keyword OR  rooms.name like :keyword OR equipments.name like :keyword)";

    public static final String CHECKLIST_USER_CLAUSE = " AND users.id IN (:users)";

    public static final String GET_CANCELLED_COMPLETED_CHECKLIST = "SELECT DISTINCT\n" +
            "   assigned_checklists.uuid,\n" +
            "   assigned_checklists.checklist_id,\n" +
            "   assigned_checklists.modified,\n" +
            "   checklist_titles.title,\n" +
            "   checklists.pending_resources_count as pendingResourcesCount, \n" +
            "   checklists.pending_references_count as pendingReferencesCount, \n" +
            "   assigned_checklists.execution_status as assigned_sync_status, \n" +
            "   checklists.sync_status as checklist_sync_status, \n" +
            "   users.full_name AS last_updated_by,\n " +
            "   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,\n" +
            "   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,\n" +
            "   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite," +
            "   checklists.checklist_type_id as checklist_type\n" +
            "FROM\n" +
            "   assigned_checklists\n" +
            "   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id\n" +
            "   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id\n" +
            "   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid\n" +
            "   INNER JOIN users ON assigned_checklists.user_id = users.id\n" +
            "   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid\n" +
            "   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id\n" +
            "   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id \n" +
            "   LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "       UserFavorite.checklist_id = checklists.id \n" +
            "       AND UserFavorite.is_deleted = 0 " +
            "       AND UserFavorite.user_id = :userId " +
            "   )\n" +
            "WHERE\n" +
            "   assigned_users.user_id = :userId " +
            "   AND assigned_checklists.location_id = :locationId \n" +
            "   AND assigned_users.is_deleted = 0 \n" +
            "   AND assigned_checklists.checklist_status = :checklistStatus \n" +
            "   AND assigned_checklists.is_deleted = 0 \n" +
            "   AND assigned_checklists.assignee_type = :assignType \n" +
            "   AND (checklist_titles.title like :keyword OR  rooms.name like :keyword OR equipments.name like :keyword) ";

    public static final String GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN = "SELECT DISTINCT\n" +
            "   assigned_checklists.uuid,\n" +
            "   assigned_checklists.checklist_id,\n" +
            "   assigned_checklists.modified,\n" +
            "   checklist_titles.title,\n" +
            "   users.full_name AS last_updated_by,\n " +
            "   checklists.pending_resources_count as pendingResourcesCount, \n" +
            "   checklists.pending_references_count as pendingReferencesCount, \n" +
            "   assigned_checklists.execution_status as assigned_sync_status, \n" +
            "   checklists.sync_status as checklist_sync_status, \n" +
            "   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite," +
            "   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,\n" +
            "   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,\n" +
            "   checklists.checklist_type_id as checklist_type\n" +
            "FROM\n" +
            "   assigned_checklists\n" +
            "   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id\n" +
            "   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id\n" +
            "   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid\n" +
            "   INNER JOIN users ON assigned_checklists.user_id = users.id\n" +
            "   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid\n" +
            "   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id\n" +
            "   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id \n" +
            "   LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "       UserFavorite.checklist_id = checklists.id " +
            "       AND UserFavorite.is_deleted = 0 " +
            "       AND UserFavorite.user_id = :userId " +
            "   ) \n" +
            "WHERE\n" +
            "    assigned_checklists.location_id = :locationId \n" +
            "AND assigned_users.is_deleted = 0 \n" +
            "AND assigned_checklists.checklist_status = :checklistStatus \n" +
            "AND assigned_checklists.is_deleted = 0 \n" +
            "AND assigned_checklists.assignee_type = :assignType \n" +
            "AND (checklist_titles.title like :keyword OR  rooms.name like :keyword OR equipments.name like :keyword) \n";


    public static final String CHECKLIST_STAUTUS_CLAUSE_MY_ASSIGNED = " AND assigned_checklists.checklist_status IN (:status)";
    public static final String ASSIGNED_CHECKLIST_TYPE_CLAUSE = " AND checklists.checklist_type_id IN (:type)";
    public static final String ASSIGNED_DEPARTMENT_CLAUSE = " AND assigned_checklists.department_id IN (:department)";

    public static final String USER_ASSIGNED_USER_JOIN = "\tLEFT JOIN assigned_users AS AssignedUser ON (\n" +
            "\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND AssignedUser.is_deleted = 0 \n" +
            "\t)\n";
    public static final String USER_DEFAULT_CLAUSE = "WHERE\n" +
            "\tAssignedChecklist.assignee_type = 1 \n" +
            "\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) \n" +
            "\tAND AssignedChecklist.location_id = :locationId \n" +
            "\tAND AssignedChecklist.is_deleted = 0 \n" +
            "\tAND (ChecklistTitle.title LIKE :keyword OR  Room.name LIKE :keyword OR Equipment.name LIKE :keyword) \n";
    public static final String USER_USER_ID_CLAUSE = "\tAND AssignedUser.user_id = :userId \n";
    public static final String USER_ORDER_BY = "ORDER BY\n" +
            "\t:orderBy";

    public static final String DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN = "\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (\n" +
            "\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id \n" +
            "\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id \n" +
            "\t\tAND UserLocationDepartment.is_deleted = 0 \n" +
            "\t) \n";
    public static final String DEPARTMENT_LOCATION_DEPARTMENT_JOIN = "\tLEFT JOIN location_departments AS LocationDepartment ON (\n" +
            "\t\tLocationDepartment.location_id = AssignedChecklist.location_id \n" +
            "\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id \n" +
            "\t\tAND LocationDepartment.is_deleted = 0 \n" +
            "\t) \n";
    public static final String DEPARTMENT_DEFAULT_CLAUSE = "WHERE\n" +
            "\tAssignedChecklist.assignee_type = 2 \n" +
            "\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) \n" +
            "\tAND AssignedChecklist.location_id = :locationId \n" +
            "\tAND AssignedChecklist.is_deleted = 0 \n" +
            "\tAND (ChecklistTitle.title LIKE :keyword OR  Room.name LIKE :keyword OR Equipment.name LIKE :keyword) \n";
    public static final String DEPARTMENT_CHECKLIST_STATUS_CLAUSE = "\tAND checklistStatus IN( :status) \n";
    public static final String DEPARTMENT_CHECKLIST_TYPE_CLAUSE = "\tAND ChecklistType.type IN( :type) \n";

    public static final String DEPARTMENT_DEPARTMENT_NAME_CLAUSE = "\tAND Department.id IN( :department) \n";
    public static final String MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE = "\tAND AssignedChecklist.department_id IN( :department) \n";

    public static final String DEPARTMENT_USER_ID_CLAUSE = "\tAND UserLocationDepartment.user_id = :userId \n";
    public final static String CHECKLIST_DEPARTMENT = "SELECT\n" +
            "\tChecklist.id,\n" +
            "  Checklist.sync_status, \n" +
            "  AssignedChecklist.execution_status, \n" +
            "  Checklist.pending_resources_count, \n" +
            "  Checklist.pending_references_count, \n" +
            " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite," +
            "\tAssignedChecklist.uuid,\n" +
            "\tAssignedChecklist.checklist_status AS status,\n" +
            "\tChecklistType.type AS type,\n" +
            "\tChecklist.is_sequential,\n" +
            "\tChecklistTitle.title,\n" +
            "\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,\n" +
            "\tRoom.name AS room,\n" +
            "\tEquipment.name AS equipment,\n" +
            "\tAuthor.full_name AS author,\n" +
            "\tDepartment.name AS assignee,\n" +
            "\tAssignedChecklist.started_by_user_id, \n" +
            "\tAssignedChecklist.due_date AS due_at,\n" +
            "\tAssignedChecklist.assigned_at,\n" +
            "\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,\n" +
            "\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,\n" +
            "\tAssignedChecklist.modified AS updated_at\n" +
            "FROM\n" +
            "\tassigned_checklists AS AssignedChecklist\n" +
            "\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )\n" +
            "\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )\n" +
            "\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n" +
            "\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )\n" +
            "\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )\n" +
            "\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )\n" +
            "\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )\n" +
            "\tLEFT JOIN assigned_departments AS AssignedDepartment ON (\n" +
            "\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND AssignedDepartment.is_deleted = 0 \n" +
            "\t)\n" +
            "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "  UserFavorite.checklist_id = Checklist.id \n" +
            "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = " + ":userId" +
            ") " +
            "\tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )\n";

    public static final String GET_ROOM_ASSETS = "SELECT rooms.id AS room_id,\n       " +
            "equipments.id AS equipment_id,\n       " +
            "rooms.name AS room,\n      " +
            " equipments.name AS asset,\n       " +
            "rooms.name || ' / ' || equipments.name AS room_asset\n " +
            "FROM checklist_room_equipments\n " +
            "LEFT JOIN checklist_locations " +
            "ON " +
            "checklist_locations.id = checklist_room_equipments.checklist_location_id\n " +
            "LEFT JOIN rooms ON rooms.id = checklist_room_equipments.room_id\n " +
            "LEFT JOIN equipments ON equipments.id = checklist_room_equipments.equipment_id\n " +
            "WHERE checklist_locations.checklist_id = :checklistId  " +
            "AND checklist_locations.location_id =  " +
            " :locationId " + "  AND checklist_room_equipments.is_deleted = 0\n" + "  " +
            "AND checklist_locations.is_deleted = 0\n" + "  AND rooms.is_deleted = 0\n" + "  " +
            "AND equipments.is_deleted = 0\n" + " ORDER BY rooms.name, equipments.name";


    public static final String GET_USERS_DEPARTMENT = "SELECT users.id as id,\n" + "       users.uuid as uuid,\n" + "       users.full_name as full_name,\n" + "       users.group_id as group_id\n" + " FROM users\n" + " WHERE users.group_id = 2\n" + " UNION\n" + " SELECT users.id,\n" + "       users.uuid,\n" + "       users.full_name,\n" + "       users.group_id\n" + " FROM users\n" + " INNER JOIN user_location_departments ON user_location_departments.user_id = users.id\n" + " WHERE users.is_deleted = 0\n" + "    AND user_location_departments.is_deleted = 0\n" + "    AND user_location_departments.location_id = " + ":locationId" + "    AND user_location_departments.department_id = " + ":departmentId" + "    AND users.group_id NOT IN (1,7)\n" + " ORDER BY users.full_name ASC";


    public static final String GET_USERS = "SELECT users.id as id,\n" + "       users.uuid as uuid,\n" + "       users.full_name as full_name,\n" + "       " +
            "users.group_id as group_id\n" + " FROM users\n" + " WHERE users.group_id = 2\n" + " UNION\n" + " SELECT users.id,\n" + "       users.uuid,\n" + "       " +
            "users.full_name,\n" + "       users.group_id\n" + " FROM users\n" + " INNER JOIN user_location_departments ON user_location_departments.user_id = users.id\n" +
            " WHERE users.is_deleted = 0\n" + "    AND user_location_departments.is_deleted = 0\n" + "    AND user_location_departments.location_id = " +
            ":locationId" + "    AND users.group_id NOT IN (1,7)\n" + " ORDER BY users.full_name ASC";


    public static final String GET_USER_FILTER = "SELECT users.id as id,\n" +
            "       users.full_name as name\n" +
            " FROM users\n" +
            " WHERE users.group_id = 2\n" +
            " UNION\n" +
            " SELECT users.id as id,\n" +
            "       users.full_name as name\n" +
            " FROM users\n" +
            " INNER JOIN user_location_departments ON user_location_departments.user_id = users.id\n" +
            " WHERE users.is_deleted = 0\n" +
            "    AND user_location_departments.is_deleted = 0\n" +
            "    AND user_location_departments.location_id = :locationId" +
            "    AND users.group_id NOT IN (1,7)\n" +
            " ORDER BY name ASC";

    public static final String IS_ASSIGNED_USER_EXISTS = "SELECT COUNT(user_id) FROM assigned_users WHERE assigned_checklist_uuid = :assignedUuid AND user_id = :userId AND is_deleted = 0";
    public static final String GET_LOCATIONS_ADMIN = "SELECT \n" +
            "  DISTINCT locations.id, \n" +
            "  locations.name, \n" +
            "  locations.timezone, \n" +
            "  locations.last_sync_time \n" +
            "FROM \n" +
            "  locations";

    public static final String GET_LOCATIONS = "SELECT  \n" +
            "  DISTINCT locations.id, \n" +
            "  locations.name, \n" +
            "  locations.timezone, \n" +
            "  locations.last_sync_time \n" +
            "FROM \n" +
            "  locations \n" +
            "  INNER JOIN user_location_departments ON user_location_departments.location_id = locations.id \n" +
            "WHERE \n" +
            "  user_location_departments.user_id = :userId  and user_location_departments.is_deleted = 0";

    public static final String GET_LOCATION = "SELECT * FROM locations WHERE id = :id";


    public static final String GET_CHECKLIST_DETAIL = "WITH RECURSIVE elements(id, parent_id, checklist_id, item_id, item_type_id, item_uuid, title, description, sequence_no, status, sort_order, rootid, level) AS (\n" +
            "        SELECT\n" +
            "            checklist_elements.id,\n" +
            "            checklist_elements.parent_id,\n" +
            "            checklist_elements.checklist_id,\n" +
            "            checklist_elements.item_id,\n" +
            "            checklist_elements.item_type_id,\n" +
            "            checklist_elements.item_uuid,\n" +
            "            checklist_elements.title,\n" +
            "            checklist_elements.description,\n" +
            "            checklist_elements.sequence_no,\n" +
            "            COALESCE(assigned_steps.status, assigned_decisions.status, assigned_ncw.acknowledged, " +
            "(SELECT \"action\" FROM logs WHERE checklist_element_id = checklist_elements.id " +
            "AND checklist_elements.item_type_id IN ( 7, 10 ) AND \"action\" IN ( 17, 18, 12, 13)" +
            " AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1)) AS status,\n" +
            "            checklist_elements.sort_order,\n" +
            "            checklist_elements.id AS rootid,\n" +
            "            0 AS level\n" +
            "        FROM checklist_elements\n" +
            "        LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = :checkListUuid)\n" +
            "        LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid)\n" +
            "        LEFT JOIN assigned_ncw ON (assigned_ncw.checklist_element_id = checklist_elements.id AND assigned_ncw.is_deleted = 0 AND assigned_ncw.assigned_checklist_uuid = :checkListUuid)\n" +
            "        WHERE\n" +
            "            checklist_elements.checklist_id = :checkListId\n" +
            "        AND checklist_elements.is_deleted = 0\n" +
            "        AND checklist_elements.item_type_id NOT IN ( 9 )\n" +
            "            UNION ALL\n" +
            "        SELECT \n" +
            "            checklist_elements.id,\n" +
            "            checklist_elements.parent_id,\n" +
            "            checklist_elements.checklist_id,\n" +
            "            checklist_elements.item_id,\n" +
            "            checklist_elements.item_type_id,\n" +
            "            checklist_elements.item_uuid,\n" +
            "            checklist_elements.title,\n" +
            "            checklist_elements.description,\n" +
            "            checklist_elements.sequence_no,\n" +
            "            COALESCE(assigned_steps.status, assigned_decisions.status) AS status,\n" +
            "            checklist_elements.sort_order,\n" +
            "            elements.rootid,\n" +
            "            level + 1 AS level\n" +
            "        FROM checklist_elements, elements\n" +
            "        LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = :checkListUuid)\n" +
            "        LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid)\n" +
            "        WHERE checklist_elements.id = elements.parent_id\n" +
            ")\n" +
            "SELECT\n" +
            "    id, parent_id, elements.checklist_id, item_id, item_type_id, elements.item_uuid,\n" +
            "    IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.item_description, elements.title) ELSE elements.title END, '') AS title,\n" +
            "    IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.step_action, elements.description) ELSE COALESCE(placeholders_text.item_description, elements.description) END, '') AS description,\n" +
            "    sequence_no, status, sort_order,\n" +
            "    (SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = elements.item_id AND elements.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon,\n" +
            "    (SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = elements.item_id AND ncw_hazards.item_type_id = elements.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon,\n" +
            "    rootid, level,\n" +
            "    SUM(CASE WHEN rootid != id THEN 1 ELSE 0 END) AS total_parents,\n" +
            "    SUM(CASE WHEN rootid != id AND ( ( item_type_id = 2 AND status = 1 ) OR ( item_type_id != 2 AND ( status IN ( 0, 1 ) OR status IS NULL) ) ) THEN 1 ELSE 0 END) AS total_executed_parents,\n" +
            "    SUM(CASE WHEN level = 1 AND item_type_id IN (1, 8, 12) THEN 1 ELSE 0 END) AS has_step_parent\n" +
            "FROM elements\n" +
            "LEFT JOIN logs AS placeholders_text ON ( placeholders_text.checklist_element_id = elements.id AND placeholders_text.\"action\" = 19 AND placeholders_text.assigned_checklist_uuid = :checkListUuid)\n" +
            "GROUP BY rootid\n" +
            "HAVING total_parents = total_executed_parents AND MIN(level) = 0\n" +
            "ORDER BY sort_order";

    public static final String GET_CHECKLIST_INCOMPLETE_ELEMENTS = "SELECT\n" +
            "ChecklistElement.checklist_id,\n" +
            "ChecklistElement.id,\n" +
            "ChecklistElement.item_type_id,\n" +
            "ChecklistElement.item_id,\n" +
            "ChecklistElement.item_uuid,\n" +
            "ChecklistElement.parent_id,\n" +
            "ParentElement.item_type_id AS parent_type,\n" +
            "ParentStep.status AS parent_status,\n" +
            "ChecklistElement.sort_order,\n" +
            "ChecklistElement.sequence_no,\n" +
            "IFNULL(CASE WHEN ChecklistElement.item_type_id IN ( 1, 8, 12,10 ) THEN\n" +
            "coalesce(PlaceholderText.item_description, ChecklistElement.title) ELSE COALESCE(EmbeddedImage.file_md5_checksum, ChecklistElement.title)\n" +
            "END, '') AS title,\n" +
            "IFNULL(CASE WHEN ChecklistElement.item_type_id IN ( 1, 8, 12,10 ) THEN\n" +
            "coalesce(PlaceholderText.step_action, ChecklistElement.description) ELSE coalesce(PlaceholderText.item_description, ChecklistElement.description)\n" +
            "END, '') AS description,\n" +
            "AssignedNCW.acknowledged,\n" +
            "AssignedStep.status,\n" +
            "AssignedDecision.status AS decisionStatus,\n" +
            "(SELECT action FROM logs WHERE checklist_element_id = ChecklistElement.id AND ChecklistElement.item_type_id IN ( 7, 10 ) AND action IN (12,13,17,18) AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1) AS imageTextStatus,\n" +
            "(SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = ChecklistElement.item_id AND ChecklistElement.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon,\n" +
            "(SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = ChecklistElement.item_id AND ncw_hazards.item_type_id = ChecklistElement.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon\n" +
            "FROM\n" +
            "checklist_elements AS ChecklistElement\n" +
            "LEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = ChecklistElement.parent_id)\n" +
            "LEFT JOIN resources AS EmbeddedImage ON (EmbeddedImage.id = ChecklistElement.item_id AND ChecklistElement.item_type_id = 10 AND EmbeddedImage.is_resource = 1)\n" +
            "\n" +
            "LEFT JOIN assigned_ncw AS AssignedNCW ON ( AssignedNCW.checklist_element_id = ChecklistElement.id AND AssignedNCW.assigned_checklist_uuid = :checkListUuid AND AssignedNCW.is_deleted = 0 )\n" +
            "LEFT JOIN assigned_steps AS AssignedStep ON ( AssignedStep.checklist_element_id = ChecklistElement.id AND AssignedStep.assigned_checklist_uuid = :checkListUuid AND AssignedStep.is_deleted = 0 )\n" +
            "LEFT JOIN assigned_decisions AS AssignedDecision ON ( AssignedDecision.checklist_element_id = ChecklistElement.id AND AssignedDecision.assigned_checklist_uuid = :checkListUuid AND AssignedDecision.is_deleted = 0 )\n" +
            "LEFT JOIN logs AS PlaceholderText ON ( PlaceholderText.checklist_element_id = ChecklistElement.id AND PlaceholderText.action = 19 AND PlaceholderText.assigned_checklist_uuid = :checkListUuid )\n" +
            "LEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = ParentElement.id AND ParentStep.assigned_checklist_uuid = :checkListUuid AND ParentStep.is_deleted = 0 )\n" +
            "\n" +
            "WHERE\n" +
            "ChecklistElement.checklist_id = :checkListId\n" +
            "AND ChecklistElement.is_deleted = 0\n" +
            "AND ChecklistElement.item_type_id NOT IN ( 9 )\n" +
            "AND (ChecklistElement.parent_id IS NULL OR parent_type = 2)\n" +
            "AND (imageTextStatus IS NULL OR imageTextStatus = 13)\n" +
            "AND (\n" +
            "(\n" +
            "WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n" +
            "SELECT id,parent_id,item_type_id\n" +
            "FROM checklist_elements g\n" +
            "WHERE id = ChecklistElement.id\n" +
            "UNION ALL\n" +
            "SELECT c.id,c.parent_id,c.item_type_id\n" +
            "FROM checklist_path AS cp\n" +
            "JOIN checklist_elements AS c ON cp.parent_id = c.id\n" +
            ")\n" +
            "SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id\n" +
            ") IS NULL OR\n" +
            "(\n" +
            "WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n" +
            "SELECT g.id,g.parent_id,g.item_type_id\n" +
            "FROM checklist_elements g\n" +
            "WHERE g.id = ChecklistElement.id\n" +
            "UNION ALL\n" +
            "SELECT c.id,c.parent_id,c.item_type_id\n" +
            "FROM checklist_path AS cp JOIN checklist_elements AS c ON cp.parent_id = c.id\n" +
            ")\n" +
            "SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id\n" +
            ") IN (SELECT checklist_element_id FROM assigned_decisions WHERE status = 1 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND is_deleted = 0))\n" +
            "AND COALESCE(acknowledged, AssignedStep.status, decisionStatus, -1) IN (-1, 3)\n" +
            "\n" +
            "ORDER BY\n" +
            "ChecklistElement.sort_order ASC";

    public static final String GET_CHECKLIST_DETAIL_NEXT_DEFFERED = "SELECT\n" +
            "distinct checklist_elements.checklist_id,\n" +
            "checklist_elements.id,\n" +
            "checklist_elements.item_type_id,\n" +
            "checklist_elements.item_id,\n" +
            "checklist_elements.item_uuid,\n" +
            "checklist_elements.parent_id,\n" +
            "checklist_elements.sort_order,\n" +
            "checklist_elements.sequence_no,\n" +
            "assigned_ncw.acknowledged,assigned_steps.status,assigned_decisions.status as decisionStatus , logs.action as imageTextStatus ," +
            "(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, " +
            "(select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid) as parent_status, " +

            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n" +
            "FROM\n" +
            "checklist_elements\n" +
            "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n" +
            "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = :checkListUuid AND assigned_ncw.is_deleted = 0) " +
            "LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid AND assigned_steps.is_deleted = 0) " +
            "LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND assigned_decisions.is_deleted = 0) " +
            "LEFT JOIN logs ON ( checklist_elements.id = logs.checklist_element_id and (checklist_elements.item_type_id = 7 OR checklist_elements.item_type_id = 10 or logs.action = 19) AND logs.assigned_checklist_uuid = :checkListUuid ) " +
            "WHERE\n" +
            "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT id,parent_id,item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE g.id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid and assigned_decisions.is_deleted = 0))\n" +
            "AND checklist_elements.checklist_id =  :checkListId " +
            "AND checklist_elements.is_deleted = 0 \n" +
            "AND checklist_elements.item_type_id <> 9 " +
            "AND (assigned_ncw.acknowledged = 3 or assigned_steps.status = 3 or assigned_decisions.status = 3 OR parent_status = 3) " +
            "ORDER BY\n" +
            "checklist_elements.sort_order ASC limit 1 offset :offset ";

    public static final String GET_CHECKLIST_DETAIL_SKIPPED_DEFER = "WITH RECURSIVE elements(id, parent_id, checklist_id, item_id, item_type_id, item_uuid, title, description, sequence_no, status, sort_order, rootid, level) AS (\n" +
            "        SELECT\n" +
            "            checklist_elements.id,\n" +
            "            checklist_elements.parent_id,\n" +
            "            checklist_elements.checklist_id,\n" +
            "            checklist_elements.item_id,\n" +
            "            checklist_elements.item_type_id,\n" +
            "            checklist_elements.item_uuid,\n" +
            "            checklist_elements.title,\n" +
            "            checklist_elements.description,\n" +
            "            checklist_elements.sequence_no,\n" +
            "            COALESCE(assigned_steps.status, assigned_decisions.status, assigned_ncw.acknowledged, (SELECT \"action\" FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND \"action\" IN ( 17, 18, 12, 13) AND assigned_checklist_uuid = :assignedchecklistUuid ORDER BY created DESC LIMIT 1)) AS status,\n" +
            "            checklist_elements.sort_order,\n" +
            "            checklist_elements.id AS rootid,\n" +
            "            0 AS level\n" +
            "        FROM checklist_elements\n" +
            "        LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = :assignedchecklistUuid)\n" +
            "        LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = :assignedchecklistUuid)\n" +
            "        LEFT JOIN assigned_ncw ON (assigned_ncw.checklist_element_id = checklist_elements.id AND assigned_ncw.is_deleted = 0 AND assigned_ncw.assigned_checklist_uuid = :assignedchecklistUuid)\n" +
            "        WHERE\n" +
            "            checklist_elements.checklist_id = :checklistId\n" +
            "        AND checklist_elements.is_deleted = 0\n" +
            "            UNION ALL\n" +
            "        SELECT \n" +
            "            checklist_elements.id,\n" +
            "            checklist_elements.parent_id,\n" +
            "            checklist_elements.checklist_id,\n" +
            "            checklist_elements.item_id,\n" +
            "            checklist_elements.item_type_id,\n" +
            "            checklist_elements.item_uuid,\n" +
            "            checklist_elements.title,\n" +
            "            checklist_elements.description,\n" +
            "            checklist_elements.sequence_no,\n" +
            "            COALESCE(assigned_steps.status, assigned_decisions.status) AS status,\n" +
            "            checklist_elements.sort_order,\n" +
            "            elements.rootid,\n" +
            "            level + 1 AS level\n" +
            "        FROM checklist_elements, elements\n" +
            "        LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = :assignedchecklistUuid)\n" +
            "        LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = :assignedchecklistUuid)\n" +
            "        WHERE checklist_elements.id = elements.parent_id\n" +
            ")\n" +
            "SELECT\n" +
            "    id, parent_id, elements.checklist_id, item_id, item_type_id, elements.item_uuid,\n" +
            "    IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.item_description, elements.title) ELSE elements.title END, '') AS title,\n" +
            "    IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.step_action, elements.description) ELSE COALESCE(placeholders_text.item_description, elements.description) END, '') AS description,\n" +
            "    sequence_no, status, sort_order,\n" +
            "    (SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = elements.item_id AND elements.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon,\n" +
            "    (SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = elements.item_id AND ncw_hazards.item_type_id = elements.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon,\n" +
            "    rootid, level,\n" +
            "    SUM(CASE WHEN rootid != id THEN 1 ELSE 0 END) AS total_parents,\n" +
            "    SUM(CASE WHEN rootid != id AND ( ( item_type_id = 2 AND status = 1 ) OR ( item_type_id != 2 AND ( status IN ( :status ) ) ) ) THEN 1 ELSE 0 END) AS total_executed_parents,\n" +
            "    SUM(CASE WHEN level = 1 AND item_type_id IN (1, 8, 12) THEN 1 ELSE 0 END) AS has_step_parent\n" +
            "FROM elements\n" +
            "LEFT JOIN logs AS placeholders_text ON ( placeholders_text.checklist_element_id = elements.id AND placeholders_text.\"action\" = 19 AND placeholders_text.assigned_checklist_uuid = :assignedchecklistUuid)\n" +
            "GROUP BY rootid\n" +
            "HAVING total_parents = total_executed_parents AND ( ( has_step_parent = 0 AND (CASE WHEN :status  = 2 THEN status IN ( 2, '12' ) ELSE  status IN ( 3, '13' ) END )) OR has_step_parent = 1 ) AND MIN(level) = 0\n" +
            "ORDER BY sort_order";

    public static final String GET_CHECKLIST_PENDING_ELEMENT_COUNT = "SELECT \n" +
            " COUNT(ChecklistElement.id) \n" +
            "FROM \n" +
            " checklist_elements AS ChecklistElement \n" +
            " LEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = ChecklistElement.parent_id) \n" +
            " LEFT JOIN assigned_ncw AS AssignedNCW ON ( AssignedNCW.checklist_element_id = ChecklistElement.id AND AssignedNCW.assigned_checklist_uuid =  :checkListUuid AND AssignedNCW.is_deleted = 0 ) \n" +
            " LEFT JOIN assigned_steps AS AssignedStep ON ( AssignedStep.checklist_element_id = ChecklistElement.id AND AssignedStep.assigned_checklist_uuid =  :checkListUuid AND AssignedStep.is_deleted = 0 ) \n" +
            " LEFT JOIN assigned_decisions AS AssignedDecision ON ( AssignedDecision.checklist_element_id = ChecklistElement.id AND AssignedDecision.assigned_checklist_uuid =  :checkListUuid AND AssignedDecision.is_deleted = 0 ) \n" +
            " LEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = ParentElement.id AND ParentStep.assigned_checklist_uuid =  :checkListUuid AND ParentStep.is_deleted = 0 ) \n" +
            "\n" +
            "WHERE \n" +
            " ChecklistElement.checklist_id =  :checkListId\n" +
            " AND ChecklistElement.is_deleted = 0  \n" +
            " AND ChecklistElement.item_type_id NOT IN ( 9 )  \n" +
            " AND (ParentStep.status IN (1) OR ParentStep.checklist_element_id IS NULL) \n" +
            " AND (AssignedNCW.acknowledged IN (1,2) OR AssignedStep.status IN ( 1, 2 ) OR AssignedDecision.status IN (0, 1 ,2)  \n" +
            " OR (SELECT action FROM logs WHERE checklist_element_id = ChecklistElement.id AND ChecklistElement.item_type_id IN ( 7, 10 ) AND assigned_checklist_uuid =  :checkListUuid \n" +
            "   ORDER BY created DESC LIMIT 1) IN (12,17,18)) \n" +
            "  AND ( \n" +
            "    ( \n" +
            "     WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS ( \n" +
            " SELECT id,parent_id,item_type_id \n" +
            " FROM checklist_elements g \n" +
            "      WHERE id = ChecklistElement.id  \n" +
            "       UNION ALL \n" +
            "      SELECT c.id,c.parent_id,c.item_type_id \n" +
            " FROM checklist_path AS cp  \n" +
            "      JOIN checklist_elements AS c ON cp.parent_id = c.id \n" +
            "     ) \n" +
            " SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id  \n" +
            "   ) IS NULL OR  \n" +
            "   ( \n" +
            "    WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS ( \n" +
            "     SELECT g.id,g.parent_id,g.item_type_id \n" +
            " FROM checklist_elements g \n" +
            " WHERE g.id = ChecklistElement.id  \n" +
            "      UNION ALL \n" +
            "     SELECT c.id,c.parent_id,c.item_type_id \n" +
            "     FROM checklist_path AS cp JOIN checklist_elements AS c ON cp.parent_id = c.id \n" +
            "    ) \n" +
            "    SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id \n" +
            "   ) IN (SELECT checklist_element_id FROM assigned_decisions WHERE status = 1 AND assigned_decisions.assigned_checklist_uuid =  :checkListUuid AND is_deleted = 0)) \n" +
            "ORDER BY \n" +
            " ChecklistElement.sort_order ASC;";
    public static final String GET_CHECKLIST_TOTAL_ELEMENT_COUNT = "SELECT\n" +
            "\tCOUNT(ChecklistElement.id)\n" +
            "FROM\n" +
            "\tchecklist_elements AS ChecklistElement\n" +
            "\tLEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = ChecklistElement.parent_id)\n" +
            "\tLEFT JOIN assigned_ncw AS AssignedNCW ON ( AssignedNCW.checklist_element_id = ChecklistElement.id AND AssignedNCW.assigned_checklist_uuid = :checkListUuid AND AssignedNCW.is_deleted = 0 )\n" +
            "\tLEFT JOIN assigned_steps AS AssignedStep ON ( AssignedStep.checklist_element_id = ChecklistElement.id AND AssignedStep.assigned_checklist_uuid = :checkListUuid AND AssignedStep.is_deleted = 0 )\n" +
            "\tLEFT JOIN assigned_decisions AS AssignedDecision ON ( AssignedDecision.checklist_element_id = ChecklistElement.id AND AssignedDecision.assigned_checklist_uuid = :checkListUuid AND AssignedDecision.is_deleted = 0 )\n" +
            /*"\tLEFT JOIN logs AS AssignedTextImage ON ( AssignedTextImage.checklist_element_id = ChecklistElement.id " +
            "AND AssignedTextImage.\"action\" IN ( 17, 18 ) AND AssignedTextImage.assigned_checklist_uuid = :checkListUuid )\n" +*/
            "\tLEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = ParentElement.id AND ParentStep.assigned_checklist_uuid = :checkListUuid AND ParentStep.is_deleted = 0 )\n" +
            "WHERE\n" +
            "\tChecklistElement.checklist_id = :checkListId \n" +
            "\tAND ChecklistElement.is_deleted = 0 \n" +
            "\tAND ChecklistElement.item_type_id NOT IN ( 9 ) \n" +
            "\tAND (ParentStep.status IN (0, 1, 3) OR ParentStep.status\tIS NULL)\n" +
            " \tAND (\n" +
            "\t\t\t\t(\n" +
            "\t\t\t\t\tWITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n" +
            "            SELECT id,parent_id,item_type_id\n" +
            "            FROM checklist_elements g\n" +
            "\t\t\t\t\t\tWHERE id = ChecklistElement.id \n" +
            "\t\t\t\t\t\t\tUNION ALL\n" +
            "\t\t\t\t\t\tSELECT c.id,c.parent_id,c.item_type_id\n" +
            "            FROM checklist_path AS cp \n" +
            "\t\t\t\t\t\tJOIN checklist_elements AS c ON cp.parent_id = c.id\n" +
            "\t\t\t\t\t)\n" +
            "          SELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id  \n" +
            "\t\t\t) IS NULL OR \n" +
            "\t\t\t(\n" +
            "\t\t\t\tWITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS (\n" +
            "\t\t\t\t\tSELECT g.id,g.parent_id,g.item_type_id\n" +
            "          FROM checklist_elements g\n" +
            "          WHERE g.id = ChecklistElement.id \n" +
            "\t\t\t\t\t\tUNION ALL\n" +
            "\t\t\t\t\tSELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c ON cp.parent_id = c.id\n" +
            "\t\t\t\t)\n" +
            "\t\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != ChecklistElement.id\n" +
            "\t\t\t) IN (SELECT checklist_element_id FROM assigned_decisions WHERE status = 1  AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND is_deleted = 0))\n" +
            "ORDER BY\n" +
            "\tChecklistElement.sort_order ASC";

    public static final String GET_CHECKLIST_EXECUTION_DETAIL_NEXT_ELEMENT = "WITH RECURSIVE elements(id, parent_id, checklist_id, item_id, item_type_id, item_uuid, title, description, sequence_no, status, sort_order, rootid, level) AS ( \n" +
            "                    SELECT \n" +
            "                        checklist_elements.id, \n" +
            "                        checklist_elements.parent_id, \n" +
            "                        checklist_elements.checklist_id, \n" +
            "                        checklist_elements.item_id, \n" +
            "                        checklist_elements.item_type_id, \n" +
            "                        checklist_elements.item_uuid, \n" +
            "                        checklist_elements.title, \n" +
            "                        checklist_elements.description, \n" +
            "                        checklist_elements.sequence_no, \n" +
            "                        COALESCE(assigned_steps.status, assigned_decisions.status, assigned_ncw.acknowledged,  \n" +
            "            (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id  \n" +
            "            AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18, 12, 13) \n" +
            "             AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1)) AS status, \n" +
            "                        checklist_elements.sort_order, \n" +
            "                        checklist_elements.id AS rootid, \n" +
            "                        0 AS level \n" +
            "                    FROM checklist_elements \n" +
            "                    LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    LEFT JOIN assigned_ncw ON (assigned_ncw.checklist_element_id = checklist_elements.id AND assigned_ncw.is_deleted = 0 AND assigned_ncw.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    WHERE \n" +
            "                        checklist_elements.checklist_id = :checklistId \n" +
            "                    AND checklist_elements.is_deleted = 0 \n" +
            "                    AND checklist_elements.item_type_id NOT IN ( 9 )\n" +
            "                    AND checklist_elements.sort_order > :currentSortOrder\n" +
            "                        UNION ALL \n" +
            "                    SELECT  \n" +
            "                        checklist_elements.id, \n" +
            "                        checklist_elements.parent_id, \n" +
            "                        checklist_elements.checklist_id, \n" +
            "                        checklist_elements.item_id, \n" +
            "                        checklist_elements.item_type_id, \n" +
            "                        checklist_elements.item_uuid, \n" +
            "                        checklist_elements.title, \n" +
            "                        checklist_elements.description, \n" +
            "                        checklist_elements.sequence_no, \n" +
            "                        COALESCE(assigned_steps.status, assigned_decisions.status) AS status, \n" +
            "                        checklist_elements.sort_order, \n" +
            "                        elements.rootid, \n" +
            "                        level + 1 AS level \n" +
            "                    FROM checklist_elements, elements \n" +
            "                    LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    WHERE checklist_elements.id = elements.parent_id \n" +
            "            ) \n" +
            "            SELECT \n" +
            "                id, parent_id, elements.checklist_id, item_id, item_type_id, elements.item_uuid,\n" +
            "                IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.item_description, elements.title) ELSE elements.title END, '') AS title, \n" +
            "                IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.step_action, elements.description) ELSE COALESCE(placeholders_text.item_description, elements.description) END, '') AS description, \n" +
            "                sequence_no, status, sort_order, \n" +
            "                (SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = elements.item_id AND elements.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon, \n" +
            "                (SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = elements.item_id AND ncw_hazards.item_type_id = elements.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon, \n" +
            "                rootid, level, \n" +
            "                SUM(CASE WHEN rootid != id THEN 1 ELSE 0 END) AS total_parents, \n" +
            "                SUM(CASE WHEN rootid != id AND ( ( item_type_id = 2 AND status = 1 ) OR ( item_type_id != 2 AND ( status IN ( 0, 1 ) OR status IS NULL) ) ) THEN 1 ELSE 0 END) AS total_executed_parents, \n" +
            "                SUM(CASE WHEN level = 1 AND item_type_id IN (1, 8, 12) THEN 1 ELSE 0 END) AS has_step_parent, \n" +
            "                SUM(CASE WHEN level = 1 THEN item_type_id ELSE 0 END) AS parent_type\n" +
            "            FROM elements \n" +
            "            LEFT JOIN logs AS placeholders_text ON ( placeholders_text.checklist_element_id = elements.id AND placeholders_text.action = 19 AND placeholders_text.assigned_checklist_uuid = :checkListUuid) \n" +
            "            GROUP BY rootid \n" +
            "            HAVING total_parents = total_executed_parents AND MIN(level) = 0 AND (has_step_parent = 0 OR (has_step_parent = 1 AND item_type_id NOT IN ( 10 )))\n" +
            "            ORDER BY sort_order LIMIT 1;";

    public static final String GET_CHECKLIST_EXECUTION_DETAIL_NEXT_SKIPPED_ELEMENT = "SELECT\n distinct " +
            "checklist_elements.checklist_id,\n" +
            "checklist_elements.id,\n" +
            "checklist_elements.item_type_id,\n" +
            "checklist_elements.item_id,\n" +
            "checklist_elements.item_uuid,\n" +
            "checklist_elements.parent_id,\n" +
            "min(checklist_elements.sort_order) as sort_order ,\n" +
            "checklist_elements.sequence_no,\n" +
            "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus, " +
            "(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, " +
            "(select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid) as parent_status, " +
            "(SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1) AS imageTextStatus," +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n" +
            "FROM checklist_elements\n" +
            "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n" +
            "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = :checkListUuid AND assigned_ncw.is_deleted = 0) " +
            "LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid AND assigned_steps.is_deleted = 0) " +
            "LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND assigned_decisions.is_deleted = 0) " +
            "LEFT JOIN logs  ON (" +
            "logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n" +
            "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n" +
            "AND logs.action = 19)\n" +
            "WHERE\n" +
            "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT id,parent_id,item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE g.id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid and assigned_decisions.is_deleted = 0))\n" +
            "AND checklist_elements.checklist_id =  :checkListId " +
            "AND checklist_elements.item_type_id <> 9 " +
            "AND (assigned_ncw.acknowledged = 2 or assigned_steps.status = 2 or assigned_decisions.status = 2 OR parent_status = 2 OR imageTextStatus = 12) " +
            "AND checklist_elements.is_deleted = 0 \n" +
            " AND sort_order > :currentSortOrder\n" +
            "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or parent_type = 2)" +
            "ORDER BY\n" +
            "checklist_elements.sort_order ASC;";

    public static final String GET_CHECKLIST_EXECUTION_DETAIL_NEXT_DEFFERED_ELEMENT = "SELECT\n distinct " +
            "checklist_elements.checklist_id,\n" +
            "checklist_elements.id,\n" +
            "checklist_elements.item_type_id,\n" +
            "checklist_elements.item_id,\n" +
            "checklist_elements.item_uuid,\n" +
            "checklist_elements.parent_id,\n" +
            "min(checklist_elements.sort_order) as sort_order ,\n" +
            "checklist_elements.sequence_no,\n" +
            "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus, " +
            "(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, " +
            "(select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid) as parent_status, " +
            "(SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1) AS imageTextStatus," +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n" +
            "FROM checklist_elements\n" +
            "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n" +
            "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = :checkListUuid AND assigned_ncw.is_deleted = 0) " +
            "LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid AND assigned_steps.is_deleted = 0) " +
            "LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND assigned_decisions.is_deleted = 0) " +
            "LEFT JOIN logs  ON (" +
            "logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n" +
            "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n" +
            "AND logs.action = 19)\n" +
            "WHERE\n" +
            "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT id,parent_id,item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE g.id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid and assigned_decisions.is_deleted = 0))\n" +
            "AND checklist_elements.checklist_id =  :checkListId " +
            "AND checklist_elements.item_type_id <> 9 " +
            "AND (assigned_ncw.acknowledged = 3 or assigned_steps.status = 3 or assigned_decisions.status = 3 OR parent_status = 3 OR imageTextStatus = 13) " +
            "AND checklist_elements.is_deleted = 0 \n" +
            " AND sort_order > :currentSortOrder\n" +
            "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or parent_type = 2)" +
            "ORDER BY\n" +
            "checklist_elements.sort_order ASC;";

    public static final String GET_CHECKLIST_EXECUTION_DETAIL_CURRENT_ELEMENT = "SELECT\n" +
            "\tAssignedChecklist.checklist_id,\n" +
            "\tChecklistElement.id,\n" +
            "\tChecklistElement.item_type_id,\n" +
            "\tChecklistElement.item_id,\n" +
            "\tChecklistElement.item_uuid,\n" +
            "\tChecklistElement.parent_id,\n" +
            "\tChecklistElement.sort_order,\n" +
            "\tChecklistElement.sequence_no,\n" +
            "\tParentChecklistElement.item_type_id AS parent_type,\n" +
            "\tIFNULL(\n" +
            "\tCASE\n" +
            "\t\t\tWHEN ChecklistElement.item_type_id IN ( 1, 8, 12 ) THEN coalesce( PlacholderText.item_description, ChecklistElement.title ) \n" +
            "\t\t\tELSE ChecklistElement.title \n" +
            "\t\tEND,\n" +
            "\t\t'' \n" +
            "\t) AS title,\n" +
            "\tIFNULL(\n" +
            "\tCASE\n" +
            "\t\t\tWHEN ChecklistElement.item_type_id IN ( 1, 8, 12 ) THEN coalesce( PlacholderText.step_action, ChecklistElement.description ) \n" +
            "\t\t\tELSE coalesce( PlacholderText.item_description, ChecklistElement.description ) \n" +
            "\t\tEND,\n" +
            "\t\t'' \n" +
            "\t) AS description,\n" +
            "\tAssignedStep.status,\n" +
            "\tAssignedDecision.status AS \"decisionStatus\",\n" +
            "\tAssignedNCW.acknowledged,\n" +
            "\t( SELECT \"action\" FROM logs WHERE assigned_checklist_uuid = AssignedChecklist.uuid AND checklist_element_id = ChecklistElement.id AND ChecklistElement.item_type_id IN ( 7, 10 ) ORDER BY created DESC LIMIT 1 ) AS \"imageTextStatus\",\n" +
            "\tCOALESCE( ParentAssignedStep.status, ParentAssignedDecision.status ) AS parent_status \n" +
            "FROM\n" +
            "\tassigned_checklists AS AssignedChecklist\n" +
            "\tLEFT JOIN checklist_elements AS ChecklistElement ON ( ChecklistElement.checklist_id = AssignedChecklist.checklist_id )\n" +
            "\tLEFT JOIN checklist_elements AS ParentChecklistElement ON ( ParentChecklistElement.id = ChecklistElement.parent_id )\n" +
            "\tLEFT JOIN logs AS PlacholderText ON (\n" +
            "\t\tPlacholderText.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND PlacholderText.checklist_element_id = ChecklistElement.id \n" +
            "\t\tAND PlacholderText.\"action\" = 19 \n" +
            "\t)\n" +
            "\tLEFT JOIN assigned_ncw AS AssignedNCW ON (\n" +
            "\t\tAssignedNCW.checklist_element_id = ChecklistElement.id \n" +
            "\t\tAND AssignedNCW.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND AssignedNCW.is_deleted = 0 \n" +
            "\t)\n" +
            "\tLEFT JOIN assigned_steps AS AssignedStep ON (\n" +
            "\t\tAssignedStep.checklist_element_id = ChecklistElement.id \n" +
            "\t\tAND AssignedStep.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND AssignedStep.is_deleted = 0 \n" +
            "\t)\n" +
            "\tLEFT JOIN assigned_decisions AS AssignedDecision ON (\n" +
            "\t\tAssignedDecision.checklist_element_id = ChecklistElement.id \n" +
            "\t\tAND AssignedDecision.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND AssignedDecision.is_deleted = 0 \n" +
            "\t)\n" +
            "\tLEFT JOIN assigned_steps AS ParentAssignedStep ON (\n" +
            "\t\tParentAssignedStep.checklist_element_id = ParentChecklistElement.id \n" +
            "\t\tAND ParentAssignedStep.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND ParentAssignedStep.is_deleted = 0 \n" +
            "\t)\n" +
            "\tLEFT JOIN assigned_decisions AS ParentAssignedDecision ON (\n" +
            "\t\tParentAssignedDecision.checklist_element_id = ParentChecklistElement.id \n" +
            "\t\tAND ParentAssignedDecision.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "\t\tAND ParentAssignedDecision.is_deleted = 0 \n" +
            "\t) \n" +
            "WHERE\n" +
            "\tAssignedChecklist.uuid = :checkListUuid \n" +
            "\tAND ChecklistElement.is_deleted = 0 \n" +
            "\tAND ChecklistElement.item_type_id <> 9 \n" +
            "\tAND (\n" +
            "\t\t(\n" +
            "\t\t\tParentChecklistElement.item_type_id IN ( 1, 8, 12 ) \n" +
            "\t\t\tAND (\n" +
            "\t\t\t\tparent_status IS NULL \n" +
            "\t\t\t\tOR parent_status = 0 \n" +
            "\t\t\t\tOR parent_status = 1 \n" +
            "\t\t\t) \n" +
            "\t\t) \n" +
            "\t\tOR ( ParentChecklistElement.item_type_id = 2 AND parent_status = 1 ) \n" +
            "\t\tOR ParentChecklistElement.item_type_id IS NULL \n" +
            "\t) \n" +
            "\tAND ChecklistElement.sort_order = :currentSortOrder\n" +
            "ORDER BY\n" +
            "\tChecklistElement.sort_order ASC;";

    public static final String GET_CHECKLIST_EXECUTION_DETAIL_CURRENT_SKIPPED_ELEMENT = "SELECT\n distinct " +
            "checklist_elements.checklist_id,\n" +
            "checklist_elements.id,\n" +
            "checklist_elements.item_type_id,\n" +
            "checklist_elements.item_id,\n" +
            "checklist_elements.item_uuid,\n" +
            "checklist_elements.parent_id,\n" +
            "checklist_elements.sort_order,\n" +
            "checklist_elements.sequence_no,\n" +
            "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus, " +
            "(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, " +
            "(select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid) as parent_status, " +
            "(SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1) AS imageTextStatus," +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n" +
            "FROM checklist_elements\n" +
            "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n" +
            "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = :checkListUuid AND assigned_ncw.is_deleted = 0) " +
            "LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid AND assigned_steps.is_deleted = 0) " +
            "LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND assigned_decisions.is_deleted = 0) " +
            "LEFT JOIN logs  ON (" +
            "logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n" +
            "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n" +
            "AND logs.action = 19)\n" +
            "WHERE\n" +
            "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT id,parent_id,item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE g.id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid and assigned_decisions.is_deleted = 0))\n" +
            "AND checklist_elements.checklist_id =  :checkListId " +
            "AND checklist_elements.item_type_id <> 9 " +
            "AND checklist_elements.is_deleted = 0 \n" +
            " AND sort_order = :currentSortOrder\n" +
            "ORDER BY\n" +
            "checklist_elements.sort_order ASC;";
    public static final String GET_CHECKLIST_EXECUTION_DETAIL_CURRENT_DEFFERED_ELEMENT = "SELECT\n distinct " +
            "checklist_elements.checklist_id,\n" +
            "checklist_elements.id,\n" +
            "checklist_elements.item_type_id,\n" +
            "checklist_elements.item_id,\n" +
            "checklist_elements.item_uuid,\n" +
            "checklist_elements.parent_id,\n" +
            "checklist_elements.sort_order,\n" +
            "checklist_elements.sequence_no,\n" +
            "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus ,logs.action as imageTextStatus , " +
            "(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, " +
            "(select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid) as parent_status, " +
            "(SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1) AS imageTextStatus," +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n" +
            "FROM checklist_elements\n" +
            "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n" +
            "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = :checkListUuid AND assigned_ncw.is_deleted = 0) " +
            "LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid AND assigned_steps.is_deleted = 0) " +
            "LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND assigned_decisions.is_deleted = 0) " +
            "LEFT JOIN logs  ON (" +
            "logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n" +
            "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n" +
            "AND logs.action = 19)\n" +

            "WHERE\n" +
            "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT id,parent_id,item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE g.id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid and assigned_decisions.is_deleted = 0))\n" +
            "AND checklist_elements.checklist_id =  :checkListId " +
            "AND checklist_elements.item_type_id <> 9 " +
            "AND checklist_elements.is_deleted = 0 \n" +
            " AND sort_order = :currentSortOrder\n" +
            "ORDER BY\n" +
            "checklist_elements.sort_order ASC;";

    public static final String GET_CHECKLIST_EXECUTION_DETAIL_PREVIOUS_ELEMENT = "WITH RECURSIVE elements(id, parent_id, checklist_id, item_id, item_type_id, item_uuid, title, description, sequence_no, status, sort_order, rootid, level) AS ( \n" +
            "                    SELECT \n" +
            "                        checklist_elements.id, \n" +
            "                        checklist_elements.parent_id, \n" +
            "                        checklist_elements.checklist_id, \n" +
            "                        checklist_elements.item_id, \n" +
            "                        checklist_elements.item_type_id, \n" +
            "                        checklist_elements.item_uuid, \n" +
            "                        checklist_elements.title, \n" +
            "                        checklist_elements.description, \n" +
            "                        checklist_elements.sequence_no, \n" +
            "                        COALESCE(assigned_steps.status, assigned_decisions.status, assigned_ncw.acknowledged,  \n" +
            "            (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id  \n" +
            "            AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18, 12, 13) \n" +
            "             AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1)) AS status, \n" +
            "                        checklist_elements.sort_order, \n" +
            "                        checklist_elements.id AS rootid, \n" +
            "                        0 AS level \n" +
            "                    FROM checklist_elements \n" +
            "                    LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    LEFT JOIN assigned_ncw ON (assigned_ncw.checklist_element_id = checklist_elements.id AND assigned_ncw.is_deleted = 0 AND assigned_ncw.assigned_checklist_uuid = :checkListUuid) \n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "                    WHERE \n" +
            "                        checklist_elements.checklist_id = :checklistId \n" +
            "                    AND checklist_elements.is_deleted = 0 \n" +
            "                    AND checklist_elements.item_type_id NOT IN ( 9 )\n" +
            "                    AND checklist_elements.sort_order < :currentSortOrder\n" +
            "                        UNION ALL \n" +
            "                    SELECT  \n" +
            "                        checklist_elements.id, \n" +
            "                        checklist_elements.parent_id, \n" +
            "                        checklist_elements.checklist_id, \n" +
            "                        checklist_elements.item_id, \n" +
            "                        checklist_elements.item_type_id, \n" +
            "                        checklist_elements.item_uuid, \n" +
            "                        checklist_elements.title, \n" +
            "                        checklist_elements.description, \n" +
            "                        checklist_elements.sequence_no, \n" +
            "                        COALESCE(assigned_steps.status, assigned_decisions.status) AS status, \n" +
            "                        checklist_elements.sort_order, \n" +
            "                        elements.rootid, \n" +
            "                        level + 1 AS level \n" +
            "                    FROM checklist_elements, elements \n" +
            "                    LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid) \n" +
            "                    WHERE checklist_elements.id = elements.parent_id \n" +
            "            ) \n" +
            "            SELECT \n" +
            "                id, parent_id, elements.checklist_id, item_id, item_type_id, elements.item_uuid,\n" +
            "                IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.item_description, elements.title) ELSE elements.title END, '') AS title, \n" +
            "                IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.step_action, elements.description) ELSE COALESCE(placeholders_text.item_description, elements.description) END, '') AS description, \n" +
            "                sequence_no, status, sort_order, \n" +
            "                (SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = elements.item_id AND elements.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon, \n" +
            "                (SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = elements.item_id AND ncw_hazards.item_type_id = elements.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon, \n" +
            "                rootid, level, \n" +
            "                SUM(CASE WHEN rootid != id THEN 1 ELSE 0 END) AS total_parents, \n" +
            "                SUM(CASE WHEN rootid != id AND ( ( item_type_id = 2 AND status = 1 ) OR ( item_type_id != 2 AND ( status IN ( 0, 1 ) OR status IS NULL) ) ) THEN 1 ELSE 0 END) AS total_executed_parents, \n" +
            "                SUM(CASE WHEN level = 1 AND item_type_id IN (1, 8, 12) THEN 1 ELSE 0 END) AS has_step_parent, \n" +
            "                SUM(CASE WHEN level = 1 THEN item_type_id ELSE 0 END) AS parent_type\n" +
            "            FROM elements \n" +
            "            LEFT JOIN logs AS placeholders_text ON ( placeholders_text.checklist_element_id = elements.id AND placeholders_text.action = 19 AND placeholders_text.assigned_checklist_uuid = :checkListUuid) \n" +
            "            GROUP BY rootid \n" +
            "            HAVING total_parents = total_executed_parents AND MIN(level) = 0 AND ( has_step_parent = 0 OR ( has_step_parent = 1 AND item_type_id NOT IN ( 10 ) ) )\n" +
            "            ORDER BY sort_order DESC LIMIT 1;";

    public static final String GET_CHECKLIST_EXECUTION_DETAIL_PREVIOUS_SKIPPED_ELEMENT = "SELECT\n distinct " +
            "checklist_elements.checklist_id,\n" +
            "checklist_elements.id,\n" +
            "checklist_elements.item_type_id,\n" +
            "checklist_elements.item_id,\n" +
            "checklist_elements.item_uuid,\n" +
            "checklist_elements.parent_id,\n" +
            "max(checklist_elements.sort_order) as sort_order,\n" +
            "checklist_elements.sequence_no,\n" +
            "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus," +
            "(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, " +
            "(select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid) as parent_status, " +
            "(SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1) AS imageTextStatus," +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n" +
            "FROM checklist_elements\n" +
            "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n" +
            "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = :checkListUuid AND assigned_ncw.is_deleted = 0) " +
            "LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid AND assigned_steps.is_deleted = 0) " +
            "LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND assigned_decisions.is_deleted = 0) " +
            "LEFT JOIN logs  ON (" +
            "logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n" +
            "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n" +
            "AND logs.action = 19)\n" +
            "WHERE\n" +
            "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT id,parent_id,item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE g.id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid and assigned_decisions.is_deleted = 0))\n" +
            "AND checklist_elements.checklist_id =  :checkListId " +
            "AND checklist_elements.item_type_id <> 9 " +
            "AND checklist_elements.is_deleted = 0 \n" +
            "AND (assigned_ncw.acknowledged = 2 or assigned_steps.status = 2 or assigned_decisions.status = 2 OR parent_status = 2 OR imageTextStatus = 12) " +
            " AND sort_order < :currentSortOrder\n" +
            "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or parent_type = 2)" +
            "ORDER BY\n" +
            "checklist_elements.sort_order ASC;";

    public static final String GET_CHECKLIST_EXECUTION_DETAIL_PREVIOUS_DEFFERED_ELEMENT = "SELECT\n distinct " +
            "checklist_elements.checklist_id,\n" +
            "checklist_elements.id,\n" +
            "checklist_elements.item_type_id,\n" +
            "checklist_elements.item_id,\n" +
            "checklist_elements.item_uuid,\n" +
            "checklist_elements.parent_id,\n" +
            "max(checklist_elements.sort_order) as sort_order,\n" +
            "checklist_elements.sequence_no,\n" +
            "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus, " +
            "(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, " +
            "(select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid) as parent_status, " +
            "(SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = :checkListUuid ORDER BY created DESC LIMIT 1) AS imageTextStatus," +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n" +
            "FROM checklist_elements\n" +
            "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n" +
            "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = :checkListUuid AND assigned_ncw.is_deleted = 0) " +
            "LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = :checkListUuid AND assigned_steps.is_deleted = 0) " +
            "LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = :checkListUuid AND assigned_decisions.is_deleted = 0) " +
            "LEFT JOIN logs  ON (" +
            "logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n" +
            "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n" +
            "AND logs.action = 19)\n" +
            "WHERE\n" +
            "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT id,parent_id,item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n" +
            "\t\t\t(\n" +
            "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n" +
            "\t\t\t\tFROM checklist_elements g\n" +
            "\t\t\t\tWHERE g.id = checklist_elements.id \n" +
            "\t\t\t  UNION ALL\n" +
            "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n" +
            "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n" +
            "\t\t\t\t  ON cp.parent_id = c.id\n" +
            "\t\t\t)\n" +
            "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n" +
            "\n" +
            "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = :checkListUuid and assigned_decisions.is_deleted = 0))\n" +
            "AND checklist_elements.checklist_id =  :checkListId " +
            "AND checklist_elements.item_type_id <> 9 " +
            "AND checklist_elements.is_deleted = 0 \n" +
            "AND (assigned_ncw.acknowledged = 3 or assigned_steps.status = 3 or assigned_decisions.status = 3 OR parent_status = 3 OR imageTextStatus = 13) " +
            " AND sort_order < :currentSortOrder\n" +
            "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or parent_type = 2)" +
            "ORDER BY\n" +
            "checklist_elements.sort_order ASC;";
    public static final String GET_CHECKLIST_EXECUTION_DETAIL_CHILDS = "SELECT\n distinct " +
            "checklist_elements.checklist_id,\n" +
            "checklist_elements.id,\n" +
            "checklist_elements.item_type_id,\n" +
            "checklist_elements.item_id,\n" +
            "checklist_elements.item_uuid,\n" +
            "checklist_elements.parent_id,\n" +
            "checklist_elements.sort_order,\n" +
            "checklist_elements.sequence_no,\n" +
            "assigned_ncw.acknowledged,assigned_steps.status, " +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN coalesce(logs.item_description, checklist_elements.title) ELSE checklist_elements.title END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN coalesce(logs.step_action, checklist_elements.description) ELSE coalesce(logs.item_description, checklist_elements.description) END AS description\n" +
            "FROM\n" +
            "checklist_elements\n" +
            "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n" +
            "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.is_deleted = 0) " +
            "LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.is_deleted = 0) " +
            "WHERE\n" +
            "checklist_elements.checklist_id =  :checkListId " +
            "AND checklist_elements.is_deleted = 0 \n" +
            "AND checklist_elements.parent_id = :parent_id" +
            "ORDER BY\n" +
            "checklist_elements.checklist_id ASC,\n" +
            "checklist_elements.sort_order ASC LIMIT 1 SORT_ORDER :offset;";

    public static final String GET_STEP_ATTRIBUTES = "select distinct step_attributes.id, assigned_step_attributes.item_uuid,step_attributes.label,  " +
            "       step_attributes.sort_order,  custom_fields.step_attribute_count, " +
            "       custom_fields.user_roles,  step_attributes.custom_field_id, step_attributes.step_id, step_attributes.uuid, step_attributes.description, custom_fields.name, " +
            "       custom_fields.allow_gallery,custom_fields.allowed_media_types,custom_fields.multiple,custom_fields.default_value, custom_fields.max_length, custom_fields.max_value," +
            "       custom_fields.min_length,custom_fields.min_value,custom_fields.model,custom_fields.possible_values,custom_fields.allow_description,custom_fields.display_as," +
            "       custom_fields.required,custom_fields.type ," +
            "CASE WHEN custom_fields.type = 'qa' THEN users.username ELSE assigned_step_attributes.value END AS value\n" +
            "from " +
            "       step_attributes " +
            "LEFT JOIN " +
            "       custom_fields " +
            "ON " +
            "       (step_attributes.custom_field_id = custom_fields.id)" +
            "LEFT JOIN " +
            "       assigned_step_attributes " +
            "ON " +
            "       (assigned_step_attributes.step_id = step_attributes.step_id and assigned_step_attributes.step_attribute_id =  step_attributes.id " +
            "       and assigned_step_attributes.assigned_checklist_uuid = :assignedChecklistUuid and assigned_step_attributes.checklist_element_id = :elementId " +
            "       and assigned_step_attributes.is_deleted = 0)" +
            "LEFT JOIN " +
            "       users " +
            "ON " +
            "       (assigned_step_attributes.value = users.id and custom_fields.type = 'qa')" +
            " where " +
            "       step_attributes.step_id = :stepId and step_attributes.is_deleted = 0 " +
            " GROUP BY  step_attributes.id ORDER BY step_attributes.sort_order";


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

    public static final String GET_CHECLIST_PPES = "SELECT DISTINCT\n" +
            "\tppes.id,\n" +
            "\tppes.icon,\n" +
            "\tppes.label\n" +
            "FROM\n" +
            "\tchecklist_ppes\n" +
            "LEFT JOIN ppes ON (checklist_ppes.ppe_id = ppes.id)\n" +
            "WHERE\n" +
            "\tchecklist_ppes.step_id = :stepId\n" +
            "AND checklist_ppes.is_deleted = 0\n" +
            "ORDER BY checklist_ppes.id ASC;";
    public static final String GET_NCW_HAZARDS = "SELECT\n" +
            "\thazards.id,\n" +
            "\thazards.icon,\n" +
            "\thazards.label\n" +
            "FROM\n" +
            "\tncw_hazards\n" +
            "INNER JOIN hazards ON (hazards.id = ncw_hazards.hazard_id)\n" +
            "WHERE\n" +
            "\tncw_hazards.item_id = :itemId\n" +
            "AND ncw_hazards.item_type_id = :itemTypeId\n" +
            "AND ncw_hazards.is_deleted = 0;";
    public static final String GET_ELEMENT_RESOURCES = "select * from resources where item_id = :itemId and is_resource = 0 and is_deleted = 0";
    public static final String GET_RESOURCES = "select * from resources where id = :itemId and is_resource = 1 and is_deleted = 0";
    public static final String GET_ELEMENT_RESOURCES_EMBEDDED = "select * from resources where item_id = :itemId and is_resource = 1 and is_deleted = 0";

    public static final String GET_USERS_FOR_ROLES = "SELECT\n" +
            "\tUser.id,\n" +
            "\tUser.group_id,\n" +
            "\tUser.uuid,\n" +
            "\tUser.full_name \n" +
            "FROM\n" +
            "\tusers AS User\n" +
            "\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (\n" +
            "\t\tUserLocationDepartment.user_id = User.id \n" +
            "\t\tAND UserLocationDepartment.is_deleted = 0 \n" +
            "\t) \n" +
            "WHERE\n" +
            "\tUser.is_deleted = 0 \n" +
            "\tAND User.group_id IN (:groupIds)\n" +
            "\tAND ((\n" +
            "\t\t\tUserLocationDepartment.location_id = :locationId \n" +
            "\t\t\tAND UserLocationDepartment.department_id = :departmentId \n" +
            "\t\t) \n" +
            "\tOR ( User.is_administrator = 1 ))";
    public static final String GET_ALL_USERS_FOR_ROLES = "SELECT\n" +
            "\tDISTINCT User.id,\n" +
            "\tUser.group_id,\n" +
            "\tUser.uuid,\n" +
            "\tUser.full_name \n" +
            "FROM\n" +
            "\tusers AS User\n" +
            "\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (\n" +
            "\t\tUserLocationDepartment.user_id = User.id \n" +
            "\t\tAND UserLocationDepartment.is_deleted = 0 \n" +
            "\t) \n" +
            "WHERE\n" +
            "\tUser.is_deleted = 0 \n" +
            "\tAND User.group_id IN (:groupIds)\n" +
            "\tAND ((\n" +
            "\t\t\tUserLocationDepartment.location_id = :locationId \n" +
            "\t\t) \n" +
            "\tOR ( User.is_administrator = 1 ))";

    public static final String GET_ELEMENT_RESOURCES_URL = "select * from resource_links where item_id = :itemId";

    public static final String GET_ITEM_UUID_FOR_STEP_ATTRIBUTE = "select item_uuid from assigned_step_attributes where  checklist_element_id  = :checklistElementId  and assigned_checklist_uuid = :assignedChecklistUuid limit 1";
    public static final String GET_ASSIGNED_STEP_UUID = "select * from assigned_steps where checklist_element_id = :stepId and assigned_checklist_uuid = :assignedChecklistUuid";
    public static final String VALIDATE_QA = "SELECT\n" +
            "\tUser.id,\n" +
            "\tUser.group_id,\n" +
            "\tUser.is_administrator, \n" +
            "\tUser.full_name \n" +
            "FROM\n" +
            "\tusers AS User \n" +
            "WHERE\n" +
            "\tlower( User.username ) = :username \n" +
            "\tAND User.password = :password \n" +
            "\tAND User.is_deleted = 0";
    public static final String GET_CHECLIST_PPES_FOR_CHECKLIST = "SELECT DISTINCT\n" +
            "\tppes.id,\n" +
            "\tppes.icon,\n" +
            "\tppes.label\n" +
            "FROM\n" +
            "\tchecklist_elements\n" +
            "INNER JOIN checklist_ppes ON (checklist_ppes.step_id = checklist_elements.item_id)\n" +
            "INNER JOIN ppes ON (ppes.id = checklist_ppes.ppe_id)\n" +
            "WHERE\n" +
            "\tchecklist_elements.checklist_id = :checklistId\n" +
            "AND checklist_elements.is_deleted = 0\n" +
            "AND checklist_elements.item_type_id IN (1, 8, 12)\n" +
            "AND checklist_ppes.is_deleted = 0\n" +
            "ORDER BY ppes.id ASC;";
    public static final String IF_STEP_ATTRIBUTE_ALREADY_EXECUTED = "select * from assigned_step_attributes where item_uuid = :itemUUID and checklist_element_id = :checklistElementId and step_id = :stepId and step_attribute_id = :stepAttributeId and is_deleted = 0";
    public static final String GET_VALUE_IF_STEP_ATTRIBUTE_ALREADY_EXECUTED = "select value from assigned_step_attributes where item_uuid = :itemUUID and checklist_element_id = :checklistElementId and step_id = :stepId and step_attribute_id = :stepAttributeId and is_deleted = 0";
    public static final String GET_LOGS = "select * from logs where assigned_checklist_uuid = :assignedChecklistUuid";
    public static final String GET_USERS_FOR_ASSIGNMENT = "SELECT\n" +
            "\tUser.id,\n" +
            "\tUser.uuid,\n" +
            "\tUser.full_name,\n" +
            "\tUser.group_id,\n" +
            "\tRole.name AS role,\n" +
            "\tAssignedUser.assigned_checklist_uuid  \n" +
            "FROM\n" +
            "\tusers AS User\n" +
            "\tLEFT JOIN user_location_departments AS UserLocationDepartment ON ( UserLocationDepartment.user_id = User.id )\n" +
            "\tLEFT JOIN assigned_users AS AssignedUser ON (\n" +
            "\t\tAssignedUser.user_id = User.id \n" +
            "\t\tAND AssignedUser.is_deleted = 0 \n" +
            "\t\tAND AssignedUser.assigned_checklist_uuid = :assignedChecklistUuid \n" +
            "\t)\n" +
            "\tLEFT JOIN groups AS Role ON ( Role.id = User.group_id )\n" +
            "WHERE\n" +
            "\tUser.is_deleted = 0 \n" +
            "\tAND User.group_id NOT IN ( 1, 7 ) \n" +
            "\tAND ((\n" +
            "\t\tUserLocationDepartment.is_deleted = 0 \n" +
            "\t\tAND UserLocationDepartment.location_id = :locationId \n" +
            "\t\tAND UserLocationDepartment.department_id = :departmentId \n" +
            "\t\t) \n" +
            "\tOR User.is_administrator = 1)\n" +
            "ORDER BY\n" +
            "\tAssignedUser.assigned_checklist_uuid DESC, Role.id ASC\n";
    public static final String GET_ALL_USERS_FOR_ASSIGNMENT = "SELECT\n" +
            "\tDISTINCT User.id,\n" +
            "\tUser.uuid,\n" +
            "\tUser.full_name,\n" +
            "\tUser.group_id,\n" +
            "\tRole.name AS role,\n" +
            "\tAssignedUser.assigned_checklist_uuid  \n" +
            "FROM\n" +
            "\tusers AS User\n" +
            "\tLEFT JOIN user_location_departments AS UserLocationDepartment ON ( UserLocationDepartment.user_id = User.id )\n" +
            "\tLEFT JOIN assigned_users AS AssignedUser ON (\n" +
            "\t\tAssignedUser.user_id = User.id \n" +
            "\t\tAND AssignedUser.is_deleted = 0 \n" +
            "\t\tAND AssignedUser.assigned_checklist_uuid = :assignedChecklistUuid \n" +
            "\t)\n" +
            "\tLEFT JOIN groups AS Role ON ( Role.id = User.group_id )\n" +
            "WHERE\n" +
            "\tUser.is_deleted = 0 \n" +
            "\tAND User.group_id NOT IN ( 1, 7 ) \n" +
            "\tAND ((\n" +
            "\t\tUserLocationDepartment.is_deleted = 0 \n" +
            "\t\tAND UserLocationDepartment.location_id = :locationId \n" +
            "\t\t) \n" +
            "\tOR User.is_administrator = 1)\n" +
            "ORDER BY\n" +
            "\tAssignedUser.assigned_checklist_uuid DESC, Role.id ASC\n";
    public static final String IF_USER_ALREADY_INSERTED = "select * from assigned_users where user_id = :userId and assigned_checklist_uuid = :uuid";

    public static final String IS_CHILD_EXECUTED = "SELECT \n" +
            "        IFNULL( COUNT( COALESCE( AssignedNCW.acknowledged, (SELECT action FROM logs WHERE checklist_element_id = ChecklistElement.id AND ChecklistElement.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18 ) AND assigned_checklist_uuid = :assignedChecklistUuid ORDER BY created DESC LIMIT 1) ) ) / COUNT( ChecklistElement.id ), 1 ) \n" +
            "        FROM \n" +
            "        checklist_elements AS ChecklistElement \n" +
            "        LEFT JOIN assigned_ncw AS AssignedNCW ON ( \n" +
            "        AssignedNCW.checklist_element_id = ChecklistElement.id  \n" +
            "        AND AssignedNCW.assigned_checklist_uuid = :assignedChecklistUuid  \n" +
            "        AND AssignedNCW.is_deleted = 0)\n" +
            "        WHERE \n" +
            "        ChecklistElement.parent_id = :parentId\n" +
            "        AND ChecklistElement.is_deleted = 0\n";

    public static final String GET_PARENT_DETAILS = "SELECT   \n" +
            "        checklist_elements.checklist_id, \n" +
            "        checklist_elements.id, \n" +
            "        checklist_elements.item_type_id, \n" +
            "        checklist_elements.item_id, \n" +
            "        checklist_elements.item_uuid, \n" +
            "        checklist_elements.parent_id, \n" +
            "        checklist_elements.sort_order, \n" +
            "        checklist_elements.sequence_no, \n" +
            "        ParentStep.status,\n" +
            "        IFNULL( checklist_elements.title, '' ) AS title, \n" +
            "        IFNULL( checklist_elements.description, '' ) AS description from checklist_elements " +
            "        LEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = :parentId AND ParentStep.assigned_checklist_uuid =  :checklistUuid AND ParentStep.is_deleted = 0 ) " +
            "        where id = :parentId";

    public static final String GET_NON_EXECUTED_CHILD_ELEMENT = "SELECT AssignedNCW.acknowledged, ChecklistElement.sort_order, ChecklistElement.title, ChecklistElement.item_type_id\n" +
            "                FROM  \n" +
            "                checklist_elements AS ChecklistElement  \n" +
            "                LEFT JOIN assigned_ncw AS AssignedNCW ON (  \n" +
            "                AssignedNCW.checklist_element_id = ChecklistElement.id   \n" +
            "                AND AssignedNCW.assigned_checklist_uuid = :checklistUuid \n" +
            "                AND AssignedNCW.is_deleted = 0) \n" +
            "                WHERE  \n" +
            "                ChecklistElement.parent_id = :parentId \n" +
            "                AND ChecklistElement.is_deleted = 0\n" +
            "\t\t\t\tAND AssignedNCW.acknowledged is NULL\n" +
            "\t\t\t\tAND ChecklistElement.item_type_id != 10\n" +
            "\t\t\t\tLIMIT 1";

    public static final String IS_ANY_ELEMENT_AFTER_DECISION_EXECUTED = "SELECT\n" +
            "        COUNT(ChecklistElement.id)\n" +
            "    FROM\n" +
            "        assigned_checklists AS AssignedChecklist\n" +
            "    LEFT JOIN checklist_elements AS ChecklistElement ON ( ChecklistElement.checklist_id = AssignedChecklist.checklist_id )\n" +
            "    LEFT JOIN checklist_elements AS StepChildElement ON (\n" +
            "         StepChildElement.checklist_id = ChecklistElement.checklist_id\n" +
            "         AND StepChildElement.parent_id = ChecklistElement.id\n" +
            "         AND ChecklistElement.item_type_id IN ( 1, 8, 12 )\n" +
            "         AND StepChildElement.is_deleted = 0\n" +
            "        )\n" +
            "    LEFT JOIN assigned_steps AS AssignedStep ON (\n" +
            "         AssignedStep.assigned_checklist_uuid = AssignedChecklist.uuid\n" +
            "         AND AssignedStep.checklist_element_id = ChecklistElement.id\n" +
            "         AND AssignedStep.is_deleted = 0\n" +
            "        )\n" +
            "    LEFT JOIN assigned_decisions AS AssignedDecision ON (\n" +
            "         AssignedDecision.assigned_checklist_uuid = AssignedChecklist.uuid\n" +
            "         AND AssignedDecision.checklist_element_id = ChecklistElement.id\n" +
            "         AND AssignedDecision.is_deleted = 0\n" +
            "        )\n" +
            "    LEFT JOIN assigned_ncw AS AssignedNCW ON (\n" +
            "         AssignedNCW.assigned_checklist_uuid = AssignedChecklist.uuid\n" +
            "         AND (\n" +
            "          AssignedNCW.checklist_element_id = ChecklistElement.id\n" +
            "          OR AssignedNCW.checklist_element_id = StepChildElement.id\n" +
            "         )\n" +
            "         AND AssignedNCW.is_deleted = 0\n" +
            "        )\n" +
            "    WHERE\n" +
            "        AssignedChecklist.uuid = :assignedChecklistUuid\n" +
            "    AND ChecklistElement.is_deleted = 0\n" +
            "    AND COALESCE( AssignedStep.status,\n" +
            "         CASE\n" +
            "          WHEN AssignedDecision.status IN ( 0, 1 ) THEN\n" +
            "          1 ELSE NULL\n" +
            "         END,\n" +
            "         AssignedNCW.acknowledged,\n" +
            "         (SELECT action FROM logs WHERE ( checklist_element_id = ChecklistElement.id OR checklist_element_id = StepChildElement.id ) AND ChecklistElement.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18 ) AND assigned_checklist_uuid = :assignedChecklistUuid ORDER BY created DESC LIMIT 1),\n" +
            "         0) <> 0";

    public static final String DECISION_PARENT_ID_CLAUSE = "\tAND ChecklistElement.parent_id = :elementId\n";
    public static final String DECISION_SORT_ORDER_CLAUSE = "\tAND ChecklistElement.sort_order\t> :sortOrder";

    public static final String GET_PLACEHOLDER_DETAIL = "SELECT\n" +
            "checklist_elements.id AS elementId,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN coalesce(logs.item_description, checklist_elements.title) ELSE checklist_elements.title END AS title,\n" +
            "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN coalesce(logs.step_action, checklist_elements.description) ELSE coalesce(logs.item_description, checklist_elements.description) END AS description\n" +
            "FROM\n" +
            "checklist_elements\n" +
            "LEFT JOIN logs ON(\n" +
            "logs.action = 19\n" +
            "AND logs.checklist_element_id = checklist_elements.id\n" +
            "AND logs.assigned_checklist_uuid = :checklistUuid \n" +
            ")\n" +
            "WHERE\n" +
            "checklist_elements.checklist_id = :checklistId \n" +
            "AND checklist_elements.is_deleted = 0";
    public static final String GET_UUID_LOGS = "select uuid from logs where logs.checklist_element_id = :checklist_element_id and logs.assigned_checklist_uuid = :assignedChecklistUuid;";
    public static final String GET_CHILDS_BY_PARENT = "select * from checklist_elements where parent_id = :parentId";
    public static final String COMPARE_LOCATION_DEPARTMENT_QUERY = "SELECT (CASE WHEN COUNT(id) > 0 THEN 1 ELSE 0 END)\n" +
            "FROM\n" +
            "\tuser_location_departments\n" +
            "WHERE\n" +
            "\tuser_id = :userId \n" +
            "\tAND location_id = :locationId \n" +
            "\tAND department_id = :departmentId\n" +
            "\tAND is_deleted = 0";
    public static final String COMPARE_LOCATION_QUERY = "SELECT (CASE WHEN COUNT(id) > 0 THEN 1 ELSE 0 END)\n" +
            "FROM\n" +
            "\tuser_location_departments\n" +
            "WHERE\n" +
            "\tuser_id = :userId \n" +
            "\tAND location_id = :locationId \n" +
            "\tAND is_deleted = 0";
    public static final String GET_GROUP_IDS = "SELECT GROUP_CONCAT(id) FROM groups";
    // public static final String GET_QA_USERNAME = "SELECT username FROM users WHERE item_uuid = :itemUuid AND assigned_checklist_uuid = :assignedChecklistUuid";
    public static final String IS_QCM = "SELECT COUNT(UserLocationDepartment.id) " +
            "FROM user_location_departments AS UserLocationDepartment " +
            "INNER JOIN departments AS Department ON ( " +
            "   Department.id = UserLocationDepartment.department_id " +
            ") " +
            "WHERE " +
            "   UserLocationDepartment.is_deleted = 0 " +
            "AND UserLocationDepartment.user_id = :userId " +
            "AND UserLocationDepartment.location_id = :locationId " +
            "AND Department.is_deleted = 0 " +
            "AND Department.short_name = 'QCM'";

    public static final String GET_FILES_BY_ATTRIBUTE_ID = "SELECT assigned_step_resources.uuid,assigned_step_resources.checklist_element_id,assigned_step_resources.assigned_checklist_uuid,\n" +
            "assigned_step_resources.content_type,assigned_step_resources.created,assigned_step_resources.display_file_name,\n" +
            "assigned_step_resources.file_md5_checksum,assigned_step_resources.file_name,assigned_step_resources.is_deleted,\n" +
            "assigned_step_resources.is_downloaded,assigned_step_resources.is_uploaded,assigned_step_resources.item_id,\n" +
            "assigned_step_resources.item_type_id,assigned_step_resources.user_id,assigned_step_resources.sync_status,\n" +
            "assigned_step_resources.modified \n" +
            "from \n" +
            "assigned_step_attributes \n" +
            "INNER join \n" +
            "assigned_step_resources \n" +
            "ON \n" +
            "(assigned_step_attributes.value = assigned_step_resources.uuid and assigned_step_resources.is_deleted = 0) \n" +
            "where\n" +
            "assigned_step_attributes.step_attribute_id = :stepAttributeId\n" +
            " and assigned_step_attributes.is_deleted = 0" +
            " and assigned_step_attributes.assigned_checklist_uuid = :assignedChecklistUuid" +
            " and assigned_step_resources.checklist_element_id = :elementId";
    public static final String GET_UUID_FILE_ALREADY_EXISTS = "SELECT resources.uuid from resources INNER join assigned_step_attributes on(resources.uuid = assigned_step_attributes.value and assigned_step_attributes.step_attribute_id = :stepAttributeid and assigned_step_attributes.is_deleted = 0 and assigned_step_attributes.assigned_checklist_uuid = :assignedChecklistUuid) where resources.file_md5_checksum = :fileMd5Checksum and resources.item_id = :itemId";

    public static final String GET_CHECKLIST_TYPE = "select id, description as name  from checklist_types where is_deleted = 0";
    public static final String GET_ALL_CHECKLIST_TYPE = "select id, description as name from checklist_types where is_deleted = 0 and type <> 3";
    public static final String GET_WORK_ORDER_STATUS_FILTER = "select id, name from workorder_statuses where id not in (4, 6, 7)";

    public static final String GET_ASSIGNED_ITEM_PLACEHOLDERS = "SELECT \n" +
            "ChecklistElement.id,\n" +
            "ChecklistElement.sequence_no,\n" +
            "Placeholder.name,\n" +
            "AssignedItemPlaceholder.value,\n" +
            "AssignedItemPlaceholder.created AS captured_at,\n" +
            "User.full_name AS captured_by\n" +
            "FROM assigned_item_placeholders AssignedItemPlaceholder\n" +
            "LEFT JOIN checklist_elements ChecklistElement ON (ChecklistElement.id = AssignedItemPlaceholder.checklist_element_id)\n" +
            "LEFT JOIN item_placeholders ItemPlaceholder ON (ItemPlaceholder.id = AssignedItemPlaceholder.item_placeholder_id)\n" +
            "LEFT JOIN placeholders Placeholder ON (Placeholder.id = ItemPlaceholder.placeholder_id)\n" +
            "LEFT JOIN users User ON (User.id = AssignedItemPlaceholder.user_id)\n" +
            "WHERE\n" +
            "    AssignedItemPlaceholder.assigned_checklist_uuid = :checklistUUID" +
            "    AND AssignedItemPlaceholder.is_deleted = 0\n" +
            "    AND ChecklistElement.is_deleted = 0\n" +
            "ORDER BY ChecklistElement.sort_order ASC, ItemPlaceholder.sort_order ASC";

    public static final String CHECKLIST_COUNT_ADMIN = "SELECT COUNT (DISTINCT AssignedChecklist.uuid) FROM \n" +
            " assigned_checklists AS AssignedChecklist \n" +
            " INNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id ) \n" +
            " INNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id ) \n" +
            " INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id ) \n" +
            " LEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid ) \n" +
            " LEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id ) \n" +
            " LEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id ) \n" +
            " LEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id ) \n" +
            " LEFT JOIN assigned_departments AS AssignedDepartment ON ( AssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid  \n" +
            "AND AssignedDepartment.is_deleted = 0  \n" +
            " ) \n" +
            "    LEFT OUTER JOIN user_favorites UserFavorite ON (  \n" +
            "    UserFavorite.checklist_id = Checklist.id  \n" +
            "    AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = :userId) \n" +
            "LEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )\n" +
            "\n" +
            "WHERE AssignedChecklist.assignee_type = 1 AND AssignedChecklist.checklist_status IN ( 0, 4 ) " +
            "AND AssignedChecklist.location_id = :locationId AND AssignedChecklist.is_deleted = 0\n";

    public static final String CHECKLIST_COUNT = "SELECT COUNT (DISTINCT AssignedChecklist.uuid) FROM \n" +
            "assigned_checklists AS AssignedChecklist\n" +
            "INNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )        \n" +
            "INNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )        \n" +
            "INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )        \n" +
            "LEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )        \n" +
            "LEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )        \n" +
            "LEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )        \n" +
            "LEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )        \n" +
            "LEFT JOIN assigned_departments AS AssignedDepartment ON ( AssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid         \n" +
            "AND AssignedDepartment.is_deleted = 0)\n" +
            "LEFT OUTER JOIN user_favorites UserFavorite ON (\n" +
            "UserFavorite.checklist_id = Checklist.id         \n" +
            "AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = :userId)        \n" +
            "LEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )       \n" +
            "LEFT JOIN assigned_users AS AssignedUser ON (AssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "AND AssignedUser.is_deleted = 0)   \n" +
            "WHERE AssignedChecklist.assignee_type = 1 AND AssignedChecklist.checklist_status IN ( 0, 4 ) AND" +
            " AssignedChecklist.location_id = :locationId AND AssignedChecklist.is_deleted = 0 \n" +
            "AND AssignedUser.user_id = :userId\n";

    public static final String CHECKLIST_DEPARTMENT_ADMIN_COUNT = "SELECT count (DISTINCT AssignedChecklist.uuid) FROM\n" +
            "        assigned_checklists AS AssignedChecklist\n" +
            "        INNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )\n" +
            "        INNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )\n" +
            "        INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n" +
            "        INNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )\n" +
            "        LEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )\n" +
            "        LEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )\n" +
            "        LEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )\n" +
            "        LEFT JOIN assigned_departments AS AssignedDepartment ON (\n" +
            "        AssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "        AND AssignedDepartment.is_deleted = 0 \n" +
            "        )\n" +
            "          LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "          UserFavorite.checklist_id = Checklist.id \n" +
            "          AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = :userId \n" +
            "        )  \n" +
            "        LEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )\n" +
            "LEFT JOIN location_departments AS LocationDepartment ON (\n" +
            "        LocationDepartment.location_id = AssignedChecklist.location_id \n" +
            "        AND LocationDepartment.department_id = AssignedDepartment.department_id \n" +
            "        AND LocationDepartment.is_deleted = 0)\n" +
            "WHERE\n" +
            "        AssignedChecklist.assignee_type = 2 \n" +
            "        AND AssignedChecklist.checklist_status IN ( 0, 4 ) \n" +
            "        AND AssignedChecklist.location_id = :locationId \n" +
            "        AND AssignedChecklist.is_deleted = 0";

    public static final String CHECKLIST_DEPARTMENT_COUNT = "SELECT count (DISTINCT AssignedChecklist.uuid) FROM\n" +
            "        assigned_checklists AS AssignedChecklist\n" +
            "        INNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )\n" +
            "        INNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )\n" +
            "        INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n" +
            "        INNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )\n" +
            "        LEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )\n" +
            "        LEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )\n" +
            "        LEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )\n" +
            "        LEFT JOIN assigned_departments AS AssignedDepartment ON (\n" +
            "        AssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid \n" +
            "        AND AssignedDepartment.is_deleted = 0 \n" +
            "        )\n" +
            "          LEFT OUTER JOIN user_favorites UserFavorite ON ( \n" +
            "          UserFavorite.checklist_id = Checklist.id \n" +
            "          AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = :userId \n" +
            "        )  \n" +
            "        LEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )\n" +
            "LEFT JOIN user_location_departments AS UserLocationDepartment ON " +
            "(UserLocationDepartment.location_id = AssignedChecklist.location_id\n" +
            "        AND UserLocationDepartment.department_id = AssignedDepartment.department_id \n" +
            "        AND UserLocationDepartment.is_deleted = 0)\n" +
            "WHERE\n" +
            "        AssignedChecklist.assignee_type = 2 \n" +
            "        AND AssignedChecklist.checklist_status IN ( 0, 4 ) \n" +
            "        AND AssignedChecklist.location_id = :locationId \n" +
            "        AND AssignedChecklist.is_deleted = 0\n" +
            "AND UserLocationDepartment.user_id = :userId\n";

    public static final String GET_STEP_EMBEDDED_IMAGES = "select id, parent_id, item_id, " +
            "item_type_id, item_uuid, checklist_id, sort_order, title, description, " +
            "(SELECT \"action\" FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 10 ) AND \"action\" IN ( 18 ) AND assigned_checklist_uuid = :checklistUuid ORDER BY created DESC LIMIT 1) AS imageTextStatus " +
            "from checklist_elements " +
            "where checklist_id = :checklistId AND parent_id = :parentId AND item_type_id = 10 AND is_deleted = 0 " +
            "order by sort_order ASC";

    public static final String GET_SORT_ORDER_SKIPPING_CHILD_EMBEDDED_IMAGE = "SELECT min(checklist_elements.sort_order)\n" +
            "from checklist_elements\n" +
            "LEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = checklist_elements.parent_id)\n" +
            "where checklist_elements.sort_order >= :sortOrder AND  checklist_elements.checklist_id = :checklistId\n" +
            "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or ParentElement.item_type_id = 2);";

    public static final String GET_QR_SCAN_ATTRIBUTE_ITEM = "SELECT\n" +
            "    AssignedStepAttribute.uuid,\n" +
            "    AssignedStepAttribute.item_uuid,\n" +
            "    AssignedStepAttribute.step_attribute_id,\n" +
            "    AssignedStepAttribute.checklist_element_id,\n" +
            "    AssignedStepAttribute.assigned_checklist_uuid,\n" +
            "    AssignedItemPlaceholder.uuid AS entity_uuid,\n" +
            "    AssignedItemPlaceholder.value AS entity_name,\n" +
            "    AssignedItemPlaceholder.model,\n" +
            "    (\n" +
            "    SELECT\n" +
            "        step_action \n" +
            "    FROM\n" +
            "        logs \n" +
            "    WHERE\n" +
            "        assigned_checklist_uuid = AssignedStepAttribute.assigned_checklist_uuid \n" +
            "        AND checklist_element_id = AssignedStepAttribute.checklist_element_id \n" +
            "        AND item_uuid = AssignedStepAttribute.item_uuid \n" +
            "        AND \"action\" = 6 \n" +
            "        AND assigned_to_name = AssignedStepAttribute.uuid \n" +
            "    ORDER BY\n" +
            "        created DESC \n" +
            "        LIMIT 1 \n" +
            "    ) AS verification_reason,\n" +
            "   LocationEquipment.upc_number,\n" +
            "    QrStorage.code AS qr_code\n" +
            "FROM\n" +
            "    assigned_item_placeholders AssignedItemPlaceholder\n" +
            "    LEFT JOIN item_placeholders ItemPlaceholder ON ( ItemPlaceholder.id = AssignedItemPlaceholder.item_placeholder_id )\n" +
            "    LEFT JOIN assigned_step_attributes AssignedStepAttribute ON (\n" +
            "        AssignedStepAttribute.assigned_checklist_uuid = AssignedItemPlaceholder.assigned_checklist_uuid \n" +
            "        AND AssignedStepAttribute.checklist_element_id = AssignedItemPlaceholder.checklist_element_id \n" +
            "        AND AssignedStepAttribute.value = AssignedItemPlaceholder.uuid \n" +
            "        AND AssignedStepAttribute.step_attribute_id = :stepAttributeId\n" +
            "        AND AssignedStepAttribute.item_uuid = :itemUuid\n" +
            "    )\n" +
            "    LEFT JOIN location_equipments AS LocationEquipment ON (LocationEquipment.id = AssignedItemPlaceholder.foreign_key AND AssignedItemPlaceholder.model = 'LocationEquipment')" +
            "    LEFT JOIN qr_storage QrStorage ON ( QrStorage.model = AssignedItemPlaceholder.model AND QrStorage.foreign_key = AssignedItemPlaceholder.foreign_key ) \n" +
            "WHERE\n" +
            "    AssignedItemPlaceholder.assigned_checklist_uuid = :checkListUUID\n" +
            "    AND AssignedItemPlaceholder.checklist_element_id = :stepId \n" +
            "    AND AssignedItemPlaceholder.is_deleted = 0 \n" +
            "    AND AssignedItemPlaceholder.model IS NOT NULL \n" +
            "    AND AssignedItemPlaceholder.foreign_key IS NOT NULL\n" +
            "ORDER BY\n" +
            "    ItemPlaceholder.sort_order ASC;";
}




