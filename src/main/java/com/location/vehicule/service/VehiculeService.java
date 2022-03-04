/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.vehicule.service;

import com.location.vehicule.model.Vehicule;
import com.location.vehicule.repository.VehiculeRepository;
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
public class VehiculeService {
    
    @Autowired
    private VehiculeRepository vhlRepo;
    
    public Vehicule enregistrer(Vehicule vehicule) {
        return this.vhlRepo.save(vehicule);
    }
    
    public Vehicule rechercher(Long idVehicule) {
        return this.vhlRepo.findById(idVehicule).orElse(new Vehicule());
    }
    
    public void supprimer(Long idVehicule) {
        this.vhlRepo.deleteById(idVehicule);
    }
    
    public List<Vehicule> lister() {
        return this.vhlRepo.findAll();
    }
    
}
