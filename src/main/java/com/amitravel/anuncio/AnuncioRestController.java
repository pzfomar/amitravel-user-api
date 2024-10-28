package com.amitravel.anuncio;

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
@RequestMapping("{lang}/anuncio")
public class AnuncioRestController {
    @Autowired
    private AnuncioService anuncioService;

    @GetMapping(path = "todos")
    public ResponseEntity<List<Anuncio>> todos(@PathVariable("lang") String lang) throws Exception {
        return this.anuncioService.todos(lang);
    }

    @GetMapping(path = "negocio/{negocioId}")
    public ResponseEntity<List<Anuncio>> negocio(@PathVariable("lang") String lang,
            @PathVariable("negocioId") Long negocioId)
            throws Exception {
        return this.anuncioService.negocio(lang, negocioId);
    }
}
