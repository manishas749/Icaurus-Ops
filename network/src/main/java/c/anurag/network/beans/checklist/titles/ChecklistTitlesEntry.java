package c.anurag.network.beans.checklist.titles;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.util.TraceActivity;

import static c.anurag.network.database.Utility.getUuidQueryFromTable;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class ChecklistTitlesEntry implements IEntry<ChecklistTitlesResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ChecklistTitlesEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ChecklistTitlesResponse insertUpdate(ChecklistTitlesResponse response) {
        List<ChecklistTitles> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, checklist_id, title, created, modified) " +
                "VALUES (?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id =?,  uuid = ?, checklist_id = ?, title = ?, " +
                "created = ?, modified = ?  WHERE uuid = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (ChecklistTitles obj : data) {
            try {
                boolean isUpdate = getUuidQueryFromTable(tableName, obj.getUuid(), icarusDatabaseManager);
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

    private void bulkInsertUpdate(SQLiteStatement statement, ChecklistTitles obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getChecklistId());
        statement.bindString(count++, obj.getTitle());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}
