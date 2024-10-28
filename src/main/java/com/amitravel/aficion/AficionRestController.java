package com.amitravel.aficion;

import java.util.List;

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
@RequestMapping("{lang}/aficion")
public class AficionRestController {

    @Autowired
    private AficionService aficionService;

    @PostMapping(path = "")
    public ResponseEntity<Aficion> crear(@PathVariable("lang") String lang, @RequestBody Aficion request)
            throws Exception {
        return this.aficionService.crear(lang, request);
    }

    @GetMapping(path = "usuario/{usuarioId}")
    public ResponseEntity<List<Aficion>> obtenerPorUsuario(@PathVariable("lang") String lang,
            @PathVariable("usuarioId") Long usuarioId) throws Exception {
        return this.aficionService.obtenerPorUsuario(lang, usuarioId);
    }
}
