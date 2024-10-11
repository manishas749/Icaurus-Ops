package c.anurag.network.beans.workorder;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class WorkordersEntry implements IEntry<WorkordersResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public WorkordersEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public WorkordersResponse insertUpdate(WorkordersResponse response) {
        List<Workorders> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, title, due_date, " +
                "workorder_status_id, assigned_to_id, workorder_priority_id, " +
                "workorder_billing_type_id, author_id, location_id, location_room_id, " +
                "location_equipment_id, assigned_to_type, description, closed_date, start_date, " +
                "checklist_id, created, modified, sync_status) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, title = ?, " +
                "due_date = ?, workorder_status_id = ?, assigned_to_id = ?, " +
                "workorder_priority_id = ?, workorder_billing_type_id = ?, author_id = ?, " +
                "location_id = ?, location_room_id = ?, location_equipment_id = ?, " +
                "assigned_to_type = ?, description = ?, closed_date = ?, start_date = ?, " +
                "checklist_id = ?, created = ?, modified = ?, " +
                "sync_status = ? WHERE  uuid = ? AND modified <= ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (Workorders obj : data) {
            try {
                boolean isUpdate = Utility.getUuidQueryFromTable(tableName, obj.getUuid(), icarusDatabaseManager);

                if (isUpdate) {
                    bulkInsertUpdate(updateStatement, obj, false);
                } else {
                    bulkInsertUpdate(insertStatement, obj, true);
                }
            } catch (Exception e) {
                TraceActivity.writeActivityError("Table: " + tableName + "  Uuid: " + obj.getUuid());
                e.printStackTrace();
            }
        }
        return response;
    }

    private void bulkInsertUpdate(SQLiteStatement statement, Workorders obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getTitle());
        Utility.insertNullString(statement, count++, obj.getDueDate());
        statement.bindLong(count++, obj.getWorkorderStatusId());
        statement.bindLong(count++, obj.getAssignedToId());
        statement.bindLong(count++, obj.getWorkorderPriorityId());
        Utility.insertNullLong(statement, count++, obj.getWorkorderBillingTypeId());
        statement.bindLong(count++, obj.getAuthorId());
        statement.bindLong(count++, obj.getLocationId());
        Utility.insertNullLong(statement, count++, obj.getLocationRoomId());
        Utility.insertNullLong(statement, count++, obj.getLocationEquipmentId());
        statement.bindLong(count++, obj.getAssignedToType());
        statement.bindString(count++, obj.getDescription());
        Utility.insertNullString(statement, count++, obj.getClosedDate());
        Utility.insertNullString(statement, count++, obj.getStartDate());
        Utility.insertNullLong(statement, count++, obj.getChecklistId());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count, obj.getUuid());
            statement.bindString(count, obj.getUpdatedAt());
        }
        statement.execute();
    }
}
