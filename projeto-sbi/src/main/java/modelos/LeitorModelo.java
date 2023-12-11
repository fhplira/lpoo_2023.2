package modelos;

public class LeitorModelo {
	
	private String nome;
	private String email;
	private String cpf;
	private int emprestimo = 0;
	
	public LeitorModelo(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
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

	public int getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(int emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	public void adicionarEmprestimo(int emprestimo) {
		this.emprestimo = this.getEmprestimo() + emprestimo;
	}
	
	public void removerEmprestimo(int emprestimo) {
		this.emprestimo = this.getEmprestimo() - emprestimo;
	}
}
