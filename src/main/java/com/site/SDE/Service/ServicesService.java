package com.site.SDE.Service;

import com.site.SDE.Entite.Services;


import java.util.List;
import java.util.Optional;

public interface ServicesService {
    Services ajouterService(Services contact);
    Services modifierService(Services contact );
    List<Services> lstService();
    Optional<Services> getServiceById(Long id);
    void supprimerService(Long id);
}
