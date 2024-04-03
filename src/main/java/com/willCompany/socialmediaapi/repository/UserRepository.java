package com.willCompany.socialmediaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.willCompany.socialmediaapi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}