package com.controleestoque.api_estoque.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_categorias")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CacadeType.ALL)
    private List<Produto> produtos;

    public Categoria() {}

    public Categoria(String nome, List<Produto> produtos){
        this.nome = nome;
        this.produtos = produtos;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}
