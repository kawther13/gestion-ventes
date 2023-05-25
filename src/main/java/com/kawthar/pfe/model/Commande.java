package com.kawthar.pfe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;  
    private double tva;
    private double totalprix;
    private boolean valide,novalider, enattente;
     @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_clt", referencedColumnName = "id")
    private Client client; 
     @JsonIgnore
     @OneToMany(cascade = CascadeType.ALL,mappedBy = "commande")
     private List<LigneCommande> ligneCommandes;

 
}
