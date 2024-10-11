package c.anurag.network.beans.assigned.departments;

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

public class AssignedDepartmentsEntry implements IEntry<AssignedDepartmentsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public AssignedDepartmentsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public AssignedDepartmentsResponse insertUpdate(AssignedDepartmentsResponse response) {
        List<AssignedDepartments> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, assigned_checklist_uuid, " +
                "department_id, is_deleted, created, modified, " +
                "sync_status) VALUES (?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, " +
                "assigned_checklist_uuid = ?, department_id = ?, is_deleted = ?, " +
                "created = ?, modified = ?, " +
                "sync_status = ? WHERE assigned_checklist_uuid = ? AND " +
                "department_id = ? AND modified <= ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE assigned_checklist_uuid = ? AND department_id = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (AssignedDepartments obj : data) {
            try {
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    int syncStatus = 1;
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, syncStatus);
                        updateStatusStatement.bindString(2, obj.getAssignedChecklistUuid());
                        updateStatusStatement.bindLong(3, obj.getDepartmentId());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    }
                } else {
                    String selectSql = "SELECT uuid FROM " + tableName + " WHERE assigned_checklist_uuid = '" + obj.getAssignedChecklistUuid() +
                            "' AND department_id = " + obj.getDepartmentId();

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

    private void bulkInsertUpdate(SQLiteStatement statement, AssignedDepartments obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getAssignedChecklistUuid());
        statement.bindLong(count++, obj.getDepartmentId());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count++, obj.getAssignedChecklistUuid());
            statement.bindLong(count++, obj.getDepartmentId());
            statement.bindString(count, obj.getUpdatedAt());
        }
        statement.execute();
    }
}
