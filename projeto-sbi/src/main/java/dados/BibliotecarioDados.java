package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BibliotecarioDados implements InterfaceBibliotecarioDados{
	
	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;
	
	public boolean verificarNomeBibliotecario(String nome) throws Exception {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String verificaEmailBibliotecario = "SELECT * FROM bibliotecario WHERE nome_bibliotecario = ?";
			stmt = con.prepareStatement(verificaEmailBibliotecario);
			stmt.setString(1, nome);
			result = stmt.executeQuery();
			return result.next();
			
		} catch(Exception e) {
			return false;
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

	public boolean verificarEmailBibliotecario(String email) throws Exception {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String verificaEmailBibliotecario = "SELECT * FROM bibliotecario WHERE email_bibliotecario = ?";
			stmt = con.prepareStatement(verificaEmailBibliotecario);
			stmt.setString(1, email);
			result = stmt.executeQuery();
			return result.next();
			
		} catch(Exception e) {
			return false;
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
	
	
	public boolean verificarSenha(String email, String senha) throws Exception {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String verificaSenha = "SELECT * FROM bibliotecario WHERE email_bibliotecario = ? AND senha_bibliotecario = ?";
			stmt = con.prepareStatement(verificaSenha);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			result = stmt.executeQuery();
			return result.next();
			
		} catch(Exception e) {
			return false;
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
