package com.amitravel.promocion;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion, Long> {
    @Query(value = "SELECT * FROM PROMOCIONES WHERE MATCH(nombre, descripcion) AGAINST(?1)", nativeQuery = true)
    Page<Promocion> findAllByMatch(String busqueda, PageRequest of);

    List<Promocion> findAllByNegocioId(Long negocioId);
}
