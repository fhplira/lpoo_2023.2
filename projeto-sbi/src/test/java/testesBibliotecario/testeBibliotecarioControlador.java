package testesBibliotecario;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import controladores.BibliotecarioControlador;
import controladores.ExcecaoControlador;
import dados.BibliotecarioDados;

@RunWith(MockitoJUnitRunner.class)
public class testeBibliotecarioControlador {

    @InjectMocks
    private BibliotecarioControlador controlador;

    @Mock
    private BibliotecarioDados dadosMock;
    
    @BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		controlador = new BibliotecarioControlador();
		controlador.setDados(dadosMock);
	}

    @Test
    public void loginBibliotecarioComSucessoTest() throws Exception {
    	
    	when(dadosMock.verificarEmailBibliotecario("exemplo@gmail.com")).thenReturn(true);
        when(dadosMock.verificarSenha("exemplo@gmail.com", "senha123")).thenReturn(true);

        assertDoesNotThrow(() -> controlador.login("exemplo@gmail.com", "senha123"));
    }
    
    @Test
    public void falhaLoginEmailVazio() {
    	Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.login(" ", "senha123");});		
    }
    
    @Test
    public void falhaSenhaVazia() {
    	Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.login("exemplo@gmail.com", " ");});		
    }
    
    @Test
    public void falhaLoginEmailNulo() {
    	Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.login("", "senha123");});		
    }
    
    @Test
    public void falhaSenhaNula() {
    	Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.login("exemplo@gmail.com", "");});		
    }
    
    @Test
    public void falhaEmailSemCaractere() {
    	Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.login("exemplo", "senha123");});		
    }
    
    @Test
    public void falhaSenhaPequena() {
    	Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.login("exemplo", "sen");});		
    }
    
    @Test
    public void falhaSenhaIncorreta() {
    	Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.login("exemplo@gmail.com", "senha12");});		
    }
    
    @Test
    public void falhaEmailIncorreto() {
    	Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.login("exemplo123@gmail.com", "senha12");});		
    }
   
}
