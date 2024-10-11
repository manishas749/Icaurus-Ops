package com.icarus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.icarus.database.Queries;
import com.icarus.entities.LocationEntity;

import java.util.List;

@Dao
public interface LocationDao {


    @Query(Queries.GET_LOCATIONS)
    public List<LocationEntity> getLocations(Integer userId);

    @Query(Queries.GET_LOCATIONS_ADMIN)
    public List<LocationEntity> getLocations();

    @Query(Queries.GET_LOCATION)
    public LocationEntity get(Integer id);


}

