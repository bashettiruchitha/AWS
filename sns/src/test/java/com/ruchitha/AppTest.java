package com.ruchitha;

import java.util.List;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.Topic;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String[] args) {
        AmazonSNS client= AmazonSNSClient.builder().withRegion("us-east-1").build();
     
        ListTopicsResult rs=client.listTopics();//list the topic names
         List<Topic>tp=rs.getTopics();
         for (Topic topic : tp)
         {
            System.out.println("Topic details");
            System.out.println("names"+topic.getTopicArn().split(":")[5]);//names are spilted
            ListSubscriptionsByTopicResult results = client.listSubscriptionsByTopic(topic.getTopicArn());
            for(Subscription sub : results.getSubscriptions())
            {
                System.out.println("\tSubscription : [ "+sub.getProtocol()+" ] "+sub.getEndpoint());
            }
            if (topic.getTopicArn().split(":")[5].equals("my-latestest-news"))
         {
                PublishResult res = client.publish(new PublishRequest(topic.getTopicArn(), "Hello user"));
        }


        //   client.publish(new PublishRequest("arn:aws:sns:us-west-2:106129732153:my-latest-news", "Hello new user"));  
 
         // client.createTopic("hello");
        // }


    //     String topicName = "Flipkart";
    //     String protocol = "email";
    //     String endpoint = "bashettyruchitha@gmail.com";
    
    //       String topicArn = client.createTopic(new CreateTopicRequest(topicName)).getTopicArn();

    
    //     client.subscribe(new SubscribeRequest(topicArn, protocol, endpoint));
 
    //     System.out.println("Topic created and subscribed. TopicArn: " + topicArn);
    // }
    }


    CreateTopicResult r2= client.createTopic("hello");
    String topicArn=r2.getTopicArn();
    client.subscribe("email","ruchibashetty@gmail.com", topicArn);
    client.confirmSubscription(topicArn,topicArn);

}
}









    //create a topic ....
// AmazonSNS client= AmazonSNSClient.builder().withRegion("us-east-1").build();

    //   String topicName = "Flipkart";
    //     String protocol = "email";
    //     String endpoint = "bashettyruchitha@gmail.com";
    
    //       String topicArn = client.createTopic(new CreateTopicRequest(topicName)).getTopicArn();
    //     client.subscribe(new SubscribeRequest(topicArn, protocol, endpoint));
 
    //     System.out.println("Topic created and subscribed. TopicArn: " + topicArn);
    // or just we can create a topic 
    // by using a client.createTopic("kpitusers");


    // or AmazonSNS client = AmazonSNSClient.builder().withRegion("us-west-2").build();
 
        // create topic
        // CreateTopicResult result = client.createTopic("discount-offer-an98");
       
        // // add email subscriber
        // ListTopicsResult topics = client.listTopics();
        // Topic topic = null;
        // for (Topic t : topics.getTopics()) {
        //     if (t.getTopicArn().equals(result.getTopicArn())) {
        //         topic = t;
        //     }
        // }
       
        // SubscribeResult result2 =  client.subscribe(new SubscribeRequest(topic.getTopicArn(),"email", "nagarkarabhishek123@gmail.com"));
        // // send a message
 
        // client.publish(topic.getTopicArn(), "Subject", "Message");
    // }

