package com.icarus.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.icarus.constants.Constants;
import com.icarus.dao.AllCaptureDataDao;
import com.icarus.database.AppDatabase;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.models.ElementAttributesItems;
import com.icarus.models.ElementWithCaptureDataItems;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.ChecklistElementsApi;
import com.icarus.util.FileUtils;
import com.icarus.util.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Monika Rana on 04/10/2019
 */
public class AllCaptureDataRepository {
    private Context mContext;

    public AllCaptureDataRepository(Context context) {
        mContext = context;
    }

    /**
     * Calls query for getting list of elements having attributes
     *
     * @param assignedChecklistUUID Checklist UUID
     * @param checklistID           Checklist ID
     * @param config                Required for pagination on list
     * @return The list of elements
     */
    public LiveData<PagedList<ElementWithCaptureDataItems>> getElementsWithCaptureData(String assignedChecklistUUID, Integer checklistID, PagedList.Config config) {
        AppDatabase appDatabase = AppDatabase.getInstance(mContext);
        AllCaptureDataDao dataDao = appDatabase.allCaptureDataDao();
        DataSource.Factory<Integer, ElementWithCaptureDataItems> factory;

        factory = dataDao.getElementsWithAttributes(assignedChecklistUUID, checklistID);
        return new LivePagedListBuilder<>(factory, config)
                .build();
    }

    /**
     * Returns a list of data captured on attributes for a given element in an assigned checklist.
     * <p>
     * The data captured which is returned for a given attribute is the latest data recorded on that
     * element. Meaning if the data on an attribute was captured more than once, it would return
     * the data that was captured last on that attribute.
     *
     * @param assignedChecklistUuid UUID of the Assigned Checklist
     * @param elementId             ID of Element
     * @return The attribute list
     */
    public MutableLiveData<List<ElementAttributesItems>> getElementAttributes(String assignedChecklistUuid, int elementId) {
        AppDatabase database = AppDatabase.getInstance(mContext);
        AllCaptureDataDao dao = database.allCaptureDataDao();
        List<ElementAttributesItems> dataCaptured = dao.getAttributes(assignedChecklistUuid, elementId);

        MutableLiveData<List<ElementAttributesItems>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(dataCaptured);

        return mutableLiveData;
    }

    /**
     * This method is called when we click on the attached file template from file required attribute
     *
     * @param onDownloadListener Callback for handling result
     */
    public void downloadAttachedTemplateFile(String fileName, String itemUUID, final OnDownloadListener onDownloadListener) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File directory = FileUtils.getResourcesAttachmentsDir();
            if (directory == null) {
                onDownloadListener.onFailed();
                return;
            }

            final File fileDestinationFolder = new File(directory, fileName);

            if (!fileDestinationFolder.exists()) {
                if (!Utilities.isOnline(mContext)) {
                    onDownloadListener.noInternetAvailable();
                    return;
                }
                RetroUtils.getRetrofitInstance(mContext, new InternetConnectionListener() {
                    @Override
                    public void onInternetUnavailable() {
                        onDownloadListener.noInternetAvailable();
                    }
                }).create(ChecklistElementsApi.class)
                        .capturedDataDownload(Constants.HEADER_ACCEPT, itemUUID)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new AbstractNetworkObservable<ResponseBody>() {
                            @Override
                            public void success(ResponseBody responseBody) {
                                if (responseBody != null) {
                                    try {
                                        if (fileDestinationFolder.createNewFile()) {
                                            fileUtils.saveToDisk(responseBody, fileDestinationFolder);
                                            onDownloadListener.onSuccess();
                                        } else
                                            onDownloadListener.onFailed();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        onDownloadListener.onFailed();
                                    }
                                }
                            }

                            @Override
                            public void failure(Throwable error) {
                                onDownloadListener.onFailed();
                            }
                        });
            } else {
                onDownloadListener.onSuccess();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            onDownloadListener.onFailed();
        }
    }
}
