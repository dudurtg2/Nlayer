package com.lanchenlayer;

import com.lanchenlayer.applications.ProdutoApplication;
import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.facade.ProdutoFacade;
import com.lanchenlayer.repositories.ProdutoRepository;
import com.lanchenlayer.services.ProdutoService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Console {
    private static ProdutoRepository produtoRepository;
    private static ProdutoService produtoService;
    private static ProdutoApplication produtoApplication;
    private static ProdutoFacade produtoFacade;
    private static Scanner scanner;

    public static void resolverDependencias() {
        produtoRepository = new ProdutoRepository();
        produtoService = new ProdutoService();
        produtoApplication = new ProdutoApplication(produtoRepository, produtoService);
        produtoFacade = new ProdutoFacade(produtoApplication);
        scanner = new Scanner(System.in);
    }

    public static void inicializarProdutos() {
        produtoFacade.adicionar(new Produto(61, "Brasilia", "C:\\Users\\aluno\\imagens\\Brasilia.jpg"));
        produtoFacade.adicionar(new Produto(71, "Salvador", "C:\\Users\\aluno\\imagens\\Salvador.jpg"));
        produtoFacade.adicionar(new Produto(11, "São Paulo", "C:\\Users\\aluno\\imagens\\SaoPaulo.jpg"));
        produtoFacade.adicionar(new Produto(21, "Rio de Janeiro", "C:\\Users\\aluno\\imagens\\RioDeJaneiro.jpg"));
        produtoFacade.adicionar(new Produto(32, "Juiz de Fora", "C:\\Users\\aluno\\imagens\\JuizDeFora.jpg"));
        produtoFacade.adicionar(new Produto(19, "Campinas", "C:\\Users\\aluno\\imagens\\Campinas.jpg"));
        produtoFacade.adicionar(new Produto(27, "Vitoria", "C:\\Users\\aluno\\imagens\\Vitoria.jpg"));
        produtoFacade.adicionar(new Produto(31, "Belo Horizonte", "C:\\Users\\aluno\\imagens\\BeloHorizonte.jpg"));
        

    }

    public static void listarProdutos() {
        System.out.println("Id    |    Descrição   |   Valor");

        ArrayList<Produto> produtos = produtoFacade.buscarTodos();

        produtos.forEach(c -> {
            System.out.println(c.getDDD() + "   |     " + c.getEstado());
        });
    }

    public static void cadastrarProduto() {
        System.out.println("Informe o DDD do estado: ");
        int id = scanner.nextInt();

        System.out.println("Informe o nome do estado: ");
        String estado = scanner.next();

        System.out.println("Informe o caminho da imagem da bandeira: ");
        String imagem = scanner.next();

        Produto produto = new Produto(id, estado, imagem);
        produtoFacade.adicionar(produto);
    }

    public static void exibirMenu() {
        System.out.println("\n1 - Novo estado");
        System.out.println("2 - Atualizar estado");
        System.out.println("3 - Listar estados");
        System.out.println("4 - Buscar estado pelo DDD");
        System.out.println("5 - Remover estado");
        System.out.println("6 - Sair");
    }

    public static int solicitarInputUsuario() {
        System.out.println("Informe a opção do menu desejado: ");
        return scanner.nextInt();
    }

    public static void buscarPorDDD() {
        System.out.println("Informe o DDD desejada: ");
        int id = scanner.nextInt();


        System.out.println("Estado: " + produtoFacade.buscarPorDDD(id).getEstado());
    }

    private static void atualizarProduto() {
        System.out.println("Informe o DDD do produto que deseja atualizar: ");
        int DDD = scanner.nextInt();

        System.out.println("Informe a novo nome do estado: ");
        String descricao = scanner.next();

        System.out.println("Informe o novo caminho da imagem do produto: ");
        String imagem = scanner.next();

        Produto produto = new Produto(DDD, descricao,  imagem);
        produtoFacade.atualizarProduto(DDD, produto);
    }

    public static void removerProduto() {
        System.out.println("Informe o DDD do estado que deseja remover: ");
        int id = scanner.nextInt();

        produtoFacade.remover(id);
    }

    public static void rodar() {
        int opcaoMenu = 0;

        do {
            exibirMenu();
            opcaoMenu = solicitarInputUsuario();
            switch (opcaoMenu) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    buscarPorDDD();
                    break;
                case 5:
                    removerProduto();
                    break;
            }

        } while (opcaoMenu != 6);
    }

    public static void main(String[] args) {
        resolverDependencias();
        inicializarProdutos();
        rodar();
    }
}
