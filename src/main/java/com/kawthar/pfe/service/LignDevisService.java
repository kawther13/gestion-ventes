package com.kawthar.pfe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.LigneDives;

public interface LignDevisService {
	LigneDives ajouterArticle(LigneDives ligneDives);
	List<LigneDives> listArticles();
	void supprimerArticle(Long id);
	LigneDives rechercherParId(Long id);
}
