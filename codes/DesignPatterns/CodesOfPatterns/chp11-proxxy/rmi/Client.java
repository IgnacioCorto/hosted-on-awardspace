// import java.rmi.Naming;
import java.rmi.*;

public class Client {
	public static void main(String [] args) {
		try {
            RemoteInterface servicio 
                = (RemoteInterface) Naming.lookup(
                    "rmi://127.0.0.1/Hola_Remota");
                    
            System.out.println( "Imprimiendo el servicio" );
            System.out.println( servicio.diHola() );
            
		} catch (Exception ex) { 
		ex.printStackTrace();
		} 
	}
}
