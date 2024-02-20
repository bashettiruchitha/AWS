package com.bashettir;

import java.util.List;
import java.util.Scanner;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */public static void main(String[] args) {
        AmazonS3 s3= AmazonS3Client.builder().withCredentials(new ProfileCredentialsProvider()).build();

        
        // s3.listBuckets().forEach(b -> System.out.println(b.getName()));



        // list the buckets which present the aws
        List<Bucket> buckets=s3.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(bucket.getName());
            
        }
        Scanner sc=new Scanner(System.in);

        // creation of the bucket



        // s3.createBucket("myfiles879");
        // System.out.println("enter the message");
        // String line =sc.nextLine();
        // s3.putObject("myfiles96","message.txt",line);




        // deletion of the bucket 


        // System.out.println("enter the delete the buckets name");
        // String line2=sc.nextLine();
        // s3.deleteBucket(line2);
        // System.out.println("sucessfully delted"+line2);




        // s3.deleteObject("myfiles96", "message.txt");//just we can delete the file inside the bucket 
     
    }
}


