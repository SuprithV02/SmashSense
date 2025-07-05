package com.smashsense.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "smashsense_super_secure_jwt_key_1234567890";
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;

    public String generateToken(String username) { // This method takes a username as input.It returns a JWT token (as a
                                                   // String) that represents this user’s identity in a secure,
                                                   // verifiable format.
        return Jwts.builder() // This starts the creation of JWT using JJWT library.You are using a builder
                              // pattern to fluently add data to the token.
                .setSubject(username) // The subject is the main identity the token represents.It will later be
                                      // extracted to identify who the token belongs to.
                .setIssuedAt(new Date()) // This marks when the token was created.Useful for tracking token age or
                                         // debugging.
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Defines when the token will
                                                                                       // expire.
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes()) // Signs the token using the algorithm HS256
                                                                           // (HMAC-SHA256) and your secret key
                .compact(); // This converts the token data into a compressed string format (JWT string).
    }

    public String extractUserName(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, String username) {
        return extractUserName(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser() // Creates a new JWT token using the JJWT library
                .setSigningKey(SECRET_KEY) //Sets the secret key used to sign the token.This is necessary to verify the token’s signature 
                .parseClaimsJws(token) // This parses the JWT and verifies the signature, if everything is valid it will gives u clams, if the token is expired, this line will throw an exception
                .getBody() // Retrieves the actual payload/claims of the JWT.
                .getExpiration() // Returns the expiration time (exp) of the token as a Date object.
                .before(new Date()); // Compares the token’s expiration date with the current time.If the expiration is before the current time, the token is expired → returns true.
    }

}
