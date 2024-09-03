package com.saireddy.spring_security2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontController {

    @GetMapping("/")
    public CsrfToken getCsrfToken (HttpServletRequest request) {
      return (CsrfToken) request.getAttribute("_csrf");

    }
}
