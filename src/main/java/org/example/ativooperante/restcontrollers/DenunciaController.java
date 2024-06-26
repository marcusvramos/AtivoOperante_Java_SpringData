package org.example.ativooperante.restcontrollers;

import org.example.ativooperante.db.entities.Denuncia;
import org.example.ativooperante.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/denuncia")
@CrossOrigin("*")
public class DenunciaController {

    @Autowired
    private DenunciaService service;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllDenuncias() {
        return ResponseEntity.ok(service.getAllDenuncias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDenunciaById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getDenunciasByUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdStr = authentication.getName();
        Long userId = Long.parseLong(userIdStr);

        List<Denuncia> denuncias = service.getByUserId(userId);
        return ResponseEntity.ok(denuncias);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addDenuncia(@RequestBody Denuncia denuncia) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdStr = authentication.getName();

        try {
            Long userId = Long.parseLong(userIdStr);
            Denuncia saved = service.save(denuncia, userId);
            if (saved == null) {
                return ResponseEntity.badRequest().body("Erro ao inserir denúncia");
            } else {
                URI location = URI.create("/api/denuncia/" + saved.getId());
                return ResponseEntity.created(location).body(saved);
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.status(500).body("Erro do servidor");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDenuncia(@PathVariable Long id, @RequestBody Map<String, Object> denuncia) {
        Denuncia updated = service.update(id, denuncia);
        if (updated == null)
            return ResponseEntity.badRequest().body("Erro ao atualizar denúncia");
        else
            return ResponseEntity.ok("Denúncia atualizada com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDenuncia(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Denúncia removida com sucesso");
    }
}
