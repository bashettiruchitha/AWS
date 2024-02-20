package com.txt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class App3 {
    private static final String DB_URL = "jdbc:mysql://ruchitha-bills.cj8000i6gxgi.eu-west-1.rds.amazonaws.com/bills";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "Ruchi123";
    public static void main(String[] args) {
      AmazonSQS amazonSQS = AmazonSQSClient.builder().withRegion("eu-west-1").build();
      System.out.println("SQS Laoded");

      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("Connection Established....");

        Statement statement = con.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM utilitytable");

        while (resultSet.next()) {
            String var1 = resultSet.getString(1);
           int var3 = resultSet.getInt(3);

           
            SendMessageRequest sendMessageRequest = new SendMessageRequest().withQueueUrl("https://sqs.eu-west-1.amazonaws.com/106129732153/ruchitha").withMessageBody("Your " + var1 + "bill is " + var3);
            amazonSQS.sendMessage(sendMessageRequest);
            System.out.println("Message Sent");


        }
        

      } catch (ClassNotFoundException e) {
        // TODO: handle exception
      }
      catch(SQLException exp)
      {
        exp.printStackTrace();
      }



    }
}
