package com.willCompany.socialmediaapi.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willCompany.socialmediaapi.model.Post;
import com.willCompany.socialmediaapi.model.PostDTO;
import com.willCompany.socialmediaapi.repository.PostRepository;

import lombok.Data;

@Data
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Optional<Post> getOne(final Long id) {
        return postRepository.findById(id);
    }

    public Iterable<Post> getAll() {
        return postRepository.findAll();
    }

    public void delete(final Long id) {
        postRepository.deleteById(id);
    }

    public Post save(PostDTO postDTO) {
    	
        Post post = new Post();
        post.setText(postDTO.getText());
        if (postDTO.getImage() != null && !postDTO.getImage().isEmpty()) {
        	post.setImage(postDTO.getImage());
        }
        post.setUserId(1l);
        post.setCreatedDate(LocalDateTime.now());
        // Vous pouvez ajouter d'autres attributs si nécessaire

        return postRepository.save(post);
    }

}
