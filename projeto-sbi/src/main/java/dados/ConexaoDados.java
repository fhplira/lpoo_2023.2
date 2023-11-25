package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDados {
	
	public static Connection getConnection() throws ExcecaoDados {

        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sib",
                    "root",
                    "root");

        } catch (ClassNotFoundException e) {
            throw new ExcecaoDados("Erro de conexão.", e);
        } catch (SQLException e) {
            throw new ExcecaoDados("Erro ao cenectar.", e);
        }
        return con;
    }
}
