package com.amitravel.busqueda;

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
public class BusquedaService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BusquedaRepository busquedaRepository;

    public ResponseEntity<Busqueda> crear(Busqueda request) throws Exception {
        log.info("BusquedaService::crear::lang:{}:request:{}", request);

        Optional<Usuario> usuario = this.usuarioRepository.findById(request.getUsuarioId());
        if (usuario.isEmpty()) {
            throw new Exception("No existe usuario");
        }

        request.setEstatus(true);
        Busqueda response = this.busquedaRepository.save(request);
        log.info("BusquedaService::crear::save::nuevoBusqueda:{}", "ok");
        log.info("BusquedaService::crear::response::{}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<List<Busqueda>> obtener(String lang) {
        log.info("BusquedaService::obtener::lang:{}:pagina:{}:tamanio:{}", lang);

        List<Busqueda> response = this.busquedaRepository.findTop10ByOrderByVisitadaDesc();
        log.info("UsuarioService::obtener::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
