package br.edu.fatece.teste;

import br.edu.fatece.model.bean.People;
import br.edu.fatece.model.dao.PeopleDao;

/**
 * @author mario
 */
public class PeopleTest {
    
    public static void main(String[] args) {
        
        PeopleDao dao = new PeopleDao();
        People p;
        
        p = dao.findById(1);
        
        System.out.println("Nome: " + p.getNome());
    }
}
