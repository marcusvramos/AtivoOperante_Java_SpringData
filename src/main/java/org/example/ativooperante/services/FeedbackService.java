package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Feedback;
import org.example.ativooperante.db.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }

    public Feedback getById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
