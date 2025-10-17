package com.marcelodev.biblioteca.infrastructure.model;

public class Autor extends Pessoa {
    public Autor(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "autor";
    }
}