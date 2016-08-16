import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImplementation extends UnicastRemoteObject implements MyRemoteInterface {
    
    public String getHelloWorld() {
        return "The Server says: Hello World!!!";
    }

    public MyRemoteImplementation() throws RemoteException { }

    public static void main ( String [] args ) {
        try {
            MyRemoteInterface myService = new MyRemoteImplementation();
            Naming.rebind("Remote_HelloWorld", myService);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}