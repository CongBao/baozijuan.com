package com.baozijuan.timegallery.service.impl;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.dao.UserDao;
import com.baozijuan.timegallery.service.UserService;
import com.baozijuan.timegallery.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User registerUser(User user) {
        user.setPassword(DigestUtil.digest(user.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));
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
    public List<User> loadAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User loadUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User loadUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Set<Role> loadRolesById(Long id) {
        User user = userDao.findById(id).orElse(null);
        return user == null ? null : user.getRoles();
    }

    @Override
    public Set<Role> loadRolesByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user == null ? null : user.getRoles();
    }

    @Override
    public Set<Role> loadRolesByEmail(String email) {
        User user = userDao.findByEmail(email);
        return user == null ? null : user.getRoles();
    }

    @Override
    public User updateUsernameById(Long id, String username) {
        try {
            User user = userDao.getOne(id);
            user.setUsername(username);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updatePasswordById(Long id, String password) {
        try {
            User user = userDao.getOne(id);
            user.setPassword(DigestUtil.digest(password));
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateDobById(Long id, Instant dob) {
        try {
            User user = userDao.getOne(id);
            user.setDob(dob);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateEmailById(Long id, String email) {
        try {
            User user = userDao.getOne(id);
            user.setEmail(email);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateGenderById(Long id, String gender) {
        try {
            User user = userDao.getOne(id);
            user.setGender(gender);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateNicknameById(Long id, String nickname) {
        try {
            User user = userDao.getOne(id);
            user.setNickname(nickname);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateSignatureById(Long id, String signature) {
        try {
            User user = userDao.getOne(id);
            user.setSignature(signature);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateDescriptionById(Long id, String description) {
        try {
            User user = userDao.getOne(id);
            user.setDescription(description);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateAccountNonExpiredById(Long id, boolean accountNonExpired) {
        try {
            User user = userDao.getOne(id);
            user.setAccountNonExpired(accountNonExpired);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateAccountNonLockedById(Long id, boolean accountNonLocked) {
        try {
            User user = userDao.getOne(id);
            user.setAccountNonLocked(accountNonLocked);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateCredentialsNonExpiredById(Long id, boolean credentialsNonExpired) {
        try {
            User user = userDao.getOne(id);
            user.setCredentialsNonExpired(credentialsNonExpired);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateEnabledById(Long id, boolean enabled) {
        try {
            User user = userDao.getOne(id);
            user.setEnabled(enabled);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User addRolesById(Long id, Set<Role> roles) {
        try {
            User user = userDao.getOne(id);
            user.getRoles().addAll(roles);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User removeRolesById(Long id, Set<Role> roles) {
        try {
            User user = userDao.getOne(id);
            user.getRoles().removeAll(roles);
            return userDao.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }

}
