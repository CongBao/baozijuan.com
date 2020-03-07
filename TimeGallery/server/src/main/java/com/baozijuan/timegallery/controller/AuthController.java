package com.baozijuan.timegallery.controller;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.domain.User;
import com.baozijuan.timegallery.bean.view.UserView;
import com.baozijuan.timegallery.service.UserService;
import com.baozijuan.timegallery.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/checkUsername")
    public Response<Boolean> isUsernameExist(@RequestParam String username) {
        return Response.ok(userService.isUserExistByUsername(username));
    }

    @PostMapping("/checkEmail")
    public Response<Boolean> isEmailExist(@RequestParam String email) {
        return Response.ok(userService.isUserExistByEmail(email));
    }

    @PostMapping("/login")
    public Response<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = jwtUtil.generateToken(auth);
            User user = (User) auth.getPrincipal();
            return Response.ok(UserView.of(user, token));
        } catch (DisabledException e) {
            return Response.forbidden("Account disabled");
        } catch (LockedException e) {
            return Response.forbidden("Account locked");
        } catch (BadCredentialsException e) {
            return Response.forbidden("Wrong password");
        } catch (AuthenticationException e) {
            return Response.forbidden("Account not found");
        } catch (Exception e) {
            return Response.internalServerError(e.getMessage());
        }
    }

    @PostMapping("/register")
    public Response<?> register(@RequestBody User user) {
        if (user == null) {
            return Response.badRequest("Empty request body");
        }
        if (userService.isUserExistByUsername(user.getUsername())) {
            return Response.badRequest("Username exists");
        }
        if (userService.isUserExistByEmail(user.getEmail())) {
            return Response.badRequest("Email exists");
        }
        User added = userService.addUser(user);
        Authentication auth = new PreAuthenticatedAuthenticationToken(added, null, added.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtUtil.generateToken(auth);
        return Response.ok(UserView.of(added, token));
    }

}
