package com.kawthar.pfe.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kawthar.pfe.model.Article;

public interface ArticleRepo extends JpaRepository<Article, Long> {
	
Article findByNomArticle(String nomArticle);
@Modifying
@Transactional
@Query(value = "DELETE FROM comercial.article a WHERE (a.id = ?1)",nativeQuery = true)
void deleteArticle(Long id);
}
