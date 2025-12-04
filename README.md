# API de Controle de Estoque  
CRUD de Produtos, Categorias, Fornecedores e Estoque (Spring Boot)

Este repositório contém uma API REST desenvolvida em Spring Boot para gerenciamento de estoque, incluindo cadastro de produtos, categorias, fornecedores e controle de quantidades em estoque.  
O desafio original incluía também o módulo de **Clientes** e **Vendas**, mas **essas partes não foram implementadas neste projeto**.

---

## Tecnologias Utilizadas
- Java 17  
- Spring Boot
- PostgreSQL  
- Maven  

---

## Estrutura da Aplicação
A estrutura segue o padrão recomendado pelo Spring Boot e pela arquitetura em camadas:

    ```
    src/
    └─ main/
    └─ java/com/controleestoque/api_estoque/
    ├─ model/
    │ ├─ categoria/
    │ ├─ estoque/
    │ ├─ fornecedor/
    │ └─ produto/
    └─ ApiEstoqueApplication.java
    └─ resources/
    ├─ application.properties
    └─ ...

---

## Formato dos Registros (JSON)

### Criar Produto:
  ```json
      {
        "nome": "Notebook",
        "preco": 3500.00,
        "categoria": {
          "id": 1
        },
        "fornecedores": [
          { "id": 1 },
          { "id": 2 }
        ]
      }
  ```

### Criar Categoria:
  ```json
    {
      "nome": "Eletrônicos"
    }
  ```

### Criar Fornecedor:
  ```json
    {
      "nome": "Fornecedor XYZ"
    }
  ```


### Criar Estoque:
  ```json
    {
      "quantidade": 50,
      "produto": { "id": 1 }
    }
  ```
---
## Endpoints Disponíveis

### Categorias:
  ```
POST    /api/categorias
GET     /api/categorias
GET     /api/categorias/{id}
PUT     /api/categorias/{id}
DELETE  /api/categorias/{id}
  ```


### Fornecedores:
  ```
POST    /api/fornecedores
GET     /api/fornecedores
GET     /api/fornecedores/{id}
PUT     /api/fornecedores/{id}
DELETE  /api/fornecedores/{id}
  ```


### Produtos:
  ```
POST    /api/produtos
GET     /api/produtos
GET     /api/produtos/{id}
PUT     /api/produtos/{id}
DELETE  /api/produtos/{id}
  ```

### Estoque:
  ```
POST    /api/estoques
GET     /api/estoques
GET     /api/estoques/{id}
PUT     /api/estoques/{id}
  ```
