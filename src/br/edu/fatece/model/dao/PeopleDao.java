package br.edu.fatece.model.dao;

import br.edu.fatece.connection.ConnectionFactory;
import br.edu.fatece.model.bean.People;
import javax.persistence.EntityManager;

/**
 * @author mario
 */
public class PeopleDao {
    
    public People save(People p) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        }finally{
            em.close();
        }
        return p;
    }
    
    public People update(People p) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            if(p.getId() == null) {
                em.persist(p);
            } else {
                em.merge(p);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        }finally{
            em.close();
        }
        return p;
    }
    
    public People findById(int id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        People p = null;
        
        try {
            p = em.find(People.class, id);
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            em.close();
        }
        return p;
    }
    
    public People findById(Integer id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        People t = null;
        
        try {
            t = em.find(People.class, id);
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            em.close();
        }
        return t;
    }
}
