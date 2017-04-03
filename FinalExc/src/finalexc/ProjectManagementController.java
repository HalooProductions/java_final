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
    
    public void addUser(String nimi, String salasana, String kuvaus) {
        new UserDAO().addUser(nimi, salasana, kuvaus);
    }
    
    public void deleteUser(String nimi) {
        new UserDAO().deleteUser(nimi);
    }
    
    public boolean isCorrectUser(String nimi, String salasana) {
        return new UserDAO().getWithNameAndPassword(nimi, salasana);
    }
   
}