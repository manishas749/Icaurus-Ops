package com.icarus.database;

/**
 * Created by Monika Rana on 13/04/2020
 */
class MigrationQueries_3_4 {

    static final String PRAGMA_OFF_FOREIGN_KEY = "PRAGMA foreign_keys = OFF;";

    static final String DROP_USER_SUGGESTIONS_NEW = " DROP TABLE IF EXISTS user_suggestions_new;";

    static final String CREATE_USER_SUGGESTIONS_NEW = "CREATE TABLE user_suggestions_new (\n" +
            "   uuid TEXT NOT NULL,\n" +
            "   assigned_checklist_uuid TEXT,\n" +
            "   checklist_id INTEGER,\n" +
            "   checklist_element_id INTEGER NULL,\n" +
            "   user_id INTEGER NOT NULL,\n" +
            "   description TEXT NOT NULL,\n" +
            "   is_deleted INTEGER NOT NULL DEFAULT (0),\n" +
            "   created TEXT NOT NULL,\n" +
            "   modified TEXT NOT NULL,\n" +
            "   sync_status INTEGER NOT NULL DEFAULT (0),\n" +
            "   PRIMARY KEY (uuid),\n" +
            "   CONSTRAINT user_suggestions_assigned_checklist_uuid FOREIGN KEY (assigned_checklist_uuid) REFERENCES assigned_checklists (uuid) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "   CONSTRAINT user_suggestions_checklist_id FOREIGN KEY (checklist_id) REFERENCES checklists (id) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "   CONSTRAINT user_suggestions_checklist_element_id FOREIGN KEY (checklist_element_id) REFERENCES checklist_elements (id) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "   CONSTRAINT user_suggestions_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");";

    static final String INSERT_INTO_USER_SUGGESTION_NEW = "INSERT OR REPLACE INTO user_suggestions_new (uuid, assigned_checklist_uuid, checklist_id, user_id, description, is_deleted, created, modified, sync_status)\n" +
            "SELECT uuid, assigned_checklist_uuid, checklist_id, user_id, description, is_deleted, created, modified, sync_status\n" +
            "FROM user_suggestions;";

    static final String DROP_USER_SUGGESTIONS = "DROP TABLE IF EXISTS user_suggestions;";

    static final String ALTER_USER_SUGGESTION_NEW = "ALTER TABLE user_suggestions_new RENAME TO user_suggestions;";

    static final String DROP_ASSIGNED_CHECKLIST_COMMENTS_NEW = "DROP TABLE IF EXISTS assigned_checklist_comments_new;";

    static final String CREATE_ASSIGNED_CHECKLIST_COMMENTS_NEW = "CREATE TABLE assigned_checklist_comments_new (\n" +
            " uuid TEXT NOT NULL,\n" +
            " assigned_checklist_uuid TEXT NOT NULL,\n" +
            " checklist_id INTEGER NOT NULL,\n" +
            " checklist_element_id INTEGER NULL,\n" +
            " user_id INTEGER NOT NULL,\n" +
            " comment text,\n" +
            " is_deleted INTEGER NOT NULL DEFAULT (0),\n" +
            " created TEXT NOT NULL,\n" +
            " modified TEXT NOT NULL,\n" +
            " sync_status INTEGER NOT NULL DEFAULT (0),\n" +
            " PRIMARY KEY (`uuid`),\n" +
            " CONSTRAINT assigned_checklist_comments_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            " CONSTRAINT assigned_checklist_comments_assigned_checklist_uuid FOREIGN KEY (assigned_checklist_uuid) REFERENCES assigned_checklists (uuid) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            " CONSTRAINT assigned_checklist_comments_checklist_id FOREIGN KEY (checklist_id) REFERENCES checklists (id) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            " CONSTRAINT assigned_checklist_comments_checklist_element_id FOREIGN KEY (checklist_element_id) REFERENCES checklist_elements (id) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ");\n";

    static final String INSERT_ASSIGNED_CHECKLIST_COMMENTS_NEW = "INSERT OR REPLACE INTO assigned_checklist_comments_new(uuid, assigned_checklist_uuid, checklist_id, user_id, comment, is_deleted, created, modified, sync_status)\n" +
            "SELECT \n" +
            "\tAssignedChecklistComment.uuid,\n" +
            "\tAssignedChecklistComment.assigned_checklist_uuid,\n" +
            "\tAssignedChecklist.checklist_id,\n" +
            "\tAssignedChecklistComment.user_id,\n" +
            "\tAssignedChecklistComment.comment,\n" +
            "\tAssignedChecklistComment.is_deleted,\n" +
            "\tAssignedChecklistComment.created,\n" +
            "\tAssignedChecklistComment.modified,\n" +
            "\tAssignedChecklistComment.sync_status\n" +
            "FROM\n" +
            "\tassigned_checklist_comments AssignedChecklistComment\n" +
            "\tINNER JOIN assigned_checklists AssignedChecklist ON (AssignedChecklistComment.assigned_checklist_uuid = AssignedChecklist.uuid);\n";

    static final String DROP_ASSIGNED_CHECKLIST_COMMENTS = "DROP TABLE IF EXISTS `assigned_checklist_comments`;";

    static  final String ALTER_ASSIGNED_CHECKLIST_COMMENTS_NEW = "ALTER TABLE `assigned_checklist_comments_new` RENAME TO `assigned_checklist_comments`;";

    static final String PRAGMA_ON_FOREIGN_KEY = "PRAGMA foreign_keys = ON;";

}
