package com.icarus.workorder.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.BuildConfig;
import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.base.BaseFragment;
import com.icarus.constants.Constants;
import com.icarus.database.AppDatabase;
import com.icarus.databinding.FragmentWorkorderDetailBinding;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.listeners.OnSelectListener;
import com.icarus.util.ContentType;
import com.icarus.util.DialogUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.ImageLoader;
import com.icarus.util.Navigator;
import com.icarus.util.StringUtil;
import com.icarus.workorder.activities.WorkOrderCompleteActivity;
import com.icarus.workorder.models.WorkOrderAttachmentItems;
import com.icarus.workorder.models.WorkOrderDetailItems;
import com.icarus.workorder.models.WorkOrderNoteDetailItems;
import com.icarus.workorder.models.WorkOrderNoteInfoItems;
import com.icarus.workorder.navigators.WorkOrderDetailNavigator;
import com.icarus.workorder.viewmodels.WorkOrderDetailViewModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import c.anurag.database.util.CommonFunctions;

/**
 * Created by Anurag Purwar on 1/10/2019.
 */

public class WorkorderDetailFragment extends BaseFragment<FragmentWorkorderDetailBinding, WorkOrderDetailViewModel> implements WorkOrderDetailNavigator {
    private static String WORK_ORDER_ID = "WORK_ORDER_ID";
    private static String WORK_ORDER_UUID = "WORK_ORDER_UUID";
    private FragmentWorkorderDetailBinding mBinding;
    private WorkOrderDetailViewModel mWorkOrderViewModel;
    private ProgressDialog progressDialog;

    public static WorkorderDetailFragment getInstance(Integer workOrderId, String workOrderUuid) {
        WorkorderDetailFragment fragment = new WorkorderDetailFragment();
        Bundle args = new Bundle();
        args.putInt(WORK_ORDER_ID, workOrderId);
        args.putString(WORK_ORDER_UUID, workOrderUuid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_workorder_detail;
    }

    @Override
    public WorkOrderDetailViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(WorkOrderDetailViewModel.class) : null;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
        mWorkOrderViewModel = getViewModel();
        mWorkOrderViewModel.setNavigator(this);
        int workOrderId = getArguments().getInt(WORK_ORDER_ID, 0);
        String workOrderUuid = getArguments().getString(WORK_ORDER_UUID);
        mWorkOrderViewModel.setWorkOrderId(workOrderId, workOrderUuid);

        mWorkOrderViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<WorkOrderDetailItems>() {
            @Override
            public void onChanged(@Nullable final WorkOrderDetailItems workOrderDetailItems) {

                mWorkOrderViewModel.setInfoAdapter(workOrderDetailItems);
                mBinding.setItem(workOrderDetailItems);
                if (mWorkOrderViewModel.getAttachmentLiveData().hasObservers()) {
                    mWorkOrderViewModel.getAttachmentLiveData().removeObservers(getViewLifecycleOwner());
                }
                mWorkOrderViewModel.getAttachmentLiveData().observe(getViewLifecycleOwner(), new Observer<List<WorkOrderAttachmentItems>>() {
                    @Override
                    public void onChanged(@Nullable final List<WorkOrderAttachmentItems> workOrderAttachmentItems) {
                        mWorkOrderViewModel.setWorkOrderAttachmentItems(workOrderAttachmentItems);
                        if (mWorkOrderViewModel.getNoteLiveData().hasObservers()) {
                            mWorkOrderViewModel.getNoteLiveData().removeObservers(getViewLifecycleOwner());
                        }
                        mWorkOrderViewModel.getNoteLiveData().observe(getViewLifecycleOwner(), new Observer<List<WorkOrderNoteInfoItems>>() {
                            @Override
                            public void onChanged(@Nullable final List<WorkOrderNoteInfoItems> workOrderNoteInfoItems) {
                                if (StringUtil.INSTANCE.listNotNull(workOrderNoteInfoItems)) {
                                    Integer[] noteId = new Integer[workOrderNoteInfoItems.size()];
                                    for (int i = 0; i < workOrderNoteInfoItems.size(); i++) {
                                        noteId[i] = workOrderNoteInfoItems.get(i).getId();
                                    }
                                    mWorkOrderViewModel.fetchNoteDetail(noteId);

                                    if (mWorkOrderViewModel.getNoteDetailLiveData().hasObservers()) {
                                        mWorkOrderViewModel.getNoteDetailLiveData().removeObservers(getViewLifecycleOwner());
                                    }

                                    mWorkOrderViewModel.getNoteDetailLiveData().observe(getViewLifecycleOwner(), new Observer<List<WorkOrderNoteDetailItems>>() {
                                        @Override
                                        public void onChanged(@Nullable List<WorkOrderNoteDetailItems> workOrderNoteDetailItems) {
                                            mWorkOrderViewModel.setNoteInfoAdapter(workOrderNoteInfoItems, workOrderAttachmentItems, workOrderNoteDetailItems);
                                        }
                                    });

                                } else {
                                    mWorkOrderViewModel.setNoteInfoAdapter(workOrderNoteInfoItems, workOrderAttachmentItems, new ArrayList<WorkOrderNoteDetailItems>());
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public void performInProgressAction(WorkOrderDetailItems workOrderDetailItems, String statusName) {
        mWorkOrderViewModel.performInProgressAction(workOrderDetailItems, statusName);
    }

    @Override
    public void performCompleteAction(WorkOrderDetailItems workOrderDetailItems) {
        Navigator.launchActivityWithResult(getActivity(), Constants.REQUEST_RESULT_FOR_WORK_ORDER, WorkOrderCompleteActivity.getInstance(getActivity(),
                workOrderDetailItems.getId(), workOrderDetailItems.getUuid()));
    }

    @Override
    public void openOrDownloadAttachment(final WorkOrderAttachmentItems attachmentItem) {
        final File file = FileUtils.getFileFromName(attachmentItem.getPath(), Constants.WORK_ORDER_ATTACHMENTS);
        if (attachmentItem.getIsDownloaded() && file.exists()) {
            openFile(file, attachmentItem.getContentType());
        } else {
            DialogUtility.showAlertWithTwoButtonsOnly(getActivity(), getString(R.string.ask_file_download), R.string.ok, R.string.cancel, new OnSelectListener() {
                @Override
                public void onPositiveButtonClick() {
                    showProgressBar();
                    if (ContentType.getImageTypes().contains(attachmentItem.getContentType()))
                        BaseApplication.getImageLoader().loadImage(file, ImageLoader.ImageType.Workorder, attachmentItem.getUuid(), attachmentItem.getFileMd5Checksum(), new OnDownloadListener() {
                            @Override
                            public void onSuccess() {
                                saveAndOpenFile(attachmentItem, file);
                            }

                            @Override
                            public void onFailed() {
                                hideProgressBar();
                                CommonFunctions.showToast(getString(R.string.error_downloading_file));
                            }

                            @Override
                            public void noInternetAvailable() {
                                hideProgressBar();
                                CommonFunctions.showToast(getString(R.string.no_internet_connection));
                            }
                        });
                    else {
                        mWorkOrderViewModel.downloadFile(attachmentItem, new OnDownloadListener() {
                            @Override
                            public void onSuccess() {
                                saveAndOpenFile(attachmentItem, file);
                            }

                            @Override
                            public void onFailed() {
                                CommonFunctions.showToast(getString(R.string.error_downloading_file));
                                hideProgressBar();
                            }

                            @Override
                            public void noInternetAvailable() {
                                CommonFunctions.showToast(getString(R.string.no_internet_connection));
                            }
                        });
                    }
                }

                @Override
                public void onNegativeButtonClick() {
                    //Do Nothing
                }
            });

        }
    }

    @Override
    public void showProgressBar() {
        if (getActivity() != null) {
            progressDialog = ProgressDialog.show(getActivity(), getString(R.string.app_name), getString(R.string.downloading_file), true);
            progressDialog.setCancelable(false);
        }
    }

    @Override
    public void hideProgressBar() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    private void saveAndOpenFile(WorkOrderAttachmentItems attachmentItem, File file) {
        hideProgressBar();
        attachmentItem.setIsDownloaded(Constants.DOWNLOADED);
        AppDatabase appDatabase = AppDatabase.getInstance(getActivity());
        appDatabase.workOrderDetailDao().updateWorkOrderAttachment(attachmentItem.getUuid());
        openFile(file, attachmentItem.getContentType());
    }


    private void openFile(File file, String contentType) {
        if (getActivity() == null)
            return;
        Uri photoURI = FileProvider.getUriForFile(getActivity(), BuildConfig.APPLICATION_ID + ".provider", file);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(photoURI, contentType);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.file_open_error);
            builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
    }
}
