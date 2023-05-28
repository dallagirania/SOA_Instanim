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
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String text;
    private String description;
    private String categorie;
    @Lob
    private String img;
    @OneToMany (mappedBy ="blog")
    private List<CommentBlog> commentBlog;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getText() {
        return text;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }


    @JsonManagedReference
    public List<CommentBlog> getCommentBlog() {
        return commentBlog;
    }
}
