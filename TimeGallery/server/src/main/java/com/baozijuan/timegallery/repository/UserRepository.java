package com.baozijuan.timegallery.repository;

import com.baozijuan.timegallery.bean.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByUsername(String username);

    User findByEmail(String email);

    User findByUsernameAndPassword(String username, String password);

    User findByEmailAndPassword(String username, String password);

}
