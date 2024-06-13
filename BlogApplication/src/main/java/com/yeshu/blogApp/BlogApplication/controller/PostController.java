package com.yeshu.blogApp.BlogApplication.controller;

import com.yeshu.blogApp.BlogApplication.config.AppConstants;
import com.yeshu.blogApp.BlogApplication.payloads.ApiResponse;
import com.yeshu.blogApp.BlogApplication.payloads.PostDto;
import com.yeshu.blogApp.BlogApplication.payloads.PostResponse;
import com.yeshu.blogApp.BlogApplication.service.FileService;
import com.yeshu.blogApp.BlogApplication.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
        PostDto createPost = this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
        List<PostDto> posts = this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
            ){
        return new ResponseEntity<PostResponse>(this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        return ResponseEntity.ok(this.postService.getPostById(postId));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<ApiResponse>((new ApiResponse("Post Deleted Successfully", true)),HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId,@RequestBody PostDto postDto){
        PostDto updatePost = this.postService.updatePost(postDto,postId);
        return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }

    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keywords){
        List<PostDto> posts = this.postService.searchPostByTitle(keywords);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @GetMapping("/posts/search/content/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByContent(@PathVariable String keywords){
        List<PostDto> posts = this.postService.searchPostByContent(keywords);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @PostMapping("/posts/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image")MultipartFile image, @PathVariable Integer postId) throws IOException {

        PostDto postdto = this.postService.getPostById(postId);

        String  fileName = this.fileService.uploadImage(path,image);
        postdto.setImageName(fileName);
        PostDto updatePost = this.postService.updatePost(postdto,postId);
        return  new ResponseEntity<>(updatePost,HttpStatus.OK);
    }

    @GetMapping(value = "/posts/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable String imageName, HttpServletResponse response) throws IOException{
        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }

}
