package c.anurag.network.beans.checklist.ppes;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.util.TraceActivity;

import static c.anurag.network.database.Utility.getIdQueryFromTable;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class ChecklistPpesEntry implements IEntry<ChecklistPpesResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ChecklistPpesEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ChecklistPpesResponse insertUpdate(ChecklistPpesResponse response) {
        List<ChecklistPpes> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, ppe_id, checklist_id, step_id, status, " +
                " created, modified) VALUES (?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, ppe_id = ? ,checklist_id = ?, step_id = ?, " +
                "status = ?, created = ?, modified = ?  WHERE id = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (ChecklistPpes obj : data) {
            try {
                boolean isUpdate = getIdQueryFromTable(tableName, obj.getId(), icarusDatabaseManager);
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

    private void bulkInsertUpdate(SQLiteStatement statement, ChecklistPpes obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getPpeId());
        statement.bindLong(count++, obj.getChecklistId());
        statement.bindLong(count++, obj.getStepId());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());

        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}
