package dados;

import modelos.LivroModelo;
import java.util.List;

public interface InterfaceLivroDados {
	public void cadastrarLivro(LivroModelo livro) throws ExcecaoDados;
    
    public boolean verificarLivro(String isbn) throws ExcecaoDados;
    
    public void acrescentarExemplarLivro(LivroModelo livro, int exemplarASomar) throws ExcecaoDados;
    
    public void deletarExemplarLivro(LivroModelo livro, int exemplarASubtrair) throws ExcecaoDados;
    	  	
    public int buscarQuantidadeLivros(String isbn)throws ExcecaoDados;
    
    public List<LivroModelo> buscarTodosOsLivros() throws ExcecaoDados;
    
    public LivroModelo buscarLivroPorIsbn(String isbn) throws ExcecaoDados;
    
    public LivroModelo buscarLivroPorTitulo(String titulo)throws ExcecaoDados;
    
    public List<LivroModelo> buscarLivroPorAutor(String autor) throws ExcecaoDados;
    
    public LivroModelo buscarLivroPorTituloModelo(String titulo)throws ExcecaoDados;
    
    public void modificarExemplarFazerEmprestimo(LivroModelo livro)throws ExcecaoDados;
    
    public void modificarExemplarFinalizarEmprestimo(LivroModelo livro)throws ExcecaoDados;
}
