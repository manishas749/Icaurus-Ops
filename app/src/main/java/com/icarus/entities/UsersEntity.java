package com.icarus.entities;

import org.jetbrains.annotations.NotNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "users", foreignKeys = {
        @ForeignKey(entity = GroupEntity.class, parentColumns = "id", childColumns = "group_id"),
        @ForeignKey(entity = LocationEntity.class, parentColumns = "id", childColumns = "last_location_id")})
public class UsersEntity {
    @NotNull
    @ColumnInfo(name = "account_uuid")
    public String accountUuid;
    @ColumnInfo(name = "business_name")
    public String businessName;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "full_name")
    public String fullName;


    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid( String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }


    public Integer getId() {
        return id;
    }

    public void setId( Integer id) {
        this.id = id;
    }


    public Integer getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator( Integer isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getLastLocationId() {
        return lastLocationId;
    }

    public void setLastLocationId(Integer lastLocationId) {
        this.lastLocationId = lastLocationId;
    }


    public String getModified() {
        return modified;
    }

    public void setModified( String modified) {
        this.modified = modified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername( String username) {
        this.username = username;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid( String uuid) {
        this.uuid = uuid;
    }

    @NotNull
    @ColumnInfo(name = "group_id")
    public Integer groupId;
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    public Integer id;
    @NotNull
    @ColumnInfo(name = "is_administrator")
    public Integer isAdministrator;
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;
    @ColumnInfo(name = "last_location_id")
    public Integer lastLocationId;
    @NotNull
    @ColumnInfo(name = "modified")
    public String modified;
    @ColumnInfo(name = "password")
    public String password;
    @NotNull
    @ColumnInfo(name = "username")
    public String username;
    @NotNull
    @ColumnInfo(name = "uuid")
    public String uuid;

}
