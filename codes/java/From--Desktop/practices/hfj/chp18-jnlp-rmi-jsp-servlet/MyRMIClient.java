import java.rmi.*;

class MyRMIClient {

    public static void main (String [] args) {
        new MyRMIClient();
    }
    
    MyRMIClient() {
        try {
            MyRemoteInterface myService = 
                    (MyRemoteInterface) Naming.lookup("rmi://127.0.0.1/Remote_HelloWorld");
            String msg = myService.getHelloWorld();
            System.out.println(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}