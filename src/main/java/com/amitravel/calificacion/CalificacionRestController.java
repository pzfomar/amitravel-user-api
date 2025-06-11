package com.amitravel.calificacion;

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
@RequestMapping("{lang}/calificacion")
public class CalificacionRestController {
    @Autowired
    private CalificacionService calificacionService;

    @PostMapping(path = "")
    public ResponseEntity<Calificacion> crear(@PathVariable("lang") String lang,
            @RequestBody Calificacion request) throws Exception {
        return this.calificacionService.crear(request);
    }

    @GetMapping(path = "evento/{eventoId}")
    public ResponseEntity<List<Calificacion>> obtenerPorEvento(@PathVariable("lang") String lang,
            @PathVariable("eventoId") Long eventoId) throws Exception {
        return this.calificacionService.obtenerPorEvento(lang, eventoId);
    }

    @GetMapping(path = "promedio/evento/{eventoId}")
    public ResponseEntity<Integer> obtenerPromedioPorEvento(@PathVariable("lang") String lang,
            @PathVariable("eventoId") Long eventoId) throws Exception {
        return this.calificacionService.obtenerPromedioPorEvento(lang, eventoId);
    }
}
