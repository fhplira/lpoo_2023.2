package testesLivro;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
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
				controlador.cadastrarLivro("1111111111111", "tituloTeste", "autorTeste", "editoraTeste", "2000", "imagem.png", "testeDescricao");	
			} catch (ExcecaoDados  | ExcecaoControlador e2 ) {
				fail();
			}
		}
}