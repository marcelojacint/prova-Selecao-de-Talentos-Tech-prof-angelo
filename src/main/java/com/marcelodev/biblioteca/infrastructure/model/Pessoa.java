package com.marcelodev.biblioteca.infrastructure.model;

public abstract class Pessoa {
    private static long contador = 0;
    protected Long id;
    protected String nome;

    public Pessoa(String nome) {
        contador++;
        this.id = contador;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public abstract String getTipo();
}