package com.site.SDE.Service;

import com.site.SDE.Entite.Veterinary;

import java.util.List;
import java.util.Optional;

public interface VeterinaryService {
    Veterinary ajouterVeterinary(Veterinary contact);
    Veterinary modifierVeterinary(Veterinary contact );
    List<Veterinary> lstVeterinary();
    Optional<Veterinary> getVeterinaryById(Long id);
    void supprimerVeterinary(Long id);
}


