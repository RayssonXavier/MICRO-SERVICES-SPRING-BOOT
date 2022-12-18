create table produtos.produto (
    id bigserial primary key,
    identificador varchar not null,
    nome varchar (100) not null,
    preco float not null,
    id_categoria bigint REFERENCES produtos.categoria(id)
);
