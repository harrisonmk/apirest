package com.produtos.apirest.controle;

import com.produtos.apirest.modelo.Produto;
import com.produtos.apirest.repositorio.ProdutoRepositorio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value="Api Rest Produtos")
@CrossOrigin(origins="*")
public class ProdutoControle {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Produto> listaProdutos() {

        return produtoRepositorio.findAll();

    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna um produto unico")
    public Produto listaProdutoUnico(@PathVariable("id") Long id) {
        return produtoRepositorio.findById(id).orElseThrow();
    }

    
    @PostMapping("/produto")
    @ApiOperation(value="Este metodo salva um produto")
    public Produto salvarProduto(@Valid @RequestBody Produto produto) {

        return produtoRepositorio.save(produto);

    }

    
    @DeleteMapping("/produto")
    @ApiOperation(value="Este metodo deleta um produto")
    public void deletarProduto(@RequestBody Produto produto) {

       produtoRepositorio.delete(produto);

    }
    
    
    @PutMapping("/produto")
    @ApiOperation(value="Este metodo atualiza um produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {

     return produtoRepositorio.save(produto);

    }
    
}
