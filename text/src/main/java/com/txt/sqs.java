package com.txt;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.ListQueuesResult;

public class sqs {
    public static void main(String[] args) {
        AmazonSQS s1=AmazonSQSClient.builder().withRegion("eu-west-1").build();

        // creation of the queue
        // s1.createQueue("ruchitha");
        // System.out.println("successfully created queue"+s1);

        // sending  a message

        // SendMessageRequest sm=new SendMessageRequest("ruchitha", "helloo hai how  are you");
        // s1.sendMessage(sm);
        // System.out.println("sucessfully send a message "+sm);


        // ListQueuesResult rq=s1.listQueues();
        // System.out.println("you sqs queues are"+rq);


    // GetQueueUrlResult queue=s1.getQueueUrl("ruchitha");

    // System.out.println("the queue url is "+queue);

    ListQueuesResult rq=s1.listQueues();
    System.out.println("the queues "+rq);
    

        
        }



    }
    

