/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Entidad.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;
/**
 *
 * @author angel
 */
public class EntidadContactoTest {
    
    //variable tipo logger - para ver los mensajes de error que queremos
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaUP");
        
        //Me crea el entityManager
        EntityManager em = emf.createEntityManager();
        
        //Me crea entity Transaction
        EntityTransaction tx = em.getTransaction();
        
        //inicio transaccion - conjunto de instrucciones de forma atomica (si falla una fallan todas atras)
        tx.begin();
        
        //Crear objeto contacto (import entity contacto)
        Contacto contacto1 = new Contacto("Antonio","Perez","Antonio@gmail.com");
        
        //logs
        log.debug("Objecto a persistir: " + contacto1);
        
        //persistir el objeto
        em.persist(contacto1);
        
        //Busqueda registro
        Contacto contacto2 = new Contacto();
        contacto2 = em.find(Contacto.class, 1); //si sabemos la primary key
        
        System.out.println("La persona buscada es " + contacto2);
        
        //Actualizar un registro
        contacto2.setNombre("Juancho");
        //Luego persistir en BD
        em.merge(contacto2);
        
        //Borrar un registro
        Contacto contactoBorrar = new Contacto();
        
        contactoBorrar = em.find(Contacto.class, 1);
        em.remove(contactoBorrar);
        
        // finalizar la transaccion
        tx.commit();
        log.debug("Objeto persistido correctamente " + contacto1);
        
        //cerrar entityManager
        em.close();
        
        //EntityManager tantos como clases diferentes (de tablas) que usamos
        //La entityManagerFactory es la misma
        
    }
}
