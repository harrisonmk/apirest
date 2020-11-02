
package com.produtos.apirest.repositorio;

import com.produtos.apirest.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
    
    
    
}
