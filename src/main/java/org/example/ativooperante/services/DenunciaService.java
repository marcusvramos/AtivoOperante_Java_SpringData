package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Denuncia;
import org.example.ativooperante.db.repository.DenunciaRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    public List<Denuncia> getAllDenuncias() {
        return repository.findAll();
    }

    public Denuncia getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Denuncia save(Denuncia denuncia) {
        return repository.save(denuncia);
    }

    public Denuncia update(Long id, Map<String, Object> updateFields) {
        Denuncia denuncia = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Denuncia not found"));

        BeanWrapper beanWrapper = new BeanWrapperImpl(denuncia);
        updateFields.forEach((propertyName, propertyValue) -> {
            if (beanWrapper.isWritableProperty(propertyName) && !propertyName.equals("id")) {
                beanWrapper.setPropertyValue(propertyName, propertyValue);
            }
        });

        return repository.save(denuncia);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}