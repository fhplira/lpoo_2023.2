package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dados.LivroDados;
import modelos.LivroModelo;


public class Main {

	// TESTES
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		ResultSet result;
		Connection con;
		
		try {
			con = new ConexaoDados().getConnection();

			System.out.print("sucesso!");
			
			
			LivroModelo livro = new LivroModelo("9780316053419", 
					"The Twilight Saga, volume 1",
					"Stephanie Meyer", 
					"Little, Brown & Company", 
					"2008", 
					"About three things I was absolutely positive. First, Edward was a vampire. Second, there was a part of him—and I didn't know how dominant that part might be—that thirsted for my blood. And third, I was unconditionally and irrevocably in love with him.", 
					"https://m.media-amazon.com/images/I/61y8sriKWhL._SX679_.jpg" 
					);
			String cadastraLivro = "INSERT INTO livro (isbn, titulo_livro, autor, editora, data_publicacao, descricao, img) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ExcecaoDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
