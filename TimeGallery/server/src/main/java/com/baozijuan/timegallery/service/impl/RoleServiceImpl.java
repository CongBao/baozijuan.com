package com.baozijuan.timegallery.service.impl;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.dao.RoleDao;
import com.baozijuan.timegallery.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
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
    public List<Role> loadAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role loadRoleById(Long id) {
        return roleDao.findById(id).orElse(null);
    }

    @Override
    public Role loadRoleByRoleName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }

    @Override
    public Role updateRoleNameById(Long id, String roleName) {
        try {
            Role role = roleDao.getOne(id);
            role.setRoleName(roleName);
            return roleDao.save(role);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public void deleteRoleById(Long id) {
        roleDao.deleteById(id);
    }

}
