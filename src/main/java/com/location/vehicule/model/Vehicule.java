/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.vehicule.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author seraphinathis
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
public class Vehicule implements Serializable {
    
    @Id
    @SequenceGenerator(name = "vehicule_sequence", sequenceName = "vehicule_sequence", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicule_sequence")
    private Long idVehicule;
    private String plaque;
    private String numeroMoteur;
    private String marque;
    private String modele;
    private String couleur;
    private String transmission;
    private String moteur;
    private double prixLocation;
    private String etat; // Disponible - En Location - En Reparation
    
}
