package com.controleestoque.api_estoque.model.produto;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.controleestoque.api_estoque.model.categoria.CategoriaRepository;
import com.controleestoque.api_estoque.model.fornecedor.FornecedorRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final FornecedorRepository fornecedorRepository;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {

        if (produto.getCategoria() == null || produto.getCategoria().getId() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        categoriaRepository.findById(produto.getCategoria().getId())
                .ifPresent(produto::setCategoria);

        if (produto.getFornecedores() != null && !produto.getFornecedores().isEmpty()) {

            List<Long> ids = produto.getFornecedores().stream()
                    .map(f -> f.getId())
                    .toList();

            produto.getFornecedores().clear();

            ids.forEach(idFornecedor -> {
                fornecedorRepository.findById(idFornecedor)
                        .ifPresent(f -> produto.getFornecedores().add(f));
            });
        }

        Produto savedProduto = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoDetails.getNome());
                    Produto updatedProduto = produtoRepository.save(produto);
                    return ResponseEntity.ok(updatedProduto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
