create table shopping.item (
    shop_id bigserial REFERENCES shopping.shop(id),
    identificado_produto varchar(100) not null,
    preco float not null
);