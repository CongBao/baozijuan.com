package com.baozijuan.timegallery.controller;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody User user) {
        return userService.register(user);
    }

}
