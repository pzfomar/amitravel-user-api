package com.amitravel.promocion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    public ResponseEntity<Promocion> obtener(String lang, Long id) throws Exception {
        log.info("PromocionService::obtener::lang:{}:id:{}", lang, id);

        Optional<Promocion> promocion = this.promocionRepository.findById(id);
        if (promocion.isEmpty()) {
            throw new Exception("No existe la promocion");
        }

        Promocion response = promocion.get();
        log.info("PromocionService::obtener::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<List<Promocion>> negocio(String lang, Long negocioId) {
        log.info("PromocionService::negocio::lang:{}:negocioId:{}", lang, negocioId);

        List<Promocion> response = this.promocionRepository.findAllByNegocioId(negocioId);
        log.info("PromocionService::negocio::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
