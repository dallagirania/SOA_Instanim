package com.site.SDE.RestController;

import com.site.SDE.Entite.*;
import com.site.SDE.Service.CommentBlogService;
import com.site.SDE.Service.ProprietaireService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/CBlog")
public class CommentBlogRestController {
    @Autowired
    CommentBlogService commentBlogService;

    @Autowired
    ProprietaireService proprietaireService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    public CommentBlogDto ajouterCommentBlog(@RequestBody CommentBlogDto animalDto){
        CommentBlog offreRequest=modelMapper.map(animalDto,CommentBlog.class);
        CommentBlog animal=commentBlogService.ajouterCommentBlog(offreRequest);
        CommentBlogDto animalResponse=modelMapper.map(animal,CommentBlogDto.class);
        return animalResponse;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public CommentBlog modifierOffre(@PathVariable("id")Long id,@RequestBody CommentBlog animal){
        CommentBlog newanimal=commentBlogService.modifierCommentBlog(animal);
        return newanimal;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerCommentBlogl(@PathVariable("id")Long id){
        commentBlogService.supprimerCommentBlog(id);
    }

    //    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Optional<Offre>getOffreById(@PathVariable("id")Long id){
//        Optional<Offre>offre=offresService.getOffreById(id);
//        return offre;
//    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<CommentBlogDto> getCommentBloglById(@PathVariable("id")Long id){
        CommentBlog animal=commentBlogService.getCommentBlogById(id);
        CommentBlogDto animalDto=modelMapper.map(animal,CommentBlogDto.class);
        return ResponseEntity.ok().body(animalDto);
    }
    //    @RequestMapping(method = RequestMethod.GET)
//    public List<Offre>lstOffres(){
//        return offresService.lstOffres();
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<CommentBlogDto>lstAnimal(){
        return commentBlogService.lstCommentBlog().stream().map(animal -> modelMapper.map(animal,CommentBlogDto.class)).collect(Collectors.toList());
    }

    @GetMapping("list-CommentBlog-by-blog/{id}")
    public List<CommentBlog> listCommentBlogByIdBlog(@PathVariable Long id) {
        return commentBlogService.listeCommentBlogByBlogId(id);
    }
}


