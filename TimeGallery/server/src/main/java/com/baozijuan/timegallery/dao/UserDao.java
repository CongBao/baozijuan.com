package com.baozijuan.timegallery.dao;

import com.baozijuan.timegallery.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
