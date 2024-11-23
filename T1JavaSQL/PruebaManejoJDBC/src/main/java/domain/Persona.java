/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author angsaegim
 */
public class Persona {
    
    // Representa los campos de la tabla de la DB persona
    private int idPersona;
    private String nombre;
    private String apellidos;
    private String email;
    private int edad;
    
   public Persona(){
       
   }
   
    public Persona(int idPersona){
        this.setIdPersona(idPersona);
   }
    
   public Persona(String nombre, String apellidos, String email, int edad){
       this.setNombre(nombre);
       this.setApellidos(apellidos);
       this.setEmail(email);
       this.setEdad(edad);
    }

    public Persona(int idPersona, String nombre, String apellidos, String email, int edad) {
        this.setIdPersona(idPersona);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setEmail(email);
        this.setEdad(edad);
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return " ID = [" + idPersona + "] " + nombre + " " + apellidos + " " + email + " " + edad;
    }

}
