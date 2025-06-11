package com.amitravel.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByApodoAndContrasenia(String apodo, String contrasenia);

    Optional<Usuario> findByApodo(String apodo);
}
