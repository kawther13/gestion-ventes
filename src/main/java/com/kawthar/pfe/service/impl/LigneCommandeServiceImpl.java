package com.kawthar.pfe.service.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.Commande;
import com.kawthar.pfe.model.LigneCommande;
import com.kawthar.pfe.repository.ArticleRepo;
import com.kawthar.pfe.repository.CommandeRepo;
import com.kawthar.pfe.repository.LignCommandeRepo;
import com.kawthar.pfe.service.LignCommandeService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class LigneCommandeServiceImpl implements LignCommandeService{
@Autowired
private LignCommandeRepo lignCommandeRepo;
@Autowired
private CommandeRepo commandeRepo;
@Autowired ArticleRepo articleRepo;
@Override
public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande , Long id) {
	// TODO Auto-generated method stub
	Commande commande=commandeRepo.findById(id).get();
		ligneCommande.setCommande(commande);
		Article art=articleRepo.findById(ligneCommande.getArticle().getId()).get();
		 
		art.setQteArt(art.getQteArt()-ligneCommande.getQuantity());
		articleRepo.save(art);

	ligneCommande.setArticle(art);
 	double prix_Total=ligneCommande.getArticle().getPrixArticle()*ligneCommande.getQuantity();

	commande.setTotalprix(prix_Total+calculeTotal(commande.getId()));
	commandeRepo.save(commande);
	
	ligneCommande.setTotalPrice(prix_Total);
	return lignCommandeRepo.save(ligneCommande);
}
	@Override
	public List<LigneCommande> list() {
		// TODO Auto-generated method stub
		return lignCommandeRepo.findAll();
	}

	@Override
	public void supprimerLignCommande(Long id) {
		// TODO Auto-generated method stub
		LigneCommande ligneCommande=lignCommandeRepo.findById(id).get();
		Commande cmd=commandeRepo.findById(ligneCommande.getCommande().getId()).get();
		cmd.setTotalprix(cmd.getTotalprix()-ligneCommande.getTotalPrice());
		commandeRepo.save(cmd);
		Article art=articleRepo.findById(ligneCommande.getArticle().getId()).get();
		art.setQteArt(art.getQteArt()+ligneCommande.getQuantity());
		articleRepo.save(art);
		lignCommandeRepo.deleteLigneCommande(id);
	}

	
	@Override
	public LigneCommande rechercherParId(Long id_ordDetails) {
		// TODO Auto-generated method stub
		return lignCommandeRepo.findLigneCommandeById(id_ordDetails);
	}

	@Override
	public List<LigneCommande> listByCommande(Commande commande) {
		// TODO Auto-generated method stub
		return lignCommandeRepo.findByCommande(commande);
	}

	@Override
	public double calculeTotal(Long id) {
		// TODO Auto-generated method stub
		try {
			double total= lignCommandeRepo.calculerTotal(id);
			Commande commande= commandeRepo.findById(id).get();
			commande.setTotalprix(total);
			if(total==0.0) {
				return 0;
			}else {
				return total;
			}
		} catch (Exception e) {
			e.printStackTrace();
					return 0;
		}
		
	}


}
