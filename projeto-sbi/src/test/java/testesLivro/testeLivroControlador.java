package testesLivro;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import dados.InterfaceLivroDados;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import dados.ExcecaoDados;
import dados.LivroDados;
import modelos.LivroModelo;


@ExtendWith(MockitoExtension.class)
public class testeLivroControlador {

	@Mock
	private InterfaceLivroDados dadosMock;

	@InjectMocks
	private LivroControlador livroControlador;

	@Mock
	private LivroModelo livroMock;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		controlador = new LivroControlador();
		controlador.setDados(dadosMock);
	}

	LivroControlador controlador = new LivroControlador();



	@Test
	void cadastrarLivroPorIsbnComSucesso() throws Exception {
		// Configuração
		String isbn = "1234567890";
		String exemplares = "5";
		LivroModelo livroMock = new LivroModelo();
		livroMock.setIsbn(isbn);
		livroMock.setTitulo("Teste Livro");
		livroMock.setAdicionarDisponivel(Integer.parseInt(exemplares));
		livroMock.setEmprestado(0);
		livroMock.setValorTotal();

		// Simulando o comportamento do método buscarLivroApi
		LivroControlador spyControlador = spy(controlador);
		doReturn(livroMock).when(spyControlador).buscarLivroApi(isbn);

		// Ação
		spyControlador.cadastrarLivroPorISBN(isbn, exemplares);

		// Verificação
		verify(dadosMock, times(1)).cadastrarLivro(livroMock);
	}

	@Test
	public void cadastrarLivroManualmenteComSucesso(@Mock LivroDados dadosMock) {

		controlador.setDados(dadosMock);

		try {
			when(dadosMock.verificarLivro("1111111111111")).thenReturn(false);	
			controlador.cadastrarLivro("1111111111111", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");	
		} catch (ExcecaoDados  | ExcecaoControlador e2 ) {
			fail();
		}
	}


	@Test
	public void falhaLivroJaCadastrado(@Mock LivroDados dadosMock) {

		try {
			when(dadosMock.verificarLivro("1111111111111")).thenReturn(true);
		} catch (ExcecaoDados e) {
			fail();
		}	
		controlador.setDados(dadosMock);

		Assertions.assertThrows(ExcecaoControlador.class, 
				() -> {controlador.cadastrarLivro("1111111111111", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});				
	}


	@Test
	public void falhaCadastrarLivroManualmenteIsbnNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteIsbnVazio() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("  ", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteIsbnNumeroDeCaracteresAMais() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("12345678912312", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteIsbnNumeroDeCaracteresAMenos() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteIsbnComLetras() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("12345678aa", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteTituloNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteTituloVazio() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "  ", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteAutorNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteAutorVazio() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "  ", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteAutorComNumeros() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "123", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteEditoraNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteEditoraVazio() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "    ", "2000", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteDataNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteDataVazio() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "    ", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteDataformatacaoAnoIncorreta() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "202", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteDataformatacaoIncorreta() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "155/02/2023", "imagem.png", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteImgNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "2000", "", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteImgVazia() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "2000", "   ", "testeDescricao", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteDescricaoNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteDescricaoVazio() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "    ", "2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteControleExemplarNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteControleExemplarVazio() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "   ");});	
	}


	@Test
	public void falhaCadastrarLivroManualmenteControleExemplarComLetra() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "a2");});	
	}

	@Test
	public void falhaCadastrarLivroManualmenteControleExemplarMenorQueZero() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("1234567891234", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "-2");});	
	}


	@Test
	public void adicionarExemplaresComSucesso(@Mock LivroDados dadosMock) {
		controlador.setDados(dadosMock);

		try {
			LivroModelo livro = new LivroModelo();
			livro.setIsbn("1234567890123");

			String controleExemplar = "1";

			when(dadosMock.buscarLivroPorIsbn(anyString())).thenReturn(new LivroModelo());
			doNothing().when(dadosMock).acrescentarExemplarLivro(any(LivroModelo.class), anyInt());

			controlador.AdicionarExemplares(livro, controleExemplar);
		} catch (ExcecaoDados  | ExcecaoControlador e2 ) {
			fail();
		}
	}

	@Test
	public void falhaAoAdicionarExemplaresIsbnVazio() {
		LivroModelo livro = new LivroModelo();
		livro.setIsbn("");
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.AdicionarExemplares(livro, "2");});	
	}

	@Test
	public void falhaAoAdicionarExemplaresQuantidadeVazia() {
		LivroModelo livro = new LivroModelo();
		livro.setIsbn("1111111111111");
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.AdicionarExemplares(livro, "");});	
	}

	@Test
	public void falhaAoAdicionarExemplaresQuantidadeNegativa() {
		LivroModelo livro = new LivroModelo();
		livro.setIsbn("1111111111111");
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.AdicionarExemplares(livro, "-1");});	
	}

	@Test
	public void falhaAoAdicionarExemplaresQuantidadeComLetra() {
		LivroModelo livro = new LivroModelo();
		livro.setIsbn("1111111111111");
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.AdicionarExemplares(livro, "a1");});	
	}

	@Test
	public void falhaAoAdicionarExemplaresQuantidadeZero() {
		LivroModelo livro = new LivroModelo();
		livro.setIsbn("1111111111111");
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.AdicionarExemplares(livro, "0");});	
	}



	@Test
	public void excluirExemplaresComSucesso(@Mock LivroDados dadosMock) {
		controlador.setDados(dadosMock);

		try {
			LivroModelo livro = new LivroModelo();
			livro.setIsbn("1234567890123");
			livro.setDisponivel(1);
			livro.setTotal(2);

			String controleExemplar = "1";

			when(dadosMock.buscarLivroPorIsbn(anyString())).thenReturn(new LivroModelo());
			doNothing().when(dadosMock).deletarExemplarLivro(any(LivroModelo.class), anyInt());  

			controlador.ExcluirExemplares(livro, controleExemplar); 
		} catch (ExcecaoDados  | ExcecaoControlador e2 ) {
			fail();
		}
	}

	@Test
	public void falhaAoExcluirexemplaresNenhumLivroDisponivel() {
		LivroModelo livro = new LivroModelo();
		livro.setIsbn("1234567890123");
		livro.setDisponivel(0);
		livro.setTotal(2);

		String controleExemplar = "1";
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.ExcluirExemplares(livro, controleExemplar);});	
	}


	@Test
	public void falhaAoExcluirexemplaresQuantidadeMaiorQueTotal() {
		LivroModelo livro = new LivroModelo();
		livro.setIsbn("1234567890123");
		livro.setDisponivel(1);
		livro.setTotal(1);

		String controleExemplar = "3";
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.ExcluirExemplares(livro, controleExemplar);});	
	}

	@Test
	public void falhaAoExcluirExemplaresQuantidadeZero() {
		LivroModelo livro = new LivroModelo();
		livro.setIsbn("1234567890123");
		livro.setDisponivel(1);
		livro.setTotal(0);

		String controleExemplar = "2";
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.ExcluirExemplares(livro, controleExemplar);});	
	}
	
	@Test
	public void falhaAoCadastrarLivroPorIsbn(@Mock LivroDados dadosMock, @Mock CloseableHttpClient httpClienteMock, @Mock CloseableHttpResponse httpResponseMock, @Mock HttpEntity httpEntityMock) throws ClientProtocolException, IOException {

		controlador.setHttpCliente(httpClienteMock);

		Mockito.lenient().when(httpClienteMock.execute(any(HttpGet.class))).thenReturn(httpResponseMock);

		Mockito.lenient().when(httpResponseMock.getEntity()).thenReturn(httpEntityMock);


		String api = "{\r\n"
				+ "  \"kind\": \"books#volumes\",\r\n"
				+ "  \"totalItems\": 0\r\n"
				+ "}";

		Mockito.lenient().when(httpEntityMock.getContent()).thenReturn(new ByteArrayInputStream(api.getBytes()));

		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivroPorISBN("9788504020267", "2");});	
	}
	
	
	@Test
	public void falhaAoCadastrarLivroPorIsbnJaExistente(@Mock LivroDados dadosMock) {
		try {
			when(dadosMock.verificarLivro("1111111111111")).thenReturn(true);
		} catch (ExcecaoDados e) {
			fail();
		}	
		controlador.setDados(dadosMock);

		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivroPorISBN("1111111111111", "2");});	
	}
	
	@Test
	public void falhaAoCadastrarLivroPorIsbnVazio() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivroPorISBN("", "2");});	
	}

	@Test
	public void falhaAoCadastrarLivroPorIsbnComLetras() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivroPorISBN("1111111111a1a", "2");});	
	}

	@Test
	public void falhaAoAdicionarLivroPorIsbnNumeroDeCaracteresAMais() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivroPorISBN("11111111111111", "2");});		
	}

	@Test
	public void falhaAoAdicionarLivroPorIsbnNumeroDeCaracteresAMenos() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivroPorISBN("111111111", "2");});		
	}

	@Test
	public void falhaAoAdicionarLivroPorIsbnExemplaresNulo() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivroPorISBN("1111111111111", "");});		
	}

	@Test
	public void falhaAoAdicionarLivroPorIsbnExemplaresComLetras() {
		Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivroPorISBN("1111111111111", "2a");});		
	}

	@Test
	public void buscarTodosOsLivrosComSucesso(@Mock LivroDados dadosMock) {
		controlador.setDados(dadosMock);
		
		 List<LivroModelo> livrosMock = Arrays.asList(new LivroModelo("1111111111111", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao"), new LivroModelo("2222222222222", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao"));				
	        try {
				when(dadosMock.buscarTodosOsLivros()).thenReturn(livrosMock);
				List<LivroModelo> resultado = controlador.buscarTodosOsLivros();
			} catch (ExcecaoDados | ExcecaoControlador e) {
				fail();
			}		
	}
	
	@Test
	public void buscarLivroPorIsbnComSucesso(@Mock LivroDados dadosMock) {
		controlador.setDados(dadosMock);
				
		LivroModelo livroMock = new LivroModelo();
	        try {
				when(dadosMock.buscarLivroPorIsbn("1111111111111")).thenReturn(livroMock);
				LivroModelo resultado = controlador.buscarLivroPorIsbn("1111111111111");
			} catch (ExcecaoDados | ExcecaoControlador e) {
				fail();
			}		
	}

	
	@Test
	public void buscarLivroPorIsbnNulo() {		
	        Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.buscarLivroPorIsbn("");});		
	}
	
	@Test
	public void buscarLivroPorIsbnVazio() {		
	        Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.buscarLivroPorIsbn("    ");});		
	}
	
	@Test
	public void buscarLivroPorIsbnComLetra() {		
	        Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.buscarLivroPorIsbn("4758444a");});		
	}
	
	@Test
	public void buscarLivroPorIsbnComNumeroDeCaracteresAMais() {		
	        Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.buscarLivroPorIsbn("123456789123456");});		
	}
	
	@Test
	public void buscarLivroPorIsbnComNumeroDeCaracteresAMenos() {		
	        Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.buscarLivroPorIsbn("123456789");});		
	}
	
	@Test
	public void buscarLivroPorTituloComSucesso(@Mock LivroDados dadosMock) {
		controlador.setDados(dadosMock);
				
		LivroModelo livroMock = new LivroModelo();
	        try {
				when(dadosMock.buscarLivroPorTitulo("A caverna")).thenReturn(livroMock);
				livroMock = controlador.buscarLivroPorTitulo("A caverna");
			} catch (ExcecaoDados | ExcecaoControlador e) {
				fail();
			}		
	        
	    

	}
	
	@Test
	public void buscarLivroPorTituloNulo() {		
	        Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.buscarLivroPorTitulo("");});		
	}
	
	@Test
	public void buscarLivroPorTituloVazio() {		
	        Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.buscarLivroPorTitulo("    ");});		
	}
}