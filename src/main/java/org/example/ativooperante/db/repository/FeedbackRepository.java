package org.example.ativooperante.db.repository;

import org.example.ativooperante.db.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query(value="SELECT * FROM feedback WHERE den_id = :id", nativeQuery = true)
    List<Feedback> findByDenunciaId(Long id);
}
