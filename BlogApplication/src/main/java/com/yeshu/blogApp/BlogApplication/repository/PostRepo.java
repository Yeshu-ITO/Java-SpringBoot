package com.yeshu.blogApp.BlogApplication.repository;

import com.yeshu.blogApp.BlogApplication.entity.Category;
import com.yeshu.blogApp.BlogApplication.entity.Post;
import com.yeshu.blogApp.BlogApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
