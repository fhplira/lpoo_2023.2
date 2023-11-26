package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmprestimoModelo {
	
	private double multa = 0;
	private int diasAtrasados = 0; 
	private int idLocal;
	private String isbn;
	private String cpf;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataAtual = LocalDateTime.now();
	private LocalDateTime dataDevolucao;
	private String dataEmprestimoFormatada;
	private String dataDevolucaoFormatada;
	private String dataAtualFormatada = getDataAtual().format(padraoHora);
	private static DateTimeFormatter padraoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public EmprestimoModelo(String isbn, String cpf) {
		this.isbn = isbn;
		this.cpf = cpf;
		this.dataEmprestimo = LocalDateTime.now();
		this.dataDevolucao = this.getDataEmprestimo().plusDays(15);
		this.dataEmprestimoFormatada = getDataEmprestimo().format(padraoHora);
		this.dataDevolucaoFormatada = getDataDevolucao().format(padraoHora);
	}

	public EmprestimoModelo() {
		
	}
	
	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public int getDiasAtrasados() {
		return diasAtrasados;
	}

	public void setDiasAtrasados(int diasAtrasados) {
		this.diasAtrasados = diasAtrasados;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
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

	public LocalDateTime getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(LocalDateTime dataAtual) {
		this.dataAtual = dataAtual;
	}

	public String getDataAtualFormatada() {
		return dataAtualFormatada;
	}

	public void setDataAtualFormatada(String dataAtualFormatada) {
		this.dataAtualFormatada = dataAtualFormatada;
	}
	
}