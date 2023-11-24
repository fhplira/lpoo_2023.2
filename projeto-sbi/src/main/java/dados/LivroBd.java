package dados;

import model.LivroModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LivroBd {

    Connection con = ConexaoBD.getConnection();


    public void cadastrarLivro(LivroModelo livro) {

        try {

            String cadastrarLivro = "INSERT INTO livro (titulo, autor, editora, isbn, dataPublicacao, descricao, img, quantidade, emprestados, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(cadastrarLivro);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setString(4, livro.getIsbn());
            stmt.setString(5, livro.getDataPublicacao());
            stmt.setString(6, livro.getDescricao());
            stmt.setString(7, livro.getImg());
            stmt.setInt(8, livro.getQuantidade());
            stmt.setInt(9, livro.getEmprestados());
            stmt.setInt(10, livro.getDisponivel());

            ResultSet result;
            result = stmt.executeQuery(cadastrarLivro);
        } catch (Exception e) {}

    }
}
