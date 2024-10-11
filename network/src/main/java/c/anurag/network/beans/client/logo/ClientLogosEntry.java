package c.anurag.network.beans.client.logo;

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

public class ClientLogosEntry implements IEntry<ClientLogoResponse> {

    private File storagePath;
    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ClientLogosEntry(Context context, String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
        storagePath = BaseApplication.getCommonFunctions().getStoragePath();
    }

    @Override
    public ClientLogoResponse insertUpdate(ClientLogoResponse response) {
        List<ClientLogo> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, user_id, name, file_md5_checksum, " +
                "isDownloaded, created, modified) " + "VALUES (?,?,?,?,?,?,?,?);";
        String updateSql =
                "UPDATE " + tableName + " SET id = ?, uuid = ?, user_id = ?, name = ?, " + "file_md5_checksum = ?," + "isDownloaded = ?," +
                        "created = ?, modified = ? WHERE uuid = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (ClientLogo obj : data) {
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

    private void bulkInsertUpdate(SQLiteStatement statement, ClientLogo obj, boolean insert) {
        int isDownloaded = 0;
        File resource = new File(storagePath + "/" + CommonString.CHECKLIST_LOGO + "/" + obj.getName());

        if (resource.exists()) {
            if (SHA1.checkMD5(obj.getFileMd5Checksum(), resource)) {
                isDownloaded = 1;
            }
        }

        statement.clearBindings();
        int count = 1;
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getUserId());
        statement.bindString(count++, obj.getName());
        statement.bindString(count++, obj.getFileMd5Checksum());
        statement.bindLong(count++, isDownloaded);
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());

        if (!insert) {
            statement.bindString(count, obj.getUuid());
        }
        statement.execute();
    }
}
