package testesLivro;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
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
		public void falhaAoExcluirexemplaresQuantidadeZero() {
			LivroModelo livro = new LivroModelo();
			livro.setIsbn("1234567890123");
			livro.setDisponivel(1);
			livro.setTotal(0);

			String controleExemplar = "2";
			Assertions.assertThrows(ExcecaoControlador.class, () -> {controlador.ExcluirExemplares(livro, controleExemplar);});	
		}
		
		
		
		
		
}