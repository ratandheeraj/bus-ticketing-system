package com.project.busticketingsystem.controller;

import com.project.busticketingsystem.model.User;
import com.project.busticketingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("authenticate-user")
    public User authenticateUser(@Valid @RequestBody User user){
        return userService.authenticateUser(user);
    }

}
