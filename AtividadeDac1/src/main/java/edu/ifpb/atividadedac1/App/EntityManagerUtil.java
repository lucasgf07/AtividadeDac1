package edu.ifpb.atividadedac1.App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class EntityManagerUtil {
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;
   
    public static EntityManager getEntityManager(){
        if (factory == null){
            factory = Persistence.createEntityManagerFactory("AtividadeDac");
        }
        if(em == null){
            em = factory.createEntityManager();
        }
        return em;      
    }
}
