package com.baozijuan.timegallery.service;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.bean.User;

import java.util.List;
import java.util.Set;

public interface RoleService {

    //// CREATE ////

    Role registerRole(Role role);

    //// CHECK ////

    boolean isRoleExistById(Long id);

    boolean isRoleExistByRoleName(String roleName);

    //// READ ////

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role getRoleByRoleName(String roleName);

    //// UPDATE ////

    Role updateRoleNameById(Long id, String roleName);

    //// DELETE ////

    void deleteRoleById(Long id);

}
