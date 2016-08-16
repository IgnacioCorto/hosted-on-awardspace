import java.rmi.RemoteException;
import java.rmi.Remote;

interface EnvioUI extends Remote {
    ObjEjemplo getObjeto() throws RemoteException;
}
