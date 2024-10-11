package com.icarus.checklistexecutionfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.icarus.BR;
import com.icarus.R;
import com.icarus.adapters.PPEListAdapter;
import com.icarus.adapters.StepEmbeddedImagePagerAdapter;
import com.icarus.base.BaseFragment;
import com.icarus.constants.Constants;
import com.icarus.customviews.SlideButton;
import com.icarus.databinding.FragmentStepProcedureBinding;
import com.icarus.enums.AttributeType;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.navigators.SPExecutionNavigator;
import com.icarus.util.FileUtils;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;


/**
 * This fragment shows step procedure execution
 */
public class SPFragment extends BaseFragment<FragmentStepProcedureBinding, ChecklistExecutionViewModel> implements View.OnClickListener, SPExecutionNavigator {
    private FragmentStepProcedureBinding binding;
    private ChecklistExecutionViewModel mViewModel;
    private List<ChecklistDetailItems> checklistDetailItemsList;
    public static final String IS_SHOW_SLIDE_COMPLETE = "is_show_slide_complete";
    private boolean isAttributesAdded;

    public static SPFragment getInstance(boolean isShowSlideButton, SPExecutionNavigator navigator) {
        Bundle args = new Bundle();
        args.putBoolean(SPFragment.IS_SHOW_SLIDE_COMPLETE, isShowSlideButton);
        SPFragment fragment = new SPFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_step_procedure;
    }

    @Override
    public ChecklistExecutionViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(ChecklistExecutionViewModel.class) : null;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Utilities.getInstance(getActivity()).showHideKeyboard(false, getActivity());
        binding = getViewDataBinding();
        mViewModel = getViewModel();
        mViewModel.getData(mViewModel.getChecklistElementDetail());

        //Sets boolean if step is executed
        mViewModel.checkStepExecuted();
        binding.setItem(mViewModel.getChecklistElementDetail());
        binding.setViewModel(getViewModel());
        binding.dashLine.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        setFabIconOptions();
        binding.executePendingBindings();

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(binding.recyclerViewEquipments.getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.recyclerViewEquipments.setLayoutManager(layoutManager);

        if (mViewModel.getSelectedTab() == 0)
            binding.btnSlide.isEnabled(!mViewModel.isStepExecuted(), getString(mViewModel.getChecklistElementDetail().getStepExecutionStatus()));
        else
            binding.btnSlide.isEnabled(true, getString(mViewModel.getChecklistElementDetail().getStepExecutionStatus()));

        checklistDetailItemsList = mViewModel.getStepEmbeddedImages(mViewModel.getChecklistElementDetail().getElementId());
        if (checklistDetailItemsList != null && checklistDetailItemsList.size() > 0) {
            final int listSize = checklistDetailItemsList.size();

            StepEmbeddedImagePagerAdapter adapter = new StepEmbeddedImagePagerAdapter(getActivity(), checklistDetailItemsList, mViewModel);
            binding.viewPagerEmbeddedImages.setAdapter(adapter);
            addDot(0, listSize);

            binding.setTotalEmbeddedImageCount(listSize);
            binding.setCurrentEmbeddedImageCount(1);
            //Execute first embedded image as visible
            if (!checklistDetailItemsList.get(0).checkElementIfExecuted()) {
                mViewModel.executeImage(checklistDetailItemsList.get(0).getElementId(), checklistDetailItemsList.get(0).getItemUuid(),
                        checklistDetailItemsList.get(0).getDescription());
                checklistDetailItemsList.get(0).setImageTextStatus(LogTableActions.IMAGE.getValue());
            }

            // whenever the page changes
            binding.viewPagerEmbeddedImages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    File file = FileUtils.getFileFromName(checklistDetailItemsList.get(i).getFileName(), Constants.RESOURCES);
                    //Execute image as viewed
                    if (!checklistDetailItemsList.get(i).checkElementIfExecuted() && FileUtils.isFileExist(file.getPath())) {
                        mViewModel.executeImage(checklistDetailItemsList.get(i).getElementId(), checklistDetailItemsList.get(i).getItemUuid(),
                                checklistDetailItemsList.get(i).getDescription());
                        checklistDetailItemsList.get(i).setImageTextStatus(LogTableActions.IMAGE.getValue());
                    }
                    //Showing selected image dot
                    addDot(i, listSize);
                    binding.setCurrentEmbeddedImageCount(i + 1);
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
        } else {
            binding.embeddedImageContainer.setVisibility(View.GONE);
            binding.pagerDots.setVisibility(View.GONE);
        }

        if (mViewModel.getCheckListPPItemsList() != null && mViewModel.getCheckListPPItemsList().size() > 0)
            binding.recyclerViewEquipments.setAdapter(new PPEListAdapter(getActivity(), mViewModel.getCheckListPPItemsList(),
                    mViewModel.getCheckListPPItemsList().size(), mViewModel.getChecklistElementDetail().getItemUuid(),
                    false));
        else
            binding.recyclerViewEquipments.setVisibility(View.GONE);

        //Show attributes if any and manage record details and slide to complete button, And on orientation
        //change prevents fragments added again as they are already added
        if (savedInstanceState != null)
            isAttributesAdded = savedInstanceState.getBoolean("isAttributesAdded", false);

        if (mViewModel.attributeItemsList != null && mViewModel.attributeItemsList.size() > 0 && getActivity() != null && !isAttributesAdded) {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            for (int i = 0; i < mViewModel.attributeItemsList.size(); i++) {
                if (mViewModel.attributeItemsList.get(i).getType().equalsIgnoreCase(AttributeType.QA.toString()))
                    ft.add(binding.containerAttributes.getId(), QAVerifyFragment.getInstance(i, this), QAVerifyFragment.class.getSimpleName().concat(String.valueOf(i)));
                else if (mViewModel.attributeItemsList.get(i).getType().equalsIgnoreCase(AttributeType.FILE.toString()))
                    ft.add(binding.containerAttributes.getId(), FileRequiredFragment.getInstance(i, this), FileRequiredFragment.class.getSimpleName().concat(String.valueOf(i)));
                else if (mViewModel.attributeItemsList.get(i).getType().equalsIgnoreCase(AttributeType.QR.toString())) {
                    ft.add(binding.containerAttributes.getId(), QRCodeFragment.getInstance(i, this), QRCodeFragment.class.getSimpleName().concat(String.valueOf(i)));
                } else
                    ft.add(binding.containerAttributes.getId(), UserInputExecutionFragment.getInstance(i, this), UserInputExecutionFragment.class.getSimpleName().concat(String.valueOf(i)));
            }
            ft.commit();
            isAttributesAdded = true;
        }

        //Manage record details and slide to complete button visibility
        //If selected tab is 0 and step not executed, show record details button and enable slide to complete button only if all attributes are completed
        //If selected tab is 0 and step executed, show execution status
        //If selected tab is skipped/deferred, show record details button
        if (mViewModel.attributeItemsList != null && mViewModel.attributeItemsList.size() > 0) {
            if (mViewModel.getSelectedTab() == 0 && mViewModel.isStepExecuted()) {
                //Show executed status and disable slide to complete button
                binding.btnSlide.isEnabled(false, getString(mViewModel.getChecklistElementDetail().getStepExecutionStatus()));
                binding.btnSlide.setVisibility(View.VISIBLE);
                //If skipped or deferred don't show record detail button and attributes, only status is displayed
                if (mViewModel.getChecklistElementDetail().isSkipped() || mViewModel.getChecklistElementDetail().isDeferred()) {
                    binding.recordDetails.setVisibility(View.GONE);
                    binding.containerAttributes.setVisibility(View.GONE);
                } else {
                    binding.recordDetails.setVisibility(View.GONE);
                    binding.containerAttributes.setVisibility(View.VISIBLE);
                }
            } else if (mViewModel.getSelectedTab() == 1 || mViewModel.getSelectedTab() == 2) {
                binding.recordDetails.setVisibility(View.VISIBLE);
                binding.containerAttributes.setVisibility(View.GONE);
                binding.btnSlide.setVisibility(View.INVISIBLE);
            } else {
                binding.recordDetails.setVisibility(View.VISIBLE);
                binding.containerAttributes.setVisibility(View.GONE);
                binding.btnSlide.setVisibility(View.INVISIBLE);
            }
        } else {
            binding.recordDetails.setVisibility(View.GONE);
            binding.containerAttributes.setVisibility(View.GONE);

            if (mViewModel.getSelectedTab() == 0 && mViewModel.isStepExecuted()) {
                //Show executed status and disable slide to complete button
                binding.btnSlide.isEnabled(false, getString(mViewModel.getChecklistElementDetail().getStepExecutionStatus()));
            }
        }

        binding.btnSlide.setOnCompleteListener(new SlideButton.OnCompleteListener() {
            @Override
            public void onComplete() {
                if (checklistDetailItemsList != null && !mViewModel.ifStepEmbeddedImagesExecuted(checklistDetailItemsList)) {
                    Utilities.getInstance(getActivity()).showToast(getString(R.string.execute_all_child_embedded_images), Toast.LENGTH_LONG, getActivity());
                    binding.btnSlide.refresh();
                } else if (mViewModel.isChildExecuted(mViewModel.getChecklistElementDetail().getElementId())) {
                    mViewModel.executeStep(ChecklistExecutionStatus.ACKNOWLEDGE.getValue(), LogTableActions.COMPLETED.getValue());
                    mViewModel.setExecuted(true);
                    mViewModel.setStepExecuted(true);
                    getViewModel().fetchNextData(true);
                } else {
                    Utilities.getInstance(getActivity()).showToast(getString(R.string.execute_all_child_elements), Toast.LENGTH_LONG, getActivity());
                    binding.btnSlide.refresh();
                }
            }
        });

        if (savedInstanceState != null) {
            binding.recordDetails.setVisibility(savedInstanceState.getBoolean("isRecordDetailBtnVisible",
                    false) ?
                    View.VISIBLE : View.GONE);

            binding.btnSlide.setVisibility(savedInstanceState.getBoolean("isBtnSlideVisible",
                    false) ?
                    View.VISIBLE : View.INVISIBLE);

            binding.containerAttributes.setVisibility(savedInstanceState.getBoolean("isAttributesVisible",
                    false) ?
                    View.VISIBLE : View.GONE);
        }
        binding.recordDetails.setOnClickListener(this);
    }


    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isRecordDetailBtnVisible", binding.recordDetails.getVisibility() == View.VISIBLE);
        outState.putBoolean("isAttributesVisible", binding.containerAttributes.getVisibility() == View.VISIBLE);
        outState.putBoolean("isBtnSlideVisible", binding.btnSlide.getVisibility() == View.VISIBLE);
        outState.putBoolean("isAttributesAdded", isAttributesAdded);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recordDetails:
                binding.containerAttributes.setVisibility(View.VISIBLE);
                binding.recordDetails.setVisibility(View.INVISIBLE);
                binding.nestedScrollView.postDelayed(new Runnable() {
                    public void run() {
                        binding.nestedScrollView.smoothScrollBy(0, binding.containerAttributes.getTop());
                    }
                }, 100);

                if (mViewModel.isAttributesExecuted())
                    binding.btnSlide.setVisibility(View.VISIBLE);


                //Check if there is any qr attribute pending to be executed show qr scan fragment
                if (mViewModel.getQrScanAttribute() != null && mViewModel.getQrScanAttribute().checkIfQRScanPending()) {
                    QRCodeFragment fragment = (QRCodeFragment) getChildFragmentManager().findFragmentByTag(QRCodeFragment.class.getSimpleName().
                            concat(String.valueOf(mViewModel.getQrScanAttribute().getAttributePosition())));
                    if (fragment == null)
                        return;
                    Utilities.getInstance(getActivity()).addFragment(R.id.frame_layout,
                            QRCodeVerifyFragment.getInstance(fragment.getNavigator()), QRCodeVerifyFragment.class.getSimpleName(), true, getActivity());
                }
                break;
        }
    }

    //Indicator for embedded images
    public void addDot(int page_position, int size) {
        AppCompatImageView[] dot = new AppCompatImageView[size];
        binding.pagerDots.removeAllViews();

        if (getActivity() != null)
            for (int i = 0; i < dot.length; i++) {
                dot[i] = new AppCompatImageView(getActivity());
                dot[i].setImageResource(R.drawable.grey_circle);
                dot[i].setPadding(5, 0, 5, 0);
                binding.pagerDots.addView(dot[i]);
            }
        //active dot for selected image
        dot[page_position].setImageResource(R.drawable.blue_circle);
    }

    @Override
    public void checkIfStepValidToComplete() {
        //When all attributes are executed, show slide to complete button
        if (mViewModel.isAttributesExecuted() && binding.containerAttributes.getVisibility() == View.VISIBLE) {
            binding.btnSlide.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void removeQRAttributeIfNoItemToScan(int attributePosition) {
        if (getChildFragmentManager().findFragmentById(binding.containerAttributes.getId()) == null)
            return;

        QRCodeFragment fragment = (QRCodeFragment) getChildFragmentManager()
                .findFragmentByTag(QRCodeFragment.class.getSimpleName().
                        concat(String.valueOf(attributePosition)));
        if (fragment != null)
            getChildFragmentManager().beginTransaction().remove(fragment).commit();

        //check if no attribute show slide to complete button
        if (mViewModel.isAttributesExecuted()) {
            binding.btnSlide.setVisibility(View.VISIBLE);
            binding.recordDetails.setVisibility(View.GONE);
        }

        int sequenceNumber = 0;
        for (int i = 0; i < mViewModel.attributeItemsList.size(); i++) {
            if (mViewModel.attributeItemsList.get(i).getType().equalsIgnoreCase(AttributeType.QA.toString())) {
                QAVerifyFragment qaVerifyFragment = (QAVerifyFragment) getChildFragmentManager().findFragmentByTag(QAVerifyFragment.class.getSimpleName().
                        concat(String.valueOf(i)));
                if (qaVerifyFragment != null) {
                    qaVerifyFragment.updateSequenceNumber(sequenceNumber);
                    sequenceNumber++;
                }
            } else if (mViewModel.attributeItemsList.get(i).getType().equalsIgnoreCase(AttributeType.FILE.toString())) {
                FileRequiredFragment fileRequiredFragment = (FileRequiredFragment) getChildFragmentManager().findFragmentByTag(FileRequiredFragment.class.getSimpleName().
                        concat(String.valueOf(i)));
                if (fileRequiredFragment != null) {
                    fileRequiredFragment.updateSequenceNumber(sequenceNumber);
                    sequenceNumber++;
                }
            } else if (mViewModel.attributeItemsList.get(i).getType().equalsIgnoreCase(AttributeType.QR.toString()) && i != attributePosition) {
                QRCodeFragment qrCodeFragment = (QRCodeFragment) getChildFragmentManager().findFragmentByTag(QRCodeFragment.class.getSimpleName().
                        concat(String.valueOf(i)));
                if (qrCodeFragment != null) {
                    qrCodeFragment.updateSequenceNumber(sequenceNumber);
                    sequenceNumber++;
                }
            } else {
                UserInputExecutionFragment userInputExecutionFragment = (UserInputExecutionFragment) getChildFragmentManager().findFragmentByTag(UserInputExecutionFragment.class.getSimpleName().
                        concat(String.valueOf(i)));
                if (userInputExecutionFragment != null) {
                    userInputExecutionFragment.updateSequenceNumber(sequenceNumber);
                    sequenceNumber++;
                }
            }
        }

    }


    public void setFabIconOptions() {
        //Check if parent skipped or deferred and show icon
        if ((mViewModel.getChecklistElementDetail().isSkipped())) {
            mViewModel.isDeferAvailable = true;
            mViewModel.isSkipAvailable = false;
        } else if ((mViewModel.getChecklistElementDetail().isDeferred())) {
            mViewModel.isDeferAvailable = false;
            mViewModel.isSkipAvailable = true;
        } else if (!mViewModel.getChecklistElementDetail().checkElementIfExecuted()) {
            mViewModel.isDeferAvailable = true;
            mViewModel.isSkipAvailable = true;
        } else {
            mViewModel.isDeferAvailable = false;
            mViewModel.isSkipAvailable = false;
        }

        mViewModel.isReferenceAvailable = getViewModel().isReference();
    }

}

