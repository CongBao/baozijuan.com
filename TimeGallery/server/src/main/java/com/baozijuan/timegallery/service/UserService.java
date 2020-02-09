package com.baozijuan.timegallery.service;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.bean.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.Instant;
import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {

    //// CREATE ////

    User registerUser(User user);

    //// CHECK ////

    boolean loginByUsernameAndPassword(String username, String password);

    boolean loginByEmailAndPassword(String email, String password);

    boolean isUserExistById(Long id);

    boolean isUserExistByUsername(String username);

    boolean isUserExistByEmail(String email);

    //// READ ////

    List<User> loadAllUsers();

    User loadUserById(Long id);

    User loadUserByEmail(String email);

    Set<Role> loadRolesById(Long id);

    Set<Role> loadRolesByUsername(String username);

    Set<Role> loadRolesByEmail(String email);

    //// UPDATE ////

    User updateUsernameById(Long id, String username);

    User updatePasswordById(Long id, String password);

    User updateDobById(Long id, Instant dob);

    User updateEmailById(Long id, String email);

    User updateGenderById(Long id, String gender);

    User updateNicknameById(Long id, String nickname);

    User updateSignatureById(Long id, String signature);

    User updateDescriptionById(Long id, String description);

    User updateAccountNonExpiredById(Long id, boolean accountNonExpired);

    User updateAccountNonLockedById(Long id, boolean accountNonLocked);

    User updateCredentialsNonExpiredById(Long id, boolean credentialsNonExpired);

    User updateEnabledById(Long id, boolean enabled);

    User addRolesById(Long id, Set<Role> roles);

    User removeRolesById(Long id, Set<Role> roles);

    //// DELETE ////

    void deleteUserById(Long id);

}
