package org.example.ativooperante.services;

import org.example.ativooperante.db.entities.Orgao;
import org.example.ativooperante.db.repository.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository orgaoRepository;

    public List<Orgao> findAll() {
        return orgaoRepository.findAll();
    }

    public Orgao findById(Long id) {
        return orgaoRepository.findById(id).orElse(null);
    }

    public Orgao save(Orgao orgao) {
        return orgaoRepository.save(orgao);
    }

    public void deleteById(Long id) {
        orgaoRepository.deleteById(id);
    }

    public Orgao update(Orgao orgao) {
        if (orgao != null && orgao.getId() != null && orgaoRepository.existsById(orgao.getId())) {
            return orgaoRepository.save(orgao);
        }
        return null;
    }
}
