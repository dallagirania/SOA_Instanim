package com.site.SDE.Service;

import com.site.SDE.Entite.Animal;
import com.site.SDE.Entite.CommentBlog;
import com.site.SDE.Entite.Contact;

import java.util.List;
import java.util.Optional;

public interface CommentBlogService {
    CommentBlog ajouterCommentBlog(CommentBlog contact);
    CommentBlog modifierCommentBlog(CommentBlog contact );
    List<CommentBlog> lstCommentBlog();

    CommentBlog getCommentBlogById(Long id);
    List<CommentBlog> listeCommentBlogByBlogId(Long id);
    void supprimerCommentBlog(Long id);
}
