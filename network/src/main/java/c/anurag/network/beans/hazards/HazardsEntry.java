package c.anurag.network.beans.hazards;

import android.content.Context;
import android.database.sqlite.SQLiteStatement;

import java.io.File;
import java.util.List;

import c.anurag.common.md5.SHA1;
import c.anurag.database.IcarusDatabaseManager;
import c.anurag.database.application.BaseApplication;
import c.anurag.database.util.CommonString;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class HazardsEntry implements IEntry<HazardsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;
    private File storagePath;

    public HazardsEntry(Context context, String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
        storagePath = BaseApplication.getCommonFunctions().getStoragePath();
    }

    @Override
    public HazardsResponse insertUpdate(HazardsResponse response) {
        List<Hazards> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, icon, label, " +
                "file_md5_checksum, created, modified, isDownloaded) " + "VALUES (?,?,?,?,?,?,?, ?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, icon = ?, label = ?, " + "file_md5_checksum = ?," +
                "created = ?, modified = ?, isDownloaded= ?  WHERE id = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (Hazards obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, Hazards obj, boolean insert) {
        int isDownloaded = 0;
        File resource = new File(storagePath + "/" + CommonString.Hazards + "/" + obj.getIcon());

        if (resource.exists()) {
            if (SHA1.checkMD5(obj.getFileMd5Checksum(), resource)) {
                isDownloaded = 1;
            }
        }
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        Utility.insertNullString(statement, count++, obj.getIcon());
        Utility.insertNullString(statement, count++, obj.getLabel());
        statement.bindString(count++, obj.getFileMd5Checksum());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, isDownloaded);

        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}
