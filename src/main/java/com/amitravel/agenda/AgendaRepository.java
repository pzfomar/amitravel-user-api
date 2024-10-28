package com.amitravel.agenda;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    List<Agenda> findAllByUsuarioIdAndFecha(Long usuarioId, LocalDate fecha);

}
