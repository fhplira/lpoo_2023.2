package model;

public class Leitor {
	private String nome;
	private String email;
	private long cpf;
	
	public Leitor(String nome, String email , long cpf) {
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
	
	public long getCpf() {
		return this.cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
