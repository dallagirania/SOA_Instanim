package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Titre;
    private String description;
    private String date;
    private String anim;

    @ManyToOne
    @JoinColumn(name="proprietaireId")
    private Proprietaire proprietaire;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return Titre;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getAnim() {
        return anim;
    }

    @JsonBackReference
    public Proprietaire getProprietaire() {
        return proprietaire;
    }
}
