package com.site.SDE.Entite;

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
public class
Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    public String getImg() {
        return img;
    }

    @Lob
    private String img;
    @Lob
    private String photo;

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPhoto() {
        return photo;
    }

    public Long getId() {
        return id;
    }

    public String getMdp() {
        return mdp;
    }
    @OneToMany (mappedBy ="proprietaire")
    private List<Animal> animal;

    @JsonManagedReference
    public List<Animal> getAnimal() {
        return animal;
    }
    @OneToMany (mappedBy ="proprietaire")
    private List<Publication> publication;

    @JsonManagedReference
    public List<Publication> getPublication() {
        return publication;
    }


    @OneToMany (mappedBy ="proprietaire")
    private List<Tache> tache;

    @JsonManagedReference
    public List<Tache> getTache() {
        return tache;
    }



}