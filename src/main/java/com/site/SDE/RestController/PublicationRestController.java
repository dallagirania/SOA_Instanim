package com.site.SDE.RestController;
import com.site.SDE.Entite.Publication;
import com.site.SDE.Entite.PublicationDto;
import com.site.SDE.Service.ProprietaireService;
import com.site.SDE.Service.PublicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/publication")
public class PublicationRestController {
    @Autowired
    PublicationService animalService;
    @Autowired
    ProprietaireService proprietaireService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    public PublicationDto ajouterAdd(@RequestBody  PublicationDto publicationDto){
        Publication publicationRequest=modelMapper.map(publicationDto,Publication.class);
        Publication publication=animalService.ajouterPublication(publicationRequest);
        PublicationDto publicationResponse=modelMapper.map(publication,PublicationDto.class);
        return publicationResponse;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Publication modifierOffre(@PathVariable("id")Long id,@RequestBody Publication animal){
        Publication newanimal=animalService.modifierPublication(animal);
        return newanimal;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerPublication(@PathVariable("id")Long id){
        animalService.supprimerPublication(id);
    }

    //    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Optional<Offre>getOffreById(@PathVariable("id")Long id){
//        Optional<Offre>offre=offresService.getOffreById(id);
//        return offre;
//    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<PublicationDto> getanimalById(@PathVariable("id")Long id){
        Publication animal=animalService.getPublicationById(id);
        PublicationDto animalDto=modelMapper.map(animal,PublicationDto.class);
        return ResponseEntity.ok().body(animalDto);
    }
    //    @RequestMapping(method = RequestMethod.GET)
//    public List<Offre>lstOffres(){
//        return offresService.lstOffres();
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<PublicationDto>lstAnimal(){
        return animalService.lstPublication().stream().map(animal -> modelMapper.map(animal,PublicationDto.class)).collect(Collectors.toList());
    }

    @GetMapping("list-add-by-prop/{id}")
    public List<Publication> listanimalByIdPrp(@PathVariable Long id) {
        return animalService.listePublicationByProId(id);
    }
}

