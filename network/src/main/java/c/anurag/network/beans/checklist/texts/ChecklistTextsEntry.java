package c.anurag.network.beans.checklist.texts;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class ChecklistTextsEntry implements IEntry<ChecklistTextsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ChecklistTextsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ChecklistTextsResponse insertUpdate(ChecklistTextsResponse response) {
        List<ChecklistTexts> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, description, created, modified) " +
                "VALUES (?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id =?,  uuid = ?, description = ?, " +
                "created = ?, modified = ?  WHERE uuid = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (ChecklistTexts obj : data) {
            try {
                boolean isUpdate = Utility.getIdQueryFromTable(tableName, obj.getId(), icarusDatabaseManager);
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

    private void bulkInsertUpdate(SQLiteStatement statement, ChecklistTexts obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getDescription());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}
