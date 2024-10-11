package com.icarus.workorder.viewmodels;

import android.app.Application;
import android.text.TextUtils;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;

import com.icarus.R;
import com.icarus.base.BaseViewModel;
import com.icarus.util.FileUtils;
import com.icarus.widget.GalleryImageWidget;
import com.icarus.widget.viewmodel.GalleryViewModel;
import com.icarus.workorder.navigators.WorkOrderCompleteNavigator;
import com.icarus.workorder.repositories.WorkOrderCompleteRepository;

import java.io.File;

/**
 * Created by Anurag Purwar on 22/1/18.
 */
public class WorkOrderCompleteViewModel extends BaseViewModel<WorkOrderCompleteNavigator> {
    private final WorkOrderCompleteRepository workOrderCompleteRepository;
    private GalleryViewModel galleryViewModel;

    public WorkOrderCompleteViewModel(@NonNull Application application) {
        super(application);
        File fileDestinationFolder = FileUtils.getWorkOrderAttachmentsDir();
        galleryViewModel = new GalleryViewModel(getApplication(), fileDestinationFolder);
        workOrderCompleteRepository = new WorkOrderCompleteRepository(getApplication());
    }

    public void onCancelClick() {
        getNavigator().onCancelClick();
    }

    public void onCompleteClick() {
        getNavigator().onCompleteWorkOrder();
    }

    public void saveWorkOrder(String description, String worOrderUuid, Integer workOrderId) {
        boolean isValidated = true;

        if (TextUtils.isEmpty(description)) {
            getNavigator().onDescriptionError(R.string.error_field_required);
            isValidated = false;
        }

        if (isValidated) {
            workOrderCompleteRepository.completeWorkOrder(description, worOrderUuid, workOrderId, galleryViewModel.getListAttachment());
            getNavigator().onSuccessfullySaveWorkOrder();
        }
    }

    public GalleryViewModel getGalleryViewModel() {
        return galleryViewModel;
    }

    @BindingAdapter("app:bindAttachmentView")
    public static void setAttachmentView(LinearLayout linearLayout, GalleryViewModel galleryViewModel) {

        GalleryImageWidget galleryImageWidget = new GalleryImageWidget(linearLayout.getContext());
        galleryImageWidget.setItem(galleryViewModel);
        linearLayout.addView(galleryImageWidget);
    }
}