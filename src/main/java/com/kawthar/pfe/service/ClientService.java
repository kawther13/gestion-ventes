package com.kawthar.pfe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Article;
import com.kawthar.pfe.model.Client;

public interface ClientService{
	Client ajouterClient(Client client);
	List<Client> listClients();
	void supprimerClient(Long id);
	Client rechercherParId(Long id);
}
