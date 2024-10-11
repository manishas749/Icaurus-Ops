package com.icarus.synchronization.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.LocationRoomEquipmentsEntity;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.LocationsApi;
import com.icarus.synchronization.syncmodels.RetrieveLocationRoomEquipment;

import java.util.ArrayList;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class LocationRoomEquipmentWorker extends CommonWorker {

    private final Context mContext;
    //-- Initialize Database
    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
    final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

    public LocationRoomEquipmentWorker(Context context, WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        int pageCount = getInputData().getInt(Parameters.PAGE_COUNT, 0);
        int locationId = BaseApplication.getPreferenceManager().getUserLocationId();

        for (int i = 0; i < pageCount; i++) {
            hitApi(i + 1, locationId);
        }

        return Result.success();
    }

    private void hitApi(int pageNo, Integer locationId) {

        RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                .create(LocationsApi.class)
                .locationRoomEquipmentsIndex(
                        Constants.HEADER_ACCEPT,
                        Parameters.PAGE_SIZE,
                        pageNo,
                        BaseApplication.getPreferenceManager().getLastActivityAfter(),
                        BaseApplication.getPreferenceManager().getLastActivityBefore(),
                        BaseApplication.getPreferenceManager().getRevisionNumber(),
                        locationId
                )
                .subscribe(new AbstractNetworkObservable<RetrieveLocationRoomEquipment>() {
                    @Override
                    public void success(RetrieveLocationRoomEquipment retrievedLocations) {
                        try {
                            if (retrievedLocations == null) {
                                return;
                            }

                            List<RetrieveLocationRoomEquipment.Datum> locationEquipmentList = retrievedLocations.getData();

                            if (locationEquipmentList == null) {
                                return;
                            }

                            List<LocationRoomEquipmentsEntity> locationRoomEquipmentsEntities =
                                    new ArrayList<>(mapLocationRoomEquipments(locationEquipmentList));

                            getSynchronizationDao.insertLocationRoomEquipments(locationRoomEquipmentsEntities);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
                        }

                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.d(Parameters.TAG, error.getMessage());
                        WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
                    }
                });
    }

    private List<LocationRoomEquipmentsEntity> mapLocationRoomEquipments(
            List<RetrieveLocationRoomEquipment.Datum> locationRoomEquipments
    ) {
        List<LocationRoomEquipmentsEntity> locationRoomEquipmentsEntities = new ArrayList<>();

        if (locationRoomEquipments == null) {
            return locationRoomEquipmentsEntities;
        }

        for (RetrieveLocationRoomEquipment.Datum locationRoomEquipment : locationRoomEquipments) {
            LocationRoomEquipmentsEntity locationRoomEquipmentEntity = ModelMapper.mapLocationRoomEquipmentsEntity(locationRoomEquipment);
            locationRoomEquipmentsEntities.add(locationRoomEquipmentEntity);
        }

        return locationRoomEquipmentsEntities;
    }
}
