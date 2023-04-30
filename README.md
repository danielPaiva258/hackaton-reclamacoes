# Hackaton-reclamacoes
## Branch microservice_reclamacao
Microserviço de <b>Reclamação</b>

### Controllers
Reclamacao Controller:
* /ativas: todas as reclamações não finalizadas com ações pendentes.
* /list: todas as reclamações.
* /{id}: detalhes de uma reclamação específica.
* /?id_cliente={id}: todas as reclamações de um clientes específico.
* {id}/historico_atendimento: lista de id's de todos os atendimentos dessa mesma reclamação.

### Models
* AtendimentoDTO
* Reclamacao

### Repositories
* ReclamacaoRepository

### Tests
* recupera_reclamacao_por_id()
