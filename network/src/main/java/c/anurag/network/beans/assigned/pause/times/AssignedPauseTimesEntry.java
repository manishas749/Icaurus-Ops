package c.anurag.network.beans.assigned.pause.times;

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

public class AssignedPauseTimesEntry implements IEntry<AssignedPauseTimesResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public AssignedPauseTimesEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public AssignedPauseTimesResponse insertUpdate(AssignedPauseTimesResponse response) {
        List<AssignedPauseTimes> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid,  " +
                "assigned_checklist_uuid, user_id, resumed_by_user_id, " +
                "reason, pause_status, is_deleted, created, modified, " +
                "sync_status, item_id, item_type_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, assigned_checklist_uuid = ?, " +
                "user_id = ?, resumed_by_user_id = ?, reason = ?, pause_status = ?, " +
                "is_deleted = ?, created = ?, modified = ?, " +
                "sync_status = ?, item_id = ?, item_type_id = ? WHERE uuid = ? AND modified <= ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE uuid = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (AssignedPauseTimes obj : data) {
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
                TraceActivity.writeActivityError("Table: " + tableName + "  Uuid: " + obj.getUuid());
                e.printStackTrace();
            }
        }
        return response;
    }

    private void bulkInsertUpdate(SQLiteStatement statement, AssignedPauseTimes obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        int itemId = 0;
        int itemTypeId = 0;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getAssignedChecklistUuid());
        statement.bindLong(count++, obj.getUserId());
        statement.bindLong(count++, obj.getResumedByUserId());
        Utility.insertNullString(statement, count++, obj.getReason());
        statement.bindLong(count++, obj.getPauseStatus());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);
        statement.bindLong(count++, itemId);
        statement.bindLong(count++, itemTypeId);

        if (!insert) {
            statement.bindString(count++, obj.getUuid());
            statement.bindString(count, obj.getUpdatedAt());
        }
        statement.execute();
    }
}
