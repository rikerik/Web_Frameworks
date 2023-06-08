package com.security.Security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;

@Service
public class JwtService {

    private static final String SECRET_KEY = "F5FsIomatLl5wix98ISx+dWlyR765OaHGq7e9Xv4JWN75hKRrNfzqU/kLi6UumG1r7nTT7FLeJTLVxJk+uI/8hH/xkuWg74Obc9x2PvglocQgKlvnOnJG05F9faFdlJrhOZEloiSlwnmr6Jrmvl3kAiezNX1BSd0tXgnIHMQrRK/0PqZs7aMGYsZFjire4HG7925znKiIESxsUO5YfFdHsopP5I+vDPsMcN7yJoSaafQHcLBPe6rOweKRHRMUo6r8ilYa8wYo8CmlOYKxdS8G4aUn0aJnprK5q8LMPjIeDVMmvFBNUFlbLT75/3FpExgVaGhzcQD5fjMLdGlYGyXQv57kA/5PKNiirkbT0sSFWU=";

    public String extractUsername(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
