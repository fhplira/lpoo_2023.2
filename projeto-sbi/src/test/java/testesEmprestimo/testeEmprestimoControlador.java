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
	public void RealizarEmprestimoComSucesso() {
		
		 LivroDados dadosLivroMock = Mockito.mock(LivroDados.class);
	     LeitorDados dadosLeitorMock = Mockito.mock(LeitorDados.class);
	     EmprestimoDados dadosEmprestimoMock = Mockito.mock(EmprestimoDados.class);
	     LivroModelo livro = new LivroModelo();
	     LeitorModelo leitor = new LeitorModelo();
		
		controladorEmprestimo.setDados(dadosEmprestimoMock);
		controladorEmprestimo.setLeitorDados(dadosLeitorMock);
		controladorEmprestimo.setLivroDados(dadosLivroMock);
		controladorLivro.setDados(dadosLivroMock);
		controladorLeitor.setDados(dadosLeitorMock);
		
		
		
		
		try {
			when(dadosLivroMock.verificarLivro("0000000000")).thenReturn(true);
			when(controladorLeitor.buscarLeitorPorCpf("00000000000")).thenReturn(leitor);
			when(controladorLivro.buscarLivroPorIsbn("00000000000")).thenReturn(livro);
			when(dadosEmprestimoMock.verificarEmprestimo("00000000000", "0000000000")).thenReturn(false);
			when(dadosLeitorMock.buscarLeitorPorCpf("00000000000")).thenReturn(leitor);
			when(dadosLivroMock.buscarLivroPorIsbn("0000000000")).thenReturn(livro);
			controladorEmprestimo.realizarEmprestimo("0000000000", "00000000000");
			
		} catch (ExcecaoControlador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test 
	public void BuscarEmprestimoComSucesso() throws ExcecaoDados, ExcecaoControlador {
		EmprestimoDados dadosEmprestimoMock = Mockito.mock(EmprestimoDados.class);
		EmprestimoModelo emprestimo = new EmprestimoModelo();
		controladorEmprestimo.setDados(dadosEmprestimoMock);
	
		
	
		when(dadosEmprestimoMock.buscarEmprestimo("11111111111", "0000000000")).thenReturn(emprestimo);
		controladorEmprestimo.buscarEmprestimo("11111111111", "0000000000");
		
	}
	
	

}
