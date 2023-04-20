-- Populando tabela cliente
INSERT INTO cliente (endereco, nome)
VALUES 
('Rua A, 123', 'João da Silva'),
('Avenida B, 456', 'Maria Santos'),
('Rua C, 789', 'José Oliveira');

-- Populando tabela pedido
INSERT INTO pedido (data, numero_pedido, id_cliente)
VALUES 
('2023-04-20', '00001', 1),
('2023-04-19', '00002', 1),
('2023-04-18', '00003', 2),
('2023-04-17', '00004', 3);

-- Populando tabela produto
INSERT INTO produto (nome, valor)
VALUES 
('Produto 1', 100),
('Produto 2', 200),
('Produto 3', 300);

-- Populando tabela produto_pedido
INSERT INTO produto_pedido (id_pedido, id_produto)
VALUES 
(1, 1),
(1, 2),
(1, 2),
(2, 3),
(3, 1),
(3, 1),
(3, 3),
(3, 3),
(4, 2);

-- Populando tabela reclamacao
INSERT INTO reclamacao (data_criacao, origem, status, titulo, id_cliente)
VALUES 
('2023-04-20', 'Telefone', 'Aberta', 'Problema com a linha', 1),
('2023-04-19', 'E-mail', 'Fechada', 'Problema com a entrega', 2),
('2023-04-18', 'Chat', 'Em andamento', 'Produto com defeito', 3),
('2023-04-17', 'Telefone', 'Fechada', 'Dúvida sobre produto', 1);

-- Populando tabela pagamento
INSERT INTO pagamento (forma_pagamento, status, valor, valor_frete, valor_parcela, pedido_id)
VALUES 
(1, 'Aguardando pagamento', 500, 20, 520, 1),
(2, 'Pago', 300, 10, 150, 2),
(1, 'Pago', 600, 30, 200, 3),
(3, 'Aguardando pagamento', 200, 15, 66.66, 4);

-- Populando tabela atendimento
INSERT INTO atendimento (data, descricao, status, id_reclamacao)
VALUES 
('2023-04-20', 'Atendimento via telefone', 'Concluído', 1),
('2023-04-19', 'Atendimento via e-mail', 'Concluído', 2),
('2023-04-18', 'Atendimento via chat', 'Em andamento', 3),
('2023-04-17', 'Atendimento via telefone', 'Concluído', 4),
('2023-04-17', 'Atendimento via telefone', 'Concluído', 1),
('2023-04-16', 'Atendimento via chat', 'Em andamento', 1);
