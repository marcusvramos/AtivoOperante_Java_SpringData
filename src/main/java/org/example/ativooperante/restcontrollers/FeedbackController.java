package org.example.ativooperante.restcontrollers;

import org.example.ativooperante.db.entities.Feedback;
import org.example.ativooperante.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllFeedbacks() {
        return ResponseEntity.ok(service.getAllFeedbacks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFeedbackById(@PathVariable Long id) {
        Feedback feedback = service.getById(id);
        if (feedback == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(feedback);
    }

    @GetMapping("/denuncia/{id}")
    public ResponseEntity<Object> getFeedbacksByDenunciaId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getByDenunciaId(id));
    }

    @PostMapping
    public ResponseEntity<Object> addFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = service.save(feedback);
        if (savedFeedback == null)
            return ResponseEntity.badRequest().body("Erro ao inserir feedback");
        else
            return ResponseEntity.ok("Feedback inserido com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFeedback(@PathVariable Long id, @RequestBody Map<String, Object> feedback) {
        Feedback updatedFeedback = service.update(id, feedback);
        if (updatedFeedback == null)
            return ResponseEntity.badRequest().body("Erro ao atualizar feedback");
        else
            return ResponseEntity.ok("Feedback atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFeedback(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Feedback removido com sucesso");
    }
}
