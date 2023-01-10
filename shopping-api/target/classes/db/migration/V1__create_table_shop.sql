create schema if not exists shopping;

create table shopping.shop (
    id bigserial primary key,
    identificador_usuario varchar(100) not null,
    data timestamp  not null,
    total float not null
);