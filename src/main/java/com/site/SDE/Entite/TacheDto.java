package com.site.SDE.Entite;

import lombok.Data;

@Data
public class TacheDto {
    private Long id;
    private String Titre;
    private String description;
    private String date;
    private String anim;
    private Proprietaire proprietaire;
}
