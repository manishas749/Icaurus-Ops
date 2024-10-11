package c.anurag.network.beans.assigned.skip.defer.reasons;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class AssignedSkipDeferReasonsEntry implements IEntry<AssignedSkipDeferReasonsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public AssignedSkipDeferReasonsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public AssignedSkipDeferReasonsResponse insertUpdate(AssignedSkipDeferReasonsResponse response) {
        List<AssignedSkipDeferReasons> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, user_id, " +
                "assigned_checklist_uuid, assigned_checklist_step_id, checklist_element_id, status, reason, " +
                "is_deleted, created, modified, sync_status) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, user_id = ?, " +
                "assigned_checklist_uuid = ?, assigned_checklist_step_id = ?, checklist_element_id = ?, status = ?, " +
                "reason = ?, is_deleted = ?, created = ?, modified = ?, " +
                "sync_status = ? WHERE assigned_checklist_uuid = ? " +
                "AND assigned_checklist_step_id = ? AND checklist_element_id = ? AND modified <= ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE assigned_checklist_uuid = ? " +
                "AND assigned_checklist_step_id = ? AND checklist_element_id = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (AssignedSkipDeferReasons obj : data) {
            try {
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    int syncStatus = 1;
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, syncStatus);
                        updateStatusStatement.bindString(2, obj.getAssignedChecklistUuid());
                        updateStatusStatement.bindLong(3, obj.getAssignedChecklistStepId());
                        updateStatusStatement.bindLong(4, obj.getChecklistElementId());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    }
                } else {
                    String selectSql = "SELECT uuid FROM " + tableName + " WHERE assigned_checklist_uuid = '" + obj.getAssignedChecklistUuid() +
                            "' AND assigned_checklist_step_id = " + obj.getAssignedChecklistStepId() + " AND checklist_element_id = " + obj.getChecklistElementId();

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

    private void bulkInsertUpdate(SQLiteStatement statement, AssignedSkipDeferReasons obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getUserId());
        statement.bindString(count++, obj.getAssignedChecklistUuid());
        Utility.insertNullLong(statement, count++, obj.getAssignedChecklistStepId());
        statement.bindLong(count++, obj.getChecklistElementId());
        statement.bindLong(count++, obj.getStatus());
        Utility.insertNullString(statement, count++, obj.getReason());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count++, obj.getAssignedChecklistUuid());
            statement.bindLong(count++, obj.getAssignedChecklistStepId());
            statement.bindLong(count++, obj.getChecklistElementId());
            statement.bindString(count, obj.getUpdatedAt());
        }
        statement.execute();
    }
}
