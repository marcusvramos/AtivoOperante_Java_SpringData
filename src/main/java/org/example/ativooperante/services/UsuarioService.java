package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Usuario;
import org.example.ativooperante.db.repository.UsuarioRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Long id, Map<String, Object> updateFields) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));

        BeanWrapper beanWrapper = new BeanWrapperImpl(usuario);
        updateFields.forEach((propertyName, propertyValue) -> {
            if (beanWrapper.isWritableProperty(propertyName) && !propertyName.equals("id")) {
                beanWrapper.setPropertyValue(propertyName, propertyValue);
            }
        });

        return usuarioRepository.save(usuario);
    }
}
