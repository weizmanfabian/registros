/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmysql.Models;

import crudmysql.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author weizm
 */
public class Fabricante extends Conexion {

    private String nombre;

    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    public Fabricante() {
    }

    public boolean create(Fabricante fabricante) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "INSERT INTO `fabricante` (`FABRICANTES` ) VALUES (?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, fabricante.getNombre());

            ps.execute();

            System.out.println("OK create fabricante");
            return true;
        } catch (Exception e) {
            System.err.println("ERR create fabricante " + e.getMessage());
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() create fabricante " + e.getMessage());
            }
        }
    }

    public ArrayList buscarTodo() {
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Fabricante> output = new ArrayList();

        String sql = "SELECT * FROM fabricante order by FABRICANTES";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Fabricante f = new Fabricante();
                f.setNombre(rs.getString("FABRICANTES"));
                output.add(f);
            }
            ps.close();
            System.out.println("OK buscarTodo Fabricante. Results: " + output.size());
            return output;
        } catch (Exception e) {
            System.err.println("ERR buscarTodo Fabricante " + e.getMessage());
            return output;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() buscarTodo Fabricante " + e.getMessage());
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Fabricante{" + "nombre=" + nombre + '}';
    }

}
