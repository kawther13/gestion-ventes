package com.kawthar.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByEmail(String email);
}
