package com.kawthar.pfe.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_ordDetails;
		
		private int quantity;
		private double totalPrice,unitPrice;
		@JsonIgnore
		 @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		 @JoinColumn(name = "id_cmd", referencedColumnName = "id")
		  private Commande commande;
		 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		    @JoinColumn(name = "id_art", referencedColumnName = "id")
		private Article article;

}
