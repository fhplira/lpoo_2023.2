package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
	
	private double multa = 0;
	private int limiteLivro = 0;
	private int diasAtrasados = 0; 
	private long cpf;
	private int idLocal;
	private long isbn;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataDevolucao;
	private String dataEmprestimoFormatada;
	private String dataDevolucaoFormatada;
	
	DateTimeFormatter padraoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public Emprestimo(long isbn, int idLocal, long cpf) {
		this.isbn = isbn;
		this.idLocal = idLocal;
		this.cpf = cpf;
		this.dataEmprestimo = LocalDateTime.now();
		this.dataDevolucao = this.getDataEmprestimo().plusDays(15);
		this.dataEmprestimoFormatada = getDataEmprestimo().format(padraoHora);
		this.dataDevolucaoFormatada = getDataDevolucao().format(padraoHora);
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public int getLimiteLivro() {
		return limiteLivro;
	}

	public void setLimiteLivro(int limiteLivro) {
		this.limiteLivro = limiteLivro;
	}

	public int getDiasAtrasados() {
		return diasAtrasados;
	}

	public void setDiasAtrasados(int diasAtrasados) {
		this.diasAtrasados = diasAtrasados;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
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
