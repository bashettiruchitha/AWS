package com.txt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class employees {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            String url="jdbc:mysql://ruchitha-bills.cj8000i6gxgi.eu-west-1.rds.amazonaws.com/ruchitha";
            String username="admin";
            String pwd="Ruchi123";



            // --------------------------------------------------------------

            // display all the records 

        //     try{
        //         Class.forName("com.mysql.cj.jdbc.Driver");
        //     System.out.println("connection ");

        //     Connection con=DriverManager.getConnection(url,username,pwd);

        //     System.out.println("connected successfully");

        //     Statement st= con.createStatement();
        //     ResultSet rs=st.executeQuery("select * from employees");
        //     while (rs.next()) {
        //         System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3));
                
        //     }
        
        // }catch(SQLException e1){
        //     System.out.println("sql excpetion"+e1);
        // }



        // --------------------------------------------------
    

        // insert into tables
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("connection ");

            // Connection con=DriverManager.getConnection(url,username,pwd);

            // System.out.println("connected successfully");
            // PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?)");

            // Scanner s1=new Scanner(System.in);
            // Scanner s2=new Scanner(System.in);
            // Scanner s3=new Scanner(System.in);

            // System.out.println("enter the emp id");
            // int newid=s1.nextInt();

            // System.out.println("enter the new name ");
            // String newname =s2.nextLine();

            // System.out.println("enter the new age");
            // int newage=s3.nextInt();

            // ps.setInt(1,newid);
            // ps.setString(2, newname);
            // ps.setInt(3, newage);

            // int rowsUpdated=ps.executeUpdate();
            // System.out.println("rows updated"+rowsUpdated);

            // ps.close();
            // con.close();
        

            // ----------------------------------------------------


            // update  the record 



            // Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("connection ");

            // Connection con=DriverManager.getConnection(url,username,pwd);

            // System.out.println("connected successfully");
            // PreparedStatement ps=con.prepareStatement("update employees set empname=?,empage=? where empid=?");

            // Scanner s1=new Scanner(System.in);
            // Scanner s2=new Scanner(System.in);
            // Scanner s3=new Scanner(System.in);


            // System.out.println("enter the existing id ");
            // int id=s1.nextInt();

            // System.out.println("enter the modify the name");
            // String newname=s2.nextLine();


            // System.out.println("enter the modify the age  ");
            // int newage=s3.nextInt();

            // ps.setInt(3, id);
            // ps.setString(1, newname);
            // ps.setInt(2, newage);


            // int rowsUpdated=ps.executeUpdate();
            // System.out.println("the rows are updated "+rowsUpdated);

            // ps.close();
            // con.close();


            // ---------------------------------------------

            // delete the recored 


            // Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("connection ");

            // Connection con=DriverManager.getConnection(url,username,pwd);

            // System.out.println("connected successfully");
            // PreparedStatement ps=con.prepareStatement("delete from employees where empid=?");

            //  Scanner s1=new Scanner(System.in);
            //  System.out.println("enter the id to be deleted ");
            //  int id=s1.nextInt();

            //  ps.setInt(1, id);
            //  int rowsdeleted=ps.executeUpdate();
            //  System.out.println("the rows are deleted "+rowsdeleted);

            //  ps.close();
            //  con.close();

            // select a single recored

             Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connection ");

            Connection con=DriverManager.getConnection(url,username,pwd);

            System.out.println("connected successfully");
        PreparedStatement ps=con.prepareStatement("select *from employees where empid=?");
        Scanner s1= new Scanner(System.in);
        System.out.println("enter the id to display the values");
        int id=s1.nextInt();
        ps.setInt(1, id);

        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            System.out.println("empid"+rs.getInt(1));
            System.out.println("empname"+rs.getString(2));
            System.out.println("empage"+rs.getInt(3));
            
        }

        ps.close();
        con.close();
    }

}      















  