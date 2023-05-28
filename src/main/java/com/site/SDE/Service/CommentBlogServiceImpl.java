package com.site.SDE.Service;

import com.site.SDE.Entite.CommentBlog;
import com.site.SDE.Repository.CommentBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentBlogServiceImpl implements CommentBlogService {
    @Autowired
    CommentBlogRepository commentBlogRepository;
    @Override
    public CommentBlog ajouterCommentBlog(CommentBlog contact) {
        return commentBlogRepository.save(contact);
    }

    @Override
    public CommentBlog modifierCommentBlog(CommentBlog contact) {
        return commentBlogRepository.save(contact);
    }

    @Override
    public List<CommentBlog> lstCommentBlog() {
        return commentBlogRepository.findAll();
    }

    @Override
    public CommentBlog getCommentBlogById(Long id)  {
        Optional<CommentBlog> animal = commentBlogRepository.findById(id);

        if(animal.isPresent()) {
            return animal.get();
        }
        return null;
    }

    @Override
    public List<CommentBlog> listeCommentBlogByBlogId(Long id) {
        return commentBlogRepository.findBlogById(id);
    }

    @Override
    public void supprimerCommentBlog(Long id) {
        commentBlogRepository.deleteById(id);
    }
}
