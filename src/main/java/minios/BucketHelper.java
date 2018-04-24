package minios;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public class BucketHelper extends Connection {
    public void createBucket() throws IOException, XmlPullParserException, InsufficientDataException, NoSuchAlgorithmException, NoResponseException, InternalException, InvalidKeyException, InvalidBucketNameException, ErrorResponseException, RegionConflictException {
        String bucketname;
        Scanner input = new Scanner(System.in);
        System.out.println("enter the name of bucket you wanna create");
        bucketname = input.nextLine();
        boolean b = mc.bucketExists(bucketname);
        if (b == true) System.out.println("bucket already exists");
        else {
            mc.makeBucket(bucketname);
            System.out.println("bucket created successfully");
        }

    }

    public void deleteBucket() throws IOException, XmlPullParserException, InsufficientDataException, NoSuchAlgorithmException, NoResponseException, InternalException, InvalidKeyException, InvalidBucketNameException, ErrorResponseException {
        String bucket;
        Scanner input1 = new Scanner(System.in);
        System.out.print("enter the name of bucket you wanna delete");
        bucket = input1.nextLine();
        boolean b = mc.bucketExists(bucket);
        if (b == false) System.out.println("bucket doesn't exists");
        else {
            mc.removeBucket(bucket);
            System.out.println("bucket deleted successfully");

        }
    }

    public void listBucket() throws IOException, XmlPullParserException, InsufficientDataException, NoSuchAlgorithmException, NoResponseException, InternalException, InvalidKeyException, InvalidBucketNameException, ErrorResponseException {
       List<Bucket> ls = mc.listBuckets();
        System.out.println("Listing Bucket names ");
      for(Bucket b:ls){
          System.out.println(b.name()+b.creationDate());
      }
    }

    public void list_Objects_in_Bucket() throws IOException, XmlPullParserException, InsufficientDataException, NoSuchAlgorithmException, NoResponseException, InternalException, InvalidKeyException, InvalidBucketNameException, ErrorResponseException {
        String buckets;
        Scanner input3 = new Scanner(System.in);
        System.out.print("enter the name of bucket you wanna list objects ");
        buckets = input3.nextLine();



            boolean found = mc.bucketExists(buckets);
            if (found) {

                Iterable<Result<Item>> myObjects = mc.listObjects(buckets);
                for (Result<Item> result : myObjects) {
                    Item item = result.get();
                    System.out.println(item.lastModified() + ", " + item.size() + ", " + item.objectName());
                }
            } else {
                System.out.println("bucket does not exist");
            }



}}
