package com.yeshu.blogApp.BlogApplication.repository;

import com.yeshu.blogApp.BlogApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
}
