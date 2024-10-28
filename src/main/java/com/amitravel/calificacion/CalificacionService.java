package com.amitravel.calificacion;

import java.util.List;
import java.util.Optional;

import com.amitravel.evento.Evento;
import com.amitravel.evento.EventoRepository;
import com.amitravel.usuario.Usuario;
import com.amitravel.usuario.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public ResponseEntity<Calificacion> crear(Calificacion request) throws Exception {
        log.info("CalificacionService::crear::lang:{}:request:{}", request);

        Optional<Evento> evento = this.eventoRepository.findById(request.getEventoId());
        if (evento.isEmpty()) {
            throw new Exception("No existe evento");
        }
        Optional<Usuario> usuario = this.usuarioRepository.findById(request.getUsuarioId());
        if (usuario.isEmpty()) {
            throw new Exception("No existe usuario");
        }

        request.setEstatus(true);
        Calificacion response = this.calificacionRepository.save(request);
        log.info("CalificacionService::crear::save::nuevoCalificacion:{}", "ok");
        log.info("CalificacionService::crear::response:{}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<List<Calificacion>> obtenerPorEvento(String lang, Long eventoId) {
        log.info("CalificacionService::obtenerPorEvento::lang:{}:eventoId:{}", lang, eventoId);

        List<Calificacion> response = this.calificacionRepository.findAllByEventoId(eventoId);
        log.info("CalificacionService::obtenerPorEvento::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<Integer> obtenerPromedioPorEvento(String lang, Long eventoId) {
        log.info("CalificacionService::obtenerPromedioPorEvento::lang:{}:eventoId:{}", lang, eventoId);

        List<Calificacion> calificaciones = this.calificacionRepository.findAllByEventoId(eventoId);

        Integer total = 0;
        if (!calificaciones.isEmpty()) {
            total = Math.round(calificaciones.parallelStream().mapToInt(Calificacion::getEvaluacion).sum()
                    / calificaciones.size());
        }
        log.info("CalificacionService::obtenerPromedioPorEvento::total:{}", total);

        return ResponseEntity.status(HttpStatus.OK).body(total);
    }
}
