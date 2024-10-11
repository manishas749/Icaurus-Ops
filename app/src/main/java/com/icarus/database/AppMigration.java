package com.icarus.database;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.migration.Migration;
import androidx.annotation.NonNull;


class AppMigration {

    public static final Migration MIGRATION_FROM_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
        }
    };

    public static final Migration MIGRATION_FROM_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(MigrationQueries_2_3.PARGMA_OFF_FOREIGN_KEY);
            database.execSQL(MigrationQueries_2_3.DROP_ASSIGNED_COMMENTS);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_ASSIGNED_COMMENTS);

            database.execSQL(MigrationQueries_2_3.DROP_CHECKLIST_NEW);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_CHECKLIST_NEW);
            database.execSQL(MigrationQueries_2_3.INSERT_INTO_CHECKLIST_NEW);
            database.execSQL(MigrationQueries_2_3.DROP_CHECKLISTS);
            database.execSQL(MigrationQueries_2_3.ALTER_CHECKLISTS);

            database.execSQL(MigrationQueries_2_3.DROP_CHECKLIST_EXECUTION_PERMISSION_NEW);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_CHECKLIST_EXECUTION_PERMISSION_NEW);
            database.execSQL(MigrationQueries_2_3.INSERT_INTO_CHECKLIST_EXECUTION_PERMISSION_NEW);
            database.execSQL(MigrationQueries_2_3.DROP_CHECKLIST_EXECUTION_PERMISSION);
            database.execSQL(MigrationQueries_2_3.ALTER_CHECKLIST_EXECUTION_PERMISSION);

            database.execSQL(MigrationQueries_2_3.DROP_USER_NEW);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_USER_NEW);
            database.execSQL(MigrationQueries_2_3.INSERT_INTO_USER_NEW);
            database.execSQL(MigrationQueries_2_3.DROP_USERS);
            database.execSQL(MigrationQueries_2_3.ALTER_USERS);

            database.execSQL(MigrationQueries_2_3.DROP_ASSIGNED_NCW_NEW);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_ASSIGNED_NCW_NEW);
            database.execSQL(MigrationQueries_2_3.INSERT_INTO_ASSIGNED_NCW_NEW);
            database.execSQL(MigrationQueries_2_3.DROP_ASSIGNED_NCW);
            database.execSQL(MigrationQueries_2_3.ALTER_ASSIGNED_NCW);

            database.execSQL(MigrationQueries_2_3.DROP_WORKORDER_NEW);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_WORKORDER_NEW);
            database.execSQL(MigrationQueries_2_3.INSERT_INTO_WORKORDER_NEW);
            database.execSQL(MigrationQueries_2_3.DROP_WORKORDERS);
            database.execSQL(MigrationQueries_2_3.ALTER_WORKORDERS);

            database.execSQL(MigrationQueries_2_3.DROP_LOCATION_ROOM_EQUIPMENT_NEW);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_LOCATION_ROOM_EQUIPMENT_NEW);
            database.execSQL(MigrationQueries_2_3.INSERT_INTO_LOCATION_ROOM_EQUIPMENT_NEW);
            database.execSQL(MigrationQueries_2_3.DROP_LOCATION_ROOM_EQUIPMENTS);
            database.execSQL(MigrationQueries_2_3.ALTER_LOCATION_ROOM_EQUIPMENTS);

            database.execSQL(MigrationQueries_2_3.DROP_PPE_NEW);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_PPE_NEW);
            database.execSQL(MigrationQueries_2_3.INSERT_INTO_PPE_NEW);
            database.execSQL(MigrationQueries_2_3.DROP_PPES);
            database.execSQL(MigrationQueries_2_3.ALTER_PPES);

            database.execSQL(MigrationQueries_2_3.DROP_ASSIGNED_STEP_RESOURCE_NEW);
            database.execSQL(MigrationQueries_2_3.CREATE_TABLE_ASSIGNED_STEP_RESOURCE_NEW);
            database.execSQL(MigrationQueries_2_3.INSERT_INTO_ASSIGNED_STEP_RESOURCE_NEW);
            database.execSQL(MigrationQueries_2_3.DROP_ASSIGNED_STEP_RESOURCES);
            database.execSQL(MigrationQueries_2_3.ALTER_ASSIGNED_STEP_RESOURCES);

            database.execSQL(MigrationQueries_2_3.PARGMA_ON_FOREIGN_KEY);
        }
    };

    static final Migration MIGRATION_FROM_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(MigrationQueries_3_4.PRAGMA_OFF_FOREIGN_KEY);

            //Added checklist_element_id in user_suggestions table
            database.execSQL(MigrationQueries_3_4.DROP_USER_SUGGESTIONS_NEW);
            database.execSQL(MigrationQueries_3_4.CREATE_USER_SUGGESTIONS_NEW);
            database.execSQL(MigrationQueries_3_4.INSERT_INTO_USER_SUGGESTION_NEW);
            database.execSQL(MigrationQueries_3_4.DROP_USER_SUGGESTIONS);
            database.execSQL(MigrationQueries_3_4.ALTER_USER_SUGGESTION_NEW);

            //Add checklist_id and checklist_element_id column in the assigned_checklist_comments table
            database.execSQL(MigrationQueries_3_4.DROP_ASSIGNED_CHECKLIST_COMMENTS_NEW);
            database.execSQL(MigrationQueries_3_4.CREATE_ASSIGNED_CHECKLIST_COMMENTS_NEW);
            database.execSQL(MigrationQueries_3_4.INSERT_ASSIGNED_CHECKLIST_COMMENTS_NEW);
            database.execSQL(MigrationQueries_3_4.DROP_ASSIGNED_CHECKLIST_COMMENTS);
            database.execSQL(MigrationQueries_3_4.ALTER_ASSIGNED_CHECKLIST_COMMENTS_NEW);

            database.execSQL(MigrationQueries_3_4.PRAGMA_ON_FOREIGN_KEY);

        }
    };

    static final Migration MIGRATION_FROM_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(MigrationQueries_4_5.PRAGMA_OFF_FOREIGN_KEY);

            //Create table location rooms
            database.execSQL(MigrationQueries_4_5.CREATE_TABLE_LOCATION_ROOMS);

            //Create table qr_storage
            database.execSQL(MigrationQueries_4_5.CREATE_TABLE_QR_STORAGE);

            //Create table location_equipments
            database.execSQL(MigrationQueries_4_5.CREATE_TABLE_LOCATION_EQUIPMENTS);

            //Alter table assigned_item_placeholders*
            database.execSQL(MigrationQueries_4_5.ALTER_TABLE_ASSIGNED_ITEM_PLACEHOLDERS);
            database.execSQL(MigrationQueries_4_5.CREATE_TABLE_ASSIGNED_ITEM_PLACEHOLDERS);
            database.execSQL(MigrationQueries_4_5.INSERT_INTO_ASSIGNED_ITEM_PLACEHOLDERS_NEW);

            database.execSQL(MigrationQueries_4_5.PRAGMA_ON_FOREIGN_KEY);

        }
    };

    static final Migration MIGRATION_FROM_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(MigrationQueries_5_6.PRAGMA_OFF_FOREIGN_KEY);

            //Alter table user_suggestions
            database.execSQL(MigrationQueries_5_6.ALTER_TABLE_USER_FAVORITES);
            database.execSQL(MigrationQueries_5_6.CREATE_TABLE_USER_FAVOURITES);
            database.execSQL(MigrationQueries_5_6.INSERT_INTO_USER_FAVOURITES_NEW);

            //Alter table location_equipments
            database.execSQL(MigrationQueries_5_6.ALTER_TABLE_LOCATION_EQUIPMENTS);
            database.execSQL(MigrationQueries_5_6.CREATE_TABLE_LOCATION_EQUIPMENTS);
            database.execSQL(MigrationQueries_5_6.INSERT_INTO_LOCATION_EQUIPMENTS_NEW);

            database.execSQL(MigrationQueries_5_6.PRAGMA_ON_FOREIGN_KEY);

        }
    };

    static final Migration MIGRATION_FROM_6_7 = new Migration(6, 7) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(MigrationQueries_6_7.PRAGMA_OFF_FOREIGN_KEY);

            //Alter table location_equipments
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_LOCATION_EQUIPMENTS);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_LOCATION_EQUIPMENTS);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_LOCATION_EQUIPMENTS_NEW);

            //Alter table location_rooms
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_LOCATION_ROOMS);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_LOCATION_ROOMS);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_LOCATION_ROOMS_NEW);

            //Alter table location_room_equipments
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_LOCATION_ROOM_EQUIPMENTS);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_LOCATION_ROOM_EQUIPMENTS);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_LOCATION_ROOM_EQUIPMENTS_NEW);

            //Alter table location_room_equipments
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_CHECKLIST_ROOM_EQUIPMENTS);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_CHECKLIST_ROOM_EQUIPMENTS);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_CHECKLIST_ROOM_EQUIPMENTS_NEW);

            //Alter table assigned_room_equipments
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_ASSIGNED_ROOM_EQUIPMENTS);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_ASSIGNED_ROOM_EQUIPMENTS);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_ASSIGNED_ROOM_EQUIPMENTS_NEW);

            //Alter table checklists
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_CHECKLISTS);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_CHECKLISTS);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_CHECKLISTS_NEW);

            //Alter table work_orders
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_WORK_ORDER);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_WORK_ORDERS);
            database.execSQL(MigrationQueries_6_7.CREATE_WORK_ORDER_UNIQUE_INDEX);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_WORK_ORDERS_NEW);
            database.execSQL(MigrationQueries_6_7.DROP_WORK_ORDERS);

            //Alter table workorder_notes
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_WORK_ORDER_NOTES);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_WORK_ORDER_NOTES);
            database.execSQL(MigrationQueries_6_7.CREATE_WORK_ORDER_NOTES_UNIQUE_INDEX);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_WORK_ORDER_NOTES_NEW);
            database.execSQL(MigrationQueries_6_7.DROP_WORK_ORDER_NOTES);

            //Alter table workorder_note_details
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_WORK_ORDER_NOTE_DETAILS);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_WORK_ORDER_NOTE_DETAILS);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_WORK_ORDER_NOTE_DETAILS_NEW);
            database.execSQL(MigrationQueries_6_7.DROP_WORK_ORDER_NOTE_DETAILS);

            //Alter table workorder_attachments
            database.execSQL(MigrationQueries_6_7.ALTER_TABLE_WORK_ORDER_ATTACHMENTS);
            database.execSQL(MigrationQueries_6_7.CREATE_TABLE_WORK_ORDER_ATTACHMENTS);
            database.execSQL(MigrationQueries_6_7.INSERT_INTO_WORK_ORDER_ATTACHMENTS_NEW);
            database.execSQL(MigrationQueries_6_7.DROP_WORK_ORDER_ATTACHMENT);

            database.execSQL(MigrationQueries_6_7.PRAGMA_ON_FOREIGN_KEY);

        }
    };

}
