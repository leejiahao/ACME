package com.moriah.acme.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "acme_job_spice", schema = "acme_space@cassandra-pu")
public class AcmeJobSpice {
    @Id
    @Column(name = "job_spice_id")
    private UUID jobDrcId;

    @Column(name = "job_id")
    private UUID jobId;
    
    @Column(name = "spice_model_id")
    private UUID spiceModelId;

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

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public UUID getJobDrcId() {
		return jobDrcId;
	}

	public void setJobDrcId(UUID jobDrcId) {
		this.jobDrcId = jobDrcId;
	}

	public UUID getJobId() {
		return jobId;
	}

	public void setJobId(UUID jobId) {
		this.jobId = jobId;
	}

	public UUID getSpiceModelId() {
		return spiceModelId;
	}

	public void setSpiceModelId(UUID spiceModelId) {
		this.spiceModelId = spiceModelId;
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

}
