package com.baozijuan.timegallery.controller.user;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.view.UserView;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/rest/user")
@PreAuthorize("hasRole('USER')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Response<UserView> get(@PathVariable Long userId) {
        return Response.okOrNotFound(UserView.of(userService.loadUserById(userId)));
    }

    @PutMapping("/{userId}/username")
    public Response<UserView> updateUsername(@PathVariable Long userId, @RequestParam String username) {
        return Response.okOrNotFound(UserView.of(userService.updateUsernameById(userId, username)));
    }

    @PutMapping("/{userId}/password")
    public Response<UserView> updatePassword(@PathVariable Long userId, @RequestParam String password) {
        return Response.okOrNotFound(UserView.of(userService.updatePasswordById(userId, password)));
    }

    @PutMapping("/{userId}/dob")
    public Response<UserView> updateDob(@PathVariable Long userId, @RequestParam String isoUTCDate) {
        return Response.okOrNotFound(UserView.of(userService.updateDobById(userId, Instant.parse(isoUTCDate))));
    }

    @PutMapping("/{userId}/email")
    public Response<UserView> updateEmail(@PathVariable Long userId, @RequestParam String email) {
        return Response.okOrNotFound(UserView.of(userService.updateEmailById(userId, email)));
    }

    @PutMapping("/{userId}/gender")
    public Response<UserView> updateGender(@PathVariable Long userId, @RequestParam String gender) {
        return Response.okOrNotFound(UserView.of(userService.updateGenderById(userId, gender)));
    }

    @PutMapping("/{userId}/nickname")
    public Response<UserView> updateNickname(@PathVariable Long userId, @RequestParam String nickname) {
        return Response.okOrNotFound(UserView.of(userService.updateNicknameById(userId, nickname)));
    }

    @PutMapping("/{userId}/signature")
    public Response<UserView> updateSignature(@PathVariable Long userId, @RequestParam String signature) {
        return Response.okOrNotFound(UserView.of(userService.updateSignatureById(userId, signature)));
    }

    @PutMapping("/{userId}/description")
    public Response<UserView> updateDescription(@PathVariable Long userId, @RequestParam String description) {
        return Response.okOrNotFound(UserView.of(userService.updateDescriptionById(userId, description)));
    }

    @DeleteMapping("/{userId}")
    public Response<?> delete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return Response.ok();
    }

}
