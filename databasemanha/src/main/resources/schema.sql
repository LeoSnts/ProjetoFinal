drop table if exists morador;

create table morador(
    id_morador bigint auto_increment,
    nome varchar(100) not null,
    rg varchar(10) not null,
    primary key(id_morador)
    );