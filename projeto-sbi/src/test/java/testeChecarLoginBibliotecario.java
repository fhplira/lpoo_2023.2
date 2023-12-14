import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import controladores.BibliotecarioControlador;
import controladores.ExcecaoControlador;

public class testeChecarLoginBibliotecario {
	
	@Test
	public void testLogin() {
		
		BibliotecarioControlador bibliotecario = new BibliotecarioControlador();
		Assertions.assertThrows(ExcecaoControlador.class, 
				() -> {bibliotecario.login("bruno.cartaxo@paulista.ifpe.edu.br", "12345");});
		
	}

}
