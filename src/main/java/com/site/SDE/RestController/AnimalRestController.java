package com.site.SDE.RestController;

import com.site.SDE.Entite.Animal;
import com.site.SDE.Entite.AnimalDto;
import com.site.SDE.Service.AnimalService;
import com.site.SDE.Service.ProprietaireService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/animal")
public class AnimalRestController {
    @Autowired
    AnimalService animalService;
    @Autowired
    ProprietaireService proprietaireService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    public AnimalDto ajouterOffre(@RequestBody AnimalDto animalDto){
        Animal offreRequest=modelMapper.map(animalDto,Animal.class);
        Animal animal=animalService.ajouterAnimal(offreRequest);
        AnimalDto animalResponse=modelMapper.map(animal,AnimalDto.class);
        return animalResponse;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Animal modifierOffre(@PathVariable("id")Long id,@RequestBody Animal animal){
        Animal newanimal=animalService.modifierAnimal(animal);
        return newanimal;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerAnimal(@PathVariable("id")Long id){
        animalService.supprimerAnimal(id);
    }

    //    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Optional<Offre>getOffreById(@PathVariable("id")Long id){
//        Optional<Offre>offre=offresService.getOffreById(id);
//        return offre;
//    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<AnimalDto> getanimalById(@PathVariable("id")Long id){
        Animal animal=animalService.getAnimalById(id);
        AnimalDto animalDto=modelMapper.map(animal,AnimalDto.class);
        return ResponseEntity.ok().body(animalDto);
    }
    //    @RequestMapping(method = RequestMethod.GET)
//    public List<Offre>lstOffres(){
//        return offresService.lstOffres();
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<AnimalDto>lstAnimal(){
        return animalService.lstAnimal().stream().map(animal -> modelMapper.map(animal,AnimalDto.class)).collect(Collectors.toList());
    }

    @GetMapping("list-animal-by-prop/{id}")
    public List<Animal> listanimalByIdPrp(@PathVariable Long id) {
        return animalService.listeAnimalByProId(id);
    }
}


