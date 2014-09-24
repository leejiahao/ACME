package com.moriah.acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "acme_emp", schema = "acme_space@cassandra-pu")
public class AcmeEmp {
	@Id
    @Column(name = "empl_id")
    private String emplId;
	
    @Column(name = "user_acct_name")
    private String userAcctName;
    
    @Column(name = "co_cd")
    private String coCd;
    
    @Column(name = "dept_id")
    private String deptId;
    
    @Column(name = "user_engl_name")
    private String userEnglName;
    
    @Column(name = "user_chns_name")
    private String userChnsName;
    
    @Column(name = "user_email_addr")
    private String userEmailAddr;
    
    @Column(name = "supv_user_acct_name")
    private String supvUserAcctName;
    
    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "create_user")
    private String createUser;
    
    @Column(name = "update_time")
    private Date updateTime;
    
    @Column(name = "update_user")
    private String updateUser;

	public String getEmplId() {
		return emplId;
	}

	public void setEmplId(String emplId) {
		this.emplId = emplId;
	}

	public String getUserAcctName() {
		return userAcctName;
	}

	public void setUserAcctName(String userAcctName) {
		this.userAcctName = userAcctName;
	}

	public String getCoCd() {
		return coCd;
	}

	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getUserEnglName() {
		return userEnglName;
	}

	public void setUserEnglName(String userEnglName) {
		this.userEnglName = userEnglName;
	}

	public String getUserChnsName() {
		return userChnsName;
	}

	public void setUserChnsName(String userChnsName) {
		this.userChnsName = userChnsName;
	}

	public String getUserEmailAddr() {
		return userEmailAddr;
	}

	public void setUserEmailAddr(String userEmailAddr) {
		this.userEmailAddr = userEmailAddr;
	}

	public String getSupvUserAcctName() {
		return supvUserAcctName;
	}

	public void setSupvUserAcctName(String supvUserAcctName) {
		this.supvUserAcctName = supvUserAcctName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
