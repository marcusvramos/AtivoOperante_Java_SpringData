package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Denuncia;
import org.example.ativooperante.db.entities.Usuario;
import org.example.ativooperante.db.repository.DenunciaRepository;
import org.example.ativooperante.db.repository.UsuarioRepository;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Denuncia> getAllDenuncias() {
        return repository.findAll();
    }

    public Denuncia getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Denuncia> getByUserId(Long id) {
        return repository.findByUserId(id);
    }

    public Denuncia save(Denuncia denuncia, Long userId) {
        Usuario usuario = usuarioRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        denuncia.setUsuario(usuario);
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