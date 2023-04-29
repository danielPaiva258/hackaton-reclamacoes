    create table atendimento (
       id integer auto_increment,
        data timestamp,
        descricao varchar(255),
        status varchar(255),
        id_reclamacao integer,
        primary key (id)
    );

    create table cliente (
       id integer auto_increment,
        endereco varchar(255),
        nome varchar(255),
        primary key (id)
    );

    create table pagamento (
       id integer auto_increment,
        forma_pagamento double,
        status varchar(255),
        valor double,
        valor_frete double,
        valor_parcela double,
        pedido_id integer,
        primary key (id)
    );

    create table pedido (
       id integer auto_increment,
        data varchar(255),
        numero_pedido varchar(255),
        id_cliente integer,
        primary key (id)
    );

    create table produto (
       id integer auto_increment,
        nome varchar(255),
        valor varchar(255),
        primary key (id)
    );

    create table produto_pedido (
       id_pedido integer not null,
        id_produto integer not null
    );

    create table reclamacao (
       id integer auto_increment,
        data_criacao timestamp,
        origem varchar(255),
        status varchar(255),
        titulo varchar(255),
        id_cliente integer,
        primary key (id)
    );


    alter table pagamento 
       add constraint FKthad9tkw4188hb3qo1lm5ueb0 
       foreign key (pedido_id) 
       references pedido(id);

    alter table pedido 
       add constraint FK9y4jnyp1hxqa386cnly0ay9uw 
       foreign key (id_cliente) 
       references cliente(id);

    alter table produto_pedido 
       add constraint FKcfjlvdadqb9dtdqptw61mpl7l 
       foreign key (id_produto) 
       references produto(id);

    alter table produto_pedido 
       add constraint FK3moid9j0iyby8p094vaij1bo5 
       foreign key (id_pedido) 
       references pedido(id);

    alter table reclamacao 
       add constraint FKevmpqodwyk8ncwnt5kevrfxnk 
       foreign key (id_cliente) 
       references cliente(id);

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