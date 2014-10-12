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
@Table(name = "acme_job_lvs", schema = "acme_space@cassandra-pu")
public class AcmeJobLvs {
    @Id
    @Column(name = "job_lvs_id")
    private UUID jobLvsId;

    @Column(name = "job_id")
    private UUID jobId;
    
    @Column(name = "job_testline_id")
    private UUID jobTestlineId;
    
    @Column(name = "testline_name")
    private String testlineName;
    
    @Column(name = "lvs_deck_id")
    private UUID lvsDeckId;

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

	public UUID getJobLvsId() {
		return jobLvsId;
	}

	public void setJobLvsId(UUID jobLvsId) {
		this.jobLvsId = jobLvsId;
	}

	public UUID getJobId() {
		return jobId;
	}

	public void setJobId(UUID jobId) {
		this.jobId = jobId;
	}

	public UUID getLvsDeckId() {
		return lvsDeckId;
	}

	public void setLvsDeckId(UUID lvsDeckId) {
		this.lvsDeckId = lvsDeckId;
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

	public String getTestlineName() {
		return testlineName;
	}

	public void setTestlineName(String testlineName) {
		this.testlineName = testlineName;
	}

}
