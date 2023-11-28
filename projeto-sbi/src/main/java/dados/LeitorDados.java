package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.LeitorModelo;

public class LeitorDados {

	public void cadastrarLeitor(LeitorModelo leitor) throws ExcecaoDados {
		
		String cadastraLeitor = "INSERT INTO leitor (nome_leitor, cpf_leitor, email_leitor)  VALUES (?, ?, ?)";
		
		try {
			Connection con = new ConexaoDados().getConnection();
			PreparedStatement stmt = con.prepareStatement(cadastraLeitor);
			
			stmt.setString(1, leitor.getNome());
			stmt.setString(2, leitor.getCpf());
			stmt.setString(3, leitor.getEmail());
			stmt.execute();
		} catch (Exception e){
			throw new ExcecaoDados("Erro ao tentar cadastrar Leitor");
		}
		
	}
	
	public void atualizarLeitor(LeitorModelo leitor) {
		String atualizaLeitor = "UPDATE ";
	}
	
	public boolean verificarLeitor(String cpf) throws ExcecaoDados {
		
		String verificarLeitor = "SELECT * FROM leitor WHERE cpf_leitor = ?";
		
		try {
			Connection con = new ConexaoDados().getConnection();
			PreparedStatement stmt = con.prepareStatement(verificarLeitor);
			stmt.setString(1, cpf);
			ResultSet resultado = stmt.executeQuery();
			 if (resultado.next()) {    
		            return true;
		        } else {
		            return false;
		        }
		}
		catch(Exception e) {
			throw new ExcecaoDados("Erro ao tentar buscar Leitor");
		}
	}
}
