package com.icarus.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import android.content.Context;

import com.icarus.base.BaseApplication;
import com.icarus.dao.AllCaptureDataDao;
import com.icarus.dao.AllCheckListDao;
import com.icarus.dao.CancelledCompletedDao;
import com.icarus.dao.CheckListDetailDao;
import com.icarus.dao.ChecklistExecutionDao;
import com.icarus.dao.ChecklistUndoDao;
import com.icarus.dao.ClientDao;
import com.icarus.dao.DashboardDao;
import com.icarus.dao.DepartmentChecklistDao;
import com.icarus.dao.GetChecklistElementDao;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.LocationDao;
import com.icarus.dao.LogsDao;
import com.icarus.dao.MyAssignmentDao;
import com.icarus.dao.NotesDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.dao.QRStepAttributeExecutionDao;
import com.icarus.dao.ReportDao;
import com.icarus.dao.UserDao;
import com.icarus.dao.UserSuggestionDao;
import com.icarus.entities.AllChecklistEntity;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedItemPlaceholderEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.AsssignedDepartmentsEntity;
import com.icarus.entities.CheckListLogoEntity;
import com.icarus.entities.CheckListPpesEntity;
import com.icarus.entities.CheckListTitlesEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.ChecklistExecutionPermission;
import com.icarus.entities.ChecklistLocationEntity;
import com.icarus.entities.ChecklistRoomEquipmentsEntity;
import com.icarus.entities.ChecklistStatusEntity;
import com.icarus.entities.ChecklistTypeEntity;
import com.icarus.entities.ClientLogoEntity;
import com.icarus.entities.ClientSettingEntity;
import com.icarus.entities.CustomFieldsEntity;
import com.icarus.entities.DepartmentsEntity;
import com.icarus.entities.EquipmentsEntity;
import com.icarus.entities.GroupEntity;
import com.icarus.entities.HazardsEntity;
import com.icarus.entities.ItemPlaceholdersEntity;
import com.icarus.entities.ItemTypeEntity;
import com.icarus.entities.LocationDepartmentsEntity;
import com.icarus.entities.LocationEntity;
import com.icarus.entities.LocationEquipmentsEntity;
import com.icarus.entities.LocationRoomEquipmentsEntity;
import com.icarus.entities.LocationRoomEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.NcwHazardsEntity;
import com.icarus.entities.PepesEntity;
import com.icarus.entities.PlaceholderEntity;
import com.icarus.entities.QRStorageEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.entities.ResourcesLinksEntity;
import com.icarus.entities.RoomsEntity;
import com.icarus.entities.StepAttributesEntity;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.entities.UserLocationsDepartments;
import com.icarus.entities.UserSuggestionAttachmentsEntity;
import com.icarus.entities.UserSuggestionEntity;
import com.icarus.entities.UsersEntity;
import com.icarus.entities.WorkOrdeStatusEntity;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderBillingTypeEntity;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;
import com.icarus.workorder.dao.CreateWorkOrderDao;
import com.icarus.workorder.dao.WorkOrderCommonDao;
import com.icarus.workorder.dao.WorkOrderDao;
import com.icarus.workorder.dao.WorkOrderDetailDao;

@Database(entities = {LocationEntity.class, AllChecklistEntity.class, CheckListTitlesEntity.class, ChecklistStatusEntity.class, ChecklistTypeEntity.class, ChecklistLocationEntity.class, UserLocationsDepartments.class, ChecklistExecutionPermission.class, UserFavouritesEntity.class, ItemPlaceholdersEntity.class, ChecklistElementsEntity.class, DepartmentsEntity.class, AssignCheckListEntity.class, AssignedUserEntity.class, UsersEntity.class, AssignRoomEquipmentsEntity.class, RoomsEntity.class, EquipmentsEntity.class, AsssignedDepartmentsEntity.class, LocationDepartmentsEntity.class, ChecklistRoomEquipmentsEntity.class, LogsEntity.class, AssignedCheckListPauseTimesEntity.class,
        WorkOrdeStatusEntity.class, AssignedNCWEntity.class, WorkOrderEntity.class, GroupEntity.class, ResourceEntity.class, StepAttributesEntity.class, CustomFieldsEntity.class, LocationRoomEquipmentsEntity.class, HazardsEntity.class, CheckListPpesEntity.class, PepesEntity.class, NcwHazardsEntity.class, AssignedDecisionEntity.class, AssignedLogoEntity.class, ClientLogoEntity.class, CheckListLogoEntity.class, ResourcesLinksEntity.class, AssignedStepAttributesEntity.class, AssignedStepFileResourceEntity.class, AssignedStepEntity.class, WorkOrderBillingTypeEntity.class, WorkOrderNotesEntity.class, WorkOrderAttachmentsEntity.class, WorkOrderNoteDetailEntity.class, ClientSettingEntity.class, UserSuggestionEntity.class, UserSuggestionAttachmentsEntity.class, ItemTypeEntity.class, AssignedChecklistCommentsEntity.class, AssignedItemPlaceholderEntity.class, PlaceholderEntity.class,
        QRStorageEntity.class, LocationRoomEntity.class, LocationEquipmentsEntity.class},
        version = 7, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabaseInstance;

    public abstract WorkOrderCommonDao workOrderCommonDao();

    public abstract WorkOrderDetailDao workOrderDetailDao();

    public abstract WorkOrderDao workOrderDao();

    public abstract CreateWorkOrderDao createWorkOrderDao();

    public abstract AllCheckListDao allCheckListDao();

    public abstract LocationDao locationDao();

    public abstract ClientDao clientDao();

    public abstract MyAssignmentDao myAssignmentDao();

    public abstract DepartmentChecklistDao departmentChecklistDao();

    public abstract CancelledCompletedDao cancelledCompletedDao();

    public abstract CheckListDetailDao checkListDetailDao();

    public abstract UserSuggestionDao userSuggestionDao();

    public abstract AllCaptureDataDao allCaptureDataDao();

    public abstract GetSynchronizationDao getSynchronizationDao();

    public abstract GetChecklistElementDao getChecklistElementDao();

    public abstract NotesDao notesDao();

    public abstract UserDao userDao();

    public abstract ReportDao reportDao();

    public abstract PostSynchronizationDao postSynchronizationDao();

    public abstract QRStepAttributeExecutionDao qrStepAttributeExecutionDao();

    public abstract DashboardDao getDashboardDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (appDatabaseInstance == null || !appDatabaseInstance.getOpenHelper().getDatabaseName().equalsIgnoreCase(BaseApplication.getPreferenceManager().getClientUuid())) {
            String DATABASE_NAME = BaseApplication.getPreferenceManager().getClientUuid();

            appDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .addMigrations(AppMigration.MIGRATION_FROM_1_2, AppMigration.MIGRATION_FROM_2_3,
                            AppMigration.MIGRATION_FROM_3_4, AppMigration.MIGRATION_FROM_4_5,
                            AppMigration.MIGRATION_FROM_5_6, AppMigration.MIGRATION_FROM_6_7)
                    .allowMainThreadQueries().build();

        }

        return appDatabaseInstance;
    }

    public abstract ChecklistExecutionDao checklistExtecutionDao();

    public abstract LogsDao getLogsDao();

    public abstract ChecklistUndoDao checklistUndoDao();


}
