package com.icarus.database;

import com.icarus.util.AppUtility;

public class MigrationQueries_5_6 {
    static final String PRAGMA_OFF_FOREIGN_KEY = "PRAGMA foreign_keys = OFF;";

    static final String oldUserFavouritesTableName = "_user_favorites_old_" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_USER_FAVORITES = "ALTER TABLE " +
            "\"user_favorites\" RENAME TO \" " + oldUserFavouritesTableName + "\";";

    static final String CREATE_TABLE_USER_FAVOURITES = "CREATE TABLE user_favorites \n" +
            "            (uuid TEXT NOT NULL,\n" +
            "            user_id INTEGER NOT NULL,\n" +
            "            checklist_id INTEGER NOT NULL,\n" +
            "            is_deleted INTEGER NOT NULL  DEFAULT (0),\n" +
            "            created TEXT NOT NULL,\n" +
            "            modified TEXT NOT NULL,\n" +
            "            sync_status INTEGER NOT NULL,\n" +
            "            PRIMARY KEY (uuid),\n" +
            "            CONSTRAINT user_favorites_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            "            );";

    static final String INSERT_INTO_USER_FAVOURITES_NEW = "INSERT INTO \"user_favorites\" " +
            "(\"uuid\", \"user_id\", \"checklist_id\", \"is_deleted\"," +
            " \"created\", \"modified\", \"sync_status\")\n" +
            "SELECT \"uuid\", \"user_id\", \"checklist_id\"," +
            " \"is_deleted\", \"created\", \"modified\", \"sync_status\" FROM \" " + oldUserFavouritesTableName + "\";";

    //Migration for location equipment table as we are adding new field upc_number
    static String oldLocationEquipmentsTableName = "_location_equipments" + AppUtility.Companion.getYMDTime();

    static final String ALTER_TABLE_LOCATION_EQUIPMENTS = "ALTER TABLE " +
            "\"location_equipments\" RENAME TO \" " + oldLocationEquipmentsTableName + "\";";

    static final String CREATE_TABLE_LOCATION_EQUIPMENTS = "CREATE TABLE \"location_equipments\" (\n" +
            "  \"id\" INTEGER NOT NULL,\n" +
            "  \"location_id\" INTEGER NOT NULL,\n" +
            "  \"equipment_id\" INTEGER NOT NULL,\n" +
            "  \"serial_number\" TEXT DEFAULT NULL,\n" +
            "  \"upc_number\" TEXT DEFAULT NULL,\n" +
            "  \"is_deleted\" INTEGER NOT NULL DEFAULT 0,\n" +
            "  \"modified\" TEXT NOT NULL,\n" +
            "  PRIMARY KEY (\"id\"),\n" +
            "  FOREIGN KEY (\"equipment_id\") REFERENCES \"equipments\" (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  FOREIGN KEY (\"location_id\") REFERENCES \"locations\" (\"id\") ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";

    static final String INSERT_INTO_LOCATION_EQUIPMENTS_NEW = "INSERT INTO \"location_equipments\" (\"id\", \"location_id\", \"equipment_id\", \"serial_number\", \"is_deleted\", \"modified\")\n" +
            "SELECT \"id\", \"location_id\", \"equipment_id\", \"serial_number\", \"is_deleted\", \"modified\" FROM \" " + oldLocationEquipmentsTableName + "\";";

    static final String PRAGMA_ON_FOREIGN_KEY = "PRAGMA foreign_keys = ON;";
}
