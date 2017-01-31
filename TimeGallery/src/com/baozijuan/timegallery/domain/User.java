package com.baozijuan.timegallery.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_info")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {

	private static final long serialVersionUID = -8690329897890058422L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	////////// Account Information //////////

	@Column(name = "account", nullable = false, length = 64, unique = true)
	private String account;

	@Column(name = "password", nullable = false, length = 64)
	private String password;

	////////// Personal Information //////////

	@Column(name = "family_name", length = 64)
	private String familyName;

	@Column(name = "given_name", length = 64)
	private String givenName;

	@Column(name = "nickname", length = 64)
	private String nickname;

	@Column(name = "gender", length = 16)
	private String gender;

	@Column(name = "dob", length = 64)
	private String dob;

	@Column(name = "phone", length = 64)
	private String phone;

	@Column(name = "address")
	private String address;

	////////// Profile Information //////////

	@Column(name = "created_date", length = 64)
	private String createdDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date());

	@Column(name = "updated_date", length = 64)
	private String updatedDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date());

	@Column(name = "last_login_date", length = 64)
	private String lastLoginDate = "";

	@Column(name = "signature")
	private String signature = "No Signature";

	@Column(name = "description")
	private String description = "No Description";

	@Column(name = "mail_verified")
	@Type(type = "yes_no")
	private boolean mailVerified = false;

	@Column(name = "exp")
	private Integer exp = 0;

	@ManyToOne(targetEntity = Authority.class)
	@JoinColumn(name = "authority_id", referencedColumnName = "authority_id", nullable = false)
	private Authority authority = new Authority(1, 10, false, false, false, null);

	public User() {
	}

	public User(Integer id, String account, String password, String familyName, String givenName, String nickname,
			String gender, String dob, String phone, String address, String createdDate, String updatedDate,
			String lastLoginDate, String signature, String description, boolean mailVerified, Integer exp,
			Authority authority) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.familyName = familyName;
		this.givenName = givenName;
		this.nickname = nickname;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.lastLoginDate = lastLoginDate;
		this.signature = signature;
		this.description = description;
		this.mailVerified = mailVerified;
		this.exp = exp;
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isMailVerified() {
		return mailVerified;
	}

	public void setMailVerified(boolean mailVerified) {
		this.mailVerified = mailVerified;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
