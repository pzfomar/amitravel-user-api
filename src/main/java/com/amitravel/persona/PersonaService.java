package com.amitravel.persona;

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
public class PersonaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public ResponseEntity<Persona> crear(String lang, Persona request) throws Exception {
        log.info("PersonaService::crear::lang:{}:request:{}", lang, request);

        Optional<Usuario> usuario = this.usuarioRepository.findById(request.getUsuarioId());
        if (usuario.isEmpty()) {
            throw new Exception("No existe Usuario");
        }

        request.setEstatus(true);
        Persona response = this.personaRepository.save(request);
        log.info("PersonaService::crear::save::nuevoPersona:{}", "ok");
        log.info("PersonaService::crear::response:{}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Persona> obtenerPorUsuario(String lang, Long usuarioId) throws Exception {
        log.info("PersonaService::obtenerPorUsuario::lang:{}:usuarioId:{}", lang, usuarioId);

        Optional<Persona> persona = this.personaRepository.findByUsuarioId(usuarioId);
        if (persona.isEmpty()) {
            throw new Exception("No existe la persona");
        }

        Persona response = persona.get();
        log.info("PersonaService::obtenerPorUsuario::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
