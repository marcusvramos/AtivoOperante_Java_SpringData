package org.example.ativooperante.db.repository;

import org.example.ativooperante.db.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> { }
