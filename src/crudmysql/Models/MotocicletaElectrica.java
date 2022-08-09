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
public class MotocicletaElectrica extends Conexion {

    private int idMotocicletas;
    private String nombreFabricante;
    private int precioUnitario;
    private int autonomiaBateria;
    private int proveedoresId;

    public MotocicletaElectrica() {
    }

    public MotocicletaElectrica(int idMotocicletas, String nombreFabricante, int precioUnitario, int autonomiaBateria, int proveedoresId) {
        this.idMotocicletas = idMotocicletas;
        this.nombreFabricante = nombreFabricante;
        this.precioUnitario = precioUnitario;
        this.autonomiaBateria = autonomiaBateria;
        this.proveedoresId = proveedoresId;
    }

    public boolean create(MotocicletaElectrica moto) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "INSERT INTO `MOTOCICLETAS_ELECTRICAS` (`ID_MOTOCICLETAS`, `NOMBRE_FABRICANTE`, `PRECIO_UNITARIO`, `AUTONOMIA_BATERIA`, `PROVEEDORES_ID`) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, moto.getIdMotocicletas());
            ps.setString(2, moto.getNombreFabricante());
            ps.setInt(3, moto.getPrecioUnitario());
            ps.setInt(4, moto.getAutonomiaBateria());
            ps.setInt(5, moto.getProveedoresId());

            ps.execute();

            System.out.println("OK create MotocicletaElectrica");
            return true;
        } catch (Exception e) {
            System.err.println("ERR create MotocicletaElectrica " + e.getMessage());
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() create MotocicletaElectrica " + e.getMessage());
            }
        }
    }

    public ArrayList buscarPorProveedor() {
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<MotocicletaElectrica> output = new ArrayList();

        String sql = "Select NOMBRE_FABRICANTE from motocicletas_electricas where PROVEEDORES_ID = 101";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MotocicletaElectrica m = new MotocicletaElectrica();
                m.setNombreFabricante(rs.getString("NOMBRE_FABRICANTE"));
                output.add(m);
            }
            ps.close();
            System.out.println("OK buscarPorProveedor MotocicletaElectrica. Results: " + output.size());
            return output;
        } catch (Exception e) {
            System.err.println("ERR buscarPorProveedor MotocicletaElectrica " + e.getMessage());
            return output;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() buscarPorProveedor MotocicletaElectrica " + e.getMessage());
            }
        }
    }

    public int getIdMotocicletas() {
        return idMotocicletas;
    }

    public void setIdMotocicletas(int idMotocicletas) {
        this.idMotocicletas = idMotocicletas;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getAutonomiaBateria() {
        return autonomiaBateria;
    }

    public void setAutonomiaBateria(int autonomiaBateria) {
        this.autonomiaBateria = autonomiaBateria;
    }

    public int getProveedoresId() {
        return proveedoresId;
    }

    public void setProveedoresId(int proveedoresId) {
        this.proveedoresId = proveedoresId;
    }

    @Override
    public String toString() {
        return "MotocicletaElectrica{" + "idMotocicletas=" + idMotocicletas + ", nombreFabricante=" + nombreFabricante + ", precioUnitario=" + precioUnitario + ", autonomiaBateria=" + autonomiaBateria + ", proveedoresId=" + proveedoresId + '}';
    }

}
