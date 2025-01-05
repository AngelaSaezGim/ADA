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
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author angsaegim
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Seccion.findSeccion",query="SELECT s FROM Seccion s WHERE s.seccion = ?1"),
    @NamedQuery(name = "Seccion.findSeccionConProductos", query = "SELECT s FROM Seccion s JOIN FETCH s.productos WHERE s.seccion = ?1")
})

public class Seccion  implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column (name = "IdSeccion") 
    
    private int idSeccion;
    //resto de campos
    private String responsable;
    private String seccion;
    
    // NUEVO - Parte inverso de productos (por cada seccion hay muchos productos)
    //Cada seccion tendra una lista de productos
    @OneToMany (mappedBy="seccion",cascade = CascadeType.ALL) //Parte inversa de la relacion
    private List<Producto> productos;

    public Seccion(int idSeccion, String responsable, String seccion, List<Producto> productos) {
        this.idSeccion = idSeccion;
        this.responsable = responsable;
        this.seccion = seccion;
        this.productos = productos;
    }

    public Seccion(String responsable, String seccion, List<Producto> productos) {
        this.responsable = responsable;
        this.seccion = seccion;
        this.productos = productos;
    }

    public Seccion() {
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "-> Seccion{" + "idSeccion=" + idSeccion + ", responsable=" + responsable + ", seccion=" + seccion + "\n productos=" + productos + '}';
    }

    
}
