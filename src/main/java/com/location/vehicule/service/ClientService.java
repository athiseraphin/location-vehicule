/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.vehicule.service;


import com.location.vehicule.model.Client;
import com.location.vehicule.repository.ClientRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author seraphinathis
 */
@Service
@Transactional
public class ClientService {
    
    @Autowired
    private ClientRepository cltRepo;
    
    public Client enregistrer(Client client) {
        return this.cltRepo.save(client);
    }
    
    public Client rechercher(Long idClient) {
        return this.cltRepo.findById(idClient).orElse(new Client());
    }
    
    public void supprimer(Long idClient) {
        this.cltRepo.deleteById(idClient);
    }
    
    public List<Client> lister() {
        return this.cltRepo.findAll();
    }
    
}
