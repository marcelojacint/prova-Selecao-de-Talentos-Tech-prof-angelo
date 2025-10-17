package com.marcelodev.biblioteca.controller;

import com.marcelodev.biblioteca.business.interfaces.BibliotecaServiceI;
import com.marcelodev.biblioteca.infrastructure.enums.GeneroLivroEnum;
import com.marcelodev.biblioteca.infrastructure.model.Livro;

import java.util.List;

public class BibliotecaController {
    private final BibliotecaServiceI service;

    public BibliotecaController(BibliotecaServiceI service) {
        this.service = service;
    }

    public void cadastrarLivro(String titulo, List<String> autores, GeneroLivroEnum genero) {
        Livro livro = new Livro(titulo, autores, genero);
        service.cadastrarLivro(livro);
    }

    public void mostrarLivrosDisponiveis() {
        List<Livro> livros = service.listarLivrosDisponiveis();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
        } else {
            livros.forEach(l -> System.out.println("Título: " + l.getTitulo() + " | Gênero: " + l.getGenero()));
        }
    }
}
