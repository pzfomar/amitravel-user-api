package com.amitravel.producto;

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
@RequestMapping("{lang}/producto")
public class ProductoRestController {
    @Autowired
    private ProductoService productoService;

    @GetMapping(path = "{id}")
    public ResponseEntity<Producto> obtener(@PathVariable("lang") String lang, @PathVariable("id") Long id)
            throws Exception {
        return this.productoService.obtener(lang, id);
    }

    @GetMapping(path = "negocio/{negocioId}")
    public ResponseEntity<List<Producto>> negocio(@PathVariable("lang") String lang,
            @PathVariable("negocioId") Long negocioId)
            throws Exception {
        return this.productoService.negocio(lang, negocioId);
    }
}
