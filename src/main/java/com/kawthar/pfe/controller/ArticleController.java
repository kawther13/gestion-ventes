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

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.service.ArticleService;

@RestController
@RequestMapping(value = "/pfe/article")
public class ArticleController {
@Autowired
private ArticleService articleService;
@GetMapping(value = "/all")
public List<Article>articles(){
	return articleService.listArticles();
}
@PostMapping(value = "/save")
public  Article addArticle(@RequestBody Article article){
	return articleService.ajouterArticle(article);
}
@GetMapping(value="/byId/{id}")
public Article findById(@PathVariable("id") Long id) {
	return articleService.rechercherParId(id);
}
@DeleteMapping(value="/delete/{id}")
public void deleteArticle(@PathVariable("id") Long id) {
	//Article art= articleService.rechercherParId(id);
	
	articleService.supprimerArticle(id);
}
}
