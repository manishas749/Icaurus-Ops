package c.anurag.network.beans.resource.links;

import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class ResourceLinksEntry implements IEntry<ResourceLinksResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ResourceLinksEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ResourceLinksResponse insertUpdate(ResourceLinksResponse response) {
        List<ResourceLinks> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, link_title, link, item_type_id,item_id, "
                + "is_deleted, " +
                " created, modified) " + "VALUES (?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, link_title = ?, link = ?, " +
                "item_type_id = ?, item_id = ?," + "is_deleted = ?, " +
                "created = ?, modified = ?  WHERE uuid = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (ResourceLinks obj : data) {
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

    public void bulkInsertUpdate(SQLiteStatement statement, ResourceLinks obj, boolean insert) {

        statement.clearBindings();
        int count = 1;
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getLinkTitle());
        statement.bindString(count++, obj.getLink());
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
