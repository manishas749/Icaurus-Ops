package com.icarus.database;

public class QueriesExecution {
    public static final String GET_CAPTURED_DATA = "SELECT checklist_elements.sequence_no,step_attributes.label ," +
            "assigned_step_attributes.value,custom_fields.type from assigned_step_attributes  " +
            "left join checklist_elements on (checklist_elements.id = assigned_step_attributes.checklist_element_id) " +
            "left join step_attributes on (step_attributes.id = assigned_step_attributes.step_attribute_id) " +
            "inner join custom_fields on (step_attributes.custom_field_id = custom_fields.id " +
            "and step_attributes.id = assigned_step_attributes.step_attribute_id) " +
            "where " +
            "assigned_step_attributes.assigned_checklist_uuid = :checklistUuid " +
            "  group by sequence_no "+
            "order by checklist_elements.sort_order";



    public static final String GET_CHECKLIST_DETAIL = "SELECT\n" +
            "\tChecklist.id,\n" +
            "\tAssignedChecklist.uuid,\n" +
            "\tAssignedChecklist.checklist_status AS status,\n" +
            "\tChecklistType.type,\n" +
            "\tChecklist.is_sequential,\n" +
            "\tChecklistTitle.title,\n" +
            "\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,\n" +
            "\tRoomEquipment.room_id,\n" +
            "\tRoomEquipment.equipment_id,\n" +
            "\tRoom.name AS room,\n" +
            "\tEquipment.name AS equipment,\n" +
            "\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,\n" +
            "\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus\n" +
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
            "\tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )\n" +
            "WHERE \n" +
            "\tAssignedChecklist.uuid = :assignedChecklistUuid \n" +
            "\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) \n" +
            "\tAND AssignedChecklist.is_deleted = 0";
}
