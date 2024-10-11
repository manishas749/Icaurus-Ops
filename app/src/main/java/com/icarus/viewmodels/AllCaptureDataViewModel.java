package com.icarus.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.icarus.R;
import com.icarus.adapters.AllCaptureDataElementsAdapter;
import com.icarus.base.BaseViewModel;
import com.icarus.constants.Constants;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.models.ElementAttributesItems;
import com.icarus.models.ElementWithCaptureDataItems;
import com.icarus.navigators.AllCaptureDataNavigator;
import com.icarus.repositories.AllCaptureDataRepository;
import com.icarus.util.FileUtils;

import java.io.File;

/**
 * Created by Monika Rana on 04/10/2019
 */
public class AllCaptureDataViewModel extends BaseViewModel<AllCaptureDataNavigator> {
    private AllCaptureDataRepository allCaptureDataRepository;
    private String checklistUUID;
    private final static PagedList.Config config
            = new PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(Constants.PAGE_INITIAL_LOAD_SIZE_HINT)
            .setPrefetchDistance(Constants.PAGE_PREFETCH_DISTANCE)
            .setEnablePlaceholders(true)
            .build();

    private AllCaptureDataElementsAdapter allCaptureDataElementsAdapter;

    public AllCaptureDataViewModel(@NonNull Application application) {
        super(application);
        allCaptureDataRepository = new AllCaptureDataRepository(getApplication());
    }

    public LiveData<PagedList<ElementWithCaptureDataItems>> getElementListLiveData(String assignedChecklistUUID, Integer checklistID) {
        checklistUUID = assignedChecklistUUID;
        setIsLoading(true);
        return allCaptureDataRepository.getElementsWithCaptureData(assignedChecklistUUID, checklistID, config);
    }

    /**
     * Sets elements with attributes on list
     *
     * @return adapter for setting in recycler view for showing elements
     */
    public AllCaptureDataElementsAdapter getElementListAdapter() {
        if (allCaptureDataElementsAdapter == null)
            allCaptureDataElementsAdapter = new AllCaptureDataElementsAdapter(this, getApplication().getApplicationContext());
        return allCaptureDataElementsAdapter;
    }

    /**
     * This method is called for getting attributes list for each element from database
     *
     * @param assignedChecklistUUID The UUID for selected checklist
     * @param elementId             The element
     * @param position              Required for updating the attribute list for elements
     */
    public void getElementsAttributeList(String assignedChecklistUUID, int elementId, int position) {
        getNavigator().observeElementAttribute(allCaptureDataRepository.getElementAttributes(assignedChecklistUUID, elementId), position);
    }

    public String getChecklistUUID() {
        return checklistUUID;
    }

    /**
     * This method opens the clicked captured file
     *
     * @param item This param contains the captured file item info
     */
    public void onImageClick(final ElementAttributesItems item) {
        try {
            File directory = FileUtils.getResourcesAttachmentsDir();
            if (directory == null) {
                getNavigator().showMessage(getApplication().getString(R.string.file_path_error));
                return;
            }

            final File fileDestinationFolder = new File(directory, item.getFileName());
            if (!fileDestinationFolder.exists()) {
                getNavigator().popUpAskDownload(item.getFileName(), item.getCapturedUUID());
            } else
                getNavigator().openClickedFile(item.getFileName());
        } catch (Exception ex) {
            ex.printStackTrace();
            getNavigator().showMessage(getApplication().getString(R.string.file_path_error));
        }
    }

    /**
     * This method download the captured file
     *
     * @param fileName The name of the file to be downloaded
     * @param itemUUID The item UUID required for downloading file
     */
    public void downloadCapturedFiles(final String fileName, String itemUUID) {
        setIsLoading(true);
        allCaptureDataRepository.downloadAttachedTemplateFile(fileName, itemUUID, new OnDownloadListener() {
            @Override
            public void onSuccess() {
                setIsLoading(false);
                getNavigator().openClickedFile(fileName);
            }

            @Override
            public void onFailed() {
                setIsLoading(false);
                getNavigator().showMessage(getApplication().getString(R.string.error_downloading_file));
            }

            @Override
            public void noInternetAvailable() {
                setIsLoading(false);
                getNavigator().showMessage(getApplication().getString(R.string.no_internet_connection));
            }
        });
    }
}
