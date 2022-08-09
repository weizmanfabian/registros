/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudmysql.Main;

import crudmysql.Models.Bicicleta;
import crudmysql.Models.Cliente;
import crudmysql.Models.Fabricante;
import crudmysql.Models.MotocicletaElectrica;
import crudmysql.Models.Proveedor;
import crudmysql.Models.Registro;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author weizm
 */
public class CrudMysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

//        -----------------start fabricantes ----------------------------------------------------------------------------------------
        ArrayList fabricantes = new ArrayList<>(Arrays.asList(
                "Cannondale",
                "Trek",
                "Starker",
                "Yeti",
                "Fuji",
                "Lucky Lion",
                "Be Electric",
                "Aima",
                "Mec de Colombia",
                "Atom Electric",
                "Bmc"
        ));
        for (Object i : fabricantes) {
            Fabricante f = new Fabricante((String) i);
            f.create(f);
        }
//        -----------------start PROVEEDOR ----------------------------------------------------------------------------------------
        ArrayList<Proveedor> proveedores = new ArrayList<>(List.of(
                new Proveedor(101, "Auteco", "calle 7 No. 45-17", "05713224459"),
                new Proveedor(102, "Hitachi", "calle 19 No. 108-26", "05714223344"),
                new Proveedor(103, "Bosch", "carrera 68 No. 26-45", "05715678798"),
                new Proveedor(104, "Teco", "calle 77 No. 68-33", "05712213243"),
                new Proveedor(105, "General Electric", "calle 29 No. 26-12", "05717239919")
        ));
        for (Proveedor i : proveedores) {
            Proveedor p = new Proveedor();
            p.create(i);
        }
//        -----------------start MotocicletaElectrica ----------------------------------------------------------------------------------------
        ArrayList<MotocicletaElectrica> motos = new ArrayList<>(List.of(
                new MotocicletaElectrica(2001, "Starker", 4200000, 18, 101),
                new MotocicletaElectrica(2002, "Lucky Lion", 5600000, 14, 102),
                new MotocicletaElectrica(2003, "Be Electric", 4600000, 26, 101),
                new MotocicletaElectrica(2004, "Aima", 8000000, 36, 103),
                new MotocicletaElectrica(2005, "Mec de Colombia", 5900000, 20, 104),
                new MotocicletaElectrica(2006, "Atom Electric", 4500000, 12, 105)
        ));
        for (MotocicletaElectrica i : motos) {
            MotocicletaElectrica m = new MotocicletaElectrica();
            m.create(i);
        }
//        -----------------start BICICLETAS ----------------------------------------------------------------------------------------
        ArrayList<Bicicleta> bicis = new ArrayList<>(List.of(
                new Bicicleta(1001, "Cannondale", 1200000, 2020),
                new Bicicleta(1002, "Trek", 1450000, 2019),
                new Bicicleta(1003, "Yeti", 2000000, 2020),
                new Bicicleta(1004, "Fuji", 950000, 2021),
                new Bicicleta(1005, "Bmc", 1950000, 1018)
        ));
        for (Bicicleta i : bicis) {
            Bicicleta b = new Bicicleta();
            b.create(i);
        }
//        -----------------start CLIENTES ----------------------------------------------------------------------------------------
        ArrayList<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente("lucky", "Pedro", "Perez", "lucky@gmail.com", "3204563520", 11111111, "2000-01-01"),
                new Cliente("malopez", "Maria", "Lopez", "malopez@gmail.com", "3204563520", 11111111, "2000-01-01"),
                new Cliente("diva", "Ana", "Diaz", "diva@gmail.com", "3204563520", 11111111, "2000-01-01"),
                new Cliente("dreamer", "Luis", "Rojas", "dreamer@gmail.com", "3204563520", 11111111, "2000-01-01"),
                new Cliente("ninja", "Andres", "Cruz", "ninja@gmail.com", "3204563520", 11111111, "2000-01-01"),
                new Cliente("neon", "Nelson", "Ruiz", "neon@gmail.com", "3204563520", 11111111, "2000-01-01"),
                new Cliente("rose", "Claudia", "Mendez", "rose@gmail.com", "3204563520", 11111111, "2000-01-01"),
                new Cliente("green", "Jorge", "Rodriguez", "green@gmail.com", "3204563520", 11111111, "2000-01-01")
        ));
        for (Cliente i : clientes) {
            Cliente c = new Cliente();
            c.create(i);
        }
        //        -----------------start registros ----------------------------------------------------------------------------------------
        ArrayList<Registro> registros = new ArrayList<>(List.of(
                new Registro(4001, "lucky", "Cannondale", "2017-10-25 20:00:00"),
                new Registro(4002, "lucky", "Trek", "2019-03-15 18:30:00"),
                new Registro(4003, "lucky", "Starker", "2019-05-20 20:30:00"),
                new Registro(4004, "malopez", "Cannondale", "2018-05-20 20:30:00"),
                new Registro(4005, "malopez", "Starker", "2020-01-20 20:30:00"),
                new Registro(4006, "diva", "Yeti", "2019-05-20 20:30:00"),
                new Registro(4007, "diva", "Fuji", "2018-06-22 21:30:00"),
                new Registro(4008, "diva", "Lucky Lion", "2020-03-17 15:30:20"),
                new Registro(4009, "dreamer", "Lucky Lion", "2020-03-17 15:30:20"),
                new Registro(4010, "dreamer", "Be Electric", "2020-04-10 18:30:20"),
                new Registro(4011, "ninja", "Aima", "2020-02-17 20:30:20"),
                new Registro(4012, "ninja", "Starker", "2020-02-20 16:30:20"),
                new Registro(4013, "ninja", "Mec de Colombia", "2020-03-27 18:30:20"),
                new Registro(4014, "rose", "Atom Electric", "2020-03-20 21:30:20"),
                new Registro(4015, "green", "Yeti", "2020-01-10 17:30:20"),
                new Registro(4016, "green", "Trek", "2020-02-15 20:30:20"),
                new Registro(4017, "green", "Bmc", "2020-03-17 18:30:20")
        ));
        for (Registro i : registros) {
            Registro r = new Registro();
            r.create(i);
        }
        //        -----------------start SQL ----------------------------------------------------------------------------------------
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setIdBicicleta(1001);
        bicicleta.setAnioContruccion(2017);
        bicicleta.setNombreFabricante("Cannodale");
        bicicleta.update(bicicleta);
        //
        Cliente cliente = new Cliente();
        cliente.setAlias("ninja");
        cliente.setCelular("3115678432");
        cliente.update(cliente);
        //
        Registro registro = new Registro();
        registro.delete("green", "Trek");
        //        -----------------start Consultas ----------------------------------------------------------------------------------------
        System.out.println("Consulta 1");
        Fabricante newFabricante = new Fabricante();
        for (Object f : newFabricante.buscarTodo()) {
            System.out.println(f);
        }
        //
        System.out.println("Consulta 2");
        Bicicleta newBicicleta = new Bicicleta();
        for (Object b : newBicicleta.mayor2019()) {
            System.out.println(b);
        }
        //
        System.out.println("Consulta 3");
        MotocicletaElectrica newMotocicletaElectrica = new MotocicletaElectrica();
        for (Object me : newMotocicletaElectrica.buscarPorProveedor()) {
            System.out.println(me);
        }
        //
        System.out.println("Consulta 4");
        Registro newMarcaRegistro = new Registro();
        for (Object r : newMarcaRegistro.buscarPorNombreRegistro()) {
            System.out.println(r);
        }
        //
        System.out.println("Consulta 5");
        Cliente newCliente = new Cliente();
        for (Object r : newCliente.buscarPorMarcaRegistro()) {
            System.out.println(r);
        }
        //
        System.out.println("Consulta 6");
        System.out.println(newBicicleta.conteoMayor2019());
    }

}
