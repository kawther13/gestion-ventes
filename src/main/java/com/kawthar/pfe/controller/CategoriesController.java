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

import com.kawthar.pfe.model.CategorieArticle;
import com.kawthar.pfe.repository.CategorieRepo;
import com.kawthar.pfe.service.CategorieService;

@RestController
@RequestMapping(value = "/pfe/categories")
public class CategoriesController {
@Autowired
private CategorieService categorieService;
@GetMapping(value = "/all")
public List<CategorieArticle> categorieArticles(){
	return categorieService.listCategorieArticles();
	
}
@PostMapping(value = "/save")
public CategorieArticle addCategorieArticle(@RequestBody CategorieArticle categorieArticle) {
	return categorieService.ajouterCategorieArticle(categorieArticle);
}
@DeleteMapping(value = "/delete/{id}")
public CategorieArticle changeEtat(@PathVariable("id") Long  id) {
	return categorieService.changeEtatCategoryArticle(id);
}
@GetMapping(value = "/findByID/{id}")
public CategorieArticle findById(@PathVariable("id") Long  id) {
	return categorieService.rechercherParId(id);
}
}
