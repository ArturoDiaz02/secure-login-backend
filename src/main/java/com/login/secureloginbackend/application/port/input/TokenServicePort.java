package com.login.secureloginbackend.application.port.input;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface TokenServicePort {
    String generateToken(UserDetails user);
    String getTokenFromRequest(HttpServletRequest request);
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    <T> T getClaim(String token, Function<Claims,T> claimsResolver);
    <T> Object getRole (String token, Function<Claims,T> claimsResolver);
    Date extractExpiration(String token);
}
