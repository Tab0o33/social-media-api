package com.willCompany.socialmediaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.willCompany.socialmediaapi.model.Post;
import com.willCompany.socialmediaapi.model.PostDTO;
import com.willCompany.socialmediaapi.service.PostService;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * Read - Get all posts
     * 
     * @return - An Iterable object of Post full filled
     */
    @GetMapping("/posts")
    public Iterable<Post> getAll() {
        System.out.println("out");
        return postService.getAll();
    }

    /**
     * Create - Add a new post
     * 
     * @param post An object post
     * @return The post object saved
     */
    @PostMapping("/posts")
    public Post save(@RequestBody PostDTO post) {
        return postService.save(post);
    }

}
