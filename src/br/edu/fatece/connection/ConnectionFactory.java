package br.edu.fatece.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author mario
 */
public class ConnectionFactory {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");
    
    public EntityManager getConnection() {
        return emf.createEntityManager();
    }
    
}
