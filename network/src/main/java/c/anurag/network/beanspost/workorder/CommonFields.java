package c.anurag.network.beanspost.workorder;

import com.google.gson.annotations.SerializedName;

import c.anurag.database.application.BaseApplication;

/**
 * Created by on 6/14/2016.
 */
public class CommonFields {

    {
        //mEntryTs = mModified = mCreated = BaseApplication.getCommonFunctions().getUtcTime();
        mUuid = BaseApplication.getCommonFunctions().getUUID();
        mId = 0;
        mSyncStatus = 0;
        mIsDeleted = 0;
    }

    @SerializedName("id")
    private int mId;

    @SerializedName("uuid")
    private String mUuid;

    @SerializedName("created")
    private String mCreated;

    @SerializedName("is_deleted")
    private int mIsDeleted;

    @SerializedName("modified")
    private String mModified;

    @SerializedName("entry_ts")
    private String mEntryTs;

    @SerializedName("revision_id")
    private int mRevisionId;

    private int mSyncStatus;

    public int getRevisionId() {
        return mRevisionId;
    }

    public int getIsDeleted() {
        return mIsDeleted;
    }

    public void setIsDeleted(int mIsDeleted) {
        this.mIsDeleted = mIsDeleted;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getUuid() {
        return mUuid;
    }

    public void setUuid(String mUuid) {
        this.mUuid = mUuid;
    }

    public String getCreated() {
        return mCreated;
    }

    public void setCreated(String mCreated) {
        this.mCreated = mCreated;
    }

    public String getModified() {
        return mModified;
    }

    public void setModified(String mModified) {
        this.mModified = mModified;
    }

    public String getEntryTs() {
        return mEntryTs;
    }

    public void setEntryTs(String mEntryTs) {
        this.mEntryTs = mEntryTs;
    }

    public int getSyncStatus() {
        return mSyncStatus;
    }

    public void setSyncStatus(int mSyncStatus) {
        this.mSyncStatus = mSyncStatus;
    }
}