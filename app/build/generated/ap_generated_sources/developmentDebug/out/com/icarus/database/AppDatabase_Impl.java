package com.icarus.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.icarus.dao.AllCaptureDataDao;
import com.icarus.dao.AllCaptureDataDao_Impl;
import com.icarus.dao.AllCheckListDao;
import com.icarus.dao.AllCheckListDao_Impl;
import com.icarus.dao.CancelledCompletedDao;
import com.icarus.dao.CancelledCompletedDao_Impl;
import com.icarus.dao.CheckListDetailDao;
import com.icarus.dao.CheckListDetailDao_Impl;
import com.icarus.dao.ChecklistExecutionDao;
import com.icarus.dao.ChecklistExecutionDao_Impl;
import com.icarus.dao.ChecklistUndoDao;
import com.icarus.dao.ChecklistUndoDao_Impl;
import com.icarus.dao.ClientDao;
import com.icarus.dao.ClientDao_Impl;
import com.icarus.dao.DashboardDao;
import com.icarus.dao.DashboardDao_Impl;
import com.icarus.dao.DepartmentChecklistDao;
import com.icarus.dao.DepartmentChecklistDao_Impl;
import com.icarus.dao.GetChecklistElementDao;
import com.icarus.dao.GetChecklistElementDao_Impl;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.GetSynchronizationDao_Impl;
import com.icarus.dao.LocationDao;
import com.icarus.dao.LocationDao_Impl;
import com.icarus.dao.LogsDao;
import com.icarus.dao.LogsDao_Impl;
import com.icarus.dao.MyAssignmentDao;
import com.icarus.dao.MyAssignmentDao_Impl;
import com.icarus.dao.NotesDao;
import com.icarus.dao.NotesDao_Impl;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao_Impl;
import com.icarus.dao.QRStepAttributeExecutionDao;
import com.icarus.dao.QRStepAttributeExecutionDao_Impl;
import com.icarus.dao.ReportDao;
import com.icarus.dao.ReportDao_Impl;
import com.icarus.dao.UserDao;
import com.icarus.dao.UserDao_Impl;
import com.icarus.dao.UserSuggestionDao;
import com.icarus.dao.UserSuggestionDao_Impl;
import com.icarus.workorder.dao.CreateWorkOrderDao;
import com.icarus.workorder.dao.CreateWorkOrderDao_Impl;
import com.icarus.workorder.dao.WorkOrderCommonDao;
import com.icarus.workorder.dao.WorkOrderCommonDao_Impl;
import com.icarus.workorder.dao.WorkOrderDao;
import com.icarus.workorder.dao.WorkOrderDao_Impl;
import com.icarus.workorder.dao.WorkOrderDetailDao;
import com.icarus.workorder.dao.WorkOrderDetailDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile WorkOrderCommonDao _workOrderCommonDao;

  private volatile WorkOrderDetailDao _workOrderDetailDao;

  private volatile WorkOrderDao _workOrderDao;

  private volatile CreateWorkOrderDao _createWorkOrderDao;

  private volatile AllCheckListDao _allCheckListDao;

  private volatile LocationDao _locationDao;

  private volatile ClientDao _clientDao;

  private volatile MyAssignmentDao _myAssignmentDao;

  private volatile DepartmentChecklistDao _departmentChecklistDao;

  private volatile CancelledCompletedDao _cancelledCompletedDao;

  private volatile CheckListDetailDao _checkListDetailDao;

  private volatile UserSuggestionDao _userSuggestionDao;

  private volatile AllCaptureDataDao _allCaptureDataDao;

  private volatile GetSynchronizationDao _getSynchronizationDao;

  private volatile GetChecklistElementDao _getChecklistElementDao;

  private volatile NotesDao _notesDao;

  private volatile UserDao _userDao;

  private volatile ReportDao _reportDao;

  private volatile PostSynchronizationDao _postSynchronizationDao;

  private volatile QRStepAttributeExecutionDao _qRStepAttributeExecutionDao;

  private volatile DashboardDao _dashboardDao;

  private volatile ChecklistExecutionDao _checklistExecutionDao;

  private volatile LogsDao _logsDao;

  private volatile ChecklistUndoDao _checklistUndoDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(7) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `locations` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `timezone` TEXT NOT NULL, `last_sync_time` TEXT, `last_sync_status` INTEGER, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklists` (`id` INTEGER NOT NULL, `pending_resources_count` INTEGER, `pending_references_count` INTEGER, `checklist_placeholder_count` INTEGER NOT NULL, `assigned_to_id` INTEGER, `author_id` INTEGER NOT NULL, `checklist_status_id` INTEGER, `checklist_type_id` INTEGER NOT NULL, `department_id` INTEGER NOT NULL, `due_at` TEXT, `estimate_hours` TEXT, `is_approval_required` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `is_sequential` INTEGER NOT NULL, `is_template` INTEGER, `modified` TEXT, `parent_id` INTEGER, `uuid` TEXT NOT NULL, `sync_status` INTEGER, PRIMARY KEY(`id`), FOREIGN KEY(`checklist_status_id`) REFERENCES `checklist_statuses`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_type_id`) REFERENCES `checklist_types`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_titles` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `checklist_id` INTEGER NOT NULL, `title` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`checklist_id`) REFERENCES `checklists`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_statuses` (`description` TEXT, `edit_allowed` INTEGER, `id` INTEGER NOT NULL, `is_closed` INTEGER, `is_default` INTEGER, `is_deleted` INTEGER, `is_expired` INTEGER NOT NULL, `modified` TEXT NOT NULL, `name` TEXT NOT NULL, `sort_order` INTEGER, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_types` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `type` TEXT NOT NULL, `description` TEXT, `is_deleted` INTEGER, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_locations` (`checklist_id` INTEGER NOT NULL, `id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `location_id` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`checklist_id`) REFERENCES `checklists`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`location_id`) REFERENCES `locations`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user_location_departments` (`user_id` INTEGER NOT NULL, `id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `location_id` INTEGER NOT NULL, `modified` TEXT NOT NULL, `created` TEXT NOT NULL, `department_id` INTEGER, PRIMARY KEY(`id`), FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`location_id`) REFERENCES `locations`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_execution_permissions` (`id` INTEGER NOT NULL, `group_id` INTEGER NOT NULL, `checklist_type_id` INTEGER NOT NULL, `checklist_status_id` INTEGER NOT NULL, `is_assignable` INTEGER NOT NULL, `is_executable` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`checklist_type_id`) REFERENCES `checklist_types`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`group_id`) REFERENCES `groups`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user_favorites` (`uuid` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `checklist_id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_placeholders` (`id` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, `item_type_id` INTEGER NOT NULL, `placeholder_id` INTEGER NOT NULL, `sort_order` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`placeholder_id`) REFERENCES `placeholders`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_elements` (`checklist_id` INTEGER NOT NULL, `description` TEXT, `id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, `item_type_id` INTEGER NOT NULL, `item_uuid` TEXT, `modified` TEXT NOT NULL, `parent_id` INTEGER, `sequence_no` TEXT NOT NULL, `sort_order` INTEGER NOT NULL, `title` TEXT, PRIMARY KEY(`id`), FOREIGN KEY(`checklist_id`) REFERENCES `checklists`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`item_type_id`) REFERENCES `item_types`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`parent_id`) REFERENCES `checklist_elements`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `departments` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `name` TEXT NOT NULL, `short_name` TEXT, `is_deleted` INTEGER, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_checklists` (`assigned_at` TEXT, `assignee_type` INTEGER NOT NULL, `checklist_id` INTEGER NOT NULL, `checklist_status` INTEGER NOT NULL, `created` TEXT NOT NULL, `department_id` INTEGER NOT NULL, `due_date` TEXT, `is_deleted` INTEGER NOT NULL, `location_id` INTEGER NOT NULL, `modified` TEXT NOT NULL, `started_at` TEXT, `started_by_user_id` INTEGER, `sync_status` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `execution_status` INTEGER NOT NULL, `pending_elements_count` INTEGER NOT NULL, `pending_resources_count` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_id`) REFERENCES `checklists`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`location_id`) REFERENCES `locations`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_users` (`assigned_checklist_uuid` TEXT NOT NULL, `assigned_by` INTEGER NOT NULL, `created` TEXT NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`assigned_by`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`account_uuid` TEXT NOT NULL, `business_name` TEXT, `email` TEXT, `full_name` TEXT, `group_id` INTEGER NOT NULL, `id` INTEGER NOT NULL, `is_administrator` INTEGER NOT NULL, `is_deleted` INTEGER, `last_location_id` INTEGER, `modified` TEXT NOT NULL, `password` TEXT, `username` TEXT NOT NULL, `uuid` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`group_id`) REFERENCES `groups`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`last_location_id`) REFERENCES `locations`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_room_equipments` (`uuid` TEXT NOT NULL, `assigned_checklist_uuid` TEXT NOT NULL, `created` TEXT NOT NULL, `equipment_id` INTEGER, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, `room_id` INTEGER, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `rooms` (`id` INTEGER NOT NULL, `uuid` TEXT, `name` TEXT NOT NULL, `is_default` INTEGER, `is_deleted` INTEGER, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `equipments` (`id` INTEGER NOT NULL, `is_default` INTEGER, `is_deleted` INTEGER, `modified` TEXT NOT NULL, `name` TEXT NOT NULL, `uuid` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_departments` (`uuid` TEXT NOT NULL, `assigned_checklist_uuid` TEXT NOT NULL, `department_id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`department_id`) REFERENCES `departments`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `location_departments` (`id` INTEGER NOT NULL, `location_id` INTEGER NOT NULL, `department_id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`department_id`) REFERENCES `departments`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`location_id`) REFERENCES `locations`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_room_equipments` (`id` INTEGER NOT NULL, `checklist_location_id` INTEGER, `location_room_equipment_id` INTEGER, `room_id` INTEGER, `equipment_id` INTEGER, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`checklist_location_id`) REFERENCES `checklist_locations`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `logs` (`uuid` TEXT NOT NULL, `item_uuid` TEXT, `checklist_id` INTEGER, `checklist_element_id` INTEGER, `action` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `assigned_to` INTEGER, `username` TEXT NOT NULL, `assigned_to_name` TEXT, `assigned_checklist_uuid` TEXT, `item_description` TEXT NOT NULL, `step_action` TEXT, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`checklist_id`) REFERENCES `checklists`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_checklist_pause_times` (`uuid` TEXT NOT NULL, `assigned_checklist_uuid` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `resumed_by_user_id` INTEGER, `reason` TEXT NOT NULL, `is_paused` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workorder_statuses` (`id` INTEGER NOT NULL, `is_default` INTEGER, `name` TEXT NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_ncw` (`uuid` TEXT NOT NULL, `assigned_checklist_uuid` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, `item_type_id` INTEGER NOT NULL, `checklist_element_id` INTEGER, `acknowledged` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_element_id`) REFERENCES `checklist_elements`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workorders` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `due_date` TEXT, `workorder_status_id` INTEGER NOT NULL, `assigned_to_id` INTEGER NOT NULL, `assigned_to_type` INTEGER NOT NULL, `workorder_priority_id` INTEGER NOT NULL, `author_id` INTEGER NOT NULL, `location_id` INTEGER NOT NULL, `checklist_id` INTEGER, `workorder_billing_type_id` INTEGER, `location_equipment_id` INTEGER, `location_room_id` INTEGER, `start_date` TEXT, `closed_date` TEXT, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, `created` TEXT NOT NULL, `execution_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`))");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_workorders_id` ON `workorders` (`id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `groups` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `resources` (`content_type` TEXT, `display_file_name` TEXT, `file_md5_checksum` TEXT NOT NULL, `file_name` TEXT NOT NULL, `id` INTEGER NOT NULL, `file_size` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `is_downloaded` INTEGER NOT NULL, `is_resource` INTEGER NOT NULL, `item_id` INTEGER, `item_type_id` INTEGER, `modified` TEXT NOT NULL, `uuid` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `step_attributes` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `step_id` INTEGER NOT NULL, `custom_field_id` INTEGER NOT NULL, `label` TEXT NOT NULL, `description` TEXT, `sort_order` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`custom_field_id`) REFERENCES `custom_fields`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `custom_fields` (`allow_description` INTEGER NOT NULL, `allow_gallery` INTEGER, `allowed_media_types` TEXT, `default_value` TEXT, `display_as` TEXT, `id` INTEGER NOT NULL, `is_default` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `max_length` INTEGER, `max_value` REAL, `min_length` INTEGER, `min_value` REAL, `model` TEXT NOT NULL, `modified` TEXT NOT NULL, `multiple` INTEGER NOT NULL, `name` TEXT NOT NULL, `possible_values` TEXT, `required` INTEGER NOT NULL, `sort_order` INTEGER NOT NULL, `step_attribute_count` INTEGER NOT NULL, `type` TEXT NOT NULL, `user_roles` TEXT, `uuid` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `location_room_equipments` (`id` INTEGER NOT NULL, `location_id` INTEGER, `room_id` INTEGER, `equipment_id` INTEGER, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `hazards` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `uuid` TEXT NOT NULL, `label` TEXT NOT NULL, `icon` TEXT, `modified` TEXT NOT NULL, `file_md5_checksum` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_ppes` (`id` INTEGER NOT NULL, `ppe_id` INTEGER NOT NULL, `step_id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, `uuid` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`ppe_id`) REFERENCES `ppes`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ppes` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `label` TEXT NOT NULL, `icon` TEXT, `status` INTEGER, `modified` TEXT NOT NULL, `file_md5_checksum` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ncw_hazards` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `uuid` TEXT NOT NULL, `item_id` INTEGER NOT NULL, `item_type_id` INTEGER NOT NULL, `hazard_id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, FOREIGN KEY(`hazard_id`) REFERENCES `hazards`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_decisions` (`assigned_checklist_uuid` TEXT NOT NULL, `checklist_element_id` INTEGER NOT NULL, `created` TEXT NOT NULL, `decision_id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, `status` INTEGER NOT NULL, `sync_status` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_element_id`) REFERENCES `checklist_elements`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_logos` (`uuid` TEXT NOT NULL, `assigned_checklist_uuid` TEXT NOT NULL, `checklist_logo_id` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_logo_id`) REFERENCES `checklist_logos`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `client_logos` (`created` TEXT NOT NULL, `file_md5_checksum` TEXT NOT NULL, `id` INTEGER NOT NULL, `is_downloaded` INTEGER NOT NULL, `modified` TEXT NOT NULL, `name` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `checklist_logos` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `name` TEXT NOT NULL, `checklist_id` INTEGER NOT NULL, `logo_type` INTEGER NOT NULL, `file_md5_checksum` TEXT NOT NULL, `modified` TEXT NOT NULL, `is_downloaded` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`checklist_id`) REFERENCES `checklists`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `resource_links` (`id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, `item_type_id` INTEGER NOT NULL, `link` TEXT NOT NULL, `link_title` TEXT NOT NULL, `modified` TEXT NOT NULL, `uuid` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`item_type_id`) REFERENCES `item_types`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_step_attributes` (`assigned_checklist_uuid` TEXT NOT NULL, `checklist_element_id` INTEGER NOT NULL, `created` TEXT NOT NULL, `is_deleted` INTEGER NOT NULL, `item_uuid` TEXT NOT NULL, `modified` TEXT NOT NULL, `step_attribute_id` INTEGER NOT NULL, `step_id` INTEGER NOT NULL, `sync_status` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `value` TEXT NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_step_resources` (`uuid` TEXT NOT NULL, `assigned_checklist_uuid` TEXT NOT NULL, `checklist_element_id` INTEGER NOT NULL, `item_type_id` INTEGER NOT NULL, `item_id` INTEGER NOT NULL, `display_file_name` TEXT, `file_name` TEXT, `content_type` TEXT, `file_md5_checksum` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `is_deleted` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `is_uploaded` INTEGER NOT NULL, `is_downloaded` INTEGER NOT NULL, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`item_type_id`) REFERENCES `item_types`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_element_id`) REFERENCES `checklist_elements`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_steps` (`assigned_checklist_uuid` TEXT NOT NULL, `checklist_element_id` INTEGER NOT NULL, `created` TEXT NOT NULL, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, `status` INTEGER NOT NULL, `step_id` INTEGER NOT NULL, `sync_status` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_element_id`) REFERENCES `checklist_elements`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workorder_billing_types` (`id` INTEGER NOT NULL, `is_default` INTEGER, `name` TEXT NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workorder_notes` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `workorder_id` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `workorder_notes` TEXT, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, `created` TEXT NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`workorder_id`) REFERENCES `workorders`(`id`) ON UPDATE CASCADE ON DELETE NO ACTION )");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_workorder_notes_id` ON `workorder_notes` (`id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workorder_attachments` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `workorder_id` INTEGER, `display_filename` TEXT NOT NULL, `filename` TEXT NOT NULL, `filesize` INTEGER NOT NULL, `content_type` TEXT, `author_id` INTEGER NOT NULL, `file_md5_checksum` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, `created` TEXT NOT NULL, `is_downloaded` INTEGER NOT NULL, `is_uploaded` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`author_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`workorder_id`) REFERENCES `workorders`(`id`) ON UPDATE CASCADE ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workorder_note_details` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `workorder_note_id` INTEGER NOT NULL, `property` TEXT NOT NULL, `property_key` TEXT NOT NULL, `old_value` TEXT, `value` TEXT, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, `created` TEXT NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`workorder_note_id`) REFERENCES `workorder_notes`(`id`) ON UPDATE CASCADE ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `client_settings` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `name` TEXT NOT NULL, `value` TEXT NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user_suggestions` (`uuid` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `assigned_checklist_uuid` TEXT, `checklist_id` INTEGER, `description` TEXT NOT NULL, `is_deleted` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, `checklist_element_id` INTEGER, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_element_id`) REFERENCES `checklist_elements`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_id`) REFERENCES `checklists`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user_suggestion_attachments` (`uuid` TEXT NOT NULL, `user_suggestion_uuid` TEXT NOT NULL, `display_filename` TEXT NOT NULL, `filename` TEXT NOT NULL, `filesize` INTEGER NOT NULL, `content_type` TEXT, `user_id` INTEGER NOT NULL, `file_md5_checksum` TEXT NOT NULL, `is_uploaded` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`uuid`), FOREIGN KEY(`user_suggestion_uuid`) REFERENCES `user_suggestions`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_types` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `description` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_checklist_comments` (`uuid` TEXT NOT NULL, `assigned_checklist_uuid` TEXT NOT NULL, `user_id` INTEGER NOT NULL, `comment` TEXT, `is_deleted` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `sync_status` INTEGER NOT NULL, `checklist_id` INTEGER NOT NULL, `checklist_element_id` INTEGER, PRIMARY KEY(`uuid`), FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_id`) REFERENCES `checklists`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_element_id`) REFERENCES `checklist_elements`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assigned_item_placeholders` (`uuid` TEXT NOT NULL, `assigned_checklist_uuid` TEXT NOT NULL, `checklist_element_id` INTEGER NOT NULL, `item_placeholder_id` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `value` TEXT NOT NULL, `is_deleted` INTEGER NOT NULL, `created` TEXT NOT NULL, `modified` TEXT NOT NULL, `foreign_key` INTEGER, `model` TEXT, PRIMARY KEY(`uuid`), FOREIGN KEY(`assigned_checklist_uuid`) REFERENCES `assigned_checklists`(`uuid`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`item_placeholder_id`) REFERENCES `item_placeholders`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`checklist_element_id`) REFERENCES `checklist_elements`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `placeholders` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `name` TEXT NOT NULL, `placeholder` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `qr_storage` (`id` INTEGER NOT NULL, `uuid` TEXT NOT NULL, `model` TEXT NOT NULL, `foreign_key` TEXT NOT NULL, `code` TEXT NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `location_rooms` (`id` INTEGER NOT NULL, `location_id` INTEGER, `room_id` INTEGER, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `location_equipments` (`id` INTEGER NOT NULL, `location_id` INTEGER, `equipment_id` INTEGER, `serial_number` TEXT, `is_deleted` INTEGER NOT NULL, `modified` TEXT NOT NULL, `upc_number` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '85df91767bf13c9baca84630b83cc51c')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `locations`");
        _db.execSQL("DROP TABLE IF EXISTS `checklists`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_titles`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_statuses`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_types`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_locations`");
        _db.execSQL("DROP TABLE IF EXISTS `user_location_departments`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_execution_permissions`");
        _db.execSQL("DROP TABLE IF EXISTS `user_favorites`");
        _db.execSQL("DROP TABLE IF EXISTS `item_placeholders`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_elements`");
        _db.execSQL("DROP TABLE IF EXISTS `departments`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_checklists`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_users`");
        _db.execSQL("DROP TABLE IF EXISTS `users`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_room_equipments`");
        _db.execSQL("DROP TABLE IF EXISTS `rooms`");
        _db.execSQL("DROP TABLE IF EXISTS `equipments`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_departments`");
        _db.execSQL("DROP TABLE IF EXISTS `location_departments`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_room_equipments`");
        _db.execSQL("DROP TABLE IF EXISTS `logs`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_checklist_pause_times`");
        _db.execSQL("DROP TABLE IF EXISTS `workorder_statuses`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_ncw`");
        _db.execSQL("DROP TABLE IF EXISTS `workorders`");
        _db.execSQL("DROP TABLE IF EXISTS `groups`");
        _db.execSQL("DROP TABLE IF EXISTS `resources`");
        _db.execSQL("DROP TABLE IF EXISTS `step_attributes`");
        _db.execSQL("DROP TABLE IF EXISTS `custom_fields`");
        _db.execSQL("DROP TABLE IF EXISTS `location_room_equipments`");
        _db.execSQL("DROP TABLE IF EXISTS `hazards`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_ppes`");
        _db.execSQL("DROP TABLE IF EXISTS `ppes`");
        _db.execSQL("DROP TABLE IF EXISTS `ncw_hazards`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_decisions`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_logos`");
        _db.execSQL("DROP TABLE IF EXISTS `client_logos`");
        _db.execSQL("DROP TABLE IF EXISTS `checklist_logos`");
        _db.execSQL("DROP TABLE IF EXISTS `resource_links`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_step_attributes`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_step_resources`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_steps`");
        _db.execSQL("DROP TABLE IF EXISTS `workorder_billing_types`");
        _db.execSQL("DROP TABLE IF EXISTS `workorder_notes`");
        _db.execSQL("DROP TABLE IF EXISTS `workorder_attachments`");
        _db.execSQL("DROP TABLE IF EXISTS `workorder_note_details`");
        _db.execSQL("DROP TABLE IF EXISTS `client_settings`");
        _db.execSQL("DROP TABLE IF EXISTS `user_suggestions`");
        _db.execSQL("DROP TABLE IF EXISTS `user_suggestion_attachments`");
        _db.execSQL("DROP TABLE IF EXISTS `item_types`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_checklist_comments`");
        _db.execSQL("DROP TABLE IF EXISTS `assigned_item_placeholders`");
        _db.execSQL("DROP TABLE IF EXISTS `placeholders`");
        _db.execSQL("DROP TABLE IF EXISTS `qr_storage`");
        _db.execSQL("DROP TABLE IF EXISTS `location_rooms`");
        _db.execSQL("DROP TABLE IF EXISTS `location_equipments`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLocations = new HashMap<String, TableInfo.Column>(5);
        _columnsLocations.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("timezone", new TableInfo.Column("timezone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("last_sync_time", new TableInfo.Column("last_sync_time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("last_sync_status", new TableInfo.Column("last_sync_status", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocations = new TableInfo("locations", _columnsLocations, _foreignKeysLocations, _indicesLocations);
        final TableInfo _existingLocations = TableInfo.read(_db, "locations");
        if (! _infoLocations.equals(_existingLocations)) {
          return new RoomOpenHelper.ValidationResult(false, "locations(com.icarus.entities.LocationEntity).\n"
                  + " Expected:\n" + _infoLocations + "\n"
                  + " Found:\n" + _existingLocations);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklists = new HashMap<String, TableInfo.Column>(19);
        _columnsChecklists.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("pending_resources_count", new TableInfo.Column("pending_resources_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("pending_references_count", new TableInfo.Column("pending_references_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("checklist_placeholder_count", new TableInfo.Column("checklist_placeholder_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("assigned_to_id", new TableInfo.Column("assigned_to_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("author_id", new TableInfo.Column("author_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("checklist_status_id", new TableInfo.Column("checklist_status_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("checklist_type_id", new TableInfo.Column("checklist_type_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("department_id", new TableInfo.Column("department_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("due_at", new TableInfo.Column("due_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("estimate_hours", new TableInfo.Column("estimate_hours", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("is_approval_required", new TableInfo.Column("is_approval_required", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("is_sequential", new TableInfo.Column("is_sequential", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("is_template", new TableInfo.Column("is_template", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("modified", new TableInfo.Column("modified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("parent_id", new TableInfo.Column("parent_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklists = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysChecklists.add(new TableInfo.ForeignKey("checklist_statuses", "NO ACTION", "NO ACTION",Arrays.asList("checklist_status_id"), Arrays.asList("id")));
        _foreignKeysChecklists.add(new TableInfo.ForeignKey("checklist_types", "NO ACTION", "NO ACTION",Arrays.asList("checklist_type_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklists = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklists = new TableInfo("checklists", _columnsChecklists, _foreignKeysChecklists, _indicesChecklists);
        final TableInfo _existingChecklists = TableInfo.read(_db, "checklists");
        if (! _infoChecklists.equals(_existingChecklists)) {
          return new RoomOpenHelper.ValidationResult(false, "checklists(com.icarus.entities.AllChecklistEntity).\n"
                  + " Expected:\n" + _infoChecklists + "\n"
                  + " Found:\n" + _existingChecklists);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistTitles = new HashMap<String, TableInfo.Column>(4);
        _columnsChecklistTitles.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistTitles.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistTitles.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistTitles.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistTitles = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysChecklistTitles.add(new TableInfo.ForeignKey("checklists", "NO ACTION", "NO ACTION",Arrays.asList("checklist_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklistTitles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistTitles = new TableInfo("checklist_titles", _columnsChecklistTitles, _foreignKeysChecklistTitles, _indicesChecklistTitles);
        final TableInfo _existingChecklistTitles = TableInfo.read(_db, "checklist_titles");
        if (! _infoChecklistTitles.equals(_existingChecklistTitles)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_titles(com.icarus.entities.CheckListTitlesEntity).\n"
                  + " Expected:\n" + _infoChecklistTitles + "\n"
                  + " Found:\n" + _existingChecklistTitles);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistStatuses = new HashMap<String, TableInfo.Column>(10);
        _columnsChecklistStatuses.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("edit_allowed", new TableInfo.Column("edit_allowed", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("is_closed", new TableInfo.Column("is_closed", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("is_default", new TableInfo.Column("is_default", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("is_expired", new TableInfo.Column("is_expired", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistStatuses.put("sort_order", new TableInfo.Column("sort_order", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistStatuses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChecklistStatuses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistStatuses = new TableInfo("checklist_statuses", _columnsChecklistStatuses, _foreignKeysChecklistStatuses, _indicesChecklistStatuses);
        final TableInfo _existingChecklistStatuses = TableInfo.read(_db, "checklist_statuses");
        if (! _infoChecklistStatuses.equals(_existingChecklistStatuses)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_statuses(com.icarus.entities.ChecklistStatusEntity).\n"
                  + " Expected:\n" + _infoChecklistStatuses + "\n"
                  + " Found:\n" + _existingChecklistStatuses);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistTypes = new HashMap<String, TableInfo.Column>(6);
        _columnsChecklistTypes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistTypes.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistTypes.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistTypes.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistTypes.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistTypes.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistTypes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChecklistTypes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistTypes = new TableInfo("checklist_types", _columnsChecklistTypes, _foreignKeysChecklistTypes, _indicesChecklistTypes);
        final TableInfo _existingChecklistTypes = TableInfo.read(_db, "checklist_types");
        if (! _infoChecklistTypes.equals(_existingChecklistTypes)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_types(com.icarus.entities.ChecklistTypeEntity).\n"
                  + " Expected:\n" + _infoChecklistTypes + "\n"
                  + " Found:\n" + _existingChecklistTypes);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistLocations = new HashMap<String, TableInfo.Column>(5);
        _columnsChecklistLocations.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLocations.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLocations.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLocations.put("location_id", new TableInfo.Column("location_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLocations.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistLocations = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysChecklistLocations.add(new TableInfo.ForeignKey("checklists", "NO ACTION", "NO ACTION",Arrays.asList("checklist_id"), Arrays.asList("id")));
        _foreignKeysChecklistLocations.add(new TableInfo.ForeignKey("locations", "NO ACTION", "NO ACTION",Arrays.asList("location_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklistLocations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistLocations = new TableInfo("checklist_locations", _columnsChecklistLocations, _foreignKeysChecklistLocations, _indicesChecklistLocations);
        final TableInfo _existingChecklistLocations = TableInfo.read(_db, "checklist_locations");
        if (! _infoChecklistLocations.equals(_existingChecklistLocations)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_locations(com.icarus.entities.ChecklistLocationEntity).\n"
                  + " Expected:\n" + _infoChecklistLocations + "\n"
                  + " Found:\n" + _existingChecklistLocations);
        }
        final HashMap<String, TableInfo.Column> _columnsUserLocationDepartments = new HashMap<String, TableInfo.Column>(7);
        _columnsUserLocationDepartments.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserLocationDepartments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserLocationDepartments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserLocationDepartments.put("location_id", new TableInfo.Column("location_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserLocationDepartments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserLocationDepartments.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserLocationDepartments.put("department_id", new TableInfo.Column("department_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserLocationDepartments = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysUserLocationDepartments.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysUserLocationDepartments.add(new TableInfo.ForeignKey("locations", "NO ACTION", "NO ACTION",Arrays.asList("location_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUserLocationDepartments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserLocationDepartments = new TableInfo("user_location_departments", _columnsUserLocationDepartments, _foreignKeysUserLocationDepartments, _indicesUserLocationDepartments);
        final TableInfo _existingUserLocationDepartments = TableInfo.read(_db, "user_location_departments");
        if (! _infoUserLocationDepartments.equals(_existingUserLocationDepartments)) {
          return new RoomOpenHelper.ValidationResult(false, "user_location_departments(com.icarus.entities.UserLocationsDepartments).\n"
                  + " Expected:\n" + _infoUserLocationDepartments + "\n"
                  + " Found:\n" + _existingUserLocationDepartments);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistExecutionPermissions = new HashMap<String, TableInfo.Column>(7);
        _columnsChecklistExecutionPermissions.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistExecutionPermissions.put("group_id", new TableInfo.Column("group_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistExecutionPermissions.put("checklist_type_id", new TableInfo.Column("checklist_type_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistExecutionPermissions.put("checklist_status_id", new TableInfo.Column("checklist_status_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistExecutionPermissions.put("is_assignable", new TableInfo.Column("is_assignable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistExecutionPermissions.put("is_executable", new TableInfo.Column("is_executable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistExecutionPermissions.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistExecutionPermissions = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysChecklistExecutionPermissions.add(new TableInfo.ForeignKey("checklist_types", "NO ACTION", "NO ACTION",Arrays.asList("checklist_type_id"), Arrays.asList("id")));
        _foreignKeysChecklistExecutionPermissions.add(new TableInfo.ForeignKey("groups", "NO ACTION", "NO ACTION",Arrays.asList("group_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklistExecutionPermissions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistExecutionPermissions = new TableInfo("checklist_execution_permissions", _columnsChecklistExecutionPermissions, _foreignKeysChecklistExecutionPermissions, _indicesChecklistExecutionPermissions);
        final TableInfo _existingChecklistExecutionPermissions = TableInfo.read(_db, "checklist_execution_permissions");
        if (! _infoChecklistExecutionPermissions.equals(_existingChecklistExecutionPermissions)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_execution_permissions(com.icarus.entities.ChecklistExecutionPermission).\n"
                  + " Expected:\n" + _infoChecklistExecutionPermissions + "\n"
                  + " Found:\n" + _existingChecklistExecutionPermissions);
        }
        final HashMap<String, TableInfo.Column> _columnsUserFavorites = new HashMap<String, TableInfo.Column>(7);
        _columnsUserFavorites.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserFavorites.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserFavorites.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserFavorites.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserFavorites.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserFavorites.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserFavorites.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserFavorites = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysUserFavorites.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUserFavorites = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserFavorites = new TableInfo("user_favorites", _columnsUserFavorites, _foreignKeysUserFavorites, _indicesUserFavorites);
        final TableInfo _existingUserFavorites = TableInfo.read(_db, "user_favorites");
        if (! _infoUserFavorites.equals(_existingUserFavorites)) {
          return new RoomOpenHelper.ValidationResult(false, "user_favorites(com.icarus.entities.UserFavouritesEntity).\n"
                  + " Expected:\n" + _infoUserFavorites + "\n"
                  + " Found:\n" + _existingUserFavorites);
        }
        final HashMap<String, TableInfo.Column> _columnsItemPlaceholders = new HashMap<String, TableInfo.Column>(7);
        _columnsItemPlaceholders.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemPlaceholders.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemPlaceholders.put("item_type_id", new TableInfo.Column("item_type_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemPlaceholders.put("placeholder_id", new TableInfo.Column("placeholder_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemPlaceholders.put("sort_order", new TableInfo.Column("sort_order", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemPlaceholders.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemPlaceholders.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemPlaceholders = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysItemPlaceholders.add(new TableInfo.ForeignKey("placeholders", "NO ACTION", "NO ACTION",Arrays.asList("placeholder_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesItemPlaceholders = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItemPlaceholders = new TableInfo("item_placeholders", _columnsItemPlaceholders, _foreignKeysItemPlaceholders, _indicesItemPlaceholders);
        final TableInfo _existingItemPlaceholders = TableInfo.read(_db, "item_placeholders");
        if (! _infoItemPlaceholders.equals(_existingItemPlaceholders)) {
          return new RoomOpenHelper.ValidationResult(false, "item_placeholders(com.icarus.entities.ItemPlaceholdersEntity).\n"
                  + " Expected:\n" + _infoItemPlaceholders + "\n"
                  + " Found:\n" + _existingItemPlaceholders);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistElements = new HashMap<String, TableInfo.Column>(12);
        _columnsChecklistElements.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("item_type_id", new TableInfo.Column("item_type_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("item_uuid", new TableInfo.Column("item_uuid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("parent_id", new TableInfo.Column("parent_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("sequence_no", new TableInfo.Column("sequence_no", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("sort_order", new TableInfo.Column("sort_order", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistElements.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistElements = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysChecklistElements.add(new TableInfo.ForeignKey("checklists", "NO ACTION", "NO ACTION",Arrays.asList("checklist_id"), Arrays.asList("id")));
        _foreignKeysChecklistElements.add(new TableInfo.ForeignKey("item_types", "NO ACTION", "NO ACTION",Arrays.asList("item_type_id"), Arrays.asList("id")));
        _foreignKeysChecklistElements.add(new TableInfo.ForeignKey("checklist_elements", "NO ACTION", "NO ACTION",Arrays.asList("parent_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklistElements = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistElements = new TableInfo("checklist_elements", _columnsChecklistElements, _foreignKeysChecklistElements, _indicesChecklistElements);
        final TableInfo _existingChecklistElements = TableInfo.read(_db, "checklist_elements");
        if (! _infoChecklistElements.equals(_existingChecklistElements)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_elements(com.icarus.entities.ChecklistElementsEntity).\n"
                  + " Expected:\n" + _infoChecklistElements + "\n"
                  + " Found:\n" + _existingChecklistElements);
        }
        final HashMap<String, TableInfo.Column> _columnsDepartments = new HashMap<String, TableInfo.Column>(6);
        _columnsDepartments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepartments.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepartments.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepartments.put("short_name", new TableInfo.Column("short_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepartments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepartments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDepartments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDepartments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDepartments = new TableInfo("departments", _columnsDepartments, _foreignKeysDepartments, _indicesDepartments);
        final TableInfo _existingDepartments = TableInfo.read(_db, "departments");
        if (! _infoDepartments.equals(_existingDepartments)) {
          return new RoomOpenHelper.ValidationResult(false, "departments(com.icarus.entities.DepartmentsEntity).\n"
                  + " Expected:\n" + _infoDepartments + "\n"
                  + " Found:\n" + _existingDepartments);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedChecklists = new HashMap<String, TableInfo.Column>(18);
        _columnsAssignedChecklists.put("assigned_at", new TableInfo.Column("assigned_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("assignee_type", new TableInfo.Column("assignee_type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("checklist_status", new TableInfo.Column("checklist_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("department_id", new TableInfo.Column("department_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("due_date", new TableInfo.Column("due_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("location_id", new TableInfo.Column("location_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("started_at", new TableInfo.Column("started_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("started_by_user_id", new TableInfo.Column("started_by_user_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("execution_status", new TableInfo.Column("execution_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("pending_elements_count", new TableInfo.Column("pending_elements_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklists.put("pending_resources_count", new TableInfo.Column("pending_resources_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedChecklists = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysAssignedChecklists.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysAssignedChecklists.add(new TableInfo.ForeignKey("checklists", "NO ACTION", "NO ACTION",Arrays.asList("checklist_id"), Arrays.asList("id")));
        _foreignKeysAssignedChecklists.add(new TableInfo.ForeignKey("locations", "NO ACTION", "NO ACTION",Arrays.asList("location_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedChecklists = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedChecklists = new TableInfo("assigned_checklists", _columnsAssignedChecklists, _foreignKeysAssignedChecklists, _indicesAssignedChecklists);
        final TableInfo _existingAssignedChecklists = TableInfo.read(_db, "assigned_checklists");
        if (! _infoAssignedChecklists.equals(_existingAssignedChecklists)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_checklists(com.icarus.entities.AssignCheckListEntity).\n"
                  + " Expected:\n" + _infoAssignedChecklists + "\n"
                  + " Found:\n" + _existingAssignedChecklists);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedUsers = new HashMap<String, TableInfo.Column>(8);
        _columnsAssignedUsers.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedUsers.put("assigned_by", new TableInfo.Column("assigned_by", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedUsers.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedUsers.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedUsers.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedUsers.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedUsers.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedUsers.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedUsers = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysAssignedUsers.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysAssignedUsers.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedUsers.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("assigned_by"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedUsers = new TableInfo("assigned_users", _columnsAssignedUsers, _foreignKeysAssignedUsers, _indicesAssignedUsers);
        final TableInfo _existingAssignedUsers = TableInfo.read(_db, "assigned_users");
        if (! _infoAssignedUsers.equals(_existingAssignedUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_users(com.icarus.entities.AssignedUserEntity).\n"
                  + " Expected:\n" + _infoAssignedUsers + "\n"
                  + " Found:\n" + _existingAssignedUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(13);
        _columnsUsers.put("account_uuid", new TableInfo.Column("account_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("business_name", new TableInfo.Column("business_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("full_name", new TableInfo.Column("full_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("group_id", new TableInfo.Column("group_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("is_administrator", new TableInfo.Column("is_administrator", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("last_location_id", new TableInfo.Column("last_location_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysUsers.add(new TableInfo.ForeignKey("groups", "NO ACTION", "NO ACTION",Arrays.asList("group_id"), Arrays.asList("id")));
        _foreignKeysUsers.add(new TableInfo.ForeignKey("locations", "NO ACTION", "NO ACTION",Arrays.asList("last_location_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "users");
        if (! _infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.icarus.entities.UsersEntity).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedRoomEquipments = new HashMap<String, TableInfo.Column>(8);
        _columnsAssignedRoomEquipments.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedRoomEquipments.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedRoomEquipments.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedRoomEquipments.put("equipment_id", new TableInfo.Column("equipment_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedRoomEquipments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedRoomEquipments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedRoomEquipments.put("room_id", new TableInfo.Column("room_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedRoomEquipments.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedRoomEquipments = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAssignedRoomEquipments.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        final HashSet<TableInfo.Index> _indicesAssignedRoomEquipments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedRoomEquipments = new TableInfo("assigned_room_equipments", _columnsAssignedRoomEquipments, _foreignKeysAssignedRoomEquipments, _indicesAssignedRoomEquipments);
        final TableInfo _existingAssignedRoomEquipments = TableInfo.read(_db, "assigned_room_equipments");
        if (! _infoAssignedRoomEquipments.equals(_existingAssignedRoomEquipments)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_room_equipments(com.icarus.entities.AssignRoomEquipmentsEntity).\n"
                  + " Expected:\n" + _infoAssignedRoomEquipments + "\n"
                  + " Found:\n" + _existingAssignedRoomEquipments);
        }
        final HashMap<String, TableInfo.Column> _columnsRooms = new HashMap<String, TableInfo.Column>(6);
        _columnsRooms.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRooms.put("uuid", new TableInfo.Column("uuid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRooms.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRooms.put("is_default", new TableInfo.Column("is_default", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRooms.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRooms.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRooms = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRooms = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRooms = new TableInfo("rooms", _columnsRooms, _foreignKeysRooms, _indicesRooms);
        final TableInfo _existingRooms = TableInfo.read(_db, "rooms");
        if (! _infoRooms.equals(_existingRooms)) {
          return new RoomOpenHelper.ValidationResult(false, "rooms(com.icarus.entities.RoomsEntity).\n"
                  + " Expected:\n" + _infoRooms + "\n"
                  + " Found:\n" + _existingRooms);
        }
        final HashMap<String, TableInfo.Column> _columnsEquipments = new HashMap<String, TableInfo.Column>(6);
        _columnsEquipments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEquipments.put("is_default", new TableInfo.Column("is_default", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEquipments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEquipments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEquipments.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEquipments.put("uuid", new TableInfo.Column("uuid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEquipments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEquipments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEquipments = new TableInfo("equipments", _columnsEquipments, _foreignKeysEquipments, _indicesEquipments);
        final TableInfo _existingEquipments = TableInfo.read(_db, "equipments");
        if (! _infoEquipments.equals(_existingEquipments)) {
          return new RoomOpenHelper.ValidationResult(false, "equipments(com.icarus.entities.EquipmentsEntity).\n"
                  + " Expected:\n" + _infoEquipments + "\n"
                  + " Found:\n" + _existingEquipments);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedDepartments = new HashMap<String, TableInfo.Column>(5);
        _columnsAssignedDepartments.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDepartments.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDepartments.put("department_id", new TableInfo.Column("department_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDepartments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDepartments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedDepartments = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysAssignedDepartments.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedDepartments.add(new TableInfo.ForeignKey("departments", "NO ACTION", "NO ACTION",Arrays.asList("department_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedDepartments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedDepartments = new TableInfo("assigned_departments", _columnsAssignedDepartments, _foreignKeysAssignedDepartments, _indicesAssignedDepartments);
        final TableInfo _existingAssignedDepartments = TableInfo.read(_db, "assigned_departments");
        if (! _infoAssignedDepartments.equals(_existingAssignedDepartments)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_departments(com.icarus.entities.AsssignedDepartmentsEntity).\n"
                  + " Expected:\n" + _infoAssignedDepartments + "\n"
                  + " Found:\n" + _existingAssignedDepartments);
        }
        final HashMap<String, TableInfo.Column> _columnsLocationDepartments = new HashMap<String, TableInfo.Column>(5);
        _columnsLocationDepartments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationDepartments.put("location_id", new TableInfo.Column("location_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationDepartments.put("department_id", new TableInfo.Column("department_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationDepartments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationDepartments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocationDepartments = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysLocationDepartments.add(new TableInfo.ForeignKey("departments", "NO ACTION", "NO ACTION",Arrays.asList("department_id"), Arrays.asList("id")));
        _foreignKeysLocationDepartments.add(new TableInfo.ForeignKey("locations", "NO ACTION", "NO ACTION",Arrays.asList("location_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesLocationDepartments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocationDepartments = new TableInfo("location_departments", _columnsLocationDepartments, _foreignKeysLocationDepartments, _indicesLocationDepartments);
        final TableInfo _existingLocationDepartments = TableInfo.read(_db, "location_departments");
        if (! _infoLocationDepartments.equals(_existingLocationDepartments)) {
          return new RoomOpenHelper.ValidationResult(false, "location_departments(com.icarus.entities.LocationDepartmentsEntity).\n"
                  + " Expected:\n" + _infoLocationDepartments + "\n"
                  + " Found:\n" + _existingLocationDepartments);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistRoomEquipments = new HashMap<String, TableInfo.Column>(7);
        _columnsChecklistRoomEquipments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistRoomEquipments.put("checklist_location_id", new TableInfo.Column("checklist_location_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistRoomEquipments.put("location_room_equipment_id", new TableInfo.Column("location_room_equipment_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistRoomEquipments.put("room_id", new TableInfo.Column("room_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistRoomEquipments.put("equipment_id", new TableInfo.Column("equipment_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistRoomEquipments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistRoomEquipments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistRoomEquipments = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysChecklistRoomEquipments.add(new TableInfo.ForeignKey("checklist_locations", "NO ACTION", "NO ACTION",Arrays.asList("checklist_location_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklistRoomEquipments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistRoomEquipments = new TableInfo("checklist_room_equipments", _columnsChecklistRoomEquipments, _foreignKeysChecklistRoomEquipments, _indicesChecklistRoomEquipments);
        final TableInfo _existingChecklistRoomEquipments = TableInfo.read(_db, "checklist_room_equipments");
        if (! _infoChecklistRoomEquipments.equals(_existingChecklistRoomEquipments)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_room_equipments(com.icarus.entities.ChecklistRoomEquipmentsEntity).\n"
                  + " Expected:\n" + _infoChecklistRoomEquipments + "\n"
                  + " Found:\n" + _existingChecklistRoomEquipments);
        }
        final HashMap<String, TableInfo.Column> _columnsLogs = new HashMap<String, TableInfo.Column>(15);
        _columnsLogs.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("item_uuid", new TableInfo.Column("item_uuid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("action", new TableInfo.Column("action", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("assigned_to", new TableInfo.Column("assigned_to", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("assigned_to_name", new TableInfo.Column("assigned_to_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("item_description", new TableInfo.Column("item_description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("step_action", new TableInfo.Column("step_action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLogs.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLogs = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysLogs.add(new TableInfo.ForeignKey("checklists", "NO ACTION", "NO ACTION",Arrays.asList("checklist_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLogs = new TableInfo("logs", _columnsLogs, _foreignKeysLogs, _indicesLogs);
        final TableInfo _existingLogs = TableInfo.read(_db, "logs");
        if (! _infoLogs.equals(_existingLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "logs(com.icarus.entities.LogsEntity).\n"
                  + " Expected:\n" + _infoLogs + "\n"
                  + " Found:\n" + _existingLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedChecklistPauseTimes = new HashMap<String, TableInfo.Column>(10);
        _columnsAssignedChecklistPauseTimes.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("resumed_by_user_id", new TableInfo.Column("resumed_by_user_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("reason", new TableInfo.Column("reason", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("is_paused", new TableInfo.Column("is_paused", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistPauseTimes.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedChecklistPauseTimes = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysAssignedChecklistPauseTimes.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedChecklistPauseTimes.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedChecklistPauseTimes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedChecklistPauseTimes = new TableInfo("assigned_checklist_pause_times", _columnsAssignedChecklistPauseTimes, _foreignKeysAssignedChecklistPauseTimes, _indicesAssignedChecklistPauseTimes);
        final TableInfo _existingAssignedChecklistPauseTimes = TableInfo.read(_db, "assigned_checklist_pause_times");
        if (! _infoAssignedChecklistPauseTimes.equals(_existingAssignedChecklistPauseTimes)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_checklist_pause_times(com.icarus.entities.AssignedCheckListPauseTimesEntity).\n"
                  + " Expected:\n" + _infoAssignedChecklistPauseTimes + "\n"
                  + " Found:\n" + _existingAssignedChecklistPauseTimes);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkorderStatuses = new HashMap<String, TableInfo.Column>(4);
        _columnsWorkorderStatuses.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderStatuses.put("is_default", new TableInfo.Column("is_default", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderStatuses.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderStatuses.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkorderStatuses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkorderStatuses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkorderStatuses = new TableInfo("workorder_statuses", _columnsWorkorderStatuses, _foreignKeysWorkorderStatuses, _indicesWorkorderStatuses);
        final TableInfo _existingWorkorderStatuses = TableInfo.read(_db, "workorder_statuses");
        if (! _infoWorkorderStatuses.equals(_existingWorkorderStatuses)) {
          return new RoomOpenHelper.ValidationResult(false, "workorder_statuses(com.icarus.entities.WorkOrdeStatusEntity).\n"
                  + " Expected:\n" + _infoWorkorderStatuses + "\n"
                  + " Found:\n" + _existingWorkorderStatuses);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedNcw = new HashMap<String, TableInfo.Column>(11);
        _columnsAssignedNcw.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("item_type_id", new TableInfo.Column("item_type_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("acknowledged", new TableInfo.Column("acknowledged", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedNcw.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedNcw = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysAssignedNcw.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedNcw.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysAssignedNcw.add(new TableInfo.ForeignKey("checklist_elements", "NO ACTION", "NO ACTION",Arrays.asList("checklist_element_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedNcw = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedNcw = new TableInfo("assigned_ncw", _columnsAssignedNcw, _foreignKeysAssignedNcw, _indicesAssignedNcw);
        final TableInfo _existingAssignedNcw = TableInfo.read(_db, "assigned_ncw");
        if (! _infoAssignedNcw.equals(_existingAssignedNcw)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_ncw(com.icarus.entities.AssignedNCWEntity).\n"
                  + " Expected:\n" + _infoAssignedNcw + "\n"
                  + " Found:\n" + _existingAssignedNcw);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkorders = new HashMap<String, TableInfo.Column>(21);
        _columnsWorkorders.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("due_date", new TableInfo.Column("due_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("workorder_status_id", new TableInfo.Column("workorder_status_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("assigned_to_id", new TableInfo.Column("assigned_to_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("assigned_to_type", new TableInfo.Column("assigned_to_type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("workorder_priority_id", new TableInfo.Column("workorder_priority_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("author_id", new TableInfo.Column("author_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("location_id", new TableInfo.Column("location_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("workorder_billing_type_id", new TableInfo.Column("workorder_billing_type_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("location_equipment_id", new TableInfo.Column("location_equipment_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("location_room_id", new TableInfo.Column("location_room_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("start_date", new TableInfo.Column("start_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("closed_date", new TableInfo.Column("closed_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorders.put("execution_status", new TableInfo.Column("execution_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkorders = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkorders = new HashSet<TableInfo.Index>(1);
        _indicesWorkorders.add(new TableInfo.Index("index_workorders_id", true, Arrays.asList("id")));
        final TableInfo _infoWorkorders = new TableInfo("workorders", _columnsWorkorders, _foreignKeysWorkorders, _indicesWorkorders);
        final TableInfo _existingWorkorders = TableInfo.read(_db, "workorders");
        if (! _infoWorkorders.equals(_existingWorkorders)) {
          return new RoomOpenHelper.ValidationResult(false, "workorders(com.icarus.entities.WorkOrderEntity).\n"
                  + " Expected:\n" + _infoWorkorders + "\n"
                  + " Found:\n" + _existingWorkorders);
        }
        final HashMap<String, TableInfo.Column> _columnsGroups = new HashMap<String, TableInfo.Column>(3);
        _columnsGroups.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroups.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroups.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGroups = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGroups = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGroups = new TableInfo("groups", _columnsGroups, _foreignKeysGroups, _indicesGroups);
        final TableInfo _existingGroups = TableInfo.read(_db, "groups");
        if (! _infoGroups.equals(_existingGroups)) {
          return new RoomOpenHelper.ValidationResult(false, "groups(com.icarus.entities.GroupEntity).\n"
                  + " Expected:\n" + _infoGroups + "\n"
                  + " Found:\n" + _existingGroups);
        }
        final HashMap<String, TableInfo.Column> _columnsResources = new HashMap<String, TableInfo.Column>(13);
        _columnsResources.put("content_type", new TableInfo.Column("content_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("display_file_name", new TableInfo.Column("display_file_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("file_md5_checksum", new TableInfo.Column("file_md5_checksum", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("file_name", new TableInfo.Column("file_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("file_size", new TableInfo.Column("file_size", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("is_downloaded", new TableInfo.Column("is_downloaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("is_resource", new TableInfo.Column("is_resource", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("item_id", new TableInfo.Column("item_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("item_type_id", new TableInfo.Column("item_type_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysResources = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesResources = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoResources = new TableInfo("resources", _columnsResources, _foreignKeysResources, _indicesResources);
        final TableInfo _existingResources = TableInfo.read(_db, "resources");
        if (! _infoResources.equals(_existingResources)) {
          return new RoomOpenHelper.ValidationResult(false, "resources(com.icarus.entities.ResourceEntity).\n"
                  + " Expected:\n" + _infoResources + "\n"
                  + " Found:\n" + _existingResources);
        }
        final HashMap<String, TableInfo.Column> _columnsStepAttributes = new HashMap<String, TableInfo.Column>(9);
        _columnsStepAttributes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStepAttributes.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStepAttributes.put("step_id", new TableInfo.Column("step_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStepAttributes.put("custom_field_id", new TableInfo.Column("custom_field_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStepAttributes.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStepAttributes.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStepAttributes.put("sort_order", new TableInfo.Column("sort_order", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStepAttributes.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStepAttributes.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStepAttributes = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysStepAttributes.add(new TableInfo.ForeignKey("custom_fields", "NO ACTION", "NO ACTION",Arrays.asList("custom_field_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesStepAttributes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStepAttributes = new TableInfo("step_attributes", _columnsStepAttributes, _foreignKeysStepAttributes, _indicesStepAttributes);
        final TableInfo _existingStepAttributes = TableInfo.read(_db, "step_attributes");
        if (! _infoStepAttributes.equals(_existingStepAttributes)) {
          return new RoomOpenHelper.ValidationResult(false, "step_attributes(com.icarus.entities.StepAttributesEntity).\n"
                  + " Expected:\n" + _infoStepAttributes + "\n"
                  + " Found:\n" + _existingStepAttributes);
        }
        final HashMap<String, TableInfo.Column> _columnsCustomFields = new HashMap<String, TableInfo.Column>(23);
        _columnsCustomFields.put("allow_description", new TableInfo.Column("allow_description", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("allow_gallery", new TableInfo.Column("allow_gallery", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("allowed_media_types", new TableInfo.Column("allowed_media_types", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("default_value", new TableInfo.Column("default_value", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("display_as", new TableInfo.Column("display_as", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("is_default", new TableInfo.Column("is_default", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("max_length", new TableInfo.Column("max_length", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("max_value", new TableInfo.Column("max_value", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("min_length", new TableInfo.Column("min_length", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("min_value", new TableInfo.Column("min_value", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("model", new TableInfo.Column("model", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("multiple", new TableInfo.Column("multiple", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("possible_values", new TableInfo.Column("possible_values", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("required", new TableInfo.Column("required", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("sort_order", new TableInfo.Column("sort_order", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("step_attribute_count", new TableInfo.Column("step_attribute_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("user_roles", new TableInfo.Column("user_roles", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomFields.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomFields = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomFields = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomFields = new TableInfo("custom_fields", _columnsCustomFields, _foreignKeysCustomFields, _indicesCustomFields);
        final TableInfo _existingCustomFields = TableInfo.read(_db, "custom_fields");
        if (! _infoCustomFields.equals(_existingCustomFields)) {
          return new RoomOpenHelper.ValidationResult(false, "custom_fields(com.icarus.entities.CustomFieldsEntity).\n"
                  + " Expected:\n" + _infoCustomFields + "\n"
                  + " Found:\n" + _existingCustomFields);
        }
        final HashMap<String, TableInfo.Column> _columnsLocationRoomEquipments = new HashMap<String, TableInfo.Column>(6);
        _columnsLocationRoomEquipments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRoomEquipments.put("location_id", new TableInfo.Column("location_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRoomEquipments.put("room_id", new TableInfo.Column("room_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRoomEquipments.put("equipment_id", new TableInfo.Column("equipment_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRoomEquipments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRoomEquipments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocationRoomEquipments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocationRoomEquipments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocationRoomEquipments = new TableInfo("location_room_equipments", _columnsLocationRoomEquipments, _foreignKeysLocationRoomEquipments, _indicesLocationRoomEquipments);
        final TableInfo _existingLocationRoomEquipments = TableInfo.read(_db, "location_room_equipments");
        if (! _infoLocationRoomEquipments.equals(_existingLocationRoomEquipments)) {
          return new RoomOpenHelper.ValidationResult(false, "location_room_equipments(com.icarus.entities.LocationRoomEquipmentsEntity).\n"
                  + " Expected:\n" + _infoLocationRoomEquipments + "\n"
                  + " Found:\n" + _existingLocationRoomEquipments);
        }
        final HashMap<String, TableInfo.Column> _columnsHazards = new HashMap<String, TableInfo.Column>(6);
        _columnsHazards.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHazards.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHazards.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHazards.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHazards.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHazards.put("file_md5_checksum", new TableInfo.Column("file_md5_checksum", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHazards = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHazards = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHazards = new TableInfo("hazards", _columnsHazards, _foreignKeysHazards, _indicesHazards);
        final TableInfo _existingHazards = TableInfo.read(_db, "hazards");
        if (! _infoHazards.equals(_existingHazards)) {
          return new RoomOpenHelper.ValidationResult(false, "hazards(com.icarus.entities.HazardsEntity).\n"
                  + " Expected:\n" + _infoHazards + "\n"
                  + " Found:\n" + _existingHazards);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistPpes = new HashMap<String, TableInfo.Column>(6);
        _columnsChecklistPpes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistPpes.put("ppe_id", new TableInfo.Column("ppe_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistPpes.put("step_id", new TableInfo.Column("step_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistPpes.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistPpes.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistPpes.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistPpes = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysChecklistPpes.add(new TableInfo.ForeignKey("ppes", "NO ACTION", "NO ACTION",Arrays.asList("ppe_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklistPpes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistPpes = new TableInfo("checklist_ppes", _columnsChecklistPpes, _foreignKeysChecklistPpes, _indicesChecklistPpes);
        final TableInfo _existingChecklistPpes = TableInfo.read(_db, "checklist_ppes");
        if (! _infoChecklistPpes.equals(_existingChecklistPpes)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_ppes(com.icarus.entities.CheckListPpesEntity).\n"
                  + " Expected:\n" + _infoChecklistPpes + "\n"
                  + " Found:\n" + _existingChecklistPpes);
        }
        final HashMap<String, TableInfo.Column> _columnsPpes = new HashMap<String, TableInfo.Column>(7);
        _columnsPpes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPpes.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPpes.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPpes.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPpes.put("status", new TableInfo.Column("status", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPpes.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPpes.put("file_md5_checksum", new TableInfo.Column("file_md5_checksum", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPpes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPpes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPpes = new TableInfo("ppes", _columnsPpes, _foreignKeysPpes, _indicesPpes);
        final TableInfo _existingPpes = TableInfo.read(_db, "ppes");
        if (! _infoPpes.equals(_existingPpes)) {
          return new RoomOpenHelper.ValidationResult(false, "ppes(com.icarus.entities.PepesEntity).\n"
                  + " Expected:\n" + _infoPpes + "\n"
                  + " Found:\n" + _existingPpes);
        }
        final HashMap<String, TableInfo.Column> _columnsNcwHazards = new HashMap<String, TableInfo.Column>(7);
        _columnsNcwHazards.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNcwHazards.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNcwHazards.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNcwHazards.put("item_type_id", new TableInfo.Column("item_type_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNcwHazards.put("hazard_id", new TableInfo.Column("hazard_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNcwHazards.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNcwHazards.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNcwHazards = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysNcwHazards.add(new TableInfo.ForeignKey("hazards", "NO ACTION", "NO ACTION",Arrays.asList("hazard_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesNcwHazards = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNcwHazards = new TableInfo("ncw_hazards", _columnsNcwHazards, _foreignKeysNcwHazards, _indicesNcwHazards);
        final TableInfo _existingNcwHazards = TableInfo.read(_db, "ncw_hazards");
        if (! _infoNcwHazards.equals(_existingNcwHazards)) {
          return new RoomOpenHelper.ValidationResult(false, "ncw_hazards(com.icarus.entities.NcwHazardsEntity).\n"
                  + " Expected:\n" + _infoNcwHazards + "\n"
                  + " Found:\n" + _existingNcwHazards);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedDecisions = new HashMap<String, TableInfo.Column>(10);
        _columnsAssignedDecisions.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("decision_id", new TableInfo.Column("decision_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedDecisions.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedDecisions = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysAssignedDecisions.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedDecisions.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysAssignedDecisions.add(new TableInfo.ForeignKey("checklist_elements", "NO ACTION", "NO ACTION",Arrays.asList("checklist_element_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedDecisions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedDecisions = new TableInfo("assigned_decisions", _columnsAssignedDecisions, _foreignKeysAssignedDecisions, _indicesAssignedDecisions);
        final TableInfo _existingAssignedDecisions = TableInfo.read(_db, "assigned_decisions");
        if (! _infoAssignedDecisions.equals(_existingAssignedDecisions)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_decisions(com.icarus.entities.AssignedDecisionEntity).\n"
                  + " Expected:\n" + _infoAssignedDecisions + "\n"
                  + " Found:\n" + _existingAssignedDecisions);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedLogos = new HashMap<String, TableInfo.Column>(6);
        _columnsAssignedLogos.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedLogos.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedLogos.put("checklist_logo_id", new TableInfo.Column("checklist_logo_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedLogos.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedLogos.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedLogos.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedLogos = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysAssignedLogos.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedLogos.add(new TableInfo.ForeignKey("checklist_logos", "NO ACTION", "NO ACTION",Arrays.asList("checklist_logo_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedLogos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedLogos = new TableInfo("assigned_logos", _columnsAssignedLogos, _foreignKeysAssignedLogos, _indicesAssignedLogos);
        final TableInfo _existingAssignedLogos = TableInfo.read(_db, "assigned_logos");
        if (! _infoAssignedLogos.equals(_existingAssignedLogos)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_logos(com.icarus.entities.AssignedLogoEntity).\n"
                  + " Expected:\n" + _infoAssignedLogos + "\n"
                  + " Found:\n" + _existingAssignedLogos);
        }
        final HashMap<String, TableInfo.Column> _columnsClientLogos = new HashMap<String, TableInfo.Column>(8);
        _columnsClientLogos.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientLogos.put("file_md5_checksum", new TableInfo.Column("file_md5_checksum", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientLogos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientLogos.put("is_downloaded", new TableInfo.Column("is_downloaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientLogos.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientLogos.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientLogos.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientLogos.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientLogos = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysClientLogos.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesClientLogos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientLogos = new TableInfo("client_logos", _columnsClientLogos, _foreignKeysClientLogos, _indicesClientLogos);
        final TableInfo _existingClientLogos = TableInfo.read(_db, "client_logos");
        if (! _infoClientLogos.equals(_existingClientLogos)) {
          return new RoomOpenHelper.ValidationResult(false, "client_logos(com.icarus.entities.ClientLogoEntity).\n"
                  + " Expected:\n" + _infoClientLogos + "\n"
                  + " Found:\n" + _existingClientLogos);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklistLogos = new HashMap<String, TableInfo.Column>(8);
        _columnsChecklistLogos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLogos.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLogos.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLogos.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLogos.put("logo_type", new TableInfo.Column("logo_type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLogos.put("file_md5_checksum", new TableInfo.Column("file_md5_checksum", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLogos.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklistLogos.put("is_downloaded", new TableInfo.Column("is_downloaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklistLogos = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysChecklistLogos.add(new TableInfo.ForeignKey("checklists", "NO ACTION", "NO ACTION",Arrays.asList("checklist_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklistLogos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChecklistLogos = new TableInfo("checklist_logos", _columnsChecklistLogos, _foreignKeysChecklistLogos, _indicesChecklistLogos);
        final TableInfo _existingChecklistLogos = TableInfo.read(_db, "checklist_logos");
        if (! _infoChecklistLogos.equals(_existingChecklistLogos)) {
          return new RoomOpenHelper.ValidationResult(false, "checklist_logos(com.icarus.entities.CheckListLogoEntity).\n"
                  + " Expected:\n" + _infoChecklistLogos + "\n"
                  + " Found:\n" + _existingChecklistLogos);
        }
        final HashMap<String, TableInfo.Column> _columnsResourceLinks = new HashMap<String, TableInfo.Column>(8);
        _columnsResourceLinks.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResourceLinks.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResourceLinks.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResourceLinks.put("item_type_id", new TableInfo.Column("item_type_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResourceLinks.put("link", new TableInfo.Column("link", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResourceLinks.put("link_title", new TableInfo.Column("link_title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResourceLinks.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResourceLinks.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysResourceLinks = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysResourceLinks.add(new TableInfo.ForeignKey("item_types", "NO ACTION", "NO ACTION",Arrays.asList("item_type_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesResourceLinks = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoResourceLinks = new TableInfo("resource_links", _columnsResourceLinks, _foreignKeysResourceLinks, _indicesResourceLinks);
        final TableInfo _existingResourceLinks = TableInfo.read(_db, "resource_links");
        if (! _infoResourceLinks.equals(_existingResourceLinks)) {
          return new RoomOpenHelper.ValidationResult(false, "resource_links(com.icarus.entities.ResourcesLinksEntity).\n"
                  + " Expected:\n" + _infoResourceLinks + "\n"
                  + " Found:\n" + _existingResourceLinks);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedStepAttributes = new HashMap<String, TableInfo.Column>(12);
        _columnsAssignedStepAttributes.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("item_uuid", new TableInfo.Column("item_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("step_attribute_id", new TableInfo.Column("step_attribute_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("step_id", new TableInfo.Column("step_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepAttributes.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedStepAttributes = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAssignedStepAttributes.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        final HashSet<TableInfo.Index> _indicesAssignedStepAttributes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedStepAttributes = new TableInfo("assigned_step_attributes", _columnsAssignedStepAttributes, _foreignKeysAssignedStepAttributes, _indicesAssignedStepAttributes);
        final TableInfo _existingAssignedStepAttributes = TableInfo.read(_db, "assigned_step_attributes");
        if (! _infoAssignedStepAttributes.equals(_existingAssignedStepAttributes)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_step_attributes(com.icarus.entities.AssignedStepAttributesEntity).\n"
                  + " Expected:\n" + _infoAssignedStepAttributes + "\n"
                  + " Found:\n" + _existingAssignedStepAttributes);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedStepResources = new HashMap<String, TableInfo.Column>(16);
        _columnsAssignedStepResources.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("item_type_id", new TableInfo.Column("item_type_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("display_file_name", new TableInfo.Column("display_file_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("file_name", new TableInfo.Column("file_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("content_type", new TableInfo.Column("content_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("file_md5_checksum", new TableInfo.Column("file_md5_checksum", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("is_uploaded", new TableInfo.Column("is_uploaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("is_downloaded", new TableInfo.Column("is_downloaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedStepResources.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedStepResources = new HashSet<TableInfo.ForeignKey>(4);
        _foreignKeysAssignedStepResources.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedStepResources.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysAssignedStepResources.add(new TableInfo.ForeignKey("item_types", "NO ACTION", "NO ACTION",Arrays.asList("item_type_id"), Arrays.asList("id")));
        _foreignKeysAssignedStepResources.add(new TableInfo.ForeignKey("checklist_elements", "NO ACTION", "NO ACTION",Arrays.asList("checklist_element_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedStepResources = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedStepResources = new TableInfo("assigned_step_resources", _columnsAssignedStepResources, _foreignKeysAssignedStepResources, _indicesAssignedStepResources);
        final TableInfo _existingAssignedStepResources = TableInfo.read(_db, "assigned_step_resources");
        if (! _infoAssignedStepResources.equals(_existingAssignedStepResources)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_step_resources(com.icarus.entities.AssignedStepFileResourceEntity).\n"
                  + " Expected:\n" + _infoAssignedStepResources + "\n"
                  + " Found:\n" + _existingAssignedStepResources);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedSteps = new HashMap<String, TableInfo.Column>(10);
        _columnsAssignedSteps.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("step_id", new TableInfo.Column("step_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedSteps.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedSteps = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysAssignedSteps.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedSteps.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysAssignedSteps.add(new TableInfo.ForeignKey("checklist_elements", "NO ACTION", "NO ACTION",Arrays.asList("checklist_element_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedSteps = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedSteps = new TableInfo("assigned_steps", _columnsAssignedSteps, _foreignKeysAssignedSteps, _indicesAssignedSteps);
        final TableInfo _existingAssignedSteps = TableInfo.read(_db, "assigned_steps");
        if (! _infoAssignedSteps.equals(_existingAssignedSteps)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_steps(com.icarus.entities.AssignedStepEntity).\n"
                  + " Expected:\n" + _infoAssignedSteps + "\n"
                  + " Found:\n" + _existingAssignedSteps);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkorderBillingTypes = new HashMap<String, TableInfo.Column>(4);
        _columnsWorkorderBillingTypes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderBillingTypes.put("is_default", new TableInfo.Column("is_default", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderBillingTypes.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderBillingTypes.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkorderBillingTypes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkorderBillingTypes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkorderBillingTypes = new TableInfo("workorder_billing_types", _columnsWorkorderBillingTypes, _foreignKeysWorkorderBillingTypes, _indicesWorkorderBillingTypes);
        final TableInfo _existingWorkorderBillingTypes = TableInfo.read(_db, "workorder_billing_types");
        if (! _infoWorkorderBillingTypes.equals(_existingWorkorderBillingTypes)) {
          return new RoomOpenHelper.ValidationResult(false, "workorder_billing_types(com.icarus.entities.WorkOrderBillingTypeEntity).\n"
                  + " Expected:\n" + _infoWorkorderBillingTypes + "\n"
                  + " Found:\n" + _existingWorkorderBillingTypes);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkorderNotes = new HashMap<String, TableInfo.Column>(8);
        _columnsWorkorderNotes.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNotes.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNotes.put("workorder_id", new TableInfo.Column("workorder_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNotes.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNotes.put("workorder_notes", new TableInfo.Column("workorder_notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNotes.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNotes.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNotes.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkorderNotes = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysWorkorderNotes.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysWorkorderNotes.add(new TableInfo.ForeignKey("workorders", "NO ACTION", "CASCADE",Arrays.asList("workorder_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesWorkorderNotes = new HashSet<TableInfo.Index>(1);
        _indicesWorkorderNotes.add(new TableInfo.Index("index_workorder_notes_id", true, Arrays.asList("id")));
        final TableInfo _infoWorkorderNotes = new TableInfo("workorder_notes", _columnsWorkorderNotes, _foreignKeysWorkorderNotes, _indicesWorkorderNotes);
        final TableInfo _existingWorkorderNotes = TableInfo.read(_db, "workorder_notes");
        if (! _infoWorkorderNotes.equals(_existingWorkorderNotes)) {
          return new RoomOpenHelper.ValidationResult(false, "workorder_notes(com.icarus.entities.WorkOrderNotesEntity).\n"
                  + " Expected:\n" + _infoWorkorderNotes + "\n"
                  + " Found:\n" + _existingWorkorderNotes);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkorderAttachments = new HashMap<String, TableInfo.Column>(14);
        _columnsWorkorderAttachments.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("workorder_id", new TableInfo.Column("workorder_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("display_filename", new TableInfo.Column("display_filename", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("filename", new TableInfo.Column("filename", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("filesize", new TableInfo.Column("filesize", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("content_type", new TableInfo.Column("content_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("author_id", new TableInfo.Column("author_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("file_md5_checksum", new TableInfo.Column("file_md5_checksum", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("is_downloaded", new TableInfo.Column("is_downloaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderAttachments.put("is_uploaded", new TableInfo.Column("is_uploaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkorderAttachments = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysWorkorderAttachments.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("author_id"), Arrays.asList("id")));
        _foreignKeysWorkorderAttachments.add(new TableInfo.ForeignKey("workorders", "NO ACTION", "CASCADE",Arrays.asList("workorder_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesWorkorderAttachments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkorderAttachments = new TableInfo("workorder_attachments", _columnsWorkorderAttachments, _foreignKeysWorkorderAttachments, _indicesWorkorderAttachments);
        final TableInfo _existingWorkorderAttachments = TableInfo.read(_db, "workorder_attachments");
        if (! _infoWorkorderAttachments.equals(_existingWorkorderAttachments)) {
          return new RoomOpenHelper.ValidationResult(false, "workorder_attachments(com.icarus.entities.WorkOrderAttachmentsEntity).\n"
                  + " Expected:\n" + _infoWorkorderAttachments + "\n"
                  + " Found:\n" + _existingWorkorderAttachments);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkorderNoteDetails = new HashMap<String, TableInfo.Column>(10);
        _columnsWorkorderNoteDetails.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("workorder_note_id", new TableInfo.Column("workorder_note_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("property", new TableInfo.Column("property", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("property_key", new TableInfo.Column("property_key", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("old_value", new TableInfo.Column("old_value", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("value", new TableInfo.Column("value", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkorderNoteDetails.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkorderNoteDetails = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysWorkorderNoteDetails.add(new TableInfo.ForeignKey("workorder_notes", "NO ACTION", "CASCADE",Arrays.asList("workorder_note_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesWorkorderNoteDetails = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkorderNoteDetails = new TableInfo("workorder_note_details", _columnsWorkorderNoteDetails, _foreignKeysWorkorderNoteDetails, _indicesWorkorderNoteDetails);
        final TableInfo _existingWorkorderNoteDetails = TableInfo.read(_db, "workorder_note_details");
        if (! _infoWorkorderNoteDetails.equals(_existingWorkorderNoteDetails)) {
          return new RoomOpenHelper.ValidationResult(false, "workorder_note_details(com.icarus.entities.WorkOrderNoteDetailEntity).\n"
                  + " Expected:\n" + _infoWorkorderNoteDetails + "\n"
                  + " Found:\n" + _existingWorkorderNoteDetails);
        }
        final HashMap<String, TableInfo.Column> _columnsClientSettings = new HashMap<String, TableInfo.Column>(6);
        _columnsClientSettings.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientSettings.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientSettings.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientSettings.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientSettings.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientSettings.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientSettings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClientSettings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientSettings = new TableInfo("client_settings", _columnsClientSettings, _foreignKeysClientSettings, _indicesClientSettings);
        final TableInfo _existingClientSettings = TableInfo.read(_db, "client_settings");
        if (! _infoClientSettings.equals(_existingClientSettings)) {
          return new RoomOpenHelper.ValidationResult(false, "client_settings(com.icarus.entities.ClientSettingEntity).\n"
                  + " Expected:\n" + _infoClientSettings + "\n"
                  + " Found:\n" + _existingClientSettings);
        }
        final HashMap<String, TableInfo.Column> _columnsUserSuggestions = new HashMap<String, TableInfo.Column>(10);
        _columnsUserSuggestions.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestions.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserSuggestions = new HashSet<TableInfo.ForeignKey>(4);
        _foreignKeysUserSuggestions.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysUserSuggestions.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysUserSuggestions.add(new TableInfo.ForeignKey("checklist_elements", "NO ACTION", "NO ACTION",Arrays.asList("checklist_element_id"), Arrays.asList("id")));
        _foreignKeysUserSuggestions.add(new TableInfo.ForeignKey("checklists", "NO ACTION", "NO ACTION",Arrays.asList("checklist_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUserSuggestions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserSuggestions = new TableInfo("user_suggestions", _columnsUserSuggestions, _foreignKeysUserSuggestions, _indicesUserSuggestions);
        final TableInfo _existingUserSuggestions = TableInfo.read(_db, "user_suggestions");
        if (! _infoUserSuggestions.equals(_existingUserSuggestions)) {
          return new RoomOpenHelper.ValidationResult(false, "user_suggestions(com.icarus.entities.UserSuggestionEntity).\n"
                  + " Expected:\n" + _infoUserSuggestions + "\n"
                  + " Found:\n" + _existingUserSuggestions);
        }
        final HashMap<String, TableInfo.Column> _columnsUserSuggestionAttachments = new HashMap<String, TableInfo.Column>(12);
        _columnsUserSuggestionAttachments.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("user_suggestion_uuid", new TableInfo.Column("user_suggestion_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("display_filename", new TableInfo.Column("display_filename", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("filename", new TableInfo.Column("filename", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("filesize", new TableInfo.Column("filesize", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("content_type", new TableInfo.Column("content_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("file_md5_checksum", new TableInfo.Column("file_md5_checksum", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("is_uploaded", new TableInfo.Column("is_uploaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSuggestionAttachments.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserSuggestionAttachments = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysUserSuggestionAttachments.add(new TableInfo.ForeignKey("user_suggestions", "NO ACTION", "NO ACTION",Arrays.asList("user_suggestion_uuid"), Arrays.asList("uuid")));
        _foreignKeysUserSuggestionAttachments.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUserSuggestionAttachments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserSuggestionAttachments = new TableInfo("user_suggestion_attachments", _columnsUserSuggestionAttachments, _foreignKeysUserSuggestionAttachments, _indicesUserSuggestionAttachments);
        final TableInfo _existingUserSuggestionAttachments = TableInfo.read(_db, "user_suggestion_attachments");
        if (! _infoUserSuggestionAttachments.equals(_existingUserSuggestionAttachments)) {
          return new RoomOpenHelper.ValidationResult(false, "user_suggestion_attachments(com.icarus.entities.UserSuggestionAttachmentsEntity).\n"
                  + " Expected:\n" + _infoUserSuggestionAttachments + "\n"
                  + " Found:\n" + _existingUserSuggestionAttachments);
        }
        final HashMap<String, TableInfo.Column> _columnsItemTypes = new HashMap<String, TableInfo.Column>(3);
        _columnsItemTypes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemTypes.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemTypes.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemTypes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItemTypes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItemTypes = new TableInfo("item_types", _columnsItemTypes, _foreignKeysItemTypes, _indicesItemTypes);
        final TableInfo _existingItemTypes = TableInfo.read(_db, "item_types");
        if (! _infoItemTypes.equals(_existingItemTypes)) {
          return new RoomOpenHelper.ValidationResult(false, "item_types(com.icarus.entities.ItemTypeEntity).\n"
                  + " Expected:\n" + _infoItemTypes + "\n"
                  + " Found:\n" + _existingItemTypes);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedChecklistComments = new HashMap<String, TableInfo.Column>(10);
        _columnsAssignedChecklistComments.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("checklist_id", new TableInfo.Column("checklist_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedChecklistComments.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedChecklistComments = new HashSet<TableInfo.ForeignKey>(4);
        _foreignKeysAssignedChecklistComments.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysAssignedChecklistComments.add(new TableInfo.ForeignKey("checklists", "NO ACTION", "NO ACTION",Arrays.asList("checklist_id"), Arrays.asList("id")));
        _foreignKeysAssignedChecklistComments.add(new TableInfo.ForeignKey("checklist_elements", "NO ACTION", "NO ACTION",Arrays.asList("checklist_element_id"), Arrays.asList("id")));
        _foreignKeysAssignedChecklistComments.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        final HashSet<TableInfo.Index> _indicesAssignedChecklistComments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedChecklistComments = new TableInfo("assigned_checklist_comments", _columnsAssignedChecklistComments, _foreignKeysAssignedChecklistComments, _indicesAssignedChecklistComments);
        final TableInfo _existingAssignedChecklistComments = TableInfo.read(_db, "assigned_checklist_comments");
        if (! _infoAssignedChecklistComments.equals(_existingAssignedChecklistComments)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_checklist_comments(com.icarus.entities.AssignedChecklistCommentsEntity).\n"
                  + " Expected:\n" + _infoAssignedChecklistComments + "\n"
                  + " Found:\n" + _existingAssignedChecklistComments);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignedItemPlaceholders = new HashMap<String, TableInfo.Column>(11);
        _columnsAssignedItemPlaceholders.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("assigned_checklist_uuid", new TableInfo.Column("assigned_checklist_uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("checklist_element_id", new TableInfo.Column("checklist_element_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("item_placeholder_id", new TableInfo.Column("item_placeholder_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("created", new TableInfo.Column("created", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("foreign_key", new TableInfo.Column("foreign_key", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignedItemPlaceholders.put("model", new TableInfo.Column("model", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignedItemPlaceholders = new HashSet<TableInfo.ForeignKey>(4);
        _foreignKeysAssignedItemPlaceholders.add(new TableInfo.ForeignKey("assigned_checklists", "NO ACTION", "NO ACTION",Arrays.asList("assigned_checklist_uuid"), Arrays.asList("uuid")));
        _foreignKeysAssignedItemPlaceholders.add(new TableInfo.ForeignKey("users", "NO ACTION", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysAssignedItemPlaceholders.add(new TableInfo.ForeignKey("item_placeholders", "NO ACTION", "NO ACTION",Arrays.asList("item_placeholder_id"), Arrays.asList("id")));
        _foreignKeysAssignedItemPlaceholders.add(new TableInfo.ForeignKey("checklist_elements", "NO ACTION", "NO ACTION",Arrays.asList("checklist_element_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAssignedItemPlaceholders = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignedItemPlaceholders = new TableInfo("assigned_item_placeholders", _columnsAssignedItemPlaceholders, _foreignKeysAssignedItemPlaceholders, _indicesAssignedItemPlaceholders);
        final TableInfo _existingAssignedItemPlaceholders = TableInfo.read(_db, "assigned_item_placeholders");
        if (! _infoAssignedItemPlaceholders.equals(_existingAssignedItemPlaceholders)) {
          return new RoomOpenHelper.ValidationResult(false, "assigned_item_placeholders(com.icarus.entities.AssignedItemPlaceholderEntity).\n"
                  + " Expected:\n" + _infoAssignedItemPlaceholders + "\n"
                  + " Found:\n" + _existingAssignedItemPlaceholders);
        }
        final HashMap<String, TableInfo.Column> _columnsPlaceholders = new HashMap<String, TableInfo.Column>(4);
        _columnsPlaceholders.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlaceholders.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlaceholders.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlaceholders.put("placeholder", new TableInfo.Column("placeholder", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlaceholders = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlaceholders = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlaceholders = new TableInfo("placeholders", _columnsPlaceholders, _foreignKeysPlaceholders, _indicesPlaceholders);
        final TableInfo _existingPlaceholders = TableInfo.read(_db, "placeholders");
        if (! _infoPlaceholders.equals(_existingPlaceholders)) {
          return new RoomOpenHelper.ValidationResult(false, "placeholders(com.icarus.entities.PlaceholderEntity).\n"
                  + " Expected:\n" + _infoPlaceholders + "\n"
                  + " Found:\n" + _existingPlaceholders);
        }
        final HashMap<String, TableInfo.Column> _columnsQrStorage = new HashMap<String, TableInfo.Column>(6);
        _columnsQrStorage.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQrStorage.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQrStorage.put("model", new TableInfo.Column("model", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQrStorage.put("foreign_key", new TableInfo.Column("foreign_key", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQrStorage.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQrStorage.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQrStorage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQrStorage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQrStorage = new TableInfo("qr_storage", _columnsQrStorage, _foreignKeysQrStorage, _indicesQrStorage);
        final TableInfo _existingQrStorage = TableInfo.read(_db, "qr_storage");
        if (! _infoQrStorage.equals(_existingQrStorage)) {
          return new RoomOpenHelper.ValidationResult(false, "qr_storage(com.icarus.entities.QRStorageEntity).\n"
                  + " Expected:\n" + _infoQrStorage + "\n"
                  + " Found:\n" + _existingQrStorage);
        }
        final HashMap<String, TableInfo.Column> _columnsLocationRooms = new HashMap<String, TableInfo.Column>(5);
        _columnsLocationRooms.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRooms.put("location_id", new TableInfo.Column("location_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRooms.put("room_id", new TableInfo.Column("room_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRooms.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationRooms.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocationRooms = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocationRooms = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocationRooms = new TableInfo("location_rooms", _columnsLocationRooms, _foreignKeysLocationRooms, _indicesLocationRooms);
        final TableInfo _existingLocationRooms = TableInfo.read(_db, "location_rooms");
        if (! _infoLocationRooms.equals(_existingLocationRooms)) {
          return new RoomOpenHelper.ValidationResult(false, "location_rooms(com.icarus.entities.LocationRoomEntity).\n"
                  + " Expected:\n" + _infoLocationRooms + "\n"
                  + " Found:\n" + _existingLocationRooms);
        }
        final HashMap<String, TableInfo.Column> _columnsLocationEquipments = new HashMap<String, TableInfo.Column>(7);
        _columnsLocationEquipments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEquipments.put("location_id", new TableInfo.Column("location_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEquipments.put("equipment_id", new TableInfo.Column("equipment_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEquipments.put("serial_number", new TableInfo.Column("serial_number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEquipments.put("is_deleted", new TableInfo.Column("is_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEquipments.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEquipments.put("upc_number", new TableInfo.Column("upc_number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocationEquipments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocationEquipments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocationEquipments = new TableInfo("location_equipments", _columnsLocationEquipments, _foreignKeysLocationEquipments, _indicesLocationEquipments);
        final TableInfo _existingLocationEquipments = TableInfo.read(_db, "location_equipments");
        if (! _infoLocationEquipments.equals(_existingLocationEquipments)) {
          return new RoomOpenHelper.ValidationResult(false, "location_equipments(com.icarus.entities.LocationEquipmentsEntity).\n"
                  + " Expected:\n" + _infoLocationEquipments + "\n"
                  + " Found:\n" + _existingLocationEquipments);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "85df91767bf13c9baca84630b83cc51c", "b84f22353a92dcabf7a4dd9c7b47d005");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "locations","checklists","checklist_titles","checklist_statuses","checklist_types","checklist_locations","user_location_departments","checklist_execution_permissions","user_favorites","item_placeholders","checklist_elements","departments","assigned_checklists","assigned_users","users","assigned_room_equipments","rooms","equipments","assigned_departments","location_departments","checklist_room_equipments","logs","assigned_checklist_pause_times","workorder_statuses","assigned_ncw","workorders","groups","resources","step_attributes","custom_fields","location_room_equipments","hazards","checklist_ppes","ppes","ncw_hazards","assigned_decisions","assigned_logos","client_logos","checklist_logos","resource_links","assigned_step_attributes","assigned_step_resources","assigned_steps","workorder_billing_types","workorder_notes","workorder_attachments","workorder_note_details","client_settings","user_suggestions","user_suggestion_attachments","item_types","assigned_checklist_comments","assigned_item_placeholders","placeholders","qr_storage","location_rooms","location_equipments");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `locations`");
      _db.execSQL("DELETE FROM `checklist_titles`");
      _db.execSQL("DELETE FROM `checklist_locations`");
      _db.execSQL("DELETE FROM `checklists`");
      _db.execSQL("DELETE FROM `checklist_statuses`");
      _db.execSQL("DELETE FROM `checklist_execution_permissions`");
      _db.execSQL("DELETE FROM `checklist_types`");
      _db.execSQL("DELETE FROM `user_location_departments`");
      _db.execSQL("DELETE FROM `user_favorites`");
      _db.execSQL("DELETE FROM `item_placeholders`");
      _db.execSQL("DELETE FROM `checklist_elements`");
      _db.execSQL("DELETE FROM `departments`");
      _db.execSQL("DELETE FROM `assigned_users`");
      _db.execSQL("DELETE FROM `assigned_room_equipments`");
      _db.execSQL("DELETE FROM `assigned_departments`");
      _db.execSQL("DELETE FROM `assigned_checklists`");
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `rooms`");
      _db.execSQL("DELETE FROM `equipments`");
      _db.execSQL("DELETE FROM `location_departments`");
      _db.execSQL("DELETE FROM `checklist_room_equipments`");
      _db.execSQL("DELETE FROM `logs`");
      _db.execSQL("DELETE FROM `assigned_checklist_pause_times`");
      _db.execSQL("DELETE FROM `workorder_statuses`");
      _db.execSQL("DELETE FROM `assigned_ncw`");
      _db.execSQL("DELETE FROM `workorders`");
      _db.execSQL("DELETE FROM `groups`");
      _db.execSQL("DELETE FROM `resources`");
      _db.execSQL("DELETE FROM `step_attributes`");
      _db.execSQL("DELETE FROM `custom_fields`");
      _db.execSQL("DELETE FROM `location_room_equipments`");
      _db.execSQL("DELETE FROM `hazards`");
      _db.execSQL("DELETE FROM `checklist_ppes`");
      _db.execSQL("DELETE FROM `ppes`");
      _db.execSQL("DELETE FROM `ncw_hazards`");
      _db.execSQL("DELETE FROM `assigned_decisions`");
      _db.execSQL("DELETE FROM `assigned_logos`");
      _db.execSQL("DELETE FROM `client_logos`");
      _db.execSQL("DELETE FROM `checklist_logos`");
      _db.execSQL("DELETE FROM `resource_links`");
      _db.execSQL("DELETE FROM `assigned_step_attributes`");
      _db.execSQL("DELETE FROM `assigned_step_resources`");
      _db.execSQL("DELETE FROM `assigned_steps`");
      _db.execSQL("DELETE FROM `workorder_billing_types`");
      _db.execSQL("DELETE FROM `workorder_notes`");
      _db.execSQL("DELETE FROM `workorder_attachments`");
      _db.execSQL("DELETE FROM `workorder_note_details`");
      _db.execSQL("DELETE FROM `client_settings`");
      _db.execSQL("DELETE FROM `user_suggestion_attachments`");
      _db.execSQL("DELETE FROM `user_suggestions`");
      _db.execSQL("DELETE FROM `item_types`");
      _db.execSQL("DELETE FROM `assigned_checklist_comments`");
      _db.execSQL("DELETE FROM `assigned_item_placeholders`");
      _db.execSQL("DELETE FROM `placeholders`");
      _db.execSQL("DELETE FROM `qr_storage`");
      _db.execSQL("DELETE FROM `location_rooms`");
      _db.execSQL("DELETE FROM `location_equipments`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public WorkOrderCommonDao workOrderCommonDao() {
    if (_workOrderCommonDao != null) {
      return _workOrderCommonDao;
    } else {
      synchronized(this) {
        if(_workOrderCommonDao == null) {
          _workOrderCommonDao = new WorkOrderCommonDao_Impl(this);
        }
        return _workOrderCommonDao;
      }
    }
  }

  @Override
  public WorkOrderDetailDao workOrderDetailDao() {
    if (_workOrderDetailDao != null) {
      return _workOrderDetailDao;
    } else {
      synchronized(this) {
        if(_workOrderDetailDao == null) {
          _workOrderDetailDao = new WorkOrderDetailDao_Impl(this);
        }
        return _workOrderDetailDao;
      }
    }
  }

  @Override
  public WorkOrderDao workOrderDao() {
    if (_workOrderDao != null) {
      return _workOrderDao;
    } else {
      synchronized(this) {
        if(_workOrderDao == null) {
          _workOrderDao = new WorkOrderDao_Impl(this);
        }
        return _workOrderDao;
      }
    }
  }

  @Override
  public CreateWorkOrderDao createWorkOrderDao() {
    if (_createWorkOrderDao != null) {
      return _createWorkOrderDao;
    } else {
      synchronized(this) {
        if(_createWorkOrderDao == null) {
          _createWorkOrderDao = new CreateWorkOrderDao_Impl(this);
        }
        return _createWorkOrderDao;
      }
    }
  }

  @Override
  public AllCheckListDao allCheckListDao() {
    if (_allCheckListDao != null) {
      return _allCheckListDao;
    } else {
      synchronized(this) {
        if(_allCheckListDao == null) {
          _allCheckListDao = new AllCheckListDao_Impl(this);
        }
        return _allCheckListDao;
      }
    }
  }

  @Override
  public LocationDao locationDao() {
    if (_locationDao != null) {
      return _locationDao;
    } else {
      synchronized(this) {
        if(_locationDao == null) {
          _locationDao = new LocationDao_Impl(this);
        }
        return _locationDao;
      }
    }
  }

  @Override
  public ClientDao clientDao() {
    if (_clientDao != null) {
      return _clientDao;
    } else {
      synchronized(this) {
        if(_clientDao == null) {
          _clientDao = new ClientDao_Impl(this);
        }
        return _clientDao;
      }
    }
  }

  @Override
  public MyAssignmentDao myAssignmentDao() {
    if (_myAssignmentDao != null) {
      return _myAssignmentDao;
    } else {
      synchronized(this) {
        if(_myAssignmentDao == null) {
          _myAssignmentDao = new MyAssignmentDao_Impl(this);
        }
        return _myAssignmentDao;
      }
    }
  }

  @Override
  public DepartmentChecklistDao departmentChecklistDao() {
    if (_departmentChecklistDao != null) {
      return _departmentChecklistDao;
    } else {
      synchronized(this) {
        if(_departmentChecklistDao == null) {
          _departmentChecklistDao = new DepartmentChecklistDao_Impl(this);
        }
        return _departmentChecklistDao;
      }
    }
  }

  @Override
  public CancelledCompletedDao cancelledCompletedDao() {
    if (_cancelledCompletedDao != null) {
      return _cancelledCompletedDao;
    } else {
      synchronized(this) {
        if(_cancelledCompletedDao == null) {
          _cancelledCompletedDao = new CancelledCompletedDao_Impl(this);
        }
        return _cancelledCompletedDao;
      }
    }
  }

  @Override
  public CheckListDetailDao checkListDetailDao() {
    if (_checkListDetailDao != null) {
      return _checkListDetailDao;
    } else {
      synchronized(this) {
        if(_checkListDetailDao == null) {
          _checkListDetailDao = new CheckListDetailDao_Impl(this);
        }
        return _checkListDetailDao;
      }
    }
  }

  @Override
  public UserSuggestionDao userSuggestionDao() {
    if (_userSuggestionDao != null) {
      return _userSuggestionDao;
    } else {
      synchronized(this) {
        if(_userSuggestionDao == null) {
          _userSuggestionDao = new UserSuggestionDao_Impl(this);
        }
        return _userSuggestionDao;
      }
    }
  }

  @Override
  public AllCaptureDataDao allCaptureDataDao() {
    if (_allCaptureDataDao != null) {
      return _allCaptureDataDao;
    } else {
      synchronized(this) {
        if(_allCaptureDataDao == null) {
          _allCaptureDataDao = new AllCaptureDataDao_Impl(this);
        }
        return _allCaptureDataDao;
      }
    }
  }

  @Override
  public GetSynchronizationDao getSynchronizationDao() {
    if (_getSynchronizationDao != null) {
      return _getSynchronizationDao;
    } else {
      synchronized(this) {
        if(_getSynchronizationDao == null) {
          _getSynchronizationDao = new GetSynchronizationDao_Impl(this);
        }
        return _getSynchronizationDao;
      }
    }
  }

  @Override
  public GetChecklistElementDao getChecklistElementDao() {
    if (_getChecklistElementDao != null) {
      return _getChecklistElementDao;
    } else {
      synchronized(this) {
        if(_getChecklistElementDao == null) {
          _getChecklistElementDao = new GetChecklistElementDao_Impl(this);
        }
        return _getChecklistElementDao;
      }
    }
  }

  @Override
  public NotesDao notesDao() {
    if (_notesDao != null) {
      return _notesDao;
    } else {
      synchronized(this) {
        if(_notesDao == null) {
          _notesDao = new NotesDao_Impl(this);
        }
        return _notesDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public ReportDao reportDao() {
    if (_reportDao != null) {
      return _reportDao;
    } else {
      synchronized(this) {
        if(_reportDao == null) {
          _reportDao = new ReportDao_Impl(this);
        }
        return _reportDao;
      }
    }
  }

  @Override
  public PostSynchronizationDao postSynchronizationDao() {
    if (_postSynchronizationDao != null) {
      return _postSynchronizationDao;
    } else {
      synchronized(this) {
        if(_postSynchronizationDao == null) {
          _postSynchronizationDao = new PostSynchronizationDao_Impl(this);
        }
        return _postSynchronizationDao;
      }
    }
  }

  @Override
  public QRStepAttributeExecutionDao qrStepAttributeExecutionDao() {
    if (_qRStepAttributeExecutionDao != null) {
      return _qRStepAttributeExecutionDao;
    } else {
      synchronized(this) {
        if(_qRStepAttributeExecutionDao == null) {
          _qRStepAttributeExecutionDao = new QRStepAttributeExecutionDao_Impl(this);
        }
        return _qRStepAttributeExecutionDao;
      }
    }
  }

  @Override
  public DashboardDao getDashboardDao() {
    if (_dashboardDao != null) {
      return _dashboardDao;
    } else {
      synchronized(this) {
        if(_dashboardDao == null) {
          _dashboardDao = new DashboardDao_Impl(this);
        }
        return _dashboardDao;
      }
    }
  }

  @Override
  public ChecklistExecutionDao checklistExtecutionDao() {
    if (_checklistExecutionDao != null) {
      return _checklistExecutionDao;
    } else {
      synchronized(this) {
        if(_checklistExecutionDao == null) {
          _checklistExecutionDao = new ChecklistExecutionDao_Impl(this);
        }
        return _checklistExecutionDao;
      }
    }
  }

  @Override
  public LogsDao getLogsDao() {
    if (_logsDao != null) {
      return _logsDao;
    } else {
      synchronized(this) {
        if(_logsDao == null) {
          _logsDao = new LogsDao_Impl(this);
        }
        return _logsDao;
      }
    }
  }

  @Override
  public ChecklistUndoDao checklistUndoDao() {
    if (_checklistUndoDao != null) {
      return _checklistUndoDao;
    } else {
      synchronized(this) {
        if(_checklistUndoDao == null) {
          _checklistUndoDao = new ChecklistUndoDao_Impl(this);
        }
        return _checklistUndoDao;
      }
    }
  }
}
