package com.baozijuan.timegallery.controller.user;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Response<User> get(@PathVariable Long userId) {
        return Response.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}/username")
    public Response<User> updateUsername(@PathVariable Long userId, @RequestParam String username) {
        return Response.ok(userService.updateUsernameById(userId, username));
    }

    @PutMapping("/{userId}/password")
    public Response<User> updatePassword(@PathVariable Long userId, @RequestParam String password) {
        return Response.ok(userService.updatePasswordById(userId, password));
    }

    @PutMapping("/{userId}/dob")
    public Response<User> updateDob(@PathVariable Long userId, @RequestParam String isoUTCDate) {
        return Response.ok(userService.updateDobById(userId, Instant.parse(isoUTCDate)));
    }

    @PutMapping("/{userId}/email")
    public Response<User> updateEmail(@PathVariable Long userId, @RequestParam String email) {
        return Response.ok(userService.updateEmailById(userId, email));
    }

    @PutMapping("/{userId}/gender")
    public Response<User> updateGender(@PathVariable Long userId, @RequestParam String gender) {
        User user = userService.updateGenderById(userId, gender);
        return Response.ok(user);
    }

    @PutMapping("/{userId}/nickname")
    public Response<User> updateNickname(@PathVariable Long userId, @RequestParam String nickname) {
        return Response.ok(userService.updateNicknameById(userId, nickname));
    }

    @PutMapping("/{userId}/signature")
    public Response<User> updateSignature(@PathVariable Long userId, @RequestParam String signature) {
        return Response.ok(userService.updateSignatureById(userId, signature));
    }

    @PutMapping("/{userId}/description")
    public Response<User> updateDescription(@PathVariable Long userId, @RequestParam String description) {
        return Response.ok(userService.updateDescriptionById(userId, description));
    }

    @DeleteMapping("/{userId}")
    public Response<?> delete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return Response.ok();
    }

}
