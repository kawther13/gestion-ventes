package com.kawthar.pfe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.Role;

public interface RoleService{
	Role ajouterArticle(Role role);
	List<Role> listArticles();
	void supprimerArticle(Long id);
	Role rechercherParId(Long id); 
}
