package com.example.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.User;
import com.example.repository.UserRepository;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceTest {
	@Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = new User(null, "test@example.com", "password123", "John", "Doe", "NYC");
        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals("test@example.com", savedUser.getEmail());
    }

    @Test
    void testFindUserByEmail() {
        userService.saveUser(new User(null, "ram@example.com", "password001", "ram", "kumar", "chennai"));

        Optional<User> foundUser = userService.findByEmail("ram@example.com");
        assertTrue(foundUser.isPresent());
        assertEquals("ram@example.com", foundUser.get().getEmail());
    }

    @Test
    void testFindUserByEmailNotFound() {
        Optional<User> foundUser = userService.findByEmail("1@example.com");
        assertFalse(foundUser.isPresent());
    }
    

}