package model;

public class Livro {
	String titulo;
	String autor;
	String editora;
	String isbn;
	String DataPublicacao;
	String img;
	int quantidade;
	int emprestados;
	int disponivel;
	
	public Livro() {
		
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

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDataPublicacao() {
		return DataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		DataPublicacao = dataPublicacao;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
