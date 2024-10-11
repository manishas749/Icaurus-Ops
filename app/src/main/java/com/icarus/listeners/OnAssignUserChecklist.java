package com.icarus.listeners;

import com.icarus.models.UserItems;

import java.util.List;

public interface OnAssignUserChecklist {

    void assignUserChecklist(List<UserItems> userItemsList);

    void cancelAssign();
}
