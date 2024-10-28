package com.amitravel.persona;

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
@RequestMapping("{lang}/persona")
public class PersonaRestController {
    @Autowired
    private PersonaService personaService;

    @PostMapping(path = "")
    public ResponseEntity<Persona> crear(@PathVariable("lang") String lang, @RequestBody Persona request)
            throws Exception {
        return this.personaService.crear(lang, request);
    }

    @GetMapping(path = "usuario/{usuarioId}")
    public ResponseEntity<Persona> obtenerPorUsuario(@PathVariable("lang") String lang,
            @PathVariable("usuarioId") Long usuarioId) throws Exception {
        return this.personaService.obtenerPorUsuario(lang, usuarioId);
    }
}
