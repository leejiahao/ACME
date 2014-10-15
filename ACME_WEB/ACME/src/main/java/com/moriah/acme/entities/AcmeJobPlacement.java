package com.moriah.acme.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.moriah.acme.utils.DateAdapter;

@Entity
@Table(name = "acme_job_placement", schema = "acme_space@cassandra-pu")
public class AcmeJobPlacement {
    @Id
    @Column(name = "job_placement_id")
    private UUID jobPlacementId;

    @Column(name = "job_id")
    private UUID jobId;
    
    @Column(name = "file_id")
    private UUID fileId;
    
    @Column(name = "job_placement_file_path")
    private String jobPlacementFilePath;
    
    @Column(name = "job_placement_file_name")
    private String jobPlacementFileName;

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

	public UUID getJobPlacementId() {
		return jobPlacementId;
	}

	public void setJobPlacementId(UUID jobPlacementId) {
		this.jobPlacementId = jobPlacementId;
	}

	public UUID getJobId() {
		return jobId;
	}

	public void setJobId(UUID jobId) {
		this.jobId = jobId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    @XmlJavaTypeAdapter(DateAdapter.class)
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

    @XmlJavaTypeAdapter(DateAdapter.class)
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

	public UUID getFileId() {
		return fileId;
	}

	public void setFileId(UUID fileId) {
		this.fileId = fileId;
	}

	public String getJobPlacementFilePath() {
		return jobPlacementFilePath;
	}

	public void setJobPlacementFilePath(String jobPlacementFilePath) {
		this.jobPlacementFilePath = jobPlacementFilePath;
	}

	public String getJobPlacementFileName() {
		return jobPlacementFileName;
	}

	public void setJobPlacementFileName(String jobPlacementFileName) {
		this.jobPlacementFileName = jobPlacementFileName;
	}

}
