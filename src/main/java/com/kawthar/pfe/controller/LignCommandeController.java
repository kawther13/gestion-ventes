package com.kawthar.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.Client;
import com.kawthar.pfe.model.Commande;
import com.kawthar.pfe.model.LigneCommande;
import com.kawthar.pfe.service.ArticleService;
import com.kawthar.pfe.service.CommandeService;
import com.kawthar.pfe.service.LignCommandeService;

@RestController
@RequestMapping(value="/pfe/lignCommande")
public class LignCommandeController {
@Autowired
private LignCommandeService lignCommandeService;
@Autowired
private ArticleService articleService; 
@Autowired
private CommandeService commandeService;
@GetMapping(value = "/all/{id}")
public List<LigneCommande> listCommandes(@PathVariable("id") Long id){
	Commande cmd = commandeService.rechercherParId(id);
	return lignCommandeService.listByCommande(cmd);
}
@PostMapping(value = "/save/{id}")
public LigneCommande save(@RequestBody LigneCommande ligneCommande, @PathVariable("id") Long id) throws JsonParseException , JsonMappingException , Exception  {
	 
	return lignCommandeService.ajouterLigneCommande(ligneCommande,id);
}
@DeleteMapping(value = "/delete/{id}")
public void deleteById(@PathVariable("id") Long id) {
	lignCommandeService.supprimerLignCommande(id);
}
@GetMapping(value = "/byId/{id}")
public LigneCommande findById(@PathVariable("id") Long id)	{
	return lignCommandeService.rechercherParId(id);
}
@GetMapping(value="/calculTotal/{id}")
public double calcule(@PathVariable("id") Long id) {
	return lignCommandeService.calculeTotal(id);
}
	
}
