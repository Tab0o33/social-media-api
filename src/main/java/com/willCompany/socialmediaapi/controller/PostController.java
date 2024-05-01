package com.willCompany.socialmediaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willCompany.socialmediaapi.model.CreatePostDTO;
import com.willCompany.socialmediaapi.model.Post;
import com.willCompany.socialmediaapi.model.PostWithDetailsDTO;
import com.willCompany.socialmediaapi.model.UpdatePostDTO;
import com.willCompany.socialmediaapi.service.PostService;
import com.willCompany.socialmediaapi.service.UserPostService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/public")
@Tag(name = "Post", description = "Endpoints to handle posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserPostService userPostService;

    /**
     * Read - Get all posts
     * 
     * @return - An Iterable object of Post full filled
     */
    @GetMapping("/posts")
    public Iterable<Post> getAll() {
        return postService.getAll();
    }

    /**
     * Read - Get all posts with more data
     * 
     * @return - An Iterable object of Post full filled with more data
     */
    @GetMapping("/posts/details")
    public Iterable<PostWithDetailsDTO> getAllWithDetails() {
        return userPostService.getPostsWithDetails(1L);
    }

    /**
     * Create - Add a new post
     * 
     * @param post An object post
     * @return The post object saved
     */
    @PostMapping("/posts")
    public Post save(@RequestBody CreatePostDTO post) {
        return postService.save(post);
    }

    /**
     * Create - Update a user/post relation
     * 
     * @param update An object with a param isLiked
     * @return The post object updated
     */
    @PatchMapping("/posts/{id}")
    public void upsert(@PathVariable("id") final Long id, @RequestBody UpdatePostDTO post) {
        userPostService.upsert(1L, id, post.getIsLiked());
    }

}
