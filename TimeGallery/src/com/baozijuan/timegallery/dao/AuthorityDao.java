package com.baozijuan.timegallery.dao;

import com.baozijuan.common.dao.BaseDao;
import com.baozijuan.timegallery.domain.Authority;

public interface AuthorityDao extends BaseDao<Authority> {

	Authority findById(int id);

}
