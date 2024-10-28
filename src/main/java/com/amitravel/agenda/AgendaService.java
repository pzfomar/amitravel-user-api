package com.amitravel.agenda;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.amitravel.usuario.Usuario;
import com.amitravel.usuario.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Agenda> crear(Agenda request) throws Exception {
        log.info("AgendaService::crear::lang:{}:request:{}", request);

        Optional<Usuario> usuario = this.usuarioRepository.findById(request.getUsuarioId());
        if (usuario.isEmpty()) {
            throw new Exception("No existe usuario");
        }

        request.setEstatus(true);
        Agenda response = this.agendaRepository.save(request);
        log.info("AgendaService::crear::save::nuevoAgenda:{}", "ok");
        log.info("AgendaService::crear::response:{}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Agenda> actualizar(String lang, Long id, Agenda request) throws Exception {
        log.info("AgendaService::actualizar::lang:{}:id:{}:request:{}", lang, id, request);

        Optional<Agenda> agenda = this.agendaRepository.findById(id);
        if (agenda.isEmpty()) {
            throw new Exception("No existe la agenda");
        }

        agenda.get().setNombre(request.getNombre());
        agenda.get().setDescripcion(request.getDescripcion());
        agenda.get().setFecha(request.getFecha());
        agenda.get().setHora(request.getHora());
        Agenda response = this.agendaRepository.save(agenda.get());
        log.info("AgendaService::actualizar::save::Agenda:{}", "ok");
        log.info("AgendaService::actualizar::response:{}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Agenda> eliminar(String lang, Long id) throws Exception {
        log.info("AgendaService::eliminar::lang:{}:id:{}", lang, id);

        Optional<Agenda> agenda = this.agendaRepository.findById(id);
        if (agenda.isEmpty()) {
            throw new Exception("No existe la agenda");
        }
        this.agendaRepository.delete(agenda.get());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(agenda.get());
    }

    public ResponseEntity<List<Agenda>> obtenerPorUsuario(String lang, Long usuarioId, LocalDate fecha) {
        log.info("AgendaService::obtenerPorUsuario::lang:{}:usuarioId:{}", lang, usuarioId);

        List<Agenda> response = this.agendaRepository.findAllByUsuarioIdAndFecha(usuarioId, fecha);
        log.info("UsuarioService::obtenerPorUsuario::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
