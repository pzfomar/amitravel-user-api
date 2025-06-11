package com.amitravel.persona;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    @Query(value = "SELECT * FROM PERSONAS WHERE MATCH(nombre, apellido_paterno, apellido_materno, telefono) AGAINST(?1)", nativeQuery = true)
    Page<Persona> findAllByMatch(String busqueda, PageRequest of);

    Optional<Persona> findByUsuarioId(Long usuarioId);
}
