package org.example.ativooperante.restcontrollers;

import jakarta.validation.Valid;
import org.example.ativooperante.db.entities.Orgao;
import org.example.ativooperante.services.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orgao")
@CrossOrigin("*")
public class OrgaoController {

    @Autowired
    private OrgaoService orgaoService;

    @GetMapping("/all")
    public ResponseEntity<List<Orgao>> getAllOrgaos() {
        return ResponseEntity.ok(orgaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orgao> getOrgaoById(@PathVariable Long id) {
        Orgao orgao = orgaoService.findById(id);
        return orgao != null ? ResponseEntity.ok(orgao) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Orgao> createOrgao(@Valid @RequestBody Orgao orgao) {
        Orgao savedOrgao = orgaoService.save(orgao);
        URI location = URI.create("/api/orgao/" + savedOrgao.getId());
        return ResponseEntity.created(location).body(savedOrgao);
    }

    @PutMapping
    public ResponseEntity<Orgao> updateOrgao(@RequestBody Orgao orgao) {
        Orgao updatedOrgao = orgaoService.update(orgao);
        return updatedOrgao != null ? ResponseEntity.ok(updatedOrgao) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrgao(@PathVariable Long id) {
        orgaoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
