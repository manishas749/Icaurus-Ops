package c.anurag.network.beans.workorder.note.details;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class WorkorderNoteDetailsEntry implements IEntry<WorkorderNoteDetailsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public WorkorderNoteDetailsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public WorkorderNoteDetailsResponse insertUpdate(WorkorderNoteDetailsResponse response) {
        List<WorkorderNoteDetails> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, workorder_note_id, " +
                "property, property_key, old_value, value, created, modified,  " +
                " sync_status) VALUES (?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, workorder_note_id = ?, " +
                "property = ?, property_key = ?, old_value = ?, value = ?, created = ?, " +
                "modified = ?, sync_status = ? WHERE uuid = ?";


        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (WorkorderNoteDetails obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, WorkorderNoteDetails obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getWorkorderNoteId());
        statement.bindString(count++, obj.getProperty());
        statement.bindString(count++, obj.getPropertyKey());
        Utility.insertNullString(statement, count++, obj.getOldValue());
        statement.bindString(count++, obj.getValue());
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
