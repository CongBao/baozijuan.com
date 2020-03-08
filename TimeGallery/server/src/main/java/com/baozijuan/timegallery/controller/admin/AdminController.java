package com.baozijuan.timegallery.controller.admin;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.view.UserView;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Response<List<UserView>> getAllUsers() {
        List<UserView> users = userService.loadAllUsers().stream().map(UserView::of).collect(Collectors.toList());
        if (users.isEmpty()) {
            return Response.notFound();
        }
        return Response.ok(users);
    }

}
