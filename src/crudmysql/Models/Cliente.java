/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmysql.Models;

import java.sql.Date;
import crudmysql.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author weizm
 */
public class Cliente extends Conexion {

    private String alias;
    private String nombres;
    private String apellidos;
    private String email;
    private String celular;
    private int contrasenia;
    private Date fechaNacimiento;

    public Cliente(String alias, String nombres, String apellidos, String email, String celular, int contrasenia, String fechaNacimiento) throws ParseException {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.alias = alias;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.celular = celular;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = Date.valueOf(fechaNacimiento);
    }

    public Cliente() {
    }

    public boolean create(Cliente cli) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "INSERT INTO `clientes`(`ALIAS`, `NOMBRES`, `APELLIDOS`, `EMAIL`, `CELULAR`, `CONTRASENIA`, `FECHA_NACIMIENTO`) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getAlias());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getApellidos());
            ps.setString(4, cli.getEmail());
            ps.setString(5, cli.getCelular());
            ps.setInt(6, cli.getContrasenia());
            ps.setDate(7, cli.getFechaNacimiento());

            ps.execute();

            System.out.println("OK create Cliente");
            return true;
        } catch (Exception e) {
            System.err.println("ERR create Cliente " + e.getMessage());
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() create Cliente " + e.getMessage());
            }
        }
    }

    public boolean update(Cliente cli) {
        Connection con = getConexion();
        PreparedStatement ps = null;

        String sql = "UPDATE `clientes` SET `CELULAR`=? WHERE `ALIAS`=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getCelular());
            ps.setString(2, cli.getAlias());

            ps.execute();
            ps.close();

            System.out.println("OK update Cliente");
            return true;
        } catch (Exception e) {
            System.err.println("ERR update Cliente " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() update Cliente " + e.getMessage());
            }
        }
    }

    public ArrayList buscarPorMarcaRegistro() {
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cliente> output = new ArrayList();

        String sql = "Select ALIAS, NOMBRES, APELLIDOS from clientes inner join registro on NOMBRE_REGISTRO = ALIAS where MARCA_REGISTRO = 'Yeti'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setAlias(rs.getString("ALIAS"));
                c.setNombres(rs.getString("NOMBRES"));
                c.setApellidos(rs.getString("APELLIDOS"));
                output.add(c);
            }
            ps.close();
            System.out.println("OK buscarPorMarcaRegistro Cliente. Results: " + output.size());
            return output;
        } catch (Exception e) {
            System.err.println("ERR buscarPorMarcaRegistro Cliente " + e.getMessage());
            return output;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("ERR con.close() buscarPorMarcaRegistro Cliente " + e.getMessage());
            }
        }
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "alias=" + alias + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", celular=" + celular + ", contrasenia=" + contrasenia + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
