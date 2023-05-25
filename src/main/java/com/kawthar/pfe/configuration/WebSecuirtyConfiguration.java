package com.kawthar.pfe.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kawthar.pfe.service.auth.ApplicationUserDetails;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecuirtyConfiguration extends WebSecurityConfigurerAdapter {
@Autowired
private ApplicationUserDetails applicationUserDetails;
@Autowired
private ApplicationRequestFilter applicationRequestFilter;
@Autowired
private JwtAuthenticationEntrePoint authenticationEntrePoint;
@Bean
BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	
}
	@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(applicationUserDetails).passwordEncoder(passwordEncoder());
}

	

	@Bean
	public AuthenticationManager CustomAuthenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return authenticationManagerBean();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
			http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/pfe/login","/pfe/utilisateur/register").permitAll()
			.antMatchers(HttpHeaders.ALLOW).permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling().authenticationEntryPoint(authenticationEntrePoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			;
			
			http.addFilterBefore(applicationRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
}
