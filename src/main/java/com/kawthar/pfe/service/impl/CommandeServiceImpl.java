package com.kawthar.pfe.service.impl;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kawthar.pfe.model.Commande;
import com.kawthar.pfe.model.LigneCommande;
import com.kawthar.pfe.repository.CommandeRepo;
import com.kawthar.pfe.repository.LignCommandeRepo;
import com.kawthar.pfe.service.CommandeService;
import com.kawthar.pfe.service.LignCommandeService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class CommandeServiceImpl implements CommandeService{
@Autowired
private CommandeRepo commandeRepo;
@Autowired
private LignCommandeRepo  lignCommandeRepo;
	@Override
	public Commande ajouterCommande(Commande commande) {
		       commande.setOrderDate(new Date());
		       commande.setValide(false);
		       commande.setNovalider(false);
		       commande.setEnattente(true);
		       return commandeRepo.save(commande);}
				 

	@Override
	public List<Commande> listCommandes() {
		// TODO Auto-generated method stub
		return commandeRepo.listCommandes();
	}
 
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
	@Override
	public void supprimerCommandes(Long id) {
	Commande commande=	commandeRepo.findById(id).get();
 	 lignCommandeRepo.deleteLigneCommandeByCommande(commande.getId());
 	 commandeRepo.deleteById(id);
		 
		 
	}
		@Override
	public Commande rechercherParId(Long id) {
		// TODO Auto-generated method stub
		return commandeRepo.findById(id).get();
	}


	@Override
	public List<Commande> commandClient(Long idClt) {
		// TODO Auto-generated method stub
		return commandeRepo.commandClient(idClt);
	}


	@Override
	public Commande validercommandes(Long id) {
		Commande commande= commandeRepo.findById(id).get();
		commande.setValide(true);
		commande.setTva(commande.getTotalprix()* 0.18);
		commande.setNovalider(false);
		commande.setEnattente(false);
		List<LigneCommande> list=lignCommandeRepo.ligneCommandeDeCommande(id);
		commande.setLigneCommandes(list);
		return commandeRepo.save(commande);
		 
		
 	}


	@Override
	public Commande arretercommandes(Long id) {
		Commande commande= commandeRepo.findById(id).get();
		commande.setValide(false);
		commande.setNovalider(true);
		commande.setEnattente(false);
		commande.setTva(0);
		List<LigneCommande> list=lignCommandeRepo.ligneCommandeDeCommande(id);
		commande.setLigneCommandes(list);
		return commandeRepo.save(commande);
	}


	@Override
	public List<Commande> listDevis() {
		// TODO Auto-generated method stub
		return commandeRepo.listDevis();
	}
	@Override
public double totalCommande() {
	return commandeRepo.calculerTotal();
}
}
