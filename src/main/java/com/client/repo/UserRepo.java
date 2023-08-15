package com.client.repo;

import com.client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {


        User findOneByEmailIgnoreCaseAndPassword(String email, String password);

    }
