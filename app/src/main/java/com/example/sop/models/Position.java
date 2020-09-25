package com.example.sop.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("canCreate")
    @Expose
    private Integer canCreate;
    @SerializedName("canDelete")
    @Expose
    private Integer canDelete;
    @SerializedName("canEdit")
    @Expose
    private Integer canEdit;
    @SerializedName("canApprov")
    @Expose
    private Integer canApprov;
    @SerializedName("canCoordinate")
    @Expose
    private Integer canCoordinate;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(Integer canCreate) {
        this.canCreate = canCreate;
    }

    public Integer getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Integer canDelete) {
        this.canDelete = canDelete;
    }

    public Integer getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Integer canEdit) {
        this.canEdit = canEdit;
    }

    public Integer getCanApprov() {
        return canApprov;
    }

    public void setCanApprov(Integer canApprov) {
        this.canApprov = canApprov;
    }

    public Integer getCanCoordinate() {
        return canCoordinate;
    }

    public void setCanCoordinate(Integer canCoordinate) {
        this.canCoordinate = canCoordinate;
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

}
