package com.marcelodev.biblioteca.controller;

import com.marcelodev.biblioteca.business.interfaces.BibliotecaServiceI;
import com.marcelodev.biblioteca.infrastructure.enums.GeneroLivroEnum;
import com.marcelodev.biblioteca.infrastructure.model.Autor;
import com.marcelodev.biblioteca.infrastructure.model.Livro;
import com.marcelodev.biblioteca.infrastructure.model.Usuario;

import java.util.List;

public class BibliotecaController {
    private final BibliotecaServiceI service;

    public BibliotecaController(BibliotecaServiceI service) {
        this.service = service;
    }

    public void cadastrarUsuario(String nome) {
        Usuario usuario = new Usuario(nome);
        service.cadastrarPessoa(usuario);
    }

    public void cadastrarAutor(String nome) {
        Autor autor = new Autor(nome);
        service.cadastrarPessoa(autor);
    }

    public void cadastrarLivro(String titulo, List<Autor> autores, GeneroLivroEnum genero) {
        Livro livro = new Livro(titulo, autores, genero);
        service.cadastrarLivro(livro);
    }

    public void mostrarLivrosDisponiveis() {
        List<Livro> livros = service.listarLivrosDisponiveis();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
        } else {
            livros.forEach(l -> {
                System.out.print("Título: " + l.getTitulo() + " | Gênero: " + l.getGenero() + " | Autores: ");
                l.getAutores().forEach(a -> System.out.print(a.getNome() + " "));
                System.out.println();
            });
        }
    }
}
