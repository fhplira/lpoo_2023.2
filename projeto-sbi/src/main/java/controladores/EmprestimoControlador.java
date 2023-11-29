package controladores;

import dados.ExcecaoDados;
import dados.LeitorDados;
import dados.LivroDados;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

//Remover todos os comentarios apos a criação da classe EmprestimoDados e seus Métodos.
//Próximas Adições Metodos: 1° Fazer Devolução;
// 2° Aplicar Multa em caso de atraso;
// e 3° Avisar Leitor (sobre a proximidade do final do emprestimo).

public class EmprestimoControlador {
	//private EmprestimoDados dados = new EmprestimoDados();   
	private LeitorDados leitorDados = new LeitorDados();
	
	public EmprestimoModelo fazerEmprestimo(String cpf, String isbn) throws ExcecaoControlador {
		
		try {
			if(!leitorDados.verificarLeitor(cpf)) {
				throw new ExcecaoControlador("Leitor não Existe");
			}
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
		
		//(fazer try catch de livros para verificar se exite; apenas quando metodo existir no controller de livro.)
		
		//EmprestimoModelo emprestimo = new EmprestimoModelo();
		
		//try {
			//emprestimo = Dados.criarEmprestimo(isbn, cpf);
			//return emprestimo;
		//}
		//catch(ExcecaoDados e) {
			//throw new ExcecaoControlador(e.getMessage(), e);
		//}
		return null; //retornando null temporariamente.
	}
	
	public EmprestimoModelo fazerDevolucao(LivroModelo livro, LeitorModelo leitor) throws ExcecaoControlador {
		
		return null;
	}
}
