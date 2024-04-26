package org.example.ativooperante.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "orgaos")
public class Orgao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Integer id;

    @Column(name = "org_nome", length = 30)
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
