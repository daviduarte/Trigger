package com.camera.trigger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity // Para se tornar uma classe persistente, ou seja, que tenha uma tablea no BD
public class Telefone {
    @Id // Temos que ter uma primary key
    @GeneratedValue(strategy = GenerationType.AUTO)    // Estratégia automática do JPA. Gera primary keys em sequência automaticamanete: 1,2,3...
    private Long id; 

    private String numero;

    @JsonIgnore
    @org.hibernate.annotations.ForeignKey(name="usuario_id")                // Na tabela, quando tiver um telefone com código 1 (por exmeplo), qual usuário ele vai estar amarrado?
    @ManyToOne      // Define o tipo de relaçã. Muitos Telefone() para 1 Usuario()
    private Usuario usuario; // 1 usuário possui muitos telefones.

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
