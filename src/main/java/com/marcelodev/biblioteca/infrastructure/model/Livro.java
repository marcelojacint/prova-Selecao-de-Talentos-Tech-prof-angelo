package com.marcelodev.biblioteca.infrastructure.model;

import com.marcelodev.biblioteca.infrastructure.enums.GeneroLivroEnum;

import java.util.List;

public class Livro {
    private String titulo;
    private List<String> autores;
    private GeneroLivroEnum genero;
    private boolean disponivel = true;

    public Livro(String titulo, List<String> autores, GeneroLivroEnum genero) {
        this.titulo = titulo;
        this.autores = autores;
        this.genero = genero;
    }

    public String getTitulo() { return titulo; }
    public List<String> getAutores() { return autores; }
    public GeneroLivroEnum getGenero() { return genero; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
