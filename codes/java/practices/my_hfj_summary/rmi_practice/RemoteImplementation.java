import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RemoteImplementation 
    extends UnicastRemoteObject implements RemoteInterface
{
    public RemoteImplementation() throws RemoteException {}
    public String dimeHola() {
        return "Te respondo con gusto: Hola Usuario!!!";
    }
    public static void main(String [] args) {
        try {
            RemoteInterface Srv = new RemoteImplementation();
            Naming.rebind("Hola_Remota",Srv);
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}