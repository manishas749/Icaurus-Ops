package com.icarus.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.annotation.NonNull;

import com.icarus.base.BaseViewModel;
import com.icarus.models.ChecklistItemPlaceHolders;
import com.icarus.repositories.MyAssignedCheckListRepository;

import java.util.LinkedHashMap;
import java.util.List;

public class PlaceholderCaptureListViewModel extends BaseViewModel {
    private MyAssignedCheckListRepository myAssignedCheckListRepository;

    public PlaceholderCaptureListViewModel(@NonNull Application application) {
        super(application);

        myAssignedCheckListRepository = new MyAssignedCheckListRepository(application);
    }

    /**
     * This method converts placeholders list into hash map for getting sequence number as keys
     *
     * @return hash map with keys as sequence number
     */
    public LinkedHashMap<String, List<ChecklistItemPlaceHolders>> getItemPlaceHolders(String checklistUUID) {
        return myAssignedCheckListRepository.parsePlaceHolderList(myAssignedCheckListRepository.getItemPlaceholders(checklistUUID));
    }

}
