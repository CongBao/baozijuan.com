package com.baozijuan.timegallery.controller.user;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.Role;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class RoleController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/role")
    public Response<List<Role>> getRoles(@PathVariable Long userId) {
        return Response.ok(new ArrayList<>(userService.getRolesById(userId)));
    }

    @GetMapping("/{userId}/role/{roleId}")
    public Response<Role> getRoleInfo(@PathVariable Long userId, @PathVariable Long roleId) {
        List<Role> roles = userService.getRolesById(userId)
                .stream()
                .filter(r -> r.getId().equals(roleId))
                .collect(Collectors.toList());
        if (roles.size() == 1) {
            return Response.ok(roles.get(0));
        }
        return Response.notFound();
    }

}
