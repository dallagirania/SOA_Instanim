package com.site.SDE.Service;
import com.site.SDE.Entite.Veterinary;
import com.site.SDE.Repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class VeterinaryServiceImpl implements VeterinaryService {
    @Autowired
    VeterinaryRepository veterinaryRepository;

    @Override
    public  Veterinary ajouterVeterinary( Veterinary contact) {
        return veterinaryRepository.save(contact);
    }

    @Override
    public Veterinary modifierVeterinary(Veterinary contact) {
        return veterinaryRepository.save(contact);
    }

    @Override
    public List<Veterinary> lstVeterinary() {
        return veterinaryRepository.findAll();
    }

    @Override
    public Optional<Veterinary> getVeterinaryById(Long id) {
        return veterinaryRepository.findById(id);
    }

    @Override
    public void supprimerVeterinary(Long id) {
        veterinaryRepository.deleteById(id);

    }
}

