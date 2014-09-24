package com.moriah.acme.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "acme_spice_model", schema = "acme_space@cassandra-pu")
public class AcmeSpiceModel {   
	@Id
    @Column(name = "model_id")
    private UUID modelId;
    
    @Column(name = "tv_id")
    private UUID tvId;
    
    @Column(name = "model_name")
    private String modelName;
    
    @Column(name = "model_type")
    private String modelType;
    
    @Column(name = "model_desc")
    private String modelDesc;

    @Column(name = "file_id")
    private UUID fileId;
    
    @Column(name = "is_primary")
    private Boolean isPrimary;

    @Column(name = "status")
    private String status;
    
    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "create_user")
    private String createUser;
    
    @Column(name = "update_time")
    private Date updateTime;
    
    @Column(name = "update_user")
    private String updateUser;

	public UUID getModelId() {
		return modelId;
	}

	public void setModelId(UUID modelId) {
		this.modelId = modelId;
	}

	public UUID getTvId() {
		return tvId;
	}

	public void setTvId(UUID tvId) {
		this.tvId = tvId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getModelDesc() {
		return modelDesc;
	}

	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}

	public UUID getFileId() {
		return fileId;
	}

	public void setFileId(UUID fileId) {
		this.fileId = fileId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
}
