package com.site.SDE.Repository;

import com.site.SDE.Entite.CommentBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentBlogRepository  extends JpaRepository<CommentBlog,Long> {
    List<CommentBlog> findBlogById(Long id);
}
