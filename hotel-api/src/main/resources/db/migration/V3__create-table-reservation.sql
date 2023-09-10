create table reservation
(
    id_reserve bigint auto_increment,
    data_entry varchar(255) not null,
    data_out varchar(255) not null,
    prece_in_cents bigint not null,
    payment_method varchar(255) not null,
    primary key (id_reserve)
);