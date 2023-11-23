create table pacientes (
                           id uuid not null,
                           bairro varchar(255),
                           cep varchar(255),
                           cidade varchar(255),
                           complemento varchar(255),
                           cpf varchar(255),
                           email varchar(255),
                           logradouro varchar(255),
                           nome varchar(255),
                           numero varchar(255),
                           telefone varchar(255),
                           uf varchar(255),
                           primary key (id)
)