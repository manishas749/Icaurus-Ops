package c.anurag.network.beans.step.result.functions;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class StepResultFunctionsEntry implements IEntry<StepResultFunctionsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public StepResultFunctionsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public StepResultFunctionsResponse insertUpdate(StepResultFunctionsResponse response) {
        List<StepResultFunctions> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, step_id,capture_data, " +
                "pass_fail, yes_no, capture_data_instruction, good_repair_marginal, " +
                "grm_instruction, pass_fail_instruction, yes_no_instruction,  created, modified) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id =?, uuid = ?, step_id = ?, capture_data = ?, " +
                "pass_fail = ?, yes_no = ?, capture_data_instruction = ?, good_repair_marginal = ?, " +
                "grm_instruction = ?, pass_fail_instruction = ?, yes_no_instruction = ?, " +
                "created = ?, modified = ?  WHERE uuid = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (StepResultFunctions obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, StepResultFunctions obj, boolean insert) {
        statement.clearBindings();
        int count = 1;
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getStepId());
        statement.bindLong(count++, obj.getCaptureData());
        statement.bindLong(count++, obj.getPassFail());
        statement.bindLong(count++, obj.getYesNo());

        statement.bindString(count++, obj.getCaptureDataInstruction());
        statement.bindLong(count++, obj.getGoodRepairMarginal());
        statement.bindString(count++, obj.getGrmInstruction());
        statement.bindString(count++, obj.getPassFailInstruction());
        statement.bindString(count++, obj.getYesNoInstruction());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        if (!insert) {
            statement.bindString(count, obj.getUuid());
        }
        statement.execute();
    }
}