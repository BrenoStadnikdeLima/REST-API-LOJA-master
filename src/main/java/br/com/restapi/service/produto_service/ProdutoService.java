package br.com.restapi.service.produto_service;

import br.com.restapi.model.Produto;

import java.util.List;

public interface ProdutoService {

    public Produto createProduto(Produto newProduto);

    public List<Produto> findAllProdutos();

    public void deleteProduto(Long deletedProduto);

    public Produto updateProduto(Long id, Produto updatedProduto);


}
