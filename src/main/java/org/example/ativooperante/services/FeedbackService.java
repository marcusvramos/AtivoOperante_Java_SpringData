package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Feedback;
import org.example.ativooperante.db.repository.FeedbackRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    public List<Feedback> getAllFeedbacks() {
        return repository.findAll();
    }

    public Feedback getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }

    public Feedback update(Long id, Map<String, Object> updateFields) {
        Feedback feedback = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        BeanWrapper beanWrapper = new BeanWrapperImpl(feedback);
        updateFields.forEach((propertyName, propertyValue) -> {
            if (beanWrapper.isWritableProperty(propertyName) && !propertyName.equals("id")) {
                beanWrapper.setPropertyValue(propertyName, propertyValue);
            }
        });

        return repository.save(feedback);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
