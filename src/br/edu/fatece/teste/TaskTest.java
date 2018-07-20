
package br.edu.fatece.teste;

import br.edu.fatece.model.bean.People;
import br.edu.fatece.model.bean.Task;
import br.edu.fatece.model.dao.PeopleDao;
import br.edu.fatece.model.dao.TaskDao;
import java.util.Calendar;


public class TaskTest {
    
    public static void main(String[] args) {
        
        Task t;
        TaskDao tdao = new TaskDao();
        
        t = tdao.findById(1);
        
        System.out.print("Task: " + t.getTask());
        System.out.println(" Pessoa: " + t.getPeople().getNome());
        
   }
    
}
