package com.baozijuan.timegallery.service;

import com.baozijuan.timegallery.bean.Response;
import com.baozijuan.timegallery.bean.User;

public interface UserService {

    Response login(User user);

    Response register(User user);

}
