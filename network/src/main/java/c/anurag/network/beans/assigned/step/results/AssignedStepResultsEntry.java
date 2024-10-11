package c.anurag.network.beans.assigned.step.results;

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

public class AssignedStepResultsEntry implements IEntry<AssignedStepResultsResponse> {
    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public AssignedStepResultsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    public AssignedStepResultsResponse insertUpdate(AssignedStepResultsResponse response) {
        List<AssignedStepResults> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, assigned_checklist_uuid, user_id, " +
                "step_id, checklist_element_id, capture_data_result, pass_fail_result, yes_no_result, grm_result, " +
                "is_deleted, created, modified,  sync_status) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, assigned_checklist_uuid = ?, " +
                "user_id = ?, step_id = ?, checklist_element_id = ?, capture_data_result = ?, pass_fail_result = ?, " +
                "yes_no_result = ?, grm_result = ?, is_deleted = ?, created = ?, modified = ?, " +
                " sync_status = ? " + "WHERE assigned_checklist_uuid = ? AND uuid = ? AND modified <= ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE assigned_checklist_uuid = ? AND uuid = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (AssignedStepResults obj : data) {
            try {
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    int syncStatus = 1;
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, syncStatus);
                        updateStatusStatement.bindString(2, obj.getAssignedChecklistUuid());
                        updateStatusStatement.bindString(3, obj.getUuid());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    }
                } else {
                    String selectSql =
                            "SELECT uuid FROM " + tableName + " WHERE assigned_checklist_uuid = '" + obj.getAssignedChecklistUuid() + "' AND uuid = '" +
                                    obj.getUuid() + "'";

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

    private void bulkInsertUpdate(SQLiteStatement statement, AssignedStepResults obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getAssignedChecklistUuid());
        statement.bindLong(count++, obj.getUserId());
        statement.bindLong(count++, obj.getStepId());
        statement.bindLong(count++, obj.getChecklistElementId());
        Utility.insertNullString(statement, count++, obj.getCaptureDataResult());
        statement.bindLong(count++, obj.getPassFailResult());
        statement.bindLong(count++, obj.getYesNoResult());
        statement.bindLong(count++, obj.getGrmResult());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count++, obj.getAssignedChecklistUuid());
            statement.bindString(count++, obj.getUuid());
            statement.bindString(count, obj.getUpdatedAt());
        }
        statement.execute();
    }
}
