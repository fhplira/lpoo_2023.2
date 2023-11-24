package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.LeitorModelo;

public class LeitorBd {

	public void cadastrarLeitor(LeitorModelo leitor) {
		
		String cadastraLeitor = "INSERT INTO leitor (nome, cpf, email)  VALUES (?, ?, ?)";
		
		try {
			ConexaoBD.getConnection();
			PreparedStatement stmt = null;
			
			stmt.setString(1, leitor.getNome());
			stmt.setString(2, leitor.getCpf());
			stmt.setString(3, leitor.getEmail());
			ResultSet result;
			result = stmt.executeQuery(cadastraLeitor);
		} catch (Exception e){
			
		}
		
	}
	
	public void atualizarLeitor(LeitorModelo leitor) {
		String atualizaLeitor = "UPDATE "
	}
	
}
