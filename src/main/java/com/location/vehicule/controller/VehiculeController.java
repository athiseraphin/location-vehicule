/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.vehicule.controller;

import com.location.vehicule.model.Vehicule;
import com.location.vehicule.service.VehiculeService;
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
@RequestMapping("/vehicule") // localhost:9696/vehicule
public class VehiculeController {
    
    @Autowired
    private VehiculeService vhlService;
    
    @PostMapping(value = "/save") // localhost:9696/vehicule/save
    public ResponseEntity<Vehicule> enregistrerVehicule(@RequestBody Vehicule vehicule) {
        Vehicule vhl = this.vhlService.enregistrer(vehicule);
        return (vhl == null) ? ResponseEntity.ok(null) : ResponseEntity.ok(vhl);
    }
    
    @PutMapping(value = "/update") // localhost:9696/vehicule/update
    public ResponseEntity<Vehicule> modifierVehicule(@RequestBody Vehicule vehicule) {
        Vehicule vhl = this.vhlService.enregistrer(vehicule);
        return (vhl == null) ? ResponseEntity.ok(null) : ResponseEntity.ok(vhl);
    }
    
    @GetMapping(value = "/search/{id}") // localhost:9696/vehicule/search/1
    public Vehicule rechercherVehicule(@PathVariable("id") Long idVehicule) {
        return this.vhlService.rechercher(idVehicule);
    }
    
    @DeleteMapping(value = "/delete/{id}") // localhost:9696/vehicule/delete/1
    public ResponseEntity<String> supprimerVehicule(@PathVariable("id") Long idVehicule) {
        this.vhlService.supprimer(idVehicule);
        return ResponseEntity.ok("Suppression Ok.");
    }
    
    @GetMapping(value = "/all") // localhost:9696/vehicule/all
    public List<Vehicule> listerVehicules() {
        return this.vhlService.lister();
    }
    
    @GetMapping(value = "/") // localhost:9696/vehicule/
    public String home(){
        return "Controleur Vehicule";
    }
    
}
