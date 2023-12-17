package testesLivro;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import dados.ExcecaoDados;
import dados.LivroDados;
import modelos.LivroModelo;


@ExtendWith(MockitoExtension.class)
public class testeLivroControlador {

	LivroControlador controlador = new LivroControlador();

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
	public void cadastrarLivroPorIsbnComSucesso(@Mock LivroDados dadosMock, @Mock CloseableHttpClient httpClienteMock, @Mock CloseableHttpResponse httpResponseMock, @Mock HttpEntity httpEntityMock) throws ClientProtocolException, IOException {

		controlador.setHttpCliente(httpClienteMock);

		Mockito.lenient().when(httpClienteMock.execute(any(HttpGet.class))).thenReturn(httpResponseMock);
		Mockito.lenient().when(httpResponseMock.getEntity()).thenReturn(httpEntityMock);

		String api = "{\r\n"
				+ "  \"kind\": \"books#volumes\",\r\n"
				+ "  \"totalItems\": 1,\r\n"
				+ "  \"items\": [\r\n"
				+ "    {\r\n"
				+ "      \"kind\": \"books#volume\",\r\n"
				+ "      \"id\": \"aizjDQAAQBAJ\",\r\n"
				+ "      \"etag\": \"f4xeV0AncDA\",\r\n"
				+ "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/aizjDQAAQBAJ\",\r\n"
				+ "      \"volumeInfo\": {\r\n"
				+ "        \"title\": \"Mindset\",\r\n"
				+ "        \"subtitle\": \"A nova psicologia do sucesso\",\r\n"
				+ "        \"authors\": [\r\n"
				+ "          \"Carol Dweck\"\r\n"
				+ "        ],\r\n"
				+ "        \"publisher\": \"Objetiva\",\r\n"
				+ "        \"publishedDate\": \"2017-01-24\",\r\n"
				+ "        \"description\": \"Clássico da psicologia em versão revista e atualizada. Carol S. Dweck, professora de psicologia na Universidade Stanford e especialista internacional em sucesso e motivação, desenvolveu, ao longo de décadas de pesquisa, um conceito fundamental: a atitude mental com que encaramos a vida, que ela chama de \\\"mindset\\\", é crucial para o sucesso. Dweck revela de forma brilhante como o sucesso pode ser alcançado pela maneira como lidamos com nossos objetivos. O mindset não é um mero traço de personalidade, é a explicação de por que somos otimistas ou pessimistas, bem-sucedidos ou não. Ele define nossa relação com o trabalho e com as pessoas e a maneira como educamos nossos filhos. É um fator decisivo para que todo o nosso potencial seja explorado.\",\r\n"
				+ "        \"industryIdentifiers\": [\r\n"
				+ "          {\r\n"
				+ "            \"type\": \"ISBN_13\",\r\n"
				+ "            \"identifier\": \"9788543808246\"\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"type\": \"ISBN_10\",\r\n"
				+ "            \"identifier\": \"8543808243\"\r\n"
				+ "          }\r\n"
				+ "        ],\r\n"
				+ "        \"readingModes\": {\r\n"
				+ "          \"text\": true,\r\n"
				+ "          \"image\": true\r\n"
				+ "        },\r\n"
				+ "        \"pageCount\": 347,\r\n"
				+ "        \"printType\": \"BOOK\",\r\n"
				+ "        \"categories\": [\r\n"
				+ "          \"Psychology\"\r\n"
				+ "        ],\r\n"
				+ "        \"averageRating\": 4,\r\n"
				+ "        \"ratingsCount\": 1,\r\n"
				+ "        \"maturityRating\": \"NOT_MATURE\",\r\n"
				+ "        \"allowAnonLogging\": true,\r\n"
				+ "        \"contentVersion\": \"2.8.10.0.preview.3\",\r\n"
				+ "        \"panelizationSummary\": {\r\n"
				+ "          \"containsEpubBubbles\": false,\r\n"
				+ "          \"containsImageBubbles\": false\r\n"
				+ "        },\r\n"
				+ "        \"imageLinks\": {\r\n"
				+ "          \"smallThumbnail\": \"http://books.google.com/books/content?id=aizjDQAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\r\n"
				+ "          \"thumbnail\": \"http://books.google.com/books/content?id=aizjDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\r\n"
				+ "        },\r\n"
				+ "        \"language\": \"pt-BR\",\r\n"
				+ "        \"previewLink\": \"http://books.google.com.br/books?id=aizjDQAAQBAJ&printsec=frontcover&dq=isbn:9788543808246&hl=&cd=1&source=gbs_api\",\r\n"
				+ "        \"infoLink\": \"https://play.google.com/store/books/details?id=aizjDQAAQBAJ&source=gbs_api\",\r\n"
				+ "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=aizjDQAAQBAJ\"\r\n"
				+ "      },\r\n"
				+ "      \"saleInfo\": {\r\n"
				+ "        \"country\": \"BR\",\r\n"
				+ "        \"saleability\": \"FOR_SALE\",\r\n"
				+ "        \"isEbook\": true,\r\n"
				+ "        \"listPrice\": {\r\n"
				+ "          \"amount\": 29.9,\r\n"
				+ "          \"currencyCode\": \"BRL\"\r\n"
				+ "        },\r\n"
				+ "        \"retailPrice\": {\r\n"
				+ "          \"amount\": 29.9,\r\n"
				+ "          \"currencyCode\": \"BRL\"\r\n"
				+ "        },\r\n"
				+ "        \"buyLink\": \"https://play.google.com/store/books/details?id=aizjDQAAQBAJ&rdid=book-aizjDQAAQBAJ&rdot=1&source=gbs_api\",\r\n"
				+ "        \"offers\": [\r\n"
				+ "          {\r\n"
				+ "            \"finskyOfferType\": 1,\r\n"
				+ "            \"listPrice\": {\r\n"
				+ "              \"amountInMicros\": 29900000,\r\n"
				+ "              \"currencyCode\": \"BRL\"\r\n"
				+ "            },\r\n"
				+ "            \"retailPrice\": {\r\n"
				+ "              \"amountInMicros\": 29900000,\r\n"
				+ "              \"currencyCode\": \"BRL\"\r\n"
				+ "            },\r\n"
				+ "            \"giftable\": true\r\n"
				+ "          }\r\n"
				+ "        ]\r\n"
				+ "      },\r\n"
				+ "      \"accessInfo\": {\r\n"
				+ "        \"country\": \"BR\",\r\n"
				+ "        \"viewability\": \"PARTIAL\",\r\n"
				+ "        \"embeddable\": true,\r\n"
				+ "        \"publicDomain\": false,\r\n"
				+ "        \"textToSpeechPermission\": \"ALLOWED\",\r\n"
				+ "        \"epub\": {\r\n"
				+ "          \"isAvailable\": true,\r\n"
				+ "          \"acsTokenLink\": \"http://books.google.com.br/books/download/Mindset-sample-epub.acsm?id=aizjDQAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\r\n"
				+ "        },\r\n"
				+ "        \"pdf\": {\r\n"
				+ "          \"isAvailable\": true,\r\n"
				+ "          \"acsTokenLink\": \"http://books.google.com.br/books/download/Mindset-sample-pdf.acsm?id=aizjDQAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\r\n"
				+ "        },\r\n"
				+ "        \"webReaderLink\": \"http://play.google.com/books/reader?id=aizjDQAAQBAJ&hl=&source=gbs_api\",\r\n"
				+ "        \"accessViewStatus\": \"SAMPLE\",\r\n"
				+ "        \"quoteSharingAllowed\": false\r\n"
				+ "      },\r\n"
				+ "      \"searchInfo\": {\r\n"
				+ "        \"textSnippet\": \"O mindset não é um mero traço de personalidade, é a explicação de por que somos otimistas ou pessimistas, bem-sucedidos ou não.\"\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}\r\n"
				+ "";

		Mockito.lenient().when(httpEntityMock.getContent()).thenReturn(new ByteArrayInputStream(api.getBytes()));

		try {
			when(dadosMock.verificarLivro("9788543808246")).thenReturn(false);
			controlador.setDados(dadosMock);

			assertDoesNotThrow(() -> controlador.cadastrarLivroPorISBN("9788543808246", "2"));
		} catch (ExcecaoDados e3 ) {
			fail();
		}
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