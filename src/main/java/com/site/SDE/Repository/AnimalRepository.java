package com.site.SDE.Repository;
import com.site.SDE.Entite.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findProprietaireById(Long id);
}
