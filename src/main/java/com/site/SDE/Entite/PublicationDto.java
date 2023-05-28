package com.site.SDE.Entite;

import lombok.Data;

import java.io.Serializable;

@Data
public class PublicationDto implements Serializable {
    private Long id;
    private String text;
    private String datepub;
    private boolean etat=false;
    private String image;
    private Proprietaire proprietaire;
}