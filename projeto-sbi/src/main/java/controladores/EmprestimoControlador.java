package controladores;

import java.util.ArrayList;
import java.util.List;

import dados.EmprestimoDados;
import dados.ExcecaoDados;
import dados.LeitorDados;
import dados.LivroDados;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

// Avisar Leitor (sobre a proximidade do final do emprestimo).

public class EmprestimoControlador {
	private EmprestimoDados dados = new EmprestimoDados();   
	private LeitorDados leitorDados = new LeitorDados();
	private LivroDados livroDados = new LivroDados();
	private LeitorControlador leitorControlador = new LeitorControlador();
	private LivroControlador livroControlador = new LivroControlador();
	
	public void realizarEmprestimo(String isbn, String cpf) throws ExcecaoControlador, ExcecaoDados {
			
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
			
			LeitorModelo leitor = new LeitorModelo();
			leitor = leitorControlador.buscarLeitorPorCpf(cpf);
			
			LivroModelo livro = new LivroModelo();
			livro = livroControlador.buscarLivroPorIsbn(isbn);
			
			if(leitor.getEmprestimo() >= 2) {
				throw new ExcecaoControlador("Número de emprestimos excedidos");
			}
			
			if(livro.getDisponivel() <= 0) {
				throw new ExcecaoControlador("Sem livros disponiveis para emprestimo");
			}
			
			try {
				if(dados.verificarEmprestimo(cpf, isbn)) {
					throw new ExcecaoControlador("Este emprestimo já foi realizado para o leitor");
				}
			}catch(ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			try {
				dados.realizarEmprestimo(emprestimo);
				leitor.adicionarEmprestimo(1);
				leitorDados.adicionarEmprestimo(leitor);
				livro.setAdicionarEmprestado(1);
				livro.setRemoverDisponivel(1);
				livroDados.modificarExemplarFazerEmprestimo(livro);
			}
			catch(ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
		}
	
	public List<EmprestimoModelo> buscarTodosEmprestimos() throws ExcecaoControlador{
		try {
			List<EmprestimoModelo> emprestimos = new ArrayList<>();
			emprestimos = dados.buscarTodosEmprestimos();
			List<EmprestimoModelo> emprestimosAbertos = new ArrayList<>();
			for(EmprestimoModelo emprestimo : emprestimos) {
				if(!dados.verificarDevolucao(emprestimo)) {
					emprestimosAbertos.add(emprestimo);
				}
			}
			return emprestimosAbertos;
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	public void fazerDevolucao(EmprestimoModelo emprestimo) throws ExcecaoControlador {
		try {
			if(!dados.verificarEmprestimo(emprestimo.getCpf(), emprestimo.getIsbn())) {
				throw new ExcecaoControlador("Este emprestimo não existe");
			}
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
		
		if(emprestimo.isDevolvido()) {
			throw new ExcecaoControlador("Emprestimo já devolvido");
		}
		
		LeitorModelo leitor = new LeitorModelo();
		leitor = leitorControlador.buscarLeitorPorCpf(emprestimo.getCpf());
		
		LivroModelo livro = new LivroModelo();
		livro = livroControlador.buscarLivroPorIsbn(emprestimo.getIsbn());
		
		try {
			emprestimo.setDevolvido(true);
			dados.fazerDevolucao(emprestimo);
			leitor.removerEmprestimo(1);
			livro.setRemoverEmprestado(1);
			livro.setAdicionarDisponivel(1);
			livroDados.modificarExemplarFinalizarEmprestimo(livro);
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	public EmprestimoModelo buscarEmprestimo(String cpf, String isbn) throws ExcecaoControlador {
		try {
			return dados.buscarEmprestimo(cpf, isbn);
		}catch(ExcecaoDados e2) {
			throw new ExcecaoControlador(e2.getMessage(), e2);
		}
	
	}
}
