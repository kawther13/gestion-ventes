package com.kawthar.pfe.service.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kawthar.pfe.model.CategorieArticle;
import com.kawthar.pfe.repository.CategorieRepo;
import com.kawthar.pfe.service.CategorieService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service

public class CategorieArticleServiceImpl implements CategorieService {
@Autowired
private CategorieRepo categorieRepo;

@Override
public CategorieArticle ajouterCategorieArticle(CategorieArticle categorieArticle) {
	if(categorieRepo.findByNomCat(categorieArticle.getNomCat())==null 
			&& StringUtils.hasLength(categorieArticle.getNomCat()))
			{
		categorieArticle.setEtat(true);
		return categorieRepo.save(categorieArticle);
	}
	else{
		return null;
	}
}

@Override
public List<CategorieArticle> listCategorieArticles() {
	// TODO Auto-generated method stub
	return categorieRepo.findAll();
}

@Override
public CategorieArticle changeEtatCategoryArticle(Long id) {
	CategorieArticle categorieArticle = categorieRepo.findById(id).get();
	if(categorieArticle.isEtat()==true) {
		categorieArticle.setEtat(false);
		return categorieRepo.save(categorieArticle);
	 
	}else {
		categorieArticle.setEtat(true);
		return categorieRepo.save(categorieArticle);

	}
	
}

@Override
public CategorieArticle rechercherParId(Long id) {
	// TODO Auto-generated method stub
	return categorieRepo.findById(id).get();
}
	

}
