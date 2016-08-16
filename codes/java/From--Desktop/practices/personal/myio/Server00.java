import java.io.*;
import java.net.*;

class Server00 implements Serializable {
    
    String serverProperty;

    public static void main (String [] args) {
        new Server00().go();
    }

    void go() {
        try {

  /* *************** RESPONDER CON TEXTO ******************* */
            
            System.out.println("Esperando conexion");
            
            ServerSocket srvSckt = 
                new ServerSocket(5000);
            
            Socket srvListen = srvSckt.accept();
            
            PrintWriter sockOut = 
                new PrintWriter (
                    srvListen.getOutputStream()
                );
            
            sockOut.println("Esta es la respuesta");
            //sockOut.close();
            
            
  /* *************** RESPONDER CON OBJETO ******************* */

            //srvListen = srvSckt.accept();
            
            ObjectOutputStream out =
                new ObjectOutputStream (
                    srvListen.getOutputStream()
                );

            Server00 srvObj = new Server00();
            srvObj.serverProperty = "Serialized Object Data!!!";
            
            out.writeObject(srvObj);
            out.close();
  
                
        } catch (IOException ex) {
            ex.printStackTrace();
        } /* catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } */ finally {
           
            try {
            /* ESTA ES LA DESPEDIDA DEL PROGRAMA */
            System.out.print("\nPresiona <ENTER> para salir");
            String despedida = 
                new BufferedReader(
                    new InputStreamReader(
                        System.in 
                    )
                ).readLine();
            } catch (IOException ex) { 
                ex.printStackTrace();
            }

        }

    
    }
    
}