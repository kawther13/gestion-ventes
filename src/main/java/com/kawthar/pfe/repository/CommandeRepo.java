package com.kawthar.pfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kawthar.pfe.model.Commande;

public interface CommandeRepo extends JpaRepository<Commande, Long>{ 
	
@Query(value = "SELECT * FROM comercial.commande where id_clt=?1", nativeQuery = true)  
List<Commande> commandClient(Long idClt);
@Query(value="SELECT * FROM comercial.commande where enattente=true and valide=false  or enattente=false and valide=true", nativeQuery = true)
List<Commande> listCommandes();
@Query(value="SELECT * FROM comercial.commande where enattente=false and valide=false", nativeQuery = true)
List<Commande> listDevis();
@Query(value="SELECT sum(totalprix) FROM comercial.commande where valide=true;", nativeQuery = true)
double calculerTotal(); 
}
