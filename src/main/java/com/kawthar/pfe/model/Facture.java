package com.kawthar.pfe.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_ordDetails;
	
	private int quantity;
	private double totalPrice,unitPrice;
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_order", referencedColumnName = "id")
	  private Commande order;
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_Article", referencedColumnName = "id")
	private Article article;
	
}
