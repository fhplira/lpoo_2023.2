package testesLeitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import controladores.AplicacaoEmail;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import dados.ExcecaoDados;
import dados.InterfaceLeitorDados;
import modelos.LeitorModelo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class testeLeitorControlador {

	private LeitorControlador leitorControladorMock;

	@Mock
	private InterfaceLeitorDados dadosMock;

	@Mock
	private AplicacaoEmail emailControladorMock;

	@Mock
	private LeitorModelo leitorModeloMock;



	@Test
	public void testeCadastrarLeitorComSucesso(@Mock String nome, @Mock String cpf, @Mock String email) {
		// Arrange
		
		/*
		 * nome = "Joaozinho"; cpf = "12345678901"; email = "joaozinho@example.com";
		 */

	    //leitorModelo = new LeitorModelo(nome, cpf, email);
		
		
		/*
		 * try { leitorControlador.cadastrarLeitor(nome, cpf, email); } catch
		 * (ExcecaoControlador e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		//dadosMock.cadastrarLeitor(leitorModelo);


		try {
			when(dadosMock.verificarLeitor(cpf)).thenReturn(false);
			//leitorControlador.cadastrarLeitor(nome, cpf, email);
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//leitorControlador.cadastrarLeitor(nome, cpf, email);
		//when(dadosMock.cadastrarLeitor(any(LeitorModelo.class))).thenReturn(true);

		// Act


		// Assert
		try {
			verify(dadosMock).verificarLeitor(cpf);
			//verify(dadosMock).cadastrarLeitor(leitorModelo);
			//verify(emailControladorMock).enviarEmailCadastro(leitorModelo);
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


	}
	
	@Test
	public void cadastrarLeitorComSucesso(@Mock InterfaceLeitorDados dadosMock, @Mock String nome, @Mock String cpf, @Mock String email) throws ExcecaoControlador, ExcecaoDados {
		
		leitorControladorMock = new LeitorControlador();
		emailControladorMock = new AplicacaoEmail();
		leitorModeloMock = new LeitorModelo(nome, cpf, email);
		leitorControladorMock.setDados(dadosMock);
		
		Boolean verificacaoLeitor = dadosMock.verificarLeitor(cpf);
		
		when(verificacaoLeitor).thenReturn(false);
		
		leitorControladorMock.cadastrarLeitor(nome, cpf, email);
		emailControladorMock.enviarEmailCadastro(leitorModeloMock);
				
		
	}

}
