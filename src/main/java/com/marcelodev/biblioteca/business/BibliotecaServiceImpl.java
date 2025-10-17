package com.marcelodev.biblioteca.business;

import com.marcelodev.biblioteca.business.interfaces.BibliotecaServiceI;
import com.marcelodev.biblioteca.infrastructure.model.Emprestimo;
import com.marcelodev.biblioteca.infrastructure.model.Livro;
import com.marcelodev.biblioteca.infrastructure.model.Usuario;
import com.marcelodev.biblioteca.repository.BibliotecaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaServiceImpl implements BibliotecaServiceI {

    private final BibliotecaRepository repository;

    public BibliotecaServiceImpl(BibliotecaRepository repository) {
        this.repository = repository; // injeção de dependência
    }

    @Override
    public void cadastrarLivro(Livro livro) {
        repository.salvarLivro(livro);
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        repository.salvarUsuario(usuario);
    }

    @Override
    public boolean emprestarLivro(String titulo, String usuarioId) {
        Livro livro = repository.listarLivros().stream()
                .filter(l -> l.getTitulo().equals(titulo) && l.isDisponivel())
                .findFirst().orElse(null);

        Usuario usuario = repository.listarUsuarios().stream()
                .filter(u -> u.getId().equals(usuarioId))
                .findFirst().orElse(null);

        if (livro != null && usuario != null) {
            livro.setDisponivel(false);
            repository.listarEmprestimos().add(new Emprestimo(usuario, livro));
            return true;
        }
        return false;
    }

    @Override
    public boolean devolverLivro(String titulo, String usuarioId) {
        Emprestimo e = repository.listarEmprestimos().stream()
                .filter(emp -> emp.getLivro().getTitulo().equals(titulo) &&
                        emp.getUsuario().getId().equals(usuarioId))
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
