package com.baozijuan.timegallery.dao.impl;

import java.util.List;

import com.baozijuan.common.dao.impl.BaseDaoHibernate;
import com.baozijuan.timegallery.dao.AuthorityDao;
import com.baozijuan.timegallery.domain.Authority;

public class AuthorityDaoHibernate extends BaseDaoHibernate<Authority> implements AuthorityDao {

	@Override
	public Authority findById(int id) {
		List<Authority> authorities = find("select a from Authority a where a.id = ?0", id);
		if (authorities != null && authorities.size() > 0)
			return authorities.get(0);
		return null;
	}

}
