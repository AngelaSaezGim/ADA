/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author angsaegim
 */
public class TestManejoPersonas {

    private static Scanner tcl = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        PersonaDAO personaDao = new PersonaDAO();

        //Ver las personas que tenemos
        List<Persona> personas = personaDao.seleccionar();
        personas.forEach(persona -> {
            System.out.println("persona =" + persona);
        });

        //insertando 2 nuevos objetos de tipo persona
        Persona personaNueva = new Persona("nuevo", "apellidonuevo", "corre33o@hotmail.es", 98);
        personaDao.insertar(personaNueva);
        System.out.println("Nuevas personas insertadas");
        personas.forEach(persona -> {
            System.out.println("persona =" + persona);
        });

        /*
        System.out.println("Se actualiza a la persona con la id 12");
        Persona personaActualizada = new Persona("anngela2", "saez", "correo777@hotmail.es", 28);
        personaDao.actualizar(12, personaActualizada); // Se actualizará la persona con id 1
*/
        System.out.println("Se borra la persona con el id 11 e id 12 (que hemos creado antes)");
        personaDao.eliminar(11);
        personaDao.eliminar(12);
    }

}
