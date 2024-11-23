/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author angsaegim
 */
public class Conexion {

    /*
    CREATE SCHEMA prueba;
USE prueba;

CREATE TABLE persona (
  Id_persona INT NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(32) NOT NULL,
  Apellidos VARCHAR(32) NOT NULL,
  Email VARCHAR(50) NOT NULL,
  Edad INT NOT NULL,
  PRIMARY KEY (Id_persona)
);

INSERT INTO persona VALUES (null,'Angela','Saez','email@hola.com',21);
INSERT INTO persona VALUES (null,'paco','Saez','email@hola.com',61);
INSERT INTO persona VALUES (null,'maria','sanchez','email3333@hola.com',31);

SELECT *
FROM persona;

    
    
     */
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/prueba?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "serpis";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
