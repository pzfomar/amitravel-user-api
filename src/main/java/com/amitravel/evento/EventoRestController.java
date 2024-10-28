package com.amitravel.evento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("{lang}/evento")
public class EventoRestController {
    @Autowired
    private EventoService eventoService;

    @GetMapping(path = "todos")
    public ResponseEntity<List<Evento>> todos(@PathVariable("lang") String lang) throws Exception {
        return this.eventoService.todos(lang);
    }

    @GetMapping(path = "cercanos/{longitud}/{latitud}")
    public ResponseEntity<List<Evento>> cercanos(@PathVariable("lang") String lang,
            @PathVariable("longitud") Double longitud, @PathVariable("latitud") Double latitud) throws Exception {
        return this.eventoService.cercanos(lang, longitud, latitud);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Evento> obtener(@PathVariable("lang") String lang, @PathVariable("id") Long id)
            throws Exception {
        return this.eventoService.obtener(lang, id);
    }
}
