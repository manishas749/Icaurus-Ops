package c.anurag.network.beans.checklist;

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

public class ChecklistsEntry implements IEntry<ChecklistsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ChecklistsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ChecklistsResponse insertUpdate(ChecklistsResponse response) {
        List<Checklists> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, department_id, checklist_type_id,  is_template," +
                "delete_reason, user_id, is_sequential,  is_published, is_deleted, created, modified) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, department_id = ? ,checklist_type_id = ?, is_template = ?, " +
                "delete_reason = ?, user_id = ?, is_sequential = ?, is_published = ?, is_deleted = ?," +
                "created = ?, modified = ?  WHERE id = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (Checklists obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, Checklists obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getDepartmentId());
        statement.bindLong(count++, obj.getChecklistTypeId());
        statement.bindLong(count++, obj.getIsTemplate());
        Utility.insertNullString(statement, count++, obj.getDeleteReason());
        statement.bindLong(count++, obj.getAuthorId());
        statement.bindLong(count++, obj.getIsSequential());
        //statement.bindDouble(count++, obj.getEstimatedHours());
        statement.bindLong(count++, obj.getIsPublished());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());

        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}
