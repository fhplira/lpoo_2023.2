DROP DATABASE IF EXISTS sib;

CREATE DATABASE IF NOT EXISTS sib;

USE sib;

CREATE TABLE IF NOT EXISTS bibliotecario (
	id_bibliotecario INT AUTO_INCREMENT,
	nome_bibliotecario VARCHAR(50),
	email_bibliotecario VARCHAR(100),
	senha_bibliotecario VARCHAR(8),
	PRIMARY KEY (id_bibliotecario)
);

CREATE TABLE IF NOT EXISTS leitor (
	nome_leitor VARCHAR(50),
	cpf_leitor CHARACTER(11),
	email_leitor VARCHAR (100),
    emprestimo_leitor INT,
	PRIMARY KEY (cpf_leitor)
);

CREATE TABLE IF NOT EXISTS livro (
	isbn CHARACTER (13),
	titulo_livro VARCHAR (100),
	autor VARCHAR (500),
	editora VARCHAR (50),
	data_publicacao VARCHAR (100),
	descricao VARCHAR (6000),
	img VARCHAR (2000),
	total INT,
	emprestado INT,
    disponivel INT,
	PRIMARY KEY (isbn)
);

CREATE TABLE IF NOT EXISTS emprestimo (
	id_emprestimo INT AUTO_INCREMENT,
    cpf_leitor_fk CHARACTER(11),
    isbn_fk CHARACTER (13),
	data_emprestimo DATE DEFAULT (CURRENT_DATE),
	data_devolucao DATE DEFAULT (CURRENT_DATE + INTERVAL 15 DAY),
	dias_atraso INT,
	devolvido BOOLEAN,
	PRIMARY KEY (id_emprestimo),
    FOREIGN KEY (cpf_leitor_fk) REFERENCES leitor (cpf_leitor),
    FOREIGN KEY (isbn_fk) REFERENCES livro (isbn)
);


INSERT INTO bibliotecario (nome_bibliotecario, email_bibliotecario, senha_bibliotecario)
VALUES ("Bruno Cartaxo", "bruno.cartaxo@paulista.ifpe.edu.br", "12345");
