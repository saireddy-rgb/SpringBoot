package com.saireddy.spring_security2.service;

import com.saireddy.spring_security2.model.Users;
import com.saireddy.spring_security2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public List<Users> getAllUsers() {
       return  repo.findAll();
    }

    public Users getUserById(long userId) {
        Optional<Users> users = repo.findById(userId);
        if(users.isPresent()){
            return  users.get();
        }
        else {
            throw new RuntimeException();
        }
    }

    public void createUser(Users users) {
        Optional<Users> users1 = repo.findById(users.getUserId());
        if (users1.isPresent()) {
            System.out.println("user already exists");
        } else {
            repo.save(users);
        }
    }

    public void updateUser(long userId, Users users) {
        Users existingUser = repo.findById(userId).orElseThrow(()-> new RuntimeException());
        existingUser.setUserName(users.getUserName());
        existingUser.setUserRole(users.getUserRole());
        repo.save(existingUser);
    }

    public void deleteUser(long userId) {
        Optional<Users> users2 = repo.findById(userId);
        if (users2.isPresent()) {
            repo.deleteById(userId);
        }
        else {
            throw  new RuntimeException();
        }
    }
}
