package com.lanchenlayer.repositories;

import com.lanchenlayer.entities.Produto;

import java.util.ArrayList;

public class ProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public void remover(int DDD) {
        produtos.removeIf(produto -> produto.getDDD() == DDD);
    }

    private Produto filtrarProduto(int DDD) {
        return produtos.stream().filter(p -> p.getDDD() == DDD).findFirst().get();
    }

    public Produto buscarPorDDD(int DDD) {
        Produto produtoInDb = filtrarProduto(DDD);

        return produtoInDb;
    }

    public ArrayList<Produto> buscarTodos() {
        return produtos;
    }

    public void atualizarProduto(int DDD, Produto produto) {
        Produto produtoInDb = filtrarProduto(DDD);

        produtoInDb.setEstado(produto.getEstado());
        produtoInDb.setImagem(produto.getImagem());
    }
}
