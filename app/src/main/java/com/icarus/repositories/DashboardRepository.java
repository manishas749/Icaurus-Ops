package com.icarus.repositories;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.constants.ChecklistTag;
import com.icarus.constants.SortingTag;
import com.icarus.dao.ClientDao;
import com.icarus.dao.DashboardDao;
import com.icarus.database.AppDatabase;
import com.icarus.models.ChecklistItemPlaceHolders;
import com.icarus.models.ClientSettingItems;
import com.icarus.models.SortChecklistBy;
import com.icarus.models.StringCheckBox;

import androidx.lifecycle.MutableLiveData;
import android.content.Context;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monika Rana on 12/28/2018.
 */

public class DashboardRepository {
    private Context mContext;

    public DashboardRepository(Context context) {
        mContext = context;
    }

    public MutableLiveData<ArrayList<StringCheckBox>> getDepartmentList() {
        final MutableLiveData<ArrayList<StringCheckBox>> liveData = new MutableLiveData<>();
        // liveData = DataUtil.getDepartmentList(mContext);
        return liveData;
    }

    public void getClientSetting() {
        AppDatabase appDatabase = AppDatabase.getInstance(mContext);
        ClientDao clientDao = appDatabase.clientDao();
        List<ClientSettingItems> setting = clientDao.getClientSetting();
        for (ClientSettingItems item : setting) {
            if (item.getName().equalsIgnoreCase(mContext.getString(R.string.room))) {
                BaseApplication.getPreferenceManager().setRoomName(item.getValue());
            } else if (item.getName().equalsIgnoreCase(mContext.getString(R.string.asset))) {
                BaseApplication.getPreferenceManager().setAssetName(item.getValue());
            }
        }
    }

    public ArrayList<SortChecklistBy> getSortList(String selectedChecklist) {
        ArrayList<SortChecklistBy> sorts = new ArrayList<>();
        if (selectedChecklist.equals(ChecklistTag.ALL_CHECKLIST)) {
            SortChecklistBy sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.favorite_on_top), SortingTag.FAVORITE);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.modified_ascending), SortingTag.MODIFIED_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.modified_descending), SortingTag.MODIFIED_DESC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_a_to_z), SortingTag.NAME_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_z_to_a), SortingTag.NAME_DESC);
            sorts.add(sortChecklistBy);
        } else if (selectedChecklist.equals(ChecklistTag.MY_ASSIGNED_CHECKLIST)
                || selectedChecklist.equals(ChecklistTag.MY_DEPARTMENT_CHECKLIST)) {
            SortChecklistBy sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.due_date_asc), SortingTag.DUE_DATE_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.due_date_desc), SortingTag.DUE_DATE_DESC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.status_a_to_z), SortingTag.STATUS_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.status_z_to_a), SortingTag.STATUS_DESC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_a_to_z), SortingTag.NAME_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_z_to_a), SortingTag.NAME_DESC);
            sorts.add(sortChecklistBy);
        } else if (selectedChecklist.equals(ChecklistTag.CANCELLED_CHECKLIST)
                || selectedChecklist.equals(ChecklistTag.COMPLETED_CHECKLIST)) {
            SortChecklistBy sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.last_updated_desc), SortingTag.MODIFIED_DESC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.last_updated_asc), SortingTag.MODIFIED_ASC);
            sorts.add(sortChecklistBy);
        } else if (selectedChecklist.equalsIgnoreCase(ChecklistTag.WORK_ORDER)) {
            SortChecklistBy sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.due_date_asc), SortingTag.DUE_DATE_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.due_date_desc), SortingTag.DUE_DATE_DESC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_a_to_z), SortingTag.NAME_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_z_to_a), SortingTag.NAME_DESC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.workorder_id_ascending), SortingTag.ID_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.workorder_id_descending), SortingTag.ID_DESC);
            sorts.add(sortChecklistBy);
        } else {
            SortChecklistBy sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_a_to_z), SortingTag.NAME_ASC);
            sorts.add(sortChecklistBy);
            sortChecklistBy = new SortChecklistBy(mContext.getResources().getString(R.string.name_z_to_a), SortingTag.NAME_DESC);
            sorts.add(sortChecklistBy);
        }
        return sorts;
    }

    public ArrayList<StringCheckBox> getTypeFilterList(String selectedChecklist) {
        ArrayList<StringCheckBox> typeFilterList = new ArrayList<>();
        AppDatabase appDatabase = AppDatabase.getInstance(mContext);
        DashboardDao dashboardDao = appDatabase.getDashboardDao();
        StringCheckBox stringCheckBox = new StringCheckBox();
        stringCheckBox.setTitle("All");
        stringCheckBox.setId(0);
        stringCheckBox.setPosition(0);
        typeFilterList.add(stringCheckBox);
        if (!TextUtils.isEmpty(selectedChecklist) && selectedChecklist.equals(ChecklistTag.ALL_CHECKLIST))
            typeFilterList.addAll(dashboardDao.getAllChecklistTypesFilter());
        else if (!TextUtils.isEmpty(selectedChecklist) && selectedChecklist.equals(ChecklistTag.WORK_ORDER)) {
            String[] typeValueArray = mContext.getResources().getStringArray(R.array.type_workorder_id);
            String[] typeArray = mContext.getResources().getStringArray(R.array.type_workorder);
            typeFilterList = new ArrayList<>();
            for (int i = 0; i < typeArray.length; i++) {
                stringCheckBox = new StringCheckBox();
                stringCheckBox.setId(i);
                stringCheckBox.setTitle(typeArray[i]);
                stringCheckBox.setSelected(false);
                stringCheckBox.setShortName(typeValueArray[i]);
                stringCheckBox.setPosition(i);
                typeFilterList.add(stringCheckBox);
            }
        } else
            typeFilterList.addAll(dashboardDao.getChecklistTypes());

        return typeFilterList;
    }

    public ArrayList<StringCheckBox> getAssignedToFilterList() {
        ArrayList<StringCheckBox> assignedToFilterList = new ArrayList<>();
        String[] typeArray;
        typeArray = mContext.getResources().getStringArray(R.array.assigned_to_workorder);

        for (int i = 0; i < typeArray.length; i++) {
            StringCheckBox stringCheckBox = new StringCheckBox();
            stringCheckBox.setId(i);
            stringCheckBox.setTitle(typeArray[i]);
            stringCheckBox.setSelected(i == 0);
            stringCheckBox.setPosition(i);
            assignedToFilterList.add(stringCheckBox);
        }
        return assignedToFilterList;
    }

    public ArrayList<StringCheckBox> getPriorityFilterList() {
        ArrayList<StringCheckBox> priorityFilterList = new ArrayList<>();
        String[] typeArray = mContext.getResources().getStringArray(R.array.priority);
        int[] typeArrayId = mContext.getResources().getIntArray(R.array.priority_id);
        for (int i = 0; i < typeArray.length; i++) {
            StringCheckBox stringCheckBox = new StringCheckBox();
            stringCheckBox.setId(i);
            stringCheckBox.setTitle(typeArray[i]);
            stringCheckBox.setSelected(i == 0);
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
            stringCheckBox.setSelected(false);
            stringCheckBox.setPosition(i);
            priorityFilterList.add(stringCheckBox);
        }
        return priorityFilterList;
    }


    /**
     * This parameter checks the selected checklist and fetches the filter
     * accordingly
     *
     * @param selectedChecklist This parameter for selected filter
     * @return ArrayList of status filters
     */
    public ArrayList<StringCheckBox> getStatusFilterList(String selectedChecklist) {
        ArrayList<StringCheckBox> statusFilterList = new ArrayList<>();
        String[] typeArray;
        int[] typeArrayID;

        //For work order selected checklist fetch status filters from DB
        if (!TextUtils.isEmpty(selectedChecklist) && selectedChecklist.equals(ChecklistTag.WORK_ORDER)) {
            AppDatabase appDatabase = AppDatabase.getInstance(mContext);
            DashboardDao dashboardDao = appDatabase.getDashboardDao();
            StringCheckBox stringCheckBox = new StringCheckBox();
            stringCheckBox.setTitle("All");
            stringCheckBox.setId(-1);
            stringCheckBox.setPosition(0);
            statusFilterList.add(stringCheckBox);
            statusFilterList.addAll(dashboardDao.getStatusWorkOrder());
        } else {
            typeArray = mContext.getResources().getStringArray(R.array.status);
            typeArrayID = mContext.getResources().getIntArray(R.array.status_ids);
            for (int i = 0; i < typeArray.length; i++) {
                StringCheckBox stringCheckBox = new StringCheckBox();
                stringCheckBox.setId(typeArrayID[i]);
                stringCheckBox.setTitle(typeArray[i]);
                stringCheckBox.setSelected(false);
                stringCheckBox.setPosition(i);
                statusFilterList.add(stringCheckBox);
            }
        }
        return statusFilterList;
    }

    public List<ChecklistItemPlaceHolders> getItemPlaceholders(String checklistUUID) {
        AppDatabase appDatabase = AppDatabase.getInstance(mContext);
        DashboardDao dashboardDao = appDatabase.getDashboardDao();
        return dashboardDao.getItemPlaceHolders(checklistUUID);
    }

}
