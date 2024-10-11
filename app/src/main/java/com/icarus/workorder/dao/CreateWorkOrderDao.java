package com.icarus.workorder.dao;

import com.icarus.database.WorkOrderQueries;
import com.icarus.entities.WorkOrderEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CreateWorkOrderDao extends WorkOrderCommonDao{
    @Query(WorkOrderQueries.WORK_ORDER_ID)
    public Integer getWorkOrderId();

    @Insert
    void insertWorkOrder(WorkOrderEntity workOrderEntity);
}

