package com.kawthar.pfe.service;

import java.util.List;

import com.kawthar.pfe.model.Article;

public interface ArticleService {

	Article ajouterArticle(Article article);
	List<Article> listArticles();
	Article rechercherParId(Long id);
	void supprimerArticle(Long id);
}
