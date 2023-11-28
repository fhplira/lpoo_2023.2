package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BibliotecarioDados {
	
	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;

	public void verificarEmailBibliotecario(String email) throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String verificaEmailBibliotecario = "SELECT * FROM bibliotecario WHERE email_bibliotecario = ?";
			stmt = con.prepareStatement(verificaEmailBibliotecario);
			stmt.setString(1, email);
			result = stmt.executeQuery();
			
		} catch(Exception e) {
			throw new ExcecaoDados("Usuário não encontrado");
		} finally {
            try {
                if (stmt != null) {stmt.close();}
            } catch (SQLException e) {
                throw new ExcecaoDados("Erro ao fechar o Statement: ");
            }
            
            try {
                if (con != null) {con.close();}
            } catch (SQLException e) {
                throw new ExcecaoDados("Erro ao fechar a conexão: ");                
            }
		}
		
	}
	
	public void verificarSenha(String senha) throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String verificaSenha = "SELECT * FROM bibliotecario WHERE senha_bibliotecario = ?";
			stmt = con.prepareStatement(verificaSenha);
			stmt.setString(1, senha);
			result = stmt.executeQuery();
			
		} catch(Exception e) {
			throw new ExcecaoDados("Senha incorreta");
		} finally {
            try {
                if (stmt != null) {stmt.close();}
            } catch (SQLException e) {
                throw new ExcecaoDados("Erro ao fechar o Statement: ");
            }
            
            try {
                if (con != null) {con.close();}
            } catch (SQLException e) {
                throw new ExcecaoDados("Erro ao fechar a conexão: ");                
            }
		}
        
		
	}
	
	
}
