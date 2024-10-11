package com.icarus.dao;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

import com.icarus.database.CaptureDataQueries;
import com.icarus.models.ElementAttributesItems;
import com.icarus.models.ElementWithCaptureDataItems;

import java.util.List;

/**
 * Created by Monika Rana on 04/10/2019
 */
@Dao
public interface AllCaptureDataDao {

    @Query(CaptureDataQueries.ELEMENT_WITH_ATTRIBUTES)
    public DataSource.Factory<Integer, ElementWithCaptureDataItems> getElementsWithAttributes(String assignedChecklistUUID, Integer checklistID);

    @Query(CaptureDataQueries.ATTRIBUTES)
    List<ElementAttributesItems> getAttributes(String assignedChecklistUUID, int elementId);

  /*  @Query(CaptureDataQueries.ATTRIBUTES)
    public DataSource.Factory<Integer, CaptureDataItem> getAttributes(Integer assignedChecklistUUID, Integer checklistID);*/
}
