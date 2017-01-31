package com.baozijuan.timegallery.vo;

import java.io.Serializable;

public class UserBean implements Serializable {

	private static final long serialVersionUID = -6089242350107199893L;

	private Integer id;
	private String account;
	private String familyName;
	private String givenName;
	private String nickname;
	private String gender;
	private String dob;
	private String phone;
	private String address;
	private String createdDate;
	private String updatedDate;
	private String lastLoginDate;
	private String signature;
	private String description;
	private boolean mailVerified;
	private Integer exp;
	private AuthorityBean authority;

	public UserBean() {
	}

	public UserBean(Integer id, String account, String familyName, String givenName, String nickname, String gender,
			String dob, String phone, String address, String createdDate, String updatedDate, String lastLoginDate,
			String signature, String description, boolean mailVerified, Integer exp, AuthorityBean authority) {
		super();
		this.id = id;
		this.account = account;
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

	public AuthorityBean getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityBean authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return id + "," + account + "," + familyName + "," + givenName + "," + nickname + "," + gender + "," + dob + ","
				+ phone + "," + address + "," + createdDate + "," + updatedDate + "," + lastLoginDate + "," + signature
				+ "," + description + "," + mailVerified + "," + exp + "," + authority;
	}

}
