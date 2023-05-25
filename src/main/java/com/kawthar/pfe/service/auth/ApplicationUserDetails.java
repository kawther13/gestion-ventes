package com.kawthar.pfe.service.auth;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kawthar.pfe.model.Utilisateur;
import com.kawthar.pfe.repository.UtilisateurRepo;

@Service
public class ApplicationUserDetails implements UserDetailsService {
@Autowired
private UtilisateurRepo utilisateurRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur utilisateur= utilisateurRepo.findByEmail(username);
		if(utilisateur == null) {
			throw new UsernameNotFoundException("utilisateur n'exist pas "+username);
		}
		return new User(utilisateur.getEmail(),utilisateur.getPassword()
				,utilisateur.getRoles(). stream()
                .map(role ->
                new SimpleGrantedAuthority("ROLE_"+role.getNomRole()))
                  .collect(Collectors
                     .toList()));
	
	}

}
