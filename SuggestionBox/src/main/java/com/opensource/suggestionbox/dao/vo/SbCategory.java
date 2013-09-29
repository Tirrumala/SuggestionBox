package com.opensource.suggestionbox.dao.vo;

// Generated Jul 5, 2013 12:07:07 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SbCategory generated by hbm2java
 */
@Entity
@Table(name = "sb_category")
public class SbCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String category;
	private Integer totalLevel;
	private String levelMinApvMap;

	public SbCategory() {
	}

	public SbCategory(String category) {
		this.category = category;
	}

	public SbCategory(String category, Integer totalLevel, String levelMinApvMap) {
		this.category = category;
		this.totalLevel = totalLevel;
		this.levelMinApvMap = levelMinApvMap;
	}

	@Id
	@Column(name = "category", unique = true, nullable = false, length = 100)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "total_level")
	public Integer getTotalLevel() {
		return this.totalLevel;
	}

	public void setTotalLevel(Integer totalLevel) {
		this.totalLevel = totalLevel;
	}

	@Column(name = "level_min_apv_map", length = 100)
	public String getLevelMinApvMap() {
		return this.levelMinApvMap;
	}

	public void setLevelMinApvMap(String levelMinApvMap) {
		this.levelMinApvMap = levelMinApvMap;
	}

}