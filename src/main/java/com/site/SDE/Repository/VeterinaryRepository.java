package com.site.SDE.Repository;

import com.site.SDE.Entite.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VeterinaryRepository extends JpaRepository<Veterinary,Long> {
}
