package com.baozijuan.timegallery.dao;

import com.baozijuan.timegallery.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

    boolean existsByRoleName(String roleName);

    Role findByRoleName(String roleName);

}
