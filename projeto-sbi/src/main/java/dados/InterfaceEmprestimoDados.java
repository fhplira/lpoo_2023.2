package dados;

import java.util.List;

import modelos.EmprestimoModelo;

public interface InterfaceEmprestimoDados {
	
	public void realizarEmprestimo(EmprestimoModelo emprestimo) throws ExcecaoDados;
	
	public boolean verificarEmprestimo(String cpf, String isbn) throws ExcecaoDados;
	
	public EmprestimoModelo buscarEmprestimo(String cpf, String isbn) throws ExcecaoDados;
	
	public boolean verificarDevolucao(EmprestimoModelo emprestimo) throws ExcecaoDados;
	
	public List<EmprestimoModelo> buscarTodosEmprestimos() throws ExcecaoDados;
	
	public void fazerDevolucao(EmprestimoModelo emprestimo) throws ExcecaoDados;
	
	public boolean verificarAtraso(EmprestimoModelo emprestimo) throws ExcecaoDados;
	
	public void atualizarAtraso(EmprestimoModelo emprestimo) throws ExcecaoDados;
}
