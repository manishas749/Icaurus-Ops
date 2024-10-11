package c.anurag.network.beans.assigned.step.resources;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;

import java.io.File;
import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.database.application.BaseApplication;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class AssignedStepResourcesEntry implements IEntry<AssignedStepResourcesResponse> {

    private File storagePath;
    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public AssignedStepResourcesEntry(Context context, String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
        storagePath = BaseApplication.getCommonFunctions().getStoragePath();
    }

    @Override
    @SuppressLint("Range")
    public AssignedStepResourcesResponse insertUpdate(AssignedStepResourcesResponse response) {
        List<AssignedStepResources> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, assigned_checklist_uuid, " +
                "file_md5_checksum, file_type, item_id, item_type_id, checklist_element_id, user_id, name, " +
                "display_file_name, res_action_type, isuploaded, is_deleted, " +
                "created, modified, sync_status) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, " +
                "assigned_checklist_uuid = ?, file_md5_checksum = ?, file_type = ?, " +
                "item_id = ?, item_type_id = ?, checklist_element_id = ?, user_id = ?, name = ?, " +
                "display_file_name = ?,  res_action_type = ?, isuploaded = ?, " +
                "is_deleted = ?, created = ?, modified = ?, " +
                "sync_status = ? " + "WHERE assigned_checklist_uuid = ? AND uuid = ? AND modified <= ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE assigned_checklist_uuid = ? AND uuid = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (AssignedStepResources obj : data) {
            try {
                int resActionType = 0;
                int isuploaded = 0;
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    int syncStatus = 1;
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, syncStatus);
                        updateStatusStatement.bindString(2, obj.getAssignedChecklistUuid());
                        updateStatusStatement.bindString(3, obj.getUuid());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false, icarusDatabaseManager, resActionType, isuploaded);
                    }
                } else {
                    String selectSql =
                            "SELECT uuid, res_action_type, isuploaded FROM " + tableName + " WHERE assigned_checklist_uuid = '" + obj.getAssignedChecklistUuid() + "' AND uuid = '" +
                                    obj.getUuid() + "'";

                    Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);
                    cursor.moveToFirst();
                    if (cursor.getCount() > 0) {
                        resActionType = cursor.getInt(cursor.getColumnIndex("res_action_type"));
                        isuploaded = cursor.getInt(cursor.getColumnIndex("isuploaded"));
                        bulkInsertUpdate(updateStatement, obj, false, icarusDatabaseManager, resActionType, isuploaded);
                    } else {
                        bulkInsertUpdate(insertStatement, obj, true, icarusDatabaseManager, resActionType, isuploaded);
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

    private void bulkInsertUpdate(SQLiteStatement statement, AssignedStepResources obj, boolean insert, IcarusDatabaseManager icarusDatabaseManager, int resActionType, int isuploaded) {
        int count = 1;
        int syncStatus = 1;
        String selectSql = "SELECT checklists.uuid " + "FROM assigned_checklists " +
                "JOIN checklists ON checklists.id = assigned_checklists.checklist_id " + "WHERE assigned_checklists.uuid = '" +
                obj.getAssignedChecklistUuid() + "'";
        Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);

        if (cursor.moveToFirst() && insert) {
            String checklistUuid = cursor.getString(0);
            File resource = new File(storagePath + "/" + checklistUuid + "/" + obj.getFilename());

            if (resource.exists()) {
                isuploaded = 1;
            }
        }

        cursor.close();

        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindString(count++, obj.getAssignedChecklistUuid());
        Utility.insertNullString(statement, count++, obj.getFileMd5Checksum());
        Utility.insertNullString(statement, count++, obj.getFileType());
        statement.bindLong(count++, obj.getItemId());
        statement.bindLong(count++, obj.getItemTypeId());
        statement.bindLong(count++, obj.getChecklistElementId());
        statement.bindLong(count++, obj.getUserId());
        Utility.insertNullString(statement, count++, obj.getFilename());
        Utility.insertNullString(statement, count++, obj.getDisplayFileName());
        statement.bindLong(count++, resActionType);
        statement.bindLong(count++, isuploaded);
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count++, obj.getAssignedChecklistUuid());
            statement.bindString(count++, obj.getUuid());
            statement.bindString(count, obj.getUpdatedAt());
        }
        statement.execute();
    }
}
