package c.anurag.network.beans.workorder.note;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class WorkorderNotesEntry implements IEntry<WorkorderNotesResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public WorkorderNotesEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public WorkorderNotesResponse insertUpdate(WorkorderNotesResponse response) {
        List<WorkorderNotes> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, workorder_id, user_id, " +
                "workorder_notes, created, modified, sync_status) " +
                "VALUES (?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, workorder_id = ?, " +
                "user_id = ?, workorder_notes = ?, created = ?, modified = ?,  " +
                "  sync_status = ? WHERE uuid = ?";


        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (WorkorderNotes obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, WorkorderNotes obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getWorkorderId());
        statement.bindLong(count++, obj.getUserId());
        Utility.insertNullString(statement, count++, obj.getWorkorderNotes());

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
