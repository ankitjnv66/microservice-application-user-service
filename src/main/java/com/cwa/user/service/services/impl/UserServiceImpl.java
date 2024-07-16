package com.cwa.user.service.services.impl;

import com.cwa.user.service.exceptions.ResourceNotFoundException;
import com.cwa.user.service.model.User;
import com.cwa.user.service.repositories.UserRepository;
import com.cwa.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on the server - " + userId));
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }
}
