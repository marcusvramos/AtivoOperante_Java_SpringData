package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Usuario;
import org.example.ativooperante.db.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }
}