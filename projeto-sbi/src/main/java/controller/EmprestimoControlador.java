package controller;

import dados.ExcecaoDados;
import model.EmprestimoModelo;

//Remover todos os comentarios apos a criação da classe EmprestimoDados e seus Métodos.
//Próximas Adições Metodos: 1° Fazer Devolução;
// 2° Aplicar Multa em caso de atraso;
// e 3° Avisar Leitor (sobre a proximidade do final do emprestimo).

public class EmprestimoControlador {
	//private EmprestimoDados Dados;
	private LeitorControlador leitorControlador;
	private LivroControlador livroControlador;
	private boolean cpfExiste;
	private boolean isbnExiste;
	
	public boolean verificarExistenciaIsbn(String isbn) throws ExcecaoControlador {
		LivroControlador livro = new LivroControlador();
		
		if(isbn.isBlank()){
			throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
		}
		
		if(!isbn.matches("^\\d+$")){
			throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
		}
		
		if((isbn.length() != 10) && (isbn.length() != 13)) {
			throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
		}
		
		//try {
			//livro = livroControlador.buscarLivroPorIsbn(isbn);
			//if(livro != null) {
				//return true;
			//}
		//}
		//catch(ExcecaoDados e){
			//throw new ExcecaoControlador(e.getMessage(), e);
		//}
		return false;
	}
	
	public boolean verificarExistenciaCpf(String cpf) throws ExcecaoControlador {
		LeitorControlador leitor = new LeitorControlador();
		
		if(!cpf.matches("[0-9]+")) {
			throw new ExcecaoControlador("O campo Cpf não pode ter letras");
		}
		
		if(cpf.length() != 11) {
			throw new ExcecaoControlador("Tamanho inválido digite apenas 11 Números.");
		}
		
		if(cpf.isBlank()) {
			throw new ExcecaoControlador("O campo Cpf não pode ser vazio");
		}
		
		if(cpf.matches(".*\\s+.*")) {
			throw new ExcecaoControlador("O campo Cpf não pode ter espaço em branco");
		}
		
		//try {
			//leitor = leitorControlador.buscarLeitorPorCpf(cpf); 
			//if(leitor != null) {
				//return true;
			//}
		//}
		//catch(ExcecaoDados e){
			//throw new ExcecaoControlador(e.getMessage(), e);
		//}
		return false;
	}
	
	public EmprestimoModelo fazerEmprestimo(String isbn, String cpf) throws ExcecaoControlador {
		isbnExiste = verificarExistenciaIsbn(isbn);
		cpfExiste = verificarExistenciaCpf(cpf);
		
		if(isbn.isBlank()){
			throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
		}
		
		if(!isbn.matches("^\\d+$")){
			throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
		}
		
		if((isbn.length() != 10) && (isbn.length() != 13)) {
			throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
		}
		
		if(!cpf.matches("[0-9]+")) {
			throw new ExcecaoControlador("O campo Cpf não pode ter letras");
		}
		
		if(cpf.length() != 11) {
			throw new ExcecaoControlador("Tamanho inválido digite apenas 11 Números.");
		}
		
		if(cpf.isBlank()) {
			throw new ExcecaoControlador("O campo Cpf não pode ser vazio");
		}
		
		if(cpf.matches(".*\\s+.*")) {
			throw new ExcecaoControlador("O campo Cpf não pode ter espaço em branco");
		}
		
		if(!isbnExiste) {
			throw new ExcecaoControlador("Isbn não encontrado");
		}
		
		if(!cpfExiste) {
			throw new ExcecaoControlador("Cpf não encontrado");
		}
		
		//EmprestimoModelo emprestimo = new EmprestimoModelo();
		
		//try {
			//emprestimo = Dados.criarEmprestimo(isbn, cpf);
			//return emprestimo;
		//}
		//catch(ExcecaoDados e) {
			//throw new ExcecaoControlador(e.getMessage(), e);
		//}
		return null; //retornando null temporariamente.
	}
}