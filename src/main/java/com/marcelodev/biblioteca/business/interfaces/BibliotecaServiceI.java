package com.marcelodev.biblioteca.business.interfaces;

import com.marcelodev.biblioteca.infrastructure.model.Livro;
import com.marcelodev.biblioteca.infrastructure.model.Pessoa;
import com.marcelodev.biblioteca.infrastructure.model.Usuario;

import java.util.List;

public interface BibliotecaServiceI {
    void cadastrarLivro(Livro livro);

    void cadastrarPessoa(Pessoa pessoa);

    boolean emprestarLivro(String titulo, String nomeUsuario);

    boolean devolverLivro(String titulo, String nomeUsuario);

    List<Livro> listarLivrosDisponiveis();
}
