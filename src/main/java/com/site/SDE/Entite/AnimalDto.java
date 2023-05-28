package com.site.SDE.Entite;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimalDto  implements Serializable {
    private Long id;
    private String nom;
    private String race;
    private float poids;
    private String daten;
    private String image;
    private Proprietaire proprietaire;
}
