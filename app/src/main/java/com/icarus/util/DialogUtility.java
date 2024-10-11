package com.icarus.util;

import com.icarus.R;
import com.icarus.adapters.AssignUserAdapter;
import com.icarus.adapters.ReferenceLinksAdapter;
import com.icarus.adapters.ReferencesAdapter;
import com.icarus.base.BaseApplication;
import com.icarus.databinding.PopUpVerifyRoomAssetBinding;
import com.icarus.databinding.PopupListBinding;
import com.icarus.databinding.PopupReferencesBinding;
import com.icarus.databinding.PopupSuggestionBinding;
import com.icarus.databinding.PopupWithEditBoxBinding;
import com.icarus.entities.ResourceEntity;
import com.icarus.enums.ChecklistType;
import com.icarus.listeners.OnAssignUserChecklist;
import com.icarus.listeners.OnReason;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.AllChecklistItems;
import com.icarus.models.ResourceLinkItems;
import com.icarus.models.RoomAssetItems;
import com.icarus.models.UserItems;
import com.icarus.navigators.ChecklistExecutionNavigator;
import com.icarus.navigators.DashboardNavigator;
import com.icarus.viewmodels.ReasonPopUpViewModel;
import com.icarus.widget.viewmodel.GalleryViewModel;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Monika Rana on 1/10/2019.
 */

public class DialogUtility {
    public static void showAlertWithCloseOnly(Context context, String message, int title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(message).setCancelable(false);
        if (title > 0) {
            builder.setTitle(title);
        }
        builder.setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
    }

    public static void showAlertOnly(Context context, String message, int actionText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(message).setCancelable(false);
        builder.setPositiveButton(actionText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
    }

    public static AlertDialog showAlertWithTwoButtonsOnly(Context context, String message, int btnTxtPositive, int btnTxtNegative, final OnSelectListener onSelectListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(message).setCancelable(false);
        /*if (title > 0) {
            builder.setTitle(title);
        }*/
        builder.setNegativeButton(btnTxtNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onSelectListener.onNegativeButtonClick();
                dialogInterface.dismiss();
            }
        });

        builder.setPositiveButton(btnTxtPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onSelectListener.onPositiveButtonClick();
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
        return dialog;
    }

    public static AlertDialog showAlertWithOneButtonsOnly(Context context, String message, int btnTxt, final OnSelectListener onSelectListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(message).setCancelable(false);
        /*if (title > 0) {
            builder.setTitle(title);
        }*/

        builder.setPositiveButton(btnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onSelectListener.onPositiveButtonClick();
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
        return dialog;
    }

    public static <T> void showAlertWithCloseContinueOnly(Context context, String message, int title, final DashboardNavigator listener, final T item, String action) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(message).setCancelable(false);
        if (title > 0) {
            builder.setTitle(title);
        }
        builder.setPositiveButton(action, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                listener.continueChecklist(item);
            }
        });

        builder.setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
    }

    public static <T> void showAlertWithCloseAssignOnly(final Context context, String message, int title, final DashboardNavigator listner, final T item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(message).setCancelable(false);
        if (title > 0) {
            builder.setTitle(title);
        }
        builder.setPositiveButton(R.string.continue_string, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listner.continueChecklist(item);
                dialogInterface.dismiss();

            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
    }

    public static void showAlertWithStartAssign(Context context, String message, int title, final DashboardNavigator listner, final AllChecklistItems item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setCancelable(false);
        if (!TextUtils.isEmpty(message)) {
            builder.setMessage(message);
        }
        builder.setCancelable(false);
        if (title > 0) {
            builder.setTitle(title);
        }
        builder.setPositiveButton(R.string.assign, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                listner.assignChecklist(item);
            }
        });

        builder.setNegativeButton(R.string.start, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                listner.startChecklist(item);
            }
        });

        builder.setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
    }

    public static void showAlertForEmergencyStart(Context context, int message, int title, final DashboardNavigator listner, final AllChecklistItems item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if (message > 0) {
            builder.setMessage(message);
        }
        builder.setCancelable(false);
        if (title > 0) {
            builder.setTitle(title);
        }
        builder.setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                listner.startChecklist(item);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
    }

    public static void startChecklistDialog(final Context context, int message, final DashboardNavigator listener, final Integer checklistTypeId, final int checklistId, final int departmentId, final String checklistTitle, final List<RoomAssetItems> roomAssetItems, final List<UserItems> userItems, final String uuid, final int isSequential) {
        String locationTimeZone = BaseApplication.getPreferenceManager().getUserLocationTimeZone();
        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTimeZone(TimeZone.getTimeZone(locationTimeZone));
        myCalendar.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
        String myFormat = "dd MMM, yyyy";
        final SimpleDateFormat sdfDay = new SimpleDateFormat(myFormat, Locale.getDefault());
        sdfDay.setTimeZone(TimeZone.getTimeZone(locationTimeZone));
        Integer loggedInUserId = BaseApplication.getPreferenceManager().getUserId();
        //Check if checklist type is emergency and there are not any room assets than open checklist detail
        if (checklistTypeId == ChecklistType.Emergency.getValue() && (roomAssetItems == null
                || roomAssetItems.size() == 0)) {
            listener.continueChecklist(userItems, checklistId, departmentId, checklistTitle,
                    null, null, true, uuid,
                    isSequential);
            return;
        }

        final boolean isStart = R.string.start_checklist == message;
        //Inflate the dialog with custom view
        View mDialogView = LayoutInflater.from(context).inflate(R.layout.popup_start_checklist, null);
        //AlertDialogBuilder
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(mDialogView);

        TextView tvStartChecklist = mDialogView.findViewById(R.id.tvStartChecklist);
        final TextView spnAssign = mDialogView.findViewById(R.id.spnAssign);
        final Spinner spnRoomAssets = mDialogView.findViewById(R.id.spinnerRoomAssets);
        TextView tvAssign = mDialogView.findViewById(R.id.tvAssign);
        TextView tvRoomAssets = mDialogView.findViewById(R.id.tvRoomAssets);
        TextView cancel = mDialogView.findViewById(R.id.cancel);
        final TextView tvDueDateText = mDialogView.findViewById(R.id.tvDueDateText);
        final TextView tvDueDate = mDialogView.findViewById(R.id.tvDueDate);
        TextView done = mDialogView.findViewById(R.id.done);

        if (isStart)
            done.setText(R.string.start);
        else {
            spnAssign.setCompoundDrawablesWithIntrinsicBounds(null, null, ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_drop_down_arrow, context.getTheme()), null);
            done.setText(R.string.assign);
        }

        //show dialog
        final AlertDialog mAlertDialog = mBuilder.create();
        tvStartChecklist.setText(message);

        //Check is user list exist for this checklist and shows it
        if (userItems != null && userItems.size() > 0) {

            for (UserItems userItem : userItems) {
                userItem.setSelected(loggedInUserId.equals(userItem.getId()));
            }
            spnAssign.setText(context.getString(R.string.select_users));
            spnAssign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUtility.showAssignChecklistDialog(userItems, context, new OnAssignUserChecklist() {
                        @Override
                        public void assignUserChecklist(List<UserItems> userItemsList) {
                            //listner
                            userItems.clear();
                            userItems.addAll(userItemsList);
                            spnAssign.setText(Utilities.getCommaSeparatedUserNames(userItemsList, context.getString(R.string.select_users)));

                        }

                        @Override
                        public void cancelAssign() {
                            //Do Nothing
                        }
                    });
                }
            });
            spnAssign.setText(BaseApplication.getPreferenceManager().getUserFullName());
            if (isStart) {
                spnAssign.setEnabled(false);
            }
        } else {
            //hiding title and assign text if users not available
            spnAssign.setVisibility(View.GONE);
            tvAssign.setVisibility(View.GONE);
        }

        if (roomAssetItems != null && roomAssetItems.size() > 0) {
            tvRoomAssets.setText(String.format(context.getString(R.string.room_asset_x_x),
                    BaseApplication.getPreferenceManager().getRoomName(), BaseApplication.getPreferenceManager().getAssetName()));
            List<String> items = AppUtility.Companion.getTitleList(roomAssetItems);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.
                    layout.view_simple_spinner_item, items);
            spnRoomAssets.setAdapter(adapter);
        } else {
            spnRoomAssets.setVisibility(View.GONE);
            tvRoomAssets.setVisibility(View.GONE);
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAlertDialog.dismiss();
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(spnAssign.getText().toString())
                        || spnAssign.getText().toString().equals(context.getString(R.string.select_users))) {

                } else if (TextUtils.isEmpty(tvDueDateText.toString())) {

                } else {
                    mAlertDialog.dismiss();
                    RoomAssetItems roomAsset;
                    if (roomAssetItems != null && roomAssetItems.size() > 0) {
                        roomAsset = roomAssetItems.get(spnRoomAssets.getSelectedItemPosition());
                    } else {
                        roomAsset = null;
                    }
                    String dueDate = null;
                    if (checklistTypeId != ChecklistType.Emergency.getValue()) {
                        dueDate = tvDueDateText.getText().toString();
                    }
                    listener.continueChecklist(userItems, checklistId, departmentId, checklistTitle,
                            roomAsset, dueDate, isStart, uuid,
                            isSequential);
                }
            }
        });


        final DatePickerDialog.OnDateSetListener dateForDueDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                tvDueDateText.setText(sdfDay.format(myCalendar.getTime()));
            }

        };
        tvDueDateText.setText(sdfDay.format(myCalendar.getTime()));

        final Calendar calenderCurrentTime = Calendar.getInstance();
        calenderCurrentTime.setTimeZone(TimeZone.getTimeZone(locationTimeZone));
        calenderCurrentTime.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
        tvDueDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int datePickerThemeResId = 0;
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    datePickerThemeResId = android.R.style.Theme_Material_Light_Dialog;
                }
                //Set calender time zone of the location selected
                DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                        datePickerThemeResId, dateForDueDate, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(calenderCurrentTime.getTimeInMillis());
                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.show();

            }
        });

        if (checklistTypeId == ChecklistType.Emergency.getValue()) {
            tvDueDateText.setVisibility(View.GONE);
            tvDueDate.setVisibility(View.GONE);
        }


        mAlertDialog.show();
    }


    public static void showAssignChecklistDialog(List<UserItems> userItems, Context context,
                                                 final OnAssignUserChecklist listner) {
        //Inflate the dialog with custom view
        PopupListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.popup_list, null, false);
        //AlertDialogBuilder
        List<UserItems> userItemsTemp = new ArrayList<>();
        for (UserItems item : userItems)
            userItemsTemp.add(new UserItems().getItem(item.getFullName(), item.getId(),
                    item.getGroupId(),
                    item.getUuid(), item.getAssignedChecklistUuid(), item.isSelected(),
                    item.getRole()));

        final AssignUserAdapter adapter = new AssignUserAdapter(context, userItemsTemp);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(binding.getRoot())
                .setPositiveButton(context.getString(R.string.assign),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listner.assignUserChecklist(adapter.getUserItemsSelectedList());
                                dialogInterface.dismiss();
                            }
                        })
                .setNegativeButton(context.getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.dismiss();
                            }
                        });
        mBuilder.setCancelable(false);

        binding.recyclerViewImages.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerViewImages.setAdapter(adapter);
        binding.tvTitle.setText(R.string.assign);
        binding.tvDesc.setVisibility(View.GONE);
        final AlertDialog mAlertDialog = mBuilder.create();
        mAlertDialog.show();
    }

    public static void getReasonPopup(final Context context, String title, String message, final OnReason listener, final int validateLength, final ReasonPopUpViewModel viewModel) {
        //Inflate the dialog with custom view
        final PopupWithEditBoxBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.popup_with_edit_box, null, false);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(binding.getRoot());
        mBuilder.setCancelable(false);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
        final AlertDialog mAlertDialog = mBuilder.create();
        //show dialog
        mAlertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        mAlertDialog.show();

        binding.etReason.requestFocus();
        binding.tvTitle.setText(title);
        binding.tvSubTitle.setText(message);

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCancel();
                mAlertDialog.dismiss();
            }
        });
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = viewModel.validateReason(validateLength);
                if (error.isEmpty()) {
                    listener.onContinue(viewModel.getTxtReason().get().trim(), context);
                    mAlertDialog.dismiss();
                } else {
                    binding.txtInputReason.setError(error);
                }
            }
        });

    }

    public static AlertDialog showReferencePopUp(final Context context, List<ResourceEntity> resourceList, List<ResourceLinkItems> resourceLinkList, final ChecklistExecutionNavigator navigator) {
        //Inflate the dialog with custom view
        PopupReferencesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.popup_references, null, false);
        //AlertDialogBuilder
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(binding.getRoot()).setView(binding.getRoot())
                .setPositiveButton(context.getString(R.string.close), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        navigator.onReferenceDialogCanceled();
                        dialogInterface.dismiss();
                    }
                });
        mBuilder.setCancelable(false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL);

        binding.recyclerView.addItemDecoration(dividerItemDecoration);
        binding.setAdapter(new ReferencesAdapter(context, resourceList, navigator));
        if (resourceList != null && resourceList.size() > 0) {
            binding.recyclerView.setVisibility(View.VISIBLE);
        }

        binding.recyclerViewLinks.addItemDecoration(dividerItemDecoration);
        binding.setLinksAdapter(new ReferenceLinksAdapter(context, resourceLinkList));
        if (resourceLinkList != null && resourceLinkList.size() > 0) {
            binding.recyclerViewLinks.setVisibility(View.VISIBLE);
        }

        binding.executePendingBindings();
        final AlertDialog mAlertDialog = mBuilder.create();

        mAlertDialog.show();
        return mAlertDialog;
    }

    public static void showListPopUp(final Context context, int title, int message, RecyclerView.Adapter<?> adapter) {
        //Inflate the dialog with custom view
        PopupListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.popup_list, null, false);
        //AlertDialogBuilder
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(binding.getRoot())
                .setPositiveButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        mBuilder.setCancelable(false);
        binding.recyclerViewImages.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerViewImages.setAdapter(adapter);
        binding.tvTitle.setText(title);
        if (adapter.getItemCount() == 0)
            binding.tvDesc.setText(context.getString(R.string.no_results_found));
        else if (message == -1)
            binding.tvDesc.setVisibility(View.GONE);
        else
            binding.tvDesc.setText(message);
        final AlertDialog mAlertDialog = mBuilder.create();
        mAlertDialog.show();
    }


    public static void getSuggestionPopup(final Context context, final GalleryViewModel galleryViewModel, final OnReason suggestionListener) {
        final PopupSuggestionBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.popup_suggestion, null, false);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(binding.getRoot())
                .setPositiveButton(context.getString(R.string.submit), null)
                .setNegativeButton(context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        suggestionListener.onCancel();
                        dialogInterface.dismiss();
                    }
                });
        mBuilder.setCancelable(false);
        binding.setViewModel(galleryViewModel);
        binding.executePendingBindings();
        final AlertDialog mAlertDialog = mBuilder.create();
        mAlertDialog.show();

        mAlertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = galleryViewModel.validateSuggestion();
                if (error.isEmpty()) {
                    suggestionListener.onContinue(galleryViewModel.getTxtSuggestion().get().trim(), context);
                    mAlertDialog.dismiss();
                } else {
                    binding.etDescriptionView.setError(error);
                }
            }
        });
    }

    public static AlertDialog showAlertWithTwoButtonsOnly(Context context, String title,
                                                          String message,
                                                          int btnTxtPositive,
                                                          int btnTxtNegative,
                                                          final OnSelectListener onSelectListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(title);
        builder.setMessage(message).setCancelable(false);
        /*if (title > 0) {
            builder.setTitle(title);
        }*/
        builder.setNegativeButton(btnTxtNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onSelectListener.onNegativeButtonClick();
                dialogInterface.dismiss();
            }
        });

        builder.setPositiveButton(btnTxtPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onSelectListener.onPositiveButtonClick();
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        // Display the alert dialog on app interface
        dialog.show();
        return dialog;
    }


    public static void showAlertWithImage(Context context, int drawableId, final DialogInterface.OnCancelListener onCancelListener) {
        final PopUpVerifyRoomAssetBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.pop_up_verify_room_asset, null, false);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(binding.getRoot());
        mBuilder.setCancelable(true);

        binding.imgInstruction.setImageResource(drawableId);
        binding.executePendingBindings();
        final AlertDialog mAlertDialog = mBuilder.create();
        mAlertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mAlertDialog.show();

        mAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                onCancelListener.onCancel(dialog);
            }
        });

    }
}
