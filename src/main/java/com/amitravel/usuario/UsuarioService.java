package com.amitravel.usuario;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.amitravel.persona.Persona;
import com.amitravel.persona.PersonaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String username;

    public ResponseEntity<Usuario> crear(String lang, Usuario request) throws Exception {
        log.info("UsuarioService::crear::lang:{}:request:{}", lang, request);

        Optional<Usuario> usuario = this.usuarioRepository.findByApodo(request.getApodo());
        if (usuario.isPresent()) {
            throw new Exception("El apodo ya esta ocupado");
        }

        request.setRol(TipoRol.USUARIO);
        request.setEstatus(true);
        Usuario response = this.usuarioRepository.save(request);
        log.info("UsuarioService::crear::save::usuario:{}", "ok");
        log.info("UsuarioService::crear::response:{}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Usuario> autho(String lang, Usuario request) throws Exception {
        log.info("UsuarioService::autho::lang:{}:request:{}", lang, request);

        Optional<Usuario> usuario = this.usuarioRepository.findByApodoAndContrasenia(request.getApodo(),
                request.getContrasenia());
        if (usuario.isEmpty()) {
            throw new Exception("Credenciales erroneas");
        }

        usuario.get().setContrasenia("");
        Usuario response = usuario.get();
        log.info("UsuarioService::autho::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<Usuario> obtener(String lang, Long id) throws Exception {
        log.info("UsuarioService::obtener::lang:{}:usuarioId:{}", lang, id);

        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new Exception("No existe el usuario");
        }

        usuario.get().setContrasenia("");
        Usuario response = usuario.get();
        log.info("UsuarioService::obtener::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<Usuario> recupera(String lang, String apodo) throws Exception {
        log.info("UsuarioService::recupera::lang:{}:apodo:{}", lang, apodo);

        Optional<Usuario> usuario = this.usuarioRepository.findByApodo(apodo);
        if (usuario.isEmpty()) {
            throw new Exception("No existe el usuario");
        }

        Optional<Persona> persona = personaRepository.findByUsuarioId(usuario.get().getId());
        if (persona.isEmpty()) {
            throw new Exception("No existe la persona");
        }

        UUID uuid = UUID.randomUUID();
        String contrasenia = uuid.toString().replaceAll("-", "");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.username);
        message.setTo(persona.get().getCorreo());
        message.setSubject("Recuperar cuenta");
        message.setText("Se genero una nueva contraseña, favor de cambiarla: " + contrasenia);
        emailSender.send(message);

        usuario.get().setContrasenia(contrasenia);
        this.usuarioRepository.save(usuario.get());
        log.info("UsuarioService::recupera::save::usuario:{}", "ok");

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
