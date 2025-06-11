package com.amitravel.busqueda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusquedaRepository extends JpaRepository<Busqueda, Long> {

    List<Busqueda> findTop10ByOrderByVisitadaDesc();

}
