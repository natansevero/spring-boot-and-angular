/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.awvendasapi.resource;

import com.algaworks.awvendasapi.model.Produto;
import com.algaworks.awvendasapi.repository.Produtos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author natan
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/produtos")
public class ProdutosResouce {
    
    @Autowired
    private Produtos produtos;

    @GetMapping
    public List<Produto> listar() {
        return produtos.findAll();
    }
}
