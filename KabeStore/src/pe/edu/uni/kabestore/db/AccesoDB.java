package pe.edu.uni.kabestore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

    public AccesoDB() {
    }
   
    public static Connection getConnection() throws SQLException {

        Connection cn = null;
        // Parámetros de la base de datos
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String urlDB = "jdbc:sqlserver://localhost:1433;databaseName=BookStore";
        String user = "sa";
        String pass = "02174029Dk*";
        
        try {
            // Conexión con la BD
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(urlDB, user, pass);
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver de la BD.");
        } catch (Exception e) {
            throw new SQLException("No se puede establecer "
                    + "conexión de la BD.");
        }
        return cn;
    }
}
