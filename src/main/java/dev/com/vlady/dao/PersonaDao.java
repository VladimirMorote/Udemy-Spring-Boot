package dev.com.vlady.dao;

import dev.com.vlady.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaDao extends JpaRepository<Persona,Long> {

}
