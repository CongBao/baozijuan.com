package com.baozijuan.timegallery.bean.payload;

import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.bean.User;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class LoginInfo implements Serializable {

    private Long id;
    private String jwt;

    private String username;
    private Instant dob;
    private String email;
    private String gender;
    private String nickname;
    private String signature;
    private String description;
    private List<Role> roles;

    public static LoginInfo of(User user, String jwt) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setId(user.getId());
        loginInfo.setJwt(jwt);
        loginInfo.setUsername(user.getUsername());
        loginInfo.setDob(user.getDob());
        loginInfo.setEmail(user.getEmail());
        loginInfo.setGender(user.getGender());
        loginInfo.setNickname(user.getNickname());
        loginInfo.setSignature(user.getSignature());
        loginInfo.setDescription(user.getDescription());
        loginInfo.setRoles(new ArrayList<>(user.getRoles()));
        return loginInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getDob() {
        return dob;
    }

    public void setDob(Instant dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
