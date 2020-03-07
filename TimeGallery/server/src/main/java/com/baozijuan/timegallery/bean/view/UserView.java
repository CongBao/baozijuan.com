package com.baozijuan.timegallery.bean.view;

import com.baozijuan.timegallery.bean.domain.Role;
import com.baozijuan.timegallery.bean.domain.User;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserView implements Serializable {

    private Long id;
    private String token;

    private String username;
    private Instant dob;
    private String email;
    private String gender;
    private String nickname;
    private String signature;
    private String description;
    private List<Role> roles;

    public static UserView of (User user) {
        return of(user, null);
    }

    public static UserView of(User user, String token) {
        if (user == null) {
            return null;
        }
        UserView userView = new UserView();
        userView.setId(user.getId());
        userView.setToken(token);
        userView.setUsername(user.getUsername());
        userView.setDob(user.getDob());
        userView.setEmail(user.getEmail());
        userView.setGender(user.getGender());
        userView.setNickname(user.getNickname());
        userView.setSignature(user.getSignature());
        userView.setDescription(user.getDescription());
        userView.setRoles(new ArrayList<>(user.getRoles()));
        return userView;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
