import java.rmi.*;

public interface MyRemoteInterface extends Remote {
    // The retun value *MUST* be Serializable
    public String getHelloWorld() throws RemoteException;
}