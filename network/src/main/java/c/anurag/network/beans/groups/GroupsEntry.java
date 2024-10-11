package c.anurag.network.beans.groups;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class GroupsEntry implements IEntry<GroupsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public GroupsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public GroupsResponse insertUpdate(GroupsResponse response) {
        List<Groups> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, name, created, modified) " + "VALUES (?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, name = ?, " + "created = ?, modified = ? WHERE id = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (Groups obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, Groups obj, boolean insert) {
        statement.clearBindings();
        int count = 1;
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getName());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}