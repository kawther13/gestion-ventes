package com.kawthar.pfe.service;

import java.util.List;


import com.kawthar.pfe.model.Utilisateur;

public interface UtilisateurService {
	Utilisateur  RegisterUtilisateur(Utilisateur utilisateur);
	List<Utilisateur> listUtilisateurs();
	void supprimerutilisateur(Long id);
	Utilisateur rechercherParId(Long id);
	Utilisateur findByEmailUtilisateur(String email);
}
