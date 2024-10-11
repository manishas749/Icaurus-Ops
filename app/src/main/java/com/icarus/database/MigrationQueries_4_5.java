package com.icarus.database;

import com.icarus.util.AppUtility;

/**
 * Created by Monika Rana on 06/05/2020
 */
class MigrationQueries_4_5 {

    static final String PRAGMA_OFF_FOREIGN_KEY = "PRAGMA foreign_keys = OFF;";

    static final String CREATE_TABLE_LOCATION_ROOMS = "CREATE TABLE \"location_rooms\" (\n" +
            "  \"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  \"location_id\" INTEGER NOT NULL,\n" +
            "  \"room_id\" INTEGER NOT NULL,\n" +
            "  \"is_deleted\" INTEGER NOT NULL DEFAULT (0),\n" +
            "  \"modified\" TEXT NOT NULL,\n" +
            "  CONSTRAINT \"location_rooms_room_id\" FOREIGN KEY (\"room_id\") REFERENCES \"rooms\"" +
            " (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT \"location_rooms_location_id\" FOREIGN KEY (\"location_id\") REFERENCES " +
            "\"locations\" (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";

    static final String CREATE_TABLE_QR_STORAGE = "CREATE TABLE \"qr_storage\" (\n" +
            "  \"id\" INTEGER NOT NULL,\n" +
            "  \"uuid\" TEXT NOT NULL,\n" +
            "  \"model\" TEXT NOT NULL,\n" +
            "  \"foreign_key\" TEXT NOT NULL,\n" +
            "  \"code\" TEXT NOT NULL,\n" +
            "  \"modified\" TEXT NOT NULL,\n" +
            "  PRIMARY KEY (\"id\")\n" +
            ");";

    static final String CREATE_TABLE_LOCATION_EQUIPMENTS = "CREATE TABLE \"location_equipments\" (\n" +
            "  \"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  \"location_id\" INTEGER NOT NULL,\n" +
            "  \"equipment_id\" INTEGER NOT NULL,\n" +
            "  \"serial_number\" TEXT DEFAULT NULL,\n" +
            "  \"is_deleted\" INTEGER NOT NULL DEFAULT (0),\n" +
            "  \"modified\" TEXT NOT NULL,\n" +
            "  CONSTRAINT \"location_equipments_equipment_id\" FOREIGN KEY (\"equipment_id\") " +
            "REFERENCES \"equipments\" (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT \"location_equipments_location_id\" FOREIGN KEY (\"location_id\")" +
            " REFERENCES \"locations\" (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";

    static final String ALTER_TABLE_ASSIGNED_ITEM_PLACEHOLDERS = "ALTER TABLE " +
            "\"assigned_item_placeholders\" RENAME TO \"_assigned_item_placeholders_old_"+ AppUtility.Companion.getYMDTime() +"\";";

    static final String CREATE_TABLE_ASSIGNED_ITEM_PLACEHOLDERS = "CREATE TABLE \"assigned_item_placeholders\" (\n" +
            "  \"uuid\" TEXT NOT NULL,\n" +
            "  \"assigned_checklist_uuid\" TEXT NOT NULL,\n" +
            "  \"checklist_element_id\" INTEGER NOT NULL,\n" +
            "  \"item_placeholder_id\" INTEGER NOT NULL,\n" +
            "  \"user_id\" INTEGER NOT NULL,\n" +
            "  \"model\" TEXT DEFAULT NULL,\n" +
            "  \"foreign_key\" INTEGER DEFAULT NULL,\n" +
            "  \"value\" TEXT NOT NULL,\n" +
            "  \"is_deleted\" INTEGER NOT NULL DEFAULT (0),\n" +
            "  \"created\" TEXT NOT NULL,\n" +
            "  \"modified\" TEXT NOT NULL,\n" +
            "  PRIMARY KEY (\"uuid\"),\n" +
            "  CONSTRAINT \"assigned_item_placeholders_assigned_checklist_uuid\" FOREIGN KEY (\"assigned_checklist_uuid\") REFERENCES \"assigned_checklists\" (\"uuid\") ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT \"assigned_item_placeholders_checklist_element_id\" FOREIGN KEY (\"checklist_element_id\") REFERENCES \"checklist_elements\" (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT \"assigned_item_placeholders_user_id\" FOREIGN KEY (\"user_id\") REFERENCES \"users\" (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT \"assigned_item_placeholders_item_placeholder_id\" FOREIGN KEY (\"item_placeholder_id\") REFERENCES \"item_placeholders\" (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";

    static final String INSERT_INTO_ASSIGNED_ITEM_PLACEHOLDERS_NEW = "INSERT INTO \"assigned_item_placeholders\" " +
            "(\"uuid\", \"assigned_checklist_uuid\", \"checklist_element_id\", \"item_placeholder_id\"," +
            " \"user_id\", \"value\", \"is_deleted\", \"created\", \"modified\")\n" +
            "SELECT \"uuid\", \"assigned_checklist_uuid\", \"checklist_element_id\"," +
            " \"item_placeholder_id\", \"user_id\", \"value\", \"is_deleted\", \"created\"," +
            " \"modified\" FROM \"_assigned_item_placeholders_old_"+ AppUtility.Companion.getYMDTime() +"\";";

    static final String PRAGMA_ON_FOREIGN_KEY = "PRAGMA foreign_keys = ON;";
}
