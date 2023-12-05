package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.LivroModelo;

public class LivroDados {
	
	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;

    public void cadastrarLivro(LivroModelo livro) throws ExcecaoDados {
        try {
        	con = new ConexaoDados().getConnection();

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
        } catch (Exception e) {
        	throw new ExcecaoDados("Erro ao tentar cadastrar o livro");
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
    
    public boolean verificarLivro(String isbn) throws ExcecaoDados {
		
		
		
		try {
			con = new ConexaoDados().getConnection();
			
			String verificarLivro = "SELECT * FROM livro WHERE isbn = ?";
			stmt = con.prepareStatement(verificarLivro);
			
			
			stmt.setString(1, isbn);
			result = stmt.executeQuery();
			 if (result.next()) {    
		            return true;
		        } else {
		            return false;
		        }
		} catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar buscar Livro");
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
    
    public void deletarLivroPorIsbn(LivroModelo livro) throws ExcecaoDados {
    	try {
    		con = new ConexaoDados().getConnection();
    		
    		String deletaLivroPorIsbn = "DELETE * FROM LIVRO WHERE isbn = ?";
    		stmt = con.prepareStatement(deletaLivroPorIsbn);
    		
    		stmt.setString(1, livro.getIsbn());
    		
    		stmt.execute();
    	} catch (Exception e) {
    		throw new ExcecaoDados("Erro ao tentar deletar o livro do sistema");
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
    
    public List<LivroModelo> buscarTodosOsLivros() throws ExcecaoDados {
    	try {
    		con = new ConexaoDados().getConnection();
    		
    		String buscarLivros = "SELECT * FROM livro";
    		stmt = con.prepareStatement(buscarLivros);
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
            	
            	listaLivros.add(livro);
        	}
        	
        	return listaLivros;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
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
   
        	return livro;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
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
    
    public LivroModelo buscarLivroPorTitulo(String titulo) throws ExcecaoDados {
    	try {
    		con = new ConexaoDados().getConnection();
    		
    		String buscarTitulo = "SELECT * FROM livro WHERE titulo_livro = ?";
    		stmt = con.prepareStatement(buscarTitulo);
        	stmt.setString(1, titulo);
        	result = stmt.executeQuery();
        	
        	LivroModelo livro = new LivroModelo();
        	while (result.next()) {
        		livro.setTitulo(result.getString("titulo_livro"));
        		livro.setIsbn(result.getString("isbn"));
            	livro.setAutor(result.getString("autor"));
            	livro.setEditora(result.getString("editora"));
            	livro.setDataPublicacao(result.getString("data_publicacao"));
            	livro.setDescricao(result.getString("descricao"));
            	livro.setImg(result.getString("img"));
            
        	}
        	
        	return livro;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
        	
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
            	
            	listaLivros.add(livro);
        	}
        	
        	return listaLivros;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
        	
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
    
    
    public LivroModelo buscarLivroPorTituloModelo(String titulo) throws ExcecaoDados {
    	try {
    		con = new ConexaoDados().getConnection();
    		
    		String buscarTitulo = "SELECT * FROM livro WHERE titulo_livro = ?";
    		stmt = con.prepareStatement(buscarTitulo);
        	stmt.setString(1, titulo);
        	result = stmt.executeQuery();
        	
        	LivroModelo livro = new LivroModelo();
        	
        	while (result.next()) {
        		livro.setTitulo(result.getString("titulo_livro"));
        		livro.setIsbn(result.getString("isbn"));
            	livro.setAutor(result.getString("autor"));
            	livro.setEditora(result.getString("editora"));
            	livro.setDataPublicacao(result.getString("data_publicacao"));
            	livro.setDescricao(result.getString("descricao"));
            	livro.setImg(result.getString("img"));
            	
        	}
        	
        	return livro;
        	
    	} catch (Exception e) {
        	throw new ExcecaoDados("Livro não encontrado");
        	
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


