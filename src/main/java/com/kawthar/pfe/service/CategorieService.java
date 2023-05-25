package com.kawthar.pfe.service;

import java.util.List;


import com.kawthar.pfe.model.CategorieArticle;

public interface CategorieService{
	CategorieArticle ajouterCategorieArticle(CategorieArticle categorieArticle );
	List<CategorieArticle> listCategorieArticles();
	CategorieArticle rechercherParId(Long id);
	CategorieArticle changeEtatCategoryArticle(Long id);
	
}
