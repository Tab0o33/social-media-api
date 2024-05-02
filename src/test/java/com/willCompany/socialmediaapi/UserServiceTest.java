package com.willCompany.socialmediaapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.willCompany.socialmediaapi.model.CreateUserDTO;
import com.willCompany.socialmediaapi.model.User;
import com.willCompany.socialmediaapi.repository.UserRepository;
import com.willCompany.socialmediaapi.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetOne() {
        User mockUser = new User();
        mockUser.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        Optional<User> result = userService.getOne(1L);

        assertNotNull(result);
        assertEquals(1L, result.get().getId().longValue());
    }

    @Test
    public void testGetAll() {
        Iterable<User> mockUsers = Arrays.asList(
                new User(),
                new User());
        when(userRepository.findAll()).thenReturn(mockUsers);

        Iterable<User> result = userService.getAll();

        assertNotNull(result);
        assertEquals(2, StreamSupport.stream(result.spliterator(), false).count());
    }

    @Test
    public void testSave() {
        CreateUserDTO mockCreateUserDTO = new CreateUserDTO();
        mockCreateUserDTO.setEmail("test@test.com");
        User mockUser = new User();
        mockUser.setEmail("test@test.com");

        userService.save(mockCreateUserDTO);

        verify(userRepository, times(1)).save(mockUser);
    }

    @Test
    public void testDelete() {
        userService.delete(5L);

        verify(userRepository, times(1)).deleteById(5L);
    }

}
