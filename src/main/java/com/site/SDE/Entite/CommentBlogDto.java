package com.site.SDE.Entite;

import lombok.Data;



@Data
public class CommentBlogDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String msg;
    private String date;
    private String image;
    private Blog blog;
}
