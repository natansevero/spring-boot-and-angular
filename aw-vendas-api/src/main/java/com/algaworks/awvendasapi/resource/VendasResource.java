/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.awvendasapi.resource;

import com.algaworks.awvendasapi.model.Venda;
import com.algaworks.awvendasapi.repository.Vendas;
import com.algaworks.awvendasapi.service.VendaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author natan
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/vendas")
public class VendasResource {
    
    @Autowired
    private Vendas vendas;

    @Autowired
    private VendaService vendaService;
    
    @GetMapping
    public List<Venda> listar() {
        return vendas.findAll(); 
    }
    
    @PostMapping
    public Venda adicionar(@RequestBody @Valid Venda venda) {
        return vendaService.adicionar(venda);
    }
}
