package c.anurag.network.beans.user.favorites;

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

public class UserFavoritesEntry implements IEntry<UserFavoritesResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public UserFavoritesEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    public UserFavoritesResponse insertUpdate(UserFavoritesResponse response) {
        List<UserFavorites> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, user_id, checklist_id, " +
                "is_deleted, created, modified, sync_status) " +
                "VALUES (?,?,?,?,?,?,?);";
        String updateSql =
                "UPDATE " + tableName + " SET uuid = ?, user_id = ?, checklist_id = ?, " +
                        "is_deleted = ?, created = ?, modified = ?, " +
                        " sync_status = ? WHERE checklist_id = ? AND user_id = ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE uuid = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (UserFavorites obj : data) {
            try {
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, 1);
                        updateStatusStatement.bindString(2, obj.getUuid());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    }
                } else {
                    String selectSql =
                            "SELECT uuid FROM " + tableName + " WHERE checklist_id = '" + obj.getChecklistId() + "' AND user_id = " + obj.getUserId();
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

    private void bulkInsertUpdate(SQLiteStatement statement, UserFavorites object, boolean insert) {
        int count = 1;
        int syncStatus = 1;

        statement.clearBindings();

        statement.bindString(count++, object.getUuid());
        statement.bindLong(count++, object.getUserId());
        statement.bindLong(count++, object.getChecklistId());
        statement.bindLong(count++, object.getIsDeleted());
        statement.bindString(count++, object.getCreatedAt());
        statement.bindString(count++, object.getUpdatedAt());

        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindLong(count++, object.getChecklistId());
            statement.bindLong(count, object.getUserId());
        }

        statement.execute();
    }
}
