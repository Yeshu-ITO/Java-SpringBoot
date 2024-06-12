package com.yeshu.blogApp.BlogApplication.service.impl;

import com.yeshu.blogApp.BlogApplication.entity.Category;
import com.yeshu.blogApp.BlogApplication.entity.Post;
import com.yeshu.blogApp.BlogApplication.entity.User;
import com.yeshu.blogApp.BlogApplication.exceptions.ResourceNotFoundException;
import com.yeshu.blogApp.BlogApplication.payloads.PostDto;
import com.yeshu.blogApp.BlogApplication.repository.CategoryRepo;
import com.yeshu.blogApp.BlogApplication.repository.PostRepo;
import com.yeshu.blogApp.BlogApplication.repository.UserRepo;
import com.yeshu.blogApp.BlogApplication.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","User Id",userId));
        Category category = this.categoryRepo
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","Category Id",categoryId));

        Post post = this.modelMapper.map(postDto,Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost,PostDto.class);
    }


    @Override
    public Post updatePost(PostDto postDto, Integer postId) {


        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return List.of();
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return List.of();
    }
}
