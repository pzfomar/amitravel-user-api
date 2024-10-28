package com.amitravel.promocion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin("*")
@RestController
@RequestMapping("{lang}/promocion")
public class PromocionRestController {
    @Autowired
    private PromocionService promocionService;

    @GetMapping(path = "{id}")
    public ResponseEntity<Promocion> obtener(@PathVariable("lang") String lang, @PathVariable("id") Long id)
            throws Exception {
        return this.promocionService.obtener(lang, id);
    }

    @GetMapping(path = "negocio/{negocioId}")
    public ResponseEntity<List<Promocion>> negocio(@PathVariable("lang") String lang,
            @PathVariable("negocioId") Long negocioId)
            throws Exception {
        return this.promocionService.negocio(lang, negocioId);
    }
}
