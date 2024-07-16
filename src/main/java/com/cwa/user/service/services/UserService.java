package com.cwa.user.service.services;

import com.cwa.user.service.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    //create
    User saveUser(User user);

    //get all users
    List<User> getAllUser();

    //get user by id
    User getUserById(String userId);

    //delete user by id
    void deleteUserById(String userId);

    //TODO: update user API
}
