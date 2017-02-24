package com.baozijuan.timegallery.dao.impl;

import java.util.List;

import com.baozijuan.common.dao.impl.BaseDaoHibernate;
import com.baozijuan.timegallery.dao.UserDao;
import com.baozijuan.timegallery.domain.User;

public class UserDaoHibernate extends BaseDaoHibernate<User> implements UserDao {

	@Override
	public List<User> findByAccountAndPass(User user) {
		return find("select u from User u where u.account = ?0 and u.password = ?1", user.getAccount(),
				user.getPassword());
	}

	@Override
	public User findByAccount(String account) {
		List<User> users = find("select u from User u where u.account = ?0", account);
		if (users != null && users.size() >= 1)
			return users.get(0);
		return null;
	}

}
