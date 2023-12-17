package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmprestimoModelo {
	
	private boolean devolvido = false;
	private int diasAtraso = 0; 
	private int id;
	private String isbn;
	private String cpf;
	private LocalDateTime dataAtual;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataAviso;
	private LocalDateTime dataDevolucao;
	private DateTimeFormatter padraoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String dataEmprestimoFormatada;
	private String dataDevolucaoFormatada;
	
	public EmprestimoModelo(String isbn, String cpf) {
		this.isbn = isbn;
		this.cpf = cpf;
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
	
	public DateTimeFormatter getPadraoHora() {
		return padraoHora;
	}

	public void setPadraoHora(DateTimeFormatter padraoHora) {
		this.padraoHora = padraoHora;
	}
	
	

	public LocalDateTime getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual() {
		this.dataAtual = LocalDateTime.now();
	}

	public LocalDateTime getDataAviso() {
		return dataAviso;
	}

	public void setDataAviso(LocalDateTime dataAviso) {
		this.dataAviso = dataAviso;
	}

	public String getDataEmprestimoFormatada() {
		return dataEmprestimoFormatada;
	}

	public void setDataEmprestimoFormatada(String dataEmprestimoFormatada) {
		this.dataEmprestimoFormatada = dataEmprestimoFormatada;
	}

	public String getDataDevolucaoFormatada() {
		return dataDevolucaoFormatada;
	}

	public void setDataDevolucaoFormatada(String dataDevolucaoFormatada) {
		this.dataDevolucaoFormatada = dataDevolucaoFormatada;
	}

	public String toString() {
		return "ID do Empréstimo = " + id + " , CPF do Leitor = " + cpf;
	}	
		
}