package c.anurag.network.beans.associated.checklist;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

import static c.anurag.network.database.Utility.getUuidQueryFromTable;

/**
 * Created by anuragpurwar on 26/3/18.
 */
public class AssociatedChecklistsEntry implements IEntry<AssociatedChecklistsResponse> {
    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public AssociatedChecklistsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public AssociatedChecklistsResponse insertUpdate(AssociatedChecklistsResponse response) {
        List<AssociatedChecklists> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, checklist_id, " +
                " inserted_at, inserted_under, " +
                "associated_checklist_id, is_deleted, created, modified) "
                + "VALUES (?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, checklist_id = ?, " +
                "inserted_at = ?, inserted_under = ?," +
                " associated_checklist_id = ?, is_deleted = ?, " +
                "created = ?, modified = ? WHERE uuid = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (AssociatedChecklists obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, AssociatedChecklists obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getAssociatedChecklistId());
        Utility.insertNullLong(statement, count++, obj.getInsertedAt());
        Utility.insertNullLong(statement, count++, obj.getInsertedUnder());
        Utility.insertNullLong(statement, count++, obj.getAssociatedChecklistId());

        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());

        if (!insert) {
            statement.bindString(count, obj.getUuid());
        }
        statement.execute();
    }
}
