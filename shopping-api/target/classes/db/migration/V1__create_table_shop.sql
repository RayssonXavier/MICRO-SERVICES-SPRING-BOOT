create schema if not exists shopping;

create table shopping.shop (
    id bigserial primary key,
    identificador_usuario varchar(100) not null,
    data timestamp  not null,
    horas varchar(80),
    total float not null
);