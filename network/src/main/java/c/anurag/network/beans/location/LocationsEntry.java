package c.anurag.network.beans.location;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LocationsEntry implements IEntry<LocationsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public LocationsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public LocationsResponse insertUpdate(LocationsResponse response) {
        List<Locations> data = response.getData();
        //ToDo gmtdiff is missing in current API
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, name, address, latitude, longitude, " +
                "timezone,  is_deleted, created, modified) " + "VALUES (?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, name = ?, address = ?, " +
                "latitude = ?, longitude = ?, timezone = ?, " +
                "is_deleted = ?, created = ?, modified = ? WHERE id = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (Locations obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, Locations obj, boolean insert) {
        statement.clearBindings();
        int count = 1;
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getName());
        statement.bindString(count++, obj.getAddress());
        statement.bindDouble(count++, obj.getLatitude());
        statement.bindDouble(count++, obj.getLongitude());
        statement.bindString(count++, obj.getTimezone());
        //statement.bindString(count++, obj.getgmtdiff);
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}