package org.example.ativooperante.restcontrollers;

import org.example.ativooperante.db.entities.Tipo;
import org.example.ativooperante.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipo")
@CrossOrigin("*")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping("/all")
    public ResponseEntity<List<Tipo>> getAllTipos() {
        return ResponseEntity.ok(tipoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> getTipoById(@PathVariable Long id) {
        Tipo tipo = tipoService.findById(id);
        return tipo != null ? ResponseEntity.ok(tipo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Tipo> createTipo(@RequestBody Tipo tipo) {
        Tipo savedTipo = tipoService.save(tipo);
        URI location = URI.create("/api/tipo/" + savedTipo.getId());

        return ResponseEntity.created(location).body(savedTipo);
    }

    @PutMapping
    public ResponseEntity<Tipo> updateTipo(@RequestBody Tipo tipo) {
        Tipo updatedTipo = tipoService.update(tipo);
        return updatedTipo != null ? ResponseEntity.ok(updatedTipo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Long id) {
        tipoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
