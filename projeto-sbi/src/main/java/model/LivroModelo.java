package model;

public class LivroModelo {
	String isbn;
	String codigoExemplar;
	String titulo;
	String autor;
	String editora;
	String dataPublicacao;
	String descricao;
	String img;	
	int quantidade;
	int emprestados;
	int disponivel;
	
	
	public LivroModelo() {
		
	}
	
	public LivroModelo(String isbn, String titulo, String autor, String editora,String data_publicacao, String descricao, String img,String codigo_exemplar) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.dataPublicacao = dataPublicacao;
		this.descricao = descricao;
		this.img = img;
		this.codigoExemplar = codigoExemplar;
	}

	public String getCodigoExemplar() {
		return codigoExemplar;
	}

	public void setCodigoExemplar(String codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
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
	
}
