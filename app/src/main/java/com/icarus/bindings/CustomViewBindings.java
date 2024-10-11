package com.icarus.bindings;

import androidx.databinding.BindingAdapter;

import android.os.Build;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.icarus.R;
import com.icarus.adapters.IconsAdapter;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.customviews.DividerItemDecorator;
import com.icarus.databinding.NavHeaderBaseNavigationDrawerBinding;
import com.icarus.enums.ChecklistElementType;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.ChecklistStatus;
import com.icarus.enums.ChecklistType;
import com.icarus.enums.DueStatus;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.SelectedFile;
import com.icarus.util.AppUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.HtmlFormatter;
import com.icarus.util.ImageLoader;
import com.icarus.util.StringUtil;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.DashboardViewModel;
import com.icarus.widget.GalleryImageWidget;
import com.icarus.widget.viewmodel.GalleryViewModel;

import org.sufficientlysecure.htmltextview.HtmlFormatterBuilder;
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.List;

public class CustomViewBindings {
    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("favImage")
    public static void setImageResource(AppCompatImageView imageView, int isFav) {
        if (isFav == 1)
            imageView.setImageResource(R.mipmap.star);
        else
            imageView.setImageResource(R.mipmap.blank_star);
    }

    @BindingAdapter("setEmergencyLabel")
    public static void setDrawableStart(TextView textView, int checklistID) {
        if (checklistID == ChecklistType.Emergency.getValue()) {
            Utilities.setImageInTextView(textView.getContext(), R.drawable.ic_emergency_flag, textView.getText().toString(), textView);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            else
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }


    }

    @BindingAdapter("dueDate")
    public static void setText(TextView textView, String dueDate) {
        String dueDateText = "";
        if (!TextUtils.isEmpty(dueDate)) {
            int dueDays = Integer.parseInt(dueDate);
            if (dueDays == 0) {
                dueDateText = textView.getContext().getString(R.string.due_today);
            } else if (dueDays == 1) {
                dueDateText = textView.getContext().getString(R.string.due_tomorrow);
            } else if (dueDays == -1) {
                dueDateText = textView.getContext().getString(R.string.due_yesterday);
            } else if (dueDays < -1) {
                dueDateText = String.format(textView.getContext().getString(R.string.due_later), String.valueOf(Math.abs(dueDays)));
            } else if (dueDays > 1) {
                dueDateText = String.format(textView.getContext().getString(R.string.due_earlier), String.valueOf(Math.abs(dueDays)));
            } else {
                dueDateText = "";
            }
        }
        textView.setText(dueDateText);
    }


    @BindingAdapter("setDueDateColor")
    public static void setDueDateTextColor(TextView textView, int dueStatus) {
        if (dueStatus == DueStatus.OVERDUE.getValue()) {
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.emergency_color_error);
        } else if (dueStatus == DueStatus.NORMAL.getValue()) {
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.sub_title_text_color);
        } else if (dueStatus == DueStatus.DUE.getValue()) {
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.orange_color_picker);
        } else {
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.sub_title_text_color);
        }
    }

    @BindingAdapter("workOrderPriority")
    public static void setText(TextView textView, Integer workOrderPriorityId) {
        int priority = 0;
        if (workOrderPriorityId != null) {
            if (workOrderPriorityId == 1) {
                priority = R.string.urgent;
            } else if (workOrderPriorityId == 2) {
                priority = R.string.normal;
            } else if (workOrderPriorityId == 3) {
                priority = R.string.low;
            }
        }
        if (priority > 0) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(StringUtil.INSTANCE.toCamelCase(textView.getContext().getString(priority)));
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    @BindingAdapter({"dueDateBackground"})
    public static void setDueDateBackground(TextView textView, String workOrderStatus) {
        if (workOrderStatus.equals("New")) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.new_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.new_title_text_color);
        } else if (workOrderStatus.equals("In Progress")) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.in_progress_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.in_progress_title_text_color);
        } else if (workOrderStatus.equals("Completed")) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.paused_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.paused_title_text_color);
        } else if (workOrderStatus.equals("Closed")) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.paused_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.paused_title_text_color);
        } else if (workOrderStatus.equals("Re-opened")) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.paused_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.paused_title_text_color);
        } else if (workOrderStatus.equals("Canceled")) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.paused_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.paused_title_text_color);
        } else if (workOrderStatus.equals("Deleted")) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.paused_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.paused_title_text_color);
        }
    }

    @BindingAdapter({"roomEquipmentBackground"})
    public static void setBackground(TextView textView, String checkListStatus) {
        if (checkListStatus != null && checkListStatus.equalsIgnoreCase(textView.getContext().getString(R.string.new_string))) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.new_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.new_title_text_color);
        } else if (checkListStatus != null && checkListStatus.equalsIgnoreCase(textView.getContext().getString(R.string.paused))) {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.paused_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.paused_title_text_color);
        } else {
            AppUtility.Companion.setBackgroundDrawable(textView.getContext(), textView, R.drawable.in_progress_background);
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.in_progress_title_text_color);
        }
    }

    @BindingAdapter({"setHTML"})
    public static void setHTMLText(TextView textView, String title) {
        if (!TextUtils.isEmpty(title))
            textView.setText(Html.fromHtml(title));
    }

    @BindingAdapter({"setAcknowledged"})
    public static void setAcknowledgedIcon(AppCompatImageView imageView, ChecklistDetailItems item) {
        imageView.setVisibility(View.INVISIBLE);
        int status = -1;
        if (item == null)
            return;
        else if (((item.getItemTypeId() == ChecklistElementType.NOTE.getValue() || item.getItemTypeId() == ChecklistElementType.CAUTION.getValue() || item.getItemTypeId() == ChecklistElementType.WARNING.getValue())) && item.getAcknowledged() != null) {
            status = item.getAcknowledged();
        } else if ((item.getItemTypeId() == ChecklistElementType.STEP.getValue() || item.getItemTypeId() == ChecklistElementType.PROCEDURE.getValue() || item.getItemTypeId() == ChecklistElementType.DATA_STEP.getValue()) && item.getStatus() != null) {
            status = item.getStatus();
        } else if (item.getItemTypeId() == ChecklistElementType.DECISION.getValue() && item.getDecisionStatus() != null)
            status = item.getDecisionStatus();
        else if (item.getItemTypeId() == ChecklistElementType.RESOURCE.getValue() && item.getImageTextStatus() != null)
            status = item.getImageTextStatus();
        else if (item.getItemTypeId() == ChecklistElementType.TEXT.getValue() && item.getImageTextStatus() != null)
            status = item.getImageTextStatus();

        if (status == -1)
            imageView.setVisibility(View.INVISIBLE);
        else if (status == ChecklistExecutionStatus.SKIPPED.getValue()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_skip_next);
        } else if (item.getItemTypeId() == ChecklistElementType.DECISION.getValue() && item.getDecisionStatus() == ChecklistExecutionStatus.NO.getValue()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_check);
        } else if (status == ChecklistExecutionStatus.PENDING.getValue()) {
            imageView.setVisibility(View.INVISIBLE);
        } else if (status == ChecklistExecutionStatus.DEFERRED.getValue()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_deferr);
        } else {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_check);
        }

    }

    @BindingAdapter({"setAcknowledged"})
    public static void setAcknowledgedIcon(AppCompatImageView imageView, ChecklistElementItem item) {
        if (imageView == null) {
            return;
        }

        imageView.setVisibility(View.VISIBLE);

        if (item == null) {
            imageView.setVisibility(View.INVISIBLE);
            return;
        }

        if (item.checkElementIfExecuted()) {
            imageView.setImageResource(R.drawable.ic_check);
            return;
        }

        if (item.isSkipped()) {
            imageView.setImageResource(R.drawable.ic_skip_next);
            return;
        }

        if (item.isDeferred()) {
            imageView.setImageResource(R.drawable.ic_deferr);
            return;
        }

        imageView.setVisibility(View.INVISIBLE);
    }

    @BindingAdapter("app:bind_item")
    public static void setContent(GalleryImageWidget widget, GalleryViewModel item) {
        if (item != null)
            widget.setItem(item);
    }

    @BindingAdapter("app:errorText")
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }

    @BindingAdapter({"selectedFile"})
    public static void setThumbnail(AppCompatImageView imageView, SelectedFile selectedFile) {
        if (selectedFile != null)
            BaseApplication.getImageLoader().loadDownloadableImage(FileUtils.getFileFromName(selectedFile.getFilePath(), Constants.RESOURCES), imageView);
    }

    @BindingAdapter({"name", "folderName", "itemUUID", "isResource"})
    public static void setResourcesImage(AppCompatImageView imageView, String name, String folderName, String itemUUID, boolean isResource) {
        if (name != null && !name.trim().isEmpty() && isResource)
            BaseApplication.getImageLoader().loadImage(FileUtils.getFileFromName(name, Constants.RESOURCES), imageView, ImageLoader.ImageType.Resource, itemUUID);
    }

    @BindingAdapter({"showResourceEntity"})
    public static void setResourcesImage(AppCompatImageView imageView, ChecklistDetailItems checklistDetailItem) {
        if (checklistDetailItem != null && checklistDetailItem.isResource() && !TextUtils.isEmpty(checklistDetailItem.getFileName()))
            BaseApplication.getImageLoader().loadOrSaveResourceImage(imageView, FileUtils.getFileFromName(checklistDetailItem.getFileName(),
                    Constants.RESOURCES), ImageLoader.ImageType.Resource,
                    checklistDetailItem.getItemUuid(), checklistDetailItem.getTitle());
    }

    @BindingAdapter({"showEmbeddedImage"})
    public static void setEmbeddedImage(AppCompatImageView imageView, ChecklistElementItem checklistDetailItem) {
        if (checklistDetailItem != null && checklistDetailItem.isResource() && !TextUtils.isEmpty(checklistDetailItem.getFileName()))
            BaseApplication.getImageLoader().loadOrSaveResourceImage(imageView, FileUtils.getFileFromName(checklistDetailItem.getFileName(),
                    Constants.RESOURCES), ImageLoader.ImageType.Resource,
                    checklistDetailItem.getItemUuid(), checklistDetailItem.getTitle());
    }


    @BindingAdapter({"name", "folderName", "itemUUID", "imageType"})
    public static void setResourcesThumbnail(AppCompatImageView imageView, String name, String folderName, String itemUUID, ImageLoader.ImageType imageType) {
        if (name != null && !name.trim().isEmpty())
            BaseApplication.getImageLoader().loadImage(FileUtils.getFileFromName(name, folderName), imageView, imageType, itemUUID);
    }

    @BindingAdapter({"ppe", "hazards", "itemUUID"})
    public static void setEquipmentList(RecyclerView recyclerView, List<String> ppe, List<String> hazards, String itemUUID) {
        // recyclerView.setVisibility(View.VISIBLE);
        if (recyclerView.getLayoutManager() == null) {
            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(recyclerView.getContext());
            layoutManager.setFlexWrap(FlexWrap.WRAP);
            layoutManager.setJustifyContent(JustifyContent.FLEX_START);
            layoutManager.setFlexDirection(FlexDirection.ROW);
            //layoutManager.mar
            recyclerView.setLayoutManager(layoutManager);
        }
        if (ppe != null && ppe.size() > 0)
            recyclerView.setAdapter(new IconsAdapter(recyclerView.getContext(), ppe, ppe.size(), Constants.RESOURCES_PPE, R.string.ppe_icons, itemUUID));
        else if (hazards != null && hazards.size() > 0)
            recyclerView.setAdapter(new IconsAdapter(recyclerView.getContext(), hazards, hazards.size(), Constants.RESOURCES_HAZARDS, R.string.hazard_icons, itemUUID));
        else
            recyclerView.setVisibility(View.INVISIBLE);
    }


    @BindingAdapter("app:setItemDesc")
    public static void setItemDesc(TextView textView, String txt) {
        if (txt != null && !txt.isEmpty()) {
            textView.setText(Html.fromHtml(txt).toString().trim());
        }
    }

    @BindingAdapter("app:setCustomHTML")
    public static void setCustomHTML(HtmlTextView textView, String txt) {
        if (txt != null && !txt.isEmpty()) {
            textView.setHtml(txt, new HtmlHttpImageGetter(textView));
        }
    }

    @BindingAdapter("app:setCompactHtml")
    public static void setCompactHtml(TextView textView, String txt) {
        if (txt != null && !txt.isEmpty()) {
            Spanned formattedHtml = HtmlFormatter.formatHtml(new HtmlFormatterBuilder()
                    .setHtml(txt)
                    .setImageGetter(new HtmlHttpImageGetter(textView))
            );

            textView.setText(formattedHtml);
        }
    }

    @BindingAdapter("app:setChecklistTitleColor")
    public static void setChecklistTitleColor(AppCompatTextView textView, ChecklistStatus status) {
        if (status == null)
            status = ChecklistStatus.SYNCHRONIZED;
        switch (status) {
            case SYNCHRONIZED:
                AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.black);
                break;
            case NOT_SYNCHRONIZED:
                AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.not_synchronized_red);
                break;
            case RESOURCE_NOT_SYNCHRONIZED:
                AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.blue_text);
                break;
            default:
                break;
        }
    }

    @BindingAdapter("app:setAssignedChecklistTitleColor")
    public static void setAssignedChecklistTitleColor(AppCompatTextView textView, ChecklistStatus status) {
        if (status == null)
            status = ChecklistStatus.SYNCHRONIZED;
        switch (status) {
            case SYNCHRONIZED:
                AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.black);
                break;
            case NOT_SYNCHRONIZED:
                AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.not_synchronized_red);
                break;
            case RESOURCE_NOT_SYNCHRONIZED:
                AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.blue_text);
                break;
            case EXECUTED_CHECKLIST:
                AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.checklist_title_color);
                break;
            default:
                break;
        }
    }


    /**
     * This method sets the title for NCW element on checklist execution
     *
     * @param textView
     * @param items
     */
    @BindingAdapter("app:setNCWTitle")
    public static void setNCWTitle(AppCompatTextView textView, ChecklistDetailItems items) {
        if (items == null)
            return;
        textView.setVisibility(View.VISIBLE);
        if (items.getItemTypeId() == ChecklistElementType.NOTE.getValue()) {
            textView.setText(textView.getContext().getString(R.string.note).toUpperCase());
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.note_color);
            Utilities.setImageInTextView(textView.getContext(), R.drawable.ic_note, textView.getText().toString(), textView);
        } else if (items.getItemTypeId() == ChecklistElementType.CAUTION.getValue()) {
            textView.setText(textView.getContext().getString(R.string.caution));
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.caution_color);
            Utilities.setImageInTextView(textView.getContext(), R.drawable.ic_caution, textView.getText().toString(), textView);
        } else if (items.getItemTypeId() == ChecklistElementType.WARNING.getValue()) {
            textView.setText(textView.getContext().getString(R.string.warning));
            AppUtility.Companion.setTextColor(textView.getContext(), textView, R.color.warning_color);
            Utilities.setImageInTextView(textView.getContext(), R.drawable.ic_warning, textView.getText().toString(), textView);
        } else
            textView.setVisibility(View.GONE);
    }

    @BindingAdapter("app:setDecoratorAdapter")
    public static void setListItemDivider(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecorator(ContextCompat.getDrawable(recyclerView.getContext(), R.drawable.divider)));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("app:setNestedScrollListAdapter")
    public static void setListItems(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"bind:navigationmodel"})
    public static void loadHeader(NavigationView view, DashboardViewModel model) {
        NavHeaderBaseNavigationDrawerBinding binding = NavHeaderBaseNavigationDrawerBinding.inflate(LayoutInflater.from(view.getContext()));
        binding.setItem(model);
        binding.executePendingBindings();
        view.addHeaderView(binding.getRoot());
    }

}
