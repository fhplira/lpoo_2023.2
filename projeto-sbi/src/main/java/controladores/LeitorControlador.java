package controladores;

import java.util.List;

import dados.ExcecaoDados;
import dados.InterfaceLeitorDados;
import dados.LeitorDados;
import modelos.LeitorModelo;

public class LeitorControlador {
	
	private InterfaceLeitorDados dados;
	
	public LeitorControlador() {
		this.dados = new LeitorDados();
	}
	
	private AplicacaoEmail emailControlador = new AplicacaoEmail();
	
	public void cadastrarLeitor(String nome, String cpf, String email) throws ExcecaoControlador {
		
		try {
			if(dados.verificarLeitor(cpf)) {
				throw new ExcecaoControlador("Cpf já cadastrado no Sistema");
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
			emailControlador.enviarEmailCadastro(leitor);
		}catch(ExcecaoDados e){
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	public LeitorModelo buscarLeitorPorCpf(String cpf) throws ExcecaoControlador {
		
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
		
		LeitorModelo leitor = new LeitorModelo();
		try {
			leitor = dados.buscarLeitorPorCpf(cpf);
			return leitor;
		}catch(ExcecaoDados e){
			throw new ExcecaoControlador(e.getMessage(), e);
		}
		
	}
	
	public void atualizarNomeLeitor(LeitorModelo leitor, String nome) throws ExcecaoControlador {
		
		if(leitor.getNome().matches("[0-9]+")) {
			throw new ExcecaoControlador("O campo Nome não pode ter números");
		}
		
		try {
			if(!nome.equals(leitor.getNome())) {
				leitor.setNome(nome);
				dados.atualizarNomeLeitor(leitor);
			}
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	public void atualizarEmailLeitor(LeitorModelo leitor, String email) throws ExcecaoControlador {
		
		if(email.matches(".*\\s+.*")) {
			throw new ExcecaoControlador("O campo Email não pode ter espaço em branco");
		}
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.]+$")) {
			throw new ExcecaoControlador("Caracteres Invalidos digitados no campo Email");
		}
		
		try {
			if(!email.equals(leitor.getEmail())) {
				leitor.setEmail(email);
				dados.atualizarEmailLeitor(leitor);
				emailControlador.enviarEmailAtualizarDados(leitor);
			}
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	public List<LeitorModelo> buscarTodosLeitores() throws ExcecaoControlador{
		try {
			return dados.buscarTodosLeitores();
		}catch (ExcecaoDados e){
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}

	public InterfaceLeitorDados getDados() {
		return dados;
	}

	public void setDados(InterfaceLeitorDados dados) {
		this.dados = dados;
	}
	
	
}
