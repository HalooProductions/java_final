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
                t.setDescription(rs.getString("description"));
                t.setPlace(rs.getString("place"));
                tas.add(t);
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
    
    public Tasks getOpenTasks() {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks WHERE user_id IS NULL");
            while (rs.next()) {
                t = new Task();
                t.setId(rs.getInt("ID"));
                t.setUser_id(rs.getInt("user_id"));
                t.setStart(rs.getString("start"));
                t.setEnd(rs.getString("end"));
                t.setDescription(rs.getString("description"));
                t.setPlace(rs.getString("place"));
                tas.add(t);
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

    public Tasks addTask(String description, String place) {
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
            int rs = stmt.executeUpdate("INSERT INTO tasks (user_id, description, place) VALUES (null, '" + description + "','" + place + "')");

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
        boolean addStart = false;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement getStmt = connect.createStatement();
            ResultSet getRs = getStmt.executeQuery("SELECT * FROM tasks WHERE id = " + id + " ");
            while (getRs.next()) {
                String startDate = getRs.getString("start");
                if (startDate == null) {
                    addStart = true;
                }
            }
            
            if (addStart) {
                Statement stmt = connect.createStatement();
                int rs = stmt.executeUpdate("UPDATE tasks SET start = '" + end + "', end = '" + end + "' WHERE ID = " + id + " ");
            } else {
                Statement stmt = connect.createStatement();
                int rs = stmt.executeUpdate("UPDATE tasks SET end = '" + end + "' WHERE ID = " + id + " ");
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

    public void deleteTask(int id) {
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("DELETE FROM tasks WHERE id = '" + id + "';");

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
    
    public User getUser(int id) {
        User u = new User();
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '" + id + "'");
            while (rs.next()) {
                u.setId(rs.getInt("ID"));
                u.setName(rs.getString("name"));
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
        
        return u;
    }
    
    public void reserveForUser(int id, int user_id) {
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
    }
    
    public Tasks getUserTasks(int id) {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks WHERE user_id = " + id + " AND end IS NULL;");
            while (rs.next()) {
                t = new Task();
                t.setId(rs.getInt("ID"));
                t.setUser_id(rs.getInt("user_id"));
                t.setStart(rs.getString("start"));
                t.setEnd(rs.getString("end"));
                t.setDescription(rs.getString("description"));
                t.setPlace(rs.getString("place"));
                tas.add(t);
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
    
    public Tasks getCompletedTasks() {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks WHERE end IS NOT NULL;");
            while (rs.next()) {
                t = new Task();
                t.setId(rs.getInt("ID"));
                t.setUser_id(rs.getInt("user_id"));
                t.setStart(rs.getString("start"));
                t.setEnd(rs.getString("end"));
                t.setDescription(rs.getString("description"));
                t.setPlace(rs.getString("place"));
                tas.add(t);
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
    
    public boolean registerUser(String name, String password) {
        Connection connect = null;
        boolean returnVal = false;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(dbUrl, "root", "");
            if (!connect.isClosed()) {
                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            }
            Statement stmt = connect.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO users (name, password, description) VALUES ('" + name + "', '" + password + "', 'New user')");
            if (rs >= 0) {
                returnVal = true;
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
        return returnVal;
    }
}
