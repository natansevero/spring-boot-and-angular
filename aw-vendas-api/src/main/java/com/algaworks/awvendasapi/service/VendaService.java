/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.awvendasapi.service;

import com.algaworks.awvendasapi.model.Venda;
import com.algaworks.awvendasapi.repository.Produtos;
import com.algaworks.awvendasapi.repository.Vendas;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natan
 */
@Service
public class VendaService {
    
    @Autowired
    private Vendas vendas;
    
    @Autowired
    private Produtos produtos;
    
    public Venda adicionar(Venda venda) {
        venda.setCadastro(LocalDateTime.now());
        venda.getItens().forEach(i -> {
            i.setVenda(venda);
            i.setProduto(produtos.findById(i.getProduto().getId()).get());
        });
        
        BigDecimal totalItens = venda.getItens().stream()
                .map(i -> i.getProduto().getValor().multiply(new BigDecimal(i.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        venda.setTotal(totalItens.add(venda.getFrete()));
        
        return vendas.save(venda);
    }
}
