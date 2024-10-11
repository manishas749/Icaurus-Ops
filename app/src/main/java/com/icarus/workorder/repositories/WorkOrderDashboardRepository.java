package com.icarus.workorder.repositories;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.constants.SortingTag;
import com.icarus.models.SortChecklistBy;
import com.icarus.models.StringCheckBox;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Anurag Purwar on 17/1/19.
 */

public class WorkOrderDashboardRepository {
    private Context mContext;

    public WorkOrderDashboardRepository(Context context) {
        mContext = context;
    }

    public ArrayList<SortChecklistBy> getSortList() {
        ArrayList<SortChecklistBy> sorts = new ArrayList<>();
        SortChecklistBy sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.due_date_desc), SortingTag.DUE_DATE_DESC);
        sorts.add(sortChecklistBy);
        sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.due_date_asc), SortingTag.DUE_DATE_ASC);
        sorts.add(sortChecklistBy);
        sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_a_to_z), SortingTag.NAME_ASC);
        sorts.add(sortChecklistBy);
        sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_z_to_a), SortingTag.NAME_DESC);
        sorts.add(sortChecklistBy);
        sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.workorder_id_ascending), SortingTag.ID_ASC);
        sorts.add(sortChecklistBy);
        sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.workorder_id_descending), SortingTag.ID_DESC);
        sorts.add(sortChecklistBy);
        return sorts;
    }

    public ArrayList<StringCheckBox> getTypeFilterList() {
        ArrayList<StringCheckBox> typeFilterList = new ArrayList<>();
        int id = R.array.type_workorder;
        int workOrderId = R.array.type_workorder_id;
        String[] typeArray = mContext.getResources().getStringArray(id);
        String[] typeArrayId = mContext.getResources().getStringArray(workOrderId);
        for (int i = 0; i < typeArray.length; i++) {
            StringCheckBox stringCheckBox = new StringCheckBox();
            stringCheckBox.setId(i);
            stringCheckBox.setTitle(typeArray[i]);
            //stringCheckBox.setSelected(i == 0);
            stringCheckBox.setPosition(i);
            stringCheckBox.setShortName(typeArrayId[i]);
            typeFilterList.add(stringCheckBox);
        }
        return typeFilterList;
    }

    public ArrayList<StringCheckBox> getPriorityFilterList() {
        ArrayList<StringCheckBox> priorityFilterList = new ArrayList<>();
        String[] typeArray = mContext.getResources().getStringArray(R.array.priority);
        int[] typeArrayId = mContext.getResources().getIntArray(R.array.priority_id);
        for (int i = 0; i < typeArray.length; i++) {
            StringCheckBox stringCheckBox = new StringCheckBox();
            stringCheckBox.setId(i);
            stringCheckBox.setTitle(typeArray[i]);
            //stringCheckBox.setSelected(i == 0);
            stringCheckBox.setPosition(typeArrayId[i]);
            priorityFilterList.add(stringCheckBox);
        }
        return priorityFilterList;
    }

    public ArrayList<StringCheckBox> getAuthorFilterList() {
        ArrayList<StringCheckBox> priorityFilterList = new ArrayList<>();
        String[] typeArray = mContext.getResources().getStringArray(R.array.author);
        for (int i = 0; i < typeArray.length; i++) {
            StringCheckBox stringCheckBox = new StringCheckBox();
            stringCheckBox.setId(i);
            stringCheckBox.setTitle(typeArray[i]);
            //stringCheckBox.setSelected(i == 0);
            stringCheckBox.setPosition(i);
            priorityFilterList.add(stringCheckBox);
        }
        return priorityFilterList;
    }


    public ArrayList<StringCheckBox> getAssignedToFilterList() {
        ArrayList<StringCheckBox> assignedToFilterList = new ArrayList<>();
        String[] typeArray;
        if(BaseApplication.getPreferenceManager().getUserGroupId() == Constants.USER_ROLE_USER_ID) {
            typeArray = mContext.getResources().getStringArray(R.array.assigned_to_workorder_user);
        } else {
            typeArray = mContext.getResources().getStringArray(R.array.assigned_to_workorder);
        }
        for (int i = 0; i < typeArray.length; i++) {
            StringCheckBox stringCheckBox = new StringCheckBox();
            stringCheckBox.setId(i);
            stringCheckBox.setTitle(typeArray[i]);
            //stringCheckBox.setSelected(i == 0);
            stringCheckBox.setPosition(i);
            assignedToFilterList.add(stringCheckBox);
        }
        return assignedToFilterList;
    }
}
