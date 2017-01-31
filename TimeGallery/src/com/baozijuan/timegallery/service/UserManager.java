package com.baozijuan.timegallery.service;

import java.util.List;

import com.baozijuan.timegallery.domain.Authority;
import com.baozijuan.timegallery.domain.User;
import com.baozijuan.timegallery.exception.TGException;
import com.baozijuan.timegallery.vo.AuthorityBean;
import com.baozijuan.timegallery.vo.UserBean;

public interface UserManager {

	int LOGIN_FAIL = 0;

	int LOGIN_SUCCESS = 1;

	int REGIST_FAIL = 0;

	int REGIST_SUCCESS = 1;

	int validLogin(User user);

	int validRegist(User user);

	boolean isUserExist (String account);

	User getUserByAccount(String account) throws TGException;

	Authority getAuthorityByAccount(String account) throws TGException;

	UserBean getUserBeanByAccount(String account);

	AuthorityBean getAuthorityBeanByAccount(String account);

	List<AuthorityBean> getAllAuthorities() throws TGException;

	User updateLoginDate(User origin);

	User updateExperience(User origin, int exp);

	User updateAuthority(User origin, int level);

	User updateMailVerifyState(User origin, boolean verified);

	User updateAccount(User origin, String account);

	User updatePassword(User origin, String password);

	User updateUserInfo(UserBean update);

	void deleteAccount(User user);

}
