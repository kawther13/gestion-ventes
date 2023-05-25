package com.kawthar.pfe.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kawthar.pfe.model.Commande;
import com.kawthar.pfe.model.LigneCommande;

public interface LignCommandeRepo extends JpaRepository<LigneCommande, Long> {
   
 List<LigneCommande> findByCommande(Commande commande);
@Query(value="SELECT  sum(total_price) FROM comercial.ligne_commande lc where lc.id_cmd=?", nativeQuery = true)
 double calculerTotal(Long id); 
@Query(value="SELECT * FROM comercial.ligne_commande where id_ord_details=?",nativeQuery = true)
LigneCommande findLigneCommandeById(Long id) ;

@Query(value="SELECT  * FROM comercial.ligne_commande lc where lc.id_cmd=?", nativeQuery = true)
List<LigneCommande> ligneCommandeDeCommande(Long id); 
@Modifying
@Transactional
 @Query(value="DELETE FROM comercial.ligne_commande WHERE id_ord_details =? ", nativeQuery=true) 
 void deleteLigneCommande(Long id );
 
@Modifying
@Transactional
@Query(value="DELETE FROM comercial.ligne_commande WHERE id_cmd = ?1", nativeQuery=true)
void deleteLigneCommandeByCommande(Long id);
}
