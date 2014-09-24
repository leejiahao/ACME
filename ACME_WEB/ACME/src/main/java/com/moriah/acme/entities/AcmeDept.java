package com.moriah.acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "acme_dept", schema = "acme_space@cassandra-pu")
public class AcmeDept {
    @Id
    @Column(name = "dept_id")
    private String deptId;
    
    @Column(name = "dept_level")
    private String deptLevel;
    
    @Column(name = "dept_mgr")
    private Float deptMgr;
    
    @Column(name = "dept_short_name")
    private Float deptShortName;
    
    @Column(name = "dept_long_name")
    private Float deptLongName;
    
    @Column(name = "dept_loc")
    private Float deptLoc;
    
    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "create_user")
    private String createUser;
    
    @Column(name = "update_time")
    private Date updateTime;
    
    @Column(name = "update_user")
    private String updateUser;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public Float getDeptMgr() {
		return deptMgr;
	}

	public void setDeptMgr(Float deptMgr) {
		this.deptMgr = deptMgr;
	}

	public Float getDeptShortName() {
		return deptShortName;
	}

	public void setDeptShortName(Float deptShortName) {
		this.deptShortName = deptShortName;
	}

	public Float getDeptLongName() {
		return deptLongName;
	}

	public void setDeptLongName(Float deptLongName) {
		this.deptLongName = deptLongName;
	}

	public Float getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(Float deptLoc) {
		this.deptLoc = deptLoc;
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
