PRAGMA encoding = `UTF-8`; 
PRAGMA foreign_keys = false;

CREATE TABLE `client_settings` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL
);

CREATE TABLE `item_types` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `description` varchar(100)
  );

CREATE TABLE `checklist_statuses` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100),
  `is_default` integer(1) DEFAULT (0),
  `is_closed` integer(1) DEFAULT (0),
  `is_expired` integer NOT NULL DEFAULT (0),
  `edit_allowed` integer(1) DEFAULT (0),
  `sort_order` integer,
  `is_deleted` integer(1) DEFAULT (0),
  `modified` timestamp NOT NULL
);

CREATE TABLE `departments` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `name` varchar(100) NOT NULL,
  `short_name` varchar(100),
  `is_deleted` integer(1) DEFAULT (0),
  `modified` timestamp NOT NULL
);

CREATE TABLE `equipments` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40),
  `name` varchar(100) NOT NULL,
  `is_default` integer(1) DEFAULT (0),
  `is_deleted` integer(1) DEFAULT (0),
  `modified` timestamp NOT NULL
);

CREATE TABLE `groups` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `name` varchar(255) NOT NULL,
  `modified` timestamp NOT NULL
);

CREATE TABLE `hazards` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `label` varchar(100) NOT NULL,
  `icon` varchar(100),
  `modified` timestamp NOT NULL
);

CREATE TABLE `ppes` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `label` varchar(100) NOT NULL,
  `icon` varchar(100),
  `status` integer(1) DEFAULT (0),
  `modified` timestamp NOT NULL
);

CREATE TABLE `locations` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `name` varchar(255) NOT NULL,
  `timezone` varchar(255) NOT NULL,
  `last_sync_time` timestamp
);

CREATE TABLE `rooms` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40),
  `name` varchar(100) NOT NULL,
  `is_default` integer(1) DEFAULT (0),
  `is_deleted` integer(1) DEFAULT (0),
  `modified` timestamp NOT NULL
);

CREATE TABLE `custom_fields` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `model` varchar(255) NOT NULL,
  `step_attribute_count` integer NOT NULL DEFAULT (0),
  `name` varchar(255) NOT NULL,
  `type` varchar(40) NOT NULL,
  `is_default` integer NOT NULL DEFAULT (0),
  `allow_description` integer NOT NULL DEFAULT (0),
  `default_value` varchar(255),
  `possible_values` text,
  `display_as` varchar(255),
  `multiple` integer NOT NULL DEFAULT (0),
  `required` integer NOT NULL DEFAULT (1),
  `min_value` double precision,
  `max_value` double precision,
  `min_length` integer,
  `max_length` integer,
  `user_roles` varchar(255),
  `allow_gallery` integer,
  `allowed_media_types` varchar(255),
  `sort_order` integer NOT NULL DEFAULT (1),
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL
);

CREATE TABLE `users` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50),
  `group_id` integer NOT NULL,
  `full_name` varchar(100),
  `email` varchar(50),
  `business_name` varchar(100),
  `is_administrator` integer(1) NOT NULL DEFAULT (0),
  `is_deleted` integer(1) DEFAULT (0),
  `account_uuid` varchar(40) NOT NULL,
  `last_location_id` integer,
  `modified` timestamp NOT NULL,
  CONSTRAINT `users_groupId` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `users_lastLocationId` FOREIGN KEY (`last_location_id`) REFERENCES `locations` (`id`)
);

CREATE INDEX `users_userIsDeleted`
ON `users`(
  `is_deleted` ASC
);

CREATE TABLE `client_logos` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `user_id` integer NOT NULL,
  `name` varchar(255) NOT NULL,
  `file_md5_checksum` text NOT NULL,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `is_downloaded` INTEGER NOT NULL DEFAULT 0,
  CONSTRAINT `client_logos_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklist_types` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `type` varchar(100) NOT NULL,
  `description` varchar(100),
  `is_deleted` integer(1) DEFAULT(0),
  `modified` timestamp NOT NULL
);

CREATE TABLE `location_room_equipments` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `location_id` integer NOT NULL,
  `room_id` integer NOT NULL,
  `equipment_id` integer NOT NULL,
  `is_deleted` integer(1) DEFAULT(0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `location_room_equipments_equipment_id` FOREIGN KEY (`equipment_id`) REFERENCES `equipments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `location_room_equipments_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `location_room_equipments_room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `location_departments` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `location_id` integer NOT NULL,
  `department_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `location_departments_department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `location_departments_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `location_equipments` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `location_id` integer NOT NULL,
  `equipment_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `location_equipments_equipment_id` FOREIGN KEY (`equipment_id`) REFERENCES `equipments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `location_equipments_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `user_location_departments` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `user_id` integer NOT NULL,
  `location_id` integer NOT NULL,
  `department_id` integer,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  CONSTRAINT `user_location_departments_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_location_departments_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklists` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `checklist_type_id` integer NOT NULL,
  `department_id` integer NOT NULL,
  `parent_id` integer,
  `author_id` integer NOT NULL,
  `checklist_status_id` integer(1),
  `assigned_to_id` integer,
  `estimate_hours` integer,
  `is_approval_required` integer(1) NOT NULL DEFAULT(0),
  `is_template` integer(1),
  `is_sequential` integer(1) NOT NULL DEFAULT(0),
  `is_deleted` integer(1) NOT NULL DEFAULT(0),
  `due_at` timestamp,
  `modified` timestamp,
  CONSTRAINT `checklists_ibfk_2` FOREIGN KEY (`assigned_to_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklists_ibfk_1` FOREIGN KEY (`checklist_status_id`) REFERENCES `checklist_statuses` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklists_checklist_type_id` FOREIGN KEY (`checklist_type_id`) REFERENCES `checklist_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklists_user_id` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklist_logos` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `name` varchar(100) NOT NULL,
  `checklist_id` integer NOT NULL,
  `logo_type` integer NOT NULL DEFAULT (3),
  `file_md5_checksum` varchar(255) NOT NULL,
  `modified` timestamp NOT NULL,
  `is_downloaded` INTEGER NOT NULL DEFAULT 0,
  CONSTRAINT `checklist_logos_checklist_id` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklist_titles` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `checklist_id` integer NOT NULL,
  `title` varchar(255) NOT NULL,
  CONSTRAINT `checklist_titles_checklist_id` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklist_locations` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `checklist_id` integer NOT NULL,
  `location_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `checklist_locations_checklist_id` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklist_locations_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklist_ppes` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `ppe_id` integer NOT NULL,
  `checklist_id` integer NOT NULL,
  `step_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `checklist_ppes_checklist_id` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklist_ppes_ppe_id` FOREIGN KEY (`ppe_id`) REFERENCES `ppes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklist_room_equipments` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `checklist_location_id` integer,
  `location_room_equipment_id` integer,
  `room_id` integer NOT NULL,
  `equipment_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `checklist_room_equipments_checklist_location_id` FOREIGN KEY (`checklist_location_id`) REFERENCES `checklist_locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklist_room_equipments_equipment_id` FOREIGN KEY (`equipment_id`) REFERENCES `equipments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklist_room_equipments_location_room_equipment_id` FOREIGN KEY (`location_room_equipment_id`) REFERENCES `location_room_equipments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklist_room_equipments_room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklist_elements` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `item_type_id` integer NOT NULL,
  `item_id` integer NOT NULL,
  `item_uuid` varchar(40),
  `title` text,
  `description` text,
  `parent_id` integer,
  `sort_order` integer NOT NULL,
  `sequence_no` varchar(100) NOT NULL,
  `checklist_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `checklist_elements_checklist_id` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklist_elements_item_type_id` FOREIGN KEY (`item_type_id`) REFERENCES `item_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `checklist_elements_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `checklist_elements` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `step_attributes` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `step_id` integer NOT NULL,
  `custom_field_id` integer NOT NULL,
  `label` varchar(255) NOT NULL,
  `description` text,
  `sort_order` integer NOT NULL DEFAULT (1),
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `step_attributes_ibfk_1` FOREIGN KEY (`custom_field_id`) REFERENCES `custom_fields` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `ncw_hazards` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `item_id` integer NOT NULL,
  `item_type_id` integer NOT NULL,
  `hazard_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `ncw_hazards_hazard_id` FOREIGN KEY (`hazard_id`) REFERENCES `hazards` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `user_favorites` (
  `uuid` varchar(40) NOT NULL,
  `user_id` integer NOT NULL,
  `checklist_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `user_favorites_checklist_id` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_favorites_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `resource_links` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `item_type_id` integer NOT NULL,
  `item_id` integer NOT NULL,
  `link_title` text NOT NULL,
  `link` varchar(200) NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `resource_links_item_type_id` FOREIGN KEY (`item_type_id`) REFERENCES `item_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `resources` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` text NOT NULL,
  `file_md5_checksum` text NOT NULL,
  `is_resource` integer NOT NULL DEFAULT (0),
  `file_name` text NOT NULL,
  `display_file_name` varchar(255),
  `item_id` integer DEFAULT (0),
  `item_type_id` integer,
  `file_size` bigint NOT NULL DEFAULT (0),
  `content_type` varchar(50),
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  `is_downloaded` integer NOT NULL DEFAULT (0)
);

CREATE TABLE `assigned_checklists` (
  `uuid` varchar(40) NOT NULL,
  `checklist_id` integer NOT NULL,
  `department_id` integer NOT NULL,
  `location_id` integer NOT NULL,
  `checklist_status` integer NOT NULL DEFAULT (0),
  `assignee_type` integer NOT NULL DEFAULT (0),
  `user_id` integer NOT NULL,
  `assigned_at` timestamp,
  `started_by_user_id` integer,
  `started_at` timestamp,
  `due_date` timestamp,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_checklists_checklist_id` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_checklists_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_checklists_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_departments` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `department_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `assigned_departments_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_departments_department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_ncw` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `user_id` integer NOT NULL,
  `item_id` integer NOT NULL,
  `item_type_id` integer NOT NULL,
  `checklist_element_id` integer NOT NULL,
  `acknowledged` integer NOT NULL DEFAULT (0),
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_ncw_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_ncw_ibfk_1` FOREIGN KEY (`checklist_element_id`) REFERENCES `checklist_elements` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_ncw_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_checklist_pause_times` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `user_id` integer NOT NULL,
  `resumed_by_user_id` integer,
  `reason` varchar(255) NOT NULL,
  `is_paused` integer NOT NULL DEFAULT (0),
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_checklist_pause_times_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_checklist_pause_times_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_decisions` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `decision_id` integer NOT NULL,
  `checklist_element_id` integer NOT NULL,
  `user_id` integer NOT NULL,
  `status` integer NOT NULL DEFAULT (0),
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_decisions_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_decisions_ibfk_1` FOREIGN KEY (`checklist_element_id`) REFERENCES `checklist_elements` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_decisions_decision_id` FOREIGN KEY (`decision_id`) REFERENCES `decisions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_decisions_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_logos` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `checklist_logo_id` integer NOT NULL,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_logos_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_logos_checklist_logo_id` FOREIGN KEY (`checklist_logo_id`) REFERENCES `checklist_logos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_room_equipments` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `room_id` integer NOT NULL,
  `equipment_id` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_room_equipments_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_room_equipments_equipment_id` FOREIGN KEY (`equipment_id`) REFERENCES `equipments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_room_equipments_room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_step_attributes` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `item_uuid` varchar(40) NOT NULL,
  `step_id` integer NOT NULL,
  `step_attribute_id` integer NOT NULL,
  `checklist_element_id` integer NOT NULL,
  `user_id` integer NOT NULL,
  `value` varchar(255) NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_step_attributes_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_step_resources` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `checklist_element_id` integer NOT NULL,
  `item_type_id` integer NOT NULL DEFAULT (0),
  `item_id` integer NOT NULL DEFAULT (0),
  `display_file_name` varchar(100),
  `file_name` varchar(100),
  `content_type` varchar(50),
  `file_md5_checksum` text NOT NULL,
  `user_id` integer NOT NULL DEFAULT (0),
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `is_uploaded` INTEGER NOT NULL DEFAULT 0,
  `is_downloaded` INTEGER NOT NULL DEFAULT 0,
  `sync_status` integer NOT NULL DEFAULT (1),
  CONSTRAINT `assigned_step_resources_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_step_resources_ibfk_1` FOREIGN KEY (`checklist_element_id`) REFERENCES `checklist_elements` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_step_resources_item_type_id` FOREIGN KEY (`item_type_id`) REFERENCES `item_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_step_resources_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_steps` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `step_id` integer NOT NULL,
  `checklist_element_id` integer NOT NULL,
  `status` integer NOT NULL DEFAULT (0),
  `user_id` integer NOT NULL,
  `is_deleted` integer NOT NULL,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_steps_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_steps_ibfk_1` FOREIGN KEY (`checklist_element_id`) REFERENCES `checklist_elements` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_steps_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_users` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `user_id` integer NOT NULL,
  `assigned_by` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `assigned_users_assigned_by` FOREIGN KEY (`assigned_by`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_users_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_users_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `logs` (
  `uuid` varchar(40) NOT NULL,
  `item_uuid` varchar(40),
  `checklist_id` integer,
  `checklist_element_id` integer,
  `action` varchar(255) NOT NULL,
  `user_id` integer NOT NULL,
  `assigned_to` integer DEFAULT (0),
  `username` varchar(50) NOT NULL,
  `assigned_to_name` varchar(50),
  `assigned_checklist_uuid` varchar(40),
  `item_description` text NOT NULL,
  `step_action` text,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `placeholders` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `name` varchar(255) NOT NULL,
  `placeholder` varchar(255) NOT NULL
);

CREATE TABLE `item_placeholders` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `item_id` integer NOT NULL,
  `item_type_id` integer NOT NULL,
  `placeholder_id` integer NOT NULL,
  `sort_order` integer NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL,
  CONSTRAINT `item_placeholders_ibfk_1` FOREIGN KEY (`placeholder_id`) REFERENCES `placeholders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `assigned_item_placeholders` (
  `uuid` varchar(40) NOT NULL,
  `assigned_checklist_uuid` varchar(40) NOT NULL,
  `checklist_element_id` integer NOT NULL,
  `item_placeholder_id` integer NOT NULL,
  `user_id` integer NOT NULL,
  `value` varchar(255) NOT NULL,
  `is_deleted` integer NOT NULL,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  CONSTRAINT `assigned_item_placeholders_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_item_placeholders_ibfk_1` FOREIGN KEY (`checklist_element_id`) REFERENCES `checklist_elements` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `assigned_item_placeholders_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  CONSTRAINT `assigned_item_placeholders_item_placeholder_id` FOREIGN KEY (`item_placeholder_id`) REFERENCES `item_placeholders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `workorder_statuses` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `name` varchar(30) NOT NULL,
  `is_default` integer,
  `modified` timestamp NOT NULL
);

CREATE TABLE `workorder_billing_types` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `name` varchar(255) NOT NULL,
  `is_default` integer,
  `modified` timestamp NOT NULL
);

CREATE TABLE `workorders` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `due_date` timestamp,
  `workorder_status_id` integer NOT NULL DEFAULT (1),
  `assigned_to_id` integer NOT NULL DEFAULT (0),
  `assigned_to_type` integer NOT NULL DEFAULT (0),
  `workorder_priority_id` integer NOT NULL DEFAULT (2),
  `author_id` integer NOT NULL,
  `location_id` integer NOT NULL,
  `checklist_id` integer,
  `workorder_billing_type_id` integer,
  `location_room_id` integer,
  `location_equipment_id` integer,
  `start_date` timestamp,
  `closed_date` timestamp,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0)
);

CREATE TABLE `workorder_notes` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `workorder_id` integer NOT NULL,
  `user_id` integer NOT NULL,
  `workorder_notes` text,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `workorder_notes_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `workorder_notes_workorder_id` FOREIGN KEY (`workorder_id`) REFERENCES `workorders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `workorder_note_details` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `workorder_note_id` integer NOT NULL,
  `property` varchar(255) NOT NULL,
  `property_key` varchar(255) NOT NULL,
  `old_value` varchar(255),
  `value` varchar(255),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `workorder_note_details_workorder_note_id` FOREIGN KEY (`workorder_note_id`) REFERENCES `workorder_notes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `workorder_attachments` (
  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  `uuid` varchar(40) NOT NULL,
  `workorder_id` integer,
  `display_filename` varchar(255) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `filesize` integer NOT NULL DEFAULT (0),
  `content_type` varchar (11),
  `author_id` integer NOT NULL,
  `file_md5_checksum` varchar(40) NOT NULL,
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `is_uploaded` INTEGER NOT NULL DEFAULT (0),
  `is_downloaded` INTEGER NOT NULL DEFAULT (0),
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `workorder_attachments_author_id` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `workorder_attachments_workorder_id` FOREIGN KEY (`workorder_id`) REFERENCES `workorders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `user_suggestions` (
  `uuid` varchar(40) NOT NULL,
  `user_id` integer NOT NULL,
  `assigned_checklist_uuid` varchar(40),
  `checklist_id` integer DEFAULT (0),
  `description` text NOT NULL,
  `is_deleted` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `user_suggestions_assigned_checklist_uuid` FOREIGN KEY (`assigned_checklist_uuid`) REFERENCES `assigned_checklists` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_suggestions_checklist_id` FOREIGN KEY (`checklist_id`) REFERENCES `checklists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_suggestions_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `user_suggestion_attachments` (
  `uuid` varchar(40) NOT NULL,
  `user_suggestion_uuid` varchar(40) NOT NULL,
  `display_filename` varchar(255) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `filesize` integer NOT NULL DEFAULT (0),
  `content_type` varchar(11),
  `user_id` integer NOT NULL,
  `file_md5_checksum` varchar(40) NOT NULL,
  `is_uploaded` integer NOT NULL DEFAULT (0),
  `created` timestamp NOT NULL,
  `modified` timestamp NOT NULL,
  `sync_status` integer NOT NULL DEFAULT (0),
  CONSTRAINT `user_suggestion_attachments_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_suggestion_attachments_user_suggestion_uuid` FOREIGN KEY (`user_suggestion_uuid`) REFERENCES `user_suggestions` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `checklist_execution_permissions` (
  `id` integer NOT NULL,
  `group_id` integer NOT NULL,
  `checklist_type_id` integer NOT NULL,
  `checklist_status_id` integer NOT NULL,
  `is_assignable` integer NOT NULL DEFAULT (0),
  `is_executable` integer NOT NULL DEFAULT (0),
  `modified` timestamp NOT NULL
);


PRAGMA foreign_keys = true;