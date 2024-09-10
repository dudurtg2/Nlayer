package com.lanchenlayer.facade;

import com.lanchenlayer.applications.ProdutoApplication;
import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.repositories.ProdutoRepository;

import java.util.ArrayList;

public class ProdutoFacade {
    private ProdutoApplication produtoApplication;

    public ProdutoFacade(ProdutoApplication produtoApplication) {
        this.produtoApplication = produtoApplication;
    }

    public void adicionar(Produto produto) {
        this.produtoApplication.adicionar(produto);
    }

    public void remover(int DDD) {
        this.produtoApplication.remover(DDD);
    }

    public Produto buscarPorDDD(int DDD) {
        return this.produtoApplication.buscarPorDDD(DDD);
    }

    public ArrayList<Produto> buscarTodos() {
        return this.produtoApplication.buscarTodos();
    }

    public void atualizarProduto(int DDD, Produto produto) {
        this.produtoApplication.atualizarProduto(DDD, produto);
    }
}
