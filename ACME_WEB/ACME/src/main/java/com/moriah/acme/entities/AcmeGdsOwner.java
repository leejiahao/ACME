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
@Table(name = "acme_gds_owner", schema = "acme_space@cassandra-pu")
public class AcmeGdsOwner {
	@Id
    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "gds_id")
    private UUID gdsId;

    @Column(name = "user_acct_name")
    private String userAcctName;
    
    @Column(name = "owner_type")
    private String ownerType;
    
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

	public UUID getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(UUID ownerId) {
		this.ownerId = ownerId;
	}

	public UUID getGdsId() {
		return gdsId;
	}

	public void setGdsId(UUID gdsId) {
		this.gdsId = gdsId;
	}

	public String getUserAcctName() {
		return userAcctName;
	}

	public void setUserAcctName(String userAcctName) {
		this.userAcctName = userAcctName;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
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
}
