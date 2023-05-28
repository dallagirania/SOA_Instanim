package com.site.SDE.Repository;

import com.site.SDE.Entite.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository  extends JpaRepository<Services,Long> {
}
