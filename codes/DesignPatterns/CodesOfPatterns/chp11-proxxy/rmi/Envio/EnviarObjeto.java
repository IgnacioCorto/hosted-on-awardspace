import java.rmi.Naming;

class EnviarObjeto {
    public static void main ( String [] args ) {
        try {
            EnvioUI serv = (EnvioUI)
                Naming.lookup("rmi://127.0.0.1/Envio");
            ObjEjemplo oe = serv.getObjeto();
            oe.getDatos();
        } catch (Exception ex) { 
            ex.printStackTrace();
        } 
    }
}