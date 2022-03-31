/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.vehicule.controller;

import com.location.vehicule.model.Client;
import com.location.vehicule.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author seraphinathis
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client") // localhost:9696/client
public class ClientController {
    
    @Autowired
    private ClientService cltService;
    
    @PostMapping(value = "/save") // localhost:9696/client/save
    public ResponseEntity<Client> enregistrerClient(@RequestBody Client client) {
        Client clt = this.cltService.enregistrer(client);
        return (clt == null) ? ResponseEntity.ok(null) : ResponseEntity.ok(clt);
    }
    
    @PutMapping(value = "/update") // localhost:9696/client/update
    public ResponseEntity<Client> modifierClient(@RequestBody Client client) {
        Client clt = this.cltService.enregistrer(client);
        return (clt == null) ? ResponseEntity.ok(null) : ResponseEntity.ok(clt);
    }
    
    @GetMapping(value = "/search/{id}") // localhost:9696/client/search/1
    public Client rechercherClient(@PathVariable("id") Long idClient) {
        return this.cltService.rechercher(idClient);
    }
    
    @DeleteMapping(value = "/delete/{id}") // localhost:9696/client/delete/1
    public ResponseEntity<String> supprimerClient(@PathVariable("id") Long idClient) {
        this.cltService.supprimer(idClient);
        return ResponseEntity.ok("Suppression Ok.");
    }
    
    @GetMapping(value = "/all") // localhost:9696/client/all
    public List<Client> listerClients() {
        return this.cltService.lister();
    }
    
    @GetMapping(value = "/") // localhost:9696/client/
    public String home(){
        return "Controleur Client";
    }
    
}
