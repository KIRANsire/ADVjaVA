package com.studentapp;
import java.sql.*;

public class DBConnection {
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/simpledb", 
                    "root", 
                    "8S7r435j@"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}