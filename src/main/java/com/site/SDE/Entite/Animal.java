package com.site.SDE.Entite;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String race;
    private String daten;
    private float poids;
    @Lob
    private String image;

    public String getImage() {
        return image;
    }

    public String getDaten() {
        return daten;
    }

    public float getPoids() {
        return poids;
    }

    @ManyToOne
    @JoinColumn(name="proprietaireId")
    private Proprietaire proprietaire;


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getRace() {
        return race;
    }

    @JsonBackReference
    public Proprietaire getProprietaire() {
        return proprietaire;
    }



}
