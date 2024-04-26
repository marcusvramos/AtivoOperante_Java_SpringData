package org.example.ativooperante.restcontrollers;

import org.example.ativooperante.db.entities.Denuncia;
import org.example.ativooperante.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/denuncia")
public class DenunciaController {

    @Autowired
    private DenunciaService service;

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllDenuncias() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> getDenunciaById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addDenuncia(@RequestBody Denuncia denuncia) {
        Denuncia saved = service.save(denuncia);
        if (saved == null)
            return ResponseEntity.badRequest().body("Erro ao inserir denúncia");
        else
            return ResponseEntity.ok("Denúncia inserida com sucesso");
    }
}
