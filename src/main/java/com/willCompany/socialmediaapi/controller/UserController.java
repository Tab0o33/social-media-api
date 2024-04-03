package com.willCompany.socialmediaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willCompany.socialmediaapi.model.CreateUserDTO;
import com.willCompany.socialmediaapi.model.User;
import com.willCompany.socialmediaapi.service.UserService;

@RestController
@RequestMapping("/api/v1/public")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Read - Get all users
     * 
     * @return - An Iterable object of User full filled
     */
    @GetMapping("/users")
    public Iterable<User> getAll() {
        return userService.getAll();
    }


    /**
     * Create - Add a new user
     * 
     * @param post An object user
     * @return The user object saved
     */
    @PostMapping("/users")
    public User save(@RequestBody CreateUserDTO user) {
        return userService.save(user);
    }

}
