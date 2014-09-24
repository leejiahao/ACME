package com.moriah.acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "acme_basic_geom", schema = "acme_space@cassandra-pu")
public class AcmeBasicGeom {
    @Id
    @Column(name = "geom_cd")
    private String geomCd;
    
    @Column(name = "geom_name")
    private String geomName;
    
    @Column(name = "geom_num")
    private Float geomNum;
    
    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "create_user")
    private String createUser;

	public String getGeomCd() {
		return geomCd;
	}

	public void setGeomCd(String geomCd) {
		this.geomCd = geomCd;
	}

	public String getGeomName() {
		return geomName;
	}

	public void setGeomName(String geomName) {
		this.geomName = geomName;
	}

	public Float getGeomNum() {
		return geomNum;
	}

	public void setGeomNum(Float geomNum) {
		this.geomNum = geomNum;
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
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
