package testesEmprestimo;

import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	
	EmprestimoControlador controladorEmprestimo = new EmprestimoControlador();
	LeitorControlador controladorLeitor = new LeitorControlador();
	LivroControlador controladorLivro = new LivroControlador();
	
	@Test
	public void RealizarEmprestimoComSucesso(@Mock LivroDados dadosLivroMock, @Mock LeitorDados dadosLeitorMock, @Mock EmprestimoDados dadosEmprestimoMock ) {
		
		controladorEmprestimo.setDados(dadosEmprestimoMock);
		controladorLeitor.setDados(dadosLeitorMock);
		controladorLivro.setDados(dadosLivroMock);
		
		try {
			controladorEmprestimo.realizarEmprestimo("1111111111", "00000000000");
		} catch (ExcecaoControlador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void BuscarEmprestimoComSucesso(@Mock EmprestimoDados dadosEmprestimoMock) throws ExcecaoDados, ExcecaoControlador {
		EmprestimoModelo emprestimo = new EmprestimoModelo();
		controladorEmprestimo.setDados(dadosEmprestimoMock);
	
		
	
		when(dadosEmprestimoMock.buscarEmprestimo("11111111111", "0000000000")).thenReturn(emprestimo);
		controladorEmprestimo.buscarEmprestimo("11111111111", "0000000000");
		
	}
	
	

}
