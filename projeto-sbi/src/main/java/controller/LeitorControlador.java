package controller;

import dados.ExcecaoDados;
import dados.LeitorDados;
import model.LeitorModelo;

public class LeitorControlador {
	
	private LeitorDados repositorio;
	
	public void criarLeitorModelo(String nome, String cpf, String email) throws ExcecaoControlador {
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
		
		//LeitorModelo LeitorModelo = new LeitorModelo(nome, cpf, email);
		//try{
			//repositorio.criarLeitor(LeitorModelo); //Criar metodo criarLeitor na camada de dados.
		//}catch(ExcecaoDados e){
			//throw new ExcecaoControlador(e.getMessage(), e); //o e.getMessage retornaria um "LeitorModelo já existente".
		//}
	}
	
	public LeitorModelo buscarLeitorModeloPorCpf(String cpf) throws ExcecaoControlador {
		
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
		
		//LeitorModelo LeitorModelo = new LeitorModelo();
		//try {
			//LeitorModelo = repositorio.buscarLeitorPorCpf(cpf); //Criar metodo buscarLeitorPorCpf na camada de dados.
			//return LeitorModelo;
		//}catch(ExcecaoDados e){
			//throw new ExcecaoControlador(e.getMessage(), e); // o e.getMessage retornaria um "LeitorModelo não encontrado".
		//}
		return null; //remover apos criação dos metodos acima.
	}
}
