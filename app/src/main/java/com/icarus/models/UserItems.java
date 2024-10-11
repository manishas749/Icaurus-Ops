package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

public class UserItems {

    // id: Int, val uuid: String?, val fullName: String?, val groupId: Int

    @ColumnInfo(name = "full_name")
    private String fullName;

    @PrimaryKey
    private Integer id;

    @ColumnInfo(name = "group_id")
    private  Integer groupId;
    private String uuid;

    @ColumnInfo(name = "assigned_checklist_uuid")
    public String assignedChecklistUuid;

    @Ignore
    private boolean isSelected;

    public String role;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserItems getItem(String fullName, Integer id, Integer groupId, String uuid,
                             String assignedChecklistUuid, boolean isSelected, String role) {
        UserItems userItems = new UserItems();
        userItems.setFullName(fullName);
        userItems.setId(id);
        userItems.setGroupId(groupId);
        userItems.setUuid(uuid);
        userItems.setAssignedChecklistUuid(assignedChecklistUuid);
        userItems.setSelected(isSelected);
        userItems.setRole(role);
        return userItems;
    }

    public UserItems getItem(String fullName, int id){
        UserItems userItems = new UserItems();
        userItems.setId(id);
        userItems.setFullName(fullName);
        return userItems;
    }

}
