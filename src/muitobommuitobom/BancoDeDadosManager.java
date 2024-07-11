package muitobommuitobom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDadosManager {

        static final String url = "jdbc:mysql://localhost:3306/poo";
        static final String user = "root";
        static final String password = "";

        private static Connection conn;

        public static Connection getConexao () {
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
