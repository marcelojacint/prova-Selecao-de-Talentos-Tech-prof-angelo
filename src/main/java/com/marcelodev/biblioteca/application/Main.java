package com.marcelodev.biblioteca.application;

import com.marcelodev.biblioteca.business.BibliotecaServiceImpl;
import com.marcelodev.biblioteca.business.interfaces.BibliotecaServiceI;
import com.marcelodev.biblioteca.controller.BibliotecaController;
import com.marcelodev.biblioteca.infrastructure.enums.GeneroLivroEnum;
import com.marcelodev.biblioteca.infrastructure.model.Autor;
import com.marcelodev.biblioteca.infrastructure.model.Usuario;
import com.marcelodev.biblioteca.repository.BibliotecaRepositoryMemoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var repository = new BibliotecaRepositoryMemoria();
        BibliotecaServiceI service = new BibliotecaServiceImpl(repository);
        BibliotecaController controller = new BibliotecaController(service);

        System.out.println("=== Cadastro de Usuários ===");
        System.out.print("Quantos usuários deseja cadastrar? ");
        int qtdUsuarios = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < qtdUsuarios; i++) {
            System.out.print("Nome do usuário " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            controller.cadastrarUsuario(nome);
        }

        System.out.println("\n=== Cadastro de Autores ===");
        System.out.print("Quantos autores deseja cadastrar? ");
        int qtdAutores = Integer.parseInt(scanner.nextLine());
        List<Autor> todosAutores = new ArrayList<>();
        for (int i = 0; i < qtdAutores; i++) {
            System.out.print("Nome do autor " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            controller.cadastrarAutor(nome);
            todosAutores.add(new Autor(nome));
        }

        System.out.println("\n=== Cadastro de Livros ===");
        System.out.print("Quantos livros deseja cadastrar? ");
        int qtdLivros = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < qtdLivros; i++) {
            System.out.print("Título do livro " + (i + 1) + ": ");
            String titulo = scanner.nextLine();

            // Selecionar autores do livro
            List<Autor> autoresLivro = new ArrayList<>();
            System.out.println("Selecione os autores (digite números separados por espaço):");
            for (int j = 0; j < todosAutores.size(); j++) {
                System.out.println((j + 1) + " - " + todosAutores.get(j).getNome());
            }
            String[] escolhas = scanner.nextLine().split(" ");
            for (String e : escolhas) {
                int idx = Integer.parseInt(e) - 1;
                if (idx >= 0 && idx < todosAutores.size()) {
                    autoresLivro.add(todosAutores.get(idx));
                }
            }

            // Selecionar gênero
            System.out.println("Selecione o gênero do livro:");
            int k = 1;
            for (var g : GeneroLivroEnum.values()) {
                System.out.println(k + " - " + g);
                k++;
            }
            int escolhaGenero = Integer.parseInt(scanner.nextLine()) - 1;
            controller.cadastrarLivro(titulo, autoresLivro, GeneroLivroEnum.values()[escolhaGenero]);
        }

        System.out.println("\n=== Livros Disponíveis ===");
        controller.mostrarLivrosDisponiveis();

        scanner.close();

    }
}