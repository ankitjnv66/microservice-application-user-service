package com.cwa.user.service.controller;

import com.cwa.user.service.model.User;
import com.cwa.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //create
    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User createdUser = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    //get single user
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        User user = this.userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    //get all user
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = this.userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    //delete user
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam("userId") String userId) {
        System.out.println("Delete called");
        this.userService.deleteUserById(userId);
    }
}

