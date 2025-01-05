/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author angsaegim
 */
@Entity
//Pasarle a la base de datos -> Convertirla en una clase texto Serializable        
public class Contacto implements Serializable{
    
    //Cada objeto tiene un identificador interno del Serializable
    private static final long serialVersionUID=1L;
    
     //Poner id - primary key en la base de datos + decir que es autoincrementable
    @Id
    // Esta en el campo este (la id) 
    @GeneratedValue(strategy=GenerationType.IDENTITY) //ID va a ser autoincrementable
    @Column (name = "IdContacto") //nombre de la columna bd SQL
    
    private int idContacto; //renombrado del campo (como se va a llamar) para usarlo aqui
    
    //resto de campos
    private String nombre;
    private String apellidos;
    private String email;
    @OneToOne
    private String usuario; //ej de tabla usuarios
    
    //Constructores
     public Contacto(int idContacto, String nombre, String apellidos, String email) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Contacto() {
    }

    public Contacto(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }
    
    //getters y setters

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
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

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString
    @Override
    public String toString() {
        return "Contacto{" + "idContacto=" + idContacto + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + '}';
    }
    
}
