package project.bdUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // jeżeli hasło i użytkownik są wymagane np. dla mySql
    //private static final String USERNAME ="dbuser";
    //private static final String PASWORD = "dbpassword";
    private static final String CONN = "jdbc:mysql://localhost/bazaDanych";
    private static final String SQCONN = "jdbc:sqlite:bazaDanych.sqlite";

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        System.out.println("conn");
        return null;
    }

}
