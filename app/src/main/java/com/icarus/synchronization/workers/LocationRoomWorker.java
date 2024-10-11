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
import com.icarus.entities.LocationRoomEntity;
import com.icarus.enums.ClientSettings;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.LocationsApi;
import com.icarus.synchronization.syncmodels.RetrieveLocationRooms;
import com.icarus.util.AppUtility;

import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class LocationRoomWorker extends CommonWorker {

    private final Context mContext;
    //-- Initialize Database
    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
    final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

    public LocationRoomWorker(Context context, WorkerParameters params) {
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

    private void hitApi(int pageNo, int locationId) {

        RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                .create(LocationsApi.class)
                .locationRoomsIndex(
                        Constants.HEADER_ACCEPT,
                        Parameters.PAGE_SIZE,
                        pageNo,
                        BaseApplication.getPreferenceManager().getLastActivityAfter(),
                        BaseApplication.getPreferenceManager().getLastActivityBefore(),
                        BaseApplication.getPreferenceManager().getRevisionNumber(),
                        locationId
                )
                .subscribe(new AbstractNetworkObservable<RetrieveLocationRooms>() {
                    @Override
                    public void success(RetrieveLocationRooms retrievedLocations) {
                        try {
                            if (retrievedLocations == null) {
                                return;
                            }

                            List<RetrieveLocationRooms.Datum> locationRoomsList = retrievedLocations.getData();

                            if (locationRoomsList == null) {
                                return;
                            }

                            for (int i = 0; i < locationRoomsList.size(); i++) {
                                mapLocationRoomEntity(locationRoomsList.get(i), getSynchronizationDao);
                            }
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


    private void mapLocationRoomEntity(RetrieveLocationRooms.Datum locationRoom, GetSynchronizationDao getSynchronizationDao) {

        getSynchronizationDao.insertRoomEntity(ModelMapper.mapRoomsEntity(locationRoom.getRoom()));
        // Check if locationRoom.id exists in the database
        LocationRoomEntity localLocationRoom = getSynchronizationDao.ifLocationRoomExists(locationRoom.getId());

        // If record doesn't exist, insert the record
        if (localLocationRoom == null) {
            getSynchronizationDao.insertLocationRooms(ModelMapper.mapLocationRoomEntity(locationRoom));
        } else {
            // As record exists, we check if the modified of record received is greater than the local record.
            // In case it is we would update the record.

            if (AppUtility.Companion.compairTwoDates(locationRoom.getUpdatedAt(), localLocationRoom.getModified())) {
                // Update the record
                getSynchronizationDao.insertLocationRooms(ModelMapper.mapLocationRoomEntity(locationRoom));
            }
        }

        // If a QR code for the room exists, we need to update the corresponding entry in the database.
        if (locationRoom.getQrStorage() != null) {
            // Create the QR code record in the qr_storage table
            getSynchronizationDao.insertQRStorage(ModelMapper.mapQRStorage(locationRoom.getQrStorage(),
                    locationRoom.getId(),
                    ClientSettings.LocationRoom.toString()));
        }

    }
}
