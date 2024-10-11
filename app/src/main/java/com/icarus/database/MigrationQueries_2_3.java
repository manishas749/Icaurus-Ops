package com.icarus.database;

public class MigrationQueries_2_3 {
    static final String PARGMA_OFF_FOREIGN_KEY = "PRAGMA foreign_keys = OFF;";

    static final String CREATE_TABLE_ASSIGNED_COMMENTS = "CREATE TABLE `assigned_checklist_comments` (\n" +
            " `uuid` TEXT NOT NULL  PRIMARY KEY,\n" +
            " `assigned_checklist_uuid` TEXT NOT NULL,\n" +
            " `user_id` INTEGER NOT NULL,\n" +
            " `comment` TEXT,\n" +
            " `is_deleted` INTEGER NOT NULL,\n" +
            " `created` TEXT NOT NULL,\n" +
            " `modified` TEXT NOT NULL,\n" +
            " `sync_status` INTEGER NOT NULL DEFAULT (0),\n" +
            " CONSTRAINT `assigned_checklist_comments_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            " CONSTRAINT `assigned_checklist_comments_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";

    static final String DROP_ASSIGNED_COMMENTS = "DROP TABLE IF EXISTS `assigned_checklist_comments`;";

    static final String DROP_CHECKLIST_NEW = "DROP TABLE IF EXISTS `checklists_new`;";
    static final String CREATE_TABLE_CHECKLIST_NEW = "CREATE TABLE `checklists_new` (\n" +
            "  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  `uuid` TEXT NOT NULL,\n" +
            "  `checklist_type_id` INTEGER NOT NULL,\n" +
            "  `department_id` INTEGER NOT NULL,\n" +
            "  `parent_id` INTEGER,\n" +
            "  `author_id` INTEGER NOT NULL,\n" +
            "  `checklist_status_id` INTEGER,\n" +
            "  `assigned_to_id` INTEGER,\n" +
            "  `estimate_hours` TEXT,\n" +
            "  `checklist_placeholder_count` INTEGER NOT NULL DEFAULT(0),\n" +
            "  `is_approval_required` INTEGER NOT NULL DEFAULT(0),\n" +
            "  `is_template` INTEGER,\n" +
            "  `is_sequential` INTEGER NOT NULL DEFAULT(0),\n" +
            "  `is_deleted` INTEGER NOT NULL DEFAULT(0),\n" +
            "  `due_at` TEXT,\n" +
            "  `modified` TEXT,\n" +
            "  `sync_status` INTEGER DEFAULT(0),\n" +
            "  `pending_resources_count` INTEGER DEFAULT(0),\n" +
            "  `pending_references_count` INTEGER DEFAULT(0),\n" +
            "  CONSTRAINT `checklists_assigned_to_id` FOREIGN KEY (`assigned_to_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `checklists_checklist_status_id` FOREIGN KEY (`checklist_status_id`) REFERENCES `checklist_statuses` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `checklists_checklist_type_id` FOREIGN KEY (`checklist_type_id`) REFERENCES `checklist_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `checklists_user_id` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";
    static final String INSERT_INTO_CHECKLIST_NEW = "INSERT OR REPLACE INTO `checklists_new` (id, uuid, checklist_type_id, department_id, parent_id, author_id, checklist_status_id, assigned_to_id, estimate_hours, checklist_placeholder_count, is_approval_required, is_template, is_sequential, is_deleted, due_at, modified, sync_status, pending_resources_count, pending_references_count)\n" +
            "SELECT id, uuid, checklist_type_id, department_id, parent_id, author_id, checklist_status_id, assigned_to_id, estimate_hours, checklist_placeholder_count, is_approval_required, is_template, is_sequential, is_deleted, due_at, modified, sync_status, pending_resources_count, pending_references_count FROM checklists";
    static final String DROP_CHECKLISTS = "DROP TABLE IF EXISTS `checklists`;";
    static final String ALTER_CHECKLISTS = "ALTER TABLE `checklists_new` RENAME TO `checklists`;";

    static final String DROP_CHECKLIST_EXECUTION_PERMISSION_NEW = "DROP TABLE IF EXISTS `checklist_execution_permissions_new`;";
    static final String CREATE_TABLE_CHECKLIST_EXECUTION_PERMISSION_NEW = "CREATE TABLE `checklist_execution_permissions_new` (\n" +
            "  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  `group_id` INTEGER NOT NULL,\n" +
            "  `checklist_type_id` INTEGER NOT NULL,\n" +
            "  `checklist_status_id` INTEGER NOT NULL,\n" +
            "  `is_assignable` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `is_executable` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `modified` TEXT NOT NULL,\n" +
            "  CONSTRAINT `checklist_execution_permissions_checklist_type_id` FOREIGN KEY (`checklist_type_id`) REFERENCES `checklist_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `checklist_execution_permissions_groups` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";
    static final String INSERT_INTO_CHECKLIST_EXECUTION_PERMISSION_NEW = "INSERT OR REPLACE INTO checklist_execution_permissions_new (id, group_id, checklist_type_id, checklist_status_id, is_assignable, is_executable, modified) " +
            "Select id, group_id, checklist_type_id, checklist_status_id, is_assignable, is_executable, modified from checklist_execution_permissions\n";
    static final String DROP_CHECKLIST_EXECUTION_PERMISSION = "DROP TABLE IF EXISTS `checklist_execution_permissions`;";
    static final String ALTER_CHECKLIST_EXECUTION_PERMISSION = "ALTER TABLE `checklist_execution_permissions_new` RENAME TO `checklist_execution_permissions`;";

    static final String DROP_USER_NEW = "DROP TABLE IF EXISTS `users_new`;";
    static final String CREATE_TABLE_USER_NEW = "CREATE TABLE `users_new` (\n" +
            "  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  `uuid` TEXT NOT NULL,\n" +
            "  `username` TEXT NOT NULL,\n" +
            "  `password` TEXT,\n" +
            "  `group_id` INTEGER NOT NULL,\n" +
            "  `full_name` TEXT,\n" +
            "  `email` TEXT,\n" +
            "  `business_name` TEXT,\n" +
            "  `is_administrator` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `is_deleted` INTEGER DEFAULT (0),\n" +
            "  `account_uuid` TEXT NOT NULL,\n" +
            "  `last_location_id` INTEGER,\n" +
            "  `modified` TEXT NOT NULL,\n" +
            "  CONSTRAINT `users_groupId` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),\n" +
            "  CONSTRAINT `users_lastLocationId` FOREIGN KEY (`last_location_id`) REFERENCES `locations` (`id`)\n" +
            ");";
    static final String INSERT_INTO_USER_NEW = "INSERT OR REPLACE INTO users_new(id,uuid,username,password,group_id,full_name,email,business_name,is_administrator,is_deleted,account_uuid,last_location_id,modified)\n" +
            "SELECT id,uuid,username,password,group_id,full_name,email,business_name,is_administrator,is_deleted,account_uuid,last_location_id,modified\n" +
            "FROM users;";
    static final String DROP_USERS = "DROP TABLE IF EXISTS `users`;";
    static final String ALTER_USERS = "ALTER TABLE `users_new` RENAME TO `users`;";

    static final String DROP_ASSIGNED_NCW_NEW = "DROP TABLE IF EXISTS assigned_ncw_new;";
    static final String CREATE_TABLE_ASSIGNED_NCW_NEW = "CREATE TABLE `assigned_ncw_new` (\n" +
            "  `uuid` TEXT NOT NULL PRIMARY KEY,\n" +
            "  `assigned_checklist_uuid` TEXT NOT NULL,\n" +
            "  `user_id` INTEGER NOT NULL,\n" +
            "  `item_id` INTEGER NOT NULL,\n" +
            "  `item_type_id` INTEGER NOT NULL,\n" +
            "  `checklist_element_id` INTEGER,\n" +
            "  `acknowledged` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `is_deleted` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `created` TEXT NOT NULL,\n" +
            "  `modified` TEXT NOT NULL,\n" +
            "  `sync_status` INTEGER NOT NULL DEFAULT (0),\n" +
            "  CONSTRAINT `assigned_ncw_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `assigned_ncw_checklist_element_id` FOREIGN KEY (`checklist_element_id`) REFERENCES `checklist_elements` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `assigned_ncw_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";
    static final String INSERT_INTO_ASSIGNED_NCW_NEW = "INSERT INTO assigned_ncw_new(uuid,assigned_checklist_uuid,user_id,item_id,item_type_id,checklist_element_id,acknowledged,is_deleted,created,modified,sync_status)\n" +
            "SELECT uuid,assigned_checklist_uuid,user_id,item_id,item_type_id,checklist_element_id,acknowledged,is_deleted,created,modified,sync_status\n"+
            " From assigned_ncw;";
    static final String DROP_ASSIGNED_NCW = "DROP TABLE IF EXISTS assigned_ncw;";
    static final String ALTER_ASSIGNED_NCW = "ALTER TABLE `assigned_ncw_new` RENAME TO `assigned_ncw`;";

    static final String DROP_WORKORDER_NEW = "DROP TABLE IF EXISTS `workorders_new`;";
    static final String CREATE_TABLE_WORKORDER_NEW = "CREATE TABLE `workorders_new` (\n" +
            "  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  `uuid` TEXT NOT NULL,\n" +
            "  `title` TEXT NOT NULL,\n" +
            "  `description` TEXT NOT NULL,\n" +
            "  `due_date` TEXT,\n" +
            "  `workorder_status_id` INTEGER NOT NULL DEFAULT (1),\n" +
            "  `assigned_to_id` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `assigned_to_type` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `workorder_priority_id` INTEGER NOT NULL DEFAULT (2),\n" +
            "  `author_id` INTEGER NOT NULL,\n" +
            "  `location_id` INTEGER NOT NULL,\n" +
            "  `checklist_id` INTEGER,\n" +
            "  `workorder_billing_type_id` INTEGER,\n" +
            "  `location_room_id` INTEGER,\n" +
            "  `location_equipment_id` INTEGER,\n" +
            "  `start_date` TEXT,\n" +
            "  `closed_date` TEXT,\n" +
            "  `created` TEXT NOT NULL,\n" +
            "  `modified` TEXT NOT NULL,\n" +
            "  `sync_status` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `execution_status` INTEGER NOT NULL DEFAULT (0)\n" +
            ");";
    static final String INSERT_INTO_WORKORDER_NEW = "INSERT OR REPLACE INTO workorders_new(id,uuid,title,description,due_date,workorder_status_id,assigned_to_id,assigned_to_type,workorder_priority_id,author_id,location_id,checklist_id,workorder_billing_type_id,location_room_id,location_equipment_id,start_date,closed_date,created,modified,sync_status,execution_status)\n" +
            "SELECT id,uuid,title,description,due_date,workorder_status_id,assigned_to_id,assigned_to_type,workorder_priority_id,author_id,location_id,checklist_id,workorder_billing_type_id,location_room_id,location_equipment_id,start_date,closed_date,created,modified,sync_status,execution_status\n" +
            "FROM workorders;";
    static final String DROP_WORKORDERS = "DROP TABLE IF EXISTS `workorders`;";
    static final String ALTER_WORKORDERS = "ALTER TABLE `workorders_new` RENAME TO `workorders`;";

    static final String DROP_LOCATION_ROOM_EQUIPMENT_NEW = "DROP TABLE IF EXISTS `location_room_equipments_new`;";
    static final String CREATE_TABLE_LOCATION_ROOM_EQUIPMENT_NEW = "CREATE TABLE `location_room_equipments_new` (\n" +
            "  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  `location_id` INTEGER NOT NULL,\n" +
            "  `room_id` INTEGER NOT NULL,\n" +
            "  `equipment_id` INTEGER NOT NULL,\n" +
            "  `is_deleted` INTEGER NOT NULL DEFAULT(0),\n" +
            "  `modified` TEXT NOT NULL,\n" +
            "  CONSTRAINT `location_room_equipments_equipment_id` FOREIGN KEY (`equipment_id`) REFERENCES `equipments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `location_room_equipments_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `location_room_equipments_room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";
    static final String INSERT_INTO_LOCATION_ROOM_EQUIPMENT_NEW = "INSERT OR REPLACE INTO location_room_equipments_new(id,location_id,room_id,equipment_id,is_deleted,modified)\n" +
            "SELECT id,location_id,room_id,equipment_id,is_deleted,modified\n" +
            "FROM location_room_equipments;";
    static final String DROP_LOCATION_ROOM_EQUIPMENTS = "DROP TABLE IF EXISTS `location_room_equipments`;";
    static final String ALTER_LOCATION_ROOM_EQUIPMENTS = "ALTER TABLE `location_room_equipments_new` RENAME TO `location_room_equipments`;";

    static final String DROP_PPE_NEW = "DROP TABLE IF EXISTS `ppes_new`;";
    static final String CREATE_TABLE_PPE_NEW = "CREATE TABLE `ppes_new` (\n" +
            "  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  `uuid` TEXT NOT NULL,\n" +
            "  `label` TEXT NOT NULL,\n" +
            "  `icon` TEXT,\n" +
            "  `file_md5_checksum` TEXT NOT NULL,\n" +
            "  `status` INTEGER DEFAULT (0),\n" +
            "  `modified` TEXT NOT NULL\n" +
            ");";
    static final String INSERT_INTO_PPE_NEW = "INSERT OR REPLACE INTO ppes_new(id,uuid,label,icon,file_md5_checksum,status,modified)\n" +
            "SELECT id,uuid,label,icon,file_md5_checksum,status,modified\n" +
            "FROM ppes;";
    static final String DROP_PPES = "DROP TABLE IF EXISTS `ppes`;";
    static final String ALTER_PPES = "ALTER TABLE `ppes_new` RENAME TO `ppes`;";

    static final String DROP_ASSIGNED_STEP_RESOURCE_NEW = "DROP TABLE IF EXISTS `assigned_step_resources_new`;";
    static final String CREATE_TABLE_ASSIGNED_STEP_RESOURCE_NEW = "CREATE TABLE `assigned_step_resources_new` (\n" +
            "  `uuid` TEXT NOT NULL PRIMARY KEY,\n" +
            "  `assigned_checklist_uuid` TEXT NOT NULL,\n" +
            "  `checklist_element_id` INTEGER NOT NULL,\n" +
            "  `item_type_id` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `item_id` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `display_file_name` TEXT,\n" +
            "  `file_name` TEXT,\n" +
            "  `content_type` TEXT,\n" +
            "  `file_md5_checksum` TEXT NOT NULL,\n" +
            "  `user_id` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `is_deleted` INTEGER NOT NULL DEFAULT (0),\n" +
            "  `created` TEXT NOT NULL,\n" +
            "  `modified` TEXT NOT NULL,\n" +
            "  `is_uploaded` INTEGER NOT NULL DEFAULT 0,\n" +
            "  `is_downloaded` INTEGER NOT NULL DEFAULT 0,\n" +
            "  `sync_status` INTEGER NOT NULL DEFAULT (1),\n" +
            "  CONSTRAINT `assigned_step_resources_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `assigned_step_resources_checklist_element_id` FOREIGN KEY (`checklist_element_id`) REFERENCES `checklist_elements` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `assigned_step_resources_item_type_id` FOREIGN KEY (`item_type_id`) REFERENCES `item_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `assigned_step_resources_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";
    static final String INSERT_INTO_ASSIGNED_STEP_RESOURCE_NEW = "INSERT INTO assigned_step_resources_new(uuid, assigned_checklist_uuid, checklist_element_id, item_type_id, item_id, display_file_name, file_name, content_type, file_md5_checksum, user_id, is_deleted, created, modified, is_uploaded, is_downloaded, sync_status) \n" +
            "SELECT uuid, assigned_checklist_uuid, checklist_element_id, item_type_id, item_id, display_file_name, file_name, content_type, file_md5_checksum, user_id, is_deleted, created, modified, is_uploaded, is_downloaded, sync_status" +
            " FROM assigned_step_resources;";

    static final String DROP_ASSIGNED_STEP_RESOURCES = "DROP TABLE IF EXISTS `assigned_step_resources`;";
    static final String ALTER_ASSIGNED_STEP_RESOURCES = "ALTER TABLE `assigned_step_resources_new` RENAME TO `assigned_step_resources`;";



    static final String PARGMA_ON_FOREIGN_KEY = "PRAGMA foreign_keys = ON;";
}
