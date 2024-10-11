package c.anurag.network.beans.checklist.elements;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

import static c.anurag.network.database.Utility.getIdQueryFromTable;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class ChecklistElementsEntry  implements IEntry<ChecklistElementsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ChecklistElementsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ChecklistElementsResponse insertUpdate(ChecklistElementsResponse response) {
        List<ChecklistElements> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, item_type_id, item_id, " +
                "sort_order, sequence_no, checklist_id, parent_id, " +
                "associated_checklist_uuid, is_deleted, created, modified) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, item_type_id = ?, item_id = ?, " +
                "sort_order = ?, sequence_no = ?, checklist_id = ?,  parent_id = ?," +
                "associated_checklist_uuid = ?, is_deleted = ?, " +
                "created = ?, modified = ? WHERE id = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (ChecklistElements obj : data) {
            try {
                boolean isUpdate = getIdQueryFromTable(tableName, obj.getId(), icarusDatabaseManager);
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

    private void bulkInsertUpdate(SQLiteStatement statement, ChecklistElements obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindLong(count++, obj.getItemTypeId());
        statement.bindLong(count++, obj.getItemId());
        statement.bindLong(count++, obj.getSortOrder());
        statement.bindString(count++, obj.getSequenceNo());
        statement.bindLong(count++, obj.getChecklistId());
        statement.bindLong(count++, obj.getParentId());

        Utility.insertNullString(statement, count++, obj.getAssociatedChecklistUuid());

        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());

        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}