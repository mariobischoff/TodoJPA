package br.edu.fatece.model.dao;

import br.edu.fatece.connection.ConnectionFactory;
import br.edu.fatece.model.bean.Task;
import javax.persistence.EntityManager;

/**
 * @author mario
 */
public class TaskDao {
    
    public Task save(Task t) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return t;
        
    }
    
    public Task update(Task t) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            if(t.getId() == null) {
                em.persist(t);
            } else {
                em.merge(t);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return t;
    }
    
    public Task findById(int id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        Task t = null;
        
        try {
            t = em.find(Task.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return t;
    }
    
    public Task remove(int id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        Task t = null;
        
        try {
            t = em.find(Task.class, id);
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        }finally{
            em.close();
        }
        return t;
    }
   
    
    
    
}
