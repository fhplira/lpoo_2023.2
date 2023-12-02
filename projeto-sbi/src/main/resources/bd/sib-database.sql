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
	id_leitor INT AUTO_INCREMENT,
	nome_leitor VARCHAR(50),
	cpf_leitor CHARACTER(50),
	email_leitor VARCHAR (100),
	emprestimos INT,
	PRIMARY KEY (id_leitor)
);

CREATE TABLE IF NOT EXISTS livro (
	id_livro INT AUTO_INCREMENT,
	isbn CHARACTER (13),
	titulo_livro VARCHAR (100),
	autor VARCHAR (500),
	editora VARCHAR (50),
	data_publicacao VARCHAR (100),
	descricao VARCHAR (5000),
	img VARCHAR (2000),
	PRIMARY KEY (id_livro)
);

CREATE TABLE IF NOT EXISTS emprestimo (
	id_emprestimo INT AUTO_INCREMENT,
	id_leitor_fk INT,
	id_livro_fk INT,
	isbn VARCHAR (50),
	cpf_leitor INT,
	data_emprestimo DATE,
	data_devolucao DATE DEFAULT (CURRENT_DATE + INTERVAL 15 DAY),
	multa DECIMAL,
	numero_exemplar_livro INT,
	PRIMARY KEY (id_emprestimo),
	FOREIGN KEY (id_leitor_fk) REFERENCES leitor (id_leitor),
	FOREIGN KEY (id_livro_fk) REFERENCES livro (id_livro)
);


INSERT INTO bibliotecario (nome_bibliotecario, email_bibliotecario, senha_bibliotecario)
VALUES ("Bruno Cartaxo", "bruno.cartaxo@paulista.ifpe.edu.br", "12345");
