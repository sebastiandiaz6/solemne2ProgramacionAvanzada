/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author camil
 */
public class conexion {
    private final String base = "system";
    private final String user = "SYSTEM";
    private final String password = "1234";
    private final String url = "jdbc:oracle:thin:@localhost:1521:system";
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = (Connection) DriverManager.getConnection(url,user,password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión a la BBDD");
        }

        return con;
    }
}
