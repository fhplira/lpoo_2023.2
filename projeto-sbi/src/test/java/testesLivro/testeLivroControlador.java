package testesLivro;

import static org.mockito.Mockito.when;

import java.io.IOException;
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
	
	

		@Test
		public void cadastrarLivroPorIsbnComSucesso(@Mock LivroDados dadosMock) throws ExcecaoControlador, IOException {
			LivroControlador controlador = new LivroControlador();
			controlador.setDados(dadosMock);
			
			try {
				 
				
				when(dadosMock.verificarLivro("0000000000000")).thenReturn(false);
				controlador.cadastrarLivroPorISBN("0000000000000");
				
			} catch (ExcecaoDados e) {
				 throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			
			
		}
	}

