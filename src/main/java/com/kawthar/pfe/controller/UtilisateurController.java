package com.kawthar.pfe.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawthar.pfe.model.Utilisateur;
import com.kawthar.pfe.service.UtilisateurService;
@RestController
@RequestMapping(value = "/pfe/utilisateur/")
public class UtilisateurController {
@Autowired
private UtilisateurService utilisateurService;

@PostMapping(value = "/register")
public  Utilisateur registerUtilisateur(@RequestBody Utilisateur utilisateur) {
	return  utilisateurService.RegisterUtilisateur(utilisateur);
}
}
