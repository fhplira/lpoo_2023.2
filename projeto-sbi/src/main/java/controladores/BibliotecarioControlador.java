package controladores;

import dados.BibliotecarioDados;
import dados.ExcecaoDados;

public class BibliotecarioControlador {
	
	private BibliotecarioDados dados = new BibliotecarioDados();

	public void login(String email, String senha) throws ExcecaoControlador {
		
		if(email.isBlank()) {
			throw new ExcecaoControlador("O campo email não pode ser vazio.");
		}
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.]+$")) {
			throw new ExcecaoControlador("Caracteres Invalidos digitados no campo Email");
		}
		
		if(senha.isBlank()) {
			throw new ExcecaoControlador("O campo senha não pode ser vazio.");
		}
		
		try {
			dados.verificarEmailBibliotecario(email);
					
		}catch(ExcecaoDados e) {
			 throw new ExcecaoControlador(e.getMessage(), e);
		}
		
		
		try {
			dados.verificarEmailBibliotecario(senha);
					
		}catch(ExcecaoDados e) {
			 throw new ExcecaoControlador(e.getMessage(), e);
		}
		
	}
}
