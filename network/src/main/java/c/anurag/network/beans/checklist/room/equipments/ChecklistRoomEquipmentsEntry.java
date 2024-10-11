package c.anurag.network.beans.checklist.room.equipments;

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

public class ChecklistRoomEquipmentsEntry implements IEntry<ChecklistRoomEquipmentsResponse> {

    private final String tableName;
    private final IcarusDatabaseManager icarusDatabaseManager;

    public ChecklistRoomEquipmentsEntry(String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public ChecklistRoomEquipmentsResponse insertUpdate(ChecklistRoomEquipmentsResponse response) {
        List<ChecklistRoomEquipments> data = response.getData();
        String insertSql =
                "INSERT INTO " + tableName + " (id, checklist_location_id, location_room_equipment_id, " +
                        "room_id, equipment_id, is_deleted, created, modified) " +
                        "VALUES (?,?,?,?,?,?,?,?);";
        String updateSql = "UPDATE " + tableName + " SET id = ?, checklist_location_id = ?, " +
                "location_room_equipment_id = ?, room_id = ?, equipment_id = ?, is_deleted = ?, " +
                "created = ?, modified = ? WHERE id = ?";

        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);

        for (ChecklistRoomEquipments obj : data) {
            try{
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

    private void bulkInsertUpdate(SQLiteStatement statement, ChecklistRoomEquipments obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        Utility.insertNullLong(statement, count++, obj.getChecklistLocationId());
        statement.bindLong(count++, obj.getLocationRoomEquipmentId());
        statement.bindLong(count++, obj.getRoomId());
        statement.bindLong(count++, obj.getEquipmentId());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());

        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
    }
}