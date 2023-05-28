package com.site.SDE.Entite;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String mdp;

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

    public Long getId() {
        return id;
    }

    public String getMdp() {
        return mdp;
    }


}