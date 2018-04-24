package minios;


import io.minio.errors.*;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class App
{
    public static void main( String[] args ) throws IOException, InvalidKeyException, NoSuchAlgorithmException, XmlPullParserException, InvalidArgumentException, ErrorResponseException, NoResponseException, InvalidBucketNameException, InsufficientDataException, InternalException, InvalidPortException, InvalidEndpointException, RegionConflictException {
        System.out.println("Hello World!");
        BucketHelper bh = new BucketHelper();
        objectCrud oc =new objectCrud();
        bh.createConnection();
//bh.createBucket();
//bh.listBucket();
//bh.deleteBucket();
//bh.listBucket();
//    bh.list_Objects_in_Bucket();
oc.createObject();
oc.readObject();
oc.deleteObject();
    }
}
