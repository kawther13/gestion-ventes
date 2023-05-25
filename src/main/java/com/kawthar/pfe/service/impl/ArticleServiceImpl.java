package com.kawthar.pfe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.repository.ArticleRepo;
import com.kawthar.pfe.repository.CategorieRepo;
import com.kawthar.pfe.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
@Autowired
private ArticleRepo articleRepo;
@Autowired
private CategorieRepo categorieRepo;
	@Override
	public Article ajouterArticle(Article article) {
 			article.setCategorieArticle(categorieRepo.findById(article.getCategorieArticle().getId()).get());
		return articleRepo.save(article);
	 
		
	}

	@Override
	public List<Article> listArticles() {
		// TODO Auto-generated method stub
		return articleRepo.findAll();
	}

	@Override
	public void supprimerArticle(Long  id) {
		articleRepo.deleteArticle(id);
		
		
	}

	@Override
	public Article rechercherParId(Long id) {
		// TODO Auto-generated method stub
		return articleRepo.findById(id).get();
	}

}
