package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDados {
	
	public static Connection getConnection() {
		
		Connection con = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/sib",
							"root",
							"root");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// editar essa excecao
		}
		 catch (SQLException e) {
			e.printStackTrace();
			// editar essa excecao
		}
		return con;
	}
}
