package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {

    @PrimaryKey
    Integer id;
}
