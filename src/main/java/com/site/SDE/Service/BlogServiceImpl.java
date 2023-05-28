package com.site.SDE.Service;

import com.site.SDE.Entite.Blog;
import com.site.SDE.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog ajouterBlog(Blog contact) {
        return blogRepository.save(contact);
    }

    @Override
    public Blog modifierBlog(Blog contact) {
        return blogRepository.save(contact);
    }

    @Override
    public List<Blog> lstBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void supprimerBlog(Long id) {
        blogRepository.deleteById(id);

    }
}
