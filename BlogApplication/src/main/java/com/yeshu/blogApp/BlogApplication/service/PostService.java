package com.yeshu.blogApp.BlogApplication.service;

import com.yeshu.blogApp.BlogApplication.entity.Post;
import com.yeshu.blogApp.BlogApplication.payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto,Integer postId);

    void deletePost(Integer postId);

    List<Post> getAllPost();

    Post getPostById(Integer postId);

    List<Post> getPostByCategory(Integer categoryId);

    List<Post> getPostByUser(Integer userId);

    List<Post> searchPost(String keyword);
}
