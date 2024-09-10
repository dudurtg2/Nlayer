package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.repositories.ProdutoRepository;
import com.lanchenlayer.services.ProdutoService;

import java.util.ArrayList;

public class ProdutoApplication {
    private ProdutoRepository produtoRepository;
    private ProdutoService produtoService;

    public ProdutoApplication(ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }

    public void adicionar(Produto produto) {
        this.produtoRepository.adicionar(produto);
        this.produtoService.salvarImagem(produto);
    }

    public void adicionarSoImagem(Produto produto) {
        this.produtoService.salvarImagem(produto);
    }

    public void remover(int DDD) {
        this.produtoRepository.remover(DDD);
        this.produtoService.removerImagem(DDD);
    }

    public Produto buscarPorDDD(int DDD) {
        return this.produtoRepository.buscarPorDDD(DDD);
    }

    public ArrayList<Produto> buscarTodos() {
        return this.produtoRepository.buscarTodos();
    }

    public void atualizarProduto(int DDD, Produto produto) {
        this.produtoRepository.atualizarProduto(DDD, produto);
        this.produtoService.atualizarImagem(produto);
    }
}
