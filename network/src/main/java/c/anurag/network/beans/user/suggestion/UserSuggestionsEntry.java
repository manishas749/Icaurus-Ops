package c.anurag.network.beans.user.suggestion;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class UserSuggestionsEntry implements IEntry<UserSuggestionsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public UserSuggestionsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public UserSuggestionsResponse insertUpdate(UserSuggestionsResponse response) {
        List<UserSuggestions> data = response.getData();
        String insertSql =
                "INSERT INTO " + tableName + " (uuid, user_id, checklist_id, " + "assigned_checklist_uuid, description, " +
                        "is_deleted, created, modified,  sync_status, item_type_id) " + "VALUES (?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, user_id = ?, " +
                "checklist_id = ?, assigned_checklist_uuid = ?, description = ?," +
                "is_deleted = ?, created = ?, modified = ?, sync_status = ?, item_type_id =? " +
                "WHERE uuid = ? AND assigned_checklist_uuid = ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE uuid = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (UserSuggestions obj : data) {
            try {
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    int syncStatus = 1;
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, syncStatus);
                        updateStatusStatement.bindString(2, obj.getUuid());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    }
                } else {
                    String selectSql = "SELECT uuid FROM " + tableName + " WHERE assigned_checklist_uuid = '" + obj.getAssignedChecklistUuid() +
                            "' AND uuid = '" + obj.getUuid() + "'";

                    Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);

                    if (cursor.getCount() > 0) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    } else {
                        bulkInsertUpdate(insertStatement, obj, true);
                    }
                    cursor.close();
                }
            } catch (Exception e) {
                TraceActivity.writeActivityError("Table: " + tableName + "  Uuid: " + obj.getUuid());
                e.printStackTrace();
            }
        }
        return response;
    }

    private void bulkInsertUpdate(SQLiteStatement statement, UserSuggestions obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        int itemTypeId = 0;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getUserId());
        statement.bindLong(count++, obj.getChecklistId());
        statement.bindString(count++, obj.getAssignedChecklistUuid());

        statement.bindString(count++, obj.getDescription());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);
        statement.bindLong(count++, itemTypeId);

        if (!insert) {
            statement.bindString(count++, obj.getUuid());
            statement.bindString(count, obj.getAssignedChecklistUuid());
        }
        statement.execute();
    }
}