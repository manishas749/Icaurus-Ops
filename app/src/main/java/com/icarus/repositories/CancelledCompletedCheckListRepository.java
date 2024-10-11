package com.icarus.repositories;

import com.icarus.base.BaseApplication;
import com.icarus.constants.SortingTag;
import com.icarus.dao.CancelledCompletedDao;
import com.icarus.database.AppDatabase;
import com.icarus.models.CancelledCompletedChecklistItems;
import com.icarus.models.StringCheckBox;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import android.text.TextUtils;

import java.util.ArrayList;


public class CancelledCompletedCheckListRepository {

    private Application application;

    public CancelledCompletedCheckListRepository(Application application) {
        this.application = application;
    }

    /**
     * @param sortBy
     * @param typeBy
     * @param users
     * @return
     */
    public LiveData<PagedList<CancelledCompletedChecklistItems>> getCancelledCompletedChecklist(PagedList.Config config, String sortBy, ArrayList<StringCheckBox> typeBy,
                                                                                                ArrayList<StringCheckBox> users, Integer checklistStatus, String keyword) {
        keyword = "%" + keyword + "%";
        String type = "";
        if (typeBy != null && typeBy.size() > 0) {
            for (int i = 0; i < typeBy.size(); i++) {
                StringCheckBox item = typeBy.get(i);
                if (item.getId() != 0 && item.isSelected()) {
                    if (!TextUtils.isEmpty(type)) {
                        type += ",";
                    }
                    type += String.valueOf(item.getId());
                }
            }

        }

        String mUsers = "";
        if (users != null && users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                StringCheckBox item = users.get(i);
                if (item.getId() != 0 && item.isSelected()) {
                    if (!TextUtils.isEmpty(mUsers)) {
                        mUsers += ",";
                    }
                    mUsers += item.getId();
                }
            }

        }

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        CancelledCompletedDao allCheckListDao = appDatabase.cancelledCompletedDao();
        DataSource.Factory<Integer, CancelledCompletedChecklistItems> factory;


        if (BaseApplication.getPreferenceManager().getIsAdmin()) {
            if (sortBy.equals(SortingTag.MODIFIED_DESC)) {
                if (type.length() > 0 && mUsers.length() > 0)
                    factory = allCheckListDao.getCheckListSortByDueDateDescAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, type.split(","), mUsers.split(","), keyword);
                else if (type.length() > 0)
                    factory = allCheckListDao.getCheckListTypeDueDecAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, type.split(","), keyword);
                else if (mUsers.length() > 0)
                    factory = allCheckListDao.getCheckListDueDecAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, mUsers.split(","), keyword);
                else
                    factory = allCheckListDao.getCheckListDueDateDecAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, keyword);

            } else {
                if (type.length() > 0 && mUsers.length() > 0)
                    factory = allCheckListDao.getCheckListSortByDueDateAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, type.split(","), mUsers.split(","), keyword);
                else if (type.length() > 0)
                    factory = allCheckListDao.getCheckListTypeDueAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, type.split(","), keyword);
                else if (mUsers.length() > 0)
                    factory = allCheckListDao.getCheckListDueAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, mUsers.split(","), keyword);
                else
                    factory = allCheckListDao.getCheckListDueDateAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, keyword);

            }
        } else {
            if (sortBy.equals(SortingTag.MODIFIED_DESC)) {
                if (type.length() > 0 && mUsers.length() > 0)
                    factory = allCheckListDao.getCheckListSortByDueDateDesc(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, type.split(","), mUsers.split(","), keyword);
                else if (type.length() > 0)
                    factory = allCheckListDao.getCheckListTypeDueDec(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, type.split(","), keyword);
                else if (mUsers.length() > 0)
                    factory = allCheckListDao.getCheckListDueDec(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, mUsers.split(","), keyword);
                else
                    factory = allCheckListDao.getCheckListDueDateDec(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, keyword);

            } else {
                if (type.length() > 0 && mUsers.length() > 0)
                    factory = allCheckListDao.getCheckListSortByDueDate(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, type.split(","), mUsers.split(","), keyword);
                else if (type.length() > 0)
                    factory = allCheckListDao.getCheckListTypeDue(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, type.split(","), keyword);
                else if (mUsers.length() > 0)
                    factory = allCheckListDao.getCheckListDue(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, mUsers.split(","), keyword);
                else
                    factory = allCheckListDao.getCheckListDueDate(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), checklistStatus, 1, keyword);

            }
        }

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }
}
