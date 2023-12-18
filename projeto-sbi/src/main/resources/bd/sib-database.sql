CREATE TABLE IF NOT EXISTS bibliotecario (
	id_bibliotecario INTEGER AUTO_INCREMENT,
	nome_bibliotecario VARCHAR(50),
	email_bibliotecario VARCHAR(100),
	senha_bibliotecario VARCHAR(8),
	PRIMARY KEY (id_bibliotecario)
);


CREATE TABLE IF NOT EXISTS leitor (
	nome_leitor VARCHAR(50),
	cpf_leitor CHAR(11),
	email_leitor VARCHAR(100),
    emprestimo_leitor INTEGER,
	PRIMARY KEY (cpf_leitor)
);

CREATE TABLE IF NOT EXISTS livro (
	isbn CHAR (13),
	titulo_livro VARCHAR (100),
	autor VARCHAR (500),
	editora VARCHAR (50),
	data_publicacao VARCHAR (100),
	descricao VARCHAR (6000),
	img VARCHAR (2000),
	total INTEGER,
	emprestado INTEGER,
    disponivel INTEGER,
	PRIMARY KEY (isbn)
);

CREATE TABLE IF NOT EXISTS emprestimo (
	id_emprestimo INTEGER AUTO_INCREMENT,
    cpf_leitor_fk CHAR(11),
    isbn_fk CHAR (13),
	data_emprestimo DATE,
	data_devolucao DATE,
	dias_atraso INTEGER,
	devolvido BOOLEAN,
	PRIMARY KEY (id_emprestimo),
    FOREIGN KEY (cpf_leitor_fk) REFERENCES leitor (cpf_leitor),
    FOREIGN KEY (isbn_fk) REFERENCES livro (isbn)
);

INSERT INTO bibliotecario (nome_bibliotecario, email_bibliotecario, senha_bibliotecario) VALUES ("Bruno Cartaxo", "admin@gmail.com", "12345");
