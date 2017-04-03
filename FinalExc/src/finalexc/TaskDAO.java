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
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author vtkinju
 */
public class TaskDAO {

    private String dbUrl = "jdbc:mysql://localhost:3306/java_loppuharj";

    public Tasks getTasks() {
        Tasks tas = new Tasks();
        Task t;
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks");
            while (rs.next()) {
                t = new Task();
                t.setId(rs.getInt("ID"));
                t.setUser_id(rs.getInt("user_id"));
                t.setStart(rs.getString("start"));
                t.setEnd(rs.getString("end"));
                t.setDescription("description");
                t.setPlace("place");
                tas.add(t);
                System.out.println("Task was ");

            }
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
        return tas;

    }

    public Tasks addTask(String start, String end, String description, String place) {
        Tasks tas = new Tasks();
        Task t;
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO tasks (user_id, start, end, description, place) VALUES (null, '" + start + "','" + end + "','" + description + "','" + place + "')");

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
        return tas;

    }

    public Tasks addStart(int id) {
        String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(start);
        Tasks tas = new Tasks();
        Task t;
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("UPDATE tasks SET start = '" + start + "' WHERE ID = " + id + " ");

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
        return tas;

    }
    public Tasks addId(int user_id, int id) {
        Tasks tas = new Tasks();
        Task t;
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("UPDATE tasks SET user_id = '" + user_id + "' WHERE ID = " + id + " ");

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
        return tas;

    }
    
    public Tasks addEnd(int id) {
        String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(end);
        Tasks tas = new Tasks();
        Task t;
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("UPDATE tasks SET end = '" + end + "' WHERE ID = " + id + " ");

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
        return tas;

    }

    public void deleteTask(String description) {
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("DELETE FROM tasks WHERE description LIKE '" + description + "';");

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
