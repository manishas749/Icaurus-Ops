package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class RoomAssetItems {

    @ColumnInfo(name ="room_id" )
   public Integer roomId;
    @ColumnInfo(name ="equipment_id" )
    public Integer equipmentId;

    @ColumnInfo(name ="room_asset" )
    public String roomAsset;

    @ColumnInfo(name ="asset" )
    public String asset;

    public String room;




    //
    //
    // val roomId: Int, val equipmentId: Int, val room: String, val asset: String, val roomAsset: String
}
