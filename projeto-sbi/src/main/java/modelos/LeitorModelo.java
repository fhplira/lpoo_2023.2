package modelos;

public class LeitorModelo {
	private int id;
	private String nome;
	private String email;
	private String cpf;
	private int livrosEmprestados;
	
	public LeitorModelo(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		livrosEmprestados = 0;
	}
	
	public LeitorModelo() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getLivrosEmprestados() {
		return livrosEmprestados;
	}

	public void setLivrosEmprestados() {
		this.livrosEmprestados++;
	}
	
}
