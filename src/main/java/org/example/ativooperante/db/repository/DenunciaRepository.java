package org.example.ativooperante.db.repository;

import org.example.ativooperante.db.entities.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
    @Query(value="SELECT * FROM denuncia WHERE usu_id = :id", nativeQuery = true)
    List<Denuncia> findByUserId(Long id);
}