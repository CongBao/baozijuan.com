package com.baozijuan.timegallery.service.impl;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.User;
import com.baozijuan.timegallery.dao.UserDao;
import com.baozijuan.timegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Response login(User user) {
        return null;
    }

    @Override
    public Response register(User user) {
        userDao.save(user);
        return new Response(Response.Status.OK);
    }

}
