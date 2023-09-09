create table guests (
    id INT auto_increment,
    name varchar(255) not null,
    last_name varchar(255) not null,
    date_of_birth varchar(255) not null,
    nationality varchar(255) not null,
    phone varchar(55) not null,
    id_reservation bigint not null,
    primary key (id)
);