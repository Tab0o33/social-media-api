package com.willCompany.socialmediaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.willCompany.socialmediaapi.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}