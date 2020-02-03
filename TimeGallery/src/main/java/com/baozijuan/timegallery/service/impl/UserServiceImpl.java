package com.baozijuan.timegallery.service.impl;

import com.baozijuan.timegallery.bean.Result;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.dao.UserDao;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result login(User user) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        return result;
    }

}
