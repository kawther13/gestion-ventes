package com.kawthar.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawthar.pfe.model.Commande;
import com.kawthar.pfe.service.CommandeService;

@RestController
@RequestMapping(value="/pfe/commande")

public class CommandeController {
@Autowired
private CommandeService commandeService;
@GetMapping(value = "/all")
public List<Commande> list(){
	return commandeService.listCommandes();
}
@GetMapping(value = "/allDevis")
public List<Commande> listd(){
	return commandeService.listDevis();
}
@GetMapping(value = "/allbyClient/{idclt}")
public List<Commande> listbyClient(@PathVariable("idclt") Long idclt){
	return commandeService.commandClient(idclt);
}
@PostMapping(value = "/save")
public  Commande  saveCommande(@RequestBody Commande commande){
	return commandeService.ajouterCommande(commande);
	
}
@DeleteMapping(value = "/arreter-Commande/{id}")
public  Commande  validerCommande(@PathVariable("id") Long id){
	  return commandeService.arretercommandes(id);
	
}
@DeleteMapping(value = "/valider-Commande/{id}")
public  Commande  arreterCommande(@PathVariable("id") Long id){
	  return commandeService.validercommandes(id);
	
}
@DeleteMapping(value = "/delcommande/{id}")
public  void  deleteCommande(@PathVariable("id") Long id){
	 commandeService.supprimerCommandes(id);
	
}
@GetMapping(value = "/byId/{id}")
public  Commande  byId(@PathVariable("id") Long  id){
	return commandeService.rechercherParId(id);
	
}
@GetMapping(value = "/totalprix")
public  double  getTotal(){
	return commandeService.totalCommande();
	
}
}
