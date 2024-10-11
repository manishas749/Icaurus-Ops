package com.icarus.workorder.viewmodels;

import android.app.Application;
import android.text.TextUtils;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.icarus.R;
import com.icarus.base.BaseViewModel;
import com.icarus.entities.LocationEntity;
import com.icarus.models.AttachmentItems;
import com.icarus.util.FileUtils;
import com.icarus.widget.viewmodel.GalleryViewModel;
import com.icarus.workorder.models.RoomItems;
import com.icarus.workorder.navigators.WorkOrderCreateNavigator;
import com.icarus.workorder.repositories.WorkOrderCreateRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anurag Purwar on 22/1/18.
 */
public class WorkOrderCreateViewModel extends BaseViewModel<WorkOrderCreateNavigator> {
    private final WorkOrderCreateRepository workOrderCreateRepository;
    private MutableLiveData<List<RoomItems>> roomLiveData = new MutableLiveData<>();
    private MutableLiveData<List<RoomItems>> assetLiveData = new MutableLiveData<>();
    private MutableLiveData<List<LocationEntity>> locationLiveData = new MutableLiveData<>();

    public ArrayList<LocationEntity> locationList = new ArrayList<>();
    public ArrayList<RoomItems> roomList = new ArrayList<>();
    public ArrayList<RoomItems> assetList = new ArrayList<>();
    private int locationId;
    private String checklistTitle = "";
    private Integer checklistId;
    private ArrayAdapter<String> roomListAdapter;
    private ArrayAdapter<String> assetListAdapter;
    private GalleryViewModel galleryViewModel;
    private Integer roomId, assetId;

    public int getLocationId() {
        return locationId;
    }

    public WorkOrderCreateViewModel(@NonNull Application application) {
        super(application);
        File fileDestinationFolder = FileUtils.getWorkOrderAttachmentsDir();
        galleryViewModel = new GalleryViewModel(getApplication(), fileDestinationFolder);
        workOrderCreateRepository = new WorkOrderCreateRepository(getApplication());
    }

    /**
     * Fetches location list from database
     */
    public void getLocationList() {
        locationLiveData = workOrderCreateRepository.getLocations();
        getNavigator().onStartLocationObserving();
    }

    public ArrayAdapter<String> getLocationListInAdapter(List<LocationEntity> locations) {
        ArrayList<String> locationStringList = new ArrayList<>();
        locationList = new ArrayList<>(locations);
        for (LocationEntity locationItems : locations) {
            locationStringList.add(locationItems.getName());
        }
        return new ArrayAdapter<>(this.getApplication(), R.layout.view_simple_spinner_item, locationStringList);
    }

    public LiveData<List<LocationEntity>> observeLocationResponse() {
        return locationLiveData;
    }

    /**
     * Fetches room list from database
     */
    public void getRoomList(int locationId) {
        this.locationId = locationId;
        roomLiveData = workOrderCreateRepository.getRooms(locationId);
        getNavigator().onStartRoomObserving();
    }

    public ArrayAdapter<String> getRoomListInAdapter(List<RoomItems> roomItems) {
        ArrayList<String> roomStringList = new ArrayList<>();
        roomList = new ArrayList<>(roomItems);
        if (roomItems.size() > 1) {
            roomStringList.add("");
        }
        for (RoomItems roomItem : roomItems) {
            roomStringList.add(roomItem.getName());
        }
        roomListAdapter = new ArrayAdapter<>(this.getApplication(), R.layout.view_simple_spinner_item, roomStringList);
        return roomListAdapter;
    }

    public LiveData<List<RoomItems>> observeRoomResponse() {
        return roomLiveData;
    }

    /**
     * Fetches room list from database
     */
    public void getAssetList(int locationId, int roomId) {
        assetLiveData = workOrderCreateRepository.getAssets(locationId, roomId);
        getNavigator().onStartAssetsObserving();
    }

    public ArrayAdapter<String> getAssetListInAdapter(List<RoomItems> roomItems) {
        ArrayList<String> roomStringList = new ArrayList<>();
        assetList = new ArrayList<>(roomItems);
        if (roomItems.size() > 1) {
            roomStringList.add("");
        }

        for (RoomItems roomItem : roomItems) {
            roomStringList.add(roomItem.getName());
        }
        assetListAdapter = new ArrayAdapter<>(this.getApplication(), R.layout.view_simple_spinner_item, roomStringList);
        return assetListAdapter;
    }

    public LiveData<List<RoomItems>> observeAssetResponse() {
        return assetLiveData;
    }

    public String getChecklistTitle() {
        return checklistTitle;
    }

    public void setChecklistTitle(String checklistTitle) {
        this.checklistTitle = checklistTitle;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void onCancelClick() {
        getNavigator().onCancelClick();
    }

    public void onCreateClick() {
        getNavigator().onSaveWorkOrder();
    }

    public void saveWorkOrder(String title, String description, int locationPosition, int roomPosition, int assetPosition, ObservableList<AttachmentItems> listAttachment) {
        boolean isValidated = true;
        if (TextUtils.isEmpty(title)) {
            getNavigator().onTitleError(R.string.error_field_required);
            return;
        } else if (title.length() < 3) {
            getNavigator().onTitleError(R.string.limit_error);
            return;
        }

        LocationEntity location = locationList.get(locationPosition);
        RoomItems room = null;
        RoomItems asset = null;


        if (roomListAdapter != null && roomList.size() == roomListAdapter.getCount()) {
            room = roomList.get(roomPosition);
        } else if (roomPosition > 0) {
            room = roomList.get(roomPosition - 1);
        } else {
            getNavigator().onRoomError(R.string.error_field_room);
            return;
        }

        if (assetListAdapter != null && assetList.size() == assetListAdapter.getCount()) {
            asset = assetList.get(assetPosition);
        } else if (assetPosition > 0) {
            asset = assetList.get(assetPosition - 1);
        } else {
            getNavigator().onAssetError(R.string.error_field_asset);
            return;
        }

        if (TextUtils.isEmpty(description)) {
            getNavigator().onDescriptionError(R.string.error_field_required);
            return;
        }


        workOrderCreateRepository.createWorkOrder(title, location.getId(), room.getId(), asset.getId(), description, checklistId == 0 ? null : checklistId, listAttachment);
        getNavigator().onSuccessfullySaveWorkOrder();
    }

    public GalleryViewModel getGalleryViewModel() {
        return galleryViewModel;
    }

    public void setValues(Integer checklistId, Integer roomId, Integer assetId) {
        this.checklistId = checklistId;
        this.roomId = roomId;
        this.assetId = assetId;
    }
}