/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmysql.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author weizm
 */
public class Conexion {

    private String dataBase = "crud";
    private String user = "root";
    private String password = "";
    private String server = "localhost";
    private int puerto = 3306;
    private String url = "jdbc:mysql://" + server + ":" + puerto + "/" + dataBase;

    public Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
//            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
            if (conexion != null) {
                System.out.println("conexion exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Error conexion base de datos " + e.getMessage());
        }
        return conexion;
    }
}
