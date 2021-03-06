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
@Table(name = "acme_job_src_gds", schema = "acme_space@cassandra-pu")
public class AcmeJobSrcGds {
    @Id
    @Column(name = "job_src_gds_id")
    private UUID jobSrcGdsId;

    @Column(name = "job_id")
    private UUID jobId;
    
    @Column(name = "gds_id")
    private UUID gdsId;
    
    @Column(name = "job_src_gds_file_path")
    private String jobSrcGdsFilePath;
    
    @Column(name = "job_src_gds_file_name")
    private String jobSrcGdsFileName;

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

	public UUID getJobSrcGdsId() {
		return jobSrcGdsId;
	}

	public void setJobSrcGdsId(UUID jobSrcGdsId) {
		this.jobSrcGdsId = jobSrcGdsId;
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

	public UUID getGdsId() {
		return gdsId;
	}

	public void setGdsId(UUID gdsId) {
		this.gdsId = gdsId;
	}

	public String getJobSrcGdsFilePath() {
		return jobSrcGdsFilePath;
	}

	public void setJobSrcGdsFilePath(String jobSrcGdsFilePath) {
		this.jobSrcGdsFilePath = jobSrcGdsFilePath;
	}

	public String getJobSrcGdsFileName() {
		return jobSrcGdsFileName;
	}

	public void setJobSrcGdsFileName(String jobSrcGdsFileName) {
		this.jobSrcGdsFileName = jobSrcGdsFileName;
	}

}
