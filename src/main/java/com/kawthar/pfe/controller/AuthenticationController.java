package com.kawthar.pfe.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawthar.pfe.model.Utilisateur;
import com.kawthar.pfe.model.auth.RequestToken;
import com.kawthar.pfe.model.auth.ResponseToken;
import com.kawthar.pfe.repository.UtilisateurRepo;
import com.kawthar.pfe.service.UtilisateurService;
import com.kawthar.pfe.service.auth.ApplicationUserDetails;
import com.kawthar.pfe.utils.JwtUtils;


@RestController
@RequestMapping(value = "/pfe")
public class AuthenticationController {

	@Autowired
	private UtilisateurRepo utilisateurRepo;
	@Autowired
	private UtilisateurService utilisateurService;
	 @Autowired
	  private AuthenticationManager authenticationManager;

	  @Autowired
	  private ApplicationUserDetails userDetailsService;

	  @Autowired
	  private JwtUtils jwtUtil;

	  @PostMapping(value = "/login")
	  public ResponseEntity<ResponseToken> authenticate(@RequestBody RequestToken request) {
	    authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(
	            request.getUsername() ,
	            request.getPassword()
	        )
	    );
	    final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final Utilisateur user= utilisateurRepo.findByEmail(request.getUsername());
	    final String jwt = jwtUtil.generatedToken(userDetails);

	    return ResponseEntity.ok(ResponseToken.builder().token(jwt)
	    		.utilisateur(user).build());
	  }
	  
	 
	  
}
