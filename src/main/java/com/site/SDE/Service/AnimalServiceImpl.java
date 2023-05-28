package com.site.SDE.Service;

import com.site.SDE.Entite.Animal;
import com.site.SDE.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService{

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public Animal ajouterAnimal(Animal offre) {
        return animalRepository.save(offre);
    }

    @Override
    public Animal modifierAnimal(Animal offre) {
        return animalRepository.save(offre);
    }

    @Override
    public List<Animal> lstAnimal() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getAnimalById(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);

        if(animal.isPresent()) {
            return animal.get();
        }
        return null;
    }

    @Override
    public List<Animal> listeAnimalByProId(Long id) {
        return animalRepository.findProprietaireById(id);
    }

    @Override
    public void supprimerAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
