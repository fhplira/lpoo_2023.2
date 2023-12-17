package dados;

import java.util.List;

import modelos.LeitorModelo;

public interface InterfaceLeitorDados {
	
	public void cadastrarLeitor(LeitorModelo leitor) throws ExcecaoDados;
	
	public void atualizarNomeLeitor(LeitorModelo leitor) throws ExcecaoDados;
	
	public void atualizarEmailLeitor(LeitorModelo leitor) throws ExcecaoDados;
	
	public boolean verificarLeitor(String cpf) throws ExcecaoDados;
	
	public LeitorModelo buscarLeitorPorCpf(String cpf) throws ExcecaoDados;
	
	public void adicionarEmprestimo(LeitorModelo leitor) throws ExcecaoDados;
	
	public void removerEmprestimo(LeitorModelo leitor) throws ExcecaoDados;
	
	public void deletarLeitorPorCpf(String cpf) throws ExcecaoDados;
	
	public List<LeitorModelo> buscarTodosLeitores() throws ExcecaoDados;
	
	
}
