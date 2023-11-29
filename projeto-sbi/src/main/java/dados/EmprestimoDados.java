package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.EmprestimoModelo;

public class EmprestimoDados {
	
	PreparedStatement stmt;
	Connection con = null;
	ResultSet result;
	
	public void realizarEmprestimo(EmprestimoModelo isbn, EmprestimoModelo cpf) {
		
	}
}
