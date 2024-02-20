package com.txt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;

/**
 * Hello world!
 *
 */
public class App {
    private static final String DB_URL = "jdbc:mysql://ruchitha-bills.cj8000i6gxgi.eu-west-1.rds.amazonaws.com/bills";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "Ruchi123";

    public static void main(String[] args) {

        // AmazonSNS client = AmazonSNSClient.builder().withCredentials(new ProfileCredentialsProvider())
        //         .withRegion("eu-west-1").build();
        AmazonSNS client=AmazonSNSClient.builder().withRegion("eu-west-1").build();

        System.out.println("client load ");

        String topicArcn = "arn:aws:sns:eu-west-1:106129732153:ruchitha-topic";

        try

        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement resultStatement = connection.createStatement();
            ResultSet rs = resultStatement.executeQuery("select * from utilitytable");

            while (rs.next()) {
                String month = rs.getString(1);
                int mount = rs.getInt(3);

                // PublishRequest publishRequest = new PublishRequest().withTopicArn(topicArcn)
                //         .withMessage("your bill for month" + month + "please pay the amount " + mount);
                // client.publish(publishRequest);
                client.publish(topicArcn,"your bill for the month"+month+"is:"+mount+"monthly bills");
                System.out.println("published ");
            }
        } catch (SQLException e) {
            System.out.println("sql exception" + e);
        } catch (ClassNotFoundException e1) {
            System.out.println("class not found exception" + e1);

        }



    }
}
