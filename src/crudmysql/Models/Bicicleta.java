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
public class Bicicleta extends Conexion {

    private int idBicicleta;
    private String nombreFabricante;
    private int precioUnitario;
    private int anioContruccion;

    public Bicicleta(int idBicicleta, String nombreFabricante, int precioUnitario, int anioContruccion) {
        this.idBicicleta = idBicicleta;
        this.nombreFabricante = nombreFabricante;
        this.precioUnitario = precioUnitario;
        this.anioContruccion = anioContruccion;
    }

    public Bicicleta() {
    }

    public boolean create(Bicicleta bici) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "INSERT INTO `bicicletas`(`ID_BICICLETAS`, `NOMBRE_FABRICANTE`, `PRECIO_UNITARIO`, `ANIO_CONSTRUCCION`) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, bici.getIdBicicleta());
            ps.setString(2, bici.getNombreFabricante());
            ps.setInt(3, bici.getPrecioUnitario());
            ps.setInt(4, bici.getAnioContruccion());

            ps.execute();
            ps.close();

            System.out.println("OK create Bicicleta");
            return true;
        } catch (Exception e) {
            System.err.println("ERR create Bicicleta " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() create Bicicleta " + e.getMessage());
            }
        }
    }

    public boolean update(Bicicleta b) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "UPDATE `bicicletas` SET `ANIO_CONSTRUCCION`=?, `NOMBRE_FABRICANTE`=? WHERE `ID_BICICLETAS`=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, b.getAnioContruccion());
            ps.setString(2, b.getNombreFabricante());
            ps.setInt(3, b.getIdBicicleta());

            ps.execute();
            ps.close();

            System.out.println("OK update Bicicleta");
            return true;
        } catch (Exception e) {
            System.err.println("ERR update Bicicleta " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() update Bicicleta " + e.getMessage());
            }
        }
    }

    public ArrayList mayor2019() {
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Bicicleta> output = new ArrayList();

        String sql = "Select NOMBRE_FABRICANTE, PRECIO_UNITARIO, ANIO_CONSTRUCCION from bicicletas where ANIO_CONSTRUCCION >= 2019 order by NOMBRE_FABRICANTE";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Bicicleta b = new Bicicleta();
                b.setNombreFabricante(rs.getString("NOMBRE_FABRICANTE"));
                b.setPrecioUnitario(rs.getInt("PRECIO_UNITARIO"));
                b.setAnioContruccion(rs.getInt("ANIO_CONSTRUCCION"));
                output.add(b);
            }
            ps.close();
            System.out.println("OK mayor2019 Bicicleta. Results: " + output.size());
            return output;
        } catch (Exception e) {
            System.err.println("ERR mayor2019 Bicicleta " + e.getMessage());
            return output;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() mayor2019 Bicicleta " + e.getMessage());
            }
        }
    }

    public long conteoMayor2019() {
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "Select count(ID_BICICLETAS) AS CUENTA from bicicletas where ANIO_CONSTRUCCION >= 2019";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
           
            System.out.println("OK conteoMayor2019 Bicicleta. Results: " + rs.getLong("CUENTA"));
            return rs.getLong("CUENTA");
            
        } catch (Exception e) {
            System.err.println("ERR conteoMayor2019 Bicicleta " + e.getMessage());
            return 0;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() conteoMayor2019 Bicicleta " + e.getMessage());
            }
        }
    }

    public int getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
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

    public int getAnioContruccion() {
        return anioContruccion;
    }

    public void setAnioContruccion(int anioContruccion) {
        this.anioContruccion = anioContruccion;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + "idBicicleta=" + idBicicleta + ", nombreFabricante=" + nombreFabricante + ", precioUnitario=" + precioUnitario + ", anioContruccion=" + anioContruccion + '}';
    }

}
