package com.opensource.suggestionbox.dao.vo;

// Generated Jul 5, 2013 6:53:23 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SbDescription generated by hbm2java
 */
@Entity
@Table(name = "sb_description")
public class SbDescription implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String sgId;
	private String user;
	private Date updatedOn;
	private String isLiked;
	private String isPublic;
	private String description;
	private String fileUuid;
	private String fileName;

	public SbDescription() {
	}

	public SbDescription(String uuid) {
		this.uuid = uuid;
	}

	public SbDescription(String uuid, String sgId, String user, Date updatedOn,
			String isLiked, String isPublic, String description,
			String fileUuid, String fileName) {
		this.uuid = uuid;
		this.sgId = sgId;
		this.user = user;
		this.updatedOn = updatedOn;
		this.isLiked = isLiked;
		this.isPublic = isPublic;
		this.description = description;
		this.fileUuid = fileUuid;
		this.fileName = fileName;
	}

	@Id
	@Column(name = "uuid", unique = true, nullable = false, length = 150)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "sg_id", length = 150)
	public String getSgId() {
		return this.sgId;
	}

	public void setSgId(String sgId) {
		this.sgId = sgId;
	}

	@Column(name = "user", length = 50)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_on", length = 10)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Column(name = "is_liked", length = 2)
	public String getIsLiked() {
		return this.isLiked;
	}

	public void setIsLiked(String isLiked) {
		this.isLiked = isLiked;
	}

	@Column(name = "is_public", length = 3)
	public String getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	@Column(name = "description", length = 16777215)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "file_uuid", length = 150)
	public String getFileUuid() {
		return this.fileUuid;
	}

	public void setFileUuid(String fileUuid) {
		this.fileUuid = fileUuid;
	}

	@Column(name = "file_name", length = 150)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
