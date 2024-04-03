package com.willCompany.socialmediaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willCompany.socialmediaapi.model.CreateUserDTO;
import com.willCompany.socialmediaapi.model.User;
import com.willCompany.socialmediaapi.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getOne(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User save(final CreateUserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        return userRepository.save(user);
    }  
    
    public void delete(final Long id) {
    	userRepository.deleteById(id);
    }

}
