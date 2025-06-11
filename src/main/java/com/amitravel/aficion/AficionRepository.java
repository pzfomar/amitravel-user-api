package com.amitravel.aficion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AficionRepository extends JpaRepository<Aficion, Long> {

    List<Aficion> findAllByUsuarioId(Long usuarioId);

}
