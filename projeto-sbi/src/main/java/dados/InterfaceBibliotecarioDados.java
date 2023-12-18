package dados;

public interface InterfaceBibliotecarioDados {

	public boolean verificarNomeBibliotecario(String nome) throws Exception;
	
	public boolean verificarEmailBibliotecario(String email) throws Exception;
	
	public boolean verificarSenha(String email, String senha) throws Exception;
}
