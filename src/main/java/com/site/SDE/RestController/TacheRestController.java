package com.site.SDE.RestController;

import com.site.SDE.Entite.Tache;
import com.site.SDE.Entite.TacheDto;
import com.site.SDE.Service.ProprietaireService;
import com.site.SDE.Service.TacheService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Tache")
public class TacheRestController {
    @Autowired
    TacheService tacheService;
    @Autowired
    ProprietaireService proprietaireService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    public TacheDto ajouterTache(@RequestBody TacheDto tacheDto){
        Tache offreRequest=modelMapper.map(tacheDto,Tache.class);
        Tache animal=tacheService.ajouterTache(offreRequest);
        TacheDto animalResponse=modelMapper.map(animal,TacheDto.class);
        return animalResponse;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Tache modifierTache(@PathVariable("id")Long id,@RequestBody Tache tache){
        Tache newanimal=tacheService.modifierTache(tache);
        return newanimal;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerTache(@PathVariable("id")Long id){
        tacheService.supprimerTache(id);
    }

    //    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Optional<Offre>getOffreById(@PathVariable("id")Long id){
//        Optional<Offre>offre=offresService.getOffreById(id);
//        return offre;
//    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<TacheDto> getTacheById(@PathVariable("id")Long id){
        Tache animal=tacheService.getTacheById(id);
        TacheDto animalDto=modelMapper.map(animal,TacheDto.class);
        return ResponseEntity.ok().body(animalDto);
    }
    //    @RequestMapping(method = RequestMethod.GET)
//    public List<Offre>lstOffres(){
//        return offresService.lstOffres();
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<TacheDto> lstTache(){
        return tacheService.lstTache().stream().map(animal -> modelMapper.map(animal,TacheDto.class)).collect(Collectors.toList());
    }

    @GetMapping("list-tache-by-prop/{id}")
    public List<Tache> listTacheByIdPrp(@PathVariable Long id) {
        return tacheService.listeTacheByProId(id);
    }
}

