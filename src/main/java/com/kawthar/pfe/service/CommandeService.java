package com.kawthar.pfe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.Commande;
import com.kawthar.pfe.model.LigneCommande;

public interface CommandeService{
	Commande ajouterCommande(Commande commande);
	List<Commande> listCommandes();
	void supprimerCommandes(Long id);
	Commande rechercherParId(Long id);
	List<Commande> commandClient(Long idClt);
	Commande validercommandes(Long id);
	Commande arretercommandes(Long id);
	List<Commande> listDevis();
	double totalCommande();
}
