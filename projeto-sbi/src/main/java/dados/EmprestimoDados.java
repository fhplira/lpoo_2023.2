package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.EmprestimoModelo;
import modelos.LivroModelo;

public class EmprestimoDados {
	
	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;
	
	public void realizarEmprestimo(EmprestimoModelo emprestimo) throws ExcecaoDados {
		
		try {
        	con = new ConexaoDados().getConnection();

            String realizaEmprestimo = "INSERT INTO emprestimo (isbn_fk, cpf_leitor_fk, dias_atraso, devolvido) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(realizaEmprestimo);


            stmt.setString(1, emprestimo.getIsbn());
            stmt.setString(2, emprestimo.getCpf());
            stmt.setInt(3, emprestimo.getDiasAtraso());
            stmt.setBoolean(4, emprestimo.isDevolvido());
            
            //verificar se o executeQuery é sem parâmetro
            stmt.execute();
        } catch (Exception e) {
        	throw new ExcecaoDados("Erro ao realizar o empréstimo");
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
	
	public boolean verificarEmprestimo(String cpf, String isbn) throws ExcecaoDados {
		try {
			con = new ConexaoDados().getConnection();
			
			String verificarEmprestimo = "SELECT * FROM emprestimo WHERE cpf_leitor_fk = ? AND isbn_fk = ?";
			stmt = con.prepareStatement(verificarEmprestimo);
			
			stmt.setString(1, cpf);
			stmt.setString(2, isbn);
			result = stmt.executeQuery();
			 if (result.next()) {    
		            return true;
		        } else {
		            return false;
		        }
		} catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar buscar Emprestimo");
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
	
	public EmprestimoModelo buscarEmprestimo(EmprestimoModelo emprestimo) throws ExcecaoDados{
		try {
			con = new ConexaoDados().getConnection();
			
			String buscaEmprestimo = "SELECT * FROM emprestimo WHERE cpf_leitor_fk = ? AND isbn_fk = ?"; 
			stmt = con.prepareStatement(buscaEmprestimo);
			stmt.setString(1, emprestimo.getCpf());
			stmt.setString(2, emprestimo.getIsbn());
			result = stmt.executeQuery();
				if(result.next()) {
					emprestimo.setId(result.getInt("id_emprestimo"));
					emprestimo.setIsbn(result.getString("isbn_fk"));
					emprestimo.setCpf(result.getString("cpf_leitor_fk"));
					java.sql.Timestamp timestampDataEmprestimo = result.getTimestamp("data_emprestimo");
	                emprestimo.setDataEmprestimo(timestampDataEmprestimo.toLocalDateTime());
	                java.sql.Timestamp timestampDataDevolucao = result.getTimestamp("data_devolucao");
	                emprestimo.setDataDevolucao(timestampDataDevolucao.toLocalDateTime());
	                emprestimo.setDiasAtraso(result.getInt("dias_atraso"));
	                emprestimo.setDevolvido(result.getBoolean("devolvido"));
				}
				return emprestimo;
				
		}catch (Exception e) {
        	throw new ExcecaoDados("Erro ao buscar emprestimo");
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
	
	public List<EmprestimoModelo> buscarTodosEmprestimos() throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String buscaEmprestimos = "SELECT * FROM emprestimo"; 
			stmt = con.prepareStatement(buscaEmprestimos);
			result = stmt.executeQuery();
			
			List<EmprestimoModelo> listaEmprestimos = new ArrayList<>();
			
			while(result.next()) {
				EmprestimoModelo emprestimo = new EmprestimoModelo();
				emprestimo.setId(result.getInt("id_emprestimo"));
				emprestimo.setIsbn(result.getString("isbn_fk"));
				emprestimo.setCpf(result.getString("cpf_leitor_fk"));
				java.sql.Timestamp timestampDataEmprestimo = result.getTimestamp("data_emprestimo");
                emprestimo.setDataEmprestimo(timestampDataEmprestimo.toLocalDateTime());
                java.sql.Timestamp timestampDataDevolucao = result.getTimestamp("data_devolucao");
                emprestimo.setDataDevolucao(timestampDataDevolucao.toLocalDateTime());
                emprestimo.setDiasAtraso(result.getInt("dias_atraso"));
                emprestimo.setDevolvido(result.getBoolean("devolvido"));
                
                listaEmprestimos.add(emprestimo);		
            }
			
			return listaEmprestimos;
			
		} catch (Exception e) {
        	throw new ExcecaoDados("Erro ao buscar lista de emprestimos");
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
	
	public void fazerDevolucao(EmprestimoModelo emprestimo) throws ExcecaoDados {
		try {
        	con = new ConexaoDados().getConnection();

            String fazerDevolucao = "UPDATE emprestimo SET devolvido = ? "
					+ "WHERE cpf_leitor_fk = ? AND isbn_fk = ?";
            stmt = con.prepareStatement(fazerDevolucao);

            stmt.setBoolean(1, emprestimo.isDevolvido());
            stmt.setString(2, emprestimo.getCpf());
            stmt.setString(3, emprestimo.getIsbn());
            stmt.execute();
            
        } catch (Exception e) {
        	throw new ExcecaoDados("Erro ao realizar devolução");
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
