package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Tipo;
import org.example.ativooperante.db.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public List<Tipo> findAll() {
        return tipoRepository.findAll();
    }

    public Tipo findById(Long id) {
        return tipoRepository.findById(id).orElse(null);
    }

    public Tipo save(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public void deleteById(Long id) {
        tipoRepository.deleteById(id);
    }

    public Tipo update(Tipo tipo) {
        if (tipo != null && tipo.getId() != null && tipoRepository.existsById(tipo.getId())) {
            return tipoRepository.save(tipo);
        }
        return null;
    }
}
