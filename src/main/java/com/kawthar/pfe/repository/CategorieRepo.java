package com.kawthar.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.CategorieArticle;

public interface CategorieRepo extends JpaRepository<CategorieArticle, Long> {
	CategorieArticle  findByNomCat(String nomCat);
}
