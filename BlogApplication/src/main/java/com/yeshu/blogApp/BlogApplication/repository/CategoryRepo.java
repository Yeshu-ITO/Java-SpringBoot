package com.yeshu.blogApp.BlogApplication.repository;

import com.yeshu.blogApp.BlogApplication.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
