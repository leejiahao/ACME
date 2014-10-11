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
@Table(name = "acme_job_drc", schema = "acme_space@cassandra-pu")
public class AcmeJobDrc {
    @Id
    @Column(name = "job_drc_id")
    private UUID jobDrcId;

    @Column(name = "job_id")
    private UUID jobId;
    
    @Column(name = "job_testline_id")
    private UUID jobTestlineId;
    
    @Column(name = "drc_deck_id")
    private UUID drcDeckId;

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

	public UUID getDrcDeckId() {
		return drcDeckId;
	}

	public void setDrcDeckId(UUID drcDeckId) {
		this.drcDeckId = drcDeckId;
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

	public UUID getJobTestlineId() {
		return jobTestlineId;
	}

	public void setJobTestlineId(UUID jobTestlineId) {
		this.jobTestlineId = jobTestlineId;
	}
}
