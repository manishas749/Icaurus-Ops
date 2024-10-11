package com.icarus.constants;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class Constants {
    public static final int REQUEST_RESULT_FOR_LOCATION = 1000;
    public static final int REQUEST_RESULT_FOR_WORK_ORDER = 1001;
    public static final int REQUEST_RESULT_FOR_CANCELLED_COMPLETED = 1002;
    public static final int REQUEST_RESULT_FOR_START_CHECKLIST = 1003;

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ASSIGNED_CHECKLIST_UUID = "ASSIGNED_CHECKLIST_UUID";
    public static final String CHECKLIST_ID = "CHECKLIST_ID";
    public static final String ROOM_ID = "ROOM_ID";
    public static final String ASSET_ID = "ASSET_ID";
    public static final String CHECKLIST_TITLE = "CHECKLIST_TITLE";
    public static final String REFRESH_SCREEN = "CHECKLIST_TITLE";

    public static final String WORK_ORDER_UUID = "WORK_ORDER_UUID";
    public static final String WORK_ORDER_ID = "WORK_ORDER_ID";
    public static final String SELECTED_TAB = "SELECTED_TAB";
    public static final Integer DELETED = 1;
    public static final Integer NOT_DELETED = 0;
    public static final Integer SYNC_STATUS = 1;
    public static final Integer SYNC_STATUS_NOT = 0;
    public static final Integer CHECL_LIST_STATUS_RESUMED = 0;
    public static final Integer CHECL_LIST_STATUS_PAUSED = 4;
    public static final Integer CHECK_LIST_STATUS_COMPLETED = 2;
    public static final Integer CHECL_LIST_STATUS_CANCELLED= 1;
    public static final Integer  CHECL_LIST_STATUS_REJECTED = 5;
    public static final Integer  CHECL_LIST_STATUS_CLOSED = 6;
    public static final Integer CHECL_LIST_STATUS_PENDING_APPROVAL = 3;


    public static final Integer RESUMED = 0 ;
    public static final Integer CHECL_LIST_STATUS_PENDING = 0;
    public static final int PAGE_SIZE = 100; // page size
    public static final int PAGE_INITIAL_LOAD_SIZE_HINT = 30; // page size on first load
    public static final int PAGE_PREFETCH_DISTANCE = 10; // triggers when to fetch a page
    public static final Integer DOWNLOADED = 1;
    public static final Integer NOT_UPLOADED = 0 ;
    public static final Integer NOT_DOWNLOADED = 0 ;
    public static final Integer UPLOADED = 1 ;
    public static final Integer PAUSED_YES = 1;
    public static final String USER_ROLE_QA = "QA" ;
    public static final String USER_ROLE_ADMIN = "Admin" ;
    public static final String USER_ROLE_USER = "User" ;
    public static final String USER_ROLE_CLIENT = "Client" ;
    public static final String USER_ROLE_VENDOR = "Vendor" ;
    public static final String USER_ROLE_QCM = "QCM" ;
    public static final String QA_VALIDATION_INVALID_CREDENTIALS = "Please enter valid credentials";
    public static final String QA_VALIDATION_YOURSELF_CREDENTIALS = "You cannot verify yourself";
    public static final String QA_VALIDATION_SAME_LOCATION = "User verifying should belong to same location/department";
    public static final String QA_VALIDATION_NOT_AUTHORISED = "You are not authorised to verify";
    public static final String QA_VALIDATION_AUTHORISED = "valid";
    //public static final String HEADER_ACCEPT = "application/vnd.icarus.v2.0+json";
    public static final String HEADER_ACCEPT = "application/vnd.icarus.v2.2+json";
    public static final Integer DEFAULT_PENDING_RESOURCE_COUNT = 0;
    public static final String PLATFORM = "android";

    public static Integer FAVOURITE = 1;
    public static Integer NOT_FAVOURITE = 0;

    public static Integer WORK_ORDER_STATUS_ID = 1;
    public static Integer WORK_ORDER_BILLING_TYPE_ID = null;
    public static Integer WORK_ORDER_PRIORITY_ID = 2;
    public static Integer WORK_ORDER_ASSIGNED_TO_TYPE = 2;
    public static final String CACHE = "Cache";
    public static final String WORK_ORDER_ATTACHMENTS = "WorkOrderAttachments";
    public static final String SUGGESTION = "Suggestion";
    public static final String RESOURCES = "Resources";
    public static final String RESOURCES_PPE = "ppes";
    public static final String RESOURCES_HAZARDS = "hazards";
    public static final String CLIENT_LOGO = "ClientLogo";

    public static final int USER_ROLE_CLIENT_ID = 2 ;
    public static final int USER_ROLE_QA_ID = 3 ;
    public static final int USER_ROLE_USER_ID = 4 ;
    public static final int USER_ROLE_ADMIN_ID = 5 ;
    public static final int USER_ROLE_QCM_ID = 6 ;
    public static final int USER_ROLE_VENDOR_ID = 7 ;

    public static final String SYNC_TYPES_GROUP = "groups";
    public static final String SYNC_TYPES_ITEM_TYPES = "item_types";
    public static final String SYNC_TYPES_PPES = "ppes";
    public static final String SYNC_TYPES_HAZARDS = "hazards";
    public static final String SYNC_TYPES_CLIENT_SETTINGS = "client_settings";
    public static final String SYNC_TYPES_CHECKLIST_TYPE = "checklist_types";
    public static final String SYNC_TYPES_CHECKLIST_STATUS = "checklist_statuses";
    public static final String SYNC_TYPES_CHECKLIST_EXECUSION_PERMISSION = "checklist_execution_permissions";
    public static final String SYNC_TYPES_WORKORDER_STATUS = "workorder_statuses";
    public static final String SYNC_TYPES_WORKORDDER_BILLING = "workorder_billing_types";
    public static final String SYNC_TYPES_WORKORDDER = "workorders";
    public static final String SYNC_TYPES_DEPARTMENTS = "departments";
    public static final String SYNC_TYPES_ROOMS = "rooms";
    public static final String SYNC_TYPES_USER_FAVORITES = "user_favorites";
    public static final String SYNC_TYPES_CLIENT_LOGOS = "client_logos";
    public static final String SYNC_TYPES_EQUIPMENTS = "equipment";
    public static final String SYNC_TYPES_LOCATION = "locations";
    public static final String SYNC_TYPES_CHECKLIST = "checklists";
    public static final String SYNC_TYPES_ASSIGNED_CHECKLIST = "assigned_checklists";
    public static final String SYNC_TYPES_USER = "users";
    public static final String SYNC_TYPE_LOCATION_ROOMS = "location_rooms";
    public static final String SYNC_TYPE_LOCATION_EQUIPMENTS = "location_equipments";
    public static final String SYNC_TYPE_LOCATION_ROOM_EQUIPMENTS = "location_room_equipments";

    public static final Integer SYNC_STATUS_PENDING = 0;
    public static final Integer SYNC_STATUS_COMPLETED = 1;
    public static final Integer SYNC_STATUS_INPROGRESS = 2;
    public static final Integer SYNC_STATUS_FAILED = 3;
    public static final Integer SYNC_STATUS_UNAUTHORIZED = 4;
    public static final Integer SYNC_STATUS_INTERNET_NOT_AVAILABLE = 5;
    public static final Integer SYNC_STATUS_RESOURCE_DOWNLOAD_UPLOAD = 6;


    //--- Checklist status to maintain color of synced checklist

    public static final Integer SYNC_STATUS_CHECKLIST_PENDING = 3;
    public static final Integer SYNC_STATUS_CHECKLIST_PARTIAL_SYNCED = 2;
    public static final Integer SYNC_STATUS_CHECKLIST_FULLY_SYNCED = 1;

    public static final Integer EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER = -1;
    public static final Integer EXECUTION_STATUS_DATA_NOT_SYNC = 0;
    public static final Integer EXECUTION_STATUS_SYNC_TO_SERVER = 1;
}
