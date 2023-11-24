package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {
	
	public static void getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/sistema_bibliotecario_institucional",
							"root",
							"root");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
