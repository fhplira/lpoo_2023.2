package dados;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoDados {
	
	String url = "jdbc:mysql://localhost:3306/";
	String usuario = "root";
	String senha = "12345";
	
	public Connection getConnection() throws ExcecaoDados {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
        } catch (ClassNotFoundException e) {
            throw new ExcecaoDados("Erro de conexão.", e);
        } 

        try {
        	con = DriverManager.getConnection(url + "sib", usuario, senha);
        }
        catch (SQLException e) {
            throw new ExcecaoDados("Erro ao conectar com o banco de dados.", e);
        }
        return con;
    }
	
	public void criarBancoDados() {
		
		try (Connection con = DriverManager.getConnection(url, usuario, senha); 
				Statement stmt = con.createStatement()) {

			String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS sib";
			try (Statement statement = con.createStatement()) {
				statement.executeUpdate(createDatabaseQuery);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao criar o banco de dados");
		}
		
		try (Connection con = DriverManager.getConnection(url + "sib", usuario, senha); 
				Statement stmt = con.createStatement()) {

			InputStream inputStream = getClass().getResourceAsStream("/bd/sib-database.sql");
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder script = new StringBuilder();

			String linha;

			while ((linha = reader.readLine()) != null) {
				script.append(linha).append("\n");
			}

			String scriptSQL = script.toString();

			String[] queries = scriptSQL.split(";");

			try {
				for (String querie : queries) {
					if (!querie.trim().isEmpty()) {
						stmt.execute(querie);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Erro ao inserir dados no banco de dados");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserirDadosNoSistema() {
		
		try (Connection con = DriverManager.getConnection(url + "sib", usuario, senha); 
				Statement stmt = con.createStatement()) {

			InputStream inputStream = getClass().getResourceAsStream("/bd/sib-insercao-dados.sql");
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder script = new StringBuilder();

			String linha;

			while ((linha = reader.readLine()) != null) {
				script.append(linha).append("\n");
			}

			String scriptSQL = script.toString();

			String[] queries = scriptSQL.split(";");

			try {
				for (String querie : queries) {
					if (!querie.trim().isEmpty()) {
						stmt.execute(querie);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Erro ao inserir dados de livros e leitores no banco de dados");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
