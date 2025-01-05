/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;
import java.util.Scanner;

/**
 *
 * @author angsaegim
 */
public class EjerciciosClaseTest {

    static Logger log = LogManager.getFormatterLogger();

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MercadonaPU");

    static EntityManager em = emf.createEntityManager();

    static EntityTransaction et = em.getTransaction();

    static Scanner tcl = new Scanner(System.in);

    public static void main(String[] args) {

        et.begin();

        //Lo he hecho cada cosa en métodos ya que así lo veo mas ordenado
        MetodosEjerciciosClases.createSeccionFrutas();
        System.out.println();

        int opcion;
        do {
            printOptions();
            opcion = tcl.nextInt();  // Leer la opción seleccionada

            switch (opcion) {
                //1. Consultar la secció "Frutas" i selecciona el producte "Manzana"
                case 1:
                    System.out.println("Ejercicio 1.");
                    System.out.println("Consultar sección frutas");
                    MetodosEjerciciosClases.listarProductosSeccion("Frutas");

                    System.out.println("--- Seleccionar Producto Manzana por NamedQuery ---");
                    MetodosEjerciciosClases.seleccionarProductoSección("Frutas", "Manzana");
                    System.out.println("------------------------------------");
                    break;
                //2. Crea una nova secció anomenada "Postres", que tindrà com a responsble a "Peter Lin" i reassigna la poma a aquesta nova secció.
                case 2:
                    System.out.println("Ejercicio 2.");
                    System.out.println("--- Crear sección postres y reasignar manzana ---");
                    MetodosEjerciciosClases.createSeccion("Postres", "Peter Lin");
                    MetodosEjerciciosClases.reasignarProducto("Manzana", "Postres");
                    System.out.println("------------------------------------");
                    break;
                //3. Verifica que la poma apareix ara en la secció de postres i que ja no està a la secció de frutes.
                case 3:
                    System.out.println("Ejercicio 3.");
                    System.out.println("--- Verificar manzana en sección postres y que no está en frutas ---");

                    System.out.println("Sección Frutas ahora:");
                    MetodosEjerciciosClases.listarProductosSeccion("Frutas");

                    System.out.println("Sección Postres ahora:");
                    MetodosEjerciciosClases.listarProductosSeccion("Postres");

                    System.out.println("------------------------------------");
                    break;
                //4. Mostra un llistat complet amb el següent format:
                case 4:
                    System.out.println("Ejercicio 4.");
                    System.out.println("--- ListadoFormateado ---");
                    System.out.println("LISTADO DE TODAS LAS SECCIONES");

                    MetodosEjerciciosClases.listarProductosSeccion("Electrónica");
                    MetodosEjerciciosClases.listarProductosSeccion("Perfumería");
                    MetodosEjerciciosClases.listarProductosSeccion("Frutas");
                    MetodosEjerciciosClases.listarProductosSeccion("Postres");

                    System.out.println("------------------------------------");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Número de ejercicio no válido.");
                    break;
            }
        } while (opcion != 0);

        tcl.close();
    }

    private static void printOptions() {
        StringBuilder sb = new StringBuilder()
                .append("\nElija una opción:\n")
                .append("\t1) Consultar la secció \"Frutas\" i selecciona el producte \"Manzana\"\n")
                .append("\t2) Crea una nova secció anomenada \"Postres\" i reassigna la poma a aquesta nova secció.\n")
                .append("\t3) Verifica que la poma apareix en secció postres i que ja no està a la secció de frutes.\n")
                .append("\t4) llistat complet totes les seccions amb format.\n")
                .append("\t0) Salir\n")
                .append("Opción: ");
        System.out.print(sb.toString());
    }
}
