package com.site.SDE.RestController;

import com.site.SDE.Entite.Blog;
import com.site.SDE.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/blog")
public class BlogRestController {
    @Autowired
    BlogService blogService;

    @RequestMapping(method = RequestMethod.POST)
    public Blog ajouterBlog(@RequestBody Blog vet){
        return blogService.ajouterBlog(vet);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Blog modifierBlog(@PathVariable("id")Long id,@RequestBody Blog vet){
        Blog newVet=blogService.modifierBlog(vet);
        return newVet;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerBlog(@PathVariable("id")Long id){
        blogService.supprimerBlog(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Blog> getBlogById(@PathVariable("id")Long id){
        Optional<Blog>vet=blogService.getBlogById(id);
        return vet;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Blog> lstBlog(){
        return blogService.lstBlog();
    }
}



