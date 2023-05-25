package com.kawthar.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Facture;

public interface FactureRepo extends JpaRepository<Facture, Long>{

}
