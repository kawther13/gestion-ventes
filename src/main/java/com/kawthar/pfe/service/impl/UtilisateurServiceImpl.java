package com.kawthar.pfe.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kawthar.pfe.model.Role;
import com.kawthar.pfe.model.Utilisateur;
import com.kawthar.pfe.repository.RoleRepo;
import com.kawthar.pfe.repository.UtilisateurRepo;
import com.kawthar.pfe.service.UtilisateurService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Service


public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UtilisateurRepo utilisateurRepo;
	@Autowired
	private RoleRepo roleRepo;
		@Override
		public Utilisateur RegisterUtilisateur(Utilisateur utilisateur) {		 
			List<Utilisateur> utilisateurs= utilisateurRepo.findAll();
 			if(utilisateurs.size()<= 0) {
			Set<Role> roles=new HashSet<>();
			Role rolesADMIN= roleRepo.findByNomRole("ADMIN");
			roles.add(rolesADMIN);
			utilisateur.setRoles(roles);
			utilisateur.setNom(utilisateur.getNom());
			utilisateur.setPrenom(utilisateur.getPrenom());
			utilisateur.setAdresse(utilisateur.getAdresse());
			utilisateur.setEmail(utilisateur.getEmail());
			utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
			return utilisateurRepo.save(utilisateur);
			}else {
				return null;
			}
		}


	@Override
	public List<Utilisateur> listUtilisateurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerutilisateur(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur rechercherParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findByEmailUtilisateur(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
