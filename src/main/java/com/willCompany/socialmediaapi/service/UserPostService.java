package com.willCompany.socialmediaapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willCompany.socialmediaapi.model.PostWithDetailsDTO;
import com.willCompany.socialmediaapi.repository.UserPostRepository;

import lombok.Data;

@Data
@Service
public class UserPostService {

    @Autowired
    private UserPostRepository userPostRepository;

    public void upsert(final Long userId, final Long postId, final boolean isLiked) {
        userPostRepository.upsert(userId, postId, isLiked);
    }

    public Iterable<PostWithDetailsDTO> getPostsWithDetails(final Long userId) {
        List<Object[]> rows = userPostRepository.getAllPostsWithDetails(userId);
        if (rows.isEmpty()) {
            // ...
        }
        List<PostWithDetailsDTO> posts = new ArrayList<>();
        for (Object[] row : rows) {
            PostWithDetailsDTO post = new PostWithDetailsDTO(row);
            posts.add(post);
        }
        return posts;
    }

}
