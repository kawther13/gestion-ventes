package com.kawthar.pfe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.Facture;

public interface FactureService{
	Facture ajouterArticle(Facture facture);
	List<Facture> listArticles();
	void supprimerArticle(Long id);
	Facture rechercherParId(Long id);
}
