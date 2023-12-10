package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmprestimoModelo {
	
	private boolean devolvido = false;
	private int diasAtraso = 0; 
	private int id;
	private String isbn;
	private String cpf;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataDevolucao;
	private String dataEmprestimoFormatada;
	private String dataDevolucaoFormatada;
	private DateTimeFormatter padraoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public EmprestimoModelo(String isbn, String cpf) {
		this.isbn = isbn;
		this.cpf = cpf;
		this.dataEmprestimoFormatada = getDataEmprestimo().format(padraoHora);
		this.dataDevolucaoFormatada = getDataDevolucao().format(padraoHora);
	}

	public EmprestimoModelo() {
		
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}

	public int getDiasAtraso() {
		return diasAtraso;
	}

	public void setDiasAtraso(int diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int idLocal) {
		this.id = idLocal;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getDataEmprestimoFormatada() {
		return dataEmprestimoFormatada;
	}
	
	public void setDataEmprestimoFormatada(String dataEmprestimoFormatada) {
		this.dataEmprestimoFormatada = dataEmprestimoFormatada;
	}
	
	public void setDataDevolucaoFormatada(String dataDevolucaoFormatada) {
		this.dataDevolucaoFormatada = dataDevolucaoFormatada;
	}
	
	public String getDataDevolucaoFormatada() {
		return dataDevolucaoFormatada;
	}
}