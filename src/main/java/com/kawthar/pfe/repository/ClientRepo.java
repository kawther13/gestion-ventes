package com.kawthar.pfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Client;
import com.kawthar.pfe.model.Commande;

public interface ClientRepo  extends JpaRepository<Client, Long>{
}
