package com.marcelodev.biblioteca.infrastructure.model;

public class Usuario {
    private String id;
    private String nome;

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}
