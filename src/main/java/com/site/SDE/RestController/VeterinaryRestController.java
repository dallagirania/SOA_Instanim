package com.site.SDE.RestController;

import com.site.SDE.Entite.Veterinary;
import com.site.SDE.Service.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/vet")
public class VeterinaryRestController {
    @Autowired
    VeterinaryService vetService;

    @RequestMapping(method = RequestMethod.POST)
    public Veterinary ajouterVeterinary(@RequestBody Veterinary vet){
        return vetService.ajouterVeterinary(vet);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Veterinary modifierVeterinary(@PathVariable("id")Long id,@RequestBody Veterinary vet){
        Veterinary newVet=vetService.modifierVeterinary(vet);
        return newVet;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerVeterinary(@PathVariable("id")Long id){
        vetService.supprimerVeterinary(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Veterinary> getVeterinaryById(@PathVariable("id")Long id){
        Optional<Veterinary>vet=vetService.getVeterinaryById(id);
        return vet;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Veterinary> lstVeterinary(){
        return vetService.lstVeterinary();
    }
}

