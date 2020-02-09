package com.baozijuan.timegallery.controller.user;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Response<User> get(@PathVariable Long userId) {
        return Response.okOrNotFound(userService.loadUserById(userId));
    }

    @PutMapping("/{userId}/username")
    public Response<User> updateUsername(@PathVariable Long userId, @RequestParam String username) {
        return Response.okOrNotFound(userService.updateUsernameById(userId, username));
    }

    @PutMapping("/{userId}/password")
    public Response<User> updatePassword(@PathVariable Long userId, @RequestParam String password) {
        return Response.okOrNotFound(userService.updatePasswordById(userId, password));
    }

    @PutMapping("/{userId}/dob")
    public Response<User> updateDob(@PathVariable Long userId, @RequestParam String isoUTCDate) {
        return Response.okOrNotFound(userService.updateDobById(userId, Instant.parse(isoUTCDate)));
    }

    @PutMapping("/{userId}/email")
    public Response<User> updateEmail(@PathVariable Long userId, @RequestParam String email) {
        return Response.okOrNotFound(userService.updateEmailById(userId, email));
    }

    @PutMapping("/{userId}/gender")
    public Response<User> updateGender(@PathVariable Long userId, @RequestParam String gender) {
        return Response.okOrNotFound(userService.updateGenderById(userId, gender));
    }

    @PutMapping("/{userId}/nickname")
    public Response<User> updateNickname(@PathVariable Long userId, @RequestParam String nickname) {
        return Response.okOrNotFound(userService.updateNicknameById(userId, nickname));
    }

    @PutMapping("/{userId}/signature")
    public Response<User> updateSignature(@PathVariable Long userId, @RequestParam String signature) {
        return Response.okOrNotFound(userService.updateSignatureById(userId, signature));
    }

    @PutMapping("/{userId}/description")
    public Response<User> updateDescription(@PathVariable Long userId, @RequestParam String description) {
        return Response.okOrNotFound(userService.updateDescriptionById(userId, description));
    }

    @DeleteMapping("/{userId}")
    public Response<?> delete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return Response.ok();
    }

}
