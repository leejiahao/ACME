package com.moriah.acme.entities;

import java.util.Date;
import java.util.UUID;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.moriah.acme.utils.DateAdapter;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobInfo> acmeJobInfoList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobPlacement> acmeJobPlacementList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobSrcGds> acmeJobSrcGdsList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobTestline> acmeJobTestlineList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobNetlist> acmeJobNetlistList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobTestbench> acmeJobTestbenchList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobDrc> acmeJobDrcList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobLvs> acmeJobLvsList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobRc> acmeJobRcList;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<AcmeJobSpice> acmeJobSpiceList;

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

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public List<AcmeJobTestline> getAcmeJobTestlineList() {
		return acmeJobTestlineList;
	}

	public void setAcmeJobTestlineList(List<AcmeJobTestline> acmeJobTestlineList) {
		this.acmeJobTestlineList = acmeJobTestlineList;
	}

	public List<AcmeJobInfo> getAcmeJobInfoList() {
		return acmeJobInfoList;
	}

	public void setAcmeJobInfoList(List<AcmeJobInfo> acmeJobInfoList) {
		this.acmeJobInfoList = acmeJobInfoList;
	}

	public List<AcmeJobPlacement> getAcmeJobPlacementList() {
		return acmeJobPlacementList;
	}

	public void setAcmeJobPlacementList(List<AcmeJobPlacement> acmeJobPlacementList) {
		this.acmeJobPlacementList = acmeJobPlacementList;
	}

	public List<AcmeJobSrcGds> getAcmeJobSrcGdsList() {
		return acmeJobSrcGdsList;
	}

	public void setAcmeJobSrcGdsList(List<AcmeJobSrcGds> acmeJobSrcGdsList) {
		this.acmeJobSrcGdsList = acmeJobSrcGdsList;
	}

	public List<AcmeJobNetlist> getAcmeJobNetlistList() {
		return acmeJobNetlistList;
	}

	public void setAcmeJobNetlistList(List<AcmeJobNetlist> acmeJobNetlistList) {
		this.acmeJobNetlistList = acmeJobNetlistList;
	}

	public List<AcmeJobTestbench> getAcmeJobTestbenchList() {
		return acmeJobTestbenchList;
	}

	public void setAcmeJobTestbenchList(List<AcmeJobTestbench> acmeJobTestbenchList) {
		this.acmeJobTestbenchList = acmeJobTestbenchList;
	}

	public List<AcmeJobDrc> getAcmeJobDrcList() {
		return acmeJobDrcList;
	}

	public void setAcmeJobDrcList(List<AcmeJobDrc> acmeJobDrcList) {
		this.acmeJobDrcList = acmeJobDrcList;
	}

	public List<AcmeJobLvs> getAcmeJobLvsList() {
		return acmeJobLvsList;
	}

	public void setAcmeJobLvsList(List<AcmeJobLvs> acmeJobLvsList) {
		this.acmeJobLvsList = acmeJobLvsList;
	}

	public List<AcmeJobRc> getAcmeJobRcList() {
		return acmeJobRcList;
	}

	public void setAcmeJobRcList(List<AcmeJobRc> acmeJobRcList) {
		this.acmeJobRcList = acmeJobRcList;
	}

	public List<AcmeJobSpice> getAcmeJobSpiceList() {
		return acmeJobSpiceList;
	}

	public void setAcmeJobSpiceList(List<AcmeJobSpice> acmeJobSpiceList) {
		this.acmeJobSpiceList = acmeJobSpiceList;
	}
}
