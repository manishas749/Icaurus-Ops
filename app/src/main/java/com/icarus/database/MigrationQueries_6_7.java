package com.icarus.database;

import com.icarus.util.AppUtility;

public class MigrationQueries_6_7 {
    static final String PRAGMA_OFF_FOREIGN_KEY = "PRAGMA foreign_keys = OFF;";

    //Migration for location equipment table as we are adding new field upc_number and dropping foreign keys, changing nullable
    static String oldLocationEquipmentsTableName = "_location_equipments_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_LOCATION_EQUIPMENTS = "ALTER TABLE " +
            "\"location_equipments\" RENAME TO \" " + oldLocationEquipmentsTableName + "\";";

    static final String CREATE_TABLE_LOCATION_EQUIPMENTS = "CREATE TABLE \"location_equipments\" (\n" +
            "\"id\" INTEGER NOT NULL,\n" +
            "\"location_id\" INTEGER DEFAULT NULL,\n" +
            "\"equipment_id\" INTEGER DEFAULT NULL,\n" +
            "\"serial_number\" TEXT DEFAULT NULL,\n" +
            "\"upc_number\" TEXT DEFAULT NULL,\n" +
            "\"is_deleted\" INTEGER NOT NULL DEFAULT 0,\n" +
            "\"modified\" TEXT NOT NULL,\n" +
            "PRIMARY KEY(\"id\")\n" +
            ");";

    static final String INSERT_INTO_LOCATION_EQUIPMENTS_NEW = "INSERT INTO location_equipments \n" +
            "(\"id\", \"location_id\", \"equipment_id\", \"serial_number\", \"is_deleted\", \"modified\") \n" +
            "SELECT \"id\", \"location_id\", \"equipment_id\", \"serial_number\", \"is_deleted\", \"modified\" " +
            "FROM \" " + oldLocationEquipmentsTableName + "\";";

    //Alter table location_rooms, drop foreign keys and changing nullable
    static final String oldLocationRoomsTableName = "_location_rooms_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_LOCATION_ROOMS = "ALTER TABLE " +
            "\"location_rooms\" RENAME TO \" " + oldLocationRoomsTableName + "\";";

    static final String CREATE_TABLE_LOCATION_ROOMS = "CREATE TABLE \"location_rooms\" (\n" +
            "\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\"location_id\" INTEGER DEFAULT NULL,\n" +
            "\"room_id\" INTEGER DEFAULT NULL,\n" +
            "\"is_deleted\" INTEGER NOT NULL DEFAULT (0),\n" +
            "\"modified\" TEXT NOT NULL\n" +
            ");";

    static final String INSERT_INTO_LOCATION_ROOMS_NEW = "INSERT INTO location_rooms  \n" +
            "(\"id\", \"location_id\", \"room_id\", \"is_deleted\", \"modified\")" +
            "SELECT \"id\", \"location_id\", \"room_id\", \"is_deleted\", \"modified\" " +
            "FROM \" " + oldLocationRoomsTableName + "\";";

    //Alter table location_room_equipments, drop foreign keys and changing nullable
    static final String oldLocationRoomEquipmentsTableName = "_location_room_equipments_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_LOCATION_ROOM_EQUIPMENTS = "ALTER TABLE " +
            "\"location_room_equipments\" RENAME TO \" " + oldLocationRoomEquipmentsTableName + "\";";

    static final String CREATE_TABLE_LOCATION_ROOM_EQUIPMENTS = "CREATE TABLE \"location_room_equipments\" (\n" +
            "\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\"location_id\" INTEGER DEFAULT NULL,\n" +
            "\"room_id\" INTEGER DEFAULT NULL,\n" +
            "\"equipment_id\" INTEGER DEFAULT NULL,\n" +
            "\"is_deleted\" INTEGER NOT NULL DEFAULT (0),\n" +
            "\"modified\" TEXT NOT NULL\n" +
            ");";

    static final String INSERT_INTO_LOCATION_ROOM_EQUIPMENTS_NEW = "INSERT INTO location_room_equipments" +
            "(\"id\", \"location_id\", \"room_id\", \"equipment_id\", \"is_deleted\", \"modified\")" +
            "SELECT \"id\", \"location_id\", \"room_id\", \"equipment_id\", \"is_deleted\", \"modified\" " +
            "FROM \" " + oldLocationRoomEquipmentsTableName + "\";";

    //Alter table checklist_room_equipments drop foreign keys("location_room_equipment_id", "room_id" and "equipment_id") and changing nullable
    static final String oldChecklistRoomEquipmentsTableName = "_checklist_room_equipments_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_CHECKLIST_ROOM_EQUIPMENTS = "ALTER TABLE " +
            "\"checklist_room_equipments\" RENAME TO \" " + oldChecklistRoomEquipmentsTableName + "\";";

    static final String CREATE_TABLE_CHECKLIST_ROOM_EQUIPMENTS = "CREATE TABLE \"checklist_room_equipments\" (\n" +
            "\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\"checklist_location_id\" INTEGER DEFAULT NULL,\n" +
            "\"location_room_equipment_id\" INTEGER DEFAULT NULL,\n" +
            "\"room_id\" INTEGER DEFAULT NULL,\n" +
            "\"equipment_id\" INTEGER DEFAULT NULL,\n" +
            "\"is_deleted\" INTEGER NOT NULL DEFAULT (0),\n" +
            "\"modified\" TEXT NOT NULL,\n" +
            "CONSTRAINT checklist_room_equipments_checklist_location_id FOREIGN KEY (checklist_location_id) REFERENCES checklist_locations (id) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";

    static final String INSERT_INTO_CHECKLIST_ROOM_EQUIPMENTS_NEW = "INSERT INTO checklist_room_equipments" +
            "(\"id\", \"checklist_location_id\", \"location_room_equipment_id\", \"room_id\", \"equipment_id\", \"is_deleted\", \"modified\")" +
            "SELECT \"id\", \"checklist_location_id\", \"location_room_equipment_id\", \"room_id\", \"equipment_id\", \"is_deleted\", \"modified\" " +
            "FROM \" " + oldChecklistRoomEquipmentsTableName + "\";";

    //Alter table assigned_room_equipments drop foreign keys(""room_id" and "equipment_id" ) and changing nullable
    static final String oldAssignedRoomEquipmentsTableName = "_assigned_room_equipments_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_ASSIGNED_ROOM_EQUIPMENTS = "ALTER TABLE " +
            "\"assigned_room_equipments\" RENAME TO \" " + oldAssignedRoomEquipmentsTableName + "\";";

    static final String CREATE_TABLE_ASSIGNED_ROOM_EQUIPMENTS = "CREATE TABLE \"assigned_room_equipments\" (\n" +
            "\"uuid\" TEXT NOT NULL PRIMARY KEY,\n" +
            "\"assigned_checklist_uuid\" TEXT NOT NULL,\n" +
            "\"created\" TEXT NOT NULL,\n" +
            "\"equipment_id\" INTEGER DEFAULT NULL,\n" +
            "\"is_deleted\" INTEGER NOT NULL DEFAULT (0),\n" +
            "\"modified\" TEXT NOT NULL,\n" +
            "\"room_id\" INTEGER DEFAULT NULL,\n" +
            "\"sync_status\" INTEGER NOT NULL DEFAULT (0),\n" +
            "CONSTRAINT assigned_room_equipments_assigned_checklist_uuid FOREIGN KEY (assigned_checklist_uuid) REFERENCES assigned_checklists (uuid) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";

    static final String INSERT_INTO_ASSIGNED_ROOM_EQUIPMENTS_NEW = "INSERT INTO assigned_room_equipments" +
            "(\"uuid\", \"assigned_checklist_uuid\", \"created\", \"equipment_id\", \"is_deleted\", \"modified\", \"room_id\", \"sync_status\")" +
            "SELECT \"uuid\", \"assigned_checklist_uuid\", \"created\", \"equipment_id\", \"is_deleted\", \"modified\", \"room_id\", \"sync_status\" " +
            "FROM \" " + oldAssignedRoomEquipmentsTableName + "\";";

    //Alter table checklists drop foreign keys(author_id and assigned_to_id) and changing nullable
    static final String oldChecklistsTableName = "_checklists_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_CHECKLISTS = "ALTER TABLE " +
            "\"checklists\" RENAME TO \" " + oldChecklistsTableName + "\";";

    static final String CREATE_TABLE_CHECKLISTS = "CREATE TABLE \"checklists\" (\n" +
            "\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\"uuid\" TEXT NOT NULL,\n" +
            "\"parent_id\" INTEGER,\n" +
            "\"checklist_type_id\" INTEGER NOT NULL,\n" +
            "\"checklist_status_id\" INTEGER,\n" +
            "\"department_id\" INTEGER NOT NULL,\n" +
            "\"author_id\" INTEGER NOT NULL,\n" +
            "\"assigned_to_id\" INTEGER,\n" +
            "\"is_template\" INTEGER,\n" +
            "\"is_approval_required\" INTEGER NOT NULL,\n" +
            "\"is_sequential\" INTEGER NOT NULL,\n" +
            "\"is_deleted\" INTEGER NOT NULL,\n" +
            "\"due_at\" TEXT,\n" +
            "\"estimate_hours\" TEXT,\n" +
            "\"checklist_placeholder_count\" INTEGER NOT NULL,\n" +
            "\"modified\" TEXT,\n" +
            "\"pending_resources_count\" INTEGER,\n" +
            "\"pending_references_count\" INTEGER,\n" +
            "\"sync_status\" INTEGER,\n" +
            "FOREIGN KEY(checklist_status_id) REFERENCES checklist_statuses (id) ON UPDATE NO ACTION ON DELETE NO ACTION,\n" +
            "FOREIGN KEY(checklist_type_id) REFERENCES checklist_types (id) ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
            ");";

    static final String INSERT_INTO_CHECKLISTS_NEW = "INSERT INTO checklists" +
            "(\"id\",\"uuid\",\"parent_id\",\"checklist_type_id\",\"checklist_status_id\"," +
            "\"department_id\",\"author_id\",\"assigned_to_id\",\"is_template\"," +
            "\"is_approval_required\",\"is_sequential\",\"is_deleted\",\"due_at\"," +
            "\"estimate_hours\",\"checklist_placeholder_count\",\"modified\"," +
            "\"pending_resources_count\",\"pending_references_count\",\"sync_status\")\n" +
            "SELECT \"id\",\"uuid\",\"parent_id\",\"checklist_type_id\",\"checklist_status_id\"," +
            "\"department_id\",\"author_id\",\"assigned_to_id\",\"is_template\",\"is_approval_required\"," +
            "\"is_sequential\",\"is_deleted\",\"due_at\",\"estimate_hours\",\"checklist_placeholder_count\"," +
            "\"modified\",\"pending_resources_count\",\"pending_references_count\",\"sync_status\" " +
            "FROM \" " + oldChecklistsTableName + "\";";

    //Alter table work_orders change primary key to UUID and make id unique = true
    static final String oldWorkOrderTableName = "_workorders_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_WORK_ORDER = "ALTER TABLE " +
            "\"workorders\" RENAME TO \" " + oldWorkOrderTableName + "\";";

    static final String CREATE_TABLE_WORK_ORDERS = "CREATE TABLE \"workorders\" (\n" +
            "\"id\" INTEGER NOT NULL,\n" +
            "\"uuid\" TEXT NOT NULL PRIMARY KEY,\n" +
            "\"title\" TEXT NOT NULL,\n" +
            "\"description\" TEXT NOT NULL,\n" +
            "\"due_date\" TEXT,\n" +
            "\"workorder_status_id\" INTEGER NOT NULL,\n" +
            "\"assigned_to_id\" INTEGER NOT NULL,\n" +
            "\"assigned_to_type\" INTEGER NOT NULL,\n" +
            "\"workorder_priority_id\" INTEGER NOT NULL,\n" +
            "\"author_id\" INTEGER NOT NULL,\n" +
            "\"location_id\" INTEGER NOT NULL,\n" +
            "\"checklist_id\" INTEGER,\n" +
            "\"workorder_billing_type_id\" INTEGER,\n" +
            "\"location_equipment_id\" INTEGER,\n" +
            "\"location_room_id\" INTEGER,\n" +
            "\"start_date\" TEXT,\n" +
            "\"closed_date\" TEXT,\n" +
            "\"modified\" TEXT NOT NULL,\n" +
            "\"sync_status\" INTEGER NOT NULL,\n" +
            "\"created\" TEXT NOT NULL,\n" +
            "\"execution_status\" INTEGER NOT NULL\n" +
            ");";

    static final String CREATE_WORK_ORDER_UNIQUE_INDEX = "CREATE UNIQUE INDEX IF NOT EXISTS index_workorders_id ON workorders (id)";

    static final String INSERT_INTO_WORK_ORDERS_NEW = "INSERT INTO workorders" +
            "(\"id\",\"uuid\",\"title\",\"description\",\"due_date\"," +
            "\"workorder_status_id\",\"assigned_to_id\",\"assigned_to_type\",\"workorder_priority_id\"," +
            "\"author_id\",\"location_id\",\"checklist_id\",\"workorder_billing_type_id\"," +
            "\"location_equipment_id\",\"location_room_id\",\"start_date\"," +
            "\"closed_date\",\"modified\",\"sync_status\",\"created\",\"execution_status\")\n" +
            "SELECT \"id\",\"uuid\",\"title\",\"description\",\"due_date\"," +
            "\"workorder_status_id\",\"assigned_to_id\",\"assigned_to_type\",\"workorder_priority_id\",\"author_id\"," +
            "\"location_id\",\"checklist_id\",\"workorder_billing_type_id\",\"location_equipment_id\",\"location_room_id\"," +
            "\"start_date\",\"closed_date\",\"modified\",\"sync_status\",\"created\",\"execution_status\" " +
            "FROM \" " + oldWorkOrderTableName + "\";";

    static final String DROP_WORK_ORDERS = "DROP TABLE IF EXISTS \" " + oldWorkOrderTableName + "\";";

    //Alter table workorder_notes change primary key to UUID and add CASCADE on update to foreign key
    static final String oldWorkOrderNotesTableName = "workorder_notes_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_WORK_ORDER_NOTES = "ALTER TABLE " +
            "\"workorder_notes\" RENAME TO \" " + oldWorkOrderNotesTableName + "\";";

    static final String CREATE_TABLE_WORK_ORDER_NOTES = "CREATE TABLE \"workorder_notes\" (\n" +
            "\"id\" INTEGER NOT NULL,\n" +
            "\"uuid\" TEXT NOT NULL PRIMARY KEY,\n" +
            "\"workorder_id\" INTEGER NOT NULL,\n" +
            "\"user_id\" INTEGER NOT NULL,\n" +
            "\"workorder_notes\" TEXT,\n" +
            "\"modified\" TEXT NOT NULL,\n" +
            "\"sync_status\" INTEGER NOT NULL DEFAULT (0),\n" +
            "\"created\" TEXT NOT NULL,\n" +
            "CONSTRAINT workorder_notes_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION," +
            "CONSTRAINT workorder_notes_workorder_id FOREIGN KEY (workorder_id) REFERENCES workorders (id) ON DELETE NO ACTION ON UPDATE CASCADE" +
            ");";

    static final String CREATE_WORK_ORDER_NOTES_UNIQUE_INDEX = "CREATE UNIQUE INDEX IF NOT EXISTS index_workorder_notes_id ON workorder_notes (id)";

    static final String INSERT_INTO_WORK_ORDER_NOTES_NEW = "INSERT INTO workorder_notes" +
            "(\"id\",\"uuid\",\"workorder_id\",\"user_id\",\"workorder_notes\"," +
            "\"modified\",\"sync_status\",\"created\")\n" +
            "SELECT \"id\",\"uuid\",\"workorder_id\",\"user_id\",\"workorder_notes\"," +
            "\"modified\",\"sync_status\",\"created\" " +
            "FROM \" " + oldWorkOrderNotesTableName + "\";";

    static final String DROP_WORK_ORDER_NOTES = "DROP TABLE IF EXISTS \" " + oldWorkOrderNotesTableName + "\";";

    //Alter table workorder_note_details change primary key to UUID and add CASCADE on update to foreign key
    static final String oldWorkOrderNoteDetailTableName = "workorder_note_details_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_WORK_ORDER_NOTE_DETAILS = "ALTER TABLE " +
            "\"workorder_note_details\" RENAME TO \" " + oldWorkOrderNoteDetailTableName + "\";";

    static final String CREATE_TABLE_WORK_ORDER_NOTE_DETAILS = "CREATE TABLE \"workorder_note_details\" (\n" +
            "\"id\" INTEGER NOT NULL,\n" +
            "\"uuid\" TEXT NOT NULL PRIMARY KEY,\n" +
            "\"workorder_note_id\" INTEGER NOT NULL,\n" +
            "\"property\" TEXT NOT NULL,\n" +
            "\"property_key\" TEXT NOT NULL,\n" +
            "\"old_value\" TEXT,\n" +
            "\"value\" TEXT,\n" +
            "\"modified\" TEXT NOT NULL,\n" +
            "\"sync_status\" INTEGER NOT NULL DEFAULT (0),\n" +
            "\"created\" TEXT NOT NULL,\n" +
            "CONSTRAINT workorder_note_details_workorder_note_id FOREIGN KEY (workorder_note_id) REFERENCES workorder_notes (id) ON DELETE NO ACTION ON UPDATE CASCADE" +
            ");";

    static final String INSERT_INTO_WORK_ORDER_NOTE_DETAILS_NEW = "INSERT INTO workorder_note_details" +
            "(\"id\",\"uuid\",\"workorder_note_id\",\"property\",\"property_key\"," +
            "\"old_value\",\"value\",\"modified\",\"sync_status\",\"created\")\n" +
            "SELECT \"id\",\"uuid\",\"workorder_note_id\",\"property\",\"property_key\"," +
            "\"old_value\",\"value\",\"modified\",\"sync_status\",\"created\" " +
            "FROM \" " + oldWorkOrderNoteDetailTableName + "\";";

    static final String DROP_WORK_ORDER_NOTE_DETAILS = "DROP TABLE IF EXISTS \" " + oldWorkOrderNoteDetailTableName + "\";";

    //Alter table workorder_attachments change primary key to UUID and add CASCADE on update to foreign key
    static final String oldWorkOrderAttachmentTableName = "workorder_attachments_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_WORK_ORDER_ATTACHMENTS = "ALTER TABLE " +
            "\"workorder_attachments\" RENAME TO \" " + oldWorkOrderAttachmentTableName + "\";";

    static final String CREATE_TABLE_WORK_ORDER_ATTACHMENTS = "CREATE TABLE \"workorder_attachments\" (\n" +
            "\"id\" INTEGER NOT NULL,\n" +
            "\"uuid\" TEXT NOT NULL PRIMARY KEY,\n" +
            "\"workorder_id\" INTEGER,\n" +
            "\"display_filename\" TEXT NOT NULL,\n" +
            "\"filename\" TEXT NOT NULL,\n" +
            "\"filesize\" INTEGER NOT NULL,\n" +
            "\"content_type\" TEXT,\n" +
            "\"author_id\" INTEGER NOT NULL,\n" +
            "\"file_md5_checksum\" TEXT NOT NULL,\n" +
            "\"modified\" TEXT NOT NULL,\n" +
            "\"sync_status\" INTEGER NOT NULL DEFAULT (0),\n" +
            "\"created\" TEXT NOT NULL,\n" +
            "\"is_downloaded\" INTEGER NOT NULL,\n" +
            "\"is_uploaded\" INTEGER NOT NULL DEFAULT (0),\n" +
            "CONSTRAINT workorder_attachments_author_id FOREIGN KEY (author_id) REFERENCES users (id)," +
            "CONSTRAINT workorder_attachments_workorder_id FOREIGN KEY (workorder_id) REFERENCES workorders (id) ON DELETE NO ACTION ON UPDATE CASCADE" +
            ");";

    static final String INSERT_INTO_WORK_ORDER_ATTACHMENTS_NEW = "INSERT INTO workorder_attachments" +
            "(\"id\",\"uuid\",\"workorder_id\",\"display_filename\",\"filename\"," +
            "\"filesize\",\"content_type\",\"author_id\",\"file_md5_checksum\",\"modified\"," +
            "\"sync_status\",\"created\",\"is_downloaded\",\"is_uploaded\")\n" +
            "SELECT \"id\",\"uuid\",\"workorder_id\",\"display_filename\",\"filename\"," +
            "\"filesize\",\"content_type\",\"author_id\",\"file_md5_checksum\",\"modified\"," +
            "\"sync_status\",\"created\",\"is_downloaded\",\"is_uploaded\" " +
            "FROM \" " + oldWorkOrderAttachmentTableName + "\";";

    static final String DROP_WORK_ORDER_ATTACHMENT = "DROP TABLE IF EXISTS \" " + oldWorkOrderAttachmentTableName + "\";";

    static final String PRAGMA_ON_FOREIGN_KEY = "PRAGMA foreign_keys = ON;";
}
