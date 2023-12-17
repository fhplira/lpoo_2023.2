package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.LeitorModelo;
import modelos.LivroModelo;

public class LeitorDados implements InterfaceLeitorDados {

	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;
	
	public void cadastrarLeitor(LeitorModelo leitor) throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String cadastraLeitor = "INSERT INTO leitor (nome_leitor, cpf_leitor, email_leitor, emprestimo_leitor) "
					+ " VALUES (?, ?, ?, ?)";
			stmt = con.prepareStatement(cadastraLeitor);
			
			stmt.setString(1, leitor.getNome());
			stmt.setString(2, leitor.getCpf());
			stmt.setString(3, leitor.getEmail());
			stmt.setInt(4, leitor.getEmprestimo());
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
	
	public void atualizarNomeLeitor(LeitorModelo leitor) throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String atualizaNomeLeitor = "UPDATE leitor SET nome_leitor = ? "
					+ "WHERE cpf_leitor = ?";
			stmt = con.prepareStatement(atualizaNomeLeitor);
			
			stmt.setString(1, leitor.getNome());
			stmt.setString(2, leitor.getCpf());
			stmt.execute();
			
		} catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar atualizar o nome do leitor");
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
	
	public void atualizarEmailLeitor(LeitorModelo leitor) throws ExcecaoDados {
		
		try {
			con = new ConexaoDados().getConnection();
			
			String atualizaEmailLeitor = "UPDATE leitor SET email_leitor = ? "
					+ "WHERE cpf_leitor = ?";
			stmt = con.prepareStatement(atualizaEmailLeitor);
			
			stmt.setString(1, leitor.getEmail());
			stmt.setString(2, leitor.getCpf());
			stmt.execute();
			
		} catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar atualizar o email do leitor");
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
			
			if(result.next()) {
				leitor.setNome(result.getString("nome_leitor"));
				leitor.setCpf(result.getString("cpf_leitor"));
				leitor.setEmail(result.getString("email_leitor"));
				leitor.setEmprestimo(result.getInt("emprestimo_leitor"));
			}
			
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
	
	public void adicionarEmprestimo(LeitorModelo leitor) throws ExcecaoDados {
		try {
			con = new ConexaoDados().getConnection();
			String adicionarEmprestimo = "UPDATE leitor SET emprestimo_leitor = ? "
					+ " WHERE cpf_leitor = ?";
			stmt = con.prepareStatement(adicionarEmprestimo);
			
			stmt.setInt(1, leitor.getEmprestimo());
			stmt.setString(2, leitor.getCpf());
			stmt.execute();
			
		}catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar adicionar emprestimo");
		}finally {
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
	
	public void removerEmprestimo(LeitorModelo leitor) throws ExcecaoDados {
		try {
			con = new ConexaoDados().getConnection();
			String removerEmprestimo = "UPDATE leitor SET emprestimo_leitor = ? "
					+ " WHERE cpf_leitor = ?";
			stmt = con.prepareStatement(removerEmprestimo);
			
			stmt.setInt(1, leitor.getEmprestimo());
			stmt.setString(2, leitor.getCpf());
			stmt.execute();
			
		}catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar remover emprestimo");
		}finally {
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
	
	public void deletarLeitorPorCpf(String cpf) throws ExcecaoDados {
		try {
			con = new ConexaoDados().getConnection();
			
			String deletarLeitorPorCpf = "DELETE FROM leitor WHERE cpf_leitor = ?";
			
			stmt = con.prepareStatement(deletarLeitorPorCpf);
			
			stmt.setString(1, cpf);
			
			stmt.execute();
		}catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar excluir o leitor");
		}finally {
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
	
	public List<LeitorModelo> buscarTodosLeitores() throws ExcecaoDados {
		try {
    		con = new ConexaoDados().getConnection();
    		
    		String buscarLeitores = "SELECT * FROM leitor";
    		stmt = con.prepareStatement(buscarLeitores);
        	result = stmt.executeQuery();
        	
        	List<LeitorModelo> listaLeitores = new ArrayList<>();
        	
        	if(result.next()) {
        		LeitorModelo leitor = new LeitorModelo();
        		leitor.setNome(result.getString("nome_leitor"));
				leitor.setCpf(result.getString("cpf_leitor"));
				leitor.setEmail(result.getString("email_leitor"));
				leitor.setEmprestimo(result.getInt("emprestimo_leitor"));
            	
            	listaLeitores.add(leitor);
        	}
        	
        	return listaLeitores;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Leitor não encontrado");
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
