package com.site.SDE.RestController;

import com.site.SDE.Entite.Services;
import com.site.SDE.Service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/service")
public class ServicesRestController {  @Autowired
ServicesService serviceService;

    @RequestMapping(method = RequestMethod.POST)
    public Services ajouterVeterinary(@RequestBody Services service){
        return serviceService.ajouterService(service);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Services modifierService(@PathVariable("id")Long id,@RequestBody Services service){
        Services newservice=serviceService.modifierService(service);
        return newservice;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerService(@PathVariable("id")Long id){
        serviceService.supprimerService(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Services> getServiceById(@PathVariable("id")Long id){
        Optional<Services>vet=serviceService.getServiceById(id);
        return vet;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Services> lstVeterinary(){
        return serviceService.lstService();
    }
}
