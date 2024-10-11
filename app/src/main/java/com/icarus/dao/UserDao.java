package com.icarus.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.icarus.database.Queries;

@Dao
public interface UserDao {
    @Query(Queries.IS_QCM)
    boolean isQCM(Integer userId, Integer locationId);
}
