create table medicos (
                         id uuid not null,
                         bairro varchar(255) not null,
                         cep varchar(255) not null,
                         cidade varchar(255) not null,
                         complemento varchar(255),
                         crm varchar(255) not null unique,
                         email varchar(255) not null unique,
                         especialidade varchar(255) check (especialidade in ('ORTOPEDIA','CARDIOLOGIA','GINECOLOGIA','DERMATOLOGIA')),
                         logradouro varchar(255) not null,
                         nome varchar(255) not null,
                         numero varchar(255),
                         uf varchar(255) not null,
                         primary key (id)
);