create schema if not exists produtos;
create table produtos.categoria (
    id bigserial primary key,
    nome varchar(100) not null
);