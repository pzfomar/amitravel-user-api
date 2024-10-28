package com.amitravel.agenda;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("{lang}/agenda")
public class AgendaRestController {
    @Autowired
    private AgendaService agendaService;

    @PostMapping(path = "")
    public ResponseEntity<Agenda> crear(@PathVariable("lang") String lang,
            @RequestBody Agenda request) throws Exception {
        return this.agendaService.crear(request);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Agenda> actualizar(@PathVariable("lang") String lang,
            @PathVariable("id") Long id, @RequestBody Agenda request) throws Exception {
        return this.agendaService.actualizar(lang, id, request);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Agenda> eliminar(@PathVariable("lang") String lang, @PathVariable("id") Long id)
            throws Exception {
        return this.agendaService.eliminar(lang, id);
    }

    @GetMapping(path = "usuario/{usuarioId}/fecha/{fecha}")
    public ResponseEntity<List<Agenda>> obtenerPorUsuario(@PathVariable("lang") String lang,
            @PathVariable("usuarioId") Long usuarioId, @PathVariable("fecha") String fecha) throws Exception {
        return this.agendaService.obtenerPorUsuario(lang, usuarioId, LocalDate.parse(fecha));
    }
}
