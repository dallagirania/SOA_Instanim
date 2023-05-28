package com.site.SDE.Service;

import com.site.SDE.Entite.Services;
import com.site.SDE.Repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServicesServiceImpl implements ServicesService{
    @Autowired
    ServicesRepository servicesRepository;

    @Override
    public Services ajouterService(Services contact) {
        return servicesRepository.save(contact);
    }

    @Override
    public Services modifierService(Services contact) {
        return servicesRepository.save(contact);
    }

    @Override
    public List<Services> lstService() {
        return servicesRepository.findAll();
    }

    @Override
    public Optional<Services> getServiceById(Long id) {
        return servicesRepository.findById(id);
    }

    @Override
    public void supprimerService(Long id) {
        servicesRepository.deleteById(id);

    }
}
