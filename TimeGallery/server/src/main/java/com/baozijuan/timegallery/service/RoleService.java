package com.baozijuan.timegallery.service;

import com.baozijuan.timegallery.bean.domain.Role;

import java.util.List;

public interface RoleService {

    //// CREATE ////

    Role addRole(Role role);

    //// CHECK ////

    boolean isRoleExistById(Long id);

    boolean isRoleExistByRoleName(String roleName);

    //// READ ////

    List<Role> loadAllRoles();

    Role loadRoleById(Long id);

    Role loadRoleByRoleName(String roleName);

    //// UPDATE ////

    Role updateRoleNameById(Long id, String roleName);

    //// DELETE ////

    void deleteRoleById(Long id);

}
