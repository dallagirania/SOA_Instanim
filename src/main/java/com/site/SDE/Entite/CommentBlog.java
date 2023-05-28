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
public class CommentBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String msg;
    private String date;
    @Lob
    private String image;

    public String getPrenom() {
        return prenom;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMsg() {
        return msg;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }
    @ManyToOne
    @JoinColumn(name="blogId")
    private Blog blog;
    @JsonBackReference
    public Blog getBlog() {
        return blog;
    }
}
