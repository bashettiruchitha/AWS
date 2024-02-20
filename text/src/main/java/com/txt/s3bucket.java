package com.txt;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

public class s3bucket {
    public static void main(String[] args) {

        // create the s3 bucket 
        
        AmazonS3 s3=AmazonS3Client.builder().withRegion("eu-west-1").build();
        // s3.createBucket("chitra1233");


        // list the buckets

    //     List<Bucket> bucket=s3.listBuckets();
    //    for (Bucket b : bucket) {
    //     System.out.println(b.getName());


        // upload the file 

        // s3.putObject("chitra1233", "jan.txt", "helloo");

        // download a file 
        String  c1=s3.getObjectAsString("chitra1233", "jan.txt");
        try {
            FileWriter out= new FileWriter(new File("c:\\file\\jan.txt"));
            out.write(c1);
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        // }
        
        


        
        
       }

        
    }
    

