package controladores;

import dados.ExcecaoDados;
import dados.LeitorDados;
import modelos.LeitorModelo;

public class LeitorControlador {
	
	private LeitorDados dados = new LeitorDados();
	
	public void cadastrarLeitor(String nome, String cpf, String email) throws ExcecaoControlador {
		
		try {
			if(dados.verificarLeitor(cpf)) {
				throw new ExcecaoControlador("Leitor já existente");
			}
		}
		catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
		
		if(nome.matches("[0-9]+")) {
			throw new ExcecaoControlador("O campo Nome não pode ter números");
		}
		
		if(nome.isBlank()) {
			throw new ExcecaoControlador("O campo Nome não pode ser Vazio");
		}
		
		if(email.isBlank()) {
			throw new ExcecaoControlador("O campo Email não pode ser Vazio");
		}
		
		if(email.matches(".*\\s+.*")) {
			throw new ExcecaoControlador("O campo Email não pode ter espaço em branco");
		}
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.]+$")) {
			throw new ExcecaoControlador("Caracteres Invalidos digitados no campo Email");
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
		
		LeitorModelo leitor = new LeitorModelo(nome, cpf, email);
		try{
			dados.cadastrarLeitor(leitor);
		}catch(ExcecaoDados e){
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	public LeitorModelo buscarLeitorModeloPorCpf(String cpf) throws ExcecaoControlador {
		
		try {
			if(!dados.verificarLeitor(cpf)) {
				throw new ExcecaoControlador("Leitor não Existe");
			}
		}
		catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
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
		
		//LeitorModelo leitor = new LeitorModelo();
		//try {
			//leitor = repositorio.buscarLeitorPorCpf(cpf); //Criar metodo buscarLeitorPorCpf na camada de dados.
			//return leitor;
		//}catch(ExcecaoDados e){
			//throw new ExcecaoControlador(e.getMessage(), e);
		//}
		return null; //remover apos criação dos metodos acima.
	}
}
