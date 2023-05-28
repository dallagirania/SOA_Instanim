package com.site.SDE.Service;

import com.site.SDE.Entite.Proprietaire;
import com.site.SDE.Repository.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProprietaireServiceImpl implements ProprietaireService{

    @Autowired
    ProprietaireRepository proprietaireRepository;

    @Override
    public Proprietaire ajouterProprietaire(Proprietaire proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    @Override
    public Proprietaire modifierProprietaire(Proprietaire proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    @Override
    public List<Proprietaire> listProprietaire() {
        return proprietaireRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        proprietaireRepository.deleteById(id);

    }

    @Override
    public Optional<Proprietaire> FindById(Long id) {

        if(id!=null) {
            return proprietaireRepository.findById(id);
        }
        else
            return Optional.empty();

    }
    }

