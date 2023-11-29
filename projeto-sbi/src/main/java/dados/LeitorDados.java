package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import modelos.LeitorModelo;

public class LeitorDados {

	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;
	
	public void cadastrarLeitor(LeitorModelo leitor) throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String cadastraLeitor = "INSERT INTO leitor (nome_leitor, cpf_leitor, email_leitor)  VALUES (?, ?, ?)";
			stmt = con.prepareStatement(cadastraLeitor);
			
			stmt.setString(1, leitor.getNome());
			stmt.setString(2, leitor.getCpf());
			stmt.setString(3, leitor.getEmail());
			stmt.execute();
		} catch (Exception e){
			throw new ExcecaoDados("Erro ao tentar cadastrar Leitor");
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
	
	public void atualizarLeitor(LeitorModelo leitor) throws ExcecaoDados {
		
		try {
			String atualizaLeitor = "UPDATE leitor SET" 
					+ "nome_leitor = ?"
					+ "email_leitor = ?"
					+ "WHERE cpf_leitor = ?";
			
			stmt = con.prepareStatement(atualizaLeitor);
			
			stmt.setString(1, leitor.getNome());
			stmt.setString(2, leitor.getEmail());
			stmt.setString(3, leitor.getCpf());
			stmt.execute();
			
		} catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar atualizar informções do leitor");
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
	
	public boolean verificarLeitor(String cpf) throws ExcecaoDados {
		
		
		
		try {
			con = new ConexaoDados().getConnection();
			
			String verificarLeitor = "SELECT * FROM leitor WHERE cpf_leitor = ?";
			stmt = con.prepareStatement(verificarLeitor);
			
			
			stmt.setString(1, cpf);
			result = stmt.executeQuery();
			 if (result.next()) {    
		            return true;
		        } else {
		            return false;
		        }
		} catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar buscar Leitor");
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
	
	public LeitorModelo buscarLeitorPorCpf(String cpf) throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String buscarCpf = "SELECT * FROM leitor WHERE cpf_leitor = ?";
			stmt = con.prepareStatement(buscarCpf);
			stmt.setString(1, cpf);
			result = stmt.executeQuery();
			
			LeitorModelo leitor = new LeitorModelo();
			leitor.setNome(result.getString("nome_leitor"));
			leitor.setCpf(result.getString("cpf_leitor"));
			leitor.setEmail(result.getString("Email_leitor"));
			return leitor;
			 
		} catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar buscar Leitor");
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
