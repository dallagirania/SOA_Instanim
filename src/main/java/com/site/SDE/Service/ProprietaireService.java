package com.site.SDE.Service;

import com.site.SDE.Entite.Proprietaire;

import java.util.List;
import java.util.Optional;

public interface ProprietaireService {
    Proprietaire ajouterProprietaire(Proprietaire proprietaire);
    Proprietaire modifierProprietaire(Proprietaire proprietaire);
    List<Proprietaire> listProprietaire();
    void supprimerById(Long id);
    Optional<Proprietaire> FindById(Long id);
}
