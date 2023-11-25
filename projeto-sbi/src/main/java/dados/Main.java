package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.
					getConnection(
							"jdbc:mysql://localhost:3306/sistema_bibliotecario_institucional",
							"root",
							"root");
			System.out.print("sucesso!");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
