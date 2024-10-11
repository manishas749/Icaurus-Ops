package com.icarus.database;

public class UndoQueries {

    public final static String UPDATE_NCW_ON_UNDO = "update assigned_ncw set is_deleted = 1 , modified = :date , sync_status = 0 where checklist_element_id = :checklistElementId and is_deleted = 0";
    public final static String UPDATE_STEP_RESOURCES_ON_UNDO = "update assigned_step_resources  set is_deleted = 1 , modified = :date , sync_status = 0 where checklist_element_id = :checklistElementId and is_deleted = 0";
    public final static String UPDATE_STEP_ATTRIBUTES_UNDO = "update assigned_step_attributes  set is_deleted = 1 , modified = :date , sync_status = 0 where checklist_element_id = :checklistElementId and is_deleted = 0";
    public final static String UPDATE_STEP_ON_UNDO = "update assigned_steps set is_deleted = 1 , modified = :date , sync_status = 0 where checklist_element_id = :checklistElementId and is_deleted = 0";
    public final static String UPDATE_DECISIONS_ON_UNDO = "update assigned_decisions set is_deleted = 1 , modified = :date , sync_status = 0 where checklist_element_id = :checklistElementId and is_deleted = 0";

}
