/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vtkinju
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalexc;

public class ProjectManagementController {
    public Users getUsers() {
        return new UserDAO().getUsers();
    }
    
    public User getUser(String nimi, String salasana) {
        return new UserDAO().getUser(nimi, salasana);
    }
    
    public void addUser(String nimi, String salasana, String kuvaus) {
        new UserDAO().addUser(nimi, salasana, kuvaus);
    }
    
    public void deleteUser(String nimi) {
        new UserDAO().deleteUser(nimi);
    }
    
    public boolean isCorrectUser(String nimi, String salasana) {
        return new UserDAO().getWithNameAndPassword(nimi, salasana);
    }
    
    public Tasks getTasks() {
        return new TaskDAO().getTasks();
    }   
    
    public Tasks getOpenTasks() {
        return new TaskDAO().getOpenTasks();
    }
    
    public Tasks getUserTasks(int id) {
        return new TaskDAO().getUserTasks(id);
    }
    
    public void reserveTaskForUser(int id, int user_id) {
        new TaskDAO().reserveForUser(id, user_id);
    }
    
    public void addTask(String description, String place) {
        new TaskDAO().addTask(description, place);
    }
    
    public void deleteTask(int id) {
        new TaskDAO().deleteTask(id);
    }
    
    public void startTask(int id) {
        new TaskDAO().addStart(id);
    }
    
    public void endTask(int id) {
        new TaskDAO().addEnd(id);
    }
    
    public Tasks getCompletedTasks() {
        return new TaskDAO().getCompletedTasks();
    }
    
    public boolean registerUser(String name, String password) {
        return new TaskDAO().registerUser(name, password);
    }
}