package c.anurag.common.preference;

import android.content.Context;

/**
 * @author Anurag Purwar
 * @version 1.0
 */
public final class PreferenceManager extends AbstractPreferenceManager {
    private static final int VERSION = 1;
    private static final String PREF_NAME = "com.icarus.Preferences";
    private static final String PREF_IS_ADMIN = "PREF_IS_ADMIN";
    private static final String PREF_CLIENT_UUID = "PREF_CLIENT_UUID";
    private static final String PREF_SERVER_PATH = "PREF_SERVER_PATH";
    private static final String PREF_PPES_DOWNLOAD_PATH = "PREF_PPES_DOWNLOAD_PATH";
    private static final String PREF_HAZARDS_DOWNLOAD_PATH = "PREF_HAZARDS_DOWNLOAD_PATH";
    private static final String PREF_CHECKLIST_LOGO_DOWNLOAD_PATH = "PREF_CHECKLIST_LOGO_DOWNLOAD_PATH";
    private static final String PREF_CLIENT_LOGO_DOWNLOAD_PATH = "PREF_CLIENT_LOGO_DOWNLOAD_PATH";
    private static final String PREF_RESOURCES_DOWNLOAD_PATH = "PREF_RESOURCES_DOWNLOAD_PATH";
    private static final String PREF_ASSIGNED_STEP_RESOURCES_DOWNLOAD_PATH = "PREF_ASSIGNED_STEP_RESOURCES_DOWNLOAD_PATH";
    private static final String PREF_WORKORDER_DOWNLOAD_PATH = "PREF_WORKORDER_DOWNLOAD_PATH";

    private static final String PREF_WORKORDER_UPLOAD_PATH = "PREF_WORKORDER_UPLOAD_PATH";
    private static final String PREF_USER_SUGGESTION_ATTACHMENTS_UPLOAD_PATH = "PREF_USER_SUGGESTION_ATTACHMENTS_UPLOAD_PATH";
    private static final String PREF_ASSIGNED_STEP_RESOURCES_UPLOAD_PATH = "PREF_ASSIGNED_STEP_RESOURCES_UPLOAD_PATH";

    private static final String PREF_USER_ID = "PREF_USER_ID";
    private static final String PREF_USER_NAME = "PREF_USER_NAME";
    private static final String PREF_USER_FULL_NAME = "PREF_USER_FULL_NAME";
    private static final String PREF_USER_UUID = "PREF_USER_UUID";
    private static final String PREF_USER_GROUP_ID = "PREF_USER_GROUP_ID";
    private static final String PREF_USER_CREDINTIALS = "PREF_USER_CREDINTIALS";
    private static final String PREF_SYNC_IDENTIFIER = "PREF_SYNC_IDENTIFIER";
    private static final String PREF_CURRENT_REVISION = "PREF_CURRENT_REVISION";
    private static final String PREF_USER_LOCATIONS = "PREF_USER_LOCATIONS_";

    private static final String PREF_CLIENT_SETTING_ROOM = "PREF_CLIENT_SETTING_ROOM";
    private static final String PREF_CLIENT_SETTING_ASSET = "PREF_CLIENT_SETTING_ASSET";
    private static final String PREF_USER_SEARCH_SUGGESTION = "PREF_USER_SEARCH_SUGGESTION";
    private static final String PREF_LAST_ACTIVITY_AFTER = "PREF_LAST_ACTIVITY_AFTER";
    private static final String PREF_LAST_ACTIVITY_BEFORE = "PREF_LAST_ACTIVITY_BEFORE";
    private static final String PREF_TEMP_REVISION_NUMBER = "PREF_TEMP_REVISION_NUMBER";
    private static final String PREF_REVISION_NUMBER = "PREF_REVISION_NUMBER";


    public PreferenceManager(Context ctx) {
        super(ctx, PREF_NAME, VERSION);
    }

    public PreferenceManager(Context ctx, String prefsName, int version) {
        super(ctx, prefsName, version);
    }

    public void setIsAdmin(boolean isAdmin) {
        saveBoolean(PREF_IS_ADMIN, isAdmin);
    }

    public boolean getIsAdmin() {
        return readBoolean(PREF_IS_ADMIN);
    }


    public void setClientUuid(String clientUuid) {
        saveString(PREF_CLIENT_UUID, clientUuid);
    }

    public String getClientUuid() {
        return readString(PREF_CLIENT_UUID, "");
    }

    public String getServerPath() {
        return readString(PREF_SERVER_PATH, "");
    }

    public void setServerPath(String serverPath) {
        saveString(PREF_SERVER_PATH, serverPath);
    }

    public String getResourcesDownloadPath() {
        return readString(PREF_RESOURCES_DOWNLOAD_PATH, "");
    }

    public void setResourcesDownloadPath(String serverPath) {
        saveString(PREF_RESOURCES_DOWNLOAD_PATH, serverPath);
    }

    public String getChecklistLogoDownloadPath() {
        return readString(PREF_CHECKLIST_LOGO_DOWNLOAD_PATH, "");
    }

    public void setChecklistLogoDownloadPath(String serverPath) {
        saveString(PREF_CHECKLIST_LOGO_DOWNLOAD_PATH, serverPath);
    }

    public String getClientLogoDownloadPath() {
        return readString(PREF_CLIENT_LOGO_DOWNLOAD_PATH, "");
    }

    public void setClientLogoDownloadPath(String serverPath) {
        saveString(PREF_CLIENT_LOGO_DOWNLOAD_PATH, serverPath);
    }

    public String getPpesDownloadPath() {
        return readString(PREF_PPES_DOWNLOAD_PATH, "");
    }

    public void setPpesDownloadPath(String serverPath) {
        saveString(PREF_PPES_DOWNLOAD_PATH, serverPath);
    }

    public String getHazardsDownloadPath() {
        return readString(PREF_HAZARDS_DOWNLOAD_PATH, "");
    }

    public void setHazardsDownloadPath(String serverPath) {
        saveString(PREF_HAZARDS_DOWNLOAD_PATH, serverPath);
    }

    public String getAssignedStepResourcesDownloadPath() {
        return readString(PREF_ASSIGNED_STEP_RESOURCES_DOWNLOAD_PATH, "");
    }

    public void setAssignedStepResourcesDownloadPath(String serverPath) {
        saveString(PREF_ASSIGNED_STEP_RESOURCES_DOWNLOAD_PATH, serverPath);
    }

    public String getWorkordersDownloadPath() {
        return readString(PREF_WORKORDER_DOWNLOAD_PATH, "");
    }

    public void setWorkordersDownloadPath(String serverPath) {
        saveString(PREF_WORKORDER_DOWNLOAD_PATH, serverPath);
    }

    public String getWorkordersUploadPath() {
        return readString(PREF_WORKORDER_UPLOAD_PATH, "");
    }

    public void setWorkordersUploadPath(String serverPath) {
        saveString(PREF_WORKORDER_UPLOAD_PATH, serverPath);
    }

    public String getAssignedStepUploadPath() {
        return readString(PREF_ASSIGNED_STEP_RESOURCES_UPLOAD_PATH, "");
    }

    public void setAssignedStepUploadPath(String serverPath) {
        saveString(PREF_ASSIGNED_STEP_RESOURCES_UPLOAD_PATH, serverPath);
    }

    public String getUserSuggestionsUploadPath() {
        return readString(PREF_USER_SUGGESTION_ATTACHMENTS_UPLOAD_PATH, "");
    }

    public void setUserSuggestionsUploadPath(String serverPath) {
        saveString(PREF_USER_SUGGESTION_ATTACHMENTS_UPLOAD_PATH, serverPath);
    }

    /*public void setUserLocation(String serverPath) {
        saveString("location_" + getUserId() + "_" + getUserUuid(), serverPath);
    }

    public String getUserLocation() {
        return readString("location_" + getUserId() + "_" + getUserUuid(), "");
    }*/

    public void setUserLocationId(int locationId) {
        saveInt("location_id_" + getUserId() + "_" + getUserUuid(), locationId);
    }

    public int getUserLocationId() {
        return readInt("location_id_" + getUserId() + "_" + getUserUuid());
    }

    public void setUserLocationName(String name) {
        saveString("locationName_" + getUserId() + "_" + getUserUuid(), name);
    }

    public String getUserLocationName() {
        return readString("locationName_" + getUserId() + "_" + getUserUuid(), "");
    }

    public void setUserLocationTimeZone(String timeZone) {
        saveString("locationtimeZone_" + getUserId() + "_" + getUserUuid(), timeZone);
    }

    public String getUserLocationTimeZone() {
        return readString("locationtimeZone_" + getUserId() + "_" + getUserUuid(), "");
    }

    public int getUserId() {
        return readInt(PREF_USER_ID);
    }

    public void setUserId(int serverPath) {
        saveInt(PREF_USER_ID, serverPath);
    }

    public String getUserName() {
        return readString(PREF_USER_NAME, "");
    }

    public void setUserName(String serverPath) {
        saveString(PREF_USER_NAME, serverPath);
    }

    public void setUserFullName(String serverPath) {
        saveString(PREF_USER_FULL_NAME, serverPath);
    }

    public String getUserFullName() {
        return readString(PREF_USER_FULL_NAME, "");
    }

    public void setUserUuid(String serverPath) {
        saveString(PREF_USER_UUID, serverPath);
    }

    public void setLastActivityBefore(String lastActivityBefore) {
        saveString(PREF_LAST_ACTIVITY_BEFORE, lastActivityBefore);
    }

    public void setLastActivityAfter(String lastActivityAfter) {
        saveString(PREF_LAST_ACTIVITY_AFTER, lastActivityAfter);
    }

    public String getLastActivityAfter() {
        return readString(PREF_LAST_ACTIVITY_AFTER, "");
    }

    public String getLastActivityBefore() {
        return readString(PREF_LAST_ACTIVITY_BEFORE, "");
    }


    public String getUserUuid() {
        return readString(PREF_USER_UUID, "");
    }

    public String getUserCredintials() {
        return readString(PREF_USER_CREDINTIALS, "");
    }

    public void setUserCredintials(String userCredintails) {
        saveString(PREF_USER_CREDINTIALS, userCredintails);
    }

    public void setUserGroupId(int groupId) {
        saveInt(PREF_USER_GROUP_ID, groupId);
    }

    public int getUserGroupId() {
        return readInt(PREF_USER_GROUP_ID);
    }

    public void setAcceptTC(boolean serverPath) {
        saveBoolean("user_t&c_" + getUserId(), serverPath);
    }

    public boolean getAcceptTC() {
        return readBoolean("user_t&c_" + getUserId());
    }

    public void logout() {
        setUserName("");
        setUserFullName("");
        setClientUuid("");
        setUserUuid("");
        setUserId(0);
        setUserCredintials("");
    }

    public int getCurrentRevision() {
        return readInt(getClientUuid() + PREF_CURRENT_REVISION);
    }

    public void setCurrentRevision(int currentRevision) {
        saveInt(getClientUuid() + PREF_CURRENT_REVISION, currentRevision);
    }

    public String getSyncIdentifier() {
        return readString(PREF_SYNC_IDENTIFIER);
    }

    public void setSyncIdentifier(String syncIdentifer) {
        saveString(PREF_SYNC_IDENTIFIER, syncIdentifer);
    }

    public void setRoomName(String roomName) {
        saveString(PREF_CLIENT_SETTING_ROOM, roomName);
    }

    public String getRoomName() {
        return readString(PREF_CLIENT_SETTING_ROOM, "");
    }

    public void setAssetName(String roomName) {
        saveString(PREF_CLIENT_SETTING_ASSET, roomName);
    }

    public String getAssetName() {
        return readString(PREF_CLIENT_SETTING_ASSET, "");
    }

    public String getSearchSuggestions() {
        return readString(getUserId() + PREF_USER_SEARCH_SUGGESTION, "");
    }

    public void setSearchSuggestions(String searchSuggestions) {
        saveString(getUserId() + PREF_USER_SEARCH_SUGGESTION, searchSuggestions);
    }

    public Integer getTempRevisionNumber() {
        return readInt(PREF_TEMP_REVISION_NUMBER, 0);
    }

    public void setTempRevisionNumber(Integer revisionNumber) {
        saveInt(PREF_TEMP_REVISION_NUMBER, revisionNumber);
    }

    public Integer getRevisionNumber() {
        return readInt(PREF_REVISION_NUMBER, 0);
    }

    public void setRevisionNumber(Integer revisionNumber) {
        saveInt(PREF_REVISION_NUMBER, revisionNumber);
    }

    public void setLoginUserLocations(String locations) {
        saveString(PREF_USER_LOCATIONS + getUserId() + "_" + getUserUuid(), locations);
    }

    public String getLoginUserLocations() {
        return readString(PREF_USER_LOCATIONS + getUserId() + "_" + getUserUuid());
    }
}
