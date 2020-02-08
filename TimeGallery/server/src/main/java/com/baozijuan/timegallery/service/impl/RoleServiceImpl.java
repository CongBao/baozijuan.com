package com.baozijuan.timegallery.service.impl;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.dao.RoleDao;
import com.baozijuan.timegallery.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role registerRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public boolean isRoleExistById(Long id) {
        return roleDao.existsById(id);
    }

    @Override
    public boolean isRoleExistByRoleName(String roleName) {
        return roleDao.existsByRoleName(roleName);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getOne(id);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }

    @Override
    public Role updateRoleNameById(Long id, String roleName) {
        Role role = roleDao.getOne(id);
        role.setRoleName(roleName);
        return roleDao.save(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleDao.deleteById(id);
    }

}
