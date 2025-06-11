package com.amitravel.anuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnuncioService {
        @Autowired
        private AnuncioRepository anuncioRepository;

        public ResponseEntity<List<Anuncio>> todos(String lang) {
                log.info("AnuncioService::todos::lang:{}", lang);

                List<Anuncio> response = this.anuncioRepository.findAll();
                log.info("AnuncioService::todos::response:{}", response);

                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        public ResponseEntity<List<Anuncio>> negocio(String lang, Long negocioId) {
                log.info("AnuncioService::negocio::lang:{}:negocioId:{}", lang, negocioId);

                List<Anuncio> response = this.anuncioRepository.findAllByNegocioId(negocioId);
                log.info("AnuncioService::negocio::response:{}", response);

                return ResponseEntity.status(HttpStatus.OK).body(response);
        }
}
