package com.site.SDE.Repository;

import com.site.SDE.Entite.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TacheRepository extends JpaRepository<Tache,Long> {
    List<Tache> findProprietaireById(Long id);
}
