/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import datos.Conexion;

import java.util.*;
import java.sql.SQLException;
import domain.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author angsaegim
 */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellidos, email, edad FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellidos, email, edad) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellidos = ?, email= ?, edad = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public List<Persona> seleccionar() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                persona = new Persona(idPersona, nombre, apellidos, email, edad);
                personas.add(persona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setInt(4, persona.getEdad());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {

            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(int idPersona, Persona persona) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setInt(4, persona.getEdad());
            stmt.setInt(5,idPersona);
            filas = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {

            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return filas;

    }
    
    public int eliminar(int idPersona) throws SQLException {
        
       Connection conn = null;
       PreparedStatement stmt = null;
       int filasAfectadas=0;
       
       try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idPersona);
            filasAfectadas = stmt.executeUpdate();
       }catch(SQLException ex){
            ex.printStackTrace(System.out);
       }finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {

            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return filasAfectadas;
        
    }
}
