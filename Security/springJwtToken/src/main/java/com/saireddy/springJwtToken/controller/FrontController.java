package com.saireddy.springJwtToken.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;

public class FrontController {

    @GetMapping("/")
    public String greet() {
        return "welcome for session is use localhost:8080/id and for csrf token use localhost:8080/csrf";
    }

    @GetMapping("/id")
    public String SessionId(HttpServletRequest request) {
        return "your session id is : " + request.getSession().getId();
    }

    @GetMapping("/csrf")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}