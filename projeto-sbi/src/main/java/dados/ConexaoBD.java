package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {
	
	public static Connection getConnection() {
		Connection con = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/sistema_bibliotecario_institucional",
							"root",
							"root");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
