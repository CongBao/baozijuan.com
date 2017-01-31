package com.baozijuan.timegallery.vo;

import java.io.Serializable;

public class AuthorityBean implements Serializable {

	private static final long serialVersionUID = -6942795763770881586L;

	private Integer id;
	private Integer maxExp;
	private boolean photo;
	private boolean comment;
	private boolean software;

	public AuthorityBean() {
	}

	public AuthorityBean(Integer id, Integer maxExp, boolean photo, boolean comment, boolean software) {
		super();
		this.id = id;
		this.maxExp = maxExp;
		this.photo = photo;
		this.comment = comment;
		this.software = software;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMaxExp() {
		return maxExp;
	}

	public void setMaxExp(Integer maxExp) {
		this.maxExp = maxExp;
	}

	public boolean isPhoto() {
		return photo;
	}

	public void setPhoto(boolean photo) {
		this.photo = photo;
	}

	public boolean isComment() {
		return comment;
	}

	public void setComment(boolean comment) {
		this.comment = comment;
	}

	public boolean isSoftware() {
		return software;
	}

	public void setSoftware(boolean software) {
		this.software = software;
	}

	@Override
	public String toString() {
		return id + "," + maxExp + "," + photo + "," + comment + "," + software;
	}

}
