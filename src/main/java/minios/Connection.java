package minios;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;


public abstract class Connection {
    MinioClient mc;

    public void  createConnection() throws InvalidPortException, InvalidEndpointException {
        mc = new MinioClient("http://192.168.100.56:9000","86703NZPN8AIXNBRN79D","x4UPAdWVPjnlIAUicYQvoE/Di19+Us0vp6znBsWP");
        if(mc!=null) System.out.println("Connection made Successfully");
        else System.out.print("there was some error in making connection");

    }

}
