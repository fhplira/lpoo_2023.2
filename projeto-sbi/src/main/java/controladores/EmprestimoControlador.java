package controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private AplicacaoEmail emailControlador = new AplicacaoEmail();
	
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
				if(dados.verificarEmprestimo(cpf, isbn ) && !dados.verificarDevolucao(emprestimo)) {
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
				emprestimo = dados.buscarEmprestimo(cpf, isbn);
				emailControlador.enviarEmailEmprestimo(emprestimo);
			}
			catch(ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
		}
	
	public List<EmprestimoModelo> buscarTodosEmprestimos() throws ExcecaoControlador{
			try {
				return dados.buscarTodosEmprestimos();
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
			leitorDados.removerEmprestimo(leitor);
			livroDados.modificarExemplarFinalizarEmprestimo(livro);
			emailControlador.enviarEmailDevolucao(emprestimo);
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
	
	public EmprestimoDados getDados() {
		return dados;
	}

	public void setDados(EmprestimoDados dados) {
		this.dados = dados;
	}

	public LeitorDados getLeitorDados() {
		return leitorDados;
	}

	public void setLeitorDados(LeitorDados leitorDados) {
		this.leitorDados = leitorDados;
	}

	public LivroDados getLivroDados() {
		return livroDados;
	}

	public void setLivroDados(LivroDados livroDados) {
		this.livroDados = livroDados;
	}
}
