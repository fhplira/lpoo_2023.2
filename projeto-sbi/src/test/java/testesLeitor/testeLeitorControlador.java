package testesLeitor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import controladores.AplicacaoEmail;
import controladores.ExcecaoControlador;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import dados.InterfaceLeitorDados;
import modelos.LeitorModelo;
import controladores.LeitorControlador;

@ExtendWith(MockitoExtension.class)
public class TesteLeitorControlador {

	@Mock
	private InterfaceLeitorDados dadosMock;

	@Mock
	private AplicacaoEmail emailControladorMock;

	@InjectMocks
	private LeitorControlador leitorControlador;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		emailControladorMock = new AplicacaoEmail();
		leitorControlador = new LeitorControlador();
	}

	@Test
	public void cadastrarLeitorComSucesso() throws Exception {

		String nome = "João Silva";
		String cpf = "12345678901";
		String email = "joao.silva@example.com";


		when(dadosMock.verificarLeitor(cpf)).thenReturn(false);


		leitorControlador.cadastrarLeitor(nome, cpf, email);


		verify(dadosMock).verificarLeitor(cpf);
		verify(dadosMock).cadastrarLeitor(any(LeitorModelo.class));
		verify(emailControladorMock).enviarEmailCadastro(any(LeitorModelo.class));
	}

	@Test
	public void buscarLeitorExistentePorCpf() throws Exception {
		
		String cpf = "12345678901";
		LeitorModelo leitorExistente = new LeitorModelo("João Silva", cpf, "joao.silva@example.com");

		when(dadosMock.verificarLeitor(cpf)).thenReturn(true);
		when(dadosMock.buscarLeitorPorCpf(cpf)).thenReturn(leitorExistente);

		LeitorModelo leitorObtido = leitorControlador.buscarLeitorPorCpf(cpf);

		assertEquals(leitorExistente, leitorObtido);
		verify(dadosMock).verificarLeitor(cpf);
		verify(dadosMock).buscarLeitorPorCpf(cpf);
	}

	@Test
	public void buscarLeitorNaoExistentePorCpf() throws Exception {
		
		String cpf = "12345678901";

		when(dadosMock.verificarLeitor(cpf)).thenReturn(false);

		Assertions.assertThrows(ExcecaoControlador.class, () -> {leitorControlador.buscarLeitorPorCpf(cpf);});
	}

	@Test
	public void preencherOCampoDeCpfIncorretamenteNoCadastro() throws Exception {
		
		String cpf = "aaaaaaaaaaa";
		
		when(dadosMock.verificarLeitor(cpf)).thenReturn(false);
		
		Assertions.assertThrows(ExcecaoControlador.class, () -> {leitorControlador.buscarLeitorPorCpf(cpf);});
		
	}
	
	@Test
	public void atualizarEmailLeitorComSucesso() throws Exception {
		
		String cpf = "12345678901";
		String novoEmail = "novo.email@example.com";
		LeitorModelo leitor = new LeitorModelo("João Silva", cpf, "joao.silva@example.com");

		doNothing().when(dadosMock).atualizarEmailLeitor(leitor);
		doNothing().when(emailControladorMock).enviarEmailAtualizarDados(leitor);

		leitorControlador.atualizarEmailLeitor(leitor, novoEmail);

		assertEquals(novoEmail, leitor.getEmail());
		verify(dadosMock).atualizarEmailLeitor(leitor);
		verify(emailControladorMock).enviarEmailAtualizarDados(leitor);
	}

	@Test
	public void atualizarNomeLeitorComSucesso() throws Exception {
		
		String cpf = "12345678901";
		String novoNome = "João Pereira";
		LeitorModelo leitor = new LeitorModelo("João Silva", cpf, "joao.silva@example.com");

		doNothing().when(dadosMock).atualizarNomeLeitor(leitor);

		leitorControlador.atualizarNomeLeitor(leitor, novoNome);

		assertEquals(novoNome, leitor.getNome());
		verify(dadosMock).atualizarNomeLeitor(leitor);
	}


}