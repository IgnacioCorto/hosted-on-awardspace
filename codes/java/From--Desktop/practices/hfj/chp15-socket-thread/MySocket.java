import java.io.*;
import java.net.*;

class MySocket {

    public static void main (String [] args) {
        MySocket obj = new MySocket();
        obj.executeProgram();
    }

    void mySleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (Exception ex) {}
    }
    
    /* The program starts here : */
    
    void executeProgram () {
        try {
        
            // Socket tsw = new Socket("127.0.0.1",65535);
            // PrintWriter w = new PrintWriter(tsw.getOutputStream());
            // w.println("a saying I would like you to recieve");
            // w.print("the continuation of my phrase");
        
            Socket ts = new Socket("127.0.0.1",65535);
            InputStreamReader s = new InputStreamReader(ts.getInputStream());
            BufferedReader r = new BufferedReader(s);
            String m = r.readLine();
            r.close();
            
            System.out.println("Esta es la lectura : \""+m+"\"");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}