package com.icarus.repositories;

import android.app.Application;

import com.icarus.dao.LogsDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.LogsEntity;

import java.util.List;

public class ChecklistReportRepository {

    Application application;

    public ChecklistReportRepository(Application application){
        this.application = application;
    }


    public List<LogsEntity> getReportByChecklist(String assignedChecklistUuid){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        LogsDao logsDao = appDatabase.getLogsDao();
        return logsDao.getReport(assignedChecklistUuid);
    }

}
