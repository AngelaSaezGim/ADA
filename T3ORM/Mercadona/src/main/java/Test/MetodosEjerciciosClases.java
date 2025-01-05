/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Entidad.Producto;
import Entidad.Seccion;
import static Test.EjerciciosClaseTest.em;
import static Test.EjerciciosClaseTest.et;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author angel
 */
public class MetodosEjerciciosClases {

    //EXTRA - crear seccion frutas antes de nada
    public static void createSeccionFrutas() {

        System.out.println("Creamos la sección frutas");
        String nombreSeccion = "Frutas";

        try {
            //HE CREADO ESTO PARA VERIFICAR SI EXISTE EN LA BD ANTES DE CREARLA
            List<?> resultados = em.createQuery("SELECT s FROM Seccion s WHERE s.seccion = :nombreSeccion")
                    .setParameter("nombreSeccion", nombreSeccion)
                    .getResultList();

            if (!resultados.isEmpty()) {
                System.out.println("La sección 'Frutas' ya existe en la base de datos. No se creará nuevamente.");
                return;
            }

            //Nueva seccion FRUTAS
            Seccion nuevaSeccion = new Seccion();
            nuevaSeccion.setSeccion(nombreSeccion);
            nuevaSeccion.setResponsable("Pepito");

            //Nuevos productos asociados a esa seccion (FRUTAS)
            Producto producto1 = new Producto();
            producto1.setNombre("Manzana");
            producto1.setPrecio(1);
            producto1.setDescripcion("manzana deluxe");
            producto1.setSeccion(nuevaSeccion);

            Producto producto2 = new Producto();
            producto2.setNombre("Kiwi");
            producto2.setPrecio(3.5f);
            producto2.setDescripcion("kiwi gold");
            producto2.setSeccion(nuevaSeccion);

            //asignamos productos a seccion
            List<Producto> productos = new ArrayList<>();

            productos.add(producto1);
            productos.add(producto2);

            nuevaSeccion.setProductos(productos);

            // Iniciar transacción
            if (!et.isActive()) {
                et.begin();
            }

            //Guardalo en bd
            em.persist(nuevaSeccion);
            et.commit();
            System.out.println("Sección frutas con sus productos creada correctamente");
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }

    // YA FORMATEADO PARA EL EJERCICIO 4
    public static void listarProductosSeccion(String nombreSeccion) {

        //Listado productos seccion - Busca sección por nombreSeccion
        try {
            // Named Query buscar la sección y sus producto
            List<Seccion> secciones = em.createNamedQuery("Seccion.findSeccionConProductos", Seccion.class)
                    .setParameter(1, nombreSeccion)
                    .getResultList();

            if (secciones.isEmpty()) {
                System.out.println("No se encontró la sección '" + nombreSeccion + "'.");
                return;
            }

            // Obtener la primera sección
            Seccion seccion = (Seccion) secciones.get(0);

            System.out.println("Secció: " + seccion.getSeccion());
            System.out.println("  Productes:");

            // Obtener los productos de la sección
            List<Producto> productos = seccion.getProductos();

            if (productos.isEmpty()) {
                System.out.println("   Cap producte assignat.");
            } else {
                int contador = 1;
                for (Producto producto : productos) {
                    System.out.println("   " + contador + ". - Nom del producte: " + producto.getNombre() + ", Preu: " + producto.getPrecio());
                    contador++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //(Seleccionar Manzana)
    public static void seleccionarProductoSección(String nombreSeccion, String nombreProducto) {

        try {
            Query query = em.createNamedQuery("Seccion.findSeccion");
            query.setParameter(1, nombreSeccion);

            List<Seccion> seccionSeleccionada = query.getResultList();

            if (seccionSeleccionada.isEmpty()) {
                System.out.println("No se encontró ninguna sección con el nombre '" + nombreSeccion + "'.");
            } else {
                boolean productoEncontrado = false;

                for (Seccion seccion : seccionSeleccionada) {
                    System.out.println("Sección: " + seccion.getSeccion() + ", Responsable: " + seccion.getResponsable());

                    //Buscamos productos en esa sección
                    for (Producto producto : seccion.getProductos()) {
                        if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                            System.out.println("Producto encontrado : " + producto.getNombre() + ", Precio: " + producto.getPrecio());
                            productoEncontrado = true;
                            break;
                        }
                    }
                }
                if (!productoEncontrado) {
                    System.out.println("No existen productos con el nombre '" + nombreProducto + "' en la sección '" + nombreSeccion + "'.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Crear seccion postres
    public static void createSeccion(String nombreSeccion, String responsableSeccion) {

        System.out.println("Creamos la sección " + nombreSeccion);

        try {
            //HE CREADO ESTO PARA VERIFICAR SI EXISTE EN LA BD ANTES DE CREARLA
            List<?> resultados = em.createQuery("SELECT s FROM Seccion s WHERE s.seccion = :nombreSeccion")
                    .setParameter("nombreSeccion", nombreSeccion)
                    .getResultList();

            if (!resultados.isEmpty()) {
                System.out.println("La sección " + nombreSeccion + " ya existe en la base de datos. No se creará nuevamente.");
                return;
            }

            //Nueva seccion FRUTAS
            Seccion nuevaSeccion = new Seccion();
            nuevaSeccion.setSeccion(nombreSeccion);
            nuevaSeccion.setResponsable(responsableSeccion);

            // Iniciar transacción
            if (!et.isActive()) {
                et.begin();
            }

            //Guardalo en bd
            em.persist(nuevaSeccion);
            et.commit();
            System.out.println("Sección " + nombreSeccion + " creada correctamente");

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }

    //Reasignacion manzana a postres
    public static void reasignarProducto(String nombreProducto, String seccionAAñadirStr) {
      
        System.out.println("Reasignando productos '" + nombreProducto + "' a la sección '" + seccionAAñadirStr + "'...");

        try {
            // NamedQuery para obtener los productos con el nombre
            List<Producto> productos = em.createNamedQuery("Producto.findProductosPorNombre", Producto.class)
                    .setParameter(1, nombreProducto)
                    .getResultList();

            if (productos.isEmpty()) {
                System.out.println("No se encontraron productos con el nombre " + nombreProducto);
                return;
            }

            //Coger seccion seccionAAñadir
            // Usar NamedQuery para obtener la sección de destino
            List<Seccion> secciones = em.createNamedQuery("Seccion.findSeccion", Seccion.class)
                    .setParameter(1, seccionAAñadirStr)
                    .getResultList();

            if (secciones.isEmpty()) {
                System.out.println("No se encontró la sección '" + seccionAAñadirStr + "'");
                return;
            }
            //Convertir la list de seccion en Objeto seccion
            Seccion seccionAAñadir = secciones.get(0);

            if (!et.isActive()) {
                et.begin();
            }

            for (Producto producto : productos) {
                System.out.println("Producto antes de reasignar: " + producto);
                producto.setSeccion(seccionAAñadir); //Asignarles el objeto sección a los productos
                em.merge(producto); // Actualizar los productos
            }
            et.commit();

            System.out.println("Productos '" + nombreProducto + "' reasignados a la sección '" + seccionAAñadirStr + "' con éxito.");

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }

}
