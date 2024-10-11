package c.anurag.network.beans.assigned.logs;

import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LogsEntry implements IEntry<LogsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public LogsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public LogsResponse insertUpdate(LogsResponse response) {
        List<Logs> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, checklist_id, checklist_element_id, " +
                "item_uuid, action, " +
                "user_id, assigned_to, username, assigned_to_name, assigned_checklist_uuid, " +
                "item_description, step_action, created, modified, sync_status) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, checklist_id = ?, checklist_element_id = ?, item_uuid = ?, " +
                "action = ?, user_id = ?, assigned_to = ?, username = ?, " +
                "assigned_to_name = ?, assigned_checklist_uuid = ?, item_description = ?, " +
                "step_action = ?, created = ?, modified = ?, sync_status = ? WHERE uuid = ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE uuid = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (Logs obj : data) {
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
                    boolean isUpdate = Utility.getUuidQueryFromTable(tableName, obj.getUuid(), icarusDatabaseManager);

                    if (isUpdate) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    } else {
                        bulkInsertUpdate(insertStatement, obj, true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    private void bulkInsertUpdate(SQLiteStatement statement, Logs obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        Utility.insertNullLong(statement, count++, obj.getChecklistId());
        Utility.insertNullLong(statement, count++, obj.getChecklistElementId());

        Utility.insertNullString(statement, count++, obj.getItemUuid());
        statement.bindLong(count++, obj.getAction());
        statement.bindLong(count++, obj.getUserId());
        Utility.insertNullLong(statement, count++, obj.getAssignedTo());
        statement.bindString(count++, obj.getUsername());
        Utility.insertNullString(statement, count++, obj.getAssignedToName());
        Utility.insertNullString(statement, count++, obj.getAssignedChecklistUuid());
        statement.bindString(count++, obj.getItemDescription().replace("null", ""));
        Utility.insertNullString(statement, count++, obj.getStepAction());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count, obj.getUuid());
        }
        statement.execute();
    }
}
