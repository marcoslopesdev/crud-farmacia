package com.generation.farmacia.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarProdutosDisponiveis() {
        return produtoRepository.findAll().stream()
            .filter(produto -> produto.getQuantidade() > 0)
            .toList();
    }
}
