package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.repositories.ProdutoRepository;
import com.lanchenlayer.services.EstadoService;

import java.util.ArrayList;

public class ProdutoApplication {
    private ProdutoRepository produtoRepository;
    private EstadoService estadoService;

    public ProdutoApplication(ProdutoRepository produtoRepository, EstadoService estadoService) {
        this.produtoRepository = produtoRepository;
        this.estadoService = estadoService;
    }

    public void adicionar(Produto produto) {
        this.produtoRepository.adicionar(produto);
        this.estadoService.salvarImagem(produto);
    }

    public void adicionarSoImagem(Produto produto) {
        this.estadoService.salvarImagem(produto);
    }

    public void remover(int DDD) {
        this.produtoRepository.remover(DDD);
        this.estadoService.removerImagem(DDD);
    }

    public Produto buscarPorDDD(int DDD) {
        return this.produtoRepository.buscarPorDDD(DDD);
    }

    public ArrayList<Produto> buscarTodos() {
        return this.produtoRepository.buscarTodos();
    }

    public void atualizarProduto(int DDD, Produto produto) {
        this.produtoRepository.atualizarProduto(DDD, produto);
        this.estadoService.atualizarImagem(produto);
    }
}
