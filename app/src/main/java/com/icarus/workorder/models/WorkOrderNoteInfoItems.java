package com.icarus.workorder.models;

import com.icarus.base.BaseApplication;
import com.icarus.util.AppUtility;
import com.icarus.workorder.adapters.WorkOrderAttachmentAdapter;
import com.icarus.workorder.viewmodels.WorkOrderDetailViewModel;

import androidx.lifecycle.ViewModel;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anurag Purwar on 31/1/19.
 */
public class WorkOrderNoteInfoItems{
    @ColumnInfo(name = "workorder_notes")
    private String workorderNotes;

    @ColumnInfo(name = "created")
    private String created;

    @ColumnInfo(name = "user_id")
    private Integer userId;

    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @Ignore
    private List<WorkOrderAttachmentItems> attachments = new ArrayList<>();
    @Ignore
    private List<WorkOrderNoteDetailItems> noteDetail = new ArrayList<>();

    public String getWorkorderNotes() {
        return workorderNotes;
    }

    public void setWorkorderNotes(String workorderNotes) {
        this.workorderNotes = workorderNotes;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = AppUtility.Companion.parseDateToddMMyyyy(created);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkOrderAttachmentItems> getAttachments() {
        return attachments == null ? new ArrayList<WorkOrderAttachmentItems>() : attachments;
    }

    public void setAttachments(List<WorkOrderAttachmentItems> attachments) {
        this.attachments = attachments;
    }

    public List<WorkOrderNoteDetailItems> getNoteDetail() {
        return noteDetail;
    }

    public void setNoteDetail(List<WorkOrderNoteDetailItems> noteDetail) {
        this.noteDetail = noteDetail;
    }


    @BindingAdapter({"app:bindRecyclerView", "app:viewModel"})
    public static void setRecyclerView(RecyclerView recyclerView, List<WorkOrderAttachmentItems> attachmentItems, WorkOrderDetailViewModel viewModel) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        WorkOrderAttachmentAdapter adapter = new WorkOrderAttachmentAdapter(viewModel);
        recyclerView.setAdapter(adapter);
        adapter.setItem(attachmentItems);
    }

    @BindingAdapter("app:bindContent")
    public static void setContent(TextView textView, WorkOrderNoteInfoItems item) {
        String dueDate = "";
        String workorderStatusId = "";
        String assignedToId = "";
        String title = "";
        String workorderPriorityId = "";
        String locationRoomId = "";
        String locationEquipmentId = "";
        String workorderBillingTypeId = "";
        String workorderNotesDetail = "";
        for (WorkOrderNoteDetailItems note : item.getNoteDetail()) {
            if (note.getWorkorderNoteId().equals(item.getId())) {
                if (note.getProperty().equals("workorder")) {
                    if (note.getPropertyKey().equals("due_date")) {
                        if (TextUtils.isEmpty(note.getOldValue())) {
                            dueDate = "<b>Due Date</b> set to <i>" + AppUtility.Companion.parseDateToddMMyyyy(note.getValue()) + "</i>";
                        } else {
                            dueDate = "<b>Due Date</b> changed from <i>" + AppUtility.Companion.parseDateToddMMyyyy(note.getOldValue()) + "</i> to <i>" +
                                    AppUtility.Companion.parseDateToddMMyyyy(note.getValue()) + "</i>";
                        }
                    } else if (note.getPropertyKey().equals("workorder_status_id")) {
                        if (TextUtils.isEmpty(note.getOldValue())) {
                            workorderStatusId = "<b>Status</b> set to <i>" + note.getValue() + "</i>";
                        } else {
                            workorderStatusId = "<b>Status</b> changed from <i>" + note.getOldValue() + "</i> to <i>" + note.getValue() + "</i>";
                        }
                    } else if (note.getPropertyKey().equals("assigned_to_id")) {
                        if (TextUtils.isEmpty(note.getOldValue())) {
                            assignedToId = "<b>Assignee</b> set to <i>" + note.getValue() + "</i>";
                        } else {
                            assignedToId = "<b>Assignee</b> changed from <i>" + note.getOldValue() + "</i> to <i>" + note.getValue() + "</i>";
                        }
                    } else if (note.getPropertyKey().equals("workorder_priority_id")) {
                        if (TextUtils.isEmpty(note.getOldValue())) {
                            workorderPriorityId = "<b>Priority</b> set to <i>" + note.getValue();
                        } else {
                            workorderPriorityId = "<b>Priority</b> changed from <i>" + note.getOldValue() + " to <i>" + note.getValue() + "</i>";
                        }
                    } else if (note.getPropertyKey().equals("location_room_id")) {
                        if (TextUtils.isEmpty(note.getOldValue())) {
                            locationRoomId = "<b>" + BaseApplication.getPreferenceManager().getRoomName() + "</b> set to <i>" + note.getValue();
                        } else {
                            locationRoomId = "<b>" + BaseApplication.getPreferenceManager().getRoomName() + "</b> changed from <i>" + note.getOldValue() + "</i> to <i>" + note.getValue() + "</i>";
                        }
                    } else if (note.getPropertyKey().equals("location_equipment_id")) {
                        if (TextUtils.isEmpty(note.getOldValue())) {
                            locationEquipmentId = "<b>" + BaseApplication.getPreferenceManager().getAssetName() + "</b> set to <i>" + note.getValue() + "</i>";
                        } else {
                            locationEquipmentId =
                                    "<b>" + BaseApplication.getPreferenceManager().getAssetName() + "</b> changed from <i>" + note.getOldValue() + "</i> to <i>" + note.getValue() + "</i>";
                        }
                    } else if (note.getPropertyKey().equals("workorder_billing_type_id")) {
                        if (TextUtils.isEmpty(note.getOldValue())) {
                            workorderBillingTypeId = "<b>Billing</b> set to <i>" + note.getValue() + "</i>";
                        } else {
                            workorderBillingTypeId =
                                    "<b>Billing</b> changed from <i>" + note.getOldValue() + "</i> to <i>" + note.getValue() + "</i>";
                        }
                    } else if (note.getPropertyKey().equals("title")) {
                        if (TextUtils.isEmpty(note.getOldValue())) {
                            title = "<b>Title</b> set to <i>" + note.getValue() + "</i>";
                        } else {
                            title = "<b>Title</b> changed from <i>" + note.getOldValue() + "</i> to <i>" + note.getValue() + "</i>";
                        }
                    }
                }
            }
        }

        if (!TextUtils.isEmpty(title)) {
            workorderNotesDetail += title + "<br>";
        }
        if (!TextUtils.isEmpty(dueDate)) {
            workorderNotesDetail += dueDate + "<br>";
        }
        if (!TextUtils.isEmpty(workorderStatusId)) {
            workorderNotesDetail += workorderStatusId + "<br>";
        }
        if (!TextUtils.isEmpty(assignedToId)) {
            workorderNotesDetail += assignedToId + "<br>";
        }
        if (!TextUtils.isEmpty(workorderPriorityId)) {
            workorderNotesDetail += workorderPriorityId + "<br>";
        }
        if (!TextUtils.isEmpty(locationRoomId)) {
            workorderNotesDetail += locationRoomId + "<br>";
        }
        if (!TextUtils.isEmpty(locationEquipmentId)) {
            workorderNotesDetail += locationEquipmentId + "<br>";
        }
        if (!TextUtils.isEmpty(workorderBillingTypeId)) {
            workorderNotesDetail += workorderBillingTypeId + "<br>";
        }

        if (TextUtils.isEmpty(workorderNotesDetail)) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(Html.fromHtml(workorderNotesDetail));
        }
    }
}
