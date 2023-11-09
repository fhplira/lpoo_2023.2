package model;

public class Livro {
	String titulo;
	String autor;
	String edicao;
	String editora;
	int ano;
	int quantidade;
	int emprestados;
	int disponivel;
	
	public Livro(String titulo, String autor, String edicao, String editora, int ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.editora = editora;
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getEmprestados() {
		return emprestados;
	}

	public void setEmprestados(int emprestados) {
		this.emprestados = emprestados;
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}	
}
