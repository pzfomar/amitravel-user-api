package com.amitravel.anuncio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    List<Anuncio> findAllByNegocioId(Long negocioId);
}
