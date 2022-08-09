package crudmysql.Models;

import crudmysql.conexion.Conexion;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author weizm
 */
public class Moto {

    Connection conexion = null;

    public Moto() {
        Conexion c = new Conexion();
        conexion = c.getConexion();
    }

    public String create(String nombre, String capacidad, String marca, String precio) {
        String salida = "";
        try {
            String sql = "INSERT INTO `motos` "
                    + "(`NOMBRE`, `CAPACIDAD`, `MARCA`, `PRECIO`) "
                    + "VALUES ('" + nombre + "','" + capacidad + "','" + marca + "','" + precio + "');";
            Statement st = (Statement) conexion.createStatement();
            int res = st.executeUpdate(sql);
            System.out.println(res);
            salida = "Registro exitoso";
        } catch (Exception e) {
            System.out.println("Ocurrió un error " + e.getMessage());
            salida = "Error create";
        }
        return salida;
    }

}
