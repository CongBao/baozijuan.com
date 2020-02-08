package com.baozijuan.timegallery.service.impl;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.dao.UserDao;
import com.baozijuan.timegallery.service.UserService;
import com.baozijuan.timegallery.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User registerUser(User user) {
        user.setPassword(DigestUtil.digest(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public boolean loginByUsernameAndPassword(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, DigestUtil.digest(password));
        return user != null;
    }

    @Override
    public boolean loginByEmailAndPassword(String email, String password) {
        User user = userDao.findByEmailAndPassword(email, DigestUtil.digest(password));
        return user != null;
    }

    @Override
    public boolean isUserExistById(Long id) {
        return userDao.existsById(id);
    }

    @Override
    public boolean isUserExistByUsername(String username) {
        return userDao.existsByUsername(username);
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return userDao.existsByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Set<Role> getRolesById(Long id) {
        return userDao.getOne(id).getRoles();
    }

    @Override
    public Set<Role> getRolesByUsername(String username) {
        return userDao.findByUsername(username).getRoles();
    }

    @Override
    public Set<Role> getRolesByEmail(String email) {
        return userDao.findByEmail(email).getRoles();
    }

    @Override
    public User updateUsernameById(Long id, String username) {
        User user = userDao.getOne(id);
        user.setUsername(username);
        return userDao.save(user);
    }

    @Override
    public User updatePasswordById(Long id, String password) {
        User user = userDao.getOne(id);
        user.setPassword(password);
        return userDao.save(user);
    }

    @Override
    public User updateDobById(Long id, Instant dob) {
        User user = userDao.getOne(id);
        user.setDob(dob);
        return userDao.save(user);
    }

    @Override
    public User updateEmailById(Long id, String email) {
        User user = userDao.getOne(id);
        user.setEmail(email);
        return userDao.save(user);
    }

    @Override
    public User updateGenderById(Long id, String gender) {
        User user = userDao.getOne(id);
        user.setGender(gender);
        return userDao.save(user);
    }

    @Override
    public User updateNicknameById(Long id, String nickname) {
        User user = userDao.getOne(id);
        user.setNickname(nickname);
        return userDao.save(user);
    }

    @Override
    public User updateSignatureById(Long id, String signature) {
        User user = userDao.getOne(id);
        user.setSignature(signature);
        return userDao.save(user);
    }

    @Override
    public User updateDescriptionById(Long id, String description) {
        User user = userDao.getOne(id);
        user.setDescription(description);
        return userDao.save(user);
    }

    @Override
    public User updateEnabledById(Long id, boolean enabled) {
        User user = userDao.getOne(id);
        user.setEnabled(enabled);
        return userDao.save(user);
    }

    @Override
    public User addRolesById(Long id, Set<Role> roles) {
        User user = userDao.getOne(id);
        user.getRoles().addAll(roles);
        return userDao.save(user);
    }

    @Override
    public User removeRolesById(Long id, Set<Role> roles) {
        User user = userDao.getOne(id);
        user.getRoles().removeAll(roles);
        return userDao.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }

}
