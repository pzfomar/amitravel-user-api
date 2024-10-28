package com.amitravel.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("{lang}/usuario")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "")
    public ResponseEntity<Usuario> crear(@PathVariable("lang") String lang, @RequestBody Usuario request)
            throws Exception {
        return this.usuarioService.crear(lang, request);
    }

    @PostMapping(path = "autho")
    public ResponseEntity<Usuario> autho(@PathVariable("lang") String lang, @RequestBody Usuario request)
            throws Exception {
        return this.usuarioService.autho(lang, request);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable("lang") String lang, @PathVariable("id") Long id)
            throws Exception {
        return this.usuarioService.obtener(lang, id);
    }

    @GetMapping(path = "recupera/{apodo}")
    public ResponseEntity<Usuario> recupera(@PathVariable("lang") String lang, @PathVariable("apodo") String apodo)
            throws Exception {
        return this.usuarioService.recupera(lang, apodo);
    }
}
