package minios;


import io.minio.errors.ClientException;

import java.io.IOException;
import java.net.MalformedURLException;

public class App
{
    public static void main( String[] args ) throws IOException, ClientException {
        System.out.println("Hello World!");
        BucketHelper bh = new BucketHelper();
        bh.createConnection();
bh.createBucket();
bh.listBucket();
bh.deleteBucket();
bh.listBucket();
    bh.list_Objects_in_Bucket();

    }
}
