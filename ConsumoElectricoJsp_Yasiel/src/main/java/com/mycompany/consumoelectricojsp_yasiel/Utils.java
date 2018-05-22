package com.mycompany.consumoelectricojsp_yasiel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yasie
 */
public class Utils {

    /*
    
    
    database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://localhost/consumoelectrico?profileSQL=true&serverTimezone=UTC
database.user=2daw
database.password=2daw
database.pageSize=10
     */
    public static String dbUrl = "jdbc:mysql://localhost/consumoelectrico?profileSQL=true&serverTimezone=UTC";
    public static String dbUser = "2daw";
    public static String dbPassword = "2daw";
    public static Integer dbPageSize = 10;
    public static Integer DEFAULT_PAGESIZE = 10;
    public static String driverClassName = "com.mysql.jdbc.Driver";
    public static String classForName;

    public static ArrayList<Cliente> getAllClientes() {

        Connection conexion = null;

        ArrayList<Cliente> clien = new ArrayList<Cliente>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            Statement s = conexion.createStatement();

            ResultSet rs = s.executeQuery("select * from misclientes limit " + dbPageSize);

            while (rs.next()) {
                Cliente cc = new Cliente();
                cc.setId(rs.getInt("Id"));
                cc.setNombre(rs.getString(2));
                cc.setApellido(rs.getString(3));
                cc.setNombreCalle(rs.getString(4));
                cc.setNumero(rs.getInt(5));
                cc.setCodPostal(rs.getInt(6));
                cc.setPoblacion(rs.getString(7));
                cc.setProvincia(rs.getString(8));
                clien.add(cc);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return clien;
    }
}
