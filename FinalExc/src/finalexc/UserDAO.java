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

import java.sql.*;

/**
*
* @author vtkinju
*/
public class UserDAO {
    private String dbUrl = "jdbc:mysql://localhost:3306/java_loppuharj";

    public Users getUsers() {
        Users urs = new Users();
        User u;
        Connection connect = null;
            
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("ID"));
                String name = rs.getString("Name");
                u.setPassword(rs.getString("Password"));
                u.setDescription(rs.getString("Name"));
                u.setName(name); 
                urs.add(u);
                System.out.println("User's name was " + name);

            }
        }
        catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                //---------------------------
            }

        }
        return urs;

    }
    
    public Users addUser(String nimi, String salasana, String kuvaus) {
        Users urs = new Users();
        User u;
        Connection connect = null;
            
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO users (Name, Password, Description) VALUES ('" + nimi + "','" + salasana + "','" + kuvaus + "')");
            
        }
        catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                //---------------------------
            }

        }
        return urs;

    }
    
    public void deleteUser(String nimi) {
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("DELETE FROM users WHERE name LIKE '" + nimi + "';");

        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                //---------------------------
            }

        }
    }
}
