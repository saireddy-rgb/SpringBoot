package com.saireddy.spring_security2.controller;

import com.saireddy.spring_security2.model.Users;
import com.saireddy.spring_security2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("users/{userId}")
    public Users getUserById(@PathVariable long userId){
      return   service.getUserById(userId);
    }

    @PostMapping("/users")
    public Users createUser(@RequestBody Users users){
       service.createUser(users);
       return users;
    }

    @PutMapping("/users/{userId}")
    public Users updateUser(@PathVariable long userId, @RequestBody Users users) {
        service.updateUser(userId, users);
        return users;
    }

    @DeleteMapping("/users/{userId}")
    public String deleterUser(@PathVariable long userId){
        service.deleteUser(userId);
        return " user "+ userId + " is deleted";
    }
}
