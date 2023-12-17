package testesLivro;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import dados.ExcecaoDados;
import dados.LivroDados;


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
		public void FalhaLivroJaCadastrado(@Mock LivroDados dadosMock) {
			
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
		public void FalhaCadastrarLivroManualmenteIsbnNulo() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteIsbnVazio() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("  ", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteIsbnNumeroDeCaracteresAMais() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("12345678912312", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteIsbnNumeroDeCaracteresAMenos() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteIsbnComLetras() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("12345678aa", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteTituloNulo() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteTituloVazio() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "  ", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		
		@Test
		public void FalhaCadastrarLivroManualmenteAutorNulo() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteAutorVazio() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "  ", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteAutorComNumeros() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "123", "editoraTeste", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteEditoraNulo() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteEditoraVazio() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "    ", "2000", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteDataNulo() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteDataVazio() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "    ", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteDataformatacaoAnoIncorreta() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "202", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteDataformatacaoIncorreta() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "155/02/2023", "imagem.png", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteImgNulo() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteImgVazia() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "   ", "testeDescricao", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteDescricaoNulo() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteDescricaoVazio() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "    ", "2");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteControleExemplarNulo() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteControleExemplarVazio() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "   ");});	
		}
		
		@Test
		public void FalhaCadastrarLivroManualmenteControleExemplarComLetra() {
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.cadastrarLivro("123456789", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao", "a2");});	
		}
}