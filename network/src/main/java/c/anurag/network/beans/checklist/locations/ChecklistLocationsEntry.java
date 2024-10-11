package c.anurag.network.beans.checklist.locations;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class ChecklistLocationsEntry implements IEntry<ChecklistLocationsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ChecklistLocationsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ChecklistLocationsResponse insertUpdate(ChecklistLocationsResponse response) {
        List<ChecklistLocations> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, checklist_id, location_id, is_deleted, " +
                "created, modified) VALUES (?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, checklist_id = ?,  location_id = ?, " +
                "is_deleted = ?, created = ?, modified = ? WHERE checklist_id = ? " +
                "AND location_id = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (ChecklistLocations obj : data) {
            try {
                String selectSql = "SELECT id FROM " + tableName + " WHERE checklist_id = " + obj.getChecklistId() + " AND location_id = " + obj.getLocationId();
                Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);

                if (cursor.getCount() > 0) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, ChecklistLocations obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindLong(count++, obj.getChecklistId());
        statement.bindLong(count++, obj.getLocationId());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}
