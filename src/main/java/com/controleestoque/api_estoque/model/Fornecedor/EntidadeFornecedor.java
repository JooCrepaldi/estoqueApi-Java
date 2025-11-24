package com.controleestoque.api_estoque.model;

import jakarta.persistence*;
import java.util.Set;

@Entity
@Table(name = "tb_fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = Generative)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "fornecedores")
    private Set<Produto> produtos;

    public Fornecedor() {}

    public Fornecedor(String nome, Set<Produto> produtos){
        this.nome = nome;
        this.produtos = produtos;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.nome = nome; }
    public String getNome 

}