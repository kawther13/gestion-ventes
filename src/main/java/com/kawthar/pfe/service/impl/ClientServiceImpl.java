package com.kawthar.pfe.service.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawthar.pfe.model.Client;
import com.kawthar.pfe.repository.ClientRepo;
import com.kawthar.pfe.service.ClientService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Service

public class ClientServiceImpl  implements ClientService{
@Autowired
private ClientRepo clientRepo;
	@Override
	public Client ajouterClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepo.save(client);
	}

	@Override
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		return clientRepo.findAll();
	}

	@Override
	public void supprimerClient(Long id) {
		// TODO Auto-generated method stub
		clientRepo.deleteById(id);
	}

	@Override
	public Client rechercherParId(Long id) {
		// TODO Auto-generated method stub
		return clientRepo.findById(id).get();
	}
}
