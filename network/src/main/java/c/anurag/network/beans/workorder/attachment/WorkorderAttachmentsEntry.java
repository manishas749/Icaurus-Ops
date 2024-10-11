package c.anurag.network.beans.workorder.attachment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
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

public class WorkorderAttachmentsEntry implements IEntry<WorkorderAttachmentsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;
    private File storagePath;

    public WorkorderAttachmentsEntry(Context context, String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
        storagePath = BaseApplication.getCommonFunctions().getStoragePath();
    }

    @SuppressLint("Range")
    @Override
    public WorkorderAttachmentsResponse insertUpdate(WorkorderAttachmentsResponse response) {
        List<WorkorderAttachments> data = response.getData();
        //ToDo Need to check in app, 'disk_directory,'
        String insertSql = "INSERT INTO " + tableName + " (uuid, workorder_id, " +
                "display_filename, filesize, content_type, author_id, filename, md5_checksum, " +
                "res_action_type, isuploaded, created, modified, " +
                " sync_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, workorder_id = ?, " +
                "display_filename = ?, filesize = ?, content_type = ?, author_id = ?, " +
                "filename = ?, md5_checksum = ?, res_action_type = ?, " +
                "isuploaded = ?, created = ?, modified = ?,  " +
                "sync_status = ? WHERE uuid = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (WorkorderAttachments obj : data) {
            try {
                String selectSql = "SELECT uuid, res_action_type, isuploaded FROM " + tableName + " WHERE uuid = '" + obj.getUuid() + "'";
                Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);
                boolean isUpdate = cursor.getCount() > 0;
                int resActionType = 0;
                int isuploaded = 1;
                if (isUpdate) {
                    cursor.moveToFirst();
                    resActionType = cursor.getInt(cursor.getColumnIndex("res_action_type"));
                    isuploaded = cursor.getInt(cursor.getColumnIndex("isuploaded"));
                    bulkInsertUpdate(updateStatement, obj, false, resActionType, isuploaded);
                } else {
                    bulkInsertUpdate(insertStatement, obj, true, resActionType, isuploaded);
                }
            } catch (Exception e) {
                TraceActivity.writeActivityError("Table: " + tableName + "  Uuid: " + obj.getUuid());
                e.printStackTrace();
            }
        }
        return response;
    }

    private void bulkInsertUpdate(SQLiteStatement statement, WorkorderAttachments obj, boolean insert, int mResActionType, int mIsUploaded) {
        int count = 1;
        int syncStatus = 1;

        File resource = new File(storagePath + "/" + CommonString.WorkOrderAttachments + "/" + obj.getFilename());

        if (resource.exists() && insert) {
            if (SHA1.checkMD5(obj.getMd5Checksum(), resource)) {
                mIsUploaded = 0;
            }
        }

        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        Utility.insertNullLong(statement, count++, obj.getWorkorderId());
        statement.bindString(count++, obj.getDisplayFilename());
        statement.bindLong(count++, obj.getFilesize());
        statement.bindString(count++, obj.getContentType());
        statement.bindLong(count++, obj.getAuthorId());
        statement.bindString(count++, obj.getFilename());
        statement.bindString(count++, obj.getMd5Checksum());
        //statement.bindString(count++, obj.getDiskDirectory);
        statement.bindLong(count++, mResActionType);
        statement.bindLong(count++, mIsUploaded);

        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);
        if (!insert) {
            statement.bindString(count, obj.getUuid());
        }
        statement.execute();
    }
}
