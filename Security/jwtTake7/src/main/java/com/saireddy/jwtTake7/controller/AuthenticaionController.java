package com.saireddy.jwtTake7.controller;

import com.saireddy.jwtTake7.model.AuthenticationRespone;
import com.saireddy.jwtTake7.model.User;
import com.saireddy.jwtTake7.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticaionController {
        private  final AuthenticationService authService;

    public AuthenticaionController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationRespone> register(@RequestBody User request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthenticationRespone> login(@RequestBody User request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
