package c.anurag.network.beans.assigned.warnings;

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

public class AssignedWarningsEntry implements IEntry<AssignedWarningsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public AssignedWarningsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public AssignedWarningsResponse insertUpdate(AssignedWarningsResponse response) {
        List<AssignedWarnings> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, assigned_checklist_uuid, " +
                "user_id, warning_id, checklist_element_id, acknowledged, is_deleted, created, modified, " +
                "sync_status) VALUES (?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, assigned_checklist_uuid = ?, " +
                "user_id = ?, warning_id = ?, checklist_element_id = ?, acknowledged = ?, is_deleted = ?, " +
                "created = ?, modified = ?, sync_status = ? " +
                "WHERE assigned_checklist_uuid = ? AND warning_id = ?  AND checklist_element_id = ? AND modified <= ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE assigned_checklist_uuid = ? AND warning_id = ? AND checklist_element_id = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (AssignedWarnings obj : data) {
            try {
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    int syncStatus = 1;
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, syncStatus);
                        updateStatusStatement.bindString(2, obj.getAssignedChecklistUuid());
                        updateStatusStatement.bindLong(3, obj.getWarningId());
                        updateStatusStatement.bindLong(4, obj.getChecklistElementId());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    }
                } else {
                    String selectSql = "SELECT\n" +
                            "\tuuid\n" +
                            "FROM\n" +
                            tableName +
                            " WHERE\n" +
                            "\tassigned_checklist_uuid = '" + obj.getAssignedChecklistUuid() + "'\n" +
                            " AND warning_id = " + obj.getWarningId() +
                            " AND checklist_element_id = " + obj.getChecklistElementId();

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

    private void bulkInsertUpdate(SQLiteStatement statement, AssignedWarnings obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getAssignedChecklistUuid());
        statement.bindLong(count++, obj.getUserId());
        statement.bindLong(count++, obj.getWarningId());
        statement.bindLong(count++, obj.getChecklistElementId());
        statement.bindLong(count++, obj.getStatus());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count++, obj.getAssignedChecklistUuid());
            statement.bindLong(count++, obj.getWarningId());
            statement.bindLong(count++, obj.getChecklistElementId());
            statement.bindString(count, obj.getUpdatedAt());
        }
        statement.execute();
    }
}
