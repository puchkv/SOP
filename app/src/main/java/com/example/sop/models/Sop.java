package com.example.sop.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sop {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("approving_id")
    @Expose
    private Integer approvingId;
    @SerializedName("executor")
    @Expose
    private String executor;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("owner")
    @Expose
    private Employee owner;
    @SerializedName("approver")
    @Expose
    private Employee approver;
    @SerializedName("coordinators")
    @Expose
    private List<Employee> coordinators;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;
    /*@SerializedName("approvals")
    @Expose
    private List<Object> approvals = null;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getApprovingId() {
        return approvingId;
    }

    public void setApprovingId(Integer approvingId) {
        this.approvingId = approvingId;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public Employee getApprover() {
        return approver;
    }

    public void setApprover(Employee approver) {
        this.approver = approver;
    }

    public List<Employee> getCoordinators() {
        return coordinators;
    }

    public void setCoordinators(List<Employee> coordinators) {
        this.coordinators = coordinators;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    /*public List<Object> getApprovals() {
        return approvals;
    }

    public void setApprovals(List<Object> approvals) {
        this.approvals = approvals;
    }*/
}
