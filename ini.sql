create table atendimento
(
    id            integer auto_increment,
    data          timestamp,
    descricao     varchar(255),
    status        varchar(255),
    id_reclamacao integer,
    primary key (id)
);

create table cliente
(
    id       integer auto_increment,
    endereco varchar(255),
    nome     varchar(255),
    primary key (id)
);

create table pagamento
(
    id              integer auto_increment,
    forma_pagamento double,
    status          varchar(255),
    valor           double,
    valor_frete     double,
    valor_parcela   double,
    pedido_id       integer,
    primary key (id)
);

create table pedido
(
    id            integer auto_increment,
    data          varchar(255),
    numero_pedido varchar(255),
    id_cliente    integer,
    primary key (id)
);

create table produto
(
    id    integer auto_increment,
    nome  varchar(255),
    valor varchar(255),
    primary key (id)
);

create table produto_pedido
(
    id_pedido  integer not null,
    id_produto integer not null
);

create table reclamacao
(
    id           integer auto_increment,
    data_criacao timestamp,
    origem       varchar(255),
    status       varchar(255),
    titulo       varchar(255),
    id_cliente   integer,
    primary key (id)
);


alter table pagamento
    add constraint FKthad9tkw4188hb3qo1lm5ueb0
        foreign key (pedido_id)
            references pedido (id);

alter table pedido
    add constraint FK9y4jnyp1hxqa386cnly0ay9uw
        foreign key (id_cliente)
            references cliente (id);

alter table produto_pedido
    add constraint FKcfjlvdadqb9dtdqptw61mpl7l
        foreign key (id_produto)
            references produto (id);

alter table produto_pedido
    add constraint FK3moid9j0iyby8p094vaij1bo5
        foreign key (id_pedido)
            references pedido (id);

alter table reclamacao
    add constraint FKevmpqodwyk8ncwnt5kevrfxnk
        foreign key (id_cliente)
            references cliente (id);

-- Populando tabela cliente
INSERT INTO cliente (endereco, nome)
VALUES ('Rua A, 123', 'João da Silva'),
       ('Avenida B, 456', 'Maria Santos'),
       ('Rua C, 789', 'José Oliveira');

-- Populando tabela pedido
INSERT INTO pedido (data, numero_pedido, id_cliente)
VALUES ('2023-04-20', '00001', 1),
       ('2023-04-19', '00002', 1),
       ('2023-04-18', '00003', 2),
       ('2023-04-17', '00004', 3);

-- Populando tabela produto
INSERT INTO produto (nome, valor)
VALUES ('Produto 1', 100),
       ('Produto 2', 200),
       ('Produto 3', 300);

-- Populando tabela produto_pedido
INSERT INTO produto_pedido (id_pedido, id_produto)
VALUES (1, 1),
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
VALUES ('2023-04-20', 'Telefone', 'Aberta', 'Problema com a linha', 1),
       ('2023-04-19', 'E-mail', 'Fechada', 'Problema com a entrega', 2),
       ('2023-04-18', 'Chat', 'Em andamento', 'Produto com defeito', 3),
       ('2023-04-17', 'Telefone', 'Fechada', 'Dúvida sobre produto', 1);

-- Populando tabela pagamento
INSERT INTO pagamento (forma_pagamento, status, valor, valor_frete, valor_parcela, pedido_id)
VALUES (1, 'Aguardando pagamento', 500, 20, 520, 1),
       (2, 'Pago', 300, 10, 150, 2),
       (1, 'Pago', 600, 30, 200, 3),
       (3, 'Aguardando pagamento', 200, 15, 66.66, 4);

-- Populando tabela atendimento
INSERT INTO atendimento (data, descricao, status, id_reclamacao)
VALUES ('2023-04-20', 'Atendimento via telefone', 'Concluído', 1),
       ('2023-04-19', 'Atendimento via e-mail', 'Concluído', 2),
       ('2023-04-18', 'Atendimento via chat', 'Em andamento', 3),
       ('2023-04-17', 'Atendimento via telefone', 'Concluído', 4),
       ('2023-04-17', 'Atendimento via telefone', 'Concluído', 1),
       ('2023-04-16', 'Atendimento via chat', 'Em andamento', 1);

-- =============================== --
-- SEGURANÇA - AUTENTICAÇÃO
-- =============================== --

CREATE TABLE `focusdb`.`usuario`
(
    `id`            integer auto_increment NOT NULL,
    `username`      VARCHAR(100) NOT NULL,
    `password`      VARCHAR(100) NOT NULL,
    `dt_desativado` date,
    PRIMARY KEY (`id`)
) COMMENT = 'Usuarios de acesso ao sistema';

CREATE TABLE `focusdb`.`perfil_acesso`
(
    `id`            integer auto_increment NOT NULL,
    `codigo`        VARCHAR(100) NOT NULL,
    `nome`          VARCHAR(100) NOT NULL,
    `descricao`     VARCHAR(200) NOT NULL,
    `dt_desativado` date,
    PRIMARY KEY (`id`)
) COMMENT = 'Perfis de acesso ao sistema.';

CREATE TABLE `focusdb`.`perfil_acesso_usuario`
(
    `id`               integer auto_increment NOT NULL,
    `id_perfil_acesso` integer NOT NULL,
    `id_usuario`       integer NOT NULL,
    `dt_desativado`    date,
    PRIMARY KEY (`id`)
) COMMENT = 'Relacao de perfis de acesso ao sistema com os usuarios.';

-- Relacionamentos
ALTER TABLE `focusdb`.`perfil_acesso_usuario`
    ADD INDEX `perfil_acesso_usuario_usuario_idx` (`id_usuario` ASC) VISIBLE;
;
ALTER TABLE `focusdb`.`perfil_acesso_usuario`
    ADD CONSTRAINT `perfil_acesso_usuario_usuario`
        FOREIGN KEY (`id_usuario`)
            REFERENCES `focusdb`.`usuario` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE `focusdb`.`perfil_acesso_usuario`
    ADD INDEX `perfil_acesso_usuario_perfil_acesso_idx` (`id_perfil_acesso` ASC) VISIBLE;
;
ALTER TABLE `focusdb`.`perfil_acesso_usuario`
    ADD CONSTRAINT `perfil_acesso_usuario_perfil_acesso`
        FOREIGN KEY (`id_perfil_acesso`)
            REFERENCES `focusdb`.`perfil_acesso_usuario` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

-- Regra de usuário com único login não desativado:
ALTER TABLE `focusdb`.`usuario`
    ADD UNIQUE INDEX `uk_nome_dt_desativ` (`username` ASC, `dt_desativado` ASC) VISIBLE;
;


-- Populando tabela de usuários
INSERT INTO `focusdb`.`usuario` (`id`, `username`, `password`)
VALUES (1, 'admin', '$2a$10$5jxhtECLAvjSt.nHkSh0JOgY7jNEUJFmd5walW8agyZ586X6/0P1q');
INSERT INTO `focusdb`.`usuario` (`id`, `username`, `password`)
VALUES (2, 'supervisor-atendimento', '$2a$10$WtV.6hz9kMvG/9i9dMwVaO8wKC.ZiQZIfRFiA605qI4CnzM0YuhpC');
INSERT INTO `focusdb`.`usuario` (`id`, `username`, `password`)
VALUES (3, 'atendente', '$2a$10$iTqV68rZu5mQUeq2Jhq/ruj4bDZlU5b3ryorxqQx/DVYKdes.W3Qa');
INSERT INTO `focusdb`.`usuario` (`id`, `username`, `password`)
VALUES (4, 'cliente', '$2a$10$ehbYL0UV4xOyslw91Gq06.0UjfKaLRr22tYOFBMto7tpJ8rZjI3f.');

-- Populando tabela de perfis de acesso
INSERT INTO `focusdb`.`perfil_acesso` (`id`, `codigo`, `nome`, `descricao`)
VALUES (1, 'ADMIN', 'Administrador', 'Administração do sistema.');
INSERT INTO `focusdb`.`perfil_acesso` (`id`, `codigo`, `nome`, `descricao`)
VALUES (2, 'SUP-ATENDIMENTO', 'Supervisor de atendimento',
        'Supervisores que controlam usuários e permissões especiais nos atendimentos.');
INSERT INTO `focusdb`.`perfil_acesso` (`id`, `codigo`, `nome`, `descricao`)
VALUES (3, 'ATENDENTE', 'Atendente',
        'Atendente do sistema, com permissões de iterações com as reclamações e outros objetos. Possui limitações de acesso.');
INSERT INTO `focusdb`.`perfil_acesso` (`id`, `codigo`, `nome`, `descricao`)
VALUES (4, 'CLIENTE', 'Cliente', 'Acessos para os clientes. Possui limitações nas iterações de leitura/gravação.');

-- Populando relacionamentos entre usuários e perfis de acesso
INSERT INTO `focusdb`.`perfil_acesso_usuario` (id, id_perfil_acesso, id_usuario)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3),
       (4, 4, 4);
