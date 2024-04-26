package org.example.ativooperante.restcontrollers;

import org.example.ativooperante.db.entities.Feedback;
import org.example.ativooperante.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping("/add")
    public ResponseEntity<Object> addFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = service.save(feedback);
        if (savedFeedback == null)
            return ResponseEntity.badRequest().body("Erro ao inserir feedback");
        else
            return ResponseEntity.ok("Feedback inserido com sucesso");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> getFeedbackById(@PathVariable Integer id) {
        Feedback feedback = service.getById(id);
        if (feedback == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(feedback);
    }
}
