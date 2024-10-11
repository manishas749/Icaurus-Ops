package com.icarus.checklistexecutionfragments;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.activities.ChecklistExecutionActivity;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentRecordDetailBinding;
import com.icarus.enums.AttributeType;
import com.icarus.enums.LogTableActions;
import com.icarus.listeners.OnMultipleItemsSelected;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.CheckListStepAttributeItems;
import com.icarus.models.ChecklistIDetailtems;
import com.icarus.models.UserItems;
import com.icarus.navigators.SPExecutionNavigator;
import com.icarus.util.AppUtility;
import com.icarus.util.DialogUtility;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;
import com.icarus.workorder.activities.WorkOrderCreateActivity;

import android.app.DatePickerDialog;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AlertDialog;

import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Monika Rana on 1/25/2019.
 */

public class UserInputExecutionFragment extends BaseFragment<FragmentRecordDetailBinding, ChecklistExecutionViewModel> implements CheckBox.OnCheckedChangeListener, View.OnClickListener {
    private FragmentRecordDetailBinding binding;
    private ChecklistExecutionViewModel mViewModel;
    private CheckListStepAttributeItems mCheckListStepAttributeItems;
    private TextInputEditText etInput;
    private TextView tvDate, tvUsers;
    private RadioGroup mRadioGroup;
    private ArrayList<UserItems> selectedUsersList;
    private TextInputLayout textInputLayout;
    private int position = 0;
    //Save already saved value
    private String mAttributeValue;
    // boolean saved for not showing create work order popup if canceled/created once as create
    // work order will appear only once
    private boolean isWorkOrderCreateAsked = false, isEditable;
    private SPExecutionNavigator mNavigatorListener;
    //For saving selectable list label
    private List<String> labelList;

    public static UserInputExecutionFragment getInstance(int position, SPExecutionNavigator navigator) {
        Bundle args = new Bundle();
        args.putInt(ChecklistExecutionActivity.ATTRIBUTE_POSITION, position);
        UserInputExecutionFragment fragment = new UserInputExecutionFragment();
        fragment.setNavigatorListener(navigator);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_record_detail;
    }

    @Override
    public ChecklistExecutionViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(ChecklistExecutionViewModel.class) : null;
    }




    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        Utilities.getInstance(getActivity()).showHideKeyboard(false, getActivity());
        binding = getViewDataBinding();
        mViewModel = getViewModel();
        position = getArguments() != null ? getArguments().getInt(ChecklistExecutionActivity.ATTRIBUTE_POSITION, 0) : 0;
        if (mViewModel.attributeItemsList != null && position < mViewModel.attributeItemsList.size()) {
            mCheckListStepAttributeItems = mViewModel.attributeItemsList.get(position);
            mViewModel.setBtnText(getString(R.string.submit));
            binding.setItem(mCheckListStepAttributeItems);
            binding.setAttributeNo(position + 1);
            binding.setViewModel(mViewModel);
            addInputFields(mCheckListStepAttributeItems.getType());
            binding.executePendingBindings();
            binding.btnSubmit.setOnClickListener(this);

            binding.linear.setEnabled(false);
        }

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("isSubmitButtonVisible", false))
                binding.btnSubmit.setVisibility(View.VISIBLE);
            else
                binding.btnSubmit.setVisibility(View.INVISIBLE);

            if (savedInstanceState.getBoolean("isEditButtonVisible", false))
                binding.editAttribute.setVisibility(View.VISIBLE);
            else
                binding.editAttribute.setVisibility(View.INVISIBLE);

            if (savedInstanceState.getBoolean("isEditable", isEditable))
                binding.editAttribute.callOnClick();

            binding.label.setText(savedInstanceState.getString("sequenceNumber"));
        }
    }

    public void setNavigatorListener(SPExecutionNavigator navigatorListener) {
        mNavigatorListener = navigatorListener;
    }


    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isSubmitButtonVisible", binding.btnSubmit.getVisibility() == View.VISIBLE);
        outState.putBoolean("isEditButtonVisible", binding.editAttribute.getVisibility() == View.VISIBLE);
        outState.putBoolean("isEditable", isEditable);
        outState.putString("sequenceNumber", binding.label.getText().toString());
    }


    /**
     * Checks the input fields to be shown for the selected attribute
     *
     * @param type The attribute type for selected attribute
     */
    private void addInputFields(String type) {
        mAttributeValue = mCheckListStepAttributeItems.getAttributeValue();
        if (type.equalsIgnoreCase(AttributeType.BOOLEAN.toString()) || type.equalsIgnoreCase(AttributeType.LIST.toString())) {
            if (mCheckListStepAttributeItems.getDisplayAs().equalsIgnoreCase(AttributeType.CHECKBOX.toString())) {
                setCheckbox(mAttributeValue);
            } else {
                setRadioGroup(mAttributeValue);
            }
        } else if (type.equalsIgnoreCase(AttributeType.USER.toString())) {
            setUserSpinner(mAttributeValue);
        } else if (type.equalsIgnoreCase(AttributeType.DATE.toString())) {
            setDatePicker(mAttributeValue);
        } else if (type.equalsIgnoreCase(AttributeType.NUMBER.toString())) {
            setUserInput(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL, mAttributeValue);
        } else if (type.equalsIgnoreCase(AttributeType.TEXT.toString())) {
            setUserInput(InputType.TYPE_CLASS_TEXT, mAttributeValue);
        } else {
            //Do Nothing
        }
    }

    /**
     * Adds Spinner and gets the user list for user roles required in attribute
     *
     * @param attributeValue Saved value for attribute, is null if not submitted yet
     */
    private void setUserSpinner(String attributeValue) {
        int margin = (int) (5 * getResources().getDisplayMetrics().density);
        tvUsers = new TextView(binding.linear.getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(margin, margin, margin, margin);
        tvUsers.setLayoutParams(params);
        tvUsers.setId(0);
        tvUsers.setTextColor(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        tvUsers.setTextSize(17f);
        tvUsers.setBackgroundResource(R.drawable.rectangle_gray);
        tvUsers.setCompoundDrawablesWithIntrinsicBounds(null, null, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_drop_down_arrow, null), null);
        tvUsers.setCompoundDrawablePadding(margin);
        binding.linear.addView(tvUsers);
        tvUsers.setText(getLabel());
        selectedUsersList = new ArrayList<>();
        final List<UserItems> userItems = mViewModel.getUserList(mCheckListStepAttributeItems.getUserRoles());
        final String[] userNameList = AppUtility.Companion.getTitleList(userItems).toArray(new String[userItems.size()]);
        final boolean[] booleansList = new boolean[userNameList.length];
        Arrays.fill(booleansList, false);

        //For single value save selected index
        int selectedValueIndex = -1;
        //If values are submitted, check and show selected values
        if (attributeValue != null && !attributeValue.trim().isEmpty()) {
            binding.btnSubmit.setVisibility(View.INVISIBLE);
            tvUsers.setClickable(false);
            tvUsers.setFocusable(false);
            tvUsers.setEnabled(false);


            List<String> selectedUsers = Arrays.asList(attributeValue.split(","));
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 0; i < userNameList.length; i++) {
                for (int j = 0; j < selectedUsers.size(); j++) {
                    try {
                        if (Integer.parseInt(selectedUsers.get(j).trim()) == userItems.get(i).getId()) {
                            booleansList[i] = true;
                            selectedValueIndex = i;
                            stringBuffer.append(userItems.get(i).getFullName());
                            stringBuffer.append(", ");
                            userItems.get(i).setSelected(true);
                            selectedUsersList.add(userItems.get(i));
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            tvUsers.setText(stringBuffer.length() > 2 ? stringBuffer.substring(0, stringBuffer.length() - 2) : getLabel());
            if ((mViewModel.getChecklistElementDetail().isSkipped() || mViewModel.getChecklistElementDetail().isDeferred()) || !mViewModel.isStepExecuted()) {
                binding.editAttribute.setVisibility(View.VISIBLE);
                tvUsers.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            } else
                binding.editAttribute.setVisibility(View.INVISIBLE);
        } else {
            binding.editAttribute.setVisibility(View.INVISIBLE);
        }

        binding.editAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvUsers.setClickable(true);
                tvUsers.setFocusable(true);
                tvUsers.setEnabled(true);
                v.setVisibility(View.INVISIBLE);
                isEditable = true;
                tvUsers.setCompoundDrawablesWithIntrinsicBounds(null, null, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_drop_down_arrow, null), null);
                binding.btnSubmit.setVisibility(View.VISIBLE);
            }
        });


        final int[] finalSelectedValueIndex = {selectedValueIndex};
        tvUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserSelectorDialog(userNameList, booleansList, finalSelectedValueIndex[0], getActivity(), new OnMultipleItemsSelected() {
                    @Override
                    public void onItemsSelected(boolean[] selectedValueArray) {
                        tvUsers.setText(getLabel());
                        selectedUsersList.clear();
                        for (int i = 0; i < selectedValueArray.length; i++)
                            if (selectedValueArray[i]) {
                                finalSelectedValueIndex[0] = i;
                                userItems.get(i).setSelected(true);
                                selectedUsersList.add(userItems.get(i));
                            } else
                                userItems.get(i).setSelected(false);
                        tvUsers.setText(Utilities.getCommaSeparatedUserNames(selectedUsersList, getLabel()));
                    }
                });
            }
        });

    }

    private void showUserSelectorDialog(final String[] namesList, final boolean[] booleansList,
                                        int finalSelectedValueIndex, Context context,
                                        final OnMultipleItemsSelected listner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if (mCheckListStepAttributeItems.getMultiple() != null && mCheckListStepAttributeItems.getMultiple() == 1)
            builder.setMultiChoiceItems(namesList, booleansList, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    booleansList[which] = isChecked;
                }
            });
        else {
            //Show selected user checked

            builder.setSingleChoiceItems(namesList, finalSelectedValueIndex, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Arrays.fill(booleansList, false);
                    booleansList[which] = true;
                }
            });
        }
        builder.setCancelable(false);
        builder.setTitle(getLabel());
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listner.onItemsSelected(booleansList);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Called when the attribute is executed validates the input entered by user
     *
     * @param type Attribute type
     */
    private void checkAndSaveInputFields(String type) {
        if (type.equalsIgnoreCase(AttributeType.BOOLEAN.toString()) || type.equalsIgnoreCase(AttributeType.LIST.toString())) {
            ArrayList<String> selectedOptions = new ArrayList<>();
            if (mCheckListStepAttributeItems.getDisplayAs().equalsIgnoreCase(AttributeType.CHECKBOX.toString())) {
                //Get selected values
                for (int i = 0; labelList.size() > i; i++) {
                    if (((CheckBox) binding.getRoot().findViewById(i)).isChecked())
                        selectedOptions.add(labelList.get(i));
                }

                if (selectedOptions.size() == 0)
                    showErrorMessage(getString(R.string.select_atleast_one));
                else {
                    String selectedValues = TextUtils.join(", ", selectedOptions);
                    if (TextUtils.isEmpty(mAttributeValue) || !mAttributeValue.equalsIgnoreCase(selectedValues)) {
                        mAttributeValue = selectedValues;
                        mViewModel.executeStepAttribute(selectedValues, LogTableActions.OTHER_THAN_FILE.getValue(), position);
                    }
                    onAttributeValuesSaved();
                    //Disable checkboxes
                    for (int i = 0; labelList.size() > i; i++) {
                        ((CheckBox) binding.getRoot().findViewById(i)).setEnabled(false);
                    }
                }
            } else {

                for (int i = 0; labelList.size() > i; i++) {
                    if (((RadioButton) binding.getRoot().findViewById(i)).isChecked())
                        selectedOptions.add(labelList.get(i));
                }
                if (selectedOptions.size() == 0)
                    showErrorMessage(getString(R.string.select_atleast_one));
                else {
                    String selectedValues = TextUtils.join(", ", selectedOptions);
                    if (TextUtils.isEmpty(mAttributeValue) || !mAttributeValue.equalsIgnoreCase(selectedValues)) {
                        mAttributeValue = selectedValues;
                        mViewModel.executeStepAttribute(selectedValues, LogTableActions.OTHER_THAN_FILE.getValue(), position);
                    }
                    onAttributeValuesSaved();
                    //Disable checkboxes
                    for (int i = 0; labelList.size() > i; i++) {
                        ((RadioButton) binding.getRoot().findViewById(i)).setEnabled(false);
                    }
                }
            }
        } else if (type.equalsIgnoreCase(AttributeType.USER.toString())) {
            if (tvUsers.getText() != null && tvUsers.getText().toString().equalsIgnoreCase(getLabel()))
                showErrorMessage(getString(R.string.select_atleast_one));
            else {
                String userIds = Utilities.getCommaSeparatedUserIds(selectedUsersList, getLabel());
                if (TextUtils.isEmpty(mAttributeValue) || !mAttributeValue.equalsIgnoreCase(userIds)) {
                    mAttributeValue = userIds;
                    mViewModel.executeStepAttribute(userIds, Utilities.getCommaSeparatedUserNames(selectedUsersList, getLabel()), LogTableActions.OTHER_THAN_FILE.getValue(), position);
                }
                onAttributeValuesSaved();
                tvUsers.setClickable(false);
                tvUsers.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }

        } else if (type.equalsIgnoreCase(AttributeType.DATE.toString())) {
            if (tvDate.getText().toString().trim().isEmpty() || tvDate.getText().toString().trim().equalsIgnoreCase(getString(R.string.select_date)))
                showErrorMessage(getString(R.string.select_atleast_one));
            else {
                if (TextUtils.isEmpty(mAttributeValue) || !mAttributeValue.equalsIgnoreCase(tvDate.getText().toString().trim())) {
                    mAttributeValue = tvDate.getText().toString().trim();
                    mViewModel.executeStepAttribute(tvDate.getText().toString().trim(), LogTableActions.OTHER_THAN_FILE.getValue(), position);
                }
                onAttributeValuesSaved();
                tvDate.setClickable(false);
            }
        } else if (type.equalsIgnoreCase(AttributeType.NUMBER.toString())) {
            if (etInput.getText().toString().trim().trim().isEmpty())
                textInputLayout.setError(getString(R.string.enter_value));
            else if (!isWorkOrderCreateAsked && ((mCheckListStepAttributeItems.getMinValue() != null
                    && Float.parseFloat(etInput.getText().toString().trim()) < mCheckListStepAttributeItems.getMinValue())
                    || (mCheckListStepAttributeItems.getMaxValue() != null
                    && Float.parseFloat(etInput.getText().toString().trim()) > mCheckListStepAttributeItems.getMaxValue())))
                askToOpenWorkOrder(String.format(getString(R.string.number_limit_validation), String.valueOf(mCheckListStepAttributeItems.getMinValue() != null ? String.format(getString(R.string.min_required), String.valueOf(mCheckListStepAttributeItems.getMinValue())) : ""), String.valueOf(mCheckListStepAttributeItems.getMaxValue() != null ? String.format(getString(R.string.max_required), String.valueOf(mCheckListStepAttributeItems.getMaxValue())) : "")));
            else {
                if (TextUtils.isEmpty(mAttributeValue) || !mAttributeValue.equalsIgnoreCase(etInput.getText().toString().trim())) {
                    mAttributeValue = etInput.getText().toString().trim();
                    mViewModel.executeStepAttribute(etInput.getText().toString().trim(), LogTableActions.OTHER_THAN_FILE.getValue(), position);
                }
                etInput.setFocusableInTouchMode(false);
                etInput.clearFocus();

                onAttributeValuesSaved();
            }

        } else if (type.equalsIgnoreCase(AttributeType.TEXT.toString())) {
            if (etInput.getText().toString().trim().isEmpty())
                textInputLayout.setError(getString(R.string.enter_value));
            else if (!isWorkOrderCreateAsked && ((mCheckListStepAttributeItems.getMinLength() != null
                    && etInput.getText().toString().trim().length() < mCheckListStepAttributeItems.getMinLength())
                    || (mCheckListStepAttributeItems.getMaxLength() != null
                    && etInput.getText().toString().trim().length() > mCheckListStepAttributeItems.getMaxLength())))
                askToOpenWorkOrder(String.format(getString(R.string.characters_limit_validation), String.valueOf(mCheckListStepAttributeItems.getMinLength() != null ? String.format(getString(R.string.min_required), String.valueOf(mCheckListStepAttributeItems.getMinLength())) : ""), String.valueOf(mCheckListStepAttributeItems.getMaxLength() != null ? String.format(getString(R.string.min_required), String.valueOf(mCheckListStepAttributeItems.getMaxLength())) : "")));
            else {
                if (TextUtils.isEmpty(mAttributeValue) || !mAttributeValue.equalsIgnoreCase(etInput.getText().toString().trim())) {
                    mAttributeValue = etInput.getText().toString().trim();
                    mViewModel.executeStepAttribute(etInput.getText().toString().trim(), LogTableActions.OTHER_THAN_FILE.getValue(), position);
                }
                etInput.setFocusableInTouchMode(false);
                etInput.clearFocus();
                onAttributeValuesSaved();
            }
        } else {
            if ((SPFragment) getParentFragment() != null)
                ((SPFragment) getParentFragment()).checkIfStepValidToComplete();
            Utilities.getInstance(getActivity()).closeKeyboard(binding.getRoot(), getActivity());
            if (textInputLayout != null)
                textInputLayout.setError(null);
        }


    }

    private void onAttributeValuesSaved() {
        binding.btnSubmit.setVisibility(View.INVISIBLE);
        binding.editAttribute.setVisibility(View.VISIBLE);
        isEditable = false;
        if ((SPFragment) getParentFragment() != null)
            ((SPFragment) getParentFragment()).checkIfStepValidToComplete();
        Utilities.getInstance(getActivity()).closeKeyboard(binding.getRoot(), getActivity());
        if (textInputLayout != null)
            textInputLayout.setError(null);
    }

    /**
     * Shows the edit text for user input
     *
     * @param inputType Number or text
     */
    private void setUserInput(int inputType, String value) {
        int margin = (int) (10 * getResources().getDisplayMetrics().density);
        etInput = new TextInputEditText(binding.linear.getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(margin, margin, margin, margin);
        textInputLayout = new TextInputLayout(binding.linear.getContext());
        textInputLayout.setErrorTextAppearance(R.style.MyErrorText);
        textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        textInputLayout.setBoxCornerRadii(10, 10, 10, 10);
        etInput.setId(0);
        etInput.setInputType(inputType);
        etInput.setImeOptions(EditorInfo.IME_ACTION_DONE);
        if (InputType.TYPE_CLASS_TEXT == inputType) {
            textInputLayout.setLayoutParams(params);
            etInput.setLayoutParams(params);
            etInput.setSingleLine(false);
            etInput.setMaxLines(6);
        } else {
            LinearLayout.LayoutParams paramsNumberInput = new LinearLayout.LayoutParams(350, ViewGroup.LayoutParams.WRAP_CONTENT);
            paramsNumberInput.setMargins(margin, margin, margin, margin);
            textInputLayout.setLayoutParams(paramsNumberInput);
            etInput.setLayoutParams(paramsNumberInput);
        }

        etInput.setTextColor(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        etInput.setTextSize(17f);
        if (value != null && !value.trim().isEmpty()) {
            etInput.setText(value);
            etInput.setFocusableInTouchMode(false);
            mViewModel.setButtonVisible(false);
            binding.btnSubmit.setVisibility(View.INVISIBLE);
            if ((mViewModel.getChecklistElementDetail().isSkipped() || mViewModel.getChecklistElementDetail().isDeferred()) || !mViewModel.isStepExecuted())
                binding.editAttribute.setVisibility(View.VISIBLE);
            else
                binding.editAttribute.setVisibility(View.INVISIBLE);

        } else {
            etInput.setFocusableInTouchMode(true);
            mViewModel.setButtonVisible(true);
        }
        binding.editAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setFocusableInTouchMode(true);
                v.setVisibility(View.INVISIBLE);
                isEditable = true;
                binding.btnSubmit.setVisibility(View.VISIBLE);
            }
        });

        etInput.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (etInput.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_SCROLL:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            return true;
                    }
                }
                return false;
            }
        });

//        etInput.setBackgroundResource(R.drawable.edit_text_single_line_background);
        textInputLayout.addView(etInput, params);
        binding.linear.addView(textInputLayout);
    }

    /**
     * Shows the date picker with default current date
     *
     * @param attributeValue Saved value for attribute, is null if not submitted yet
     */
    private void setDatePicker(String attributeValue) {
        int margin = (int) (10 * getResources().getDisplayMetrics().density);
        tvDate = new TextView(binding.linear.getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(margin, margin, margin, margin);
        tvDate.setLayoutParams(params);
        tvDate.setId(0);
        tvDate.setTextColor(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        tvDate.setTextSize(17f);
        tvDate.setBackgroundResource(R.drawable.rectangle_gray);
        tvDate.setCompoundDrawablesWithIntrinsicBounds(null, null, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_choose_date, null), null);
        tvDate.setCompoundDrawablePadding(margin);
        binding.linear.addView(tvDate);
        binding.executePendingBindings();
        setDatePickerDialog();
        if (attributeValue != null && !attributeValue.trim().isEmpty()) {
            tvDate.setText(AppUtility.Companion.parseDateToddMMyyyy(attributeValue));
            tvDate.setClickable(false);
            mViewModel.setButtonVisible(false);
            binding.btnSubmit.setVisibility(View.INVISIBLE);
            if ((mViewModel.getChecklistElementDetail().isSkipped() || mViewModel.getChecklistElementDetail().isDeferred()) || !mViewModel.isStepExecuted())
                binding.editAttribute.setVisibility(View.VISIBLE);
            else
                binding.editAttribute.setVisibility(View.INVISIBLE);
        } else {
            tvDate.setClickable(true);
            mViewModel.setButtonVisible(true);
        }

        binding.editAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDate.setClickable(true);
                v.setVisibility(View.INVISIBLE);
                isEditable = true;
                binding.btnSubmit.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * Sets the date picker with default current date
     */
    private void setDatePickerDialog() {
        final Calendar myCalendar = Calendar.getInstance();
        String myFormat = "MMM dd, yyyy";
        final SimpleDateFormat sdfDay = new SimpleDateFormat(myFormat, Locale.getDefault());
        final DatePickerDialog.OnDateSetListener dateForDueDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                tvDate.setText(sdfDay.format(myCalendar.getTime()));
            }

        };

        tvDate.setText(getString(R.string.select_date));
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int datePickerThemeResId = 0;
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    datePickerThemeResId = android.R.style.Theme_Material_Light_Dialog;
                }
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), datePickerThemeResId, dateForDueDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.show();
            }
        });
    }

    /**
     * Sets the Check box for list attribute
     *
     * @param attributeValue Saved value for attribute, is null if not submitted yet
     */
    private void setCheckbox(String attributeValue) {
        List<String> selectedList = null;
        if (mCheckListStepAttributeItems.getPossibleValues() != null)
            labelList = Arrays.asList(mCheckListStepAttributeItems.getPossibleValues().split(","));

        if (attributeValue != null && !attributeValue.trim().isEmpty()) {
            selectedList = Arrays.asList(attributeValue.split(", "));
            binding.btnSubmit.setVisibility(View.INVISIBLE);

            if ((mViewModel.getChecklistElementDetail().isSkipped() || mViewModel.getChecklistElementDetail().isDeferred()) || !mViewModel.isStepExecuted())
                binding.editAttribute.setVisibility(View.VISIBLE);
            else
                binding.editAttribute.setVisibility(View.INVISIBLE);
        }

        int margin = (int) (5 * getResources().getDisplayMetrics().density);
        if (labelList != null)
            for (int i = 0; labelList.size() > i; i++) {
                CheckBox checkBox = new CheckBox(binding.linear.getContext());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(margin, margin, margin, margin);
                checkBox.setLayoutParams(params);
                checkBox.setTag(i);
                checkBox.setText(labelList.get(i));
                checkBox.setTextColor(getResources().getColor(R.color.black));
                checkBox.setId(i);
                checkBox.setTag(labelList.get(i));

                //Disable check change if value submitted
                if (attributeValue != null && !attributeValue.trim().isEmpty())
                    checkBox.setEnabled(false);

                if (selectedList != null && selectedList.size() > 0 && selectedList.contains(labelList.get(i))) {
                    checkBox.setChecked(true);
                }

                checkBox.setOnCheckedChangeListener(this);
                binding.linear.addView(checkBox);
            }

        binding.editAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (labelList != null)
                    for (int i = 0; labelList.size() > i; i++) {
                        ((CheckBox) binding.getRoot().findViewById(i)).setEnabled(true);
                    }
                v.setVisibility(View.INVISIBLE);
                isEditable = true;
                binding.btnSubmit.setVisibility(View.VISIBLE);
            }
        });

        binding.executePendingBindings();
    }

    /**
     * Sets the radio button for list attribute
     *
     * @param attributeValue Saved value for attribute, is null if not submitted yet
     */
    private void setRadioGroup(String attributeValue) {
        int margin = (int) (5 * getResources().getDisplayMetrics().density);
        mRadioGroup = new RadioGroup(binding.linear.getContext());
        LinearLayout.LayoutParams paramsGroup = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        paramsGroup.setMargins(margin, margin, margin, margin);
        mRadioGroup.setLayoutParams(paramsGroup);

        List<String> selectedList = null;
        if (attributeValue != null && !attributeValue.trim().isEmpty()) {
            selectedList = Arrays.asList(attributeValue.split(", "));
            if ((mViewModel.getChecklistElementDetail().isSkipped() || mViewModel.getChecklistElementDetail().isDeferred()) || !mViewModel.isStepExecuted())
                binding.editAttribute.setVisibility(View.VISIBLE);
            else
                binding.editAttribute.setVisibility(View.INVISIBLE);
            //Hide submit button if attribute submitted
            binding.btnSubmit.setVisibility(View.INVISIBLE);
        }

        if (!TextUtils.isEmpty(mCheckListStepAttributeItems.getPossibleValues()))
            labelList = Arrays.asList(mCheckListStepAttributeItems.getPossibleValues().split(","));
        else {
            labelList = new ArrayList<>();
            labelList.add(getString(R.string.yes));
            labelList.add(getString(R.string.no));
        }

        for (int i = 0; i < labelList.size(); i++) {
            RadioButton radioButton = new RadioButton(binding.linear.getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(margin, margin, margin, margin);
            radioButton.setLayoutParams(params);
            radioButton.setTag(labelList.get(i));
            radioButton.setBackgroundResource(R.drawable.radio_background);
            radioButton.setText(labelList.get(i));
            radioButton.setTextColor(getResources().getColor(R.color.black));
            radioButton.setId(i);

            if (selectedList != null && selectedList.size() > 0 && selectedList.contains(labelList.get(i))) {
                radioButton.setChecked(true);
            }

            if (selectedList != null && selectedList.size() > 0) {
                radioButton.setEnabled(false);
            }

            if (mCheckListStepAttributeItems.getMultiple() != null && mCheckListStepAttributeItems.getMultiple() == 1) {
                binding.linear.addView(radioButton);
                // radioButton.setOnCheckedChangeListener(this);
            } else
                mRadioGroup.addView(radioButton);
        }

        //Add radio group if multiple selection disabled
        if (mCheckListStepAttributeItems.getMultiple() != null && mCheckListStepAttributeItems.getMultiple() == 0)
            binding.linear.addView(mRadioGroup);
        binding.executePendingBindings();

        binding.editAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; labelList.size() > i; i++)
                    ((RadioButton) binding.getRoot().findViewById(i)).setEnabled(true);
                v.setVisibility(View.INVISIBLE);
                mRadioGroup.setEnabled(true);
                isEditable = true;
                binding.btnSubmit.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isSelected) {
        if (mCheckListStepAttributeItems.getMultiple() != null && mCheckListStepAttributeItems.getMultiple() == 0) {
            for (int i = 0; labelList.size() > i; i++) {
                if (mCheckListStepAttributeItems.getDisplayAs().equalsIgnoreCase(AttributeType.CHECKBOX.toString()))
                    ((CheckBox) binding.getRoot().findViewById(i)).setChecked(false);
            }
        }
        compoundButton.setChecked(isSelected);

    }

    private void showErrorMessage(String msg) {
        Utilities.getInstance(getActivity()).showToast(msg, Toast.LENGTH_LONG, getActivity());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit:
                checkAndSaveInputFields(mCheckListStepAttributeItems.getType());
                break;
        }
    }

    private void askToOpenWorkOrder(String message) {
        isWorkOrderCreateAsked = true;
        DialogUtility.showAlertWithTwoButtonsOnly(getActivity(), String.format(message, getString(R.string.ask_create_work_order)), R.string.create_work_order, R.string.cancel, new OnSelectListener() {
            @Override
            public void onPositiveButtonClick() {
                ChecklistIDetailtems checklistDetailItem = mViewModel.getChecklistIDetailtems();
                Navigator.launchActivity(getActivity(), WorkOrderCreateActivity.getInstance(getActivity(), checklistDetailItem.getTitle(), checklistDetailItem.getChecklistId(), checklistDetailItem.getRoomId(), checklistDetailItem.getEquipmentId()));
            }

            @Override
            public void onNegativeButtonClick() {

            }
        });
    }

    private String getLabel() {
        String defaultValue = getString(R.string.select_user);
        if (mCheckListStepAttributeItems.getMultiple() != null && mCheckListStepAttributeItems.getMultiple() == 1)
            defaultValue = getString(R.string.select_users);
        return defaultValue;
    }

    public void updateSequenceNumber(int sequenceNumber) {
        binding.setAttributeNo(sequenceNumber + 1);
        binding.executePendingBindings();
    }
}


