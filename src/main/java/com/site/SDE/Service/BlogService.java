package com.site.SDE.Service;

import com.site.SDE.Entite.Blog;
import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog ajouterBlog(Blog blog);
    Blog modifierBlog(Blog blog );
    List<Blog> lstBlog();
    Optional<Blog> getBlogById(Long id);
    void supprimerBlog(Long id);
}
