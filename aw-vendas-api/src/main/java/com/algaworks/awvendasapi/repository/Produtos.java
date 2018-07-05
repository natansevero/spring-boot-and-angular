/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.awvendasapi.repository;

import com.algaworks.awvendasapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author natan
 */
public interface Produtos extends JpaRepository<Produto, Long>{
    
}
