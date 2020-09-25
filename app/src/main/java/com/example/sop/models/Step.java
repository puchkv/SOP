package com.example.sop.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sop_id")
    @Expose
    private Integer sopId;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("photo")
    @Expose
    private Object photo;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("key_points")
    @Expose
    private String keyPoints;
    @SerializedName("safety")
    @Expose
    private Integer safety;
    @SerializedName("important")
    @Expose
    private Integer important;
    @SerializedName("quality")
    @Expose
    private Integer quality;
    @SerializedName("response")
    @Expose
    private Integer response;
    @SerializedName("checklist")
    @Expose
    private Integer checklist;
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

    public Integer getSopId() {
        return sopId;
    }

    public void setSopId(Integer sopId) {
        this.sopId = sopId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getKeyPoints() {
        return keyPoints;
    }

    public void setKeyPoints(String keyPoints) {
        this.keyPoints = keyPoints;
    }

    public Integer getSafety() {
        return safety;
    }

    public void setSafety(Integer safety) {
        this.safety = safety;
    }

    public Integer getImportant() {
        return important;
    }

    public void setImportant(Integer important) {
        this.important = important;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public Integer getChecklist() {
        return checklist;
    }

    public void setChecklist(Integer checklist) {
        this.checklist = checklist;
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
