import java.io.*;
import java.net.*;

class Client00 implements Serializable {
    
    String clientProperty;

    public static void main (String [] args) {
        new Client00().go();
    }

    void go() {
        try {

  /* *************** ACCETAR TEXTO ******************* */
            
            Socket cliSckt = 
                new Socket("127.0.0.1", 5000);
            
            BufferedReader sockIn = 
                new BufferedReader (
                    new InputStreamReader (
                        cliSckt.getInputStream()
                    )
                );
            
            String lectura = sockIn.readLine();
            
            System.out.println("El mensaje del servidor es: "
                    + lectura);

            sockIn.close();
            
            
  /* *************** RESPONDER CON OBJETO ******************* */

            //cliSckt = new Socket("127.0.0.1", 5000);
  
            ObjectInputStream in =
                new ObjectInputStream (
                    cliSckt.getInputStream()
                );

            Server00 myObj = 
                (Server00) in.readObject();

            System.out.println( myObj.serverProperty );
            
            in.close();


  
                
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
           
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