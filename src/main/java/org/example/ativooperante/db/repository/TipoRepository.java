package org.example.ativooperante.db.repository;

import org.example.ativooperante.db.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
}