package c.anurag.network.beanspost.workorder;

import android.content.ContentValues;
import android.text.TextUtils;

import java.util.List;

import c.anurag.database.IcarusDatabaseHelper;
import c.anurag.database.IcarusDatabaseManager;

public class WorkorderPostEntry {
    public void insertUpdate(List<WorkorderPostResponse.Workorder> data, IcarusDatabaseManager icarusDatabaseManager) {

        for (int i = 0; i < data.size(); i++) {
            WorkorderPostResponse.Workorder Workorder = data.get(i);
            int oldId = Workorder.getOldId();
            int id = Workorder.getId();
            String whereClauseWorkOrder = "";

            ContentValues values;
            values = new ContentValues();
            values.put("id", id);
            values.put("sync_status", 1);

            // Server sends old_id = 0 for already present record
            if (oldId == 0) {
                whereClauseWorkOrder = "id ='" + id + "'";
            } else {
                whereClauseWorkOrder = "id ='" + oldId + "'";
            }

            String operation = Workorder.getOperation();

            if (operation.equalsIgnoreCase("insert")) {
                icarusDatabaseManager.executeUpdateQuery(IcarusDatabaseHelper.TABLE_WORKORDERS, values, whereClauseWorkOrder);
            } else if (operation.equalsIgnoreCase("change")
                    || operation.equalsIgnoreCase("update")) {
                Workorder workorder = new Workorder();
                workorder.setId(Workorder.getId());
                workorder.setUuid(Workorder.getUuid());
                workorder.setTitle(Workorder.getTitle());
                workorder.setDueDate(Workorder.getDueDate());
                workorder.setWorkorderStatusId(Workorder.getWorkorderStatusId());
                workorder.setAssignedToId(Workorder.getAssignedToId());
                workorder.setWorkorderPriorityId(Workorder.getWorkorderPriorityId());
                workorder.setWorkorderBillingTypeId(Workorder.getWorkorderBillingTypeId());
                workorder.setAuthorId(Workorder.getAuthorId());
                workorder.setLocationId(Workorder.getLocationId());
                workorder.setLocationRoomId(Workorder.getLocationRoomId());
                workorder.setLocationEquipmentId(Workorder.getLocationEquipmentId());
                workorder.setAssignedToType(Workorder.getAssignedToType());
                workorder.setDescription(Workorder.getDescription());
                workorder.setClosedDate(Workorder.getClosedDate());
                workorder.setStartDate(Workorder.getStartDate());
                workorder.setChecklistId(Workorder.getChecklistId());
                workorder.setCreated(Workorder.getCreatedAt());
                workorder.setModified(Workorder.getUpdatedAt());
                workorder.setSyncStatus(1);
                //TODO Need to check this later
                //icarusDatabaseManager.insertUpdateWorkorders(workorder);
            }

            if (Workorder.getWorkorderAttachment() != null) {
                for (int j = 0; j < Workorder.getWorkorderAttachment().size(); j++) {
                    WorkorderPostResponse.WorkorderAttachment objAttachment = Workorder.getWorkorderAttachment().get(j);
                    String uuid = objAttachment.getUuid();
                    int workorder_id = objAttachment.getWorkorderId();
                    String disk_directory = objAttachment.getDiskDirectory();
                    if (TextUtils.isEmpty(objAttachment.getOperation())) {
                        values = new ContentValues();
                        values.put("workorder_id", workorder_id);
                        values.put("disk_directory", disk_directory);
                        values.put("sync_status", 1);
                        String whereClauseAttachment = "uuid ='" + uuid + "'";
                        icarusDatabaseManager.executeUpdateQuery(IcarusDatabaseHelper.TABLE_WORKORDER_ATTACHMENT, values, whereClauseAttachment);
                    }
                }
            }

            if (Workorder.getWorkorderNote() != null) {
                for (int j = 0; j < Workorder.getWorkorderNote().size(); j++) {
                    WorkorderPostResponse.WorkorderNote objNote = Workorder.getWorkorderNote().get(j);
                    int idA = objNote.getId();
                    String uuid = objNote.getUuid();
                    int workorder_id = objNote.getWorkorderId();
                    if (TextUtils.isEmpty(objNote.getOperation())) {
                        values = new ContentValues();
                        values.put("id", idA);
                        values.put("workorder_id", workorder_id);
                        values.put("sync_status", 1);
                        String whereClauseAttachment = "uuid ='" + uuid + "'";
                        icarusDatabaseManager.executeUpdateQuery(IcarusDatabaseHelper.TABLE_WORKORDER_NOTES, values, whereClauseAttachment);

                        if (objNote.getWorkorderNoteDetail() != null) {
                            for (int j1 = 0; j1 < objNote.getWorkorderNoteDetail().size(); j1++) {
                                WorkorderPostResponse.WorkorderNoteDetail objNote1 = objNote.getWorkorderNoteDetail().get(j1);
                                int idA1 = objNote1.getId();
                                String uuid1 = objNote1.getUuid();

                                int workorder_note_id = objNote1.getWorkorderNoteId();
                                if (TextUtils.isEmpty(objNote1.getOperation())) {
                                    values = new ContentValues();
                                    values.put("id", idA1);
                                    values.put("sync_status", 1);
                                    values.put("workorder_note_id", workorder_note_id);
                                    String whereClauseAttachment1 = "uuid ='" + uuid1 + "'";
                                    icarusDatabaseManager.executeUpdateQuery(IcarusDatabaseHelper.TABLE_WORKORDER_NOTE_DETAILS, values, whereClauseAttachment1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
