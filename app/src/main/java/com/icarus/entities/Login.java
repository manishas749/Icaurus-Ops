package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "users")
public class Login {
    @PrimaryKey
    private Integer id;

    private String uuid;

    private String username;

    private String password;

    @SerializedName("group_id")
    @ColumnInfo(name = "group_id")
    private Integer groupId;

    @SerializedName("first_name")
    @ColumnInfo(name = "first_name")
    private String firstName;

    @SerializedName("last_name")
    @ColumnInfo(name = "last_name")
    private String lastName;

    @SerializedName("full_name")
    @ColumnInfo(name = "full_name")
    private String fullName;

    private String email;

    @SerializedName("is_deleted")
    @ColumnInfo(name = "is_deleted")
    private boolean isDeleted;

    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    private String createdAt;

    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    private String updatedAt;

    @SerializedName("is_administrator")
    @ColumnInfo(name = "is_administrator")
    private boolean isAdministrator;
    @Ignore
    private String message;
    @Ignore
    private int code;

    @ColumnInfo(name = "account_uuid")
    private String clientUuid;

    @ColumnInfo(name = "terms_accepted")
    private boolean isTermsAccepted;

    private String credentials;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public String getClientUuid() {
        return clientUuid;
    }

    public void setClientUuid(String clientUuid) {
        this.clientUuid = clientUuid;
    }

    public boolean isTermsAccepted() {
        return isTermsAccepted;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        isTermsAccepted = termsAccepted;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}