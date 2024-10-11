package com.icarus;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.icarus.databinding.ActivityAddNoteBindingImpl;
import com.icarus.databinding.ActivityAllCaptureDataBindingImpl;
import com.icarus.databinding.ActivityChecklistDetailBindingImpl;
import com.icarus.databinding.ActivityChecklistDetailListingBindingImpl;
import com.icarus.databinding.ActivityChecklistExecutionBindingImpl;
import com.icarus.databinding.ActivityChecklistReportBindingImpl;
import com.icarus.databinding.ActivityDashboardBindingImpl;
import com.icarus.databinding.ActivityLocationSelectionBindingImpl;
import com.icarus.databinding.ActivitySplashBindingImpl;
import com.icarus.databinding.ActivityTermsAndConditionsBindingImpl;
import com.icarus.databinding.ActivityWebviewBindingImpl;
import com.icarus.databinding.ActivityWorkOrderCompleteBindingImpl;
import com.icarus.databinding.ActivityWorkOrderCreateBindingImpl;
import com.icarus.databinding.ActivityWorkOrderDetailBindingImpl;
import com.icarus.databinding.ActivityWorkorderBindingImpl;
import com.icarus.databinding.AppBarBaseNavigationDrawerBindingImpl;
import com.icarus.databinding.BottomSheetFilterBindingImpl;
import com.icarus.databinding.BottomSheetSortBindingImpl;
import com.icarus.databinding.BottomSheetWorkorderFilterBindingImpl;
import com.icarus.databinding.BottomSheetWorkorderSortBindingImpl;
import com.icarus.databinding.ContentLocationSelectionBindingImpl;
import com.icarus.databinding.ContentTermsAndConditionsBindingImpl;
import com.icarus.databinding.DialogSyncingBindingImpl;
import com.icarus.databinding.FragmentBarcodeScannerBindingImpl;
import com.icarus.databinding.FragmentChecklistBindingImpl;
import com.icarus.databinding.FragmentChecklistDetailBindingImpl;
import com.icarus.databinding.FragmentDecisionExecutionBindingImpl;
import com.icarus.databinding.FragmentEmbeddedImageBindingImpl;
import com.icarus.databinding.FragmentLoginBindingImpl;
import com.icarus.databinding.FragmentNcwtrExecutionBindingImpl;
import com.icarus.databinding.FragmentPagerBindingImpl;
import com.icarus.databinding.FragmentPlaceholderCapturedValuesBindingImpl;
import com.icarus.databinding.FragmentProcedureRecordImageBindingImpl;
import com.icarus.databinding.FragmentQaVerifyBindingImpl;
import com.icarus.databinding.FragmentQrAttributeVerifyManuallyBindingImpl;
import com.icarus.databinding.FragmentQrScanAttributeBindingImpl;
import com.icarus.databinding.FragmentRecordDetailBindingImpl;
import com.icarus.databinding.FragmentScanQrCodeAttributeBindingImpl;
import com.icarus.databinding.FragmentScanQrCodeAttributeBindingLandImpl;
import com.icarus.databinding.FragmentScanQrCodeAttributeBindingLargeLandImpl;
import com.icarus.databinding.FragmentSearchSuggestionsBindingImpl;
import com.icarus.databinding.FragmentStepProcedureBindingImpl;
import com.icarus.databinding.FragmentWorkorderBindingImpl;
import com.icarus.databinding.FragmentWorkorderDetailBindingImpl;
import com.icarus.databinding.ItemAllCaptureDataAttributesBindingImpl;
import com.icarus.databinding.ItemAllCaptureDataAttributesShimmerBindingImpl;
import com.icarus.databinding.ItemAllCaptureDataElementsWithAttributesBindingImpl;
import com.icarus.databinding.ItemAllCaptureDataQrAttributesBindingImpl;
import com.icarus.databinding.ItemAllCapturedDataFilesBindingImpl;
import com.icarus.databinding.ItemAllChecklistBindingImpl;
import com.icarus.databinding.ItemAssignChecklistBindingImpl;
import com.icarus.databinding.ItemAssignedChecklistNoteBindingImpl;
import com.icarus.databinding.ItemAssignmentHistoryBindingImpl;
import com.icarus.databinding.ItemAttachmentBindingImpl;
import com.icarus.databinding.ItemCancelledCompletedBindingImpl;
import com.icarus.databinding.ItemChecklistDetailBindingImpl;
import com.icarus.databinding.ItemChecklistViewReportElementBindingImpl;
import com.icarus.databinding.ItemDepartmentChecklistBindingImpl;
import com.icarus.databinding.ItemEquipmentImageBindingImpl;
import com.icarus.databinding.ItemEquipmentsBindingImpl;
import com.icarus.databinding.ItemExecutionBottomBarBindingImpl;
import com.icarus.databinding.ItemFileRequiredBindingImpl;
import com.icarus.databinding.ItemIconsBindingImpl;
import com.icarus.databinding.ItemMyAssignedBindingImpl;
import com.icarus.databinding.ItemPagerImageAdapterBindingImpl;
import com.icarus.databinding.ItemPauseHistoryBindingImpl;
import com.icarus.databinding.ItemPendingElementsBindingImpl;
import com.icarus.databinding.ItemQrLogReportBindingImpl;
import com.icarus.databinding.ItemQrScanAttributeDetailBindingImpl;
import com.icarus.databinding.ItemReferenceResourceTitleBindingImpl;
import com.icarus.databinding.ItemReferenceTitleBindingImpl;
import com.icarus.databinding.ItemSearchLayoutBindingImpl;
import com.icarus.databinding.ItemSearchSuggestionBindingImpl;
import com.icarus.databinding.ItemViewMoreBindingImpl;
import com.icarus.databinding.ItemViewReportLogBindingImpl;
import com.icarus.databinding.ItemViewReportNoteBindingImpl;
import com.icarus.databinding.ItemWorkorderAttachmentBindingImpl;
import com.icarus.databinding.ItemWorkorderBindingImpl;
import com.icarus.databinding.ItemWorkorderDetailInfoBindingImpl;
import com.icarus.databinding.ItemWorkorderNoteInfoBindingImpl;
import com.icarus.databinding.NavHeaderBaseNavigationDrawerBindingImpl;
import com.icarus.databinding.PopUpVerifyRoomAssetBindingImpl;
import com.icarus.databinding.PopupListBindingImpl;
import com.icarus.databinding.PopupReferencesBindingImpl;
import com.icarus.databinding.PopupSuggestionBindingImpl;
import com.icarus.databinding.PopupWithEditBoxBindingImpl;
import com.icarus.databinding.StepExecutionFloatingMenuBindingImpl;
import com.icarus.databinding.StepExecutionFloatingMenuBindingLandImpl;
import com.icarus.databinding.StepExecutionFloatingMenuBindingLargeLandImpl;
import com.icarus.databinding.ViewItemWithCheckboxBindingImpl;
import com.icarus.databinding.ViewItemWorkorderWithCheckboxBindingImpl;
import com.icarus.databinding.WidgetGalleryBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDNOTE = 1;

  private static final int LAYOUT_ACTIVITYALLCAPTUREDATA = 2;

  private static final int LAYOUT_ACTIVITYCHECKLISTDETAIL = 3;

  private static final int LAYOUT_ACTIVITYCHECKLISTDETAILLISTING = 4;

  private static final int LAYOUT_ACTIVITYCHECKLISTEXECUTION = 5;

  private static final int LAYOUT_ACTIVITYCHECKLISTREPORT = 6;

  private static final int LAYOUT_ACTIVITYDASHBOARD = 7;

  private static final int LAYOUT_ACTIVITYLOCATIONSELECTION = 8;

  private static final int LAYOUT_ACTIVITYSPLASH = 9;

  private static final int LAYOUT_ACTIVITYTERMSANDCONDITIONS = 10;

  private static final int LAYOUT_ACTIVITYWEBVIEW = 11;

  private static final int LAYOUT_ACTIVITYWORKORDERCOMPLETE = 12;

  private static final int LAYOUT_ACTIVITYWORKORDERCREATE = 13;

  private static final int LAYOUT_ACTIVITYWORKORDERDETAIL = 14;

  private static final int LAYOUT_ACTIVITYWORKORDER = 15;

  private static final int LAYOUT_APPBARBASENAVIGATIONDRAWER = 16;

  private static final int LAYOUT_BOTTOMSHEETFILTER = 17;

  private static final int LAYOUT_BOTTOMSHEETSORT = 18;

  private static final int LAYOUT_BOTTOMSHEETWORKORDERFILTER = 19;

  private static final int LAYOUT_BOTTOMSHEETWORKORDERSORT = 20;

  private static final int LAYOUT_CONTENTLOCATIONSELECTION = 21;

  private static final int LAYOUT_CONTENTTERMSANDCONDITIONS = 22;

  private static final int LAYOUT_DIALOGSYNCING = 23;

  private static final int LAYOUT_FRAGMENTBARCODESCANNER = 24;

  private static final int LAYOUT_FRAGMENTCHECKLIST = 25;

  private static final int LAYOUT_FRAGMENTCHECKLISTDETAIL = 26;

  private static final int LAYOUT_FRAGMENTDECISIONEXECUTION = 27;

  private static final int LAYOUT_FRAGMENTEMBEDDEDIMAGE = 28;

  private static final int LAYOUT_FRAGMENTLOGIN = 29;

  private static final int LAYOUT_FRAGMENTNCWTREXECUTION = 30;

  private static final int LAYOUT_FRAGMENTPAGER = 31;

  private static final int LAYOUT_FRAGMENTPLACEHOLDERCAPTUREDVALUES = 32;

  private static final int LAYOUT_FRAGMENTPROCEDURERECORDIMAGE = 33;

  private static final int LAYOUT_FRAGMENTQAVERIFY = 34;

  private static final int LAYOUT_FRAGMENTQRATTRIBUTEVERIFYMANUALLY = 35;

  private static final int LAYOUT_FRAGMENTQRSCANATTRIBUTE = 36;

  private static final int LAYOUT_FRAGMENTRECORDDETAIL = 37;

  private static final int LAYOUT_FRAGMENTSCANQRCODEATTRIBUTE = 38;

  private static final int LAYOUT_FRAGMENTSEARCHSUGGESTIONS = 39;

  private static final int LAYOUT_FRAGMENTSTEPPROCEDURE = 40;

  private static final int LAYOUT_FRAGMENTWORKORDER = 41;

  private static final int LAYOUT_FRAGMENTWORKORDERDETAIL = 42;

  private static final int LAYOUT_ITEMALLCAPTUREDATAATTRIBUTES = 43;

  private static final int LAYOUT_ITEMALLCAPTUREDATAATTRIBUTESSHIMMER = 44;

  private static final int LAYOUT_ITEMALLCAPTUREDATAELEMENTSWITHATTRIBUTES = 45;

  private static final int LAYOUT_ITEMALLCAPTUREDATAQRATTRIBUTES = 46;

  private static final int LAYOUT_ITEMALLCAPTUREDDATAFILES = 47;

  private static final int LAYOUT_ITEMALLCHECKLIST = 48;

  private static final int LAYOUT_ITEMASSIGNCHECKLIST = 49;

  private static final int LAYOUT_ITEMASSIGNEDCHECKLISTNOTE = 50;

  private static final int LAYOUT_ITEMASSIGNMENTHISTORY = 51;

  private static final int LAYOUT_ITEMATTACHMENT = 52;

  private static final int LAYOUT_ITEMCANCELLEDCOMPLETED = 53;

  private static final int LAYOUT_ITEMCHECKLISTDETAIL = 54;

  private static final int LAYOUT_ITEMCHECKLISTVIEWREPORTELEMENT = 55;

  private static final int LAYOUT_ITEMDEPARTMENTCHECKLIST = 56;

  private static final int LAYOUT_ITEMEQUIPMENTIMAGE = 57;

  private static final int LAYOUT_ITEMEQUIPMENTS = 58;

  private static final int LAYOUT_ITEMEXECUTIONBOTTOMBAR = 59;

  private static final int LAYOUT_ITEMFILEREQUIRED = 60;

  private static final int LAYOUT_ITEMICONS = 61;

  private static final int LAYOUT_ITEMMYASSIGNED = 62;

  private static final int LAYOUT_ITEMPAGERIMAGEADAPTER = 63;

  private static final int LAYOUT_ITEMPAUSEHISTORY = 64;

  private static final int LAYOUT_ITEMPENDINGELEMENTS = 65;

  private static final int LAYOUT_ITEMQRLOGREPORT = 66;

  private static final int LAYOUT_ITEMQRSCANATTRIBUTEDETAIL = 67;

  private static final int LAYOUT_ITEMREFERENCERESOURCETITLE = 68;

  private static final int LAYOUT_ITEMREFERENCETITLE = 69;

  private static final int LAYOUT_ITEMSEARCHLAYOUT = 70;

  private static final int LAYOUT_ITEMSEARCHSUGGESTION = 71;

  private static final int LAYOUT_ITEMVIEWMORE = 72;

  private static final int LAYOUT_ITEMVIEWREPORTLOG = 73;

  private static final int LAYOUT_ITEMVIEWREPORTNOTE = 74;

  private static final int LAYOUT_ITEMWORKORDER = 75;

  private static final int LAYOUT_ITEMWORKORDERATTACHMENT = 76;

  private static final int LAYOUT_ITEMWORKORDERDETAILINFO = 77;

  private static final int LAYOUT_ITEMWORKORDERNOTEINFO = 78;

  private static final int LAYOUT_NAVHEADERBASENAVIGATIONDRAWER = 79;

  private static final int LAYOUT_POPUPVERIFYROOMASSET = 80;

  private static final int LAYOUT_POPUPLIST = 81;

  private static final int LAYOUT_POPUPREFERENCES = 82;

  private static final int LAYOUT_POPUPSUGGESTION = 83;

  private static final int LAYOUT_POPUPWITHEDITBOX = 84;

  private static final int LAYOUT_STEPEXECUTIONFLOATINGMENU = 85;

  private static final int LAYOUT_VIEWITEMWITHCHECKBOX = 86;

  private static final int LAYOUT_VIEWITEMWORKORDERWITHCHECKBOX = 87;

  private static final int LAYOUT_WIDGETGALLERY = 88;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(88);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_add_note, LAYOUT_ACTIVITYADDNOTE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_all_capture_data, LAYOUT_ACTIVITYALLCAPTUREDATA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_checklist_detail, LAYOUT_ACTIVITYCHECKLISTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_checklist_detail_listing, LAYOUT_ACTIVITYCHECKLISTDETAILLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_checklist_execution, LAYOUT_ACTIVITYCHECKLISTEXECUTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_checklist_report, LAYOUT_ACTIVITYCHECKLISTREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_dashboard, LAYOUT_ACTIVITYDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_location_selection, LAYOUT_ACTIVITYLOCATIONSELECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_terms_and_conditions, LAYOUT_ACTIVITYTERMSANDCONDITIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_webview, LAYOUT_ACTIVITYWEBVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_work_order_complete, LAYOUT_ACTIVITYWORKORDERCOMPLETE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_work_order_create, LAYOUT_ACTIVITYWORKORDERCREATE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_work_order_detail, LAYOUT_ACTIVITYWORKORDERDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.activity_workorder, LAYOUT_ACTIVITYWORKORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.app_bar_base_navigation_drawer, LAYOUT_APPBARBASENAVIGATIONDRAWER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.bottom_sheet_filter, LAYOUT_BOTTOMSHEETFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.bottom_sheet_sort, LAYOUT_BOTTOMSHEETSORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.bottom_sheet_workorder_filter, LAYOUT_BOTTOMSHEETWORKORDERFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.bottom_sheet_workorder_sort, LAYOUT_BOTTOMSHEETWORKORDERSORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.content_location_selection, LAYOUT_CONTENTLOCATIONSELECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.content_terms_and_conditions, LAYOUT_CONTENTTERMSANDCONDITIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.dialog_syncing, LAYOUT_DIALOGSYNCING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_barcode_scanner, LAYOUT_FRAGMENTBARCODESCANNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_checklist, LAYOUT_FRAGMENTCHECKLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_checklist_detail, LAYOUT_FRAGMENTCHECKLISTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_decision_execution, LAYOUT_FRAGMENTDECISIONEXECUTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_embedded_image, LAYOUT_FRAGMENTEMBEDDEDIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_ncwtr_execution, LAYOUT_FRAGMENTNCWTREXECUTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_pager, LAYOUT_FRAGMENTPAGER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_placeholder_captured_values, LAYOUT_FRAGMENTPLACEHOLDERCAPTUREDVALUES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_procedure_record_image, LAYOUT_FRAGMENTPROCEDURERECORDIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_qa_verify, LAYOUT_FRAGMENTQAVERIFY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_qr_attribute_verify_manually, LAYOUT_FRAGMENTQRATTRIBUTEVERIFYMANUALLY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_qr_scan_attribute, LAYOUT_FRAGMENTQRSCANATTRIBUTE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_record_detail, LAYOUT_FRAGMENTRECORDDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_scan_qr_code_attribute, LAYOUT_FRAGMENTSCANQRCODEATTRIBUTE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_search_suggestions, LAYOUT_FRAGMENTSEARCHSUGGESTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_step_procedure, LAYOUT_FRAGMENTSTEPPROCEDURE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_workorder, LAYOUT_FRAGMENTWORKORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.fragment_workorder_detail, LAYOUT_FRAGMENTWORKORDERDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_all_capture_data_attributes, LAYOUT_ITEMALLCAPTUREDATAATTRIBUTES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_all_capture_data_attributes_shimmer, LAYOUT_ITEMALLCAPTUREDATAATTRIBUTESSHIMMER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_all_capture_data_elements_with_attributes, LAYOUT_ITEMALLCAPTUREDATAELEMENTSWITHATTRIBUTES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_all_capture_data_qr_attributes, LAYOUT_ITEMALLCAPTUREDATAQRATTRIBUTES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_all_captured_data_files, LAYOUT_ITEMALLCAPTUREDDATAFILES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_all_checklist, LAYOUT_ITEMALLCHECKLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_assign_checklist, LAYOUT_ITEMASSIGNCHECKLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_assigned_checklist_note, LAYOUT_ITEMASSIGNEDCHECKLISTNOTE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_assignment_history, LAYOUT_ITEMASSIGNMENTHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_attachment, LAYOUT_ITEMATTACHMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_cancelled_completed, LAYOUT_ITEMCANCELLEDCOMPLETED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_checklist_detail, LAYOUT_ITEMCHECKLISTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_checklist_view_report_element, LAYOUT_ITEMCHECKLISTVIEWREPORTELEMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_department_checklist, LAYOUT_ITEMDEPARTMENTCHECKLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_equipment_image, LAYOUT_ITEMEQUIPMENTIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_equipments, LAYOUT_ITEMEQUIPMENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_execution_bottom_bar, LAYOUT_ITEMEXECUTIONBOTTOMBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_file_required, LAYOUT_ITEMFILEREQUIRED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_icons, LAYOUT_ITEMICONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_my_assigned, LAYOUT_ITEMMYASSIGNED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_pager_image_adapter, LAYOUT_ITEMPAGERIMAGEADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_pause_history, LAYOUT_ITEMPAUSEHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_pending_elements, LAYOUT_ITEMPENDINGELEMENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_qr_log_report, LAYOUT_ITEMQRLOGREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_qr_scan_attribute_detail, LAYOUT_ITEMQRSCANATTRIBUTEDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_reference_resource_title, LAYOUT_ITEMREFERENCERESOURCETITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_reference_title, LAYOUT_ITEMREFERENCETITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_search_layout, LAYOUT_ITEMSEARCHLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_search_suggestion, LAYOUT_ITEMSEARCHSUGGESTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_view_more, LAYOUT_ITEMVIEWMORE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_view_report_log, LAYOUT_ITEMVIEWREPORTLOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_view_report_note, LAYOUT_ITEMVIEWREPORTNOTE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_workorder, LAYOUT_ITEMWORKORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_workorder_attachment, LAYOUT_ITEMWORKORDERATTACHMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_workorder_detail_info, LAYOUT_ITEMWORKORDERDETAILINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.item_workorder_note_info, LAYOUT_ITEMWORKORDERNOTEINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.nav_header_base_navigation_drawer, LAYOUT_NAVHEADERBASENAVIGATIONDRAWER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.pop_up_verify_room_asset, LAYOUT_POPUPVERIFYROOMASSET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.popup_list, LAYOUT_POPUPLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.popup_references, LAYOUT_POPUPREFERENCES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.popup_suggestion, LAYOUT_POPUPSUGGESTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.popup_with_edit_box, LAYOUT_POPUPWITHEDITBOX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.step_execution_floating_menu, LAYOUT_STEPEXECUTIONFLOATINGMENU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.view_item_with_checkbox, LAYOUT_VIEWITEMWITHCHECKBOX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.view_item_workorder_with_checkbox, LAYOUT_VIEWITEMWORKORDERWITHCHECKBOX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.icarus.R.layout.widget_gallery, LAYOUT_WIDGETGALLERY);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYADDNOTE: {
        if ("layout/activity_add_note_0".equals(tag)) {
          return new ActivityAddNoteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_add_note is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYALLCAPTUREDATA: {
        if ("layout/activity_all_capture_data_0".equals(tag)) {
          return new ActivityAllCaptureDataBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_all_capture_data is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHECKLISTDETAIL: {
        if ("layout/activity_checklist_detail_0".equals(tag)) {
          return new ActivityChecklistDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_checklist_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHECKLISTDETAILLISTING: {
        if ("layout/activity_checklist_detail_listing_0".equals(tag)) {
          return new ActivityChecklistDetailListingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_checklist_detail_listing is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHECKLISTEXECUTION: {
        if ("layout/activity_checklist_execution_0".equals(tag)) {
          return new ActivityChecklistExecutionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_checklist_execution is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHECKLISTREPORT: {
        if ("layout/activity_checklist_report_0".equals(tag)) {
          return new ActivityChecklistReportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_checklist_report is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDASHBOARD: {
        if ("layout/activity_dashboard_0".equals(tag)) {
          return new ActivityDashboardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_dashboard is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOCATIONSELECTION: {
        if ("layout/activity_location_selection_0".equals(tag)) {
          return new ActivityLocationSelectionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_location_selection is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASH: {
        if ("layout/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYTERMSANDCONDITIONS: {
        if ("layout/activity_terms_and_conditions_0".equals(tag)) {
          return new ActivityTermsAndConditionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_terms_and_conditions is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWEBVIEW: {
        if ("layout/activity_webview_0".equals(tag)) {
          return new ActivityWebviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_webview is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWORKORDERCOMPLETE: {
        if ("layout/activity_work_order_complete_0".equals(tag)) {
          return new ActivityWorkOrderCompleteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_work_order_complete is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWORKORDERCREATE: {
        if ("layout/activity_work_order_create_0".equals(tag)) {
          return new ActivityWorkOrderCreateBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_work_order_create is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWORKORDERDETAIL: {
        if ("layout/activity_work_order_detail_0".equals(tag)) {
          return new ActivityWorkOrderDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_work_order_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWORKORDER: {
        if ("layout/activity_workorder_0".equals(tag)) {
          return new ActivityWorkorderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_workorder is invalid. Received: " + tag);
      }
      case  LAYOUT_APPBARBASENAVIGATIONDRAWER: {
        if ("layout/app_bar_base_navigation_drawer_0".equals(tag)) {
          return new AppBarBaseNavigationDrawerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for app_bar_base_navigation_drawer is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETFILTER: {
        if ("layout/bottom_sheet_filter_0".equals(tag)) {
          return new BottomSheetFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETSORT: {
        if ("layout/bottom_sheet_sort_0".equals(tag)) {
          return new BottomSheetSortBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_sort is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETWORKORDERFILTER: {
        if ("layout/bottom_sheet_workorder_filter_0".equals(tag)) {
          return new BottomSheetWorkorderFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_workorder_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETWORKORDERSORT: {
        if ("layout/bottom_sheet_workorder_sort_0".equals(tag)) {
          return new BottomSheetWorkorderSortBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottom_sheet_workorder_sort is invalid. Received: " + tag);
      }
      case  LAYOUT_CONTENTLOCATIONSELECTION: {
        if ("layout/content_location_selection_0".equals(tag)) {
          return new ContentLocationSelectionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for content_location_selection is invalid. Received: " + tag);
      }
      case  LAYOUT_CONTENTTERMSANDCONDITIONS: {
        if ("layout/content_terms_and_conditions_0".equals(tag)) {
          return new ContentTermsAndConditionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for content_terms_and_conditions is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSYNCING: {
        if ("layout/dialog_syncing_0".equals(tag)) {
          return new DialogSyncingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_syncing is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTBARCODESCANNER: {
        if ("layout/fragment_barcode_scanner_0".equals(tag)) {
          return new FragmentBarcodeScannerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_barcode_scanner is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHECKLIST: {
        if ("layout/fragment_checklist_0".equals(tag)) {
          return new FragmentChecklistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_checklist is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHECKLISTDETAIL: {
        if ("layout/fragment_checklist_detail_0".equals(tag)) {
          return new FragmentChecklistDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_checklist_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTDECISIONEXECUTION: {
        if ("layout/fragment_decision_execution_0".equals(tag)) {
          return new FragmentDecisionExecutionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_decision_execution is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTEMBEDDEDIMAGE: {
        if ("layout/fragment_embedded_image_0".equals(tag)) {
          return new FragmentEmbeddedImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_embedded_image is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLOGIN: {
        if ("layout/fragment_login_0".equals(tag)) {
          return new FragmentLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNCWTREXECUTION: {
        if ("layout/fragment_ncwtr_execution_0".equals(tag)) {
          return new FragmentNcwtrExecutionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_ncwtr_execution is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPAGER: {
        if ("layout/fragment_pager_0".equals(tag)) {
          return new FragmentPagerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_pager is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPLACEHOLDERCAPTUREDVALUES: {
        if ("layout/fragment_placeholder_captured_values_0".equals(tag)) {
          return new FragmentPlaceholderCapturedValuesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_placeholder_captured_values is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPROCEDURERECORDIMAGE: {
        if ("layout/fragment_procedure_record_image_0".equals(tag)) {
          return new FragmentProcedureRecordImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_procedure_record_image is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTQAVERIFY: {
        if ("layout/fragment_qa_verify_0".equals(tag)) {
          return new FragmentQaVerifyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_qa_verify is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTQRATTRIBUTEVERIFYMANUALLY: {
        if ("layout/fragment_qr_attribute_verify_manually_0".equals(tag)) {
          return new FragmentQrAttributeVerifyManuallyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_qr_attribute_verify_manually is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTQRSCANATTRIBUTE: {
        if ("layout/fragment_qr_scan_attribute_0".equals(tag)) {
          return new FragmentQrScanAttributeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_qr_scan_attribute is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTRECORDDETAIL: {
        if ("layout/fragment_record_detail_0".equals(tag)) {
          return new FragmentRecordDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_record_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSCANQRCODEATTRIBUTE: {
        if ("layout-land/fragment_scan_qr_code_attribute_0".equals(tag)) {
          return new FragmentScanQrCodeAttributeBindingLandImpl(component, view);
        }
        if ("layout/fragment_scan_qr_code_attribute_0".equals(tag)) {
          return new FragmentScanQrCodeAttributeBindingImpl(component, view);
        }
        if ("layout-large-land/fragment_scan_qr_code_attribute_0".equals(tag)) {
          return new FragmentScanQrCodeAttributeBindingLargeLandImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_scan_qr_code_attribute is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEARCHSUGGESTIONS: {
        if ("layout/fragment_search_suggestions_0".equals(tag)) {
          return new FragmentSearchSuggestionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_search_suggestions is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSTEPPROCEDURE: {
        if ("layout/fragment_step_procedure_0".equals(tag)) {
          return new FragmentStepProcedureBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_step_procedure is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWORKORDER: {
        if ("layout/fragment_workorder_0".equals(tag)) {
          return new FragmentWorkorderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_workorder is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWORKORDERDETAIL: {
        if ("layout/fragment_workorder_detail_0".equals(tag)) {
          return new FragmentWorkorderDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_workorder_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMALLCAPTUREDATAATTRIBUTES: {
        if ("layout/item_all_capture_data_attributes_0".equals(tag)) {
          return new ItemAllCaptureDataAttributesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_all_capture_data_attributes is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMALLCAPTUREDATAATTRIBUTESSHIMMER: {
        if ("layout/item_all_capture_data_attributes_shimmer_0".equals(tag)) {
          return new ItemAllCaptureDataAttributesShimmerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_all_capture_data_attributes_shimmer is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMALLCAPTUREDATAELEMENTSWITHATTRIBUTES: {
        if ("layout/item_all_capture_data_elements_with_attributes_0".equals(tag)) {
          return new ItemAllCaptureDataElementsWithAttributesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_all_capture_data_elements_with_attributes is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMALLCAPTUREDATAQRATTRIBUTES: {
        if ("layout/item_all_capture_data_qr_attributes_0".equals(tag)) {
          return new ItemAllCaptureDataQrAttributesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_all_capture_data_qr_attributes is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMALLCAPTUREDDATAFILES: {
        if ("layout/item_all_captured_data_files_0".equals(tag)) {
          return new ItemAllCapturedDataFilesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_all_captured_data_files is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMALLCHECKLIST: {
        if ("layout/item_all_checklist_0".equals(tag)) {
          return new ItemAllChecklistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_all_checklist is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMASSIGNCHECKLIST: {
        if ("layout/item_assign_checklist_0".equals(tag)) {
          return new ItemAssignChecklistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_assign_checklist is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMASSIGNEDCHECKLISTNOTE: {
        if ("layout/item_assigned_checklist_note_0".equals(tag)) {
          return new ItemAssignedChecklistNoteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_assigned_checklist_note is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ITEMASSIGNMENTHISTORY: {
        if ("layout/item_assignment_history_0".equals(tag)) {
          return new ItemAssignmentHistoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_assignment_history is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMATTACHMENT: {
        if ("layout/item_attachment_0".equals(tag)) {
          return new ItemAttachmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_attachment is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCANCELLEDCOMPLETED: {
        if ("layout/item_cancelled_completed_0".equals(tag)) {
          return new ItemCancelledCompletedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_cancelled_completed is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHECKLISTDETAIL: {
        if ("layout/item_checklist_detail_0".equals(tag)) {
          return new ItemChecklistDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_checklist_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHECKLISTVIEWREPORTELEMENT: {
        if ("layout/item_checklist_view_report_element_0".equals(tag)) {
          return new ItemChecklistViewReportElementBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_checklist_view_report_element is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMDEPARTMENTCHECKLIST: {
        if ("layout/item_department_checklist_0".equals(tag)) {
          return new ItemDepartmentChecklistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_department_checklist is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEQUIPMENTIMAGE: {
        if ("layout/item_equipment_image_0".equals(tag)) {
          return new ItemEquipmentImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_equipment_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEQUIPMENTS: {
        if ("layout/item_equipments_0".equals(tag)) {
          return new ItemEquipmentsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_equipments is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEXECUTIONBOTTOMBAR: {
        if ("layout/item_execution_bottom_bar_0".equals(tag)) {
          return new ItemExecutionBottomBarBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_execution_bottom_bar is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFILEREQUIRED: {
        if ("layout/item_file_required_0".equals(tag)) {
          return new ItemFileRequiredBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_file_required is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMICONS: {
        if ("layout/item_icons_0".equals(tag)) {
          return new ItemIconsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_icons is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMYASSIGNED: {
        if ("layout/item_my_assigned_0".equals(tag)) {
          return new ItemMyAssignedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_my_assigned is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPAGERIMAGEADAPTER: {
        if ("layout/item_pager_image_adapter_0".equals(tag)) {
          return new ItemPagerImageAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_pager_image_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPAUSEHISTORY: {
        if ("layout/item_pause_history_0".equals(tag)) {
          return new ItemPauseHistoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_pause_history is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPENDINGELEMENTS: {
        if ("layout/item_pending_elements_0".equals(tag)) {
          return new ItemPendingElementsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_pending_elements is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMQRLOGREPORT: {
        if ("layout/item_qr_log_report_0".equals(tag)) {
          return new ItemQrLogReportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_qr_log_report is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMQRSCANATTRIBUTEDETAIL: {
        if ("layout/item_qr_scan_attribute_detail_0".equals(tag)) {
          return new ItemQrScanAttributeDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_qr_scan_attribute_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMREFERENCERESOURCETITLE: {
        if ("layout/item_reference_resource_title_0".equals(tag)) {
          return new ItemReferenceResourceTitleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_reference_resource_title is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMREFERENCETITLE: {
        if ("layout/item_reference_title_0".equals(tag)) {
          return new ItemReferenceTitleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_reference_title is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEARCHLAYOUT: {
        if ("layout/item_search_layout_0".equals(tag)) {
          return new ItemSearchLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_search_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEARCHSUGGESTION: {
        if ("layout/item_search_suggestion_0".equals(tag)) {
          return new ItemSearchSuggestionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_search_suggestion is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMVIEWMORE: {
        if ("layout/item_view_more_0".equals(tag)) {
          return new ItemViewMoreBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_view_more is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMVIEWREPORTLOG: {
        if ("layout/item_view_report_log_0".equals(tag)) {
          return new ItemViewReportLogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_view_report_log is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMVIEWREPORTNOTE: {
        if ("layout/item_view_report_note_0".equals(tag)) {
          return new ItemViewReportNoteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_view_report_note is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWORKORDER: {
        if ("layout/item_workorder_0".equals(tag)) {
          return new ItemWorkorderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_workorder is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWORKORDERATTACHMENT: {
        if ("layout/item_workorder_attachment_0".equals(tag)) {
          return new ItemWorkorderAttachmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_workorder_attachment is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWORKORDERDETAILINFO: {
        if ("layout/item_workorder_detail_info_0".equals(tag)) {
          return new ItemWorkorderDetailInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_workorder_detail_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWORKORDERNOTEINFO: {
        if ("layout/item_workorder_note_info_0".equals(tag)) {
          return new ItemWorkorderNoteInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_workorder_note_info is invalid. Received: " + tag);
      }
      case  LAYOUT_NAVHEADERBASENAVIGATIONDRAWER: {
        if ("layout/nav_header_base_navigation_drawer_0".equals(tag)) {
          return new NavHeaderBaseNavigationDrawerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for nav_header_base_navigation_drawer is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPVERIFYROOMASSET: {
        if ("layout/pop_up_verify_room_asset_0".equals(tag)) {
          return new PopUpVerifyRoomAssetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for pop_up_verify_room_asset is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPLIST: {
        if ("layout/popup_list_0".equals(tag)) {
          return new PopupListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_list is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPREFERENCES: {
        if ("layout/popup_references_0".equals(tag)) {
          return new PopupReferencesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_references is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPSUGGESTION: {
        if ("layout/popup_suggestion_0".equals(tag)) {
          return new PopupSuggestionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_suggestion is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPWITHEDITBOX: {
        if ("layout/popup_with_edit_box_0".equals(tag)) {
          return new PopupWithEditBoxBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_with_edit_box is invalid. Received: " + tag);
      }
      case  LAYOUT_STEPEXECUTIONFLOATINGMENU: {
        if ("layout-large-land/step_execution_floating_menu_0".equals(tag)) {
          return new StepExecutionFloatingMenuBindingLargeLandImpl(component, view);
        }
        if ("layout-land/step_execution_floating_menu_0".equals(tag)) {
          return new StepExecutionFloatingMenuBindingLandImpl(component, view);
        }
        if ("layout/step_execution_floating_menu_0".equals(tag)) {
          return new StepExecutionFloatingMenuBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for step_execution_floating_menu is invalid. Received: " + tag);
      }
      case  LAYOUT_VIEWITEMWITHCHECKBOX: {
        if ("layout/view_item_with_checkbox_0".equals(tag)) {
          return new ViewItemWithCheckboxBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for view_item_with_checkbox is invalid. Received: " + tag);
      }
      case  LAYOUT_VIEWITEMWORKORDERWITHCHECKBOX: {
        if ("layout/view_item_workorder_with_checkbox_0".equals(tag)) {
          return new ViewItemWorkorderWithCheckboxBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for view_item_workorder_with_checkbox is invalid. Received: " + tag);
      }
      case  LAYOUT_WIDGETGALLERY: {
        if ("layout/widget_gallery_0".equals(tag)) {
          return new WidgetGalleryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for widget_gallery is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(38);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "adapter");
      sKeys.put(2, "assetHeader");
      sKeys.put(3, "assets");
      sKeys.put(4, "attributeNo");
      sKeys.put(5, "checklistStatus");
      sKeys.put(6, "checklistType");
      sKeys.put(7, "constants");
      sKeys.put(8, "count");
      sKeys.put(9, "currentEmbeddedImageCount");
      sKeys.put(10, "downloadPath");
      sKeys.put(11, "fileAdapter");
      sKeys.put(12, "fileName");
      sKeys.put(13, "filterListType");
      sKeys.put(14, "folderName");
      sKeys.put(15, "header");
      sKeys.put(16, "isDownloaded");
      sKeys.put(17, "isEnabled");
      sKeys.put(18, "item");
      sKeys.put(19, "itemUUID");
      sKeys.put(20, "items");
      sKeys.put(21, "linksAdapter");
      sKeys.put(22, "logsAdapter");
      sKeys.put(23, "logsSummary");
      sKeys.put(24, "name");
      sKeys.put(25, "position");
      sKeys.put(26, "qrAttributeItem");
      sKeys.put(27, "qrAttributesAdapter");
      sKeys.put(28, "resourceEntity");
      sKeys.put(29, "rooms");
      sKeys.put(30, "roomsHeader");
      sKeys.put(31, "sameDateAdapter");
      sKeys.put(32, "selectedFile");
      sKeys.put(33, "title");
      sKeys.put(34, "totalEmbeddedImageCount");
      sKeys.put(35, "userItem");
      sKeys.put(36, "viewModel");
      sKeys.put(37, "workOrderAttachmentItem");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(92);

    static {
      sKeys.put("layout/activity_add_note_0", com.icarus.R.layout.activity_add_note);
      sKeys.put("layout/activity_all_capture_data_0", com.icarus.R.layout.activity_all_capture_data);
      sKeys.put("layout/activity_checklist_detail_0", com.icarus.R.layout.activity_checklist_detail);
      sKeys.put("layout/activity_checklist_detail_listing_0", com.icarus.R.layout.activity_checklist_detail_listing);
      sKeys.put("layout/activity_checklist_execution_0", com.icarus.R.layout.activity_checklist_execution);
      sKeys.put("layout/activity_checklist_report_0", com.icarus.R.layout.activity_checklist_report);
      sKeys.put("layout/activity_dashboard_0", com.icarus.R.layout.activity_dashboard);
      sKeys.put("layout/activity_location_selection_0", com.icarus.R.layout.activity_location_selection);
      sKeys.put("layout/activity_splash_0", com.icarus.R.layout.activity_splash);
      sKeys.put("layout/activity_terms_and_conditions_0", com.icarus.R.layout.activity_terms_and_conditions);
      sKeys.put("layout/activity_webview_0", com.icarus.R.layout.activity_webview);
      sKeys.put("layout/activity_work_order_complete_0", com.icarus.R.layout.activity_work_order_complete);
      sKeys.put("layout/activity_work_order_create_0", com.icarus.R.layout.activity_work_order_create);
      sKeys.put("layout/activity_work_order_detail_0", com.icarus.R.layout.activity_work_order_detail);
      sKeys.put("layout/activity_workorder_0", com.icarus.R.layout.activity_workorder);
      sKeys.put("layout/app_bar_base_navigation_drawer_0", com.icarus.R.layout.app_bar_base_navigation_drawer);
      sKeys.put("layout/bottom_sheet_filter_0", com.icarus.R.layout.bottom_sheet_filter);
      sKeys.put("layout/bottom_sheet_sort_0", com.icarus.R.layout.bottom_sheet_sort);
      sKeys.put("layout/bottom_sheet_workorder_filter_0", com.icarus.R.layout.bottom_sheet_workorder_filter);
      sKeys.put("layout/bottom_sheet_workorder_sort_0", com.icarus.R.layout.bottom_sheet_workorder_sort);
      sKeys.put("layout/content_location_selection_0", com.icarus.R.layout.content_location_selection);
      sKeys.put("layout/content_terms_and_conditions_0", com.icarus.R.layout.content_terms_and_conditions);
      sKeys.put("layout/dialog_syncing_0", com.icarus.R.layout.dialog_syncing);
      sKeys.put("layout/fragment_barcode_scanner_0", com.icarus.R.layout.fragment_barcode_scanner);
      sKeys.put("layout/fragment_checklist_0", com.icarus.R.layout.fragment_checklist);
      sKeys.put("layout/fragment_checklist_detail_0", com.icarus.R.layout.fragment_checklist_detail);
      sKeys.put("layout/fragment_decision_execution_0", com.icarus.R.layout.fragment_decision_execution);
      sKeys.put("layout/fragment_embedded_image_0", com.icarus.R.layout.fragment_embedded_image);
      sKeys.put("layout/fragment_login_0", com.icarus.R.layout.fragment_login);
      sKeys.put("layout/fragment_ncwtr_execution_0", com.icarus.R.layout.fragment_ncwtr_execution);
      sKeys.put("layout/fragment_pager_0", com.icarus.R.layout.fragment_pager);
      sKeys.put("layout/fragment_placeholder_captured_values_0", com.icarus.R.layout.fragment_placeholder_captured_values);
      sKeys.put("layout/fragment_procedure_record_image_0", com.icarus.R.layout.fragment_procedure_record_image);
      sKeys.put("layout/fragment_qa_verify_0", com.icarus.R.layout.fragment_qa_verify);
      sKeys.put("layout/fragment_qr_attribute_verify_manually_0", com.icarus.R.layout.fragment_qr_attribute_verify_manually);
      sKeys.put("layout/fragment_qr_scan_attribute_0", com.icarus.R.layout.fragment_qr_scan_attribute);
      sKeys.put("layout/fragment_record_detail_0", com.icarus.R.layout.fragment_record_detail);
      sKeys.put("layout-land/fragment_scan_qr_code_attribute_0", com.icarus.R.layout.fragment_scan_qr_code_attribute);
      sKeys.put("layout/fragment_scan_qr_code_attribute_0", com.icarus.R.layout.fragment_scan_qr_code_attribute);
      sKeys.put("layout-large-land/fragment_scan_qr_code_attribute_0", com.icarus.R.layout.fragment_scan_qr_code_attribute);
      sKeys.put("layout/fragment_search_suggestions_0", com.icarus.R.layout.fragment_search_suggestions);
      sKeys.put("layout/fragment_step_procedure_0", com.icarus.R.layout.fragment_step_procedure);
      sKeys.put("layout/fragment_workorder_0", com.icarus.R.layout.fragment_workorder);
      sKeys.put("layout/fragment_workorder_detail_0", com.icarus.R.layout.fragment_workorder_detail);
      sKeys.put("layout/item_all_capture_data_attributes_0", com.icarus.R.layout.item_all_capture_data_attributes);
      sKeys.put("layout/item_all_capture_data_attributes_shimmer_0", com.icarus.R.layout.item_all_capture_data_attributes_shimmer);
      sKeys.put("layout/item_all_capture_data_elements_with_attributes_0", com.icarus.R.layout.item_all_capture_data_elements_with_attributes);
      sKeys.put("layout/item_all_capture_data_qr_attributes_0", com.icarus.R.layout.item_all_capture_data_qr_attributes);
      sKeys.put("layout/item_all_captured_data_files_0", com.icarus.R.layout.item_all_captured_data_files);
      sKeys.put("layout/item_all_checklist_0", com.icarus.R.layout.item_all_checklist);
      sKeys.put("layout/item_assign_checklist_0", com.icarus.R.layout.item_assign_checklist);
      sKeys.put("layout/item_assigned_checklist_note_0", com.icarus.R.layout.item_assigned_checklist_note);
      sKeys.put("layout/item_assignment_history_0", com.icarus.R.layout.item_assignment_history);
      sKeys.put("layout/item_attachment_0", com.icarus.R.layout.item_attachment);
      sKeys.put("layout/item_cancelled_completed_0", com.icarus.R.layout.item_cancelled_completed);
      sKeys.put("layout/item_checklist_detail_0", com.icarus.R.layout.item_checklist_detail);
      sKeys.put("layout/item_checklist_view_report_element_0", com.icarus.R.layout.item_checklist_view_report_element);
      sKeys.put("layout/item_department_checklist_0", com.icarus.R.layout.item_department_checklist);
      sKeys.put("layout/item_equipment_image_0", com.icarus.R.layout.item_equipment_image);
      sKeys.put("layout/item_equipments_0", com.icarus.R.layout.item_equipments);
      sKeys.put("layout/item_execution_bottom_bar_0", com.icarus.R.layout.item_execution_bottom_bar);
      sKeys.put("layout/item_file_required_0", com.icarus.R.layout.item_file_required);
      sKeys.put("layout/item_icons_0", com.icarus.R.layout.item_icons);
      sKeys.put("layout/item_my_assigned_0", com.icarus.R.layout.item_my_assigned);
      sKeys.put("layout/item_pager_image_adapter_0", com.icarus.R.layout.item_pager_image_adapter);
      sKeys.put("layout/item_pause_history_0", com.icarus.R.layout.item_pause_history);
      sKeys.put("layout/item_pending_elements_0", com.icarus.R.layout.item_pending_elements);
      sKeys.put("layout/item_qr_log_report_0", com.icarus.R.layout.item_qr_log_report);
      sKeys.put("layout/item_qr_scan_attribute_detail_0", com.icarus.R.layout.item_qr_scan_attribute_detail);
      sKeys.put("layout/item_reference_resource_title_0", com.icarus.R.layout.item_reference_resource_title);
      sKeys.put("layout/item_reference_title_0", com.icarus.R.layout.item_reference_title);
      sKeys.put("layout/item_search_layout_0", com.icarus.R.layout.item_search_layout);
      sKeys.put("layout/item_search_suggestion_0", com.icarus.R.layout.item_search_suggestion);
      sKeys.put("layout/item_view_more_0", com.icarus.R.layout.item_view_more);
      sKeys.put("layout/item_view_report_log_0", com.icarus.R.layout.item_view_report_log);
      sKeys.put("layout/item_view_report_note_0", com.icarus.R.layout.item_view_report_note);
      sKeys.put("layout/item_workorder_0", com.icarus.R.layout.item_workorder);
      sKeys.put("layout/item_workorder_attachment_0", com.icarus.R.layout.item_workorder_attachment);
      sKeys.put("layout/item_workorder_detail_info_0", com.icarus.R.layout.item_workorder_detail_info);
      sKeys.put("layout/item_workorder_note_info_0", com.icarus.R.layout.item_workorder_note_info);
      sKeys.put("layout/nav_header_base_navigation_drawer_0", com.icarus.R.layout.nav_header_base_navigation_drawer);
      sKeys.put("layout/pop_up_verify_room_asset_0", com.icarus.R.layout.pop_up_verify_room_asset);
      sKeys.put("layout/popup_list_0", com.icarus.R.layout.popup_list);
      sKeys.put("layout/popup_references_0", com.icarus.R.layout.popup_references);
      sKeys.put("layout/popup_suggestion_0", com.icarus.R.layout.popup_suggestion);
      sKeys.put("layout/popup_with_edit_box_0", com.icarus.R.layout.popup_with_edit_box);
      sKeys.put("layout-large-land/step_execution_floating_menu_0", com.icarus.R.layout.step_execution_floating_menu);
      sKeys.put("layout-land/step_execution_floating_menu_0", com.icarus.R.layout.step_execution_floating_menu);
      sKeys.put("layout/step_execution_floating_menu_0", com.icarus.R.layout.step_execution_floating_menu);
      sKeys.put("layout/view_item_with_checkbox_0", com.icarus.R.layout.view_item_with_checkbox);
      sKeys.put("layout/view_item_workorder_with_checkbox_0", com.icarus.R.layout.view_item_workorder_with_checkbox);
      sKeys.put("layout/widget_gallery_0", com.icarus.R.layout.widget_gallery);
    }
  }
}
