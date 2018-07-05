
package com.algaworks.awvendasapi.resource;

import com.algaworks.awvendasapi.model.Cliente;
import com.algaworks.awvendasapi.repository.Clientes;
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
@RequestMapping("/clientes")
public class ClientesResource { 
    
    @Autowired
    private Clientes clientes;

    @GetMapping
    public List<Cliente> listar() {
        return clientes.findAll();
    }
}
