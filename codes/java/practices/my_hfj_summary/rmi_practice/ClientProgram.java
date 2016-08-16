import java.rmi.Naming;

public class ClientProgram {
    public static void main (String [] args) {
        try {
            RemoteInterface Srv = (RemoteInterface) Naming.lookup
                ("rmi://localhost/Hola_Remota");
            String msg = Srv.dimeHola();
            System.out.println(msg);
        } catch (Exception e) { e.printStackTrace(); }
    }
}