package com.site.SDE.Entite;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Veterinary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;

    public String getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    private String adresse;


    public String getImg() {
        return img;
    }

    @Lob
    private String img;

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Long getId() {
        return id;
    }


}