package com.moriah.acme.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "acme_gds", schema = "acme_space@cassandra-pu")
public class AcmeGds {    
	@Id
    @Column(name = "gds_id")
    private UUID gdsId;
    
    @Column(name = "gds_path")
    private String gdsPath;
    
    @Column(name = "gds_name")
    private String gdsName;
    
    @Column(name = "gds_type")
    private String gdsType;
    
    @Column(name = "gds_desc")
    private String gdsDesc;
    
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

	public UUID getGdsId() {
		return gdsId;
	}

	public void setGdsId(UUID gdsId) {
		this.gdsId = gdsId;
	}

	public String getGdsPath() {
		return gdsPath;
	}

	public void setGdsPath(String gdsPath) {
		this.gdsPath = gdsPath;
	}

	public String getGdsName() {
		return gdsName;
	}

	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}

	public String getGdsType() {
		return gdsType;
	}

	public void setGdsType(String gdsType) {
		this.gdsType = gdsType;
	}

	public String getGdsDesc() {
		return gdsDesc;
	}

	public void setGdsDesc(String gdsDesc) {
		this.gdsDesc = gdsDesc;
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
