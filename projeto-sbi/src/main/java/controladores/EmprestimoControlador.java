package controladores;

import dados.EmprestimoDados;
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
	private EmprestimoDados dados = new EmprestimoDados();   
	private LeitorDados leitorDados = new LeitorDados();
	private LivroDados livroDados = new LivroDados();
	
	public void realizarEmprestimo(String isbn, String cpf) throws ExcecaoControlador {
			
			try {
				if(!leitorDados.verificarLeitor(cpf)) {
					throw new ExcecaoControlador("Leitor não Existe");
				}
			}catch(ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			try {
				if(!livroDados.verificarLivro(isbn)) {
					throw new ExcecaoControlador("Livro não Existe");
				}
			}catch(ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			EmprestimoModelo emprestimo = new EmprestimoModelo();
			emprestimo.setIsbn(isbn);
			emprestimo.setCpf(cpf);
			
			
			try {
				dados.realizarEmprestimo(emprestimo);
			}
			catch(ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
		}
		
	
	public EmprestimoModelo fazerDevolucao(LivroModelo livro, LeitorModelo leitor) throws ExcecaoControlador {
		
		return null;
	}
}
