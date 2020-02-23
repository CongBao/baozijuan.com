package com.baozijuan.timegallery.service.impl;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.repository.RoleRepository;
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
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public boolean isRoleExistById(Long id) {
        return roleRepository.existsById(id);
    }

    @Override
    public boolean isRoleExistByRoleName(String roleName) {
        return roleRepository.existsByRoleName(roleName);
    }

    @Override
    public List<Role> loadAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role loadRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role loadRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role updateRoleNameById(Long id, String roleName) {
        try {
            Role role = roleRepository.getOne(id);
            role.setRoleName(roleName);
            return roleRepository.save(role);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

}
