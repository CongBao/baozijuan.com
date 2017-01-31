package com.baozijuan.timegallery.service.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.baozijuan.timegallery.dao.AuthorityDao;
import com.baozijuan.timegallery.dao.UserDao;
import com.baozijuan.timegallery.domain.Authority;
import com.baozijuan.timegallery.domain.User;
import com.baozijuan.timegallery.exception.TGException;
import com.baozijuan.timegallery.service.UserManager;
import com.baozijuan.timegallery.vo.AuthorityBean;
import com.baozijuan.timegallery.vo.UserBean;

public class UserManagerImpl implements UserManager {

	private AuthorityDao authorityDao;
	private UserDao userDao;

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int validLogin(User user) {
		if (userDao.findByAccountAndPass(user).size() >= 1)
			return LOGIN_SUCCESS;
		return LOGIN_FAIL;
	}

	@Override
	public int validRegist(User user) {
		if (userDao.findByAccountAndPass(user).size() < 1)
			if (userDao.save(user) != null)
				return REGIST_SUCCESS;
		return REGIST_FAIL;
	}

	@Override
	public boolean isUserExist(String account) {
		if(userDao.findByAccount(account) != null)
			return true;
		return false;
	}

	@Override
	public User getUserByAccount(String account) throws TGException {
		User user = userDao.findByAccount(account);
		if (user == null)
			throw new TGException("None User Exception");
		return user;
	}

	@Override
	public Authority getAuthorityByAccount(String account) throws TGException {
		User user = getUserByAccount(account);
		Authority authority = user.getAuthority();
		if (authority == null)
			throw new TGException("None Authority Exception");
		return authority;
	}

	@Override
	public UserBean getUserBeanByAccount(String account) {
		User user = getUserByAccount(account);
		return new UserBean(user.getId(), user.getAccount(), user.getFamilyName(), user.getGivenName(),
				user.getNickname(), user.getGender(), user.getDob(), user.getPhone(), user.getAddress(),
				user.getCreatedDate(), user.getUpdatedDate(), user.getLastLoginDate(), user.getSignature(),
				user.getDescription(), user.isMailVerified(), user.getExp(),
				getAuthorityBeanByAccount(user.getAccount()));
	}

	@Override
	public AuthorityBean getAuthorityBeanByAccount(String account) {
		Authority authority = getAuthorityByAccount(account);
		return new AuthorityBean(authority.getId(), authority.getMaxExp(), authority.isPhoto(), authority.isComment(),
				authority.isSoftware());
	}

	@Override
	public List<AuthorityBean> getAllAuthorities() throws TGException {
		List<Authority> authorities = authorityDao.findAll(Authority.class);
		if (authorities == null || authorities.isEmpty())
			throw new TGException("None Authority Exception");
		List<AuthorityBean> result = new ArrayList<>();
		for (Authority authority : authorities)
			result.add(new AuthorityBean(authority.getId(), authority.getMaxExp(), authority.isPhoto(),
					authority.isComment(), authority.isSoftware()));
		return result;
	}

	@Override
	public User updateLoginDate(User origin) {
		User change = origin;
		change.setLastLoginDate(DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		userDao.update(change);
		return change;
	}

	@Override
	public User updateExperience(User origin, int exp) {
		User change = origin;
		change.setExp(exp);
		userDao.update(change);
		return change;
	}

	@Override
	public User updateAuthority(User origin, int level) {
		User change = origin;
		Authority authority = authorityDao.findById(level);
		if (authority != null) {
			change.setAuthority(authority);
			userDao.update(change);
			return change;
		}
		return null;
	}

	@Override
	public User updateMailVerifyState(User origin, boolean verified) {
		User change = origin;
		change.setMailVerified(verified);
		change.setUpdatedDate(DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		userDao.update(change);
		return change;
	}

	@Override
	public User updateAccount(User origin, String account) {
		if (userDao.findByAccount(account) == null) {
			User change = origin;
			change.setAccount(account);
			change.setUpdatedDate(DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
			userDao.update(change);
			return change;
		} else {
			return null;
		}
	}

	@Override
	public User updatePassword(User origin, String password) {
		User change = origin;
		change.setPassword(password);
		change.setUpdatedDate(DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		userDao.update(change);
		return change;
	}

	@Override
	public User updateUserInfo(UserBean update) {
		User change = userDao.findByAccount(update.getAccount());
		if (!update.getSignature().equalsIgnoreCase(""))
			change.setSignature(update.getSignature());
		if (!update.getDescription().equalsIgnoreCase(""))
			change.setDescription(update.getDescription());
		if (!update.getNickname().equalsIgnoreCase(""))
			change.setNickname(update.getNickname());
		if (!update.getFamilyName().equalsIgnoreCase(""))
			change.setFamilyName(update.getFamilyName());
		if (!update.getGivenName().equalsIgnoreCase(""))
			change.setGivenName(update.getGivenName());
		if (!update.getGender().equalsIgnoreCase(""))
			change.setGender(update.getGender());
		if (!update.getDob().equalsIgnoreCase(""))
			change.setDob(update.getDob());
		if (!update.getPhone().equalsIgnoreCase(""))
			change.setPhone(update.getPhone());
		if (!update.getAddress().equalsIgnoreCase(""))
			change.setAddress(update.getAddress());
		change.setUpdatedDate(DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		userDao.update(change);
		return change;
	}

	@Override
	public void deleteAccount(User user) {
		userDao.delete(user);
	}

}
