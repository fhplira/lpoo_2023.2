package model;

public class Leitor {
	private String nome;
	private String email;
	private String cpf;
	
	public Leitor(String nome, String email , String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
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
}
