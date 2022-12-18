package com.lojaonlineapiprodutos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaonlineapiprodutos.dto.ProdutoDto;
import com.lojaonlineapiprodutos.exception.CategoriaNotFoundException;
import com.lojaonlineapiprodutos.exception.ProdutoNotFoundException;
import com.lojaonlineapiprodutos.model.Produto;
import com.lojaonlineapiprodutos.repository.CategoriaRepository;
import com.lojaonlineapiprodutos.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<ProdutoDto> obterTodos() {
        return this.produtoRepository.findAll()
                .stream().map(ProdutoDto:: convert)
                .collect(Collectors.toList());
    }

    public List<ProdutoDto> obterProdutoPorCategoria(long categoriaId) {
        return this.produtoRepository.getProdutoByCategoria(categoriaId)
                .stream().map(ProdutoDto:: convert)
                .collect(Collectors.toList());
    }

    public ProdutoDto obterProdutoPorIdentificador(String identificador) throws ProdutoNotFoundException {
        var produto= this.produtoRepository.findByIdentificador(identificador);
        if(produto != null) {
            return ProdutoDto.convert(produto);
        }
        throw new ProdutoNotFoundException();
    }

    public ProdutoDto salvar(ProdutoDto produtoDto) throws CategoriaNotFoundException {

        boolean isCategoriaExists = this.categoriaRepository
            .existsById(produtoDto.getCategoriaDto().getId());

            if(!isCategoriaExists) {
                throw new CategoriaNotFoundException();
            }

        return ProdutoDto.convert(this.produtoRepository
            .save(Produto.convert(produtoDto))
        );
    }

    public void deletar(long produtoId) throws ProdutoNotFoundException {
        var produtoOptional = this.produtoRepository.findById(produtoId);
        if(produtoOptional.isPresent()) {
            this.produtoRepository.delete(produtoOptional.get());
        }
        throw new ProdutoNotFoundException();
    }
}
