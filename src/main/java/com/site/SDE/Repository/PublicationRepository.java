package com.site.SDE.Repository;
import com.site.SDE.Entite.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long> {
    List<Publication> findProprietaireById(Long id);
}