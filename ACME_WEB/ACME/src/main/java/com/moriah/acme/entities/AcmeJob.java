package com.moriah.acme.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "acme_job", schema = "acme_space@cassandra-pu")
public class AcmeJob {
    @Id
    @Column(name = "job_id")
    private UUID jobId;
    
    @Column(name = "tv_id")
    private UUID tvId;
    
    @Column(name = "job_name")
    private String jobName;
    
    @Column(name = "job_type")
    private String jobType;
    
    @Column(name = "job_desc")
    private String jobDesc;
    
    @Column(name = "owner")
    private String owner;
    
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

	public UUID getJobId() {
		return jobId;
	}

	public void setJobId(UUID jobId) {
		this.jobId = jobId;
	}

	public UUID getTvId() {
		return tvId;
	}

	public void setTvId(UUID tvId) {
		this.tvId = tvId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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
}
