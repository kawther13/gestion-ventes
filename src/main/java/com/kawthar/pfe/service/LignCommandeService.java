package com.kawthar.pfe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.Commande;
import com.kawthar.pfe.model.LigneCommande;

public interface LignCommandeService {
	LigneCommande ajouterLigneCommande(LigneCommande ligneCommande ,Long id);
	List<LigneCommande> list();
	void supprimerLignCommande(Long id);
	LigneCommande rechercherParId(Long id_ordDetails);
	List<LigneCommande> listByCommande(Commande commande);
	double calculeTotal(Long id);
}
