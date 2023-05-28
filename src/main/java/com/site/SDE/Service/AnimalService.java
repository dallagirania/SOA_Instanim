package com.site.SDE.Service;

import com.site.SDE.Entite.Animal;


import java.util.List;

public interface AnimalService {
    Animal ajouterAnimal(Animal animal);
    Animal modifierAnimal(Animal animal);
    List<Animal> lstAnimal();
    Animal getAnimalById(Long id);
    List<Animal> listeAnimalByProId(Long id);
    void supprimerAnimal(Long id);
}
