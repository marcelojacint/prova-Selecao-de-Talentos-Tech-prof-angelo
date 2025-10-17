package com.marcelodev.biblioteca.repository.interfaces;

import com.marcelodev.biblioteca.infrastructure.model.Autor;
import com.marcelodev.biblioteca.infrastructure.model.Emprestimo;
import com.marcelodev.biblioteca.infrastructure.model.Livro;
import com.marcelodev.biblioteca.infrastructure.model.Usuario;

import java.util.List;

public interface BibliotecaRepository {
    void salvarLivro(Livro livro);

    void salvarUsuario(Usuario usuario);

    void salvarAutor(Autor autor);

    List<Livro> listarLivros();

    List<Usuario> listarUsuarios();

    List<Autor> listarAutores();

    List<Emprestimo> listarEmprestimos();
}
