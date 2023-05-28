package com.site.SDE.Service;

import com.site.SDE.Entite.Tache;
import com.site.SDE.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheServiceImpl implements TacheService{
    @Autowired
    TacheRepository tacheRepository;
    @Override
    public Tache ajouterTache(Tache tache) {
        return tacheRepository.save(tache);

    }

    @Override
    public Tache modifierTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> lstTache() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache getTacheById(Long id) {
        Optional<Tache> animal = tacheRepository.findById(id);

        if(animal.isPresent()) {
            return animal.get();
        }
        return null;
    }

    @Override
    public List<Tache> listeTacheByProId(Long id) {
        return tacheRepository.findProprietaireById(id);
    }

    @Override
    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);

    }
}
