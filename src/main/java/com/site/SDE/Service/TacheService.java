package com.site.SDE.Service;

import com.site.SDE.Entite.Tache;

import java.util.List;

public interface TacheService {
    Tache ajouterTache(Tache tache);
    Tache modifierTache(Tache tache);
    List<Tache> lstTache();
    Tache getTacheById(Long id);
    List<Tache> listeTacheByProId(Long id);
    void supprimerTache(Long id);
}
