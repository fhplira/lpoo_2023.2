package testesEmprestimo;

import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import controladores.EmprestimoControlador;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import controladores.LivroControlador;
import dados.EmprestimoDados;
import dados.ExcecaoDados;
import dados.LeitorDados;
import dados.LivroDados;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

@ExtendWith(MockitoExtension.class)
public class testeEmprestimoControlador {
	
	@Test
	public void RealizarEmprestimoComSucesso(@Mock LivroDados dadosLivroMock, @Mock LeitorDados dadosLeitorMock, @Mock EmprestimoDados dadosEmprestimoMock, @Mock LivroModelo livroMock, @Mock LeitorModelo leitorMock) {
		EmprestimoControlador controladorEmprestimo = new EmprestimoControlador();
		
		LeitorControlador controladorLeitor = new LeitorControlador();
		LivroControlador controladorLivro = new LivroControlador();
		
		controladorEmprestimo.setDados(dadosEmprestimoMock);
		controladorEmprestimo.setLeitorDados(dadosLeitorMock);
		controladorEmprestimo.setLivroDados(dadosLivroMock);
		
		
		livroMock.setIsbn("00000000000");
		leitorMock.setCpf("00000000000");
		
		try {
			when(dadosLivroMock.verificarLivro("00000000000")).thenReturn(true);
			when(dadosEmprestimoMock.verificarEmprestimo("00000000000", "00000000000")).thenReturn(false);
			when(controladorLeitor.buscarLeitorPorCpf("00000000000")).thenReturn(leitorMock);
			when(controladorLivro.buscarLivroPorIsbn("00000000000")).thenReturn(livroMock);
			controladorEmprestimo.realizarEmprestimo("00000000000", "00000000000");
			
		} catch (ExcecaoControlador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test 
	public void BuscarEmprestimoComSucesso(@Mock EmprestimoDados dadosEmprestimoMock) {
		EmprestimoModelo emprestimo = new EmprestimoModelo("00000000000","00000000000");
		
		try {
			dadosEmprestimoMock.buscarEmprestimo("00000000000","00000000000");
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
