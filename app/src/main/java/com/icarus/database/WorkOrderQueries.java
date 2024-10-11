package com.icarus.database;

import com.icarus.constants.SortingTag;

import android.text.TextUtils;

/**
 * Created by Anurag Purwar on 19/1/19.
 */
public class WorkOrderQueries {
    public static final String WORK_ORDER_ID = "SELECT id FROM workorders ORDER BY id ASC LIMIT 1";

    public static final String WORK_ORDER_NOTE_ID = "SELECT id FROM workorder_notes ORDER BY id ASC LIMIT 1";

    public static final String WORK_ORDER_NOTE_DETAIL_ID = "SELECT id FROM workorder_note_details ORDER BY id ASC LIMIT 1";

    public static final String WORK_ORDER_ATTACHMENTS_ID = "SELECT id FROM workorder_attachments ORDER BY id ASC LIMIT 1";

    //public static final String NEGATIVE_ID = "SELECT id FROM :tableName ORDER BY id ASC LIMIT 1";

    public static final String QCM_ID = "SELECT id FROM departments WHERE short_name = 'QCM'";

    public static final String GET_WORK_ORDER = "SELECT \n" +
            "   WorkOrder.id, \n" +
            "   WorkOrder.uuid, \n" +
            "   WorkOrder.title, \n" +
            "   WorkOrder.workorder_priority_id, \n" +
            "   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, \n" +
            "   WorkOrder.workorder_status_id, \n" +
            "   WorkOrderStatus.name AS status, \n" +
            "   WorkOrder.assigned_to_type, \n" +
            "   WorkOrder.assigned_to_id, \n" +
            "   coalesce(Department.name, User.full_name) AS assignee, \n" +
            "   WorkOrder.due_date, \n" +
            "   WorkOrder.modified, \n" +
            "   WorkOrder.sync_status \n" +
            "FROM \n" +
            "   workorders AS WorkOrder \n" +
            "LEFT JOIN workorder_statuses AS WorkOrderStatus ON( \n" +
            "   WorkOrderStatus.id = WorkOrder.workorder_status_id \n" +
            ") \n" +
            "LEFT JOIN departments AS Department ON( \n" +
            "   Department.id = WorkOrder.assigned_to_id \n" +
            "   AND WorkOrder.assigned_to_type = 2 \n" +
            ")  \n" +
            "LEFT JOIN users AS User ON( \n" +
            "   User.id = WorkOrder.assigned_to_id \n" +
            "   AND WorkOrder.assigned_to_type <> 2 \n" +
            ") \n" +
            "WHERE \n" +
            "   WorkOrder.location_id = :locationId \n" +
            "AND WorkOrder.workorder_status_id IN (:statusIds) \n" +
            "AND WorkOrder.workorder_priority_id IN (:priorityLevels) \n" +
            "AND ( \n" +
            "   WorkOrder.id LIKE :keyword \n" +
            "OR WorkOrder.title LIKE :keyword \n" +
            ") \n" +
            "AND CASE WHEN :authorId IS NOT NULL THEN WorkOrder.author_id = :authorId ELSE 1 = 1 END \n" +
            "AND CASE " +
            "       WHEN :assignedTo = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = :userId) " +
            "       WHEN :assignedTo = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (:departmentIds)) " +
            "       WHEN :assignedTo = 3 THEN (WorkOrder.assigned_to_type = 3) " +
            "       ELSE 1 = 1 " +
            "   END \n";

    /*public static final String GET_ALL_WORK_ORDER = "SELECT\n" +
            "    WorkOrder.id,\n" +
            "    WorkOrder.uuid,\n" +
            "    WorkOrder.title,\n" +
            "    WorkOrder.workorder_priority_id,\n" +
            "    CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays,\n" +
            "    WorkOrder.workorder_status_id,\n" +
            "    WorkOrderStatus.name AS status,\n" +
            "    WorkOrder.assigned_to_type,\n" +
            "    WorkOrder.assigned_to_id,\n" +
            "    coalesce(Department.name, User.full_name)AS assignee,\n" +
            "    WorkOrder.due_date,\n" +
            "    WorkOrder.modified,\n" +
            "    WorkOrder.sync_status\n" +
            "FROM\n" +
            "    workorders AS WorkOrder\n" +
            "LEFT JOIN workorder_statuses AS WorkOrderStatus ON(\n" +
            "    WorkOrderStatus.id = WorkOrder.workorder_status_id\n" +
            ")\n" +
            "LEFT JOIN departments AS Department ON(\n" +
            "    Department.id = WorkOrder.assigned_to_id\n" +
            "    AND WorkOrder.assigned_to_type = 2\n" +
            ")\n " +
            "LEFT JOIN users AS User ON(\n" +
            "    User.id = WorkOrder.assigned_to_id\n" +
            "    AND WorkOrder.assigned_to_type <> 2\n" +
            ")\n" +
            "WHERE\n" +
            "    WorkOrder.location_id = :locationId \n" +
            "    AND WorkOrder.title like :keyword ";

    public static final String GET_CREATED_BY_ME_WORK_ORDER = "SELECT\n" +
            "    WorkOrder.id,\n" +
            "    WorkOrder.uuid,\n" +
            "    WorkOrder.title,\n" +
            "    WorkOrder.workorder_priority_id,\n" +
            "    CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays,\n" +
            "    WorkOrder.workorder_status_id,\n" +
            "    WorkOrderStatus.name AS status,\n" +
            "    WorkOrder.assigned_to_type,\n" +
            "    WorkOrder.assigned_to_id,\n" +
            "    coalesce(Department.name, User.full_name)AS assignee,\n" +
            "    WorkOrder.due_date,\n" +
            "    WorkOrder.modified,\n" +
            "    WorkOrder.sync_status\n" +
            "FROM\n" +
            "    workorders AS WorkOrder\n" +
            "LEFT JOIN workorder_statuses AS WorkOrderStatus ON(\n" +
            "    WorkOrderStatus.id = WorkOrder.workorder_status_id\n" +
            ")\n" +
            "LEFT JOIN departments AS Department ON(\n" +
            "    Department.id = WorkOrder.assigned_to_id\n" +
            "    AND WorkOrder.assigned_to_type = 2\n" +
            ")\n " +
            "LEFT JOIN users AS User ON(\n" +
            "    User.id = WorkOrder.assigned_to_id\n" +
            "    AND WorkOrder.assigned_to_type <> 2\n" +
            ")\n" +
            "WHERE\n" +
            "    WorkOrder.location_id = :locationId \n" +
            "    AND WorkOrder.title like :keyword ";

    public static final String GET_VENDER_WORK_ORDER_FOR_USER_QA = "SELECT\n" +
            "    WorkOrder.id,\n" +
            "    WorkOrder.uuid,\n" +
            "    WorkOrder.title,\n" +
            "    WorkOrder.workorder_priority_id,\n" +
            "    CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays,\n" +
            "    WorkOrder.workorder_status_id,\n" +
            "    WorkOrderStatus.name AS status,\n" +
            "    WorkOrder.assigned_to_type,\n" +
            "    WorkOrder.assigned_to_id,\n" +
            "    coalesce(Department.name, User.full_name)AS assignee,\n" +
            "    WorkOrder.due_date,\n" +
            "    WorkOrder.modified,\n" +
            "    WorkOrder.sync_status\n" +
            "FROM\n" +
            "    workorders AS WorkOrder\n" +
            "LEFT JOIN workorder_statuses AS WorkOrderStatus ON(\n" +
            "    WorkOrderStatus.id = WorkOrder.workorder_status_id\n" +
            ")\n" +
            "LEFT JOIN departments AS Department ON(\n" +
            "    Department.id = WorkOrder.assigned_to_id\n" +
            "    AND WorkOrder.assigned_to_type = 2\n" +
            ")\n " +
            " LEFT JOIN user_location_departments UserLocationDepartment ON UserLocationDepartment.user_id= :assignedToId " +
            "LEFT JOIN users AS User ON(\n" +
            "    User.id = WorkOrder.assigned_to_id\n" +
            "    AND WorkOrder.assigned_to_type <> 2\n" +
            ")\n" +
            "WHERE\n" +
            "    WorkOrder.location_id = :locationId \n" +
            "    AND WorkOrder.title like :keyword \n" +
            "    AND WorkOrder.assigned_to_type = 3 ";

    public static final String GET_DEPARTMENT_WORK_ORDER = "SELECT\n" +
            "    DISTINCT WorkOrder.id,\n" +
            "    WorkOrder.uuid,\n" +
            "    WorkOrder.title,\n" +
            "    WorkOrder.workorder_priority_id,\n" +
            "    CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays,\n" +
            "    WorkOrder.workorder_status_id,\n" +
            "    WorkOrderStatus.name AS status,\n" +
            "    WorkOrder.assigned_to_type,\n" +
            "    WorkOrder.assigned_to_id,\n" +
            "    coalesce(Department.name, User.full_name)AS assignee,\n" +
            "    WorkOrder.due_date,\n" +
            "    WorkOrder.modified,\n" +
            "    WorkOrder.sync_status\n" +
            "FROM\n" +
            "    workorders AS WorkOrder\n" +
            "LEFT JOIN workorder_statuses AS WorkOrderStatus ON(\n" +
            "    WorkOrderStatus.id = WorkOrder.workorder_status_id\n" +
            ")\n" +
            "LEFT JOIN departments AS Department ON(\n" +
            "    Department.id = WorkOrder.assigned_to_id\n" +
            "    AND WorkOrder.assigned_to_type = 2\n" +
            ")\n " +
            "LEFT JOIN user_location_departments UserLocationDepartment ON UserLocationDepartment.department_id=Department.id \n" +
            "                                AND UserLocationDepartment.is_deleted=0 " +
            "LEFT JOIN users AS User ON(\n" +
            "    User.id = WorkOrder.assigned_to_id\n" +
            "    AND WorkOrder.assigned_to_type <> 2\n" +
            ")\n" +
            "WHERE\n" +
            "    WorkOrder.location_id = :locationId \n" +
            "    AND WorkOrder.title like :keyword ";*/

    //public static final String WORKORDER_TYPE_CLAUSE = " AND WorkOrder.workorder_status_id IN (:statusId) ";
    public static final String WORKORDER_TYPE_CLAUSE_FOR_USER = "AND (( " +
            "   WorkOrder.assigned_to_type = 1 " +
            "   AND WorkOrder.assigned_to_id = :userId" +
            "   ) " +
            "OR ( WorkOrder.author_id = :userId ) " +
            "OR ( WorkOrder.assigned_to_type = 3 ) " +
            "OR ( " +
            "   WorkOrder.assigned_to_type = 2 " +
            "   AND WorkOrder.assigned_to_id IN (:departmentIds)))";

    public static final String WORKORDER_PRIORITY_CLAUSE = " AND WorkOrder.workorder_priority_id IN (:priorityId) ";

    public static final String WORKORDER_ASSIGNED_TO_ME_CLAUSE = " AND WorkOrder.assigned_to_id = :assignedToId AND WorkOrder.assigned_to_type = 1";
    public static final String WORKORDER_ASSIGNED_TO_DEPARTMENT_CLAUSE_FOR_ADMIN = " AND Department.short_name <> 'QCM' ";
    public static final String WORKORDER_ASSIGNED_TO_DEPARTMENT_CLAUSE = " AND Department.short_name <> 'QCM' AND UserLocationDepartment.user_id= :assignedToId ";
    public static final String WORKORDER_CREATED_BY_CLAUSE = " AND WorkOrder.author_id =:assignedToId ";

    public static final String WORKORDER_AUTHOR_CLAUSE = " AND WorkOrder.author_id = :assignedToId ";

    public static final String ORDERBY_DUE_DATE_ASC = " ORDER BY WorkOrder.due_date ASC ";
    public static final String ORDERBY_DUE_DATE_DESC = " ORDER BY WorkOrder.due_date DESC ";
    public static final String ORDERBY_NAME_ASC = " ORDER BY WorkOrder.title COLLATE NOCASE ASC ";
    public static final String ORDERBY_NAME_DESC = " ORDER BY WorkOrder.title COLLATE NOCASE DESC ";
    public static final String ORDERBY_ID_ASC = " ORDER BY WorkOrder.id ASC ";
    public static final String ORDERBY_ID_DESC = " ORDER BY WorkOrder.id DESC ";

    public static final String WORK_ORDER_STATUS_NAME = "Select name from workorder_statuses WHERE id = :statusId ";
    public static final String WORK_ORDER_UPDATE = "update workorders set sync_status = 0, modified = :currentTime, start_date = :currentTime, workorder_status_id = :workorderStatusId where uuid = :workOrderUuid";
    public static final String WORK_ORDER_UPDATE_TO_USER = "update workorders set sync_status = 0, modified = :currentTime, start_date = :currentTime, workorder_status_id = :workorderStatusId, assigned_to_type = 1, assigned_to_id = :userId where uuid = :workOrderUuid";
    public static final String WORK_ORDER_COMPLETE = "update workorders set sync_status = 0, modified = :currentTime, closed_date = :currentTime, workorder_status_id = 3 where uuid = :workOrderUuid";
    public static final String WORK_ORDER_ATTACHMENT_DOWNLOAD = "update workorder_attachments set is_downloaded = 1 WHERE uuid = :uuid";

    public static String getOrderBy(String sortBy) {
        String orderBy = "";
        if (!TextUtils.isEmpty(sortBy)) {
            if (sortBy.equals(SortingTag.ID_ASC)) {
                orderBy = "WorkOrder.id asc";
            } else if (sortBy.equals(SortingTag.ID_DESC)) {
                orderBy = "WorkOrder.id desc";
            } else if (sortBy.equals(SortingTag.NAME_ASC)) {
                orderBy = "WorkOrder.title asc";
            } else if (sortBy.equals(SortingTag.NAME_DESC)) {
                orderBy = "WorkOrder.title desc";
            } else if (sortBy.equals(SortingTag.DUE_DATE_DESC)) {
                orderBy = "WorkOrder.due_date desc";
            } else {
                orderBy = "WorkOrder.due_date asc";
            }
        } else {
            orderBy = "WorkOrder.due_date asc";
        }
        return orderBy;
    }

    public static final String GET_ROOMS =
            "Select DISTINCT Room.name as Name, " +
                    "Room.id as Id  " +
                    "FROM location_room_equipments LocationRoom  " +
                    "LEFT JOIN rooms Room On Room.id = LocationRoom.room_id  " +
                    "where LocationRoom.location_id = :locationId AND LocationRoom.is_deleted = 0 AND Room.is_deleted = 0";

    public static final String GET_ASSETS =
            "Select EquipmentItems.name as Name, " +
                    "EquipmentItems.id as Id " +
                    "FROM location_room_equipments LocationEquipment " +
                    "LEFT JOIN equipments EquipmentItems On EquipmentItems.id = LocationEquipment.equipment_id " +
                    "where LocationEquipment.location_id= :locationId  AND LocationEquipment.room_id = :roomId AND LocationEquipment.is_deleted = 0 AND EquipmentItems.is_deleted = 0";

    public static final String WORK_ORDER_INFO = "SELECT\n" +
            "\tWorkorder.id,\n" +
            "\tWorkorder.uuid,\n" +
            "\tWorkorder.title,\n" +
            "\tWorkorder.description,\n" +
            "\tWorkorder.due_date,\n" +
            "\tWorkorder.workorder_status_id,\n" +
            "\tWorkorder.assigned_to_id,\n" +
            "\tWorkorder.assigned_to_type,\n" +
            "\tWorkorder.workorder_priority_id,\n" +
            "\tWorkorder.author_id,\n" +
            "\tWorkorder.location_id,\n" +
            "\tWorkorder.checklist_id,\n" +
            "\tWorkorder.workorder_billing_type_id,\n" +
            "\tWorkorder.location_room_id,\n" +
            "\tWorkorder.location_equipment_id,\n" +
            "\tWorkorder.start_date,\n" +
            "\tWorkorder.closed_date,\n" +
            "\tWorkorder.created,\n" +
            "\tWorkorder.modified,\n" +
            "\t( CASE WHEN Workorder.assigned_to_type <> 2 THEN AssignedToUser.full_name ELSE AssignedToDepartment.name  END ) AS Workorder__assigned_to,\n" +
            "\t( CASE WHEN Workorder.assigned_to_type <> 2 THEN AssignedToUser.uuid ELSE AssignedToDepartment.uuid END  ) AS Workorder__assigned_to_uuid,\n" +
            "\tWorkorderStatus.name AS WorkorderStatusName,\n" +
            "\tAuthor.full_name AS Author__full_name,\n" +
            "\tAssignedToUser.id AS assignedToUserId,\n" +
            "\tAssignedToDepartment.id AS assignedToDepartmentId,\n" +
            "\tWorkorderBillingType.name AS WorkorderBillingTypeName,\n" +
            "\tLocation.name AS LocationName,\n" +
            "\tLocationRoomEquipment.id AS LocRoomEquipID,\n" +
            "\tLocationRoomEquipment.location_id AS Loc_id,\n" +
            "\tLocationRoomEquipment.room_id,\n" +
            "\tLocationRoomEquipment.equipment_id,\n" +
            "\tRoom.name AS RoomName,\n" +
            "\tEquipment.name AS EquipmentName \n" +
            "\tFROM\n" +
            "\t\t\tworkorders AS Workorder\n" +
            "\t\t\tLEFT JOIN workorder_statuses AS WorkorderStatus ON ( Workorder.workorder_status_id = WorkorderStatus.id )\n" +
            "\t\t\tLEFT JOIN users AS Author ON ( Workorder.author_id = Author.id )\n" +
            "\t\t\tLEFT JOIN users AS AssignedToUser ON (\n" +
            "\t\t\t\tWorkorder.assigned_to_id = AssignedToUser.id \n" +
            "\t\t\t\tAND Workorder.assigned_to_type <> 2 \n" +
            "\t\t\t)\n" +
            "\t\t\tLEFT JOIN departments AS AssignedToDepartment ON (\n" +
            "\t\t\t\tWorkorder.assigned_to_id = AssignedToDepartment.id \n" +
            "\t\t\t\tAND Workorder.assigned_to_type = 2 \n" +
            "\t\t\t)\n" +
            "\t\t\tLEFT JOIN workorder_billing_types AS WorkorderBillingType ON ( Workorder.workorder_billing_type_id = WorkorderBillingType.id )\n" +
            "\t\t\tLEFT JOIN locations AS Location ON ( Workorder.location_id = Location.id )\n" +
            "\t\t\tLEFT JOIN location_room_equipments AS LocationRoomEquipment ON (\n" +
            "\t\t\t\tWorkorder.location_room_id = LocationRoomEquipment.room_id \n" +
            "\t\t\t\tAND Workorder.location_equipment_id = LocationRoomEquipment.equipment_id \n" +
            "\t\t\t\tAND Workorder.location_id = LocationRoomEquipment.location_id \n" +
            "\t\t\t)\n" +
            "\t\t\tLEFT JOIN rooms AS Room ON ( Room.id = LocationRoomEquipment.room_id )\n" +
            "\t\t\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = LocationRoomEquipment.equipment_id ) \n" +
            "\t\tWHERE\n" +
            "\t\tWorkorder.uuid = :workOrderUuid ";

    public static final String WORK_ORDER_NOTE_INFO = "SELECT  WorkorderNote.workorder_notes, WorkorderNote.created, WorkorderNote.user_id, \n" +
            "                WorkorderNote.id, User.full_name as name  \n" +
            "                FROM workorder_notes AS WorkorderNote " +
            "                LEFT JOIN users as User On (User.id = WorkorderNote.user_id)  \n" +
            "                WHERE WorkorderNote.workorder_id = :workOrderId   ORDER BY WorkorderNote.created ASC";

    public static final String WORK_ORDER_ATTACHMENTS = "SELECT uuid, display_filename, file_md5_checksum, filename, content_type, is_downloaded from workorder_attachments \n" +
            "                AS WorkOrderAttachment WHERE WorkOrderAttachment.workorder_id = :workOrderId";

    public static final String WORK_ORDER_NOTE_DETAIL = "SELECT WorkorderNoteDetail.property, WorkorderNoteDetail.property_key, \n" +
            "                WorkorderNoteDetail.old_value, WorkorderNoteDetail.value, WorkorderNoteDetail.id, \n" +
            "                WorkorderNoteDetail.workorder_note_id FROM workorder_note_details AS WorkorderNoteDetail \n" +
            "                 WHERE WorkorderNoteDetail.workorder_note_id IN (:noteId)";


    public static final String WORK_ORDER_COUNT = "SELECT \n" +
            "   count(WorkOrder.id)\n" +
            "FROM \n" +
            "   workorders AS WorkOrder \n" +
            "LEFT JOIN workorder_statuses AS WorkOrderStatus ON( \n" +
            "   WorkOrderStatus.id = WorkOrder.workorder_status_id \n" +
            ") \n" +
            "LEFT JOIN departments AS Department ON( \n" +
            "   Department.id = WorkOrder.assigned_to_id \n" +
            "   AND WorkOrder.assigned_to_type = 2 \n" +
            ")  \n" +
            "LEFT JOIN users AS User ON( \n" +
            "   User.id = WorkOrder.assigned_to_id \n" +
            "   AND WorkOrder.assigned_to_type <> 2 \n" +
            ") \n" +
            "WHERE \n" +
            "   WorkOrder.location_id = :locationId \n" +
            "AND WorkOrder.workorder_status_id IN (:statusIds) \n" +
            "AND WorkOrder.workorder_priority_id IN (:priorityIds) ";

}
