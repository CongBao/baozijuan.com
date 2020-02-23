package com.baozijuan.timegallery.service.impl;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.repository.UserRepository;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));
        return userRepository.save(user);
    }

    @Override
    public boolean isUserExistById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean isUserExistByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> loadAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User loadUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User loadUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Set<Role> loadRolesById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user == null ? null : user.getRoles();
    }

    @Override
    public Set<Role> loadRolesByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user == null ? null : user.getRoles();
    }

    @Override
    public Set<Role> loadRolesByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user == null ? null : user.getRoles();
    }

    @Override
    public User updateUsernameById(Long id, String username) {
        try {
            User user = userRepository.getOne(id);
            user.setUsername(username);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updatePasswordById(Long id, String password) {
        try {
            User user = userRepository.getOne(id);
            user.setPassword(passwordEncoder.encode(password));
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateDobById(Long id, Instant dob) {
        try {
            User user = userRepository.getOne(id);
            user.setDob(dob);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateEmailById(Long id, String email) {
        try {
            User user = userRepository.getOne(id);
            user.setEmail(email);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateGenderById(Long id, String gender) {
        try {
            User user = userRepository.getOne(id);
            user.setGender(gender);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateNicknameById(Long id, String nickname) {
        try {
            User user = userRepository.getOne(id);
            user.setNickname(nickname);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateSignatureById(Long id, String signature) {
        try {
            User user = userRepository.getOne(id);
            user.setSignature(signature);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateDescriptionById(Long id, String description) {
        try {
            User user = userRepository.getOne(id);
            user.setDescription(description);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateAccountNonExpiredById(Long id, boolean accountNonExpired) {
        try {
            User user = userRepository.getOne(id);
            user.setAccountNonExpired(accountNonExpired);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateAccountNonLockedById(Long id, boolean accountNonLocked) {
        try {
            User user = userRepository.getOne(id);
            user.setAccountNonLocked(accountNonLocked);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateCredentialsNonExpiredById(Long id, boolean credentialsNonExpired) {
        try {
            User user = userRepository.getOne(id);
            user.setCredentialsNonExpired(credentialsNonExpired);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User updateEnabledById(Long id, boolean enabled) {
        try {
            User user = userRepository.getOne(id);
            user.setEnabled(enabled);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User addRolesById(Long id, Set<Role> roles) {
        try {
            User user = userRepository.getOne(id);
            user.getRoles().addAll(roles);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public User removeRolesById(Long id, Set<Role> roles) {
        try {
            User user = userRepository.getOne(id);
            user.getRoles().removeAll(roles);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
