package com.icarus.database;

/**
 * Created by Monika Rana on 04/10/2019
 */
public class CaptureDataQueries {

    public static final String ELEMENT_WITH_ATTRIBUTES = "SELECT \n" +
            "    ChecklistElement.id AS checklist_element_id,\n" +
            "    ChecklistElement.item_type_id,\n" +
            "    ChecklistElement.sequence_no,\n" +
            "    CASE\n" +
            "\t\tWHEN Log.item_description IS NULL OR Log.item_description = '' THEN ChecklistElement.title\n" +
            "\t\tELSE Log.item_description\n" +
            "\tEND AS title,\n" +
            "    CASE\n" +
            "\t\tWHEN Log.step_action IS NULL OR Log.step_action = '' THEN ChecklistElement.description\n" +
            "\t\tELSE Log.step_action\n" +
            "\tEND AS description,\n" +
            "    ChecklistElement.description,\n" +
            "    AssignedStep.status,\n" +
            "    COUNT(StepAttribute.id) AS attributes_count\n" +
            "FROM\n" +
            "\t\tchecklist_elements AS ChecklistElement\n" +
            "\tLEFT JOIN\n" +
            "\t\tassigned_steps AS AssignedStep ON (AssignedStep.assigned_checklist_uuid = :assignedChecklistUUID\n" +
            "        AND AssignedStep.checklist_element_id = ChecklistElement.id)\n" +
            "\tINNER JOIN\n" +
            "\t\tstep_attributes AS StepAttribute ON (StepAttribute.step_id = ChecklistElement.item_id)\n" +
            "    LEFT JOIN\n" +
            "        logs Log ON (Log.checklist_element_id = ChecklistElement.id AND Log.assigned_checklist_uuid = :assignedChecklistUUID AND Log.action = 19)\n" +
            "WHERE\n" +
            "    ChecklistElement.checklist_id = :checklistID\n" +
            "\tAND ChecklistElement.item_type_id IN (1, 8, 12)\n" +
            "    AND ChecklistElement.is_deleted = 0\n" +
            "    AND (AssignedStep.is_deleted IS NULL OR AssignedStep.is_deleted = 0)\n" +
            "GROUP BY ChecklistElement.id\n" +
            "HAVING COUNT(StepAttribute.id) > 0\n" +
            "ORDER BY ChecklistElement.sort_order ASC\n";

    public static final String ATTRIBUTES = "SELECT\n" +
            "\tStepAttribute.label,\n" +
            "\tStepAttribute.description,\n" +
            "\tStepAttribute.sort_order,\n" +
            "\tStepAttribute.id,\n"+
            "\tCustomField.type,\n" +
            "\tNULL AS captured_uuid,\n" +
            "\tLog.step_action AS captured_value,\n" +
            "\tNULL AS captured_file,\n" +
            "\tNULL AS content_type,\n" +
            "\tNULL AS file_md5_checksum,\n" +
            "\tNULL AS is_downloaded,\n" +
            "\tLog.username AS captured_by,\n" +
            "\tLog.created AS captured_at\n" +
            "FROM\n" +
            "    assigned_step_attributes AS AssignedStepAttribute\n" +
            "\tINNER JOIN\n" +
            "\t\tstep_attributes AS StepAttribute ON (StepAttribute.id = AssignedStepAttribute.step_attribute_id)\n" +
            "\tINNER JOIN\n" +
            "\t\tcustom_fields AS CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n" +
            "\tLEFT JOIN\n" +
            "\t\tlogs AS Log ON (\n" +
            "\t\t\t(Log.item_uuid = AssignedStepAttribute.item_uuid OR Log.item_uuid = AssignedStepAttribute.uuid)\n" +
            "\t\t\t\tAND \n" +
            "\t\t\tLog.item_description = StepAttribute.label\n" +
            "\t\t)\n" +
            "WHERE\n" +
            "    AssignedStepAttribute.assigned_checklist_uuid = :assignedChecklistUUID\n" +
            "    AND AssignedStepAttribute.checklist_element_id = :elementId\n" +
            "\tAND AssignedStepAttribute.is_deleted = 0\n" +
            "    AND CustomField.type NOT IN ('file', 'qr')\n" +
            "GROUP BY AssignedStepAttribute.step_attribute_id\n" +
            "HAVING MAX(Log.created)\n" +
            "UNION ALL\n" +
            "SELECT\n" +
            "\tStepAttribute.label,\n" +
            "\tStepAttribute.description,\n" +
            "\tStepAttribute.sort_order,\n" +
            "\tStepAttribute.id,\n"+
            "\tCustomField.type,\n" +
            "\tAssignedStepResource.uuid AS captured_uuid,\n" +
            "\tAssignedStepResource.display_file_name AS captured_value,\n" +
            "\tAssignedStepResource.file_name AS captured_file,\n" +
            "\tAssignedStepResource.content_type,\n" +
            "\tAssignedStepResource.file_md5_checksum,\n" +
            "\tAssignedStepResource.is_downloaded,\n" +
            "\tLog.username AS captured_by,\n" +
            "\tLog.created AS captured_at\n" +
            "FROM\n" +
            "\t\tassigned_step_attributes AS AssignedStepAttribute\n" +
            "\tINNER JOIN\n" +
            "\t\tstep_attributes AS StepAttribute ON (StepAttribute.id = AssignedStepAttribute.step_attribute_id)\n" +
            "\tINNER JOIN\n" +
            "\t\tcustom_fields AS CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n" +
            "\tINNER JOIN\n" +
            "\t\tassigned_step_resources AS AssignedStepResource ON (\n" +
            "\t\t\tAssignedStepResource.uuid = AssignedStepAttribute.value\n" +
            "\t\t\tAND AssignedStepResource.checklist_element_id = AssignedStepAttribute.checklist_element_id\n" +
            "\t\t\tAND AssignedStepResource.assigned_checklist_uuid = AssignedStepAttribute.assigned_checklist_uuid\n" +
            "\t\t\tAND AssignedStepResource.is_deleted = 0\n" +
            "\t\t)\n" +
            "    INNER JOIN\n" +
            "    \tlogs AS Log ON (\n" +
            "        \tAssignedStepResource.uuid = Log.step_action\n" +
            "        \tAND Log.assigned_checklist_uuid = AssignedStepResource.assigned_checklist_uuid\n" +
            "        \tAND Log.checklist_element_id = AssignedStepResource.checklist_element_id\n" +
            "            AND Log.action = 7\n" +
            "    \t)\n" +
            "WHERE\n" +
            "\t\tAssignedStepAttribute.assigned_checklist_uuid = :assignedChecklistUUID\n" +
            "AND AssignedStepAttribute.checklist_element_id = :elementId\n" +
            "AND AssignedStepAttribute.is_deleted = 0\n" +
            "AND AssignedStepResource.is_deleted = 0\n" +
            "AND CustomField.type = 'file'\n" +
            "GROUP BY Log.step_action\n" +
            "HAVING MAX(Log.created)\n" +
            "UNION ALL\n" +
            "SELECT\n" +
            "\tStepAttribute.label,\n" +
            "\tStepAttribute.description,\n" +
            "\tStepAttribute.sort_order,\n" +
            "\tStepAttribute.id,\n"+
            "\tCustomField.type,\n" +
            "\tNULL AS captured_uuid,\n" +
            "\tLog.step_action AS captured_value,\n" +
            "\tNULL AS captured_file,\n" +
            "\tNULL AS content_type,\n" +
            "\tNULL AS file_md5_checksum,\n" +
            "\tNULL AS is_downloaded,\n" +
            "\tLog.username AS captured_by,\n" +
            "\tLog.created AS captured_at\n" +
            "FROM\n" +
            "\t\tassigned_step_attributes AS AssignedStepAttribute\n" +
            "\tINNER JOIN\n" +
            "\t\tstep_attributes AS StepAttribute ON (StepAttribute.id = AssignedStepAttribute.step_attribute_id)\n" +
            "\tINNER JOIN\n" +
            "\t\tcustom_fields AS CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n" +
            "\tLEFT JOIN\n" +
            "\t\tlogs AS Log ON (\n" +
            "\t\t\t(Log.item_uuid = AssignedStepAttribute.item_uuid OR Log.item_uuid = AssignedStepAttribute.uuid)\n" +
            "\t\t\tAND\n" +
            "\t\t\tLog.assigned_to_name = AssignedStepAttribute.uuid\n" +
            "\t\t)\n" +
            "WHERE\n" +
            "\t\tAssignedStepAttribute.assigned_checklist_uuid = :assignedChecklistUUID\n" +
            "AND AssignedStepAttribute.checklist_element_id = :elementId\n" +
            "AND AssignedStepAttribute.is_deleted = 0\n" +
            "AND CustomField.type = 'qr'\n" +
            "GROUP BY AssignedStepAttribute.value\n" +
            "HAVING MAX(Log.created);";
}
