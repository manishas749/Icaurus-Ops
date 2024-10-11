package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Created by Monika Rana on 06/05/2020
 */

@Entity(tableName = "qr_storage")
public class QRStorageEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;

    @NonNull
    @ColumnInfo(name = "model")
    private String model;

    @NonNull
    @ColumnInfo(name = "foreign_key")
    private String foreignKey;

    @NonNull
    @ColumnInfo(name = "code")
    private String code;

    @NonNull
    @ColumnInfo(name = "modified")
    private String modified;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public String getModel() {
        return model;
    }

    public void setModel(@NonNull String model) {
        this.model = model;
    }

    @NonNull
    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(@NonNull String foreignKey) {
        this.foreignKey = foreignKey;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }
}
