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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author angsaegim
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Producto.findProductosPorNombre", query = "SELECT p FROM Producto p WHERE p.nombre = ?1")
})
public class Producto implements Serializable  {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column (name = "IdProducto") 
     
    private int idProducto;
    //resto de campos
    private String nombre;
    private float precio;
    private String descripcion;
    
    // NUEVO - Encontraras idSeccion en el campo idSeccion de seccion
    @ManyToOne
    @JoinColumn (name="IdSeccion", referencedColumnName="idSeccion")
    private Seccion seccion;

    public Producto(int idProducto, String nombre, float precio, String descripcion, Seccion seccion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.seccion = seccion;
    }

    public Producto(String nombre, float precio, String descripcion, Seccion seccion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.seccion = seccion;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
    return "Producto {" +
           "idProducto=" + idProducto +
           ", nombre='" + nombre + '\'' +
           ", precio=" + precio +
           ", descripcion='" + descripcion + '\'' +
           ", seccion=" + (seccion != null ? seccion.getSeccion() : "null") +
           '}';
}
    
    
    
    
}
