package model;

public class Livro {
	String titulo;
	String autor;
	String editora;
	String isbn;
	String dataPublicacao;
	String descricao;
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
		return dataPublicacao;
	}



	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
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



	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + ", isbn=" + isbn
				+ ", dataPublicacao=" + dataPublicacao + ", descricao=" + descricao + "]";
	}

	
	
	
}
