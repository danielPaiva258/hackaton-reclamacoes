# Hackaton-reclamacoes

## Branch microservice_pedido
Branco de <b>Pedido</br>

### Controllers
* /list: lista todos os pedidos
* /{id}: detalhes de um pedido
* /id_cliente={id}: mosta todos os pedidos de um cliente específico.

### Models
* Pedido
* Produto: DTO para Produtos.

### Repositories
* PedidoRepository

### Tests
* recupera_pedido_por_id()
* contextLoads()