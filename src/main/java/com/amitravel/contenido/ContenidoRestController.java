package com.amitravel.contenido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitravel.contenido.dto.ContenidoCercanoDto;

@CrossOrigin("*")
@RestController
@RequestMapping("{lang}/contenido")
public class ContenidoRestController {
    @Autowired
    private ContenidoService contenidoService;

    @GetMapping(path = "cercano/{longitud}/{latitud}")
    public ResponseEntity<List<ContenidoCercanoDto>> cercano(@PathVariable("lang") String lang,
            @PathVariable("longitud") Double longitud, @PathVariable("latitud") Double latitud) throws Exception {
        return this.contenidoService.cercano(lang, longitud, latitud);
    }
}
