/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Tipo statement + query
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author angsaegim
 */


// INTRODUCCION A ACCESO A DATOS - CONEXION BASE DE DATOS CON MAVEN
public class TestMySQLJDBC {

    //Crear conexion
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/prueba?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //puede ser que sea requerido lo siguiente
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "serpis");

            //Tipo statement
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, nombre, apellidos, edad FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Id Persona: " + resultado.getInt("id_persona"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Apellidos " + resultado.getString("apellidos"));
                System.out.println("Id Persona: " + resultado.getInt("edad"));
                System.out.println(" ");
            }
            
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
