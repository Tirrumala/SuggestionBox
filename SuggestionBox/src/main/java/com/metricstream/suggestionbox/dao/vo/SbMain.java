package com.opensource.suggestionbox.dao.vo;

// Generated Jul 5, 2013 12:09:59 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SbMain generated by hbm2java
 */
@Entity
@Table(name = "sb_main")
public class SbMain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sgId;
	private String title;
	private String category;
	private Date createdOn;
	private String owner;
	private String approveStatus;
	private Integer approveLevel;

	public SbMain() {
	}

	public SbMain(String sgId) {
		this.sgId = sgId;
	}

	public SbMain(String sgId, String title, String category, Date createdOn,
			String owner, String approveStatus, Integer approveLevel) {
		this.sgId = sgId;
		this.title = title;
		this.category = category;
		this.createdOn = createdOn;
		this.owner = owner;
		this.approveStatus = approveStatus;
		this.approveLevel = approveLevel;
	}

	@Id
	@Column(name = "sg_id", unique = true, nullable = false, length = 150)
	public String getSgId() {
		return this.sgId;
	}

	public void setSgId(String sgId) {
		this.sgId = sgId;
	}

	@Column(name = "title", length = 250)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "category", length = 100)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_on", length = 10)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "owner", length = 50)
	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Column(name = "approve_status", length = 25)
	public String getApproveStatus() {
		return this.approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	@Column(name = "approve_level")
	public Integer getApproveLevel() {
		return this.approveLevel;
	}

	public void setApproveLevel(Integer approveLevel) {
		this.approveLevel = approveLevel;
	}

}
