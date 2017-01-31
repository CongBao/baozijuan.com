package com.baozijuan.timegallery.dao;

import java.util.List;

import com.baozijuan.common.dao.BaseDao;
import com.baozijuan.timegallery.domain.User;

public interface UserDao extends BaseDao<User> {

	List<User> findByAccountAndPass(User user);

	User findByAccount(String account);

}
