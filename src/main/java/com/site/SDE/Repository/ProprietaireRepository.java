package com.site.SDE.Repository;

import com.site.SDE.Entite.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepository extends JpaRepository <Proprietaire,Long> {
    Proprietaire findIdByEmail(String email);
    boolean existsByEmail(String email);
    Proprietaire findProprietaireByAnimalId(long id);

}
