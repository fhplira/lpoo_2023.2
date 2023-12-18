package controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dados.EmprestimoDados;
import dados.ExcecaoDados;
import dados.InterfaceEmprestimoDados;
import dados.InterfaceLeitorDados;
import dados.InterfaceLivroDados;
import dados.LeitorDados;
import dados.LivroDados;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

// Avisar Leitor (sobre a proximidade do final do emprestimo).

public class EmprestimoControlador {
	
	
	private InterfaceEmprestimoDados dados;
	private InterfaceLivroDados livroDados;
	private InterfaceLeitorDados leitorDados;
	
	public EmprestimoControlador() {
		this.dados = new EmprestimoDados();
		this.leitorDados = new LeitorDados();
		this.livroDados = new LivroDados();
	}

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
			
			EmprestimoModelo emprestimo = new EmprestimoModelo(isbn, cpf);
			
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
		
		//atualizarAtraso(emprestimo);
		
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
			EmprestimoModelo emprestimo = new EmprestimoModelo();
			//emprestimo = dados.buscarEmprestimo(cpf, isbn);
			//atualizarAtraso(emprestimo);
			//enviarEmailAviso(emprestimo);
			//atraso(emprestimo);
			emprestimo = dados.buscarEmprestimo(cpf, isbn);
			return emprestimo;
		}catch(ExcecaoDados e2) {
			throw new ExcecaoControlador(e2.getMessage(), e2);
		}
	
	}
	
	public void atraso(EmprestimoModelo emprestimo) throws ExcecaoControlador {
		try {
			atualizarAtraso(emprestimo);
			if(emprestimo.getDataAtual().isAfter(emprestimo.getDataDevolucao())) {
				if(dados.verificarAtraso(emprestimo)) {
					emailControlador.enviarEmailAtraso(emprestimo);
				}
			}
			
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	public void atualizarAtraso(EmprestimoModelo emprestimo) throws ExcecaoControlador {
		emprestimo.setDataAgora();
		try {
			if(emprestimo.getDataAtual().isAfter(emprestimo.getDataDevolucao())) {
					emprestimo.setDiasAtraso(emprestimo.duracaoDiasAtraso());
					dados.atualizarAtraso(emprestimo);
			}
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	
	public void enviarEmailAviso(EmprestimoModelo emprestimo) throws ExcecaoControlador {
		emprestimo.setDataAgora();
		emprestimo.setDataAvisarLeitor();
		try {
			if(emprestimo.getDataAtual().equals(emprestimo.getDataAviso())) {
				emailControlador.enviarEmailAviso(emprestimo);
			}
		}catch(Exception e) {
			throw new ExcecaoControlador("Falha ao enviar Email Aviso", e);
		}
	}
	
	public void verificarEmprestimosIncial() throws ExcecaoControlador{
		try {
			List<EmprestimoModelo> emprestimos = new ArrayList<>();
			emprestimos = dados.buscarTodosEmprestimos();
			for(EmprestimoModelo emprestimo : emprestimos) {
				emprestimo = buscarEmprestimo(emprestimo.getCpf(), emprestimo.getIsbn());
				atraso(emprestimo);
				enviarEmailAviso(emprestimo);
			}
		}catch(ExcecaoDados e) {
			throw new ExcecaoControlador(e.getMessage(), e);
		}
	}
	
	public InterfaceEmprestimoDados getDados() {
		return dados;
	}

	public void setDados(InterfaceEmprestimoDados dados) {
		this.dados = dados;
	}

	public InterfaceLeitorDados getLeitorDados() {
		return leitorDados;
	}

	public void setLeitorDados(InterfaceLeitorDados leitorDados) {
		this.leitorDados = leitorDados;
	}

	public InterfaceLivroDados getLivroDados() {
		return livroDados;
	}

	public void setLivroDados(InterfaceLivroDados livroDados) {
		this.livroDados = livroDados;
	}
}
