package com.site.SDE.Service;

import com.site.SDE.Entite.Publication;
import com.site.SDE.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService{
    @Autowired
PublicationRepository animalRepository;

    @Override
    public Publication ajouterPublication(Publication offre) {
        return animalRepository.save(offre);
    }

    @Override
    public Publication modifierPublication(Publication offre) {
        return animalRepository.save(offre);
    }

    @Override
    public List<Publication> lstPublication() {
        return animalRepository.findAll();
    }

    @Override
    public Publication getPublicationById(Long id) {
        Optional<Publication> animal = animalRepository.findById(id);

        if(animal.isPresent()) {
            return animal.get();
        }
        return null;
    }

    @Override
    public List<Publication> listePublicationByProId(Long id) {
        return animalRepository.findProprietaireById(id);
    }

    @Override
    public void supprimerPublication(Long id) {
        animalRepository.deleteById(id);
    }
}


