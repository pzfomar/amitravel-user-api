package com.amitravel.calificacion;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    @Query(value = "SELECT * FROM CALIFICACIONES WHERE MATCH(comentario) AGAINST(?1)", nativeQuery = true)
    Page<Calificacion> findAllByMatch(String busqueda, PageRequest of);

    List<Calificacion> findAllByEventoId(Long eventoId);
}
