## API Gestão de Produtos
## Sobre

Treinando API RestFul e fiz um CRUD simples com exceções personalizadas, tratamentos de negócio e um sistema CRUD
## Endpoints

## Base da url
```
/products
```


### 1. Criar produto

**POST** `/add`

Cria um novo produto.

**Corpo da requisição:**
```json
{
    "name": "Garrafa d'agua",
    "description": "Cor preta, 1L",
    "price": 10,
    "quantity": 100
}
```

### 2. Procurar produto por id

**GET** `/{id}`

Retorna um produto existente.

**Exemplo de resposta:**
```json
{
	"id": 1,
	"name": "Garrafa d'agua",
	"description": "Cor preta, 1L",
	"price": 10,
	"quantity": 100
	"created_at": "2025-07-07T17:30:59.000Z",
	"updated_at": "2025-07-07T17:30:59.000Z"
}
```

### 3. Atualizar produto

**PUT** `/edit/{id}`

Atualiza um produto pelo id.

**Corpo da requisição:**
```json
{
    "name": "Garrafa d'agua",
    "description": "Cor preta, 1L",
    "price": 10,
    "quantity": 200
}
```

### 4. Deletar produto

**DELeTE** `/delete/{id}`

Deleta um produto.
