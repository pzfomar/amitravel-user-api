package com.amitravel.aficion;

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
public class AficionService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AficionRepository aficionRepository;

    public ResponseEntity<Aficion> crear(String lang, Aficion request) throws Exception {
        log.info("AficionService::crear::lang:{}:request:{}", lang, request);

        Optional<Usuario> usuario = this.usuarioRepository.findById(request.getUsuarioId());
        if (usuario.isEmpty()) {
            throw new Exception("No existe usuario");
        }

        request.setEstatus(true);
        Aficion response = this.aficionRepository.save(request);
        log.info("AficionService::crear::save::nuevoProducto:{}", "ok");
        log.info("AficionService::crear::response:{}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<List<Aficion>> obtenerPorUsuario(String lang, Long usuarioId) {
        log.info("AficionService::obtenerPorUsuario::lang:{}:usuarioId:{}", lang, usuarioId);

        List<Aficion> response = this.aficionRepository.findAllByUsuarioId(usuarioId);
        log.info("AficionService::obtenerPorUsuario::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
