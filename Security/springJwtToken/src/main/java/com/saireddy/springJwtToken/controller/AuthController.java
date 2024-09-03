//package com.saireddy.springJwtToken.controller;
//
//import com.saireddy.springJwtToken.model.Role;
//
//import com.saireddy.springJwtToken.dto.RegisterDto;
//import com.saireddy.springJwtToken.model.UsersModel;
//import com.saireddy.springJwtToken.repo.RoleRepo;
//import com.saireddy.springJwtToken.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collections;
//
//@RestController
//public class AuthController {
//
//  private AuthenticationManager authenticationManager;
//  private UserRepo userRepo;
//    private RoleRepo roleRepo;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AuthController(AuthenticationManager authenticationManager, UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
//        this.authenticationManager = authenticationManager;
//        this.userRepo = userRepo;
//        this.roleRepo = roleRepo;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registe(@RequestBody RegisterDto registerDto){
//        if(userRepo.existByUsername(registerDto.getUsername())){
//            return  new ResponseEntity<>("username is taken", HttpStatus.BAD_REQUEST);
//        }
//        UsersModel usersModel = new UsersModel();
//        usersModel.setUserName(registerDto.getUsername());
//        usersModel.setUserPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//        Role roles = roleRepo.findBYName("USER").get();
//        usersModel.setRoles(Collections.singletonList(roles));
//
//        userRepo.save(usersModel);
//        return new ResponseEntity<>("User registerd sucess",HttpStatus.OK);
//    }
//
//    @PostMapping("login")
//        public ResponseEntity<String> login(){
//
//    }
//
//}
