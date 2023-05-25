package com.kawthar.pfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieArticle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	private String nomCat;
	private boolean etat;

}
