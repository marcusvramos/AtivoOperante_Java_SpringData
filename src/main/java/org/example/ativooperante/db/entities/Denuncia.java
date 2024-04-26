package org.example.ativooperante.db.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "denuncia")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "den_id")
    private Integer id;

    @Column(name = "den_titulo", length = 40)
    private String titulo;

    @Column(name = "den_texto", columnDefinition = "TEXT")
    private String texto;

    @Column(name = "den_urgencia")
    private Integer urgencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Orgao orgao;

    @Column(name = "den_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_id")
    private Tipo tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id")
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(Integer urgencia) {
        this.urgencia = urgencia;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
