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
@Table(name = "acme_tv", schema = "acme_space@cassandra-pu")
public class AcmeTv {
	@Id
    @Column(name = "tv_id")
    private UUID tvId;
    
    @Column(name = "tv_name")
    private String tvName;
    
    @Column(name = "tv_full_name")
    private String tvFullName;
    
    @Column(name = "tm6")
    private String tm6;
    
    @Column(name = "tech_cd")
    private String techCd;
    
    @Column(name = "tv_desc")
    private String tvDesc;   
    
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

	public UUID getTvId() {
		return tvId;
	}

	public void setTvId(UUID tvId) {
		this.tvId = tvId;
	}

	public String getTvName() {
		return tvName;
	}

	public void setTvName(String tvName) {
		this.tvName = tvName;
	}

	public String getTm6() {
		return tm6;
	}

	public void setTm6(String tm6) {
		this.tm6 = tm6;
	}

	public String getTechCd() {
		return techCd;
	}

	public void setTechCd(String techCd) {
		this.techCd = techCd;
	}

	public String getTvDesc() {
		return tvDesc;
	}

	public void setTvDesc(String tvDesc) {
		this.tvDesc = tvDesc;
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

	public String getTvFullName() {
		return tvFullName;
	}

	public void setTvFullName(String tvFullName) {
		this.tvFullName = tvFullName;
	}
}
