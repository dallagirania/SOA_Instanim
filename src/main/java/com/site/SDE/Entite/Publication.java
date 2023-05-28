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
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String datepub;
    private boolean etat=false;
    private boolean aime=false;

    @Lob
    private String image;
    @ManyToOne
    @JoinColumn(name="proprietaireId")
    private Proprietaire proprietaire;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getDatepub() {
        return datepub;
    }

    public boolean isEtat() {
        return etat;
    }
    public String getImage() {
        return image;
    }

    @JsonBackReference
    public Proprietaire getProprietaire() {
        return proprietaire;
    }


}
