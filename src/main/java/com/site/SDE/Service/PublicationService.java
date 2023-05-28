package com.site.SDE.Service;
import com.site.SDE.Entite.Publication;

import java.util.List;

public interface PublicationService {
    Publication ajouterPublication(Publication publication);
    Publication modifierPublication(Publication publication);
    List<Publication> lstPublication();
    Publication getPublicationById(Long id);
    List<Publication> listePublicationByProId(Long id);
    void supprimerPublication(Long id);
}
