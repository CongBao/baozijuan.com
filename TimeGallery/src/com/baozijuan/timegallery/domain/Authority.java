package com.baozijuan.timegallery.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_authority")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Authority implements Serializable {

	private static final long serialVersionUID = -6708414072710024056L;

	@Id
	@Column(name = "authority_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "max_exp", nullable = false)
	private Integer maxExp;

	@Column(name = "photo", nullable = false)
	@Type(type = "yes_no")
	private boolean photo;

	@Column(name = "comment", nullable = false)
	@Type(type = "yes_no")
	private boolean comment;

	@Column(name = "software", nullable = false)
	@Type(type = "yes_no")
	private boolean software;

	// reserve for authorities
	// all authorities should be boolean type

	@OneToMany(targetEntity = User.class, mappedBy = "authority")
	private Set<User> users = new HashSet<>();

	public Authority() {
	}

	public Authority(Integer id, Integer maxExp, boolean photo, boolean comment, boolean software, Set<User> users) {
		super();
		this.id = id;
		this.maxExp = maxExp;
		this.photo = photo;
		this.comment = comment;
		this.software = software;
		this.users = users;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
