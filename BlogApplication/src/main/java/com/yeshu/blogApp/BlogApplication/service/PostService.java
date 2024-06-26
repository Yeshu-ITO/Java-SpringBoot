package com.yeshu.blogApp.BlogApplication.service;

import com.yeshu.blogApp.BlogApplication.payloads.PostDto;
import com.yeshu.blogApp.BlogApplication.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    PostDto updatePost(PostDto postDto,Integer postId);

    void deletePost(Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer PageSize, String sortBy, String sortDir);

    PostDto getPostById(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> getPostByUser(Integer userId);

    List<PostDto> searchPostByTitle(String keyword);

    List<PostDto> searchPostByContent(String keyword);
}
