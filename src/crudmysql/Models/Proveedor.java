/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmysql.Models;

import crudmysql.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author weizm
 */
public class Proveedor extends Conexion {

    private int prov_id;
    private String prov_nombre;
    private String prov_direccion;
    private String prov_telefono;

    public Proveedor(int prov_id, String prov_nombre, String prov_direccion, String prov_telefono) {
        this.prov_id = prov_id;
        this.prov_nombre = prov_nombre;
        this.prov_direccion = prov_direccion;
        this.prov_telefono = prov_telefono;
    }

    public Proveedor() {
    }

    public boolean create(Proveedor proveedor) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "INSERT INTO `proveedor` (`PROV_ID`, `PROV_NOMBRE`, `PROV_DIRECCION`, `PROV_TELEFONO`) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, proveedor.getProv_id());
            ps.setString(2, proveedor.getProv_nombre());
            ps.setString(3, proveedor.getProv_direccion());
            ps.setString(4, proveedor.getProv_telefono());

            ps.execute();

            System.out.println("OK create Proveedor");
            return true;
        } catch (Exception e) {
            System.err.println("ERR create Proveedor " + e.getMessage());
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() create Proveedor " + e.getMessage());
            }
        }
    }

    public boolean update(Proveedor proveedor) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "UPDATE `proveedor` SET `PROV_NOMBRE`=?, `PROV_DIRECCION`=?, `PROV_TELEFONO`=? WHERE `PROV_ID`=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getProv_nombre());
            ps.setString(2, proveedor.getProv_direccion());
            ps.setString(3, proveedor.getProv_telefono());
            ps.setInt(4, proveedor.getProv_id());

            ps.execute();

            System.out.println("OK update Proveedor");
            return true;
        } catch (Exception e) {
            System.err.println("ERR update Proveedor " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() update Proveedor " + e.getMessage());
            }
        }
    }

    public boolean delete(Proveedor proveedor) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "DELETE FROM `proveedor` WHERE `PROV_ID`=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, proveedor.getProv_id());

            ps.execute();

            System.out.println("OK delete Proveedor");
            return true;
        } catch (Exception e) {
            System.err.println("ERR delete Proveedor " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() delete Proveedor " + e.getMessage());
            }
        }
    }

    public int getProv_id() {
        return prov_id;
    }

    public void setProv_id(int prov_id) {
        this.prov_id = prov_id;
    }

    public String getProv_nombre() {
        return prov_nombre;
    }

    public void setProv_nombre(String prov_nombre) {
        this.prov_nombre = prov_nombre;
    }

    public String getProv_direccion() {
        return prov_direccion;
    }

    public void setProv_direccion(String prov_direccion) {
        this.prov_direccion = prov_direccion;
    }

    public String getProv_telefono() {
        return prov_telefono;
    }

    public void setProv_telefono(String prov_telefono) {
        this.prov_telefono = prov_telefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "prov_id=" + prov_id + ", prov_nombre=" + prov_nombre + ", prov_direccion=" + prov_direccion + ", prov_telefono=" + prov_telefono + '}';
    }

}
