package com.icarus.repositories;

import android.app.Application;

import com.icarus.dao.ChecklistUndoDao;
import com.icarus.database.AppDatabase;
import com.icarus.util.AppUtility;

public class ChecklistUndoRepository {

    Application application;

    public ChecklistUndoRepository(Application application){
        this.application = application;
    }


    /**
     *
     *
     * @param checklistId
     */

    public void undoChecklistNCWSequential(Integer checklistId){

    }

    /***
     * @param checklistId ID of Checklist
     * @param itemUuid UUID of NCW
     * @param assignedChecklistUuid UUID of the assigned checklist
     * @param ncwDescription  NCW Description
     * @param elementId ID of the element being executed
     */
    public void undoChecklistNCWNonSequential(Integer checklistId, Integer elementId, String itemUuid, String assignedChecklistUuid, String ncwDescription){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistUndoDao checklistUndoDao = appDatabase.checklistUndoDao();
        checklistUndoDao.updateAssignedNCW(elementId,AppUtility.Companion.getUtcTime());

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(itemUuid,assignedChecklistUuid,checklistId,elementId,15,null,ncwDescription,"Undo",null);

    }


    /***
     * @param checklistId ID of Checklist
     * @param itemUuid UUID of step
     * @param assignedChecklistUuid UUID of the assigned checklist
     * @param ncwDescription  step Description
     * @param elementId ID of the element being executed
     */
    public void undoChecklistStepNonSequential(Integer checklistId, Integer elementId, String itemUuid, String assignedChecklistUuid, String ncwDescription){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistUndoDao checklistUndoDao = appDatabase.checklistUndoDao();
        checklistUndoDao.updateAssignedStep(elementId,AppUtility.Companion.getUtcTime());

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(itemUuid,assignedChecklistUuid,checklistId,elementId,15,null,ncwDescription,"Undo",null);

    }

    /***
     * @param checklistId ID of Checklist
     * @param itemUuid UUID of step
     * @param assignedChecklistUuid UUID of the assigned checklist
     * @param ncwDescription  step Description
     * @param elementId ID of the element being executed
     */
    public void undoChecklistStepAttributesNonSequential(Integer checklistId, Integer elementId, String itemUuid, String assignedChecklistUuid, String ncwDescription){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistUndoDao checklistUndoDao = appDatabase.checklistUndoDao();
        checklistUndoDao.updateAssignedStepAttribute(elementId,AppUtility.Companion.getUtcTime());

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(itemUuid,assignedChecklistUuid,checklistId,elementId,15,null,ncwDescription,"Undo",null);

    }

    /***
     * @param checklistId ID of Checklist
     * @param itemUuid UUID of step
     * @param assignedChecklistUuid UUID of the assigned checklist
     * @param ncwDescription  step Description
     * @param elementId ID of the element being executed
     */
    public void undoChecklistStepResourcesNonSequential(Integer checklistId, Integer elementId, String itemUuid, String assignedChecklistUuid, String ncwDescription){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistUndoDao checklistUndoDao = appDatabase.checklistUndoDao();
        checklistUndoDao.updateAssignedResources(elementId,AppUtility.Companion.getUtcTime());

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(itemUuid,assignedChecklistUuid,checklistId,elementId,15,null,ncwDescription,"Undo",null);

    }

    /***
     * @param checklistId ID of Checklist
     * @param itemUuid UUID of step
     * @param assignedChecklistUuid UUID of the assigned checklist
     * @param ncwDescription  step Description
     * @param elementId ID of the element being executed
     */
    public void undoChecklistDecisionsNonSequential(Integer checklistId, Integer elementId, String itemUuid, String assignedChecklistUuid, String ncwDescription){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistUndoDao checklistUndoDao = appDatabase.checklistUndoDao();
        checklistUndoDao.updateAssignedDecision(elementId,AppUtility.Companion.getUtcTime());

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(itemUuid,assignedChecklistUuid,checklistId,elementId,15,null,ncwDescription,"Undo",null);

    }


}
