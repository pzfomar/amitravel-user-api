package com.amitravel.contenido;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amitravel.contenido.dto.ContenidoCercanoDto;
import com.amitravel.evento.Evento;
import com.amitravel.evento.EventoRepository;
import com.amitravel.negocio.Negocio;
import com.amitravel.negocio.NegocioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContenidoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private NegocioRepository negocioRepository;

    public ResponseEntity<List<ContenidoCercanoDto>> cercano(String lang, Double longitud, Double latitud) {
        log.info("ContenidoService::cercano::lang:{}:longitud:{}:latitud:{}", lang, longitud, latitud);
        List<Evento> eventos = this.eventoRepository.findAll();
        Collections.shuffle(eventos, new Random());
        List<ContenidoCercanoDto> response = eventos.stream()
                .map(evento -> {
                    Optional<Negocio> negocio = this.negocioRepository.findById(evento.getNegocioId());
                    return ContenidoCercanoDto
                            .builder()
                            .id(evento.getId())
                            .logo(negocio.isPresent() ? negocio.get().getImagen() : "")
                            .nombre(evento.getNombre())
                            .descripcion(evento.getDescripcion())
                            .imagen(evento.getImagen())
                            .build();
                })
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
