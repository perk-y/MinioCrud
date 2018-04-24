package minios;

import io.minio.errors.*;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class objectCrud extends Connection{
    public String bucket_name;
    public String Object_name;
    public void createObject() throws IOException, XmlPullParserException, InsufficientDataException, NoSuchAlgorithmException, NoResponseException, InternalException, InvalidKeyException, InvalidBucketNameException, ErrorResponseException, InvalidArgumentException {
         Scanner in = new Scanner(System.in);
        System.out.print("enter the name of bucket you wanna add object to ");
        bucket_name = in.nextLine();
        boolean b = mc.bucketExists(bucket_name);
        if (b) {
            mc.putObject(bucket_name, "captive.png", "/home/datreon/Pictures/captive.jpg");
            System.out.println("captive.png is uploaded successfully");
        }
    }




    public void readObject() throws IOException, XmlPullParserException, InsufficientDataException, NoSuchAlgorithmException, NoResponseException, InternalException, InvalidKeyException, InvalidBucketNameException, ErrorResponseException, InvalidArgumentException {
        Scanner in = new Scanner(System.in);
        System.out.print("enter the name of bucket");
        bucket_name = in.nextLine();
        System.out.print("enter the name of object you wanna read ");
        Object_name = in.nextLine();
        boolean b = mc.bucketExists(bucket_name);
            mc.statObject(bucket_name, Object_name);

         InputStream stream = mc.getObject(bucket_name, Object_name);
            byte[] buf = new byte[16384];
            int bytesRead;
            while ((bytesRead = stream.read(buf, 0, buf.length)) >= 0) {
                System.out.println(new String(buf, 0, bytesRead));
            }
            stream.close();


    }
    public void deleteObject() throws IOException, XmlPullParserException, InsufficientDataException, NoSuchAlgorithmException, NoResponseException, InternalException, InvalidKeyException, InvalidBucketNameException, ErrorResponseException, InvalidArgumentException {
        Scanner s = new Scanner(System.in);
        System.out.print("enter the name of bucket");
        bucket_name = s.nextLine();
        System.out.print("enter the name of object you wanna delete ");
        Object_name = s.nextLine();
        mc.statObject(bucket_name, Object_name);
mc.removeObject(bucket_name,Object_name);
        System.out.println("Bucket removed successfully");
    }

}
