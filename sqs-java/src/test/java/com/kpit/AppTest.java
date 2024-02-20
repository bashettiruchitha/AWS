package com.kpit;

import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;


public class AppTest 
{
    
public static void main(String[] args)
 {


AmazonSQS sqs=AmazonSQSClient.builder().
withCredentials(new ProfileCredentialsProvider()).
withRegion("us-east-2").build();
// SQS SENDING THE MESSAGE

// SENDING THE MESSAGE TO  A PARTICULAR REGION SO WE HAVE TO USE A PARTICULAR REGION
String q1="https://sqs.us-east-2.amazonaws.com/106129732153/myqueue";
SendMessageRequest req=new SendMessageRequest().withQueueUrl(q1).withMessageBody("hello ruchitha");
sqs.sendMessage(req);

sqs.createQueue("hello");



// LISTING THE MESSAGES AND RECEIVING THE MESSAGES.
List<Message> messages=sqs.receiveMessage(q1).getMessages();

for (Message message : messages) {
    System.out.println("Message"+message.getBody());
    System.out.println("Attributes"+message.getAttributes());
    System.out.println("delete from the queue");//DELETING THE MESSAGE ..

    // String handle=message.getReceiptHandle();
    // sqs.deleteMessage(q1,handle);
     
}

   }
}
