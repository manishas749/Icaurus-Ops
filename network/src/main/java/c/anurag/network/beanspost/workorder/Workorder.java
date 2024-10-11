package c.anurag.network.beanspost.workorder;

/**
 * Created by on 6/18/2016.
 */
public class Workorder extends CommonFields
{
    private String mTitle;
    private String mDueDate;
    private int mWorkorderStatusId;
    private int mAssignedToId;
    private int mWorkorderPriorityId;
    private Integer mWorkorderBillingTypeId;
    private int mAuthorId;
    private int mLocationId;
    private int mLocationRoomId;
    private int mLocationEquipmentId;
    private int mAssignedToType;
    private String mDescription;
    private String mClosedDate;
    private String mStartDate;
    private Integer mChecklistId;

    public Workorder()
    {
    }

    public Workorder(String mTitle, String mDueDate, int mWorkorderStatusId, int mAssignedToId, int mWorkorderPriorityId,
                     Integer mWorkorderBillingTypeId, int mAuthorId, int mLocationId, int mLocationRoomId, int mLocationEquipmentId,
                     int mAssignedToType, String mDescription, String mClosedDate, String mStartDate, Integer mChecklistId)
    {
        this.mTitle = mTitle;
        this.mDueDate = mDueDate;
        this.mWorkorderStatusId = mWorkorderStatusId;
        this.mAssignedToId = mAssignedToId;
        this.mWorkorderPriorityId = mWorkorderPriorityId;
        this.mWorkorderBillingTypeId = mWorkorderBillingTypeId;
        this.mAuthorId = mAuthorId;
        this.mLocationId = mLocationId;
        this.mLocationRoomId = mLocationRoomId;
        this.mLocationEquipmentId = mLocationEquipmentId;
        this.mAssignedToType = mAssignedToType;
        this.mDescription = mDescription;
        this.mClosedDate = mClosedDate;
        this.mStartDate = mStartDate;
        this.mChecklistId = mChecklistId;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String mTitle)
    {
        this.mTitle = mTitle;
    }

    public String getDueDate()
    {
        return mDueDate;
    }

    public void setDueDate(String mDueDate)
    {
        this.mDueDate = mDueDate;
    }

    public int getWorkorderStatusId()
    {
        return mWorkorderStatusId;
    }

    public void setWorkorderStatusId(int mWorkorderStatusId)
    {
        this.mWorkorderStatusId = mWorkorderStatusId;
    }

    public int getAssignedToId()
    {
        return mAssignedToId;
    }

    public void setAssignedToId(int mAssignedToId)
    {
        this.mAssignedToId = mAssignedToId;
    }

    public int getWorkorderPriorityId()
    {
        return mWorkorderPriorityId;
    }

    public void setWorkorderPriorityId(int mWorkorderPriorityId)
    {
        this.mWorkorderPriorityId = mWorkorderPriorityId;
    }

    public Integer getWorkorderBillingTypeId()
    {
        return mWorkorderBillingTypeId;
    }

    public void setWorkorderBillingTypeId(Integer mWorkorderBillingTypeId)
    {
        this.mWorkorderBillingTypeId = mWorkorderBillingTypeId;
    }

    public int getAuthorId()
    {
        return mAuthorId;
    }

    public void setAuthorId(int mAuthorId)
    {
        this.mAuthorId = mAuthorId;
    }

    public int getLocationId()
    {
        return mLocationId;
    }

    public void setLocationId(int mLocationId)
    {
        this.mLocationId = mLocationId;
    }

    public int getLocationRoomId()
    {
        return mLocationRoomId;
    }

    public void setLocationRoomId(int mLocationRoomId)
    {
        this.mLocationRoomId = mLocationRoomId;
    }

    public int getLocationEquipmentId()
    {
        return mLocationEquipmentId;
    }

    public void setLocationEquipmentId(int mLocationEquipmentId)
    {
        this.mLocationEquipmentId = mLocationEquipmentId;
    }

    public int getAssignedToType()
    {
        return mAssignedToType;
    }

    public void setAssignedToType(int mAssignedToType)
    {
        this.mAssignedToType = mAssignedToType;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public void setDescription(String mDescription)
    {
        this.mDescription = mDescription;
    }

    public String getClosedDate()
    {
        return mClosedDate;
    }

    public void setClosedDate(String mClosedDate)
    {
        this.mClosedDate = mClosedDate;
    }

    public String getStartDate()
    {
        return mStartDate;
    }

    public void setStartDate(String mStartDate)
    {
        this.mStartDate = mStartDate;
    }

    public Integer getChecklistId()
    {
        return mChecklistId;
    }

    public void setChecklistId(Integer mChecklistId)
    {
        this.mChecklistId = mChecklistId;
    }
}
