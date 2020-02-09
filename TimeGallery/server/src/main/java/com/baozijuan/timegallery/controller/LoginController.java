package com.baozijuan.timegallery.controller;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

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

    @PostMapping("/username")
    public Response<Boolean> loginByUsername(@RequestParam String username, @RequestParam String password) {
        return Response.ok(userService.loginByUsernameAndPassword(username, password));
    }

    @PostMapping("/email")
    public Response<Boolean> loginByEmail(@RequestParam String email, @RequestParam String password) {
        return Response.ok(userService.loginByEmailAndPassword(email, password));
    }

}
