package com.amitravel.negocio;

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
@RequestMapping("{lang}/negocio")
public class NegocioRestController {
    @Autowired
    private NegocioService negocioService;

    @GetMapping(path = "todos")
    public ResponseEntity<List<Negocio>> todos(@PathVariable("lang") String lang) throws Exception {
        return this.negocioService.todos(lang);
    }

    @GetMapping(path = "cercanos/{longitud}/{latitud}")
    public ResponseEntity<List<Negocio>> cercanos(@PathVariable("lang") String lang,
            @PathVariable("longitud") Double longitud, @PathVariable("latitud") Double latitud) throws Exception {
        return this.negocioService.cercanos(lang, longitud, latitud);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Negocio> obtener(@PathVariable("lang") String lang, @PathVariable("id") Long id)
            throws Exception {
        return this.negocioService.obtener(lang, id);
    }
}
