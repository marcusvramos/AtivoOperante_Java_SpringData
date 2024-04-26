package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Denuncia;
import org.example.ativooperante.db.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    public List <Denuncia> getAll() {
        return repository.findAll();
    }

    public Denuncia getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Denuncia save(Denuncia denuncia) {
        return repository.save(denuncia);
    }
}