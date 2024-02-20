package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppTest 
{
    private static final String url = "jdbc:mysql://sampledb.cimr0kdyqj64.us-east-1.rds.amazonaws.com/sampledb";
    private static final String user = "admin";
    private static final String password = "Password!123";

    public static void main(String[] args) {
        Connection conn =  null;
        // loading a driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            System.out.println("unable to load jdbc for mysql"+e.getMessage());
            return;


        }
        // connections
        try{
            conn=DriverManager.getConnection(url,user,password);
            System.out.println("connected to database");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        // fetching
        try{
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery("select *from emp3");
            System.out.println("fetching results");
            while (rs.next()) {
                System.out.println(rs.getInt(1)+""+rs.getString(2));
                
            }
            System.out.println("----------");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
