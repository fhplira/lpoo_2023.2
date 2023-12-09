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

            String realizaEmprestimo = "INSERT INTO emprestimo (isbn_fk, cpf_leitor_fk, dias_atraso, atrasado) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(realizaEmprestimo);


            stmt.setString(1, emprestimo.getIsbn());
            stmt.setString(2, emprestimo.getCpf());
            stmt.setInt(3, emprestimo.getDiasAtraso());
            stmt.setBoolean(4, emprestimo.isAtrasado());
            
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
	
	public List<EmprestimoModelo> listarEmprestimos() throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String buscaEmprestimos = "SELECT * FROM emprestimo"; 
			stmt = con.prepareStatement(buscaEmprestimos);
			result = stmt.executeQuery();
			
			List<EmprestimoModelo> listaEmprestimos = new ArrayList<>();
			
			while (result.next()) {
				EmprestimoModelo emprestimo = new EmprestimoModelo();
				//emprestimo.setId(result.getInt("id_emprestimo"));
				emprestimo.setIsbn(result.getString("isbn"));
				emprestimo.setCpf(result.getString("cpf_leitor"));
				java.sql.Timestamp timestampDataEmprestimo = result.getTimestamp("data_emprestimo");
                emprestimo.setDataEmprestimo(timestampDataEmprestimo.toLocalDateTime());
                java.sql.Timestamp timestampDataDevolucao = result.getTimestamp("data_devolucao");
                emprestimo.setDataDevolucao(timestampDataDevolucao.toLocalDateTime());
                emprestimo.setDiasAtraso(result.getInt("dias_atraso"));
                emprestimo.setAtrasado(result.getBoolean("atrasado"));
                
                
				listaEmprestimos.add(emprestimo);
			}
			
			return listaEmprestimos;
			
		} catch (Exception e) {
        	throw new ExcecaoDados("Erro ao buscar Emprestimos");
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
	
	public void fazerDevolucao(EmprestimoModelo isbn, EmprestimoModelo cpf, EmprestimoModelo id) throws ExcecaoDados {
		try {
        	con = new ConexaoDados().getConnection();
        	
        	//precisa desenvolver mais, é so uma base
        	//sugestao: colocar status do emprestimo

            String realizaEmprestimo = "DELETE * FROM emprestimos WHERE isbn = ? AND  cpf_leitor = ? AND id_emprestimo = ?";
            stmt = con.prepareStatement(realizaEmprestimo);

            stmt.setString(1, isbn.getIsbn());
            stmt.setString(2, cpf.getCpf());
            stmt.setInt(3, id.getId());


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
