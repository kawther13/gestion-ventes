package com.kawthar.pfe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.Devis;

public interface DevisService{
	Devis ajouterArticle(Devis article);
	List<Devis> listArticles();
	void supprimerArticle(Long id);
	Devis rechercherParId(Long id);
}
