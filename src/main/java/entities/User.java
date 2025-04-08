package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DatabaseConnection;

public class User {

    private String username;
    private String password;

    public User(String username,String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public static boolean checkUser(User u) {
    String sql = "SELECT password FROM users WHERE username = ?";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement statement = conn.prepareStatement(sql)) {
        
        statement.setString(1, u.getUsername());
        
        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {

                String storedHash = rs.getString("password");
        
                return storedHash.equals(u.getPassword());
            }
            return false; 
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }

    }


}
