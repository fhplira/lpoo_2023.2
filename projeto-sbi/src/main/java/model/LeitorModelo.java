package model;

public class LeitorModelo {
	private String nome;
	private String email;
	private String cpf;
	private int LivrosEmprestados = 0;
	
	public LeitorModelo(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	public LeitorModelo() {
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
		return LivrosEmprestados;
	}

	public void setLivrosEmprestados(int livrosEmprestados) {
		LivrosEmprestados = livrosEmprestados;
	}
	
}
