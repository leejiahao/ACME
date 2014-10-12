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
@Table(name = "acme_control_circuit", schema = "acme_space@cassandra-pu")
public class AcmeControlCircuit {
	@Id
    @Column(name = "circuit_id")
    private UUID circuitId;
    
    @Column(name = "tv_id")
    private UUID tvId;
    
    @Column(name = "circuit_name")
    private String circuitName;
    
    @Column(name = "circuit_type")
    private String circuitType;
    
    @Column(name = "circuit_desc")
    private String circuitDesc;
    
    @Column(name = "circuit_gds_id")
    private UUID circuitGdsId;
    
    @Column(name = "circuit_gds_file_path")
    private String circuitGdsFilePath;
    
    @Column(name = "circuit_gds_file_name")
    private String circuitGdsFileName;
    
    @Column(name = "circuit_gds_top_cell")
    private String circuitGdsTopCell;
    
    @Column(name = "coordinate_file_path")
    private String coordinateFilePath;
    
    @Column(name = "coordinate_file_name")
    private String coordinateFileName;
    
    @Column(name = "netlist_file_path")
    private String netlistFilePath;
    
    @Column(name = "netlist_file_name")
    private String netlistFileName;

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

	public UUID getCircuitId() {
		return circuitId;
	}

	public void setCircuitId(UUID circuitId) {
		this.circuitId = circuitId;
	}

	public UUID getTvId() {
		return tvId;
	}

	public void setTvId(UUID tvId) {
		this.tvId = tvId;
	}

	public String getCircuitName() {
		return circuitName;
	}

	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}

	public String getCircuitType() {
		return circuitType;
	}

	public void setCircuitType(String circuitType) {
		this.circuitType = circuitType;
	}

	public String getCircuitDesc() {
		return circuitDesc;
	}

	public void setCircuitDesc(String circuitDesc) {
		this.circuitDesc = circuitDesc;
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

	public String getCircuitGdsFilePath() {
		return circuitGdsFilePath;
	}

	public void setCircuitGdsFilePath(String circuitGdsFilePath) {
		this.circuitGdsFilePath = circuitGdsFilePath;
	}

	public String getCircuitGdsTopCell() {
		return circuitGdsTopCell;
	}

	public void setCircuitGdsTopCell(String circuitGdsTopCell) {
		this.circuitGdsTopCell = circuitGdsTopCell;
	}

	public String getCircuitGdsFileName() {
		return circuitGdsFileName;
	}

	public void setCircuitGdsFileName(String circuitGdsFileName) {
		this.circuitGdsFileName = circuitGdsFileName;
	}

	public String getCoordinateFilePath() {
		return coordinateFilePath;
	}

	public void setCoordinateFilePath(String coordinateFilePath) {
		this.coordinateFilePath = coordinateFilePath;
	}

	public String getCoordinateFileName() {
		return coordinateFileName;
	}

	public void setCoordinateFileName(String coordinateFileName) {
		this.coordinateFileName = coordinateFileName;
	}

	public String getNetlistFilePath() {
		return netlistFilePath;
	}

	public void setNetlistFilePath(String netlistFilePath) {
		this.netlistFilePath = netlistFilePath;
	}

	public String getNetlistFileName() {
		return netlistFileName;
	}

	public void setNetlistFileName(String netlistFileName) {
		this.netlistFileName = netlistFileName;
	}

	public UUID getCircuitGdsId() {
		return circuitGdsId;
	}

	public void setCircuitGdsId(UUID circuitGdsId) {
		this.circuitGdsId = circuitGdsId;
	}
}
