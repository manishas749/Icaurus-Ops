package c.anurag.network.beans.workorder.billing.type;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class WorkorderBillingTypeEntry implements IEntry<WorkorderBillingTypesResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public WorkorderBillingTypeEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public WorkorderBillingTypesResponse insertUpdate(WorkorderBillingTypesResponse response) {
        List<WorkorderBillingType> data = response.getData();
        String insertSql =
                "INSERT INTO " + tableName + " (id, name, is_default, created, modified) VALUES (?,?,?,?,?);";
        String updateSql =
                "UPDATE " + tableName + " SET id = ?, name = ?, is_default = ?, " + "created = ?, modified = ? WHERE id = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (WorkorderBillingType obj : data) {
            try {
                boolean isUpdate = Utility.getIdQueryFromTable(tableName, obj.getId(), icarusDatabaseManager);

                if (isUpdate) {
                    bulkInsertUpdate(updateStatement, obj, false);
                } else {
                    bulkInsertUpdate(insertStatement, obj, true);
                }
            } catch (Exception e) {
                TraceActivity.writeActivityError("Table: " + tableName + "  Id" + obj.getId());
                e.printStackTrace();
            }
        }
        return response;
    }

    private void bulkInsertUpdate(SQLiteStatement statement, WorkorderBillingType obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getName());
        statement.bindLong(count++, obj.getIsDefault());

        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());

        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}
