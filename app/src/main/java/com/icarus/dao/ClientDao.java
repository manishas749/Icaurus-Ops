package com.icarus.dao;

import com.icarus.database.Queries;
import com.icarus.models.ClientSettingItems;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ClientDao {
    @Query(Queries.GET_CLIENT_SETTINGS)
    public List<ClientSettingItems> getClientSetting();


}

