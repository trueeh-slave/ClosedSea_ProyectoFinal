package co.edu.unbosque.closedsea_proyectofinal.services;

import co.edu.unbosque.closedsea_proyectofinal.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    private static Connection conn;

    public UserService(Connection conn) {
        this.conn = conn;
    }

    public User newUser(User user) {
        // Object for handling SQL statement
        PreparedStatement stmt = null;// Data structure to map results from database
        if (user != null) {
            try {
                if (user.getRole().equals("artista")) {
                    stmt = this.conn.prepareStatement("INSERT INTO userapp (email, password, name, role ) \n" +
                            "VALUES (?,?,?,'artista')");
                } else if (user.getRole().equals("comprador")) {
                    stmt = this.conn.prepareStatement("INSERT INTO userapp (email, password, name, role ) \n" +
                            "VALUES (?,?,?,'comprador')");
                }
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getName());
                stmt.setString(4, user.getRole());

                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException se) {
                se.printStackTrace(); // Handling errors from database
            } finally {
                // Cleaning-up environment
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            return user;
        } else {
            return null;
        }
    }

    public List<User> getUsers() throws SQLException {
        Statement statement = null;
        List<User> userList = new ArrayList<>();

        try{
            statement = conn.createStatement();
            String sqlQuery = "SELECT email, password, name, role FROM userapp";
            ResultSet result = statement.executeQuery(sqlQuery);

            while(result.next()){
                String email = result.getString("email");
                String password = result.getString("password");
                String name = result.getString("name");
                String role = result.getString("role");

                userList.add(new User(email,password,name,role));

                result.close();
                statement.close();
            }
        } catch (SQLException se){
            se.printStackTrace();
        } finally {
            try {
                if(statement != null) statement.close();
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        return userList;
    }
}

