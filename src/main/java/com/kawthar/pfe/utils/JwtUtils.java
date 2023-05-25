package com.kawthar.pfe.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.kawthar.pfe.model.Utilisateur;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JwtUtils {
	
private String SECRET_KEY="secret";

public String  extractUserName(String token) {
	return extractClaims(token, Claims::getSubject);
}
public<T> T extractClaims(String token, Function<Claims,T> claimsResolver) {
	final Claims claims= extractAllClaims(token);
	return claimsResolver.apply(claims);
	
}
public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
public Date extractExpirationToken(String token) {
	return extractClaims(token, Claims::getExpiration);
}
private boolean isTokenExpired(String token) {
	return extractExpirationToken(token).before(new Date());
}
public String generatedToken(UserDetails userDetails) {
	Map<String, Object> map= new HashMap<>();
	return createToken(map, userDetails);
}
private String createToken(Map<String, Object> map, UserDetails userDetails) {
	// TODO Auto-generated method stub
	return Jwts.builder().setClaims(map)
							.setSubject(userDetails.getUsername())
							.setIssuedAt(new Date(System.currentTimeMillis()))
							.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60 *10))
							.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
									
}
public boolean validateToken(String token , UserDetails userDetails) {
	final String username=extractUserName(token);
	return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
}
public Utilisateur extractUserDetailsFromToken(String token) {
	  Claims claims = Jwts.parser()
	    .setSigningKey(SECRET_KEY)
	    .parseClaimsJws(token)
	    .getBody();

	  Utilisateur userDetails = new Utilisateur();
	  userDetails.setEmail(claims.getSubject());
	  userDetails.setNom(claims.get("nom", String.class));
	  userDetails.setPrenom(claims.get("prennom", String.class));
	  userDetails.setAdresse(claims.get("adresse", String.class));
	  return userDetails;
	}
}
