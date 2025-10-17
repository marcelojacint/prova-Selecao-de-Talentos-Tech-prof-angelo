package com.marcelodev.biblioteca.business.interfaces;

import com.marcelodev.biblioteca.infrastructure.model.Livro;
import com.marcelodev.biblioteca.infrastructure.model.Usuario;

import java.util.List;

public interface BibliotecaServiceI {
    void cadastrarLivro(Livro livro);
    void cadastrarUsuario(Usuario usuario);
    boolean emprestarLivro(String titulo, String usuarioId);
    boolean devolverLivro(String titulo, String usuarioId);
    List<Livro> listarLivrosDisponiveis();
}
