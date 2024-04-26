package org.example.ativooperante.db.repository;

import org.example.ativooperante.db.entities.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
}