package c.anurag.network.beans.step.attributes;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class StepAttributesEntry implements IEntry<StepAttributesResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public StepAttributesEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public StepAttributesResponse insertUpdate(StepAttributesResponse response) {
        List<StepAttributes> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, step_id, qa, result_functions, resources," +
                " filerequired, created, modified) VALUES (?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, step_id = ?, qa = ?, result_functions = ?," +
                " resources = ?, filerequired = ?, created = ?, modified = ?  WHERE id = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (StepAttributes obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, StepAttributes obj, boolean insert) {
        statement.clearBindings();
        int count = 1;
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getStepId());
        statement.bindLong(count++, obj.getIsQaRequired());
        statement.bindLong(count++, obj.getIsResultFunctions());
        statement.bindLong(count++, obj.getIsResources());
        statement.bindLong(count++, obj.getIsFileRequired());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        if (!insert) {
            statement.bindString(count, obj.getUuid());
        }
        statement.execute();
    }
}