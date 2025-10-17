package com.marcelodev.biblioteca.business;

import com.marcelodev.biblioteca.business.interfaces.BibliotecaServiceI;
import com.marcelodev.biblioteca.infrastructure.model.*;
import com.marcelodev.biblioteca.repository.interfaces.BibliotecaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaServiceImpl implements BibliotecaServiceI {

    private final BibliotecaRepository repository;

    public BibliotecaServiceImpl(BibliotecaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarLivro(Livro livro) {
        repository.salvarLivro(livro);
    }

    @Override
    public void cadastrarPessoa(Pessoa pessoa) {
        if (pessoa instanceof Usuario) {
            repository.salvarUsuario((Usuario) pessoa);
        } else if (pessoa instanceof Autor) {
            repository.salvarAutor((Autor) pessoa);
        }
    }

    @Override
    public boolean emprestarLivro(String titulo, String nomeUsuario) {
        Livro livro = repository.listarLivros().stream()
                .filter(Livro::isDisponivel)
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst().orElse(null);

        Pessoa pessoa = repository.listarUsuarios().stream()
                .filter(u -> u.getNome().equalsIgnoreCase(nomeUsuario))
                .findFirst().orElse(null);

        if (livro != null && pessoa != null) {
            livro.setDisponivel(false);
            repository.listarEmprestimos().add(new Emprestimo((Usuario) pessoa, livro));
            return true;
        }
        return false;
    }

    @Override
    public boolean devolverLivro(String titulo, String nomeUsuario) {
        Emprestimo e = repository.listarEmprestimos().stream()
                .filter(emp -> emp.getLivro().getTitulo().equalsIgnoreCase(titulo)
                        && emp.getUsuario().getNome().equalsIgnoreCase(nomeUsuario))
                .findFirst().orElse(null);

        if (e != null) {
            e.getLivro().setDisponivel(true);
            repository.listarEmprestimos().remove(e);
            return true;
        }
        return false;
    }

    @Override
    public List<Livro> listarLivrosDisponiveis() {
        return repository.listarLivros().stream()
                .filter(Livro::isDisponivel)
                .collect(Collectors.toList());
    }
}
