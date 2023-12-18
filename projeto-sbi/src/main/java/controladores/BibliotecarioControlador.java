package controladores;

import dados.BibliotecarioDados;
import dados.ExcecaoDados;
import dados.InterfaceBibliotecarioDados;

public class BibliotecarioControlador {
	
	private InterfaceBibliotecarioDados dados;
	
	public BibliotecarioControlador() {
		this.dados = new BibliotecarioDados();
	}
	

	public void login(String email, String senha) throws Exception, ExcecaoControlador {
		
		
		if(email.isBlank()) {
			throw new ExcecaoControlador("O campo email não pode ser vazio.");
		}
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.]+$")) {
			throw new ExcecaoControlador("Caracteres Invalidos digitados no campo Email.");
		}
		
		if(senha.isBlank()) {
			throw new ExcecaoControlador("O campo senha não pode ser vazio.");
		}
		
		
		if(!dados.verificarEmailBibliotecario(email)) {
			throw new ExcecaoControlador("Email de usuário não encontrado.");
		}
		
		if(!dados.verificarSenha(email, senha)) {
			throw new ExcecaoControlador("Senha incorreta.");
		}
		
	}


	public InterfaceBibliotecarioDados getDados() {
		return dados;
	}


	public void setDados(InterfaceBibliotecarioDados dados) {
		this.dados = dados;
	}
	
}
