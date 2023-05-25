package com.kawthar.pfe.configuration;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kawthar.pfe.service.auth.ApplicationUserDetails;
import com.kawthar.pfe.utils.JwtUtils;



@Component
public class ApplicationRequestFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtil;
	@Autowired
	private ApplicationUserDetails applicationUserDetails;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String headerAuth= request.getHeader("Authorization");
		String username=null;
		String jwttoken=null;
		if(headerAuth!=null && headerAuth.startsWith("Bearer ")){
			jwttoken = headerAuth.substring(7);
			username= jwtUtil.extractUserName(jwttoken);
	}
if(username != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
	UserDetails userDetails = this.applicationUserDetails.loadUserByUsername(username);
	if(jwtUtil.validateToken(jwttoken, userDetails)) {
		UsernamePasswordAuthenticationToken authenticationToken= UsernamePasswordAuthenticationToken.authenticated(jwttoken,null, userDetails.getAuthorities() );
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
	}
filterChain.doFilter(request, response);
}
}

