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
@Table(name = "acme_lvs_deck", schema = "acme_space@cassandra-pu")
public class AcmeLvsDeck {
	@Id
    @Column(name = "deck_id")
    private UUID deckId;
    
    @Column(name = "tv_id")
    private UUID tvId;
    
    @Column(name = "deck_name")
    private String deckName;
    
    @Column(name = "deck_type")
    private String deckType;
    
    @Column(name = "deck_desc")
    private String deckDesc;
    
    @Column(name = "deck_file_path")
    private String deckFilePath;
    
    @Column(name = "deck_file_name")
    private String deckFileName;

    @Column(name = "file_id")
    private UUID fileId;
    
    @Column(name = "is_primary")
    private Boolean isPrimary;

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

	public UUID getDeckId() {
		return deckId;
	}

	public void setDeckId(UUID deckId) {
		this.deckId = deckId;
	}

	public UUID getTvId() {
		return tvId;
	}

	public void setTvId(UUID tvId) {
		this.tvId = tvId;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}

	public String getDeckType() {
		return deckType;
	}

	public void setDeckType(String deckType) {
		this.deckType = deckType;
	}

	public String getDeckDesc() {
		return deckDesc;
	}

	public void setDeckDesc(String deckDesc) {
		this.deckDesc = deckDesc;
	}

	public UUID getFileId() {
		return fileId;
	}

	public void setFileId(UUID fileId) {
		this.fileId = fileId;
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

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getDeckFilePath() {
		return deckFilePath;
	}

	public void setDeckFilePath(String deckFilePath) {
		this.deckFilePath = deckFilePath;
	}

	public String getDeckFileName() {
		return deckFileName;
	}

	public void setDeckFileName(String deckFileName) {
		this.deckFileName = deckFileName;
	}
}
