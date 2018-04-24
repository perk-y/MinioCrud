package minios;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.SourceTree;
import io.minio.Result;
import io.minio.errors.ClientException;
import io.minio.messages.Bucket;
import io.minio.messages.Item;

import javax.sound.midi.Soundbank;

public class BucketHelper extends Connection {
    public void createBucket() throws IOException, ClientException {
        String bucketname;
        Scanner input = new Scanner(System.in);
        System.out.print("enter the name of bucket you wanna create");
        bucketname = input.nextLine();
        boolean b = mc.bucketExists(bucketname);
        if (b == true) System.out.println("bucket already exists");
        else {
            mc.makeBucket(bucketname);
            System.out.println("bucket created successfully");
        }

    }

    public void deleteBucket() throws IOException, ClientException {
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

    public void listBucket() throws IOException, ClientException {
        Iterator<Bucket> ls = mc.listBuckets();
        System.out.println("Listing Bucket names ");
        while (ls.hasNext())
            System.out.println(ls.next().getName());

    }

    public void list_Objects_in_Bucket() throws IOException, ClientException {
        String buckets;
        Scanner input3 = new Scanner(System.in);
        System.out.print("enter the name of bucket you wanna list objects ");
        buckets = input3.nextLine();
        boolean b = mc.bucketExists(buckets);
        if (b == true) {
            Iterator<Result<Item>> myobjects = mc.listObjects(buckets);
            for (Iterator<Result<Item>> it = myobjects; it.hasNext(); ) {
                Result<Item> result = it.next();
                Item items = result.getResult();
                System.out.println(items.getKey()+ ", " + items.size() + ", " + items.getLastModified());
            }

        }




}}
