package com.marcelodev.biblioteca.application;

import com.marcelodev.biblioteca.business.BibliotecaServiceImpl;
import com.marcelodev.biblioteca.business.interfaces.BibliotecaServiceI;
import com.marcelodev.biblioteca.controller.BibliotecaController;
import com.marcelodev.biblioteca.infrastructure.enums.GeneroLivroEnum;
import com.marcelodev.biblioteca.infrastructure.model.Usuario;
import com.marcelodev.biblioteca.repository.BibliotecaRepositoryMemoria;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BibliotecaRepositoryMemoria bibliotecaRepositoryMemoria = new BibliotecaRepositoryMemoria();
        BibliotecaServiceI service = new BibliotecaServiceImpl(bibliotecaRepositoryMemoria);
        BibliotecaController controller = new BibliotecaController(service);


        controller.cadastrarLivro("Clean Code", List.of("Robert C. Martin"), GeneroLivroEnum.TECNICO);
        controller.cadastrarLivro("Harry Potter", List.of("J.K. Rowling"), GeneroLivroEnum.FICCAO);


        controller.mostrarLivrosDisponiveis();

    }
}