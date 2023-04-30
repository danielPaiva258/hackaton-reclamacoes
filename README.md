# Hackaton-reclamacoes
## Branch microservice_produto
Microserviço de Produtos.

### Controllers
Produto Controller: 
* /list: Lista todos os produtos.
* /{id}: Mostra informações sobre um produto específico identificado pelo ID.
* /{id}/vendas: Mostra o total de vendas de um produto específico identificado pelo ID.

### Models
Modelos do controlador de produtos.
* Produto: Descreve o produto e suas propriedades e métodos.
* PedidoDTO: Necessário para mostrar relacionamentos do produto com os pedidos.
 
### Repositories
Repositórios do controlador de produtos.
* ProdutoRepository

### Tests
Testes do serviço de produto.
* recupera_informacoes_de_produto_por_id
* recupera_informacoes_de_produto_por_nome
