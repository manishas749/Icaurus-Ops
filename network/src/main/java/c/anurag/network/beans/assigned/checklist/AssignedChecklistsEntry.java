package c.anurag.network.beans.assigned.checklist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;

import java.util.List;

import c.anurag.common.util.TraceActivity;
import c.anurag.database.IcarusDatabaseManager;
import c.anurag.network.IEntry;
import c.anurag.network.apiservice.IGetApiCall;
import c.anurag.network.beans.ChecklistStatusEnum;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class AssignedChecklistsEntry implements IEntry<AssignedChecklistsResponse> {
    private final IcarusDatabaseManager icarusDatabaseManager;
    private final String tableName;
    private IGetApiCall assignedService;
    private String lastActivityBefore;
    private String lastActivityAfter;
    private FetchChildElementsData fetchChildElementsData;

    public AssignedChecklistsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager, String lastActivityAfter, String lastActivityBefore, Context context, IGetApiCall assignedService) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
        this.lastActivityAfter = lastActivityAfter;
        this.lastActivityBefore = lastActivityBefore;
        this.assignedService = assignedService;
        fetchChildElementsData = new FetchChildElementsData(context);
    }

    public AssignedChecklistsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    //getAssignedAt
    @Override
    public AssignedChecklistsResponse insertUpdate(AssignedChecklistsResponse response) {
        List<AssignedChecklists> data = response.getData();
        String insertSql = "INSERT INTO " + tableName + " (uuid, checklist_id, user_id, " +
                "assigned_to, checklist_status, reason,  is_deleted, " +
                "start_by_user_id, start_time, due_date, department_id, location_id, " +
                " start_datetime, created, modified,  " +
                "sync_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET uuid = ?, checklist_id = ?, " +
                "user_id = ?, assigned_to = ?, checklist_status = ?, reason = ?, " +
                " is_deleted = ?, start_by_user_id = ?, start_time = ?, " +
                "due_date = ?, department_id = ?, location_id = ?,  " +
                "start_datetime = ?, created = ?, modified = ?, " +
                " sync_status = ? WHERE uuid = ? AND checklist_id = ? AND modified <= ?";
        String updateStatusSql = "UPDATE " + tableName + " SET sync_status = ? WHERE uuid = ? AND checklist_id = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        SQLiteStatement updateStatusStatement = icarusDatabaseManager.compileStatement(updateStatusSql);

        for (AssignedChecklists obj : data) {
            try {
                if (!TextUtils.isEmpty(obj.getOperation())) {
                    int syncStatus = 1;
                    if (obj.getOperation().equalsIgnoreCase("insert") || obj.getOperation().equalsIgnoreCase("update")) {
                        updateStatusStatement.clearBindings();
                        updateStatusStatement.bindLong(1, syncStatus);
                        updateStatusStatement.bindString(2, obj.getUuid());
                        updateStatusStatement.bindLong(3, obj.getChecklistId());
                        updateStatusStatement.execute();
                    } else if (obj.getOperation().equalsIgnoreCase("change")) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    }
                } else {
                    String selectSql = "SELECT uuid FROM " + tableName + " WHERE uuid = '" + obj.getUuid() + "' AND checklist_id = " + obj.getChecklistId();
                    Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);

                    if (cursor.getCount() > 0) {
                        bulkInsertUpdate(updateStatement, obj, false);
                    } else {
                        bulkInsertUpdate(insertStatement, obj, true);
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

    private void bulkInsertUpdate(SQLiteStatement statement, AssignedChecklists obj, boolean insert) {
        int count = 1;
        int syncStatus = 1;
        statement.clearBindings();
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getChecklistId());
        statement.bindLong(count++, obj.getUserId());
        statement.bindLong(count++, obj.getAssigneeType());
        statement.bindLong(count++, obj.getStatus());
        //Utility.insertNullString(statement, count++, obj.getReason());
        statement.bindString(count++, "");
        statement.bindLong(count++, obj.getIsDeleted());
        Utility.insertNullLong(statement, count++, obj.getStartedByUserId());
        Utility.insertNullString(statement, count++, obj.getStartedAt());
        Utility.insertNullString(statement, count++, obj.getDueAt());
        statement.bindLong(count++, obj.getDepartmentId());
        statement.bindLong(count++, obj.getLocationId());
        Utility.insertNullString(statement, count++, obj.getAssignedAt());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindLong(count++, syncStatus);

        if (!insert) {
            statement.bindString(count++, obj.getUuid());
            statement.bindLong(count++, obj.getChecklistId());
            statement.bindString(count, obj.getUpdatedAt());
        }
        statement.execute();

        if (null != fetchChildElementsData) {
            if (TextUtils.isEmpty(lastActivityAfter) && obj.getIsDeleted() == 0) {
                fetchChildElementsData.fetchData(obj.getUuid(), lastActivityAfter, lastActivityBefore, assignedService);
            } else if (!TextUtils.isEmpty(lastActivityAfter)
                    && ChecklistStatusEnum.get(obj.getStatus()) != ChecklistStatusEnum.CANCELLED
                    && ChecklistStatusEnum.get(obj.getStatus()) != ChecklistStatusEnum.COMPLETED) {
                fetchChildElementsData.fetchData(obj.getUuid(), lastActivityAfter, lastActivityBefore, assignedService);
            }
        }
    }
}
