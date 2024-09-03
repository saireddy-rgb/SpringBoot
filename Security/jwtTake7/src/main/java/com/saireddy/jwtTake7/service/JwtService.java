package com.saireddy.jwtTake7.service;

import com.saireddy.jwtTake7.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY = "decf45d17a2e1049c24a33f798c8b35d28cb4770584e47188098e821669ac121";

    public String extractUsername(String token){
        return exctractClaim(token, Claims::getSubject);
    }

    public boolean isValid(String token, UserDetails user){
        String username = extractUsername(token);
        return ((username.equals(user.getUsername())) && !isTokenExpried(token));
    }

    private boolean isTokenExpried(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return exctractClaim(token,Claims ::getExpiration);
    }


    public <T> T exctractClaim(String token, Function<Claims,T> resolver){
        Claims claims = extractAllclaims(token);
        return resolver.apply(claims);
    }

    public String generateToken(User user){
        String token = Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+24*60*60*1000))
                        .signWith(getSigninKey())
                        .compact();
        return token;
    }

    private Claims extractAllclaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    private SecretKey getSigninKey(){
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
