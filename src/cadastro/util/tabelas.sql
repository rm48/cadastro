CREATE DATABASE siscliente;
USE siscliente;

CREATE TABLE cliente(
	id_cliente int primary key auto_increment,
	nome varchar(50),
	endereco varchar(50),
	cidade varchar(50),
	uf char(2),
	cep char(8),
	cpf char(11),
	email varchar(50),
	sexo char(1),
	bairro varchar(50),
	fone char(11)
);
