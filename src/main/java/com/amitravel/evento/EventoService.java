package com.amitravel.evento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public ResponseEntity<List<Evento>> todos(String lang) {
        log.info("EventoService::todos::lang:{}", lang);

        List<Evento> response = this.eventoRepository.findAll();
        log.info("EventoService::todos::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<List<Evento>> cercanos(String lang, Double longitud, Double latitud) {
        log.info("EventoService::cercanos::lang:{}:longitud:{}:latitud:{}", lang, longitud, latitud);

        List<Evento> response = this.eventoRepository.findAll();
        log.info("EventoService::cercanos::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<Evento> obtener(String lang, Long id) throws Exception {
        log.info("EventoService::obtener::lang:{}:id:{}", lang, id);

        Optional<Evento> evento = this.eventoRepository.findById(id);
        if (evento.isEmpty()) {
            throw new Exception("No existe el evento");
        }

        Evento response = evento.get();
        log.info("EventoService::obtener::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
