package com.site.SDE.Entite;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String categorie;
    private String email;
    private String tel;
    private String adresse;
    @Lob
    private String img;

    public String getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getImg() {
        return img;
    }



    public String getEmail() {
        return email;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getNom() {
        return nom;
    }

    public Long getId() {
        return id;
    }


}