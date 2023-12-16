package modelos;

public class LivroModelo {
	
	private String isbn;
	private String titulo;
	private String autor;
	private String editora;
	private String dataPublicacao;
	private String descricao;
	private String img;
	private String controleExemplar;
	private int disponivel;
	private int emprestado;
	private int total = disponivel + emprestado;
	
	
	public LivroModelo() {
		
	}
	
	public LivroModelo(String isbn, String titulo, String autor, String editora, String dataPublicacao, String descricao, String img) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.dataPublicacao = dataPublicacao;
		this.descricao = descricao;
		this.img = img;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void setValorTotal() {
		this.total = this.getDisponivel() + this.getEmprestado();
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}
	
	public void setAdicionarDisponivel(int disponivel) {
		this.disponivel += disponivel ;
	}
	
	public void setRemoverDisponivel(int disponivel) {
		this.disponivel -= disponivel ;
	}

	public int getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(int emprestado) {
		this.emprestado = emprestado;
	}
	
	public void setAdicionarEmprestado(int emprestado) {
		this.emprestado += emprestado;
	}
	
	public void setRemoverEmprestado(int emprestado) {
		this.emprestado -= emprestado;
	}

	public String toString() {
		return titulo;
	}

	public String getControleExemplar() {
		return controleExemplar;
	}

	public void setControleExemplar(String controleExemplar) {
		this.controleExemplar = controleExemplar;
	}

	
}
