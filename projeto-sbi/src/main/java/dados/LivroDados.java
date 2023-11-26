package dados;

import model.LivroModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDados {
	
	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;

    public void cadastrarLivro(LivroModelo livro) throws ExcecaoDados {
        try {
        	con = new ConexaoDados().getConnection();

            String cadastraLivro = "INSERT INTO livro (isbn, titulo_livro, autor, editora, data_publicacao, descricao, img, codigo_exemplar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(cadastraLivro);

            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getDataPublicacao());
            stmt.setString(6, livro.getDescricao());
            stmt.setString(7, livro.getImg());
            
            //verificar se o executeQuery é sem parâmetro
            stmt.execute();
        } catch (Exception e) {
        	throw new ExcecaoDados("Erro ao tentar cadastrar o livro");
        }

    }
    
    public void atualizarLivro(LivroModelo livro) throws ExcecaoDados {
        try {
            con = new ConexaoDados().getConnection();

            String atualizaLivro = "UPDATE livro SET"
            		+ "titulo = ?, "
            		+ "autor = ?, "
            		+ "editora = ?, "
            		+ "data_publicacao = ?, "
            		+ "descricao = ?, "
            		+ "img = ? "
            		+ "WHERE isbn = ?";
            
            stmt = con.prepareStatement(atualizaLivro);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getDataPublicacao());
            stmt.setString(6, livro.getDescricao());
            stmt.setString(7, livro.getImg());
            stmt.setString(8, livro.getIsbn());

            //caso dê certo, atualizar para deixar sem parâmetro
            result = stmt.executeQuery(atualizaLivro);
        } catch (Exception e) {
        	throw new ExcecaoDados("Erro ao tentar atualizar as informações do livro");
        }

    }
    
    public List<LivroModelo> buscarTodosOsLivros() throws ExcecaoDados {
    	try {
    		con = new ConexaoDados().getConnection();
    		
    		String buscarAutor = "SELECT * FROM livro";
    		stmt = con.prepareStatement(buscarAutor);
        	result = stmt.executeQuery();
        	
        	List<LivroModelo> listaLivros = new ArrayList<>();
        	
        	//estrutura de repeticao que adiciona os dados na variavel livro e depois passa pra o ArrayList
        	while (result.next()) {
        		LivroModelo livro = new LivroModelo();
        		livro.setTitulo(result.getString("titulo_livro"));
        		livro.setIsbn(result.getString("isbn"));
            	livro.setAutor(result.getString("autor"));
            	livro.setEditora(result.getString("editora"));
            	livro.setDataPublicacao(result.getString("data_publicacao"));
            	livro.setDescricao(result.getString("descricao"));
            	livro.setImg(result.getString("img"));
            	livro.setCodigoExemplar(result.getString("codigo_exemplar"));
            	
            	listaLivros.add(livro);
        	}
        	
        	return listaLivros;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
    	}
    }
    
    
    public LivroModelo buscarLivroPorIsbn(String isbn) throws ExcecaoDados {    	
    	try {
    		con = new ConexaoDados().getConnection();
    		
        	String buscarIsbn = "SELECT * FROM livro WHERE isbn = ?";

        	stmt = con.prepareStatement(buscarIsbn);
        	stmt.setString(1, isbn);
        	
        	result = stmt.executeQuery();
        	LivroModelo livro = new LivroModelo();
        	
        	//resul.first;
        	livro.setIsbn(result.getString("isbn"));
        	livro.setTitulo(result.getString("titulo_livro"));
        	livro.setAutor(result.getString("autor"));
        	livro.setEditora(result.getString("editora"));
        	livro.setDataPublicacao(result.getString("data_publicacao"));
        	livro.setDescricao(result.getString("descricao"));
        	livro.setImg(result.getString("img"));
        	livro.setCodigoExemplar(result.getString("codigo_exemplar"));
   
        	return livro;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
    	}
    }
    
    public List<LivroModelo> buscarLivroPorTitulo(String titulo) throws ExcecaoDados {
    	try {
    		con = new ConexaoDados().getConnection();
    		
    		String buscarTitulo = "SELECT * FROM livro WHERE titulo_livro = ?";
    		stmt = con.prepareStatement(buscarTitulo);
        	stmt.setString(1, titulo);
        	result = stmt.executeQuery();
        	
        	List<LivroModelo> listaLivros = new ArrayList<>();
        	
        	while (result.next()) {
        		LivroModelo livro = new LivroModelo();
        		livro.setTitulo(result.getString("titulo_livro"));
        		livro.setIsbn(result.getString("isbn"));
            	livro.setAutor(result.getString("autor"));
            	livro.setEditora(result.getString("editora"));
            	livro.setDataPublicacao(result.getString("data_publicacao"));
            	livro.setDescricao(result.getString("descricao"));
            	livro.setImg(result.getString("img"));
            	livro.setCodigoExemplar(result.getString("codigo_exemplar"));
            	
            	listaLivros.add(livro);
        	}
        	
        	return listaLivros;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
    	}
    }
    
    public List<LivroModelo> buscarLivroPorAutor(String autor) throws ExcecaoDados {
    	try {
    		con = new ConexaoDados().getConnection();
    		
    		String buscarAutor = "SELECT * FROM livro WHERE autor = ?";
    		stmt = con.prepareStatement(buscarAutor);
        	stmt.setString(1, autor);
        	result = stmt.executeQuery();
        	
        	List<LivroModelo> listaLivros = new ArrayList<>();
        	
        	while (result.next()) {
        		LivroModelo livro = new LivroModelo();
        		livro.setTitulo(result.getString("titulo_livro"));
        		livro.setIsbn(result.getString("isbn"));
            	livro.setAutor(result.getString("autor"));
            	livro.setEditora(result.getString("editora"));
            	livro.setDataPublicacao(result.getString("data_publicacao"));
            	livro.setDescricao(result.getString("descricao"));
            	livro.setImg(result.getString("img"));
            	livro.setCodigoExemplar(result.getString("codigo_exemplar"));
            	
            	listaLivros.add(livro);
        	}
        	
        	return listaLivros;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
    	}
    }
    
    
}


