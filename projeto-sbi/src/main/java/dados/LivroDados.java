package dados;

import model.LivroModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LivroDados {

    public void cadastrarLivro(LivroModelo livro) throws ExcecaoDados {
        Connection con = ConexaoDados.getConnection();

        try {

            String cadastraLivro = "INSERT INTO livro (isbn, titulo, autor, editora, data_publicacao, descricao, img, codigo_exemplar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(cadastraLivro);

            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getDataPublicacao());
            stmt.setString(6, livro.getDescricao());
            stmt.setString(7, livro.getImg());
            stmt.setString(8, livro.getCodigoExemplar());
            
            //verificar se o executeQuery é sem parâmetro
            ResultSet result = stmt.executeQuery();
        } catch (Exception e) {
        	throw new ExcecaoDados("Erro ao tentar cadastrar o livro");
        }

    }
    
    public void atualizarLivro(LivroModelo livro) throws ExcecaoDados {
        try {
            Connection con = ConexaoDados.getConnection();

            String atualizaLivro = "UPDATE livro SET"
            		+ "titulo = ?, "
            		+ "autor = ?, "
            		+ "editora = ?, "
            		+ "data_publicacao = ?, "
            		+ "descricao = ?, "
            		+ "img = ? "
            		+ "WHERE isbn = ?";
            
            PreparedStatement stmt = con.prepareStatement(atualizaLivro);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getDataPublicacao());
            stmt.setString(6, livro.getDescricao());
            stmt.setString(7, livro.getImg());
            stmt.setString(8, livro.getIsbn());

            //verficar as alterações feitas no método cadastrar
            ResultSet result;
            result = stmt.executeQuery(atualizaLivro);
        } catch (Exception e) {
        	throw new ExcecaoDados("Erro ao tentar atualizar as informações do livro");
        }

    }
    
    
}


