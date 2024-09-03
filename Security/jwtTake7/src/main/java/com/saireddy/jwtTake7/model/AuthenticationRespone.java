package com.saireddy.jwtTake7.model;

public class AuthenticationRespone {
     private String token;

     public AuthenticationRespone(String token) {
          this.token = token;
     }

     public String getToken() {
          return token;
     }

     public void setToken(String token) {
          this.token = token;
     }

}
