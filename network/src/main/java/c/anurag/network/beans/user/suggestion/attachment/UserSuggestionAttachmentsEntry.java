package c.anurag.network.beans.user.suggestion.attachment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;

import java.io.File;
import java.util.List;

import c.anurag.common.md5.SHA1;
import c.anurag.database.IcarusDatabaseManager;
import c.anurag.database.application.BaseApplication;
import c.anurag.database.util.CommonString;
import c.anurag.network.IEntry;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class UserSuggestionAttachmentsEntry implements IEntry<UserSuggestionAttachmentsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;
    private File storagePath;

    public UserSuggestionAttachmentsEntry(Context context, String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
        storagePath = BaseApplication.getCommonFunctions().getStoragePath();
    }

    @Override
    public UserSuggestionAttachmentsResponse insertUpdate(UserSuggestionAttachmentsResponse response) {
        List<UserSuggestionAttachments> data = response.getData();
        //ToDo Need to check in app, 'disk_directory,'
        String insertSql = "INSERT INTO " + tableName + " (uuid, user_suggestion_uuid, " +
                "display_filename, filename, filesize, content_type, user_id,  md5_checksum, is_uploaded," +
                "created, modified, sync_status) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, user_suggestion_uuid = ?, " +
                "display_filename = ?, filename = ?, filesize = ?, content_type = ?, user_id = ?, " +
                " md5_checksum = ?, is_uploaded = ?, created = ?, modified = ?, " +
                " sync_status = ? WHERE uuid = ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE uuid = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (UserSuggestionAttachments obj : data) {
            try {
                int isUploaded = 1;
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    int syncStatus = 1;
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, syncStatus);
                        updateStatusStatement.bindString(2, obj.getUuid());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false, isUploaded);
                    }
                } else {
                    String selectSql = "SELECT uuid, is_uploaded FROM " + tableName + " WHERE uuid = '" + obj.getUuid() + "'";

                    Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);

                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        isUploaded = cursor.getInt(cursor.getColumnIndex("is_uploaded"));
                        bulkInsertUpdate(updateStatement, obj, false, isUploaded);
                    } else {
                        bulkInsertUpdate(insertStatement, obj, true, isUploaded);
                    }
                    cursor.close();
                }
            } catch (Exception e) {
                TraceActivity.writeActivityError("Table: " + tableName + "  Uuid: " + obj.getUuid());
                e.printStackTrace();
            }
        }
        return response;
    }

    private void bulkInsertUpdate(SQLiteStatement statement, UserSuggestionAttachments obj, boolean insert, int isUploaded) {
        int count = 1;
        int syncStatus = 1;

        File resource = new File(storagePath + "/" + CommonString.WorkOrderAttachments + "/" + obj.getFilename());
        if (insert) {
            if (resource.exists()) {
                if (SHA1.checkMD5(obj.getMd5Checksum(), resource)) {
                    isUploaded = 0;
                }
            }
        }

        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getUserSuggestionUuid());

        statement.bindString(count++, obj.getDisplayFilename());
        statement.bindString(count++, obj.getFilename());
        statement.bindLong(count++, obj.getFilesize());
        statement.bindString(count++, obj.getContentType());
        statement.bindLong(count++, obj.getAuthorId());

        statement.bindString(count++, obj.getMd5Checksum());
        //statement.bindString(count++, obj.getDiskDirectory);
        statement.bindLong(count++, isUploaded);

        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count, obj.getUuid());
        }
        statement.execute();
    }
}
