package com.marcelodev.biblioteca.repository;

import com.marcelodev.biblioteca.infrastructure.model.Emprestimo;
import com.marcelodev.biblioteca.infrastructure.model.Livro;
import com.marcelodev.biblioteca.infrastructure.model.Usuario;
import com.marcelodev.biblioteca.repository.interfaces.BibliotecaRepository;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepositoryMemoria implements BibliotecaRepository {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public void salvarLivro(Livro livro) {
        livros.add(livro);
    }

    @Override
    public void salvarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public List<Livro> listarLivros() {
        return livros;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    @Override
    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }
}
