package com.baozijuan.timegallery.controller;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/checkUsername")
    public Response<Boolean> isUsernameExist(@RequestParam String username) {
        return Response.ok(userService.isUserExistByUsername(username));
    }

    @PostMapping("/checkEmail")
    public Response<Boolean> isEmailExist(@RequestParam String email) {
        return Response.ok(userService.isUserExistByEmail(email));
    }

    @PostMapping
    public Response<User> register(@RequestBody User user) {
        return Response.ok(userService.registerUser(user));
    }

}
