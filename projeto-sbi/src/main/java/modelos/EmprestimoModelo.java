package modelos;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EmprestimoModelo {
	
	private boolean devolvido = false;
	private long diasAtraso = 0; 
	private int id;
	private String isbn;
	private String cpf;
	private LocalDate dataAtual;
	private LocalDate dataEmprestimo;
	private LocalDate dataAviso;
	private LocalDate dataDevolucao;
	private DateTimeFormatter padraoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public EmprestimoModelo(String isbn, String cpf) {
		this.isbn = isbn;
		this.cpf = cpf;
		this.dataEmprestimo = LocalDate.now();
		this.dataDevolucao = dataEmprestimo.plusDays(15);
	}

	public EmprestimoModelo() {
		
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}

	public long getDiasAtraso() {
		return diasAtraso;
	}

	public void setDiasAtraso(long diasAtraso) {
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
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public DateTimeFormatter getPadraoHora() {
		return padraoHora;
	}

	public void setPadraoHora(DateTimeFormatter padraoHora) {
		this.padraoHora = padraoHora;
	}

	public LocalDate getDataAtual() {
		return dataAtual;
	}
	
	public void setDataAtual(LocalDate dataAtual) {
		this.dataAtual = dataAtual;
	}

	public void setDataAgora() {
		this.dataAtual = LocalDate.now();
	}

	public LocalDate getDataAviso() {
		return dataAviso;
	}
	
	public void setDataAviso(LocalDate dataAviso) {
		this.dataAviso = dataAviso;
	}

	public void setDataAvisarLeitor() {
		this.dataAviso = dataEmprestimo.plusDays(12);;
	}
	
	public long duracaoDiasAtraso() {
		setDataAgora();
		long dias = ChronoUnit.DAYS.between(getDataDevolucao(), getDataAtual());
		return dias;
	}
	
	public String toString() {
		return "ID do Empréstimo = " + id + " , CPF do Leitor = " + cpf;
	}	
		
}