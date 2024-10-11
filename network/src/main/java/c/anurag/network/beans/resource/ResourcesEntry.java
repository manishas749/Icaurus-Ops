package c.anurag.network.beans.resource;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class ResourcesEntry implements IEntry<ResourcesResponse> {

    private final IcarusDatabaseManager icarusDatabaseManager;
    private final String tableName;

    public ResourcesEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ResourcesResponse insertUpdate(ResourcesResponse response) {
        List<Resources> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, file_md5_checksum,is_resource, " +
                "name, file_type, file_size, display_file_name, item_type_id,item_id, " + "is_deleted, " +
                " created, modified) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, file_md5_checksum = ?, is_resource = ?, " +
                "name = ?, file_type = ?, file_size = ?, display_file_name = ?, " + "item_type_id = ?, item_id = ?," + "is_deleted = ?, " +
                "created = ?, modified = ? WHERE uuid = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (Resources obj : data) {
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

    public void bulkInsertUpdate(SQLiteStatement statement, Resources obj, boolean insert) {

        statement.clearBindings();
        int count = 1;
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getFileMd5Checksum());
        statement.bindLong(count++, obj.getIsResource());
        statement.bindString(count++, obj.getFilename());
        statement.bindString(count++, obj.getFileType());
        statement.bindLong(count++, obj.getFileSize());
        statement.bindString(count++, obj.getDisplayFileName());
        statement.bindLong(count++, obj.getItemTypeId());
        statement.bindLong(count++, obj.getItemId());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        if (!insert) {
            statement.bindString(count, obj.getUuid());
        }
        statement.execute();
    }
}
