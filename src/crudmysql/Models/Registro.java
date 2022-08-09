/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmysql.Models;

import crudmysql.conexion.Conexion;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author weizman
 */
public class Registro extends Conexion {

    private int idRegistro;
    private String nombreRegistro;
    private String marcaRegistro;
    private Timestamp fechaHora;

    public Registro(int idRegistro, String nombreRegistro, String marcaRegistro, String fechaHora) throws ParseException {
        this.idRegistro = idRegistro;
        this.nombreRegistro = nombreRegistro;
        this.marcaRegistro = marcaRegistro;
        this.fechaHora = Timestamp.valueOf(fechaHora);
    }

    public Registro() {
    }

    public boolean create(Registro reg) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "INSERT INTO `registro`(`ID_REGISTRO`, `NOMBRE_REGISTRO`, `MARCA_REGISTRO`, `FECHA_HORA`) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, reg.getIdRegistro());
            ps.setString(2, reg.getNombreRegistro());
            ps.setString(3, reg.getMarcaRegistro());
            ps.setTimestamp(4, reg.getFechaHora());

            ps.execute();
            ps.close();
            System.out.println("OK create Registro");
            return true;
        } catch (Exception e) {
            System.err.println("ERR create Registro " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() create Registro " + e.getMessage());
            }
        }
    }

    public boolean delete(String nombreRegistro, String marcaRegistro) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "DELETE FROM registro  WHERE NOMBRE_REGISTRO = ? AND MARCA_REGISTRO = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreRegistro);
            ps.setString(2, marcaRegistro);

            ps.execute();
            ps.close();
            System.out.println("OK delete Registro");
            return true;
        } catch (Exception e) {
            System.err.println("ERR delete Registro " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() delete Registro " + e.getMessage());
            }
        }
    }

    public ArrayList buscarPorNombreRegistro() {
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Registro> output = new ArrayList();

        String sql = "Select MARCA_REGISTRO from registro where NOMBRE_REGISTRO ='lucky' order by MARCA_REGISTRO";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Registro r = new Registro();
                r.setMarcaRegistro(rs.getString("MARCA_REGISTRO"));
                output.add(r);
            }
            ps.close();
            System.out.println("OK buscarPorNombreRegistro Registro. Results: " + output.size());
            return output;
        } catch (Exception e) {
            System.err.println("ERR buscarPorNombreRegistro Registro " + e.getMessage());
            return output;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() buscarPorNombreRegistro Registro " + e.getMessage());
            }
        }
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNombreRegistro() {
        return nombreRegistro;
    }

    public void setNombreRegistro(String nombreRegistro) {
        this.nombreRegistro = nombreRegistro;
    }

    public String getMarcaRegistro() {
        return marcaRegistro;
    }

    public void setMarcaRegistro(String marcaRegistro) {
        this.marcaRegistro = marcaRegistro;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Registro{" + "idRegistro=" + idRegistro + ", nombreRegistro=" + nombreRegistro + ", marcaRegistro=" + marcaRegistro + ", fechaHora=" + fechaHora + '}';
    }

}
