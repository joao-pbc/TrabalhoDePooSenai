package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/POO";
    private static final String user = "root";
    private static final String password = "WWebrasil23";

    private static Connection conn;

    public Conexao() throws SQLException {
    }

    public static Connection getConexao() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

