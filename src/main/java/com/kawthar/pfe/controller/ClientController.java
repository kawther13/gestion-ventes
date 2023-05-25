package com.kawthar.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawthar.pfe.model.Client;
import com.kawthar.pfe.service.ClientService;


@RestController
@RequestMapping(value = "/pfe/client")
public class ClientController {
@Autowired
private ClientService clientService;
@GetMapping(value = "/all")
public List<Client> listClients(){
	return clientService.listClients();
}
@PostMapping(value = "/save")
public Client ajouterClient(@RequestBody Client client) {
	return clientService.ajouterClient(client);
}
@DeleteMapping(value="/delete/{id}")
public void deleteClient(@PathVariable("id") Long id) {
	clientService.supprimerClient(id);
}
@GetMapping(value="/byId/{id}")
public Client findById(@PathVariable("id") Long id) {
	return clientService.rechercherParId(id);
}

}
