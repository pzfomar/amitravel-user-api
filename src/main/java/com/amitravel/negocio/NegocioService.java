package com.amitravel.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NegocioService {
    @Autowired
    private NegocioRepository negocioRepository;

    public ResponseEntity<List<Negocio>> todos(String lang) {
        log.info("NegocioService::todos::lang:{}", lang);

        List<Negocio> response = this.negocioRepository.findAll();
        log.info("NegocioService::todos::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<List<Negocio>> cercanos(String lang, Double longitud, Double latitud) {
        log.info("NegocioService::cercanos::lang:{}:longitud:{}:latitud:{}", lang, longitud, latitud);

        List<Negocio> response = this.negocioRepository.findAll();
        log.info("NegocioService::cercanos::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<Negocio> obtener(String lang, Long id) throws Exception {
        log.info("NegocioService::todos::lang:{}:id:{}", lang, id);

        Optional<Negocio> negocio = this.negocioRepository.findById(id);
        if (negocio.isEmpty()) {
            throw new Exception("No existe el negocio");
        }

        Negocio response = negocio.get();
        log.info("NegocioService::todos::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
