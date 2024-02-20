package com.txt;

import java.util.List;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.Topic;

public class sns {
    public static void main(String[] args) {
        AmazonSNS  sns=AmazonSNSClient.builder().withRegion("eu-west-1").build();


        // creation of the topic
        // sns.createTopic("ruchitha");
        // System.out.println("succuessfully created topic");


        //  sub
        // CreateTopicResult t=sns.createTopic("ruchitha123");
        // String name = t.getTopicArn();
        // sns.subscribe(name, "email", "bashettyruchitha@gmail.com");

        



        // // list the topics 
        ListTopicsResult rs=sns.listTopics();
        List<Topic> tp=rs.getTopics();
        for (Topic topic :tp ) {
            System.out.println("Topic details");
            System.out.println("names : "+  topic.getTopicArn().split(":")[5]);
            ListSubscriptionsByTopicResult listSubscriptionsByTopicResult=sns.listSubscriptionsByTopic(topic.getTopicArn());

            List<Subscription> sub=listSubscriptionsByTopicResult.getSubscriptions();
            for (Subscription subscription : sub) {
            System.out.println("sub are"+subscription.getEndpoint());
                
            }

            
            
        }


        

        
    }
    }
